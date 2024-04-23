package examen.controladores;

import examen.entities.TipoContrato;

public class ControladorTipoContratoJPA extends SuperControladorJPA {
	
	public ControladorTipoContratoJPA() {
		super("tipocontrato", TipoContrato.class);
	}

	private static ControladorTipoContratoJPA instance = null;
	
	/**
	 * Singleton.
	 * @return
	 */
	public static ControladorTipoContratoJPA getInstance() {
		if (instance == null) {
			instance = new ControladorTipoContratoJPA();
		}
		return instance;
	}
	
}
