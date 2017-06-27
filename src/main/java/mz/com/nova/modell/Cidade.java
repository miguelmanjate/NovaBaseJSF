package mz.com.nova.modell;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Cidade extends GenerecModell {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5609241170525048455L;
    @Column(length = 20, nullable = false)
	private String nome;
    
    @ManyToOne
    @JoinColumn(nullable = false)
    private Estado estado;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
    
    
	
}
