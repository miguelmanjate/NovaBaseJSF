package mz.com.nova.controler;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import mz.com.nova.dao.CidadeDAO;
import mz.com.nova.dao.FuncionarioDAO;
import mz.com.nova.dao.PessoaDAO;
import mz.com.nova.modell.Cidade;
import mz.com.nova.modell.Funcionario;
import mz.com.nova.modell.Pessoa;

@ManagedBean
@ViewScoped
public class FuncionarioController implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7583911643410074073L;
	
	private List<Pessoa> pessoas;
	private Funcionario funcionario;
	private List<Funcionario> funcionarios;
	
	public List<Pessoa> getPessoas() {
		return pessoas;
	}
	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}
	public Funcionario getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}
	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}
	@PostConstruct
	public void listar(){
		try {
			FuncionarioDAO funcionarioDao = new FuncionarioDAO(Funcionario.class);
			funcionarios = funcionarioDao.listar();
		} catch (RuntimeException e) {
			Messages.addGlobalInfo("Ocorreu um erro ao tentar listar funcionarios");
			e.getMessage();
		}
	}
	public void novo(){
		try{
			funcionario = new Funcionario();
			PessoaDAO pessoaDao = new PessoaDAO(Pessoa.class);
			pessoas = pessoaDao.listar();
			
		}catch (RuntimeException e) {
			Messages.addGlobalInfo("Ocorreu um erro ao tentar listar pessoas");
			e.getMessage();
		}
	}
	public void salvar(){
		try{
			FuncionarioDAO funcionarioDao = new FuncionarioDAO(Funcionario.class);
			funcionarioDao.merge(funcionario);
			funcionarios = funcionarioDao.listar();
			novo();
			
			Messages.addGlobalInfo("Funcionario salvo com sucesso");
			
		}catch (RuntimeException e) {
			Messages.addGlobalInfo("Ocorreu um erro ao tentar salvar o Funcionario");
			e.getMessage();
		}
	}
	public void excluir(ActionEvent evento){
		try{
			funcionario = (Funcionario) evento.getComponent().getAttributes().get("funcionarioSelecionada");
			FuncionarioDAO funcionarioDao = new FuncionarioDAO(Funcionario.class);
			funcionarioDao.excluir(funcionario);
			funcionarios = funcionarioDao.listar();
			
			Messages.addGlobalInfo("Funcionario excluido com sucesso");
		}catch (RuntimeException e) {
			Messages.addGlobalError("Ocorreu um erro ao tentar excluir o Funcionario");
			e.getMessage();
		}
	}
	public void editar(ActionEvent evento){
		try{
		funcionario = (Funcionario) evento.getComponent().getAttributes().get("funcionarioSelecionada");
		PessoaDAO pessoaDao = new PessoaDAO(Pessoa.class);
		pessoas = pessoaDao.listar();
		
		}catch (RuntimeException e) {
			Messages.addGlobalError("Ocorreu um erro ao tentar listar Pessoas");
			e.getMessage();
		}
	}
}
