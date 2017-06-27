package mz.com.nova.controler;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import mz.com.nova.dao.CidadeDAO;
import mz.com.nova.dao.EstadoDAO;
import mz.com.nova.modell.Cidade;
import mz.com.nova.modell.Estado;
@ManagedBean
@ViewScoped
public class CidadeController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9078084937854336786L;
	
	private Cidade cidade;
	private List<Cidade> cidades;
	private List<Estado> estados;
	public Cidade getCidade() {
		return cidade;
	}
	public List<Estado> getEstados() {
		return estados;
	}
	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	public List<Cidade> getCidades() {
		return cidades;
	}
	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}
	@PostConstruct
	public void listar(){
		try {
			CidadeDAO cidadeDao = new CidadeDAO(Cidade.class);
			cidades = cidadeDao.listar();
		} catch (RuntimeException e) {
			Messages.addGlobalInfo("Ocorreu um erro ao tentar listar cidades");
		}
		
	}
	public void novo(){
		cidade = new Cidade();
		try {
		EstadoDAO estaDao = new EstadoDAO(Estado.class);
		estados = estaDao.listar();
		} catch (RuntimeException e) {
			Messages.addGlobalError("Ocorreu um erro ao tentar carregar os Estados");
			e.printStackTrace();
		}
	}
	public void salvar(){
		try {
			CidadeDAO cidadeDao = new CidadeDAO(Cidade.class);
			cidadeDao.merge(cidade);
			
			novo();
			cidades = cidadeDao.listar();
			
			Messages.addGlobalInfo("Cidade salva com sucesso!!!");
		} catch (RuntimeException e) {
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar uma cidade");
		}
		
	}

	public void excluir(ActionEvent evento){
		
		try {
			cidade = (Cidade) evento.getComponent().getAttributes().get("cidadeSelecionada");
			CidadeDAO cidadeDao = new CidadeDAO(Cidade.class);
			cidadeDao.excluir(cidade);
			Messages.addGlobalInfo("Cidade excluida com sucesso!!!");
			novo();
			cidades = cidadeDao.listar();
		} catch (RuntimeException e) {
			Messages.addGlobalError("Ocorreu um erro ao tentar excluir a cidade");
		}
	}
	public void editar(ActionEvent evento){
			
			try {
				cidade = (Cidade) evento.getComponent().getAttributes().get("cidadeSelecionada");
				EstadoDAO estaDao = new EstadoDAO(Estado.class);
				estados = estaDao.listar();
				
				Messages.addGlobalInfo("Cidade salva com sucesso!!!");
			} catch (RuntimeException e) {
				Messages.addGlobalError("Ocorreu um erro ao tentar salvar uma cidade");
			}
			
	}
}
