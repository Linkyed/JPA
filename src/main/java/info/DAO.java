package info;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class DAO<E> {
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Class<E> classe;
	
	static {
		emf = Persistence.createEntityManagerFactory("estudo-JPA");		
	}
	
	public DAO() {
		this(null);
	}
	
	public DAO(Class<E> classe) {
		this.classe = classe;
		em = emf.createEntityManager();
	}
	
	public DAO<E> abrirTransacao(){
		em.getTransaction().begin();
		return this;
	}
	
	public DAO<E> fecharTransacao(){
		em.getTransaction().commit();
		return this;
	}
	
	public DAO<E> incluir(E entidade){
		em.persist(entidade);
		return this;
	}
	
	public DAO<E> incluirAtomico(E entidade) {
		return this.abrirTransacao().incluir(entidade).fecharTransacao();
	}
	
	public List<E> obterTodos(){
		return obterTodos(10, 0);
		}
	
	public E obterPrimeiro(){
		return obterTodos(1, 0).get(0);
	}
	
	public List<E> obterTodos(int quantidade, int deslocamento){
		if (classe == null) {
			throw new RuntimeException();
		}
		
		String jpql = "select e from " + classe.getName() + " e";
		
		TypedQuery<E> query =  em.createQuery(jpql, classe).setFirstResult(deslocamento).setMaxResults(quantidade);
		
		return query.getResultList();
	}
	
	public void fechar() {
		em.close();
	}
}
