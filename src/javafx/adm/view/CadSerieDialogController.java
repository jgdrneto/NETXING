package javafx.adm.view;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.modelos.ControllerAdm;
import javafx.modelos.Serie;
import javafx.modelos.Usuario;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import projeto.dao.DAO;

public class CadSerieDialogController extends ControllerAdm{
		
	@FXML
	private TextField nome;
	
	@FXML
	private Button abrirArquivo;
	
	private String nomeImagem;
	private File arquivo;
	    
    public void BotaoCancelar(){
    	this.getStage().close();
    }
    
    public void BotaoSalvar(){
    	    	
    	if(validarOperacao()){

    		try {
    			
    			AdmOverviewController.copyFile(arquivo, new File("imagens/"+ nome.getText()+arquivo.getName().substring(arquivo.getName().lastIndexOf("."))));
        		
        		projeto.modelos.Serie s = new projeto.modelos.Serie(nome.getText(), nomeImagem);
    			
    			DAO.ACAO.salvar(s);
        		
        		this.getStage().close();
    							
			} catch (IOException e) {
				System.out.println("Erro na cópia de arquivo");
			}
    	
    	}
    	
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
    
	private boolean validarOperacao() {
		
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
		
    }
}
