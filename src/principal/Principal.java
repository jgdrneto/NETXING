package principal;

import hibernate.modelosDB.DAO.Serie_HibernateDAO;
import modelosBD.Serie;

public class Principal {

	public static void main(String[] args) {
		
		Serie_HibernateDAO serieDAO = new Serie_HibernateDAO();
		
		for (Serie se : serieDAO.listaDeSeries()){
			System.out.println("ID:" + se.getIdSerie() + " Nome:"+ se.getNome());
		}
	}

}
