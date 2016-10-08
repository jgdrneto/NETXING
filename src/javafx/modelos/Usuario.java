package javafx.modelos;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Usuario{
	private projeto.modelos.Usuario usuarioBD;
	private StringProperty login;
	private StringProperty senha;
	private IntegerProperty idade;

	public Usuario(String login, String senha, Integer idade) {
		this.login = new SimpleStringProperty(login);
		this.senha = new SimpleStringProperty(senha);
		this.idade = new SimpleIntegerProperty(idade);
		
		usuarioBD = new projeto.modelos.Usuario(login, senha, idade);
	}
	
	public Usuario(projeto.modelos.Usuario nUsuario) {
		
		nUsuario = usuarioBD;
		
		this.login = new SimpleStringProperty(nUsuario.getLogin());
		this.senha = new SimpleStringProperty(nUsuario.getSenha());
		this.idade = new SimpleIntegerProperty(nUsuario.getIdade());
	}
	
	public void setLogin(String nLogin) {
		this.usuarioBD.setLogin(nLogin);
		this.login.set(nLogin);
	}

	public void setSenha(String nSenha) {
		this.usuarioBD.setSenha(nSenha);
		this.senha.set(nSenha);
	}

	public void setIdade(Integer nIdade) {
		this.usuarioBD.setIdade(nIdade);
		this.idade.set(nIdade);
	}

	public StringProperty getLoginProperty() {
		return login;
	}

	public StringProperty getSenhaProperty() {
		return senha;
	}

	public IntegerProperty getIdadeProperty() {
		return idade;
	}
	
	public String getLogin() {
		return login.get();
	}

	public String getSenha() {
		return senha.get();
	}

	public Integer getIdade() {
		return idade.get();
	}

	public Integer getIdUsuario() {
		return usuarioBD.getIdUsuario();
	}
	
}
