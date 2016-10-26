package javafx.modelos;

import java.util.List;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import projeto.dao.DAO;
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
	private String video;
	private String imagem;
	
	//Objetos do banco de dados
	private projeto.modelos.Video videoBD;
	private projeto.modelos.Serie serieBD;
	private projeto.modelos.Categoria categoriaBD;
	
	
	public Video(Categoria categoria, Serie serie, String nome, String descricao, Integer ano, 
			String diretor, String atorPrincipal, Integer faixaEtaria,String temporada, 
			String arquivoVideo, String arquivoImagem) {
		
		this.categoria = new SimpleStringProperty(categoria.getNome());
		this.serie =  new SimpleStringProperty(serie.getNome());
		this.nome = new SimpleStringProperty(nome);
		this.descricao = new SimpleStringProperty(descricao);
		this.ano = new SimpleIntegerProperty(ano);
		this.diretor = new SimpleStringProperty(diretor);
		this.atorPrincipal = new SimpleStringProperty(atorPrincipal);
		this.faixaEtaria = new SimpleIntegerProperty(faixaEtaria);
		this.temporada = new SimpleStringProperty(temporada);
		this.video = arquivoVideo;
		this.imagem = arquivoImagem;
		
		categoriaBD = categoria;
		
		serieBD = serie;
				
		videoBD = new projeto.modelos.Video(categoriaBD,serieBD,nome,descricao,ano,diretor,atorPrincipal,faixaEtaria,temporada,arquivoVideo,arquivoImagem);
		
		DAO.ACAO.salvar(videoBD);
		
	}
	
	public Video(String categoria, String serie, String nome, String descricao, Integer ano, 
			String diretor, String atorPrincipal, Integer faixaEtaria,String temporada, 
			String arquivoVideo, String arquivoImagem) {
		
		this.categoria = new SimpleStringProperty(categoria);
		this.serie =  new SimpleStringProperty(serie);
		this.nome = new SimpleStringProperty(nome);
		this.descricao = new SimpleStringProperty(descricao);
		this.ano = new SimpleIntegerProperty(ano);
		this.diretor = new SimpleStringProperty(diretor);
		this.atorPrincipal = new SimpleStringProperty(atorPrincipal);
		this.faixaEtaria = new SimpleIntegerProperty(faixaEtaria);
		this.temporada = new SimpleStringProperty(temporada);
		this.video = arquivoVideo;
		this.imagem = arquivoImagem;
		
		categoriaBD = categoria(categoria);
		
		serieBD = serie(serie, arquivoImagem);
				
		videoBD = new projeto.modelos.Video(categoriaBD,serieBD,nome,descricao,ano,diretor,atorPrincipal,faixaEtaria,temporada,arquivoVideo,arquivoImagem);
		
		DAO.ACAO.salvar(videoBD);
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
		this.video = videoBD.getVideo();
		this.imagem = videoBD.getImagem();
		
		this.serieBD = videoBD.getSerie();
		this.categoriaBD = videoBD.getCategoria();
	}

	private Serie serie(String serieNome, String imagem) {
		
		List<Serie> listaSeries = DAO.ACAO.listar(projeto.modelos.Serie.class);
		
		for(Serie s : listaSeries){
			if(s.getNome().equals(serieNome)){
				return s;
			}
		}
		
		Serie s = new Serie(serieNome, imagem);
		
		DAO.ACAO.salvar(s);
		
		return s;
	}

	private Categoria categoria(String categoriaNome) {
		
		List<Categoria> listaCategoria = DAO.ACAO.listar(Categoria.class);
		
		for(Categoria c : listaCategoria){
			if(c.getNome().equals(categoriaNome)){
				return c;
			}
		}
		
		Categoria c = new Categoria(categoriaNome);
		
		DAO.ACAO.salvar(c);
		
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
		
		DAO.ACAO.atualizar(categoriaBD);
		
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
		
		DAO.ACAO.atualizar(serieBD);
		
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
		
		DAO.ACAO.atualizar(videoBD);
		
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
		
		DAO.ACAO.atualizar(videoBD);
		
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
		
		DAO.ACAO.atualizar(videoBD);
		
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
		
		DAO.ACAO.atualizar(videoBD);
		
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
		
		DAO.ACAO.atualizar(videoBD);
		
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
		
		DAO.ACAO.atualizar(videoBD);
		
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
		
		DAO.ACAO.atualizar(videoBD);
		
		this.temporada.set(temporada);
	}

	public String getVideo() {
		return video;
	}

	public void setArquivoVideo(String arquivoVideo) {
		
		videoBD.setVideo(arquivoVideo);
		
		DAO.ACAO.atualizar(videoBD);
		
		this.video = arquivoVideo;
	}

	public String getImagem() {
		return imagem;
	}


	public void setImagem(String arquivoImagem) {
		
		videoBD.setImagem(arquivoImagem);
		
		DAO.ACAO.atualizar(videoBD);
		
		this.imagem = arquivoImagem;
	}

    public void setCategoriaBD(projeto.modelos.Categoria nCategoria) {
        categoriaBD = nCategoria;

        videoBD.setCategoria(nCategoria);

        this.categoria.set(nCategoria.getNome());

        DAO.ACAO.atualizar(videoBD);
    }

    public void setSerieBD(projeto.modelos.Serie nSerie) {
        serieBD = nSerie;

        videoBD.setSerie(nSerie);

        this.serie.set(nSerie.getNome());

        DAO.ACAO.atualizar(videoBD);
    }

	public projeto.modelos.Video getVideoBD() {
		return videoBD;
	}

	public projeto.modelos.Serie getSerieBD() {
		return serieBD;
	}

	public projeto.modelos.Categoria getCategoriaBD() {
		return categoriaBD;
	}
	
}
