package teste.basico;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.basico.Usuario;

public class AlterarUsuario2 {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("estudo-JPA");
		EntityManager em = emf.createEntityManager();
		
		
		
		em.getTransaction().begin();
		//Objeto em estado gerenciado, qualquer alteração estara ligada am BD
		Usuario usuario = em.find(Usuario.class, 3L);
		usuario.setNome("Matias Binoto Ferrari");
		
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}
}
