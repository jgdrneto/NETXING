package projeto.dao;

import java.util.List;

import projeto.modelos.Videofavorito;

public abstract class VideoFavoritoDAO {
	
	public abstract void salvar(Videofavorito VideosFavoritos);
	
	public abstract void deletar(Videofavorito VideosFavoritos);
	
	public abstract void atualizar(Videofavorito VideosFavoritos);
	
	public abstract List<Videofavorito> listaDeVideoFavorito();
}
