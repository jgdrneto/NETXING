package javafx.principal.view;

import java.io.IOException;
import java.util.List;

import javafx.adm.view.AdmOverviewController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.principal.Principal;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import projeto.dao.DAO_HIB;
import projeto.modelos.Usuario;

public class InicioOverviewController {
	
	Principal principal;
	
	List<Usuario> listaUsuarios; 
	
	@FXML
	private TextField textoLogin;
	
	@FXML
	private TextField textoSenha;
	
	
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
			
			System.out.println("Login:" + u.getLogin() + " Senha: " + u.getSenha());
			
			System.out.println("Texto no login: " + textoLogin.getText());
			System.out.println("Texto na senha: " + textoSenha.getText());
			
			if(u.getLogin().equals(textoLogin.getText()) && u.getSenha().equals(textoSenha.getText())){
				usuarioDigitado = u;
			}
		}
		
		if(usuarioDigitado!=null){
			if(usuarioDigitado.getIdUsuario()==1){
				try {
					
					FXMLLoader loader = new FXMLLoader();
			        loader.setLocation(AdmOverviewController.class.getResource("AdmOverview.fxml"));
			        AnchorPane page;
			        
					page = (AnchorPane) loader.load();
					
					// Cria o palco stage.
			        Stage stage = new Stage();
			        stage.setTitle("Adminstrador");
			   
			        Scene scene = new Scene(page);
			        stage.setScene(scene);
			        
			        
			        // Define a pessoa no controller.
			        AdmOverviewController controller = loader.getController();
			        controller.setPrincipal(principal);
			        controller.setUsuario(usuarioDigitado);
					
			        // Mostra a janela de administrador
			        stage.show();
			        
			        //Fechando tela de login
			        principal.getPrimaryStage().close();
			        
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}else{
				System.out.println("Erro de autenticação");
			}
		}else{
			//Tela de usuário
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
    
    @FXML
    private void initialize() {
    	
    }
	
}
