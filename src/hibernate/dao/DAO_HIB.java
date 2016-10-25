package hibernate.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Transaction;

import hibernate.conexao.HibernateUtil;
import projeto.dao.DAO;

public class DAO_HIB extends DAO {
	
	Transaction transacao;
	
	@Override
	public <T> void salvar(T objeto) {
		
		try{
		
            transacao = HibernateUtil.getSession().beginTransaction();
			
            HibernateUtil.getSession().save(objeto);
			
			transacao.commit();
			
			System.out.println(objeto.getClass().getSimpleName() +" salvo(a)");

		}catch(Exception e){
			transacao.rollback();
		}

	}

	@Override
	public <T> void deletar(T objeto) {
		
		try{
		
            transacao = HibernateUtil.getSession().beginTransaction();
			
            HibernateUtil.getSession().delete(objeto);
			
			transacao.commit();
			
			System.out.println(objeto.getClass().getSimpleName() +" deletado(a)");

		}catch(Exception e){
			transacao.rollback();
		}

	}

	@Override
	public <T> void atualizar(T objeto) {

		try{

            transacao = HibernateUtil.getSession().beginTransaction();
			
            HibernateUtil.getSession().update(objeto);
			
			transacao.commit();
			
			System.out.println(objeto.getClass().getSimpleName() +" atualizado(a)");

		}catch(Exception e){
            e.printStackTrace();
            transacao.rollback();
		}

	}

	@Override
	public <T> List<T> listar(Class<?> ClasseDaTabela) {

        return new ArrayList<T>(
                HibernateUtil.getSession().createQuery("FROM " + ClasseDaTabela.getSimpleName()).getResultList());
	}
	
}
