package javafx.modelos;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import projeto.dao.DAO;

public class Serie {
	
	private projeto.modelos.Serie serieBD;
	private StringProperty nome;
	
	public Serie(String nNome, String NomeArquivo) {
		this.nome = new SimpleStringProperty(nNome);
		
		projeto.modelos.Serie serie = new projeto.modelos.Serie(nNome, NomeArquivo);
		
		DAO.ACAO.salvar(serie);

        serieBD = serie;
	}
	
	public Serie(projeto.modelos.Serie nSerie) {
		serieBD = nSerie;
		this.nome = new SimpleStringProperty(nSerie.getNome());
	}
	
	public String getNome() {
		return nome.get();
	}
	
	public StringProperty getNomeProperty() {
		return nome;
	}
	
	public String getNomeImagem(){
		return serieBD.getImagem();
	}
	
	public void setNome(String nome) {
		this.nome.set(nome);
		
		serieBD.setNome(nome);
		
		DAO.ACAO.atualizar(serieBD);
	}
	
	public void setNomeImagem(String NomeImagem){
		serieBD.setImagem(NomeImagem);
		
		DAO.ACAO.atualizar(serieBD);
	}

	public projeto.modelos.Serie getSerieBD() {
		return serieBD;
	}
	
	
	
}
