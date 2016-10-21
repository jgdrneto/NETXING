package projeto.dao;

import java.util.List;

public interface Regras {
	
	public abstract <T> void salvar(T objeto);
	
	public abstract <T> void deletar(T objeto);
	
	public abstract <T> void atualizar(T objeto);
	
	public abstract <T> List<T> listar(Class<?> Classe);
	
}
