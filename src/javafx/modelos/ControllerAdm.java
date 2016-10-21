package javafx.modelos;

import javafx.adm.view.AdmOverviewController;
import javafx.stage.Stage;

public abstract class ControllerAdm {
	
	private Stage stage;
	
	private AdmOverviewController admController;

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
