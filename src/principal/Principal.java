package principal;

import classesAbstratas.SerieDAO;
import classesAbstratas.UsuarioDAO;
import hibernate.conexao.HibernateUtil;
import hibernate.modelosDB.DAO.Serie_HibernateDAO;
import hibernate.modelosDB.DAO.Usuario_HibernateDAO;
import modelosBD.Serie;
import modelosBD.Usuario;


public class Principal {
	
	/*
	 * Descrição: Finalizando conexão com o banco de dados
	 */
	private static void fim(){
		HibernateUtil.getSessionFactory().close();
	}
	
	/*
	 * Descrição: Método principal da aplicação
	 * 
	 * @params String[] : Argumentos passados por parâmetros na execução
	 */
	public static void main(String[] args) {
		
		UsuarioDAO usuarioDAO = new Usuario_HibernateDAO();
		
		for (Usuario us : usuarioDAO.listaDeUsuarios()){
			System.out.println("ID: " + us.getIdUsuario() + " Login: "+ us.getLogin());
		}
		
		fim();
	}

}
