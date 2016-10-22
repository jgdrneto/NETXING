package javafx.adm.view.cadastrarAtualizar;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javafx.adm.view.AdmOverviewController;
import javafx.fxml.FXML;
import javafx.modelos.ControllerAdm;
import javafx.modelos.Serie;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;
import projeto.dao.DAO;

public class CadSerieDialogController extends ControllerAdm{
		
	@FXML
	private TextField nome;
	
	@FXML
	private Button abrirArquivo;
	
	private String nomeImagem;
	private File arquivo;
	
	private javafx.modelos.Serie serie;
	
    public Serie getSerie() {
		return serie;
	}

	public void setSerie(Serie serie) {
		this.serie = serie;
	}
	
	@FXML
	public void BotaoCancelar(){
    	this.getStage().close();
    }
    
    private void cadastrar(){
    	if(validarOperacaoCadastrar()){
    		
    		try {
    			
    			AdmOverviewController.copyFile(arquivo, new File("imagens/"+ nome.getText()+arquivo.getName().substring(arquivo.getName().lastIndexOf("."))));
        		
        		javafx.modelos.Serie s = new Serie(nome.getText(), nomeImagem);
    			
    			DAO.ACAO.salvar(s.getSerieBD());
        		
        		this.getStage().close();
    							
			} catch (IOException e) {
				System.out.println("Erro na cópia de arquivo");
			}
    	
    	}
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
    	
    	this.getStage().close();
    }
    
    private void atualizar() {
    	if(validarOperacaoAtualizar()){
    		
    		for(javafx.modelos.Video v : this.getAdmController().getVideosData()){
    			if(v.getSerie().equals(serie.getNome())){
    				v.setNome(nome.getText());
    				
    				v.getSerieBD().setImagem(nomeImagem);
    				
    				DAO.ACAO.atualizar(v.getSerieBD());
    			}
    		}
    		
    		serie.setNome(nome.getText());
    		serie.setNomeImagem(nomeImagem);
    		
    		
    		
    	}
	}

	private boolean validarOperacaoAtualizar() {
		
		if(!nome.getText().equals("")){
			if(!contemSerie(DAO.ACAO.listar(projeto.modelos.Serie.class), nome.getText()) || nome.getText().equals(serie.getNome())){
				if(nomeImagem!=null){
					return true;
				}else{
					
					nomeImagem = serie.getNomeImagem();
					abrirArquivo.setText(nomeImagem.substring(nomeImagem.lastIndexOf("/")));		
							
					abrirArquivo.requestFocus();
				}
			}else{
				alerta("Série já existente", "Nome de śerie inválido", "Nome da série já existente, digite um outro nome para a śerie");
				
    			nome.setText("");

    			nome.requestFocus();
			}
		}else{
			nome.requestFocus();
		}
		
		return false;
	}

	@FXML
    private void abrirArquivo() {
		
    	FileChooser fCImagem = new FileChooser();
    	
    	FileChooser.ExtensionFilter extensoes = new FileChooser.ExtensionFilter("Arquivos de imagens (*.png, *.jpg, *.bmp)", "*.png","*.jpg","*.bmp");
		
    	fCImagem.getExtensionFilters().add(extensoes);
    	
    	File file = fCImagem.showOpenDialog(this.getStage());
    	
    	if(file!=null){

    		arquivo = file;
    			
    		abrirArquivo.setText(file.getName());
    		
    		nomeImagem = "imagens/"+nome.getText()+arquivo.getName().substring(arquivo.getName().lastIndexOf("."));
    	}	
	}
    
	private boolean validarOperacaoCadastrar() {
		
    	if(!nome.getText().equals("")){
    		if(!contemSerie(DAO.ACAO.listar(projeto.modelos.Serie.class), nome.getText())){
    			if(nomeImagem!=null){		
	    			return true;
	    		}else{
	    			abrirArquivo.requestFocus();
	    		}	
    		}else{
    			alerta("Série já existente", "Nome de śerie inválido", "Nome da série já existente, digite um outro nome para a śerie");
				
    			nome.setText("");
    			abrirArquivo.setText("Escolher Imagem");	
    			arquivo = null;
    			nomeImagem = null;
    			
    			nome.requestFocus();
    		}
    	}else{
    		nome.requestFocus();
    	}
    	
    	return false;
	}
    
    
    private boolean contemSerie(List<projeto.modelos.Serie> serieData, String text) {
		
    	for(projeto.modelos.Serie s : serieData){
    		if(s.getNome().equals(text)){
    			return true;
    		}
    	}
    	
		return  false;
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
		if(serie!=null){
			nome.setText(serie.getNome());
			nomeImagem = serie.getNomeImagem();
			abrirArquivo.setText(nomeImagem.substring(nomeImagem.lastIndexOf("/")));
		}
    }
}
