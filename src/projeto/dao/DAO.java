package projeto.dao;

import hibernate.dao.DAO_HIB;

public abstract class DAO  implements Regras{
	//Caso se desejar mudar as regras de acesso, mudasse essa linha
	public static DAO ACAO = new DAO_HIB();
	
	public static void setNovoProtocoloDeAcesso(DAO aCAO) {
		ACAO = aCAO;
	}
}
