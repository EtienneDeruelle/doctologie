package display;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;


public class GoButton extends JButton {
	public GoButton(){
		super("GO");
		this.setBackground(new Color(50,205,50));
		this.setForeground(Color.BLACK);
		this.setVisible(true);
		
			this.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent event) {
					if (//AlmostLegalTube.isConnected()
							true){
						//new SearchWindow(TopPanel.textField.getText());
						System.out.println(TopPanel.textField.getText());
					} else {
						/*
						ArrayList<VideoOffline> listeVideo = OfflineSearch.searchOffline(AlmostLegalTube.getClient().getXMLPath(), TopPanel.textField.getText());
						OfflineSearchWindow sw = new OfflineSearchWindow(listeVideo);
						*/
					}
				}
			});
			
		
	}
}
