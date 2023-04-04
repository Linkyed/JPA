package teste.umpraum;

import info.DAO;
import modelo.umpraum.Assento;
import modelo.umpraum.Cliente;

public class ObterClienteAssento {
	public static void main(String[] args) {
		Assento assento = new Assento("4B");
		Cliente cliente = new Cliente("Rodrigo", assento);	
		
		DAO<Cliente> dao = new DAO<>(Cliente.class);
		
		System.out.println(dao.obterPrimeiro().getAssento().getNome());
		System.out.println(dao.obterPrimeiro().getAssento().getCliente().getNome());
	}
}
