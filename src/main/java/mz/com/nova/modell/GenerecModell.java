package mz.com.nova.modell;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
/*
 * garente que esta classe nao sera mapeada pelo hibenate, isto 
 *eh ela nao corresponde a uma tabela mas sera usada por outros para gerar tabela
 */
@SuppressWarnings("serial")
@MappedSuperclass
public class GenerecModell implements Serializable{
	@Id
	@GeneratedValue
	private long id;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return String.format("%s[id=%d]", getClass().getSimpleName(), getId());
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GenerecModell other = (GenerecModell) obj;
		if (id != other.id)
			return false;
		return true;
	}
}
