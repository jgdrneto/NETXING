package hibernate.conexao;

import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static final SessionFactory sessionFactory;
	
	static {
		
        try {
            sessionFactory = new Configuration().configure("/hibernate/conexao/hibernate.cfg.xml") .buildSessionFactory();

        } catch (Throwable ex) {

            System.err.println("Erro na criação do SessionFactory." + ex);
            
            throw new ExceptionInInitializerError(ex);
        }
    }
	
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
