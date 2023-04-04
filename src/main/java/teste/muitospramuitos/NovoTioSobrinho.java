package teste.muitospramuitos;

import info.DAO;
import modelo.muitospramuitos.Sobrinho;
import modelo.muitospramuitos.Tio;

public class NovoTioSobrinho {
	public static void main(String[] args) {
		Tio tio1 = new Tio("Josivaldo");
		Sobrinho sob1 = new Sobrinho("Lucas");
		Tio tio2 = new Tio("Elias");
		Sobrinho sob2 = new Sobrinho("Marcelo");
		
		tio1.getSobrinhos().add(sob1);
		sob1.getTios().add(tio1);
		
		tio1.getSobrinhos().add(sob2);
		sob2.getTios().add(tio1);
		
		tio2.getSobrinhos().add(sob2);
		sob2.getTios().add(tio2);
		
		tio2.getSobrinhos().add(sob1);
		sob1.getTios().add(tio2);
		
		DAO<Object> dao = new DAO<>();
		
		dao.abrirTransacao().incluir(tio1).incluir(tio2).incluir(sob1).incluir(sob2).fecharTransacao().fechar();
	}
}
