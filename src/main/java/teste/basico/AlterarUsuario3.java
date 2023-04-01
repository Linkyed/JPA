package teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.basico.Usuario;

public class AlterarUsuario3 {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("estudo-JPA");
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
			
		Usuario usuario = em.find(Usuario.class, 3L);
		//Objeto fora do estado gerenciado
		em.detach(usuario);
		usuario.setNome("Matias Binoto Ferrari");
		
		//Atualizando o BD com as alterações do usuario
		em.merge(usuario);
		
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}
}
