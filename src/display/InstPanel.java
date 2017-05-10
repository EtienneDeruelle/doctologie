package display;

import java.awt.BorderLayout;
import java.awt.Color;
import java.io.IOException;
import javax.swing.JPanel;


public class InstPanel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ButtonInst boutonA = new  ButtonInst();

	
	public InstPanel () throws IOException {
		this.setLayout(new BorderLayout());
		this.add(boutonA);
		this.setBackground(new Color(0,0,0,1));
		this.setOpaque(false);
		this.setVisible(true);
	}
	
	
	
}
