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
import mz.com.nova.dao.UsuarioDAO;
import mz.com.nova.modell.Cliente;
import mz.com.nova.modell.Pessoa;
import mz.com.nova.modell.Usuario;

@ManagedBean
@ViewScoped
public class UsuarioController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1380295136148811344L;
	private List<Usuario> usuarios;
	private Usuario usuario;
	private List<Pessoa> pessoas;
	
	public List<Usuario> getUsuarios() {
		return usuarios;
	}
	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public List<Pessoa> getPessoas() {
		return pessoas;
	}
	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}
	@PostConstruct
	public void listar(){
		try {
			UsuarioDAO usuarioDao = new UsuarioDAO(Usuario.class);
			usuarios = usuarioDao.listar();
		} catch (RuntimeException e) {
			Messages.addGlobalError("Ocorreu um error ao tentar carregar Clintes");
		}
	}
	public void novo(){
		try {
			usuario = new Usuario();
			PessoaDAO pessoaDao = new PessoaDAO(Pessoa.class);
			pessoas = pessoaDao.listar();
			
		} catch (RuntimeException e) {
			Messages.addGlobalError("Ocorreu um error ao tentar carregar Pessoas");
			e.printStackTrace();
		}
	}
	public void salvar(){
		try {
			UsuarioDAO usuarioDao = new UsuarioDAO(Usuario.class);
			usuarioDao.merge(usuario);
			
			novo();
			usuarios = usuarioDao.listar();
			Messages.addGlobalInfo("Usuario salvo com sucesso!!!");
			
		} catch (RuntimeException e) {
			Messages.addGlobalError("Ocorreu um error ao tentar carregar Usuarios");
			e.printStackTrace();
		}
	}
	public void excluir(ActionEvent evento){
		try{
			usuario = (Usuario) evento.getComponent().getAttributes().get("usuarioSelecionada");
			UsuarioDAO usuarioDao = new UsuarioDAO(Usuario.class);
			usuarioDao.excluir(usuario);
			usuarios = usuarioDao.listar();
			novo();
			Messages.addGlobalInfo("Usuario excluido com sucesso");
			
		} catch (RuntimeException e) {
			Messages.addGlobalError("Ocorreu um error ao tentar excluir um Usuario***");
			e.printStackTrace();
		}
	}
	public void editar(ActionEvent evento){
		try{
			usuario = (Usuario) evento.getComponent().getAttributes().get("usuarioSelecionada");
			
			PessoaDAO pessoaDao = new PessoaDAO(Pessoa.class);
			pessoas = pessoaDao.listar();
			
		} catch (RuntimeException e) {
			Messages.addGlobalError("Ocorreu um error ao tentar editar um Usuario***");
			e.printStackTrace();
		}
	}
}

