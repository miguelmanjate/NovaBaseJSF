package mz.com.nova.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import mz.com.nova.modell.Cidade;
import mz.com.nova.util.HibernateUtil;

public class CidadeDAO extends GenericDAO<Cidade>{

	public CidadeDAO(Class classe){
		super(classe);
	}
	
	public List<Cidade> buscarCidades(Long id_estado){
		
		Session sessao = HibernateUtil.getFabricaDesessoes().openSession();
		try {
			Criteria consulta = sessao.createCriteria(Cidade.class);
			consulta.add(Restrictions.eq("estado.id", id_estado));
			consulta.addOrder(Order.asc("nome"));
			List<Cidade> resultado = consulta.list();
			return resultado;
		} catch (RuntimeException e) {
			throw e;
		}finally {
			sessao.close();
		}
	}
}
