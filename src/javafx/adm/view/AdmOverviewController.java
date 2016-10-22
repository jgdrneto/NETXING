package javafx.adm.view;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.modelos.Usuario;
import javafx.modelos.Video;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import projeto.dao.DAO;

public class AdmOverviewController {
	
	private Stage admStage;
	
	private AdmRootLayoutController admRootLayoutController;
	
	//---------------------------------------------------------------------------
	
	@FXML
	private TextField pesquisaVideos;
		
	@FXML
	private TextField pesquisaUsuarios;
		
	
	//---------------------------------------------------------------------------
	@FXML
	private TableView<javafx.modelos.Video> tb_Videos;
	
	@FXML
	private TableColumn<javafx.modelos.Video, String> tb_Video_Nome;
	@FXML
	private TableColumn<javafx.modelos.Video, String> tb_Video_Serie;
	@FXML
	private TableColumn<javafx.modelos.Video, Number> tb_Video_Ano;
	
	
	private ObservableList<javafx.modelos.Video> videosData = FXCollections.observableArrayList();

	
	//---------------------------------------------------------------------------
	
	@FXML
	private TableView<javafx.modelos.Usuario> tb_Usuarios;
	
	@FXML
	private TableColumn<javafx.modelos.Usuario, String> tb_Usuario_Login;
	@FXML
	private TableColumn<javafx.modelos.Usuario, String> tb_Usuario_Senha;
	@FXML
	private TableColumn<javafx.modelos.Usuario, Number> tb_Usuario_Idade;
	
	private ObservableList<javafx.modelos.Usuario> usuariosData;
	
	//---------------------------------------------------------------------------
	
	public AdmOverviewController(){
		
		usuariosData = FXCollections.observableArrayList();
		
		List<projeto.modelos.Usuario> listaUsuarioBD = DAO.ACAO.listar(projeto.modelos.Usuario.class);
		
		for(projeto.modelos.Usuario usuBD : listaUsuarioBD){
			usuariosData.add(new javafx.modelos.Usuario(usuBD));
		}
		
		List<projeto.modelos.Video> listaVideosBD = DAO.ACAO.listar(projeto.modelos.Video.class);
		
		for(projeto.modelos.Video vidBD : listaVideosBD){
			videosData.add(new javafx.modelos.Video(vidBD));
		}
		
	}

	public AdmRootLayoutController getAdmRootLayoutController() {
		return admRootLayoutController;
	}

	public void setAdmRootLayoutController(AdmRootLayoutController nAdmRootLayoutController) {
		this.admRootLayoutController = nAdmRootLayoutController;
	}

	public void setAdmStage(Stage nStage) {
		this.admStage = nStage;
	}
	
	public Stage getAdmStage(){
		return this.admStage;
	}
	
	@FXML
	private void initialize() {
		//Tabela videos
		tb_Video_Nome.setCellValueFactory(cellData -> cellData.getValue().getNomeProperty());
	    tb_Video_Ano.setCellValueFactory(cellData -> cellData.getValue().getAnoProperty());	
	    tb_Video_Serie.setCellValueFactory(cellData -> cellData.getValue().getSerieProperty());
	     
	    //Tabela usuários
	    tb_Usuario_Login.setCellValueFactory(cellData -> cellData.getValue().getLoginProperty());
	    tb_Usuario_Senha.setCellValueFactory(cellData -> cellData.getValue().getSenhaProperty());
	    tb_Usuario_Idade.setCellValueFactory(cellData -> cellData.getValue().getIdadeProperty());	  
	    //inicializando tabelas
	     
	    tb_Videos.setItems(videosData);
	    tb_Usuarios.setItems(usuariosData);
	    
	}
	
	//Pesquisar vídeos
	@FXML
	public void pesquisarVideos(){
		if(pesquisaVideos.getText().isEmpty()){
			tb_Videos.setItems(videosData);
		}else{
			tb_Videos.setItems(listaDePesquisaVideos());
		}
	}

	private ObservableList<Video> listaDePesquisaVideos() {
		
		String textoDigitado = pesquisaVideos.getText();
		
		ObservableList<Video> listaDePesquisa = FXCollections.observableArrayList();
		
		for(Video v : this.videosData){
			if(v.getNome().startsWith(textoDigitado) 			||
			   v.getCategoria().startsWith(textoDigitado)		||
			   v.getAtorPrincipal().startsWith(textoDigitado)	||
			   v.getSerie().startsWith(textoDigitado)				){
				listaDePesquisa.add(v);
			}
		}
		
		return listaDePesquisa;
	}
	
	//Pesquisar usuários
	@FXML
	public void pesquisarUsuarios(){
		 if(pesquisaUsuarios.getText().isEmpty()){
			 tb_Usuarios.setItems(usuariosData);
		 }else{
			 tb_Usuarios.setItems(listaDePesquisaUsuarios());
		 }
	}

	private ObservableList<javafx.modelos.Usuario> listaDePesquisaUsuarios() {
		
		String textoDigitado = pesquisaUsuarios.getText();
		
		ObservableList<javafx.modelos.Usuario> listaDePesquisa = FXCollections.observableArrayList();
		
		for(javafx.modelos.Usuario u : usuariosData){
			if(u.getLogin().startsWith(textoDigitado)){
				listaDePesquisa.add(u);
			}
		}
		
		return listaDePesquisa;
	}
	
	public void focoPesquisaVideos(){
		pesquisaVideos.requestFocus();
	}
	
	
	
	public ObservableList<javafx.modelos.Video> getVideosData() {
		return videosData;
	}

	public ObservableList<javafx.modelos.Usuario> getUsuariosData() {
		return usuariosData;
	}

	@FXML
	public void pressionarBotao(){
		
		tb_Videos.setOnKeyReleased(
			new EventHandler<KeyEvent>() {

	        @Override
	        public void handle(KeyEvent arg0) {
	            // TODO Auto-generated method stub
	        	if(arg0.getCode()==KeyCode.C){
	        		System.out.println("Imprimiu o C");	
	        	}
	        }
	    });
	}
	
	public static void copyFile(File source, File destination) throws IOException {
        if (destination.exists()){
            destination.delete();
        }
        FileChannel sourceChannel = null;
        FileChannel destinationChannel = null;
        try {
            sourceChannel = new FileInputStream(source).getChannel();
            destinationChannel = new FileOutputStream(destination).getChannel();
            sourceChannel.transferTo(0, sourceChannel.size(),
                    destinationChannel);
        } finally {
            if (sourceChannel != null && sourceChannel.isOpen())
                sourceChannel.close();
            if (destinationChannel != null && destinationChannel.isOpen())
                destinationChannel.close();
       }
   }
	
}