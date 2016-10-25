package javafx.adm.view;

import java.io.IOException;
import java.net.URL;

import javafx.adm.tabelas.categorias.TabCategoriaController;
import javafx.adm.view.cadastrarAtualizar.CadCategoriaDialogController;
import javafx.adm.view.cadastrarAtualizar.CadSerieDialogController;
import javafx.adm.view.cadastrarAtualizar.CadUsuarioDialogController;
import javafx.adm.view.cadastrarAtualizar.CadVideoDialogController;
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
	
	private <T extends ControllerAdm> void abrirDialog(URL arquivoFXML, String titulo, T controller){
		 try {
        	 // Carrega o arquivo fxml e cria um novo stage para a janela popup.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(arquivoFXML);
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
		abrirDialog(AdmRootLayoutController.class.getResource("cadastrarAtualizar/CadUsuarioDialog.fxml"), "Cadastrar Usuário", new CadUsuarioDialogController());
	}
	
	@FXML
	public void cadastrarSerie(){
        abrirDialog(AdmRootLayoutController.class.getResource("cadastrarAtualizar/CadSerieDialog.fxml"),
                "Cadastrar Série", new CadSerieDialogController());
	}
	
	@FXML
	public void cadastrarCategoria(){
        abrirDialog(AdmRootLayoutController.class.getResource("cadastrarAtualizar/CadCategoriaDialog.fxml"),
                "Cadastrar Categoria", new CadCategoriaDialogController());
	}
	
	@FXML
	public void cadastrarVideo(){
        abrirDialog(AdmRootLayoutController.class.getResource("cadastrarAtualizar/CadVideoDialog.fxml"),
                "Cadastrar Video", new CadVideoDialogController());
	}
	
    @FXML
    public void atualizarCategoria() {
        abrirDialog(TabCategoriaController.class.getResource("TabCategoria.fxml"), "Editar Categoria",
                new TabCategoriaController());
    }

}
