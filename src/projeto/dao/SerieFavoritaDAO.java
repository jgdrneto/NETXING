package projeto.dao;

import java.util.List;

import projeto.modelos.Seriefavorita;

public abstract class SerieFavoritaDAO {
	
	public abstract void salvar(Seriefavorita SerieFavorita);
	
	public abstract void deletar(Seriefavorita SerieFavorita);
	
	public abstract void atualizar(Seriefavorita SerieFavorita);
	
	public abstract List<Seriefavorita> listaDeSerieFavorita();
}
