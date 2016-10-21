package javafx.adm.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.modelos.Usuario;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class CadUsuarioDialogController {
	
	AdmOverviewController admController;
	
	@FXML
	private TextField login;
	
	@FXML
	private TextField senha;
	
	@FXML
	private TextField repetirSenha;
	
	@FXML
	private ChoiceBox<Integer> idade;
	
	
	ObservableList<Integer> idades = FXCollections.observableArrayList();
	
	private Stage dialogStage;
	
	 /**
     * Define o palco deste dialog.
     * 
     * @param dialogStage
     */
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }
    
    public void setAdmController(AdmOverviewController nAdmController){
    	this.admController = nAdmController;
    }
    
    public void BotaoCancelar(){
    	dialogStage.close();
    }
    
    public void BotaoSalvar(){
    	
    	if(validarOperacao()){
    		admController.getUsuariosData().add(new Usuario(login.getText(), senha.getText(), idade.getValue()));
    		
    		dialogStage.close();
    	}
    	
    }
    
    private boolean validarOperacao() {
		
    	if(senha.getText().equals(repetirSenha.getText()) && !senha.getText().equals("")){
    		if(idade.getValue()!=null){
    			if(!login.getText().equals("")){
    				if(!contemUsuario(admController.getUsuariosData(), login.getText())){
    					
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
    	
    	for(int i=0;i<=130;i++){
    		idades.add(i);
    	}
    	
    	idade.setItems(idades);
    }
}
