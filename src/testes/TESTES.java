package testes;

import projeto.modelos.Usuario;

public class TESTES {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Usuario u = new Usuario("qwer", "1234", 17);
		
		//DAO_HIB.USUARIO.salvar(u);
		
		System.out.println("Id usuário :" + u.getIdUsuario());
		
	}

}
