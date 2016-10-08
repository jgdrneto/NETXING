package projeto.dao;

import java.util.List;

import projeto.modelos.Video;

public abstract class VideoDAO {
	
	public abstract void salvar(Video Video);
	
	public abstract void deletar(Video Video);
	
	public abstract void atualizar(Video Video);
	
	public abstract List<Video> listaDeVideos();
}
