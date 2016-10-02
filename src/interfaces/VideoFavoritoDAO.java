package interfaces;

import java.util.List;

import modelosBD.VideoFavorito;

public interface VideoFavoritoDAO {
	
	public void salvar(VideoFavorito VideosFavoritos);
	
	public void deletar(VideoFavorito VideosFavoritos);
	
	public void atualizar(VideoFavorito VideosFavoritos);
	
	public List<VideoFavorito> listaDeVideoFavorito();
}
