package javafx.adm.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.modelos.Video;
import javafx.principal.Principal;
import javafx.principal.view.InicioOverviewController;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import projeto.dao.DAO_HIB;
import projeto.modelos.Usuario;

public class AdmOverviewController {
	
	private InicioOverviewController telaLogin;
	
	private Stage admStage;
	
	private Usuario usuario;
	
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
	
	private ObservableList<javafx.modelos.Usuario> usuariosData;
	
	//---------------------------------------------------------------------------
	
	@FXML
	private TextField pesquisaVideos;
	
	@FXML
	private TextField pesquisaUsuario;
	
	//---------------------------------------------------------------------------
	
	
	public AdmOverviewController(){
		
		usuariosData = FXCollections.observableArrayList();
		
		for(Usuario usuBD : DAO_HIB.USUARIO.listaDeUsuarios()){
			usuariosData.add(new javafx.modelos.Usuario(usuBD));
		}
		
		videosData = FXCollections.observableArrayList();
		
		for(projeto.modelos.Video vidBD : DAO_HIB.VIDEO.listaDeVideos()){
			videosData.add(new javafx.modelos.Video(vidBD));
		}
		
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public void setAdmStage(Stage nStage) {
		this.admStage = nStage;
	}
	
	public void setInicioOverviewController(InicioOverviewController controllerLogin) {
		this.telaLogin = controllerLogin;
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
		 if(pesquisaUsuario.getText().isEmpty()){
			 tb_Usuarios.setItems(usuariosData);
		 }else{
			 tb_Usuarios.setItems(listaDePesquisaUsuarios());
		 }
	}

	private ObservableList<javafx.modelos.Usuario> listaDePesquisaUsuarios() {
		
		String textoDigitado = pesquisaUsuario.getText();
		
		ObservableList<javafx.modelos.Usuario> listaDePesquisa = FXCollections.observableArrayList();
		
		for(javafx.modelos.Usuario u : usuariosData){
			if(u.getLogin().startsWith(textoDigitado)){
				listaDePesquisa.add(u);
			}
		}
		
		return listaDePesquisa;
	}
	
}