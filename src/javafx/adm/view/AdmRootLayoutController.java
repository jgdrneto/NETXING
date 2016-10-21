package javafx.adm.view;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.principal.view.InicioOverviewController;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AdmRootLayoutController {
	
	InicioOverviewController inicioController;
	AdmOverviewController admController;
	
	
	public void setInicioOverviewController(InicioOverviewController c){
		inicioController = c;
	}
	
	@FXML
	public void logoff(){
		inicioController.clear();
		
		inicioController.getPrincipal().getPrimaryStage().show();
		
		admController.getAdmStage().close();
	}

	public void setAdmOverviewController(AdmOverviewController controller) {
		this.admController=controller;
	}
	
	@FXML
	private void initialize() {
		
	}
	
	@FXML
	private void cadastrarUsuario(){
        try {
        	 // Carrega o arquivo fxml e cria um novo stage para a janela popup.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(AdmRootLayoutController.class.getResource("CadUsuarioDialog.fxml"));
			AnchorPane page = (AnchorPane) loader.load();
			
			Stage dialogStage = new Stage();
	        dialogStage.setTitle("Cadastrar usuário");
	        dialogStage.initModality(Modality.WINDOW_MODAL);
	        dialogStage.initOwner(admController.getAdmStage());
	        Scene scene = new Scene(page);
	        dialogStage.setScene(scene);
	        
	        CadUsuarioDialogController cadUsuarioControlador = loader.getController();
	        
	        cadUsuarioControlador.setAdmController(admController);
	        cadUsuarioControlador.setDialogStage(dialogStage);
	        
	        dialogStage.showAndWait();
	        
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
