package display;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;


@SuppressWarnings("serial")
public class ButtonInst extends JButton {
	
	private ImageIcon MID = new ImageIcon("Images/MID.png");		//On va chercher l'image (on peut noter que si il ne la trouve pas il ne renvoie pas d'erreur, plut�t �trange)
	
	
	public ButtonInst (){
		super();														//le super constructeur	
		this.setIcon(this.MID);												//Mise en place de l'icone
		this.setBackground(new Color(0,0,0,1));							//g�re la transparence du bouton (en r�alit� noir avec visiblit� 0 xD)
		this.setBorderPainted(false);
		this.setContentAreaFilled(false);
		this.setFocusPainted(false);
		
		
	}
	
}

