package mz.com.nova.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import mz.com.nova.modell.Estado;

public class EstadoDAOTest {
	@Test
	@Ignore
	public void salvar(){
		Estado estado = new Estado();
		
		estado.setNome("Gaza");
		estado.setSigla("GZ");
		
		EstadoDAO estadoDAO = new EstadoDAO(Estado.class);
		estadoDAO.salvar(estado);
	}
	@Ignore
	@Test
	public void listar(){
		EstadoDAO estadoDAO = new EstadoDAO(Estado.class);
		List<Estado> resultado = estadoDAO.listar();
		
		System.out.println("total de registos encontardos: "+resultado.size());
		for(Estado estado : resultado){
			System.out.println(estado.getNome()+" -- "+estado.getSigla());
		}
		
	}
	@Ignore
	@Test
	public void buscar(){
		Long id = 3l;
		EstadoDAO estadoDAO = new EstadoDAO(Estado.class);
		Estado estado = estadoDAO.buscar(id);
		
		System.out.println(estado.getNome()+" -- "+estado.getSigla());
	}
	@Ignore
	@Test
	public void excluir(){
		Long id = 9l;
		EstadoDAO estadoDAO = new EstadoDAO(Estado.class);
		Estado estado = estadoDAO.buscar(id);
		
		if(estado == null){
		System.out.println("Nenhum registro encontrado");
		}else{
			estadoDAO.excluir(estado);
			System.out.println("Registro removido");
		}
	}
	@Test
	@Ignore
	public void editar(){
		Long id = 6l;
		EstadoDAO estadoDAO = new EstadoDAO(Estado.class);
		Estado estado = estadoDAO.buscar(id);
		
		estado.setNome("Inhambane");
		estado.setSigla("IN");
		estadoDAO.editar(estado);
		
	}
}
