package hibernate.modelosDB.DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import classesAbstratas.CategoriaDAO;
import hibernate.conexao.HibernateUtil;
import modelosBD.Categoria;

public class Categoria_HibernateDAO extends CategoriaDAO{
	
	Transaction transacao;
	
	@Override
	public void salvar(Categoria Categoria) {
		
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		try{
		
			transacao = sessao.beginTransaction();
			
			sessao.save(Categoria);
			
			transacao.commit();
			
			System.out.println("Categoria salva");

		}catch(Exception e){
			
			e.printStackTrace();
		
		}finally{
			sessao.close();
		}
	}

	@Override
	public void deletar(Categoria Categoria) {
		
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		try{
		
			transacao = sessao.beginTransaction();
			
			sessao.delete(Categoria);
			
			transacao.commit();
			
			System.out.println("Categoria deletada");

		}catch(Exception e){
			
			e.printStackTrace();
		
		}finally{
			sessao.close();
		}
	}

	@Override
	public void atualizar(Categoria Categoria) {
		
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		try{
		
			transacao = sessao.beginTransaction();
			
			sessao.update(Categoria);
			
			transacao.commit();
			
			System.out.println("Categoria atualizada");

		}catch(Exception e){
			
			e.printStackTrace();
		
		}finally{
			sessao.close();
		}
		
	}

	@Override
	public List<Categoria> listaDeCategorias() {
		
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		try{
		
			transacao = sessao.beginTransaction();
			
			return new ArrayList<Categoria>(sessao.createQuery("FROM Categoria").getResultList());

		}catch(Exception e){
			
			e.printStackTrace();
		
		}finally{
			sessao.close();
		}
		
		return new ArrayList<Categoria>();
	}

}
