package display;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;


@SuppressWarnings("serial")
public class ButtonInst extends JButton {
	
	private ImageIcon MID = new ImageIcon("Images/MID.png");		
	
	
	public ButtonInst (){
		super();														
		this.setIcon(this.MID);												
		this.setBackground(new Color(0,0,0,1));							
		this.setBorderPainted(false);
		this.setContentAreaFilled(false);
		this.setFocusPainted(false);
		
		
	}
	
}

