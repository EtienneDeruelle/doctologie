package display;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;

import main.MainSearch;


public class GoButton extends JButton {
	
	MainSearch Searcher = null;
	
	public GoButton(){
		super("GO");
		this.setBackground(new Color(77,77,77));
		this.setForeground(Color.BLACK);
		this.setVisible(true);
		
			this.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent event) {
					//new SearchWindow(TopPanel.textField.getText());
					System.out.println(TopPanel.textField.getText());
					try {
						DiseaseWindow windowD = new DiseaseWindow();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
			
		
	}
}
