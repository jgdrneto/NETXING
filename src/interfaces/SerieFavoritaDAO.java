package interfaces;

import java.util.List;

import modelosBD.SerieFavorita;

public interface SerieFavoritaDAO {
	
	public void salvar(SerieFavorita SerieFavorita);
	
	public void deletar(SerieFavorita SerieFavorita);
	
	public void atualizar(SerieFavorita SerieFavorita);
	
	public List<SerieFavorita> listaDeSerieFavorita();
}
