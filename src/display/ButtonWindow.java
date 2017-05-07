package display;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JPanel;


public class ButtonWindow extends JPanel {
	
	private ButtonIndex boutonA = new  ButtonIndex();
	private JButton boutonO = new JButton("");
	private JButton boutonD = new JButton("");
	
	
	public ButtonWindow () throws IOException {
		this.setLayout(new BorderLayout());
		this.setOpaque(false);
		this.setVisible(true);
		
		JPanel SectionB = new JPanel();
		this.add(SectionB, BorderLayout.EAST); 
		
		SectionB.setLayout(new GridLayout(6,1));
		SectionB.add(boutonA);
		//SectionB.add(boutonO);
		//SectionB.add(boutonD);
		
		SectionB.setOpaque(false);
		SectionB.setVisible(true);
	}
	
	public JButton getBoutonA() {
		return boutonA;
	}

	public JButton getBoutonO() {
		return boutonO;
	}

	public JButton getBoutonD() {
		return boutonD;
	}
	
	
}
