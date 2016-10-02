package hibernate.modelosDB.DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import hibernate.conexao.HibernateUtil;
import interfaces.SerieFavoritaDAO;
import modelosBD.SerieFavorita;

public class SerieFavorita_HibernateDAO implements SerieFavoritaDAO{
	
	Transaction transacao;
	
	@Override
	public void salvar(SerieFavorita SerieFavorita) {
		
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
	public void deletar(SerieFavorita SerieFavorita) {
		
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
	public void atualizar(SerieFavorita SerieFavorita) {
		
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
	public List<SerieFavorita> listaDeSerieFavorita() {
		
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		try{
		
			transacao = sessao.beginTransaction();
			
			return new ArrayList<SerieFavorita>(sessao.createQuery("FROM SerieFavorita").getResultList());

		}catch(Exception e){
			
			e.printStackTrace();
		
		}finally{
			sessao.close();
		}
		
		return new ArrayList<SerieFavorita>();
	}

}
