package mz.com.nova.modell;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Venda extends GenerecModell{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6539868789890291206L;
	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date horrario;
	
	@Column(nullable = false, precision = 7, scale = 2)
	private BigDecimal precoTotal;
	
	@ManyToOne
	private Cliente cliente;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private Funcionario funcionario;

	public Date getHorrario() {
		return horrario;
	}

	public void setHorrario(Date horrario) {
		this.horrario = horrario;
	}

	public BigDecimal getPrecoTotal() {
		return precoTotal;
	}

	public void setPrecoTotal(BigDecimal precoTotal) {
		this.precoTotal = precoTotal;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	
	

}
