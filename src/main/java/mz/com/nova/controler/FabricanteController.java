package mz.com.nova.controler;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import mz.com.nova.dao.FabricanteDAO;
import mz.com.nova.modell.Fabricante;

@ManagedBean
@ViewScoped
public class FabricanteController implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2044784478627866388L;
	
	private Fabricante fabricante;
	private List<Fabricante> fabricantes;
	
	public Fabricante getFabricante() {
		return fabricante;
	}
	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}
	public List<Fabricante> getFabricantes() {
		return fabricantes;
	}
	public void setFabricantes(List<Fabricante> fabricantes) {
		this.fabricantes = fabricantes;
	}
	@PostConstruct
	public void listar(){
		try {
			FabricanteDAO fabricanteDao = new FabricanteDAO(Fabricante.class);
			fabricantes = fabricanteDao.listar();
			
		} catch (RuntimeException e) {
		Messages.addGlobalError("Ocorreu um error ao tentar carregar os funcionarios");
		e.printStackTrace();
		}
	}
	public void novo(){
		fabricante = new Fabricante();
	}
	public void salvar(){
		try {
			FabricanteDAO fabricanteDao = new FabricanteDAO(Fabricante.class);
			fabricanteDao.merge(fabricante);
			novo();
			fabricantes = fabricanteDao.listar();
			Messages.addGlobalInfo("Fabricante salvo com sucesso!!");
			
		} catch (RuntimeException e) {
			Messages.addGlobalError("Ocorreu um error ao tentar salvar o fabricante");
			e.printStackTrace();
		}
		
	}

	public void excluir(ActionEvent evento){
		try {
			Fabricante fabricante = (Fabricante) evento.getComponent().getAttributes().get("fabricanteSelecionado");
			FabricanteDAO fabricanteDao = new FabricanteDAO(Fabricante.class);
			fabricanteDao.excluir(fabricante);
			
			fabricantes = fabricanteDao.listar();
			Messages.addGlobalInfo("Fabricante removido com sucesso!!");
		} catch (RuntimeException e) {
			Messages.addGlobalError("Ocorreu um erro ao tentar remover a fabrica!!");
			e.printStackTrace();
		}
	
	}
	public void editar(ActionEvent evento){
		fabricante = (Fabricante) evento.getComponent().getAttributes().get("fabricanteSelecionado");
	}
}
