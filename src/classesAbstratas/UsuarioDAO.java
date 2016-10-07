package classesAbstratas;

import java.util.List;

import modelosBD.Usuario;

public abstract class UsuarioDAO {
	
	public abstract void salvar(Usuario usuario);
	
	public abstract void deletar(Usuario usuario);
	
	public abstract void atualizar(Usuario usuario);
	
	public abstract List<Usuario> listaDeUsuarios();
}
