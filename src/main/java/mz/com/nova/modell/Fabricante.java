package mz.com.nova.modell;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Fabricante extends GenerecModell {
	/**
	 * 
	 */
	private static final long serialVersionUID = -384239959624811458L;
	
	@Column(length = 20, nullable = false)
	private String descricao;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	

}
