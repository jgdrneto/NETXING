package javafx.principal.view;

import java.io.IOException;
import java.util.List;

import javafx.adm.view.AdmOverviewController;
import javafx.adm.view.AdmRootLayoutController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.principal.Principal;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.usuario.view.UsuarioOverviewController;
import projeto.dao.DAO_HIB;
import projeto.modelos.Usuario;

public class InicioOverviewController {
	
	Principal principal;
	
	List<Usuario> listaUsuarios; 
	
	@FXML
	private TextField textoLogin;
	
	@FXML
	private PasswordField textoSenha;
	
	/**
	 * Chamado quando o usuário clica no botão de login.
	 */
	@FXML
	private void pressionarSair() {
		principal.getPrimaryStage().close();
	}
		
	/**
	 * Chamado quando o usuário clica no botão de login.
	 */
	@FXML
	private void pressionarLogin() {
				
		Usuario usuarioDigitado = null;
		
		for(Usuario u : DAO_HIB.USUARIO.listaDeUsuarios()){
			
			if(u.getLogin().equals(textoLogin.getText()) && u.getSenha().equals(textoSenha.getText())){
				usuarioDigitado = u;
			}
		}
		
		if(usuarioDigitado!=null){
			if(usuarioDigitado.getIdUsuario()==1){
				
				iniciarTelaAdministrador(usuarioDigitado);
				
			}else{
				iniciarTelaUsuario(usuarioDigitado);
			}
			
	        //Fechando tela de login
	        principal.getPrimaryStage().close();
		}else{
			//Tela de alerta para se usar caso a autenticação der errado
			alerta();
		}
	}
	
	public void alerta(){
		  Alert alert = new Alert(AlertType.WARNING);
          alert.setTitle("Erro no login");
          alert.setHeaderText("Usuário e/ou senha incorretos");
          alert.setContentText("Por favor, digite login e senha válidos");
          
          //Zerando so componentes
          textoLogin.setText("");
          textoSenha.setText("");
          
          textoLogin.requestFocus();
          
          alert.showAndWait();
	}
	
	public void iniciarTelaAdministrador(Usuario adm){
		try {
			// Cria o palco stage.
	        Stage stage = new Stage();
	        stage.setTitle("Adminstrador");
			
	        //-----------------------------------------------------------------------
	        FXMLLoader loaderAnchor = new FXMLLoader();
	        loaderAnchor.setLocation(AdmOverviewController.class.getResource("AdmOverview.fxml"));
	        AnchorPane page = (AnchorPane) loaderAnchor.load();
	        
	        //-----------------------------------------------------------------------
	        FXMLLoader loaderBorder = new FXMLLoader();
	        loaderBorder.setLocation(AdmOverviewController.class.getResource("AdmRootLayout.fxml"));
	        BorderPane rootLayout = (BorderPane) loaderBorder.load();
	        
	        rootLayout.setPrefSize(page.getPrefWidth(), page.getPrefHeight());
	        
	        rootLayout.setCenter(page);
	        
	        Scene scene = new Scene(rootLayout);
	        stage.setScene(scene);
	        
	        //-----------------------------------------------------------------------
	        // Define o controlador para o ADM
	        AdmOverviewController controller = loaderAnchor.getController();	        
	        controller.setInicioOverviewController(this);
	        controller.setUsuario(adm);
			controller.setAdmStage(stage);
			
	        AdmRootLayoutController rController = loaderBorder.getController();
	        rController.setInicioOverviewController(this);
	        rController.setAdmOverviewController(controller);
	        // Mostra a janela de administrador
	        stage.show();
	        
	        //Iniciar com foco no textfield de pesquisa de videos
	        controller.focoPesquisaVideos();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void iniciarTelaUsuario(Usuario usuario){
		
        try {
        	FXMLLoader loaderAnchor = new FXMLLoader();
            loaderAnchor.setLocation(UsuarioOverviewController.class.getResource("UsuarioOverview.fxml"));
			AnchorPane page = (AnchorPane) loaderAnchor.load();
			
			BorderPane layout = new BorderPane();
	        layout.setCenter(page);
	        
	        Scene scene = new Scene(layout);
	        Stage stage = new Stage();
	        
	        stage.setScene(scene);
	        stage.setTitle("Usuário");
	        
	        stage.show();
	        
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	}
	
	/**
     * É chamado pela aplicação principal para dar uma referência de volta a si mesmo.
     * 
     * @param Principal
     */
    public void setPrincipal(Principal nPrincipal) {
        this.principal = nPrincipal;

    }
    
    public Principal getPrincipal() {
		return principal;
	}

	@FXML
    private void initialize() {
    	//Nada a se inicializar
    }
	
    public void clear(){
    	this.textoLogin.setText("");
    	this.textoSenha.setText("");
    	
    	this.textoLogin.requestFocus();
    }
    
}
