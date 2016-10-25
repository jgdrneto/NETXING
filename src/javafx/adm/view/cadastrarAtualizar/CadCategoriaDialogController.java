package javafx.adm.view.cadastrarAtualizar;

import java.util.List;

import javafx.fxml.FXML;
import javafx.modelos.Categoria;
import javafx.modelos.ControllerAdm;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import projeto.dao.DAO;

public class CadCategoriaDialogController extends ControllerAdm{
		
	@FXML
	private TextField nome;
	   
	private javafx.modelos.Categoria categoria;

    public CadCategoriaDialogController() {
    	this.setAcao(ACAO.CADASTRAR);
	}
	
    public void BotaoCancelar(){
    	this.getStage().close();
    }
    
    public void setCategoria(Categoria nCategoria) {
        categoria = nCategoria;
        
        nome.setText(nCategoria.getNome());

        this.setAcao(ACAO.ATUALIZAR);
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

            for (javafx.modelos.Video v : getAdmController().getVideosData()) {
                if (v.getCategoria().equals(categoria.getNome())) {
                    v.setCategoria(nome.getText());
                }
            }

            categoria.setNome(nome.getText());

            this.getStage().close();
		}
		
	}

	private boolean validarOperacaoAtualizar() {
		
		if(!nome.getText().equals("")){
			if(!contemCategoria(DAO.ACAO.listar(projeto.modelos.Categoria.class), nome.getText()) || nome.getText().equals(categoria.getNome())){
				return true;
			}else{
				alerta("Categoria já existente", "Nome de categoria inválido", "Nome da categoria já existente, digite um outro nome para a categoria");
				
    			nome.setText(categoria.getNome());
    			    			
    			nome.requestFocus();
			}
		}else{
			nome.requestFocus();
		}
		
		return false;
	}

	private void cadastrar() {
		
	   	if(validarOperacaoCadastrar()){

        	javafx.modelos.Categoria c = new javafx.modelos.Categoria(nome.getText());
    			
    		DAO.ACAO.salvar(c.getCategoriaBD());
        		
        	this.getStage().close();    	
    	}
    	
		
	}
        
	private boolean validarOperacaoCadastrar() {
		
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
