package examen.controladores;

import javax.persistence.EntityManager;

import examen.entities.Contrato;

public class ControladorContratoJPA extends SuperControladorJPA {
	
	public ControladorContratoJPA() {
		super("contrato", Contrato.class);
	}

	private static ControladorContratoJPA instance = null;
	
	/**
	 * Singleton.
	 * @return
	 */
	public static ControladorContratoJPA getInstance() {
		if (instance == null) {
			instance = new ControladorContratoJPA();
		}
		return instance;
	}
	
	/**
	 * 
	 * @param c
	 */
	public void updateContrato(Contrato c) {
		EntityManager em = getEntityManager();
		
		em.getTransaction().begin();
		em.merge(c);
		em.getTransaction().commit();
	}
	
}
