package mz.com.nova.modell;

import javax.persistence.Column;
import javax.persistence.Entity;


@Entity
public class Estado extends GenerecModell {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5203600322451663563L;
	@Column(length = 2, nullable = false)
	private String sigla;
	@Column(length = 50, nullable = false)
	private String nome;

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
