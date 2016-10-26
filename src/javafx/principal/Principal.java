package javafx.principal;

import java.io.IOException;

import hibernate.conexao.HibernateUtil;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.principal.view.InicioOverviewController;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Principal extends Application {
	
	private Stage primaryStage;
	private BorderPane rootLayout;
	
	/*
	 * Descrição: Finalizando conexão com o banco de dados
	 */
	private static void fim(){
		HibernateUtil.getSessionFactory().close();
	}
		
	public void showInicioOverview(){ 
		 try {
			 // Carrega o inicio overview.
	         FXMLLoader loader = new FXMLLoader();
	         loader.setLocation(Principal.class.getResource("view/InicioOverview.fxml"));
	         AnchorPane inicioOverview = (AnchorPane) loader.load();
	            
	         rootLayout = new BorderPane();
	            
	         rootLayout.setPrefSize(inicioOverview.getPrefWidth(), inicioOverview.getPrefHeight());
	            
	         // Define o inicio overview dentro do root layout.
	         rootLayout.setCenter(inicioOverview);
	         
	         // Dá ao controlador acesso à the main app.
	         InicioOverviewController controller = loader.getController();
	         controller.setPrincipal(this);
	            
		 } catch (IOException e) {
			 e.printStackTrace();
	     }
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		this.primaryStage = primaryStage;
	    this.primaryStage.setTitle("Login - NETXING™");
	    
        this.primaryStage.getIcons().add(new Image("file:resources/Chingling_BW.gif"));

        showInicioOverview();
        
        Scene scene = new Scene(rootLayout);
        this.primaryStage.setScene(scene);
        this.primaryStage.setResizable(false);
        this.primaryStage.show();
        
	}
	
	/*
	 * Descrição: Método principal da aplicação
	 * 
	 * @params String[] : Argumentos passados por parâmetros na execução
	 */
	public static void main(String[] args) {
	
		launch(args);
		
		//Fecha conexão com o banco
		fim();
	}

	/**
     * Retorna o palco principal.
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }
	    
}
