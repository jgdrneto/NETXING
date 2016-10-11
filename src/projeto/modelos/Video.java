package projeto.modelos;
// Generated 07/10/2016 19:44:50 by Hibernate Tools 5.1.0.Beta1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Video generated by hbm2java
 */
@Entity
@Table(name = "VIDEO", catalog = "netxing")
public class Video implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer idVideo;
	private Categoria categoria;
	private Serie serie;
	private String nome;
	private String descricao;
	private Integer ano;
	private String diretor;
	private String atorPrincipal;
	private int faixaEtaria;
	private String temporada;
	private byte[] arquivoVideo;
	private String extensao;
	private Set<Videofavorito> videofavoritos = new HashSet<Videofavorito>(0);

	public Video() {
	}

	public Video(Categoria categoria, Serie serie, String nome, int faixaEtaria, byte[] arquivoVideo, String extensao) {
		this.categoria = categoria;
		this.serie = serie;
		this.nome = nome;
		this.faixaEtaria = faixaEtaria;
		this.arquivoVideo = arquivoVideo;
		this.extensao = extensao;
	}

	public Video(Categoria categoria, Serie serie, String nome, String descricao, Integer ano, String diretor,
			String atorPrincipal, int faixaEtaria, String temporada, byte[] arquivoVideo, String extensao,
			Set<Videofavorito> videofavoritos) {
		this.categoria = categoria;
		this.serie = serie;
		this.nome = nome;
		this.descricao = descricao;
		this.ano = ano;
		this.diretor = diretor;
		this.atorPrincipal = atorPrincipal;
		this.faixaEtaria = faixaEtaria;
		this.temporada = temporada;
		this.arquivoVideo = arquivoVideo;
		this.extensao = extensao;
		this.videofavoritos = videofavoritos;
	}
	
	public Video(Categoria categoria, Serie serie, String nome, String descricao, Integer ano, String diretor,
			String atorPrincipal, int faixaEtaria, String temporada, byte[] arquivoVideo, String extensao) {
		this.categoria = categoria;
		this.serie = serie;
		this.nome = nome;
		this.descricao = descricao;
		this.ano = ano;
		this.diretor = diretor;
		this.atorPrincipal = atorPrincipal;
		this.faixaEtaria = faixaEtaria;
		this.temporada = temporada;
		this.arquivoVideo = arquivoVideo;
		this.extensao = extensao;
	}
	
	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "idVideo", unique = true, nullable = false)
	public Integer getIdVideo() {
		return this.idVideo;
	}

	public void setIdVideo(Integer idVideo) {
		this.idVideo = idVideo;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CATEGORIA_idCategoria", nullable = false)
	public Categoria getCategoria() {
		return this.categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SERIE_idSerie", nullable = false)
	public Serie getSerie() {
		return this.serie;
	}

	public void setSerie(Serie serie) {
		this.serie = serie;
	}

	@Column(name = "nome", nullable = false, length = 100)
	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Column(name = "descricao", length = 300)
	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Column(name = "ano")
	public Integer getAno() {
		return this.ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	@Column(name = "diretor", length = 45)
	public String getDiretor() {
		return this.diretor;
	}

	public void setDiretor(String diretor) {
		this.diretor = diretor;
	}

	@Column(name = "atorPrincipal", length = 100)
	public String getAtorPrincipal() {
		return this.atorPrincipal;
	}

	public void setAtorPrincipal(String atorPrincipal) {
		this.atorPrincipal = atorPrincipal;
	}

	@Column(name = "faixaEtaria", nullable = false)
	public int getFaixaEtaria() {
		return this.faixaEtaria;
	}

	public void setFaixaEtaria(int faixaEtaria) {
		this.faixaEtaria = faixaEtaria;
	}

	@Column(name = "temporada", length = 45)
	public String getTemporada() {
		return this.temporada;
	}

	public void setTemporada(String temporada) {
		this.temporada = temporada;
	}

	@Column(name = "arquivoVideo", nullable = false)
	public byte[] getArquivoVideo() {
		return this.arquivoVideo;
	}

	public void setArquivoVideo(byte[] arquivoVideo) {
		this.arquivoVideo = arquivoVideo;
	}

	@Column(name = "extensao", nullable = false, length = 45)
	public String getExtensao() {
		return this.extensao;
	}

	public void setExtensao(String extensao) {
		this.extensao = extensao;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "video")
	public Set<Videofavorito> getVideofavoritos() {
		return this.videofavoritos;
	}

	public void setVideofavoritos(Set<Videofavorito> videofavoritos) {
		this.videofavoritos = videofavoritos;
	}

}
