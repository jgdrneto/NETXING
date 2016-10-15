package javafx.adm.view;

import javafx.fxml.FXML;
import javafx.principal.view.InicioOverviewController;

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
}
