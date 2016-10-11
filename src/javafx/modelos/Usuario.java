package javafx.modelos;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import projeto.dao.DAO_HIB;

public class Usuario{
	private projeto.modelos.Usuario usuarioBD;
	private StringProperty login;
	private StringProperty senha;
	private IntegerProperty idade;

	public Usuario(String login, String senha, Integer idade) {
		this.login = new SimpleStringProperty(login);
		this.senha = new SimpleStringProperty(senha);
		this.idade = new SimpleIntegerProperty(idade);
		
		//Cria o usuário
		usuarioBD = new projeto.modelos.Usuario(login, senha, idade);
		
		//salva no banco de dados usando o hibernate 
		DAO_HIB.USUARIO.salvar(usuarioBD);
	}
	
	public Usuario(projeto.modelos.Usuario nUsuario) {
		
		usuarioBD = nUsuario;
				
		this.login = new SimpleStringProperty(nUsuario.getLogin());
		this.senha = new SimpleStringProperty(nUsuario.getSenha());
		this.idade = new SimpleIntegerProperty(nUsuario.getIdade());
	}
	
	public void setLogin(String nLogin) {
		this.usuarioBD.setLogin(nLogin);
		
		DAO_HIB.USUARIO.atualizar(usuarioBD);
		
		this.login.set(nLogin);
	}

	public void setSenha(String nSenha) {
		this.usuarioBD.setSenha(nSenha);
		
		DAO_HIB.USUARIO.atualizar(usuarioBD);
		
		this.senha.set(nSenha);
	}

	public void setIdade(Integer nIdade) {
		this.usuarioBD.setIdade(nIdade);
		
		DAO_HIB.USUARIO.atualizar(usuarioBD);
		
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
	
	public projeto.modelos.Usuario getUsuarioBD(){
		return this.usuarioBD;
	}
}
