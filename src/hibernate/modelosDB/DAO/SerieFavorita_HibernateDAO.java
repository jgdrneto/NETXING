package hibernate.modelosDB.DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import classesAbstratas.SerieFavoritaDAO;
import hibernate.conexao.HibernateUtil;
import modelosBD.Seriefavorita;

public class SerieFavorita_HibernateDAO extends SerieFavoritaDAO{
	
	Transaction transacao;
	
	@Override
	public void salvar(Seriefavorita SerieFavorita) {
		
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		try{
		
			transacao = sessao.beginTransaction();
			
			sessao.save(SerieFavorita);
			
			transacao.commit();
			
			System.out.println("Vídeo salvo");

		}catch(Exception e){
			
			e.printStackTrace();
		
		}finally{
			sessao.close();
		}
	}

	@Override
	public void deletar(Seriefavorita SerieFavorita) {
		
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		try{
		
			transacao = sessao.beginTransaction();
			
			sessao.delete(SerieFavorita);
			
			transacao.commit();
			
			System.out.println("Vídeo deletado");

		}catch(Exception e){
			
			e.printStackTrace();
		
		}finally{
			sessao.close();
		}
	}

	@Override
	public void atualizar(Seriefavorita SerieFavorita) {
		
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		try{
		
			transacao = sessao.beginTransaction();
			
			sessao.update(SerieFavorita);
			
			transacao.commit();
			
			System.out.println("Vídeo atualizado");

		}catch(Exception e){
			
			e.printStackTrace();
		
		}finally{
			sessao.close();
		}
		
	}

	@Override
	public List<Seriefavorita> listaDeSerieFavorita() {
		
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		try{
		
			transacao = sessao.beginTransaction();
			
			return new ArrayList<Seriefavorita>(sessao.createQuery("FROM Seriefavorita").getResultList());

		}catch(Exception e){
			
			e.printStackTrace();
		
		}finally{
			sessao.close();
		}
		
		return new ArrayList<Seriefavorita>();
	}

}
