package hibernate.modelosDAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import hibernate.conexao.HibernateUtil;
import projeto.dao.SerieDAO;
import projeto.modelos.Serie;

public class Serie_HibernateDAO extends SerieDAO{
	
	Transaction transacao;
	
	@Override
	public void salvar(Serie Serie) {
		
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		try{
		
			transacao = sessao.beginTransaction();
			
			sessao.save(Serie);
			
			transacao.commit();
			
			System.out.println("Serie salva");

		}catch(Exception e){
			
			e.printStackTrace();
		
		}finally{
			sessao.close();
		}
	}

	@Override
	public void deletar(Serie Serie) {
		
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		try{
		
			transacao = sessao.beginTransaction();
			
			sessao.delete(Serie);
			
			transacao.commit();
			
			System.out.println("Serie deletada");

		}catch(Exception e){
			
			e.printStackTrace();
		
		}finally{
			sessao.close();
		}
	}

	@Override
	public void atualizar(Serie Serie) {
		
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		try{
		
			transacao = sessao.beginTransaction();
			
			sessao.update(Serie);
			
			transacao.commit();
			
			System.out.println("Serie atualizada");

		}catch(Exception e){
			
			e.printStackTrace();
		
		}finally{
			sessao.close();
		}
		
	}

	@Override
	public List<Serie> listaDeSeries() {
		
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		try{
		
			transacao = sessao.beginTransaction();
			
			return new ArrayList<Serie>(sessao.createQuery("FROM Serie").getResultList());

		}catch(Exception e){
			
			e.printStackTrace();
		
		}finally{
			sessao.close();
		}
		
		return new ArrayList<Serie>();
	}

}
