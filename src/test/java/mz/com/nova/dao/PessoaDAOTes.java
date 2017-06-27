package mz.com.nova.dao;

import org.junit.Ignore;
import org.junit.Test;

import mz.com.nova.modell.Cidade;
import mz.com.nova.modell.Pessoa;

public class PessoaDAOTes {
	@Test
	@Ignore
	public void salvar(){
		CidadeDAO cidadeDao = new CidadeDAO(Cidade.class);
		Cidade cidade = cidadeDao.buscar(3l);
		
		PessoaDAO pessoaDao = new PessoaDAO(Pessoa.class);
		Pessoa pessoa = new Pessoa();
		
		pessoa.setNome("Zidane");
		pessoa.setCpf("36");
		pessoa.setCep("3644");
		pessoa.setBairro("Paris");
		pessoa.setCelular("8456733");
		pessoa.setCidade(cidade);
		pessoa.setComplemento("Treinador");
		pessoa.setEmail("zedaneeem@gmail.com");
		pessoa.setNumero(new Short("2637"));
		pessoa.setRua("z13");
		pessoa.setRg("por");
		pessoa.setTelefone("363783");
		
		pessoaDao.salvar(pessoa);
	}

}
