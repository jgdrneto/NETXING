package javafx.adm.view;

import java.io.IOException;

import javafx.adm.view.cadastrar.CadCategoriaDialogController;
import javafx.adm.view.cadastrar.CadSerieDialogController;
import javafx.adm.view.cadastrar.CadUsuarioDialogController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.modelos.ControllerAdm;
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
	
	private <T extends ControllerAdm> void abrirDialog(String arquivoFXML, String titulo, T controller){
		 try {
        	 // Carrega o arquivo fxml e cria um novo stage para a janela popup.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(AdmRootLayoutController.class.getResource("cadastrar/"+arquivoFXML));
			AnchorPane page = (AnchorPane) loader.load();
			
			Stage dialogStage = new Stage();
	        dialogStage.setTitle(titulo);
	        dialogStage.setResizable(false);
	        dialogStage.initModality(Modality.WINDOW_MODAL);
	        dialogStage.initOwner(admController.getAdmStage());
	        Scene scene = new Scene(page);
	        dialogStage.setScene(scene);
	       
	        T controlador = loader.getController();
	        
	        controlador.setAdmRootLayoutController(this);
	        controlador.setAdmController(admController);
	        controlador.setStage(dialogStage);
	        
	        dialogStage.showAndWait();
	        
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@FXML
	public void cadastrarUsuario(){
		abrirDialog("CadUsuarioDialog.fxml", "Cadastrar Usuário", new CadUsuarioDialogController());
	}
	
	@FXML
	public void cadastrarSerie(){
       abrirDialog("CadSerieDialog.fxml", "Cadastrar Série", new CadSerieDialogController());
	}
	
	@FXML
	public void cadastrarCategoria(){
       abrirDialog("CadCategoriaDialog.fxml", "Cadastrar Categoria", new CadCategoriaDialogController());
	}
	
}
