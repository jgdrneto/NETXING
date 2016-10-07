package hibernate.modelosDB.DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import classesAbstratas.VideoFavoritoDAO;
import hibernate.conexao.HibernateUtil;
import modelosBD.Videofavorito;

public class VideoFavorito_HibernateDAO extends VideoFavoritoDAO{
	
	Transaction transacao;
	
	@Override
	public void salvar(Videofavorito videofavorito) {
		
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		try{
		
			transacao = sessao.beginTransaction();
			
			sessao.save(videofavorito);
			
			transacao.commit();
			
			System.out.println("Vídeo salvo");

		}catch(Exception e){
			
			e.printStackTrace();
		
		}finally{
			sessao.close();
		}
	}

	@Override
	public void deletar(Videofavorito videofavorito) {
		
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		try{
		
			transacao = sessao.beginTransaction();
			
			sessao.delete(videofavorito);
			
			transacao.commit();
			
			System.out.println("Vídeo deletado");

		}catch(Exception e){
			
			e.printStackTrace();
		
		}finally{
			sessao.close();
		}
	}

	@Override
	public void atualizar(Videofavorito videofavorito) {
		
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		try{
		
			transacao = sessao.beginTransaction();
			
			sessao.update(videofavorito);
			
			transacao.commit();
			
			System.out.println("Vídeo atualizado");

		}catch(Exception e){
			
			e.printStackTrace();
		
		}finally{
			sessao.close();
		}
		
	}

	@Override
	public List<Videofavorito> listaDeVideoFavorito() {
		
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		try{
		
			transacao = sessao.beginTransaction();
			
			return new ArrayList<Videofavorito>(sessao.createQuery("FROM Videofavorito").getResultList());

		}catch(Exception e){
			
			e.printStackTrace();
		
		}finally{
			sessao.close();
		}
		
		return new ArrayList<Videofavorito>();
	}

}
