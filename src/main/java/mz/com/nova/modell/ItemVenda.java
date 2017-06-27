package mz.com.nova.modell;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class ItemVenda extends GenerecModell{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6880506717923127198L;
	
	@Column(nullable = false)
	private Short quantidade;
	
	@Column(nullable = false, precision = 7 , scale = 2)
	private BigDecimal valorParcial;
	
	
	@ManyToOne
	private Produto produto;
	
	
	@ManyToOne
	private Venda venda;

	public Short getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Short quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getValorParcial() {
		return valorParcial;
	}

	public void setValorParcial(BigDecimal valorParcial) {
		this.valorParcial = valorParcial;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}
	
	

}
