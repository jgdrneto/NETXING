package javafx.modelos;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

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
	

	public Video(String categoria, String serie, String nome, Integer faixaEtaria, byte[] arquivoVideo, String extensao) {
		this.categoria = new SimpleStringProperty(categoria);
		this.serie = new SimpleStringProperty(serie);
		this.nome = new SimpleStringProperty(nome);
		this.faixaEtaria = new SimpleIntegerProperty(faixaEtaria);
		this.arquivoVideo = arquivoVideo;
		this.extensao = extensao;
	}


	public Integer getIdVideo() {
		return idVideo;
	}


	public void setIdVideo(Integer idVideo) {
		this.idVideo = idVideo;
	}
	
	
	public String getCategoria() {
		return categoria.get();
	}

	public StringProperty getCategoriaProperty() {
		return categoria;
	}


	public void setCategoria(String categoria) {
		this.categoria.set(categoria);
	}

	public String getSerie() {
		return serie.get();
	}

	public StringProperty getSerieProperty() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie.set(serie);
	}

	public StringProperty getNomeProperty() {
		return nome;
	}

	public String getNome() {
		return nome.get();
	}
	
	public void setNome(String nome) {
		this.nome.set(nome);
	}
	
	public String getDescricao() {
		return descricao.get();
	}

	public StringProperty getDescricaoProperty() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao.set(descricao);
	}

	public IntegerProperty getAnoProperty() {
		return ano;
	}

	public Integer getAno() {
		return ano.get();
	}
	
	public void setAno(Integer ano) {
		this.ano.set(ano);
	}

	public StringProperty getDiretorProperty() {
		return diretor;
	}
	
	public String getDiretor() {
		return diretor.get();
	}

	public void setDiretor(String diretor) {
		this.diretor.set(diretor);
	}

	public StringProperty getAtorPrincipalProperty() {
		return atorPrincipal;
	}

	public String getAtorPrincipal() {
		return atorPrincipal.get();
	}	
	
	public void setAtorPrincipal(String atorPrincipal) {
		this.atorPrincipal.set(atorPrincipal);
	}

	public IntegerProperty getFaixaEtariaInProperty() {
		return faixaEtaria;
	}

	public Integer getFaixaEtaria() {
		return faixaEtaria.get();
	}

	public void setFaixaEtaria(Integer faixaEtaria) {
		this.faixaEtaria.get();
	}

	public StringProperty getTemporadaProperty() {
		return temporada;
	}

	public String getTemporada() {
		return temporada.get();
	}

	public void setTemporada(StringProperty temporada) {
		this.temporada = temporada;
	}

	public byte[] getArquivoVideo() {
		return arquivoVideo;
	}

	public void setArquivoVideo(byte[] arquivoVideo) {
		this.arquivoVideo = arquivoVideo;
	}

	public String getExtensao() {
		return extensao;
	}


	public void setExtensao(String extensao) {
		this.extensao = extensao;
	}

}
