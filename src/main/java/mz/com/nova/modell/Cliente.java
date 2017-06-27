package mz.com.nova.modell;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Cliente extends GenerecModell {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7152142057014838245L;

	@Column(nullable = false)
	@Temporal( TemporalType.DATE)
	private Date datacadastro;
	
	@Column(nullable = false)
	private Boolean liberado;
	
	@OneToOne
	@JoinColumn(nullable = false)
	private Pessoa pessoa;

	public Date getDatacadastro() {
		return datacadastro;
	}

	public void setDatacadastro(Date datacadastro) {
		this.datacadastro = datacadastro;
	}

	public Boolean getLiberado() {
		return liberado;
	}

	public void setLiberado(Boolean liberado) {
		this.liberado = liberado;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
}
