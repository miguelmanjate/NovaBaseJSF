package mz.com.nova.dao;

import org.junit.Ignore;
import org.junit.Test;

import mz.com.nova.modell.Pessoa;
import mz.com.nova.modell.Usuario;

public class UsuarioDAOTest {
	@Test
	@Ignore
	public void salvar(){
		
		PessoaDAO pessaoDao = new PessoaDAO(Pessoa.class);
		Pessoa pessoa = pessaoDao.buscar(1l);
		
		UsuarioDAO usuarioDao = new UsuarioDAO(Usuario.class);
		Usuario usuario = new Usuario();
		
		usuario.setAtivo(false);
		usuario.setPessoa(pessoa);
		usuario.setSenha("assi4");
		usuario.setTipo('B');
		
		usuarioDao.salvar(usuario);
		
	}

}
