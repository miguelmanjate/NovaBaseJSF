package mz.com.nova.modell;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Produto extends GenerecModell {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3320779107770995807L;
	
	@Column(length = 80, nullable = false)
	private String descricao;
	
	@Column(nullable = false)
	private Short quantidade;
	/*precision estamos a definir o numero total de digitos contando antes e depois da virgula,
	 * scale estamos a afirmar que o numero total depois da virgula sao 2, isto eh duas casas decimais
	 *= 0000,00
	 */
	@Column(nullable = false, precision = 6, scale = 2)
	private BigDecimal preco;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Fabricante fabricante;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Short getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Short quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public Fabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}
	
	

}
