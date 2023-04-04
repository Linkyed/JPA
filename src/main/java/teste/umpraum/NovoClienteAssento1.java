package teste.umpraum;

import info.DAO;
import modelo.umpraum.Assento;
import modelo.umpraum.Cliente;

public class NovoClienteAssento1 {
	public static void main(String[] args) {
		Assento assento = new Assento("22C");
		Cliente cliente = new Cliente("Pedro A", assento);	
		
		DAO<Object> dao = new DAO<>();
		
		dao.abrirTransacao().incluir(assento).incluir(cliente).fecharTransacao().fechar();
	}
}
