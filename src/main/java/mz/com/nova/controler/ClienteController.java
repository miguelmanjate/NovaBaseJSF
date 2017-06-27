package mz.com.nova.controler;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import mz.com.nova.dao.ClienteDAO;
import mz.com.nova.dao.PessoaDAO;
import mz.com.nova.modell.Cliente;
import mz.com.nova.modell.Pessoa;

@ViewScoped
@ManagedBean
public class ClienteController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7094646035276477802L;

	private List<Cliente> clientes;
	private Cliente cliente;
	private List<Pessoa> pessoas;
	
	public List<Pessoa> getPessoas() {
		return pessoas;
	}
	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
		
	}

	@PostConstruct
	public void listar() {
		try {
			ClienteDAO clienteDao = new ClienteDAO(Cliente.class);
			clientes = clienteDao.listar();
		} catch (RuntimeException e) {
			Messages.addGlobalError("Ocorreu um error ao tentar carregar Clintes");
		}
	}

	public void novo() {
		try {
		cliente = new Cliente();
		PessoaDAO pessoaDao = new PessoaDAO(Pessoa.class);
		pessoas = pessoaDao.listar();
		} catch (RuntimeException e) {
			Messages.addGlobalError("Ocorreu um error ao tentar listar pessoas");
		}
	}
	public void salvar(){
		try {
			ClienteDAO clienteDao = new ClienteDAO(Cliente.class);
			clienteDao.merge(cliente);
	
			cliente = new Cliente();
			clientes = clienteDao.listar();
			PessoaDAO pessoaDao = new PessoaDAO(Pessoa.class);
			pessoas = pessoaDao.listar();
			Messages.addGlobalInfo("Cliente salvo com sucesso!!!");
		} catch (RuntimeException e) {
			Messages.addGlobalError("Ocorreu um error ao tentar carregar Clintes");
			e.printStackTrace();
		}
	}
	public void excluir(ActionEvent evento){
		try{
			cliente = (Cliente) evento.getComponent().getAttributes().get("clienteSelecionada");
			ClienteDAO clienteDao = new ClienteDAO(Cliente.class);
			clienteDao.excluir(cliente);
			clientes = clienteDao.listar();
			novo();
			Messages.addGlobalInfo("Cliente excluido com sucesso");
			
		} catch (RuntimeException e) {
			Messages.addGlobalError("Ocorreu um error ao tentar excluir um Cliente***");
			e.printStackTrace();
		}
	}
	public void editar(ActionEvent evento){
		try{
			cliente = (Cliente) evento.getComponent().getAttributes().get("clienteSelecionada");
			PessoaDAO pessoaDao = new PessoaDAO(Pessoa.class);
			pessoas = pessoaDao.listar();
			
		} catch (RuntimeException e) {
			Messages.addGlobalError("Ocorreu um error ao tentar editar um Cliente***");
			e.printStackTrace();
		}
	}
}
