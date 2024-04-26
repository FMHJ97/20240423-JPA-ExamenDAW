package examen.views;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.JTextField;

import examen.controladores.ControladorContratoJPA;
import examen.controladores.ControladorUsuarioJPA;
import examen.entities.Contrato;
import examen.entities.Usuario;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;

public class PanelGestionContratos extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField jtfId;
	private JTextField jtfDescripcion;
	private JTextField jtfSaldo;
	private JTextField jtfLimite;
	private JTextField jtfFecha;
	JComboBox<Usuario> jcbUsuario;
	private JRadioButton jrbPrestamo;
	private JRadioButton jrbCuenta;
	private JRadioButton jrbCredito;
	private JRadioButton jrbDebito;
	private ButtonGroup jBGroup;
	private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	// Referencia del PanelTabla.
	// Se usará para actualizar los datos de la tabla.
	private PanelTabla panelTabla;
	
	/**
	 * Método setter que establece una referencia al JPanel PanelTabla 
	 * actual.
	 * @return 
	 */
	public PanelTabla setPanelTabla(PanelTabla panelTabla) {
		return this.panelTabla = panelTabla;
	}
	
	/**
	 * Create the panel.
	 */
	public PanelGestionContratos() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("Gestión de Contratos");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 17));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 3;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Id:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		jtfId = new JTextField();
		jtfId.setEnabled(false);
		GridBagConstraints gbc_jtfId = new GridBagConstraints();
		gbc_jtfId.gridwidth = 2;
		gbc_jtfId.insets = new Insets(0, 0, 5, 0);
		gbc_jtfId.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfId.gridx = 1;
		gbc_jtfId.gridy = 1;
		add(jtfId, gbc_jtfId);
		jtfId.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tipo de Contrato:");
		GridBagConstraints gbc_lblNewLabel_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1.gridx = 0;
		gbc_lblNewLabel_1_1.gridy = 2;
		add(lblNewLabel_1_1, gbc_lblNewLabel_1_1);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 2;
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 2;
		add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		jrbCuenta = new JRadioButton("Cuenta Bancaria");
		jrbCuenta.setSelected(true);
		GridBagConstraints gbc_jrbCuenta = new GridBagConstraints();
		gbc_jrbCuenta.insets = new Insets(0, 0, 5, 5);
		gbc_jrbCuenta.gridx = 0;
		gbc_jrbCuenta.gridy = 0;
		panel.add(jrbCuenta, gbc_jrbCuenta);
		
		jrbCredito = new JRadioButton("Tarjeta Crédito");
		GridBagConstraints gbc_jrbCredito = new GridBagConstraints();
		gbc_jrbCredito.insets = new Insets(0, 0, 5, 0);
		gbc_jrbCredito.gridx = 1;
		gbc_jrbCredito.gridy = 0;
		panel.add(jrbCredito, gbc_jrbCredito);
		
		jrbDebito = new JRadioButton("Tarjeta Débito");
		GridBagConstraints gbc_jrbDebito = new GridBagConstraints();
		gbc_jrbDebito.anchor = GridBagConstraints.WEST;
		gbc_jrbDebito.insets = new Insets(0, 0, 0, 5);
		gbc_jrbDebito.gridx = 0;
		gbc_jrbDebito.gridy = 1;
		panel.add(jrbDebito, gbc_jrbDebito);
		
		jrbPrestamo = new JRadioButton("Préstamo");
		GridBagConstraints gbc_jrbPrestamo = new GridBagConstraints();
		gbc_jrbPrestamo.anchor = GridBagConstraints.WEST;
		gbc_jrbPrestamo.gridx = 1;
		gbc_jrbPrestamo.gridy = 1;
		panel.add(jrbPrestamo, gbc_jrbPrestamo);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Descripción:");
		GridBagConstraints gbc_lblNewLabel_1_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1_1.gridx = 0;
		gbc_lblNewLabel_1_1_1.gridy = 3;
		add(lblNewLabel_1_1_1, gbc_lblNewLabel_1_1_1);
		
		jtfDescripcion = new JTextField();
		GridBagConstraints gbc_jtfDescripcion = new GridBagConstraints();
		gbc_jtfDescripcion.gridwidth = 2;
		gbc_jtfDescripcion.insets = new Insets(0, 0, 5, 0);
		gbc_jtfDescripcion.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfDescripcion.gridx = 1;
		gbc_jtfDescripcion.gridy = 3;
		add(jtfDescripcion, gbc_jtfDescripcion);
		jtfDescripcion.setColumns(10);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Usuario:");
		GridBagConstraints gbc_lblNewLabel_1_1_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1_1_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1_1_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1_1_1.gridx = 0;
		gbc_lblNewLabel_1_1_1_1.gridy = 4;
		add(lblNewLabel_1_1_1_1, gbc_lblNewLabel_1_1_1_1);
		
		jcbUsuario = new JComboBox<Usuario>();
		GridBagConstraints gbc_jcbUsuario = new GridBagConstraints();
		gbc_jcbUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_jcbUsuario.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbUsuario.gridx = 1;
		gbc_jcbUsuario.gridy = 4;
		add(jcbUsuario, gbc_jcbUsuario);
		
		JButton btnGestionarUsuario = new JButton("Gestionar Usuario");
		btnGestionarUsuario.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				showJDialogProveedor();
			}
		});
		GridBagConstraints gbc_btnGestionarUsuario = new GridBagConstraints();
		gbc_btnGestionarUsuario.insets = new Insets(0, 0, 5, 0);
		gbc_btnGestionarUsuario.gridx = 2;
		gbc_btnGestionarUsuario.gridy = 4;
		add(btnGestionarUsuario, gbc_btnGestionarUsuario);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Saldo(€):");
		GridBagConstraints gbc_lblNewLabel_1_1_1_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1_1_1_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1_1_1_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1_1_1_1.gridx = 0;
		gbc_lblNewLabel_1_1_1_1_1.gridy = 5;
		add(lblNewLabel_1_1_1_1_1, gbc_lblNewLabel_1_1_1_1_1);
		
		jtfSaldo = new JTextField();
		GridBagConstraints gbc_jtfSaldo = new GridBagConstraints();
		gbc_jtfSaldo.gridwidth = 2;
		gbc_jtfSaldo.insets = new Insets(0, 0, 5, 0);
		gbc_jtfSaldo.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfSaldo.gridx = 1;
		gbc_jtfSaldo.gridy = 5;
		add(jtfSaldo, gbc_jtfSaldo);
		jtfSaldo.setColumns(10);
		
		JLabel lblNewLabel_1_1_1_1_2 = new JLabel("Límite(€):");
		GridBagConstraints gbc_lblNewLabel_1_1_1_1_2 = new GridBagConstraints();
		gbc_lblNewLabel_1_1_1_1_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1_1_1_1_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1_1_1_2.gridx = 0;
		gbc_lblNewLabel_1_1_1_1_2.gridy = 6;
		add(lblNewLabel_1_1_1_1_2, gbc_lblNewLabel_1_1_1_1_2);
		
		jtfLimite = new JTextField();
		GridBagConstraints gbc_jtfLimite = new GridBagConstraints();
		gbc_jtfLimite.gridwidth = 2;
		gbc_jtfLimite.insets = new Insets(0, 0, 5, 0);
		gbc_jtfLimite.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfLimite.gridx = 1;
		gbc_jtfLimite.gridy = 6;
		add(jtfLimite, gbc_jtfLimite);
		jtfLimite.setColumns(10);
		
		JLabel lblNewLabel_1_1_1_1_3 = new JLabel("Fecha de Firma:");
		GridBagConstraints gbc_lblNewLabel_1_1_1_1_3 = new GridBagConstraints();
		gbc_lblNewLabel_1_1_1_1_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1_1_1_1_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1_1_1_3.gridx = 0;
		gbc_lblNewLabel_1_1_1_1_3.gridy = 7;
		add(lblNewLabel_1_1_1_1_3, gbc_lblNewLabel_1_1_1_1_3);
		
		jtfFecha = new JTextField();
		GridBagConstraints gbc_jtfFecha = new GridBagConstraints();
		gbc_jtfFecha.insets = new Insets(0, 0, 5, 0);
		gbc_jtfFecha.gridwidth = 2;
		gbc_jtfFecha.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfFecha.gridx = 1;
		gbc_jtfFecha.gridy = 7;
		add(jtfFecha, gbc_jtfFecha);
		jtfFecha.setColumns(10);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});
		btnGuardar.setFont(new Font("Dialog", Font.BOLD, 14));
		GridBagConstraints gbc_btnGuardar = new GridBagConstraints();
		gbc_btnGuardar.insets = new Insets(0, 0, 0, 5);
		gbc_btnGuardar.gridx = 1;
		gbc_btnGuardar.gridy = 8;
		add(btnGuardar, gbc_btnGuardar);
		
		// Creamos el buttonGroup y agregamos los jradiob.
		jBGroup = new ButtonGroup();
		jBGroup.add(jrbCuenta);
		jBGroup.add(jrbDebito);
		jBGroup.add(jrbCredito);
		jBGroup.add(jrbPrestamo);
		
		// Precarga de Datos.
		loadAllUsuarios();

	}
	
	/**
	 * 
	 * @return
	 */
	private boolean isDescripcionValid() {
		String str = this.jtfDescripcion.getText();
		
		return str.matches(".{4,}");
	}
	
	/**
	 * 
	 * @return
	 */
	private boolean isLimiteValid() {
		String strLimite = this.jtfLimite.getText();
		
		try {
			Float.parseFloat(strLimite);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	/**
	 * 
	 * @return
	 */
	private boolean isSaldoValid() {
		String strSaldo = this.jtfSaldo.getText();
		
		try {
			Float.parseFloat(strSaldo);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	/**
	 * 
	 */
	public void guardar() {
		
		if (!isDescripcionValid()) {
			JOptionPane.showMessageDialog(null,
					"Error. La descripción debe tener una longitud mínima de 4 caracteres.");
			return;
		}
		
		if (!isSaldoValid()) {
			JOptionPane.showMessageDialog(null,
					"Error. El Saldo debe ser un número Float");
			return;
		}
		
		if (!isLimiteValid()) {
			JOptionPane.showMessageDialog(null,
					"Error. El Límite debe ser un número Float");
			return;
		}
		
		Contrato c = new Contrato();
		
		c.setId(Integer.parseInt(this.jtfId.getText()));
		c.setDescripcion(this.jtfDescripcion.getText());
		c.setIdUsuario(((Usuario) this.jcbUsuario.getSelectedItem()).getId());
		c.setSaldo(Float.parseFloat(this.jtfSaldo.getText()));
		c.setLimite(Float.parseFloat(this.jtfLimite.getText()));
		
		String str = this.jtfFecha.getText();
		if (!str.trim().equals("")) {
			try {
				c.setFechaFirma(sdf.parse(this.jtfFecha.getText()));
			} catch (ParseException e) {
				JOptionPane.showMessageDialog(null,
						"Error. La fecha de firma debe tener el siguiente formato: dd/MM/yyyy");
				return;
			}
		} else {
			c.setFechaFirma(null);
		}
		
		if (this.jrbCuenta.isSelected()) {
			c.setIdTipoContrato(1);
		} else if (this.jrbDebito.isSelected()) {
			c.setIdTipoContrato(2);
		} else if (this.jrbCredito.isSelected()) {
			c.setIdTipoContrato(3);
		} else {
			c.setIdTipoContrato(4);
		}
		
		// Actualizamos el registro.
		ControladorContratoJPA.getInstance().updateContrato(c);
		
		// Actualizamos los datos de la Tabla Estudiante.
		panelTabla.updateTable();
		
		// Seleccionamos el registro insertado o modificado.
		this.panelTabla.selectRowById(c);
	}
	
	/**
	 * 
	 */
	public void loadAllUsuarios() {
		
		this.jcbUsuario.removeAllItems();
		
		List<Usuario> l = (List<Usuario>) ControladorUsuarioJPA
				.getInstance().findAll();
		
		for (Usuario usuario : l) {
			this.jcbUsuario.addItem(usuario);
		}
	}
	
	/**
	 * 
	 * @param c
	 */
	public void muestraEnPantalla(Contrato c) {
		if (c != null) {
			this.jtfId.setText("" + c.getId());
			this.jtfDescripcion.setText(c.getDescripcion());
			this.jtfSaldo.setText("" + c.getSaldo());
			this.jtfLimite.setText("" + c.getLimite());
			
			if (c.getFechaFirma() != null) {
				this.jtfFecha.setText(sdf.format(c.getFechaFirma()));
			} else {
				this.jtfFecha.setText("");
			}
			
			
			for (int i = 0; i < this.jcbUsuario.getItemCount(); i++) {
				if (this.jcbUsuario.getItemAt(i).getId() == c.getIdUsuario()) {
					this.jcbUsuario.setSelectedIndex(i);
				}
			}
			
			switch (c.getIdTipoContrato()) {
			case 1:
				this.jrbCuenta.setSelected(true);
				break;
			case 2:
				this.jrbDebito.setSelected(true);
				break;
			case 3:
				this.jrbCredito.setSelected(true);
				break;
			case 4:
				this.jrbPrestamo.setSelected(true);
				break;
			}
			
		}
	}
	
	/**
	 * 
	 */
	private void showJDialogProveedor() {
		
		JDialog dialogo = new JDialog();
		// El usuario no puede redimensionar el diálogo
		dialogo.setResizable(true);
		// título del díalogo
		dialogo.setTitle("JDialog - Gestión Usuarios");
		// Pasamos parámetros al constructor del PanelGestionUsuarios.
		dialogo.setContentPane(new PanelGestionUsuarios(this, dialogo));
		// Empaquetar el di�logo hace que todos los componentes ocupen el espacio que deben y el lugar adecuado
		dialogo.pack();
		// El usuario no puede hacer clic sobre la ventana padre, si el Di�logo es modal
		dialogo.setModal(true);
		// Centro el di�logo en pantalla
		dialogo.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width)/2 - dialogo.getWidth()/2, 
				(Toolkit.getDefaultToolkit().getScreenSize().height)/2 - dialogo.getHeight()/2);
		// Muestro el di�logo en pantalla
		dialogo.setVisible(true);
	}

	public JTextField getJtfId() {
		return jtfId;
	}

	public void setJtfId(JTextField jtfId) {
		this.jtfId = jtfId;
	}

}
