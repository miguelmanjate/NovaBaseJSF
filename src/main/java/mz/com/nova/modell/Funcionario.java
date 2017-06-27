package mz.com.nova.modell;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
public class Funcionario extends GenerecModell{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5775724468738140915L;

	@Column(nullable = false, length = 20)
	private String carateiraTrabalho;
	
	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date dataDeAdmissao;
	
	@OneToOne
	@JoinColumn(nullable = false)
	private Pessoa pessoa;
	
	public String getCarateiraTrabalho() {
		return carateiraTrabalho;
	}
	public void setCarateiraTrabalho(String carateiraTrabalho) {
		this.carateiraTrabalho = carateiraTrabalho;
	}
	public Date getDataDeAdmissao() {
		return dataDeAdmissao;
	}
	public void setDataDeAdmissao(Date dataDeAdmissao) {
		this.dataDeAdmissao = dataDeAdmissao;
	}
	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	

}
