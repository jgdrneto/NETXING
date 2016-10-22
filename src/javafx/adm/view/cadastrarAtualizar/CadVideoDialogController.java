package javafx.adm.view.cadastrarAtualizar;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.modelos.ControllerAdm;
import javafx.modelos.Usuario;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;

public class CadVideoDialogController extends ControllerAdm{
	
	@FXML
	private TextField nome;
	@FXML
	private TextField ano;
	@FXML
	private TextArea descricao;
	@FXML
	private TextField diretor;
	@FXML
	private TextField atorPrincipal;
	@FXML
	private TextField temporada;
	@FXML
	private ChoiceBox<Integer> idade;
	@FXML
	private ChoiceBox<projeto.modelos.Serie> series;
	@FXML
	private ChoiceBox<projeto.modelos.Categoria> categorias;
	ObservableList<Integer> idades = FXCollections.observableArrayList();
	@FXML
	private Button escolherVideo;
	@FXML
	private Button escolherImagem;
	
    public void BotaoCancelar(){
    	this.getStage().close();
    }
    
    @FXML
    public void BotaoSalvar(){
    	/*
    	if(validarOperacao()){
    		this.getAdmController().getUsuariosData().add(new Usuario(login.getText(), senha.getText(), idade.getValue()));
    		
    		this.getStage().close();
    	}
    	*/
    }
    
    private boolean validarOperacao() {
		/*
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
    	*/
    	return false;
    	
	}
    
    @FXML
    private void escolherVideo(){
    	
    }
    
    @FXML
    private void escolherSerie(){
    	
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
    }
}
