package projeto.dao;

import java.util.List;

import projeto.modelos.Serie;

public abstract class SerieDAO {
	
	public abstract void salvar(Serie Serie);
	
	public abstract void deletar(Serie Serie);
	
	public abstract void atualizar(Serie Serie);
	
	public abstract List<Serie> listaDeSeries();
}
