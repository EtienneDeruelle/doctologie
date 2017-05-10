package display;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.DisplayMode;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;

import main.MainSearch;
import business.DiseasesCollection;


public class DiseaseWindow extends JFrame {
	
	private JPanel panelDiseases = new JPanel();
	private JPanel panelDrugs = new JPanel();

    private JScrollPane scroll;
	
	public DiseaseWindow () throws IOException {
		
		this.setResizable(false);
		this.setSize(800,600);
		this.setTitle("Doctologie");
		BufferedImage img = ImageIO.read(new File("Images/backgroundred.jpg"));
		this.setIconImage(new ImageIcon("Images/IconRed.jpg").getImage());
		this.setContentPane(new JLabel(new ImageIcon(img)));
		this.setLayout(new BorderLayout());
		
		
		
		DiseasesCollection diseases = MainSearch.searchDiseaseBySign(TopPanel.textField.getText());
		
		JLabel[] textLabelGeneticalDisease = new JLabel[diseases.getGenteticalDiseases().size()];
		JLabel[] textLabelRareDisease = new JLabel[diseases.getRareDiseases().size()];
		
		GridLayout gDisease = new GridLayout(diseases.getGenteticalDiseases().size()+diseases.getRareDiseases().size(),1);
		GridLayout gDrugs = new GridLayout(diseases.getGenteticalDiseases().size()+diseases.getRareDiseases().size(),1);
		
		panelDiseases.setLayout(gDisease);
		panelDrugs.setLayout(gDrugs);
		
		
		for(int i = 0 ; i <  diseases.getGenteticalDiseases().size() ; i++)
		{
			textLabelGeneticalDisease[i] = new JLabel("<html>"+diseases.getGenteticalDiseases().get(i)+"<br><html>");
			textLabelGeneticalDisease[i].setSize(200,200);
			panelDiseases.add(textLabelGeneticalDisease[i]);
			panelDrugs.add(textLabelGeneticalDisease[i]);
		}
		
		for(int i = 0 ; i <  diseases.getRareDiseases().size() ; i++)
		{
			textLabelRareDisease[i] = new JLabel("<html>"+diseases.getRareDiseases().get(i)+"<br><html>");
			textLabelRareDisease[i].setSize(200,200);
			panelDiseases.add(textLabelRareDisease[i]);
			panelDrugs.add(textLabelRareDisease[i]);
		}
		
		
		
		Container contenu = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,panelDiseases,panelDrugs);   
		panelDiseases.setBackground(Color.orange);
		panelDrugs.setBackground(Color.blue);
		scroll = new JScrollPane(panelDiseases,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scroll = new JScrollPane(panelDrugs,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		contenu.add(panelDiseases);
		
		contenu.add(panelDrugs);
		
		this.getContentPane().add(contenu);
        // Ou juste this.add(contenu);
		
		
		
        this.setVisible(true);
		
	}

}