package javafx.modelos;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Videofavorito {

	private IntegerProperty idVideoFavorito;
	private StringProperty nomeUsuario;
	private StringProperty nomeVideo;

	public Videofavorito() {
	}

	public Videofavorito(String usuario, String video) {
		this.nomeUsuario = new SimpleStringProperty(usuario);
		this.nomeVideo = new SimpleStringProperty(video);
	}

	public StringProperty getNomeUsuarioProperty() {
		return nomeUsuario;
	}
	
	public String getNomeUsuario() {
		return nomeUsuario.get();
	}
	
	public void setNomeUsuario(StringProperty nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public StringProperty getNomeVideo() {
		return nomeVideo;
	}

	public void setNomeVideo(StringProperty nomeVideo) {
		this.nomeVideo = nomeVideo;
	}

	
}
