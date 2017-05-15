package display;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.text.BadLocationException;

import index.IndexFilesATC;
import index.IndexFilesObo;
import index.IndexFilesOmim;
import index.IndexFilesStitch;


@SuppressWarnings("serial")
public class ButtonIndex extends JButton {
	
	private ImageIcon icon = new ImageIcon("Images/DL.png"); 			
	private static IndexFilesATC IndexATC ;
	private static IndexFilesObo IndexObo ;
	private static IndexFilesOmim IndexOmim ;
	private static IndexFilesStitch IndexStitch ;
	
	public ButtonIndex(){
		super();														
		this.setIcon(this.icon);											
		this.setBackground(new Color(0,0,0,1));							
		this.setBorderPainted(false);
		this.setContentAreaFilled(false);
		this.setFocusPainted(false);
		
		
		this.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event) {
				//System.out.println("Download");;
				try {
					IndexATC.main2(null);
					System.out.println("La génération d'index fonctionne !");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					IndexObo.main2(null);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					IndexOmim.main2(null);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					IndexStitch.main2(null);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IndexOutOfBoundsException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (BadLocationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				}
		});	
	}
	
}

