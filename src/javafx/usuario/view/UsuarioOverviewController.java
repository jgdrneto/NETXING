package javafx.usuario.view;

import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.modelos.Video;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import projeto.dao.DAO;

public class UsuarioOverviewController {
	
	private Stage userStage;
	
	@FXML
	private TextField pesquisaFilmes;
	
	@FXML
	private TextField pesquisaSeries;
	
	@FXML
	private TextField pesquisaVideos;
	
	//---------------------------------------------------------------------------
	
	@FXML
	private TableView<javafx.modelos.Video> tb_Filmes;
	
	@FXML
	private TableColumn<javafx.modelos.Video, String> tb_Filmes_Nome;
	@FXML
	private TableColumn<javafx.modelos.Video, String> tb_Filmes_Categoria;
	@FXML
	private TableColumn<javafx.modelos.Video, Number> tb_Filmes_Ano;
	
	private ObservableList<javafx.modelos.Video> filmesData = FXCollections.observableArrayList();

	//---------------------------------------------------------------------------
	
	@FXML
	private TableView<javafx.modelos.Video> tb_Series;
	
	@FXML
	private TableColumn<javafx.modelos.Video, String> tb_Series_Nome;
	@FXML
	private TableColumn<javafx.modelos.Video, String> tb_Series_Temporada;
			
	private ObservableList<javafx.modelos.Video> seriesData = FXCollections.observableArrayList();

	//---------------------------------------------------------------------------
		
	@FXML
	private TableView<javafx.modelos.Video> tb_Videos;
		
	@FXML
	private TableColumn<javafx.modelos.Video, String> tb_Videos_Nome;
	@FXML
	private TableColumn<javafx.modelos.Video, String> tb_Videos_Descricao;
	@FXML
	private TableColumn<javafx.modelos.Video, String> tb_Videos_Categoria;
		
	private ObservableList<javafx.modelos.Video> videosData = FXCollections.observableArrayList();
	
	//---------------------------------------------------------------------------
	
	public UsuarioOverviewController() {
		
		videosData = FXCollections.observableArrayList();
		
		List<projeto.modelos.Video> listaVideoBD = DAO.ACAO.listar(projeto.modelos.Video.class);
		
		for(projeto.modelos.Video vdBD : listaVideoBD){
			videosData.add(new javafx.modelos.Video(vdBD));
		}

	}
	
	public void setUserStage(Stage n_stage){
		this.userStage = n_stage;
	}
	
	public Stage getUserStage(){
		return this.userStage;
	}
	
	@FXML
	private void initialize() {
		//Tabela de vídeos.
		tb_Videos_Nome.setCellValueFactory(cellData -> cellData.getValue().getNomeProperty());
		tb_Videos_Descricao.setCellValueFactory(cellData -> cellData.getValue().getDescricaoProperty());
		tb_Videos_Categoria.setCellValueFactory(cellData -> cellData.getValue().getCategoriaProperty());
		
		//Tabela de filmes.
		tb_Filmes_Nome.setCellValueFactory(cellData -> cellData.getValue().getNomeProperty());
		tb_Filmes_Categoria.setCellValueFactory(cellData -> cellData.getValue().getCategoriaProperty());
		tb_Filmes_Ano.setCellValueFactory(cellData -> cellData.getValue().getAnoProperty());
		
		//Inicializando tabelas.
		tb_Videos.setItems(videosData);
		tb_Filmes.setItems(filmesData);
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
	
	public ObservableList<javafx.modelos.Video> getVideosData() {
		return videosData;
	}
	
	
	public ObservableList<javafx.modelos.Video> getFilmesData() {
		return filmesData;
	}
	
	
	
	
	
	
	

}
