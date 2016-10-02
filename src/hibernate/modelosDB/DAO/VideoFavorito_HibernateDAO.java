package hibernate.modelosDB.DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import hibernate.conexao.HibernateUtil;
import interfaces.VideoFavoritoDAO;
import modelosBD.VideoFavorito;

public class VideoFavorito_HibernateDAO implements VideoFavoritoDAO{
	
	Transaction transacao;
	
	@Override
	public void salvar(VideoFavorito VideoFavorito) {
		
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		try{
		
			transacao = sessao.beginTransaction();
			
			sessao.save(VideoFavorito);
			
			transacao.commit();
			
			System.out.println("Vídeo salvo");

		}catch(Exception e){
			
			e.printStackTrace();
		
		}finally{
			sessao.close();
		}
	}

	@Override
	public void deletar(VideoFavorito VideoFavorito) {
		
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		try{
		
			transacao = sessao.beginTransaction();
			
			sessao.delete(VideoFavorito);
			
			transacao.commit();
			
			System.out.println("Vídeo deletado");

		}catch(Exception e){
			
			e.printStackTrace();
		
		}finally{
			sessao.close();
		}
	}

	@Override
	public void atualizar(VideoFavorito VideoFavorito) {
		
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		try{
		
			transacao = sessao.beginTransaction();
			
			sessao.update(VideoFavorito);
			
			transacao.commit();
			
			System.out.println("Vídeo atualizado");

		}catch(Exception e){
			
			e.printStackTrace();
		
		}finally{
			sessao.close();
		}
		
	}

	@Override
	public List<VideoFavorito> listaDeVideoFavorito() {
		
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		try{
		
			transacao = sessao.beginTransaction();
			
			return new ArrayList<VideoFavorito>(sessao.createQuery("FROM VideoFavorito").getResultList());

		}catch(Exception e){
			
			e.printStackTrace();
		
		}finally{
			sessao.close();
		}
		
		return new ArrayList<VideoFavorito>();
	}

}
