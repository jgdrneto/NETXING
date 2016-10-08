package javafx.modelos;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Serie {
	
	private projeto.modelos.Serie SerieBD;
	private StringProperty nome;
	private Integer idSerie;
	
	public Serie(String nNome) {
		this.nome = new SimpleStringProperty(nNome);
	}
	
	public Serie(Integer idSerie,String nNome) {
		this.idSerie = idSerie;
		this.nome = new SimpleStringProperty(nNome);
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

	public Integer getIdSerie() {
		return idSerie;
	}

	public void setIdSerie(Integer idSerie) {
		this.idSerie = idSerie;
	}

	public void setNome(StringProperty nome) {
		this.nome = nome;
	}

}
