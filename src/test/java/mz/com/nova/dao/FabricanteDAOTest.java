package mz.com.nova.dao;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import mz.com.nova.modell.Fabricante;

public class FabricanteDAOTest {
	
	@Test
	@Ignore
	public void salvar(){
		FabricanteDAO fabricanteDao = new FabricanteDAO(Fabricante.class);
		
		Fabricante fabricante = new Fabricante();
		fabricante.setDescricao("Russia");
		fabricanteDao.salvar(fabricante);
	}
	@Test
	@Ignore
	public void listar(){
		FabricanteDAO fabricanteDao = new FabricanteDAO(Fabricante.class);
		
		List<Fabricante> fabricantes = fabricanteDao.listar();
		
		System.out.println("Total de fabricantes eh= "+fabricantes.size());
		
		for(Fabricante fabricante : fabricantes){
			System.out.println(fabricante.getDescricao());
		}
	}
	@Test
	@Ignore
	public void buscar(){
		FabricanteDAO fabricanteDao = new FabricanteDAO(Fabricante.class);
		
		Fabricante fabricante = fabricanteDao.buscar(4l);
		System.out.println(fabricante.getDescricao());
	}
	@Test
	@Ignore
	public void excluir(){
		FabricanteDAO fabricanteDao = new FabricanteDAO(Fabricante.class);
		Fabricante fabricante = fabricanteDao.buscar(2l);
		
		fabricanteDao.excluir(fabricante);
	}
	@Test
	@Ignore
	public void editar(){
		FabricanteDAO fabricanteDao = new FabricanteDAO(Fabricante.class);
		Fabricante fabricante = fabricanteDao.buscar(4l);
		
		fabricante.setDescricao("Germany");
		fabricanteDao.editar(fabricante);
	}
	@Test
	public void merge(){
		FabricanteDAO fabricanteDao = new FabricanteDAO(Fabricante.class);
		
//		Fabricante fabricante = new Fabricante();
//		fabricante.setDescricao("Japao ");
//		fabricanteDao.merge(fabricante);
		
		Fabricante fabricante = fabricanteDao.buscar(7l);
		fabricante.setDescricao("Tailandia");
		fabricanteDao.merge(fabricante);
	}
}
