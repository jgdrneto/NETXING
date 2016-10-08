package testes;

import java.io.IOException;

import javafx.adm.view.AdmOverviewController;
import javafx.fxml.FXMLLoader;
import javafx.principal.view.InicioOverviewController;
import javafx.scene.layout.AnchorPane;

public class testes1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		try {
			FXMLLoader loader = new FXMLLoader();
			System.out.println("URL: " + AdmOverviewController.class.getResource("AdmOverview.fxml"));
	        loader.setLocation(AdmOverviewController.class.getResource("./view/AdmOverview.fxml"));
	        AnchorPane page;
	        
			page = (AnchorPane) loader.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
