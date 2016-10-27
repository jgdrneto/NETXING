package javafx.adm.view;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.FileChannel;
import java.util.List;

import javafx.adm.view.cadastrarAtualizar.CadUsuarioDialogController;
import javafx.adm.view.cadastrarAtualizar.CadVideoDialogController;
import javafx.adm.view.detalhes.VideoDetalhesController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.modelos.ControllerAdm;
import javafx.modelos.Video;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
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
    public void pressionarBotaoTb_Videos() {

        tb_Videos.setOnKeyReleased(
                new EventHandler<KeyEvent>() {

                    @Override
                    public void handle(KeyEvent arg0) {
                        // TODO Auto-generated method stub
                        if (tb_Videos.getSelectionModel().getSelectedIndex() >= 0) {
                            switch (arg0.getCode()) {
                                case A:
                                    abrirDialog(CadVideoDialogController.class.getResource("CadVideoDialog.fxml"), "Editar Vídeos",
                                            tb_Videos.getSelectionModel().getSelectedItem());
                                    break;
                                case D:
                                    System.out.println("não ta entrando aqui?");
                                    deletarVideo();
                                    break;

                                default:

                                    break;
                            }
                        }
                    }
                });
    }

    private void deletarVideo() {

        javafx.modelos.Video v = tb_Videos.getSelectionModel().getSelectedItem();

        videosData.remove(v);

        DAO.ACAO.deletar(v.getVideoBD());

    }

	@FXML
    public void pressionarBotaoTb_Usuarios() {
		
        tb_Usuarios.setOnKeyReleased(
			new EventHandler<KeyEvent>() {

	        @Override
	        public void handle(KeyEvent arg0) {
	            // TODO Auto-generated method stub
                        if (tb_Usuarios.getSelectionModel().getSelectedIndex() >= 0) {
                            switch (arg0.getCode()) {
                                case A:
                                    abrirDialog(CadUsuarioDialogController.class.getResource("CadUsuarioDialog.fxml"), "Editar Usuários",
                                            tb_Usuarios.getSelectionModel().getSelectedItem());
                                    break;

                                case D:
                                    deletarUsuario();
                                    break;

                                default:

                                    break;
                            }
                        }
	        }
	    });
	}
	
    private void deletarUsuario() {
        if (tb_Usuarios.getSelectionModel().getSelectedItem().getIdUsuario() != 1) {

            javafx.modelos.Usuario u = tb_Usuarios.getSelectionModel().getSelectedItem();

            usuariosData.remove(u);

            DAO.ACAO.deletar(u.getUsuarioBD());

        } else {
            alerta("Usuário de Administrador", "Não se pode excluir usuário de administrador",
                    "Escolha outro usuário para remover");
        }

    }

	private void alerta(String titulo, String cabecalho, String conteudo){
        Alert alert = new Alert(AlertType.WARNING);
        alert.setTitle(titulo);
        alert.setHeaderText(cabecalho);
        alert.setContentText(conteudo);
        
        alert.showAndWait();
    }
	
    private <T extends ControllerAdm> void abrirDialog(URL arquivoFXML, String titulo, Object objeto) {
        try {
            // Carrega o arquivo fxml e cria um novo stage para a janela popup.
           FXMLLoader loader = new FXMLLoader();
           loader.setLocation(arquivoFXML);
           AnchorPane page = (AnchorPane) loader.load();
           
           Stage dialogStage = new Stage();
           dialogStage.setTitle(titulo);
           dialogStage.setResizable(false);
           dialogStage.initModality(Modality.WINDOW_MODAL);
           dialogStage.initOwner(this.getAdmStage());
           Scene scene = new Scene(page);
           dialogStage.setScene(scene);
          
           T controlador = loader.getController();
           controlador.setAdmRootLayoutController(admRootLayoutController);
           controlador.setAdmController(this);
           controlador.setStage(dialogStage);
           dialogStage.setResizable(false);
           
           if (objeto instanceof javafx.modelos.Video) {
                
                CadVideoDialogController c = (CadVideoDialogController) controlador;
                
                javafx.modelos.Video v = (javafx.modelos.Video)objeto;
                
                c.setVideo(v);
           }else{
               if (objeto instanceof javafx.modelos.Usuario) {
                   
                   CadUsuarioDialogController c = (CadUsuarioDialogController) controlador;
                   
                   javafx.modelos.Usuario u = (javafx.modelos.Usuario)objeto;
                   
                   c.setUsuario(u);
              }
           }
            
            
            
           dialogStage.showAndWait();
           
       } catch (IOException e) {
           // TODO Auto-generated catch block
           e.printStackTrace();
       }
   }
	
	@FXML
	private void duploCliqueVideos(){

		tb_Videos.setOnMouseClicked(new EventHandler<MouseEvent>() {
		    @Override
		    public void handle(MouseEvent mouseEvent) {
		        if(mouseEvent.getButton().equals(MouseButton.PRIMARY)){
		            if(mouseEvent.getClickCount() == 2 && tb_Videos.getSelectionModel().getSelectedIndex()>=0){
		            	
		            	abrirDialogDetalhe("VideoDetalhes.fxml","Detalhe do vídeo"); 
		            }
		        }
		    }
		});

	}
	
	private void abrirDialogDetalhe(String arquivoFXML, String titulo){
		 try {
       	 // Carrega o arquivo fxml e cria um novo stage para a janela popup.
			FXMLLoader loader = new FXMLLoader();
            loader.setLocation(VideoDetalhesController.class.getResource(arquivoFXML));
			AnchorPane page = (AnchorPane) loader.load();
			
			Stage dialogStage = new Stage();
	        dialogStage.setTitle(titulo);
	        dialogStage.setResizable(false);
	        dialogStage.initModality(Modality.WINDOW_MODAL);
	        dialogStage.initOwner(this.getAdmStage());
	        Scene scene = new Scene(page);
	        dialogStage.setScene(scene);
	        
	        VideoDetalhesController controlador = loader.getController();
	        controlador.setAdmController(this);
	        controlador.setStage(dialogStage);
	        controlador.setVideo(tb_Videos.getSelectionModel().getSelectedItem());
	        
	        dialogStage.showAndWait();
	        
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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