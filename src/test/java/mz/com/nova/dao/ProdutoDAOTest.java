package mz.com.nova.dao;

import java.math.BigDecimal;

import org.junit.Ignore;
import org.junit.Test;

import mz.com.nova.modell.Fabricante;
import mz.com.nova.modell.Produto;


public class ProdutoDAOTest {
	
	@Test
	@Ignore
	public void salvar(){
	FabricanteDAO fabricanteDao = new FabricanteDAO(Fabricante.class);
	Fabricante fabricante = fabricanteDao.buscar(3l);
	
	ProdutoDAO produtoDao = new ProdutoDAO(Produto.class);
	Produto produto = new Produto();
	
    produto.setDescricao("Charope 300mil 10 frascos");
    produto.setFabricante(fabricante);
    produto.setPreco(new BigDecimal("180.50"));
    produto.setQuantidade(new Short("3"));
    
    produtoDao.salvar(produto);
	}
}
