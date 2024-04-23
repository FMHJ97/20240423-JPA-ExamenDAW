package examen.views;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.table.DefaultTableModel;

public class PanelTablaContratos extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public PanelTablaContratos() {
		
		// Debemos agregar un Layout sobre nuestro JPanel,
		// antes de agregar el JSplitPane.
		this.setLayout(new BorderLayout());
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		
		this.add(splitPane, BorderLayout.CENTER);
		splitPane.setResizeWeight(0.5);
		
		PanelGestionContratos panelGestionContratos = new PanelGestionContratos();
		splitPane.setRightComponent(panelGestionContratos);
		
		PanelTabla panelTabla = new PanelTabla(panelGestionContratos); 
		splitPane.setLeftComponent(panelTabla);
		
		panelGestionContratos.setPanelTabla(panelTabla);
		
	}

}
