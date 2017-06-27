package mz.com.nova.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Ignore;
import org.junit.Test;

import mz.com.nova.modell.Funcionario;
import mz.com.nova.modell.Pessoa;

public class FuncionarioDAOTest {
	
	@Test
	@Ignore
	public void salvar() throws ParseException{
		PessoaDAO pessoaDao = new PessoaDAO(Pessoa.class);
		Pessoa pessoa = pessoaDao.buscar(1l);
		
		FuncionarioDAO funcionariDao = new FuncionarioDAO(Funcionario.class);
		Funcionario funcionario = new Funcionario();
		
		funcionario.setCarateiraTrabalho("Parcial");
		funcionario.setDataDeAdmissao(new SimpleDateFormat("dd/MM/yyyy").parse("13/08/2010"));
		funcionario.setPessoa(pessoa);
		
		funcionariDao.salvar(funcionario);
	}

}
