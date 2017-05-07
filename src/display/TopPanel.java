package display;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JTextField;




public class TopPanel extends JPanel {
	private GoButton GBut = new GoButton();
	private ButTrans TransButG = new ButTrans();
	private ButTrans TransButD = new ButTrans();
    static JTextField textField = new JTextField();
	
	public TopPanel() {
		this.setLayout(new BorderLayout());
		this.setOpaque(false);
		this.setVisible(true);
		
		Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		int x  = (int)dimension.getWidth();
		//System.out.println(x/6);
		textField.setColumns(x/30);					 //On lui donne un nombre de colonnes à afficher
		textField.setBackground(Color.WHITE);
		Font police = new Font("Arial", Font.BOLD, 14);
		textField.setFont(police);
		textField.setText("Tapez ici votre recherche...");
		textField.addMouseListener( new  MouseAdapter(){
			 
			 public void mousePressed(MouseEvent e) {
				 textField.setText("");
			 } 
		});
		textField.addKeyListener(
	            new KeyListener(){

	                public void keyPressed(KeyEvent e){

	                    if(e.getKeyChar() == KeyEvent.VK_ENTER){
	                    	if (//AlmostLegalTube.isConnected()
									true){
								//new SearchWindow(textField.getText());
							}
							else{
								/*
								ArrayList<VideoOffline> listeVideo = OfflineSearch.searchOffline(AlmostLegalTube.getClient().getXMLPath(), textField.getText());
								OfflineSearchWindow sw = new OfflineSearchWindow(listeVideo);
								*/
							}
	                    }
	                    else{
	                    }
	                }

					@Override
					public void keyReleased(KeyEvent e) {
						//Ne rien faire
						
					}

					@Override
					public void keyTyped(KeyEvent e) {
						//Ne rien faire
						
					}
	            }
	        );
		this.add(TransButG,BorderLayout.WEST);
		this.add(textField,BorderLayout.CENTER);
		JPanel east = new JPanel(new BorderLayout());
		east.add(GBut, BorderLayout.WEST);
		east.add(TransButD, BorderLayout.CENTER);
		east.setOpaque(false);
		this.add(east,BorderLayout.EAST);
	}
}
