package projeto.dao;

import java.util.List;

import projeto.modelos.Categoria;

public abstract class CategoriaDAO {
	
	public abstract void salvar(Categoria Categoria);
	
	public abstract void deletar(Categoria Categoria);
	
	public abstract void atualizar(Categoria Categoria);
	
	public abstract List<Categoria> listaDeCategorias();
}
