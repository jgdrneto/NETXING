package javafx.adm.view.cadastrarAtualizar;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.modelos.ControllerAdm;
import javafx.modelos.Usuario;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class CadUsuarioDialogController extends ControllerAdm{
	
	@FXML
	private TextField login;
	
	@FXML
	private TextField senha;
	
	@FXML
	private TextField repetirSenha;
	
	@FXML
	private ChoiceBox<Integer> idade;
	
	
	private javafx.modelos.Usuario usuario;
	
	ObservableList<Integer> idades = FXCollections.observableArrayList();
	
	public CadUsuarioDialogController() {
		this.setAcao(ACAO.CADASTRAR);
	}

    public void setUsuario(Usuario nUsuario) {
        this.usuario = nUsuario;
        this.setAcao(ACAO.ATUALIZAR);

        login.setText(usuario.getLogin());
        senha.setText(usuario.getSenha());
        repetirSenha.setText(usuario.getSenha());
        idade.setValue(usuario.getIdade());
	}
	
	@FXML	    
    public void BotaoCancelar(){
    	this.getStage().close();
    }
	
    @FXML
    public void BotaoSalvar(){
	 	
    	switch(this.getAcao()){
    		case CADASTRAR :
    			cadastrar();
    		break;
    		case ATUALIZAR:
    			atualizar();
    		break;	
    	}

    }
    
    private void atualizar() {
		
    	if(validarOperacaoAtualizar()){
    		
    		usuario.setLogin(login.getText());
    		usuario.setSenha(senha.getText());
    		usuario.setIdade(idade.getValue());
    		
            this.getStage().close();
    	}
		
	}

	private boolean validarOperacaoAtualizar() {
		if(!login.getText().equals("")){
			if(!contemUsuario(this.getAdmController().getUsuariosData(), login.getText()) || login.getText().equals(usuario.getLogin())){
				if(senha.getText().equals(repetirSenha.getText()) && !senha.getText().equals("")){
					return true;
				}else{
					alerta("Senhas distintas ou vazias", "Senhas não conferem", "Pro favor, digite senhas que sejam iguais");
		    		
		    		senha.setText(usuario.getSenha());
		    		repetirSenha.setText(usuario.getSenha());
		    		
		    		senha.requestFocus();
				}
			}else{
				alerta("Login ja existente", "Login já cadastrado", "Pro favor, use outro login");
				
				login.setText(usuario.getLogin());
				
				login.requestFocus();
			}
		}else{
			login.setText(usuario.getLogin());
			
			login.requestFocus();
		}
		return false;
	}


	private void cadastrar() {

    	if(validarOperacaoCadastrar()){
    		
    		this.getAdmController().getUsuariosData().add(new Usuario(login.getText(), senha.getText(), idade.getValue()));
    		
    		this.getStage().close();
    	}
	}

    private boolean validarOperacaoCadastrar() {
		
    	if(senha.getText().equals(repetirSenha.getText()) && !senha.getText().equals("")){
    		if(idade.getValue()!=null){
    			if(!login.getText().equals("")){
    				if(!contemUsuario(this.getAdmController().getUsuariosData(), login.getText())){
    					
    					return true;
    					
    				}else{
    					alerta("Login ja existente", "Login já cadastrado", "Pro favor, use outro login");
    					
    					login.setText("");
    					
    					login.requestFocus();
    				}
    			}else{
    				login.requestFocus();
    			}
    		}else{
    			idade.requestFocus();
    		}
    	}else{
    		alerta("Senhas distintas ou vazias", "Senhas não conferem", "Pro favor, digite senhas que sejam iguais");
    		
    		senha.setText("");
    		repetirSenha.setText("");
    		
    		senha.requestFocus();
    	}
    	
    	return false;
	}
    
    
    private boolean contemUsuario(ObservableList<Usuario> usuariosData, String text) {
		
    	for(Usuario u : usuariosData){
    		if(u.getLogin().equals(text)){
    			return true;
    		}
    	}
    	
		return false;
	}

	private void alerta(String titulo, String cabecalho, String conteudo){
		Alert alert = new Alert(AlertType.WARNING);
        alert.setTitle(titulo);
        alert.setHeaderText(cabecalho);
        alert.setContentText(conteudo);
        
        alert.showAndWait();
	}
    
	@FXML
    private void initialize(){
    	
    	for(int i=1;i<=130;i++){
    		idades.add(i);
    	}
    	
    	idade.setItems(idades);
    	
    	if(usuario!=null){
    		login.setText(usuario.getLogin());
    		senha.setText(usuario.getSenha());
    		repetirSenha.setText(usuario.getSenha());
    		idade.setValue(usuario.getIdade());
    	}
    }
}
