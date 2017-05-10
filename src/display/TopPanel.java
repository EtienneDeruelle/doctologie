package display;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import business.DiseasesCollection;
import main.MainSearch;




public class TopPanel extends JPanel {
	MainSearch Searcher = null;
	private GoButton GBut = new GoButton();
	private ButTrans TransButG = new ButTrans();
	private ButTrans TransButD = new ButTrans();
    static JTextField textField = new JTextField();
    //static ArrayList<JButton> textButtonGeneticalDisease = new ArrayList<JButton>();
    //static ArrayList<JButton> textButtonRareDisease = new ArrayList<JButton>();
	
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
	                    	try {
								//MainSearch.main2(TopPanel.textField.getText());
								
	                    		//MainWindow.getJPT().add(textButton);
	                    		//textLabel.setText("ifdhuighfiughufdhgiuhdfuh");
	                    		
	                    		DiseasesCollection diseases = MainSearch.searchDiseaseBySign(TopPanel.textField.getText());
	                    		
	                    		JButton[] textButtonGeneticalDisease = new JButton[diseases.getGenteticalDiseases().size()];
	                    		JButton[] textButtonRareDisease = new JButton[diseases.getRareDiseases().size()];
	                    		
	                    		GridLayout gDisease = new GridLayout(diseases.getGenteticalDiseases().size()+
	                    				diseases.getRareDiseases().size(),1);
	                    		BorderLayout layout = new BorderLayout();	
	                    		MainWindow.getJPT().setLayout(layout);
	                    		JPanel diseasePanel = new JPanel();
	                    		diseasePanel.setLayout(gDisease);
                    			MainWindow.getJPT().add(diseasePanel, BorderLayout.WEST);
                    			
	                    		//JButton geneticalButton;
	                    		for(int i = 0 ; i <  diseases.getGenteticalDiseases().size() ; i++)
	                    		{
	                    			textButtonGeneticalDisease[i] = new JButton();
	                    			textButtonGeneticalDisease[i].setText(diseases.getGenteticalDiseases().get(i));
	                    			
	                    			/*geneticalButton = new JButton("");
	                    			getTextButtonGeneticalDisease().add(geneticalButton);
	                    			geneticalButton.setVisible(true);
	                    			geneticalButton.setBorderPainted(false);
	                    			geneticalButton.setContentAreaFilled(false);
	                    			geneticalButton.setFocusPainted(false);
	                    			geneticalButton.setText(diseases.getGenteticalDiseases().get(i));*/
	                    			//diseasePanel.add(geneticalButton);
	                    			diseasePanel.add(textButtonGeneticalDisease[i]);
	                    			//textTextAreaGeneticalDisease += diseases.getGenteticalDiseases().get(i)+"\n";
	                    		}
	                    		
	                    		System.out.println(diseases.getGenteticalDiseases().size());
	                    		//JButton rareButton;
	                    		for(int i = 0 ; i <  diseases.getRareDiseases().size() ; i++)
	                    		{
	                    			//textTextAreaRareDiseases += diseases.getRareDiseases().get(i)+"\n";
	                    			textButtonRareDisease[i] = new JButton();
	                    			textButtonRareDisease[i].setText(diseases.getRareDiseases().get(i));
	                    			/*rareButton = new JButton("");
	                    			getTextButtonRareDisease().add(rareButton);
	                    			rareButton.setVisible(true);
	                    			rareButton.setBorderPainted(false);
	                    			rareButton.setContentAreaFilled(false);
	                    			rareButton.setFocusPainted(false);
	                    			rareButton.setText(diseases.getRareDiseases().get(i));*/
	                    			diseasePanel.add(textButtonRareDisease[i]);
	                    			//diseasePanel.add(rareButton);
	                    		}
	                    		System.out.println(diseases.getRareDiseases().size());
	                    		diseasePanel.setVisible(true);
	                    		
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
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
	
	/*public ArrayList<JButton> getTextButtonGeneticalDisease()
	{
		return textButtonGeneticalDisease;
	}
	
	public ArrayList<JButton> getTextButtonRareDisease()
	{
		return textButtonRareDisease;
	}*/
}
