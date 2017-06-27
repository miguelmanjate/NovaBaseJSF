package mz.com.nova.dao;

import java.util.List;

public interface GenericD<T> {
	
	public void salvar(T t);
	
	public List<T> listar();
	
	public T buscar(Long id);
	
	public void excluir(T t);
	
	public void editar(T t);
	
	public void merge(T t);

}
