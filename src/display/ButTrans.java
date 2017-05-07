package display;

import java.awt.Dimension;

import javax.swing.JButton;

public class ButTrans extends JButton {
	

	public ButTrans(){
		
		super();
		String fill = "";
		Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		int x  = (int)dimension.getWidth();
		int c = 0;
		for (int i=0;i<x/12;i++){
			fill=fill+" ";
			c++;
		};
		System.out.println("valeur de c :" + c);
		this.setText(fill);
		this.setOpaque(false);
		this.setBorderPainted(false);
		this.setContentAreaFilled(false);
		this.setFocusPainted(false);
		this.setVisible(true);
	}
	
}
