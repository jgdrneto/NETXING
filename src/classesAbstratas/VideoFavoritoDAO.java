package classesAbstratas;

import java.util.List;

import modelosBD.Videofavorito;

public abstract class VideoFavoritoDAO {
	
	public abstract void salvar(Videofavorito VideosFavoritos);
	
	public abstract void deletar(Videofavorito VideosFavoritos);
	
	public abstract void atualizar(Videofavorito VideosFavoritos);
	
	public abstract List<Videofavorito> listaDeVideoFavorito();
}
