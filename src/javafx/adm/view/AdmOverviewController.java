package javafx.adm.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.principal.Principal;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import projeto.dao.DAO_HIB;
import projeto.modelos.Usuario;

public class AdmOverviewController {
	
	Principal principal;
	
	Usuario usuario;
	
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
	private TableView<javafx.modelos.Usuario> tb_Usuario;
	
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

	public void setPrincipal(Principal principal) {
		this.principal = principal;
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
	     tb_Usuario.setItems(usuariosData);
	     
	 }
}