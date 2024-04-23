package examen.views;

import java.util.List;

import examen.controladores.ControladorContratoJPA;
import examen.controladores.ControladorTipoContratoJPA;
import examen.controladores.ControladorUsuarioJPA;
import examen.entities.Contrato;
import examen.entities.TipoContrato;
import examen.entities.Usuario;

public class DatosDeTabla {

	/** 
	 * 
	 * @return
	 */
	public static String[] getTitulosColumnas() {
		return new String[] {"Id", "Tipo de Contrato", "Descripción", "Usuario", 
				"Saldo(€)", "Límite(€)", "Fecha de Firma"};
	}

	/**
	 * 
	 * @return
	 */
	public static Object[][] getDatosDeTabla() {
		// Obtengo todos los contratos.
		List<Contrato> contratos = (List<Contrato>) ControladorContratoJPA
				.getInstance().findAll();
		
		// Obtengo todas los usuarios.
		List<Usuario> usuarios = (List<Usuario>) ControladorUsuarioJPA
				.getInstance().findAll();
		
		// Obtengo todos los tipos de contrato.
		List<TipoContrato> tiposContratos = (List<TipoContrato>) ControladorTipoContratoJPA
				.getInstance().findAll();
		
		// Preparo una estructura para pasar al constructor de la JTable
		Object[][] datos = new Object[contratos.size()][7];
		// Cargo los datos de la lista de los contratos en la matriz de los datos.
		for (int i = 0; i < contratos.size(); i++) {
			Contrato c = contratos.get(i);
			datos[i][0] = c.getId();
			
			for (TipoContrato tipoCont : tiposContratos) {
				if (tipoCont.getId() == c.getIdTipoContrato()) {
					datos[i][1] = tipoCont.getDescripcion();
				}
			}
			
			datos[i][2] = c.getDescripcion();
			
			for (Usuario usuario : usuarios) {
				if (usuario.getId() == c.getIdUsuario()) {
					datos[i][3] = usuario.getNombreUsuario();
				}
			}
			
			datos[i][4] = c.getSaldo();
			datos[i][5] = c.getLimite();
			datos[i][6] = c.getFechaFirma();
			
		}
		
		return datos;
	}
	
	
}
