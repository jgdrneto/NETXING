package javafx.modelos;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import projeto.dao.DAO_HIB;
import projeto.modelos.Categoria;
import projeto.modelos.Serie;

public class Video{
	
	private Integer idVideo;
	private StringProperty categoria;
	private StringProperty serie;
	private StringProperty nome;
	private StringProperty descricao;
	private IntegerProperty ano;
	private StringProperty diretor;
	private StringProperty atorPrincipal;
	private IntegerProperty faixaEtaria;
	private StringProperty temporada;
	private byte[] arquivoVideo;
	private String extensao;
	
	//Objetos do banco de dados
	private projeto.modelos.Video videoBD;
	private projeto.modelos.Serie serieBD;
	private projeto.modelos.Categoria categoriaBD;
	
	
	public Video(String categoria, String serie, String nome, String descricao, Integer ano, 
			String diretor, String atorPrincipal, Integer faixaEtaria,String temporada, 
			byte[] arquivoVideo, String extensao) {
		
		this.categoria = new SimpleStringProperty(categoria);
		this.serie =  new SimpleStringProperty(serie);
		this.nome = new SimpleStringProperty(nome);
		this.descricao = new SimpleStringProperty(descricao);
		this.ano = new SimpleIntegerProperty(ano);
		this.diretor = new SimpleStringProperty(diretor);
		this.atorPrincipal = new SimpleStringProperty(atorPrincipal);
		this.faixaEtaria = new SimpleIntegerProperty(faixaEtaria);
		this.temporada = new SimpleStringProperty(temporada);
		this.arquivoVideo = arquivoVideo;
		this.extensao = extensao;
		
		categoriaBD = categoria(categoria);
		
		serieBD = serie(serie);
				
		videoBD = new projeto.modelos.Video(categoriaBD,serieBD,nome,descricao,ano,diretor,atorPrincipal,faixaEtaria,temporada,arquivoVideo,extensao);
		
	}
	
	public Video(projeto.modelos.Video videoBD) {
		this.videoBD = videoBD;
		
		this.categoria = new SimpleStringProperty(videoBD.getCategoria().getNome());
		this.serie =  new SimpleStringProperty(videoBD.getSerie().getNome());
		this.nome = new SimpleStringProperty(videoBD.getNome());
		this.descricao = new SimpleStringProperty(videoBD.getDescricao());
		this.ano = new SimpleIntegerProperty(videoBD.getAno());
		this.diretor = new SimpleStringProperty(videoBD.getDiretor());
		this.atorPrincipal = new SimpleStringProperty(videoBD.getAtorPrincipal());
		this.faixaEtaria = new SimpleIntegerProperty(videoBD.getFaixaEtaria());
		this.temporada = new SimpleStringProperty(videoBD.getTemporada());
		this.arquivoVideo = videoBD.getArquivoVideo();
		this.extensao = videoBD.getExtensao();
		
		this.serieBD = videoBD.getSerie();
		this.categoriaBD = videoBD.getCategoria();
	}

	private Serie serie(String serieNome) {
		for(Serie s : DAO_HIB.SERIE.listaDeSeries()){
			if(s.getNome().equals(serieNome)){
				return s;
			}
		}
		
		Serie s = new Serie(serieNome);
		
		DAO_HIB.SERIE.salvar(s);
		
		return s;
	}

	private Categoria categoria(String categoriaNome) {
		
		for(Categoria c : DAO_HIB.CATEGORIA.listaDeCategorias()){
			if(c.getNome().equals(categoriaNome)){
				return c;
			}
		}
		
		Categoria c = new Categoria(categoriaNome);
		
		DAO_HIB.CATEGORIA.salvar(c);
		
		return c;
	}


	public Integer getIdVideo() {
		return idVideo;
	}

	
	public String getCategoria() {
		return categoria.get();
	}

	public StringProperty getCategoriaProperty() {
		return categoria;
	}


	public void setCategoria(String categoria) {
		this.categoriaBD.setNome(categoria);
		
		DAO_HIB.CATEGORIA.atualizar(categoriaBD);
		
		this.categoria.set(categoria);
	}

	public String getSerie() {
		return serie.get();
	}

	public StringProperty getSerieProperty() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serieBD.setNome(serie);
		
		DAO_HIB.SERIE.atualizar(serieBD);
		
		this.serie.set(serie);
	}

	public StringProperty getNomeProperty() {
		return nome;
	}

	public String getNome() {
		return nome.get();
	}
	
	public void setNome(String nome) {
		
		videoBD.setNome(nome);
		
		DAO_HIB.VIDEO.atualizar(videoBD);
		
		this.nome.set(nome);
	}
	
	public String getDescricao() {
		return descricao.get();
	}

	public StringProperty getDescricaoProperty() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		videoBD.setDescricao(descricao);
		
		DAO_HIB.VIDEO.atualizar(videoBD);
		
		this.descricao.set(descricao);
	}

	public IntegerProperty getAnoProperty() {
		return ano;
	}

	public Integer getAno() {
		return ano.get();
	}
	
	public void setAno(Integer ano) {
		videoBD.setAno(ano);
		
		DAO_HIB.VIDEO.atualizar(videoBD);
		
		this.ano.set(ano);
	}

	public StringProperty getDiretorProperty() {
		return diretor;
	}
	
	public String getDiretor() {
		return diretor.get();
	}

	public void setDiretor(String diretor) {
		videoBD.setDiretor(diretor);
		
		DAO_HIB.VIDEO.atualizar(videoBD);
		
		this.diretor.set(diretor);
	}

	public StringProperty getAtorPrincipalProperty() {
		return atorPrincipal;
	}

	public String getAtorPrincipal() {
		return atorPrincipal.get();
	}	
	
	public void setAtorPrincipal(String atorPrincipal) {
		
		videoBD.setAtorPrincipal(atorPrincipal);
		
		DAO_HIB.VIDEO.atualizar(videoBD);
		
		this.atorPrincipal.set(atorPrincipal);
	}

	public IntegerProperty getFaixaEtariaInProperty() {
		return faixaEtaria;
	}

	public Integer getFaixaEtaria() {
		return faixaEtaria.get();
	}

	public void setFaixaEtaria(Integer faixaEtaria) {
		
		videoBD.setFaixaEtaria(faixaEtaria);
		
		DAO_HIB.VIDEO.atualizar(videoBD);
		
		this.faixaEtaria.get();
	}

	public StringProperty getTemporadaProperty() {
		return temporada;
	}

	public String getTemporada() {
		return temporada.get();
	}

	public void setTemporada(String temporada) {
		
		videoBD.setTemporada(temporada);
		
		DAO_HIB.VIDEO.atualizar(videoBD);
		
		this.temporada.set(temporada);
	}

	public byte[] getArquivoVideo() {
		return arquivoVideo;
	}

	public void setArquivoVideo(byte[] arquivoVideo) {
		
		videoBD.setArquivoVideo(arquivoVideo);
		
		DAO_HIB.VIDEO.atualizar(videoBD);
		
		this.arquivoVideo = arquivoVideo;
	}

	public String getExtensao() {
		return extensao;
	}


	public void setExtensao(String extensao) {
		
		videoBD.setExtensao(extensao);
		
		DAO_HIB.VIDEO.atualizar(videoBD);
		
		this.extensao = extensao;
	}

}
