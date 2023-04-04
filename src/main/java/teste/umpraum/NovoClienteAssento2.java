package teste.umpraum;

import info.DAO;
import modelo.umpraum.Assento;
import modelo.umpraum.Cliente;

public class NovoClienteAssento2 {
	public static void main(String[] args) {
		Assento assento = new Assento("4B");
		Cliente cliente = new Cliente("Rodrigo", assento);	
		
		DAO<Cliente> dao = new DAO<>(Cliente.class);
		dao.incluirAtomico(cliente);
	}
}
