package javafx.modelos;

import javafx.adm.view.AdmOverviewController;
import javafx.adm.view.AdmRootLayoutController;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public abstract class ControllerAdm {
	
	public enum ACAO{
		CADASTRAR,
		ATUALIZAR
	}
	
	private ACAO acao;
	
	private Stage stage;
	
	private AdmOverviewController admController;
	
	private AdmRootLayoutController admRootLayoutController;
	
	
	
	public ACAO getAcao() {
		return acao;
	}

	public void setAcao(ACAO acao) {
		this.acao = acao;
	}

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

        this.stage.getIcons().add(new Image("file:resources/Chingling_BW.gif"));

	}

	public AdmOverviewController getAdmController() {
		return admController;
	}

	public void setAdmController(AdmOverviewController nAdmController) {
		this.admController = nAdmController;
	}
	
	
	
}
