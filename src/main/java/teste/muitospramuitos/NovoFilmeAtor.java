package teste.muitospramuitos;

import info.DAO;
import modelo.muitospramuitos.Ator;
import modelo.muitospramuitos.Filme;

public class NovoFilmeAtor {
	public static void main(String[] args) {
		Ator a1 = new Ator("Micael Jakson");
		Ator a2 = new Ator("Leonardo Dicaprio");
		Filme f1 = new Filme("Filme 1", 10.0);
		Filme f2 = new Filme("Filme 2", 3.0);
		
		f1.adicionarAtor(a2);
		f1.adicionarAtor(a1);
		f2.adicionarAtor(a2);
		f2.adicionarAtor(a1);
		
		DAO<Filme> dao = new DAO<>();
		dao.incluirAtomico(f1);
	}
}
