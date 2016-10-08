package javafx.modelos;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Categoria {
	
	private projeto.modelos.Categoria categoriaBD;
	private StringProperty nome;
	private Integer idCategoria; 
	
	public Categoria(String nome) {
		this.nome = new SimpleStringProperty(nome);
	}
	
	public Categoria(Integer nIdCategoria,String nome) {
		this.idCategoria = nIdCategoria;
		this.nome = new SimpleStringProperty(nome);
	}
	
	public String getNome() {
		return nome.get();
	}
	
	public StringProperty getNomeProperty() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome.set(nome);
	}

	public Integer getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
	}
}
