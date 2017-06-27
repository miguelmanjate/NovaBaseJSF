package mz.com.nova.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import mz.com.nova.util.HibernateUtil;

public class GenericDAO<T> implements GenericD<T> {
	private Class<T> classe;
	
	public GenericDAO(Class classe) {
		this.classe = classe;
	}
	public void salvar(T t){
		Session sessao = HibernateUtil.getFabricaDesessoes().openSession();
		Transaction transacao = null;
		
		try {
			//estamos a iniciar uma transacao para haver a sincronisacao
			transacao = sessao.beginTransaction();
			sessao.save(t);
			//estamos a confirmar uma transacao e finalisa-la
			transacao.commit();
		} catch (RuntimeException e) {
			/*
			 * qualquer coisa que acontecer antes de confirmarmos e finalisarmos 
			 * uma transacao este catch, vai pegar essa transacao perdida e desfase-la
			 * com o metodo rallback(), evitando uma transacao aberta que nao foi feichada
			 */
			
			//Aque estamos a perguntar se a transacao foi aberta, se for deferente de null 
			// eh porque foi aberta, entao temos que desfazer tudo com o rollbacck()
			if(transacao != null){
				// atransacao deicha de ser nulla apartir da linha 16, isto eh se pasar 
				//com sucesso essa linha
				transacao.rollback();
			}
			//anucia a exception
			throw e;
		}finally {
			sessao.close();
		}
	}
	
	public List<T> listar(){
		
	Session sessao = HibernateUtil.getFabricaDesessoes().openSession();
	try {
		/*
		 * Existem 4 formas atualmente de fazer consultas
		 * 1-SQL nativo
		 * 2-HQL (que eh como se fosse sql do Hibernate)
		 * 3-NameDeQuery (que eh a evuluicao do HQL)
		 * 4-Criteria (que eh a forma mais atual)
		 */
		Criteria consulta = sessao.createCriteria(classe);
		List<T> resultado = consulta.list();
		return resultado;
	} catch (RuntimeException e) {
		throw e;
	}finally {
		sessao.close();
	}
	}
	
	public T buscar(Long id){
		
	Session sessao = HibernateUtil.getFabricaDesessoes().openSession();
	try {
		
		Criteria consulta = sessao.createCriteria(classe);
		consulta.add(Restrictions.idEq(id));
		T resultado =(T) consulta.uniqueResult();
		return resultado;
	} catch (RuntimeException e) {
		throw e;
	}finally {
		sessao.close();
	}
	}
	
	public void excluir(T t){
		Session sessao = HibernateUtil.getFabricaDesessoes().openSession();
		Transaction transacao = null;
		
		try {
			transacao = sessao.beginTransaction();
			sessao.delete(t);
			transacao.commit();
		} catch (RuntimeException e) {
			if(transacao != null){
				transacao.rollback();
			}
			throw e;
		}finally {
			sessao.close();
		}
	}
	public void editar(T t){
		Session sessao = HibernateUtil.getFabricaDesessoes().openSession();
		Transaction transacao = null;
		
		try {
			transacao = sessao.beginTransaction();
			sessao.update(t);
			transacao.commit();
		} catch (RuntimeException e) {
			if(transacao != null){
				transacao.rollback();
			}
			throw e;
		}finally {
			sessao.close();
		}
	}
	public void merge(T t){
		Session sessao = HibernateUtil.getFabricaDesessoes().openSession();
		Transaction transacao = null;
		
		try {
			transacao = sessao.beginTransaction();
			sessao.merge(t);
			transacao.commit();
		} catch (RuntimeException e) {
			if(transacao != null){
				transacao.rollback();
			}
			throw e;
		}finally {
			sessao.close();
		}
	}
}
