package mz.com.nova.controler;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import mz.com.nova.dao.CidadeDAO;
import mz.com.nova.dao.EstadoDAO;
import mz.com.nova.dao.PessoaDAO;
import mz.com.nova.modell.Cidade;
import mz.com.nova.modell.Estado;
import mz.com.nova.modell.Pessoa;

@ViewScoped
@ManagedBean
public class PessoaController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4964282616924525683L;

	private List<Pessoa> pessoas;
	private Pessoa pessoa;
	private List<Cidade> cidades;
	private Estado estado;
	private List<Estado> estados;

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public List<Cidade> getCidades() {
		return cidades;
	}

	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public List<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

	public List<Estado> getEstados() {
		return estados;
	}

	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}

	public void novo() {
		pessoa = new Pessoa();
		try {
			EstadoDAO estadoDao = new EstadoDAO(Estado.class);
			CidadeDAO cidadeDao = new CidadeDAO(Cidade.class);
			estados = estadoDao.listar();
			estado = new Estado();
			cidades = new ArrayList<Cidade>();
		} catch (RuntimeException e) {
			Messages.addGlobalError("Ocorreu um error ao tentar listar Pessoa");
			e.printStackTrace();
		}
	}

	@PostConstruct
	public void listar() {
		try {
			PessoaDAO pessoaDao = new PessoaDAO(Pessoa.class);
			pessoas = pessoaDao.listar();
		} catch (RuntimeException e) {
			Messages.addGlobalError("Ocorreu um error ao tentar listar Pessoa");
			e.printStackTrace();
		}

	}

	public void salvar() {
		try {
			PessoaDAO pessoaDao = new PessoaDAO(Pessoa.class);
			pessoaDao.merge(pessoa);
			
			pessoas = pessoaDao.listar();
			novo();
			Messages.addGlobalInfo("Pessoa salva com sucesso!!!");
		} catch (RuntimeException e) {
			Messages.addGlobalError("Ocorreu um error ao tentar salvar uma Pessoa***");
			e.printStackTrace();
		}
		
	}

	public void excluir(ActionEvent evento) {
		try {
			PessoaDAO pessoaDao = new PessoaDAO(Pessoa.class);
			pessoa = (Pessoa) evento.getComponent().getAttributes().get("pessoaSelecionada");
			pessoaDao.excluir(pessoa);
			pessoas = pessoaDao.listar();

			Messages.addGlobalInfo("Pessoa excluida com sucesso");

		} catch (RuntimeException e) {
			Messages.addGlobalError("Ocorreu um error ao tentar excluir uma pessoa");
			e.printStackTrace();
		}

	}

	public void editar(ActionEvent evento) {
		try {
			pessoa = (Pessoa) evento.getComponent().getAttributes().get("pessoaSelecionada");
			
			estado = pessoa.getCidade().getEstado();
			
			EstadoDAO estadoDao = new EstadoDAO(Estado.class);
			estados = estadoDao.listar();
			
			CidadeDAO cidadeDao = new CidadeDAO(Cidade.class);
			cidades = cidadeDao.buscarCidades(estado.getId());

		} catch (RuntimeException e) {
			Messages.addGlobalError("Ocorreu um error ao listar as cidades***");
		}

	}

	public void popular() {
		try {
			if (estado != null) {
				CidadeDAO cidadeDao = new CidadeDAO(Cidade.class);
				cidades = cidadeDao.buscarCidades(estado.getId());
			}else{
				cidades = new ArrayList<Cidade>();
			}
		} catch (RuntimeException e) {
			Messages.addGlobalError("Ocorreu um error ao listar as cidades***");
		}
	}
}
