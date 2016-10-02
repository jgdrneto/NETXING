package hibernate.modelosDB.DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import hibernate.conexao.HibernateUtil;
import interfaces.UsuarioDAO;
import modelosBD.Usuario;

public class Usuario_HibernateDAO implements UsuarioDAO{
	
	Transaction transacao;
	
	@Override
	public void salvar(Usuario usuario) {
		
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		try{
		
			transacao = sessao.beginTransaction();
			
			sessao.save(usuario);
			
			transacao.commit();
			
			System.out.println("Usuário salvo");

		}catch(Exception e){
			
			e.printStackTrace();
		
		}finally{
			sessao.close();
		}
	}

	@Override
	public void deletar(Usuario usuario) {
		
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		try{
		
			transacao = sessao.beginTransaction();
			
			sessao.delete(usuario);
			
			transacao.commit();
			
			System.out.println("Usuário deletado");

		}catch(Exception e){
			
			e.printStackTrace();
		
		}finally{
			sessao.close();
		}
	}

	@Override
	public void atualizar(Usuario usuario) {
		
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		try{
		
			transacao = sessao.beginTransaction();
			
			sessao.update(usuario);
			
			transacao.commit();
			
			System.out.println("Usuário atualizado");

		}catch(Exception e){
			
			e.printStackTrace();
		
		}finally{
			sessao.close();
		}
		
	}

	@Override
	public List<Usuario> listaDeUsuarios() {
		
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		
		try{
		
			transacao = sessao.beginTransaction();
			
			return new ArrayList<Usuario>(sessao.createQuery("FROM Usuario").getResultList());

		}catch(Exception e){
			
			e.printStackTrace();
		
		}finally{
			sessao.close();
		}
		
		return new ArrayList<Usuario>();
	}

}
