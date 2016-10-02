package interfaces;

import java.util.List;

import modelosBD.Usuario;

public interface UsuarioDAO {
	
	public void salvar(Usuario usuario);
	
	public void deletar(Usuario usuario);
	
	public void atualizar(Usuario usuario);
	
	public List<Usuario> listaDeUsuarios();
}
