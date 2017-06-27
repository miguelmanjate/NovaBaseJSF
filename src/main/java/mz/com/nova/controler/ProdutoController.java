package mz.com.nova.controler;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;
import org.primefaces.event.FileUploadEvent;

import mz.com.nova.dao.CidadeDAO;
import mz.com.nova.dao.FabricanteDAO;
import mz.com.nova.dao.ProdutoDAO;
import mz.com.nova.modell.Cidade;
import mz.com.nova.modell.Fabricante;
import mz.com.nova.modell.Produto;

@ManagedBean
@ViewScoped
public class ProdutoController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6214799275214845148L;
	private List<Produto> produtos;
	private Produto produto;
	private List<Fabricante> fabricantes;

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setFabricantes(List<Fabricante> fabricantes) {
		this.fabricantes = fabricantes;
	}

	public List<Fabricante> getFabricantes() {
		return fabricantes;
	}

	@PostConstruct
	public void listar() {
		try {
			ProdutoDAO produtoDao = new ProdutoDAO(Produto.class);
			produtos = produtoDao.listar();
		} catch (RuntimeException e) {
			Messages.addGlobalError("Ocorreu um Error ao tentar caregar produtos***");
			e.printStackTrace();
		}

	}

	public void novo() {
		produto = new Produto();
		try {
			FabricanteDAO fabricanteDao = new FabricanteDAO(Fabricante.class);
			fabricantes = fabricanteDao.listar();
		} catch (RuntimeException e) {
			Messages.addGlobalError("Ocorreu um Error ao tentar Carregar Fabricantes");
		}
	}

	public void salvar() {
		try {
			ProdutoDAO produtoDao = new ProdutoDAO(Produto.class);
			produtoDao.merge(produto);
			novo();
			produtos = produtoDao.listar();

		} catch (RuntimeException e) {
			Messages.addGlobalError("Ocorreu um Error ao salvar o produto***");
			e.printStackTrace();
		}

	}

	public void excluir(ActionEvent evento) {
		try {
			produto = (Produto) evento.getComponent().getAttributes().get("produtoSelecionada");
			ProdutoDAO produtoDao = new ProdutoDAO(Produto.class);

			produtoDao.excluir(produto);
			Messages.addGlobalInfo("Produto excluido com sucesso!!!");
			novo();
			produtos = produtoDao.listar();
		} catch (RuntimeException e) {
			Messages.addGlobalError("Ocorreu um erro ao tentar excluir o Produto");
		}
	}

	public void editar(ActionEvent evento) {
		produto = (Produto) evento.getComponent().getAttributes().get("produtoSelecionada");

		try {
			FabricanteDAO fabricanteDao = new FabricanteDAO(Fabricante.class);
			fabricantes = fabricanteDao.listar();

		} catch (RuntimeException e) {
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar o produto***");
		}
	}

	public void upload(FileUploadEvent evento) {
          System.out.println("Chamou o metado");
	}
}
