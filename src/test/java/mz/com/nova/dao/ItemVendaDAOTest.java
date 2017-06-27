package mz.com.nova.dao;

import java.math.BigDecimal;

import org.junit.Ignore;
import org.junit.Test;

import mz.com.nova.modell.ItemVenda;
import mz.com.nova.modell.Produto;
import mz.com.nova.modell.Venda;

public class ItemVendaDAOTest {

	@Ignore
	@Test
	public void salvar(){
		ProdutoDAO produtoDao = new ProdutoDAO(Produto.class);
		Produto produto = produtoDao.buscar(2l);
		
		VendaDAO vendaDao = new VendaDAO(Venda.class);
		Venda venda = vendaDao.buscar(1l);
		
		ItemVendaDAO itemVendaDao = new ItemVendaDAO(Venda.class);
		ItemVenda itemVenda = new ItemVenda();
		
		itemVenda.setProduto(produto);
		itemVenda.setQuantidade(new Short("4"));
		itemVenda.setValorParcial(new BigDecimal("230.20"));
		itemVenda.setVenda(venda);
		
		itemVendaDao.salvar(itemVenda);
	}
}
