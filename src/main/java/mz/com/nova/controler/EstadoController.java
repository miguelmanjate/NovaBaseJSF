package mz.com.nova.controler;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import mz.com.nova.dao.EstadoDAO;
import mz.com.nova.modell.Estado;

@ManagedBean
@ViewScoped
public class EstadoController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8996150183142149852L;

	private Estado estado;
	private List<Estado> estados;

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public List<Estado> getEstados() {
		return estados;
	}

	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}

	@PostConstruct
	public void listar() {
		try {
			EstadoDAO estadoDao = new EstadoDAO(Estado.class);
			estados = estadoDao.listar();
		} catch (RuntimeException e) {
			Messages.addGlobalError("Oucorreu um error ao tentar carregar os estados");
			e.printStackTrace();
		}
	}

	public void novo() {
		estado = new Estado();
	}

	public void salvar() {

		try {

			EstadoDAO estadoDao = new EstadoDAO(Estado.class);
			estadoDao.merge(estado);
			novo();
			estados = estadoDao.listar();
			Messages.addGlobalInfo("Estado salvo com sucesso!!!");

		} catch (RuntimeException e) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar salvar um estado");
			e.printStackTrace();
		}
	}

	public void excluir(ActionEvent evento) {
		try {
			estado = (Estado) evento.getComponent().getAttributes().get("estadoSelecionado");
			EstadoDAO estadoDao = new EstadoDAO(Estado.class);
			estadoDao.excluir(estado);
			estados = estadoDao.listar();
			Messages.addGlobalInfo("Estado removido com sucesso!");
		} catch (RuntimeException e) {
			Messages.addGlobalError("Ocorreu um erro ao tentar remover o Estado");
			e.printStackTrace();
		}
	}
	public void editar(ActionEvent evento){
		estado = (Estado) evento.getComponent().getAttributes().get("estadoSelecionado");
	}
}
