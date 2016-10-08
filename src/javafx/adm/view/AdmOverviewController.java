package javafx.adm.view;

import javafx.fxml.FXML;
import javafx.principal.Principal;
import javafx.scene.control.TableView;
import projeto.modelos.Usuario;

public class AdmOverviewController {
	
	Principal principal;
	
	Usuario usuario;
	
	
	@FXML
	private TableView<javafx.modelos.Video> tb_Videos;

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public void setPrincipal(Principal principal) {
		this.principal = principal;
	}
		
}
