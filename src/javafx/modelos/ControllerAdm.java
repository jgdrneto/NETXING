package javafx.modelos;

import javafx.adm.view.AdmOverviewController;
import javafx.adm.view.AdmRootLayoutController;
import javafx.stage.Stage;

public abstract class ControllerAdm {
	
	private Stage stage;
	
	private AdmOverviewController admController;
	
	private AdmRootLayoutController admRootLayoutController;
	
	public AdmRootLayoutController getAdmRootLayoutController() {
		return admRootLayoutController;
	}

	public void setAdmRootLayoutController(AdmRootLayoutController nAdmRootLayoutController) {
		this.admRootLayoutController = nAdmRootLayoutController;
	}

	public Stage getStage() {
		return stage;
	}

	public void setStage(Stage nStage) {
		stage = nStage;
	}

	public AdmOverviewController getAdmController() {
		return admController;
	}

	public void setAdmController(AdmOverviewController nAdmController) {
		this.admController = nAdmController;
	}
	
	
	
}
