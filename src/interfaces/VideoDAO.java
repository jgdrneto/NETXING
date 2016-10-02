package interfaces;

import java.util.List;

import modelosBD.Video;

public interface VideoDAO {
	
	public void salvar(Video Video);
	
	public void deletar(Video Video);
	
	public void atualizar(Video Video);
	
	public List<Video> listaDeVideos();
}
