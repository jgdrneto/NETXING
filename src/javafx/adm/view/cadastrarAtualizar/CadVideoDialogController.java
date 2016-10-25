package javafx.adm.view.cadastrarAtualizar;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javafx.adm.view.AdmOverviewController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.modelos.ControllerAdm;
import javafx.modelos.Video;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import projeto.dao.DAO;

public class CadVideoDialogController extends ControllerAdm{
	
	@FXML
	private TextField nome;
	@FXML
	private TextField ano;
	@FXML
	private TextArea descricao;
	@FXML
	private TextField diretor;
	@FXML
	private TextField atorPrincipal;
	@FXML
	private TextField temporada;
	@FXML
	private ChoiceBox<Integer> idade;
	@FXML
	private ChoiceBox<projeto.modelos.Serie> series;
	@FXML
	private ChoiceBox<projeto.modelos.Categoria> categorias;
	@FXML
	private Button escolherVideo;
	@FXML
	private Button escolherImagem;
	
	ObservableList<Integer> idades = FXCollections.observableArrayList();
	
	ObservableList<projeto.modelos.Categoria> lCategoriasBD = FXCollections.observableArrayList();
	
	ObservableList<projeto.modelos.Serie> lSeriesBD = FXCollections.observableArrayList();
	
	String caminhoVideo;
	
	String caminhoImagem;
	
	File arquivoVideo;
	
	File arquivoImagem;
	
	Integer intAno;
	
	Video video;
	
    public CadVideoDialogController() {
		this.setAcao(ACAO.CADASTRAR);
	}
    
    public void setVideo(Video nVideo) {
        this.video = nVideo;
        this.setAcao(ACAO.ATUALIZAR);

        nome.setText(video.getNome());
        ano.setText(video.getAno().toString());
        descricao.setText(video.getDescricao());
        diretor.setText(video.getDiretor());
        atorPrincipal.setText(video.getAtorPrincipal());
        temporada.setText(video.getTemporada());
        idade.setValue(video.getFaixaEtaria());
        escolherVideo.setText(video.getVideo().substring(video.getVideo().lastIndexOf("/") + 1));
        escolherImagem.setText(video.getImagem().substring(video.getImagem().lastIndexOf("/") + 1));
        intAno = video.getAno();
        caminhoImagem = video.getImagem();
        caminhoVideo = video.getVideo();
        series.setValue(video.getSerieBD());
        categorias.setValue(video.getCategoriaBD());

    }
    
	public void BotaoCancelar(){
    	this.getStage().close();
    }
    
    @FXML
    public void BotaoSalvar(){
	 	
    	switch(this.getAcao()){
    		case CADASTRAR :
    			cadastrar();
    		break;
    		case ATUALIZAR:
    			atualizar();
    		break;	
    	}
    	
    }
    
    private void atualizar() {
    	
    	if(validarOperacaoAtualizar()){
    		
    		try {
    			if(!caminhoVideo.equals(video.getVideo())){
    				AdmOverviewController.copyFile(arquivoVideo, new File ("videos/"+nome.getText()+arquivoVideo.getName().substring(arquivoVideo.getName().lastIndexOf("."))));
    			}
				if(!caminhoImagem.equals(video.getImagem())){
					AdmOverviewController.copyFile(arquivoImagem, new File("imagens/videos/"+arquivoImagem.getName().substring(arquivoImagem.getName().lastIndexOf("."))));
				}
				
				video.setAno(intAno);
	    		video.setNome(nome.getText());
	    		video.getVideoBD().setSerie(series.getValue());
	    		video.getVideoBD().setCategoria(categorias.getValue());
	    		video.setArquivoVideo(caminhoVideo);
	    		video.setImagem(caminhoImagem);
	    		video.setDescricao(descricao.getText());
	    		video.setDiretor(diretor.getText());
	    		video.setAtorPrincipal(atorPrincipal.getText());
	    		video.setFaixaEtaria(idade.getValue());
	    		video.setTemporada(temporada.getText());
	    		
	    		DAO.ACAO.atualizar(video.getVideoBD());

                this.getStage().close();

    		} catch (IOException e) {
    			System.out.println("Erro na cópia de arquivo");
			}
    		
    		
    	}
		
	}

	private boolean validarOperacaoAtualizar() {
		if(!nome.getText().equals("")){
			if(!contemNome(this.getAdmController().getVideosData(), nome.getText()) || nome.getText().equals(video.getNome()) ){
				if(series.getValue()!=null){
					if(idade.getValue()!=null){
						if(categorias.getValue()!=null){
							if(caminhoVideo!=null){
								if(!descricao.getText().equals("")){
									if(!diretor.getText().equals("")){
										if(!temporada.getText().equals("")){
											try{
												intAno = Integer.parseInt(ano.getText());
												
												return true;
											}catch(NumberFormatException e){
												ano.setText(video.getAno().toString());
												ano.requestFocus();
											}
										}else{
											temporada.setText(video.getTemporada());
											
											temporada.requestFocus();
										}
									}else{
										
										diretor.setText(video.getDiretor());
										
										diretor.requestFocus();
									}
								}else{
									
									descricao.setText(video.getDescricao());
									
									descricao.requestFocus();
								}
							}else{
								
								escolherVideo.setText(video.getVideo().substring(video.getVideo().lastIndexOf("/")));
								
								escolherVideo.requestFocus();
							}
						}else{
							
							categorias.setValue(video.getCategoriaBD());
							
							categorias.requestFocus();
						}	
					}else{
						
						idade.setValue(video.getFaixaEtaria());
						
						idade.requestFocus();
					}
					
				}else{
					series.setValue(video.getSerieBD());
					
					series.requestFocus();
				}
			}else{
				alerta("Nome de vídeo ja existente", "Nome já cadastrado", "Pro favor, use outro nome para o vídeo");
				
				nome.setText(video.getNome());
				
				nome.requestFocus();
			}
		}else{
			
		}
    	return false;
    	
	}

	private void cadastrar() {
		if(validarOperacaoCadastrar()){
						
			try{
				
				AdmOverviewController.copyFile(arquivoVideo, new File ("videos/"+nome.getText()+arquivoVideo.getName().substring(arquivoVideo.getName().lastIndexOf("."))));
				
				if(caminhoImagem!=null){
					AdmOverviewController.copyFile(arquivoImagem, new File("imagens/videos/"+arquivoImagem.getName().substring(arquivoImagem.getName().lastIndexOf("."))));
				}else{
					caminhoImagem = series.getValue().getImagem(); 
				}
				
				javafx.modelos.Video v = new Video(categorias.getValue(),
						  series.getValue(),
						  nome.getText(),
						  descricao.getText(),
						  intAno,
						  diretor.getText(),
						  atorPrincipal.getText(),
						  idade.getValue(),
						  temporada.getText(),
						  caminhoVideo,
						  caminhoImagem);
				
				this.getAdmController().getVideosData().add(v);
				
                this.getStage().close();

			} catch (IOException e) {
    			System.out.println("Erro na cópia de arquivo");
			}
        } else {
            System.out.println("Entrando aqui não");
		}
		
	}

	private boolean validarOperacaoCadastrar() {
		
		if(!contemNome(this.getAdmController().getVideosData(), nome.getText()) && !nome.getText().equals("")){
			if(series.getValue()!=null){
				if(idade.getValue()!=null){
					if(categorias.getValue()!=null){
						if(caminhoVideo!=null){
							if(!descricao.getText().equals("")){
								if(!diretor.getText().equals("")){
									if(!temporada.getText().equals("")){
										try{
											intAno = Integer.parseInt(ano.getText());
											
											return true;
										}catch(NumberFormatException e){
											ano.setText("");
											ano.requestFocus();
										}
									}else{
										temporada.requestFocus();
									}
								}else{
									diretor.requestFocus();
								}
							}else{
								descricao.requestFocus();
							}
						}else{
							escolherVideo.requestFocus();
						}
					}else{
						categorias.requestFocus();
					}	
				}else{
					idade.requestFocus();
				}
				
			}else{
				series.requestFocus();
			}
		}else{
			alerta("Nome de vídeo ja existente", "Nome já cadastrado", "Pro favor, use outro nome para o vídeo");
			
			nome.setText("");
			
			nome.requestFocus();
		}
		
    	return false;
    	
	}
    
    @FXML
    private void escolherVideo(){
    	FileChooser fCImagem = new FileChooser();
    	
    	FileChooser.ExtensionFilter extensoes = new FileChooser.ExtensionFilter("Arquivos de vídeos (*.mp4, *.avi", "*.mp4","*.avi");
		
    	fCImagem.getExtensionFilters().add(extensoes);
    	
    	File file = fCImagem.showOpenDialog(this.getStage());
    	
    	if(file!=null){

    		arquivoVideo = file;
    			
    		escolherVideo.setText(file.getName());
    		
    		caminhoVideo = "videos/"+nome.getText()+arquivoVideo.getName().substring(arquivoVideo.getName().lastIndexOf("."));
    	}
    }
    
    @FXML
    private void escolherImagem(){
    	FileChooser fCImagem = new FileChooser();
    	
    	FileChooser.ExtensionFilter extensoes = new FileChooser.ExtensionFilter("Arquivos de imagens (*.png, *.jpg, *.bmp)", "*.png","*.jpg","*.bmp");
		
    	fCImagem.getExtensionFilters().add(extensoes);
    	
    	File file = fCImagem.showOpenDialog(this.getStage());
    	
    	if(file!=null){

    		arquivoImagem = file;
    			
    		escolherImagem.setText(file.getName());
    		
    		caminhoImagem = "imagens/videos/"+nome.getText()+arquivoImagem.getName().substring(arquivoImagem.getName().lastIndexOf("."));
    	}	
    }
    
    private boolean contemNome(ObservableList<Video> videosData, String text) {
		
    	for(Video v : videosData){
    		if(v.getNome().equals(text)){
    			return true;
    		}
    	}
    	
		return false;
	}

	private void alerta(String titulo, String cabecalho, String conteudo){
		Alert alert = new Alert(AlertType.WARNING);
        alert.setTitle(titulo);
        alert.setHeaderText(cabecalho);
        alert.setContentText(conteudo);
        
        alert.showAndWait();
	}
    
	@FXML
    private void initialize(){
		
		for(int i=1;i<=130;i++){
    		idades.add(i);
    	}
    	
    	idade.setItems(idades);
    	
    	List<projeto.modelos.Categoria> lCategoriasBD = DAO.ACAO.listar(projeto.modelos.Categoria.class);
    	List<projeto.modelos.Serie> lSeriesBD = DAO.ACAO.listar(projeto.modelos.Serie.class);
    	
    	this.lCategoriasBD.addAll(lCategoriasBD);
    	this.lSeriesBD.addAll(lSeriesBD);

    	categorias.setItems(this.lCategoriasBD);
    	series.setItems(this.lSeriesBD);
    }
}
