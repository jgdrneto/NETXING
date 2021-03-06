package projeto.modelos;
// Generated 20/10/2016 21:44:55 by Hibernate Tools 5.1.0.Beta1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Seriefavorita generated by hbm2java
 */
@Entity
@Table(name = "SERIEFAVORITA", catalog = "netxing")
public class Seriefavorita implements java.io.Serializable {

	private Integer idSerieFavorita;
	private Serie serie;
	private Usuario usuario;

	public Seriefavorita() {
	}

	public Seriefavorita(Serie serie, Usuario usuario) {
		this.serie = serie;
		this.usuario = usuario;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "idSerieFavorita", unique = true, nullable = false)
	public Integer getIdSerieFavorita() {
		return this.idSerieFavorita;
	}

	public void setIdSerieFavorita(Integer idSerieFavorita) {
		this.idSerieFavorita = idSerieFavorita;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SERIE_idSerie", nullable = false)
	public Serie getSerie() {
		return this.serie;
	}

	public void setSerie(Serie serie) {
		this.serie = serie;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USUARIO_idUsuario", nullable = false)
	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
