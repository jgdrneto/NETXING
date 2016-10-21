package projeto.modelos;
// Generated 20/10/2016 21:44:55 by Hibernate Tools 5.1.0.Beta1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Serie generated by hbm2java
 */
@Entity
@Table(name = "SERIE", catalog = "netxing")
public class Serie implements java.io.Serializable {

	private Integer idSerie;
	private String nome;
	private String imagem;
	private Set<Video> videos = new HashSet<Video>(0);
	private Set<Seriefavorita> seriefavoritas = new HashSet<Seriefavorita>(0);

	public Serie() {
	}

	public Serie(String nome, String imagem) {
		this.nome = nome;
		this.imagem = imagem;
	}

	public Serie(String nome, String imagem, Set<Video> videos, Set<Seriefavorita> seriefavoritas) {
		this.nome = nome;
		this.imagem = imagem;
		this.videos = videos;
		this.seriefavoritas = seriefavoritas;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "idSerie", unique = true, nullable = false)
	public Integer getIdSerie() {
		return this.idSerie;
	}

	public void setIdSerie(Integer idSerie) {
		this.idSerie = idSerie;
	}

	@Column(name = "nome", nullable = false, length = 45)
	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Column(name = "imagem", nullable = false, length = 200)
	public String getImagem() {
		return this.imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "serie")
	public Set<Video> getVideos() {
		return this.videos;
	}

	public void setVideos(Set<Video> videos) {
		this.videos = videos;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "serie")
	public Set<Seriefavorita> getSeriefavoritas() {
		return this.seriefavoritas;
	}

	public void setSeriefavoritas(Set<Seriefavorita> seriefavoritas) {
		this.seriefavoritas = seriefavoritas;
	}

}
