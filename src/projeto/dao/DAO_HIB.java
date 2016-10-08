package projeto.dao;

public class DAO_HIB {
	//Classe para usar como DAO
	public static final CategoriaDAO CATEGORIA = new hibernate.modelosDAO.Categoria_HibernateDAO();
	public static final SerieDAO SERIE =  new hibernate.modelosDAO.Serie_HibernateDAO();
	public static final SerieFavoritaDAO SERIEFAVORITA = new hibernate.modelosDAO.SerieFavorita_HibernateDAO();
	public static final UsuarioDAO USUARIO = new hibernate.modelosDAO.Usuario_HibernateDAO();
	public static final VideoDAO VIDEO = new hibernate.modelosDAO.Video_HibernateDAO();
	public static final VideoFavoritoDAO VIDEOFAVORITO = new hibernate.modelosDAO.VideoFavorito_HibernateDAO();
}
