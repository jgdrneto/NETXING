package javafx.modelos;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class Seriefavorita {
	
	private projeto.modelos.Seriefavorita seriefavoritaBD;
	private StringProperty nomeSerie;
	private Integer idUsuario;
	
	public Seriefavorita(String nNomeSerie) {
		this.nomeSerie = new SimpleStringProperty(nNomeSerie);
	}
	
	public String getNome() {
		return nomeSerie.get();
	}
	
	public StringProperty getNomeProperty() {
		return nomeSerie;
	}

	public void setNomeSerie(String nomeSerie) {
		this.nomeSerie.set(nomeSerie);
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

}
