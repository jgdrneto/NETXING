package javafx.modelos;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import projeto.dao.DAO;

public class Categoria {
	
	private projeto.modelos.Categoria categoriaBD;
	private StringProperty nome;
	
	public Categoria(String nNome) {
		this.nome = new SimpleStringProperty(nNome);
		
		projeto.modelos.Categoria categoria = new projeto.modelos.Categoria(nNome);
		
		DAO.ACAO.salvar(categoria);
		
	}
	
	public Categoria(projeto.modelos.Categoria nCategoria) {
		
		categoriaBD = nCategoria;
		
        // DAO.ACAO.atualizar(categoriaBD);

		this.nome = new SimpleStringProperty(nCategoria.getNome());
		
	}
	
	public String getNome() {
		return nome.get();
	}
	
	public StringProperty getNomeProperty() {
		return nome;
	}
	
	public void setNome(String nNome) {
		this.nome.set(nNome);
		
		categoriaBD.setNome(nNome);
		
		DAO.ACAO.atualizar(categoriaBD);
		
	}

	public projeto.modelos.Categoria getCategoriaBD() {
		return categoriaBD;
	}
	
	@Override
	public String toString() {
		return getNome();
	}
	
	
}
