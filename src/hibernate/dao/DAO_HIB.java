package hibernate.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import hibernate.conexao.HibernateUtil;
import projeto.dao.DAO;

public class DAO_HIB extends DAO {
	
	Transaction transacao;
	
	@Override
	public <T> void salvar(T objeto) {
		
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		try{
		
			transacao = sessao.beginTransaction();
			
			sessao.save(objeto);
			
			transacao.commit();
			
			System.out.println(objeto.getClass().getSimpleName() +" salvo(a)");

		}catch(Exception e){
			transacao.rollback();
		}finally{
			sessao.close();
		}
	}

	@Override
	public <T> void deletar(T objeto) {
		
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		try{
		
			transacao = sessao.beginTransaction();
			
			sessao.save(objeto);
			
			transacao.commit();
			
			System.out.println(objeto.getClass().getSimpleName() +" deletado(a)");

		}catch(Exception e){
			transacao.rollback();
		}finally{
			sessao.close();
		}
	}

	@Override
	public <T> void atualizar(T objeto) {
		
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		try{
		
			transacao = sessao.beginTransaction();
			
			sessao.save(objeto);
			
			transacao.commit();
			
			System.out.println(objeto.getClass().getSimpleName() +" atualizado(a)");

		}catch(Exception e){
			transacao.rollback();
		}finally{
			sessao.close();
		}
	}

	@Override
	public <T> List<T> listar(Class<?> ClasseDaTabela) {
		return new ArrayList<T>(HibernateUtil.getSessionFactory().openSession().createQuery("FROM "+ ClasseDaTabela.getSimpleName()).getResultList());
	}
	
}
