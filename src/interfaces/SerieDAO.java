package interfaces;

import java.util.List;

import modelosBD.Serie;

public interface SerieDAO {
	
	public void salvar(Serie Serie);
	
	public void deletar(Serie Serie);
	
	public void atualizar(Serie Serie);
	
	public List<Serie> listaDeSeries();
}
