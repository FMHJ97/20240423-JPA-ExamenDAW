package examen.controladores;

import javax.persistence.EntityManager;

import examen.entities.Usuario;

public class ControladorUsuarioJPA extends SuperControladorJPA {
	
	public ControladorUsuarioJPA() {
		super("usuario", Usuario.class);
	}

	private static ControladorUsuarioJPA instance = null;
	
	/**
	 * Singleton.
	 * @return
	 */
	public static ControladorUsuarioJPA getInstance() {
		if (instance == null) {
			instance = new ControladorUsuarioJPA();
		}
		return instance;
	}
	
	/**
	 * 
	 * @param u
	 */
	public void updateUsuario(Usuario u) {
		EntityManager em = getEntityManager();
		
		em.getTransaction().begin();
		em.merge(u);
		em.getTransaction().commit();
	}
	
}
