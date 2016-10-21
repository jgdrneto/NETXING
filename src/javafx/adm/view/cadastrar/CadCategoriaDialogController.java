package javafx.adm.view.cadastrar;

import java.util.List;

import javafx.fxml.FXML;
import javafx.modelos.ControllerAdm;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

import projeto.dao.DAO;

public class CadCategoriaDialogController extends ControllerAdm{
		
	@FXML
	private TextField nome;
	   
    public void BotaoCancelar(){
    	this.getStage().close();
    }
    
    public void BotaoSalvar(){
    	    	
    	if(validarOperacao()){

        	projeto.modelos.Categoria c = new projeto.modelos.Categoria(nome.getText());
    			
    		DAO.ACAO.salvar(c);
        		
        	this.getStage().close();    	
    	}
    	
    }
        
	private boolean validarOperacao() {
		
    	if(!nome.getText().equals("")){
    		if(!contemCategoria(DAO.ACAO.listar(projeto.modelos.Categoria.class), nome.getText())){
    			return true;
    		}else{
    			alerta("Categoria já existente", "Nome de categoria inválido", "Nome da categoria já existente, digite um outro nome para a categoria");
				
    			nome.setText("");
    			    			
    			nome.requestFocus();
    		}
    	}else{
    		nome.requestFocus();
    	}
    	
    	return false;
	}
    
    
    private boolean contemCategoria(List<projeto.modelos.Categoria> categorias, String text) {
		
    	for(projeto.modelos.Categoria s : categorias){
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
