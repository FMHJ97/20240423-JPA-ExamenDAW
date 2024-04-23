package examen.views;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JTextField;

import examen.controladores.ControladorContratoJPA;
import examen.controladores.ControladorUsuarioJPA;
import examen.entities.Contrato;
import examen.entities.Usuario;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelGestionUsuarios extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField jtfId;
	private JTextField jtfUsuario;
	private JPasswordField jpfContrasena;
	private JTextField jtfEmail;
	private JComboBox<String> jcbColor;
	
	// El componente JColorChooser y el color a aplicar.
	private Color colorPanel;
	
	private PanelGestionContratos panelGestionContratos;
	private JDialog dialogo;

	/**
	 * Create the panel.
	 * @param dialogo 
	 * @param panelGestionContratos 
	 */
	public PanelGestionUsuarios(PanelGestionContratos panelGestionContratos, JDialog dialogo) {
		
		this.panelGestionContratos = panelGestionContratos;
		this.dialogo = dialogo;
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("Gestión de Usuarios");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 17));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 2;
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
		gbc_jtfId.insets = new Insets(0, 0, 5, 0);
		gbc_jtfId.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfId.gridx = 1;
		gbc_jtfId.gridy = 1;
		add(jtfId, gbc_jtfId);
		jtfId.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Usuario:");
		GridBagConstraints gbc_lblNewLabel_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1.gridx = 0;
		gbc_lblNewLabel_1_1.gridy = 2;
		add(lblNewLabel_1_1, gbc_lblNewLabel_1_1);
		
		jtfUsuario = new JTextField();
		GridBagConstraints gbc_jtfUsuario = new GridBagConstraints();
		gbc_jtfUsuario.insets = new Insets(0, 0, 5, 0);
		gbc_jtfUsuario.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfUsuario.gridx = 1;
		gbc_jtfUsuario.gridy = 2;
		add(jtfUsuario, gbc_jtfUsuario);
		jtfUsuario.setColumns(10);
		
		JLabel lblNewLabel_1_2 = new JLabel("Contraseña:");
		GridBagConstraints gbc_lblNewLabel_1_2 = new GridBagConstraints();
		gbc_lblNewLabel_1_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_2.gridx = 0;
		gbc_lblNewLabel_1_2.gridy = 3;
		add(lblNewLabel_1_2, gbc_lblNewLabel_1_2);
		
		jpfContrasena = new JPasswordField();
		GridBagConstraints gbc_jpfContrasena = new GridBagConstraints();
		gbc_jpfContrasena.insets = new Insets(0, 0, 5, 0);
		gbc_jpfContrasena.fill = GridBagConstraints.HORIZONTAL;
		gbc_jpfContrasena.gridx = 1;
		gbc_jpfContrasena.gridy = 3;
		add(jpfContrasena, gbc_jpfContrasena);
		
		JLabel lblNewLabel_1_3 = new JLabel("Email:");
		GridBagConstraints gbc_lblNewLabel_1_3 = new GridBagConstraints();
		gbc_lblNewLabel_1_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_3.gridx = 0;
		gbc_lblNewLabel_1_3.gridy = 4;
		add(lblNewLabel_1_3, gbc_lblNewLabel_1_3);
		
		jtfEmail = new JTextField();
		GridBagConstraints gbc_jtfEmail = new GridBagConstraints();
		gbc_jtfEmail.insets = new Insets(0, 0, 5, 0);
		gbc_jtfEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtfEmail.gridx = 1;
		gbc_jtfEmail.gridy = 4;
		add(jtfEmail, gbc_jtfEmail);
		jtfEmail.setColumns(10);
		
		JLabel lblNewLabel_1_4 = new JLabel("Color Preferido:");
		GridBagConstraints gbc_lblNewLabel_1_4 = new GridBagConstraints();
		gbc_lblNewLabel_1_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_4.gridx = 0;
		gbc_lblNewLabel_1_4.gridy = 5;
		add(lblNewLabel_1_4, gbc_lblNewLabel_1_4);
		
		jcbColor = new JComboBox<String>();
		GridBagConstraints gbc_jcbColor = new GridBagConstraints();
		gbc_jcbColor.insets = new Insets(0, 0, 5, 0);
		gbc_jcbColor.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbColor.gridx = 1;
		gbc_jcbColor.gridy = 5;
		add(jcbColor, gbc_jcbColor);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});
		GridBagConstraints gbc_btnGuardar = new GridBagConstraints();
		gbc_btnGuardar.anchor = GridBagConstraints.EAST;
		gbc_btnGuardar.gridx = 1;
		gbc_btnGuardar.gridy = 6;
		add(btnGuardar, gbc_btnGuardar);
		
		// Precargamos los colores.
		loadCodigoColor();
		
		// Mostramos el usuario.
		showUsuario();

	}
	
	/**
	 * 
	 * @return
	 */
	private boolean esEmailValido() {
		
		String email = this.jtfEmail.getText();
		
		if (email.matches(".+[@].+[.].+")) {
			return true;
		}
		return false;
	}
	
	/**
	 * 
	 * @return
	 */
	private boolean isPasswordEmpty() {
		String str = this.jpfContrasena.getText();
		return str.isEmpty();
	}
	
	/**
	 * 
	 * @return
	 */
	private boolean isUsernameEmpty() {
		String str = this.jtfUsuario.getText();
		return str.isEmpty();
	}
	
	
	/**
	 * 
	 */
	private void guardar() {
		
		if (!esEmailValido()) {
			JOptionPane.showMessageDialog(null, "Error. Introduzca un email válido.");
			return;
		}
		
		if (isUsernameEmpty()) {
			JOptionPane.showMessageDialog(null, "El usuario no debe estar vacío");
			return;
		}
		
		if (isPasswordEmpty()) {
			JOptionPane.showMessageDialog(null, "La contraseña no debe estar vacía");
			return;
		}
		
		Usuario u = new Usuario();
		
		u.setId(Integer.parseInt(this.jtfId.getText()));
		u.setNombreUsuario(this.jtfUsuario.getText());
		u.setPassword(this.jpfContrasena.getText());
		u.setEmail(this.jtfEmail.getText());
		u.setColorPreferido((String) this.jcbColor.getSelectedItem());
		
		// Update
		ControladorUsuarioJPA.getInstance().updateUsuario(u);
		
		String color = (String) this.jcbColor.getSelectedItem();
		Color colorElegido = Color.decode(color);
		this.setBackground(colorElegido);
		
		// Al cerrar el JDialog.
		this.dialogo.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		this.dialogo.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				super.windowClosing(e);
				panelGestionContratos.loadAllUsuarios();;
				
				int idContratoActual = Integer.parseInt(panelGestionContratos.getJtfId().getText());
				Contrato c = (Contrato) ControladorContratoJPA.getInstance()
						.findById(idContratoActual);
				panelGestionContratos.muestraEnPantalla(c);
			}
		});
		
	}
	
	
	/**
	 * 
	 */
	private void showUsuario() {
		
		Usuario u = (Usuario) this.panelGestionContratos
				.jcbUsuario.getSelectedItem();
		
		if (u != null) {
			
			this.jtfId.setText("" + u.getId());
			this.jtfUsuario.setText(u.getNombreUsuario());
			this.jpfContrasena.setText(u.getPassword());
			this.jtfEmail.setText(u.getEmail());
			
			for (int i = 0; i < this.jcbColor.getItemCount(); i++) {
				if (this.jcbColor.getItemAt(i).equals(u.getColorPreferido())) {
					this.jcbColor.setSelectedIndex(i);
					
					this.colorPanel = Color.decode(u.getColorPreferido());
					this.setBackground(colorPanel);
				}
			}
			
		}
	}
	
	/**
	 * 
	 */
	private void loadCodigoColor() {
		this.jcbColor.addItem("#FF00FF");
		this.jcbColor.addItem("#9890A5");
		this.jcbColor.addItem("#765456");
		this.jcbColor.addItem("#879876");
		this.jcbColor.setSelectedIndex(0);
	}

}
