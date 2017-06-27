package mz.com.nova.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import mz.com.nova.modell.Cidade;
import mz.com.nova.modell.Estado;

public class CidadeDAOTest {
	
	@Test
	@Ignore
	public void salvar(){
		EstadoDAO estadoDao = new EstadoDAO(Estado.class);
		Estado estado = estadoDao.buscar(6l);
		
		Cidade cidade = new Cidade();
		cidade.setNome("Inhambane ceu");
		cidade.setEstado(estado);
		
		CidadeDAO cidadeDao = new CidadeDAO(Cidade.class);
		cidadeDao.salvar(cidade);
	}
	@Ignore
	@Test
	public void listar(){
		CidadeDAO cidadeDao = new CidadeDAO(Cidade.class);
		
		List<Cidade> cidades = cidadeDao.listar();
		for(Cidade cidade : cidades){
			System.out.println(cidade.getNome()+" - - "+cidade.getEstado().getNome());
		}
	}
	@Test
	@Ignore
	public void buscar(){
		CidadeDAO cidadeDao = new CidadeDAO(Cidade.class);
		Cidade cidade = cidadeDao.buscar(1l);
		System.out.println(cidade.getNome()+" - - "+cidade.getEstado().getNome());
	}
	@Test
	@Ignore
	public void excluir(){
		CidadeDAO cidadeDao = new CidadeDAO(Cidade.class);
		Cidade cidade = cidadeDao.buscar(6l);
		
		cidadeDao.excluir(cidade);
	}
	@Test
	@Ignore
	public void editar(){
		CidadeDAO cidadeDao = new CidadeDAO(Cidade.class);
		Cidade cidade = cidadeDao.buscar(2l);
		
		cidade.setNome("Mucimbua da Braia");
		cidadeDao.editar(cidade);
	}
	@Test
	public void buscarCidades(){
		CidadeDAO cidadeDao = new CidadeDAO(Cidade.class);
		List<Cidade> cidades = cidadeDao.buscarCidades(2l);
		
		for(Cidade c : cidades){
			System.out.println(c.getNome());
		}
	}
}
