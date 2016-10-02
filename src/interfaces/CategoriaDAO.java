package interfaces;

import java.util.List;

import modelosBD.Categoria;

public interface CategoriaDAO {
	
	public void salvar(Categoria Categoria);
	
	public void deletar(Categoria Categoria);
	
	public void atualizar(Categoria Categoria);
	
	public List<Categoria> listaDeCategorias();
}
