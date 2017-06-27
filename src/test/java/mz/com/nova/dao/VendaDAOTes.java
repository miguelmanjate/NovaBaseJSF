package mz.com.nova.dao;

import java.math.BigDecimal;
import java.util.Date;

import org.junit.Ignore;
import org.junit.Test;

import mz.com.nova.modell.Cliente;
import mz.com.nova.modell.Funcionario;
import mz.com.nova.modell.Venda;

public class VendaDAOTes {
	
	@Test
	@Ignore
	public void salvar(){
		FuncionarioDAO funcionarioDao = new FuncionarioDAO(Funcionario.class);
		Funcionario funcionario = funcionarioDao.buscar(1l);
		
		ClienteDAO clienteDao = new ClienteDAO(Cliente.class);
		Cliente cliente = clienteDao.buscar(1l);
		
		VendaDAO vendaDao = new VendaDAO(Venda.class);
		Venda venda = new Venda();
		
		venda.setCliente(cliente);
		venda.setFuncionario(funcionario);
		venda.setPrecoTotal(new BigDecimal("123.90"));
		venda.setHorrario(new Date());
		
		vendaDao.salvar(venda);
		
	}

}
