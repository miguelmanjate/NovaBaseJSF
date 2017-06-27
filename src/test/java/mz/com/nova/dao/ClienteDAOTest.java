package mz.com.nova.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Ignore;
import org.junit.Test;

import mz.com.nova.modell.Cliente;
import mz.com.nova.modell.Pessoa;

public class ClienteDAOTest {
	@Test
	@Ignore
	public void salvar() throws ParseException{
		PessoaDAO pessoaDao = new PessoaDAO(Pessoa.class);
		Pessoa pessoa = pessoaDao.buscar(4l);
				
		Cliente cliente = new Cliente();
		ClienteDAO clienteDao = new ClienteDAO(Cliente.class);
		
		cliente.setDatacadastro(new SimpleDateFormat("dd/MM/yyyy").parse("09/04/2014"));
		cliente.setLiberado(false);
		cliente.setPessoa(pessoa);
		
		clienteDao.salvar(cliente);
	}

}
