package display;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.DisplayMode;
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
import javax.swing.JSplitPane;


public class DiseaseWindow extends JFrame {
	
	private JPanel panelDiseases = new JPanel();
	private JPanel panelDrugs = new JPanel();
	
	public DiseaseWindow () throws IOException {
		
		this.setResizable(false);
		this.setSize(800,600);
		this.setTitle("Doctologie");
		BufferedImage img = ImageIO.read(new File("Images/backgroundred.jpg"));
		this.setIconImage(new ImageIcon("Images/IconRed.jpg").getImage());
		this.setContentPane(new JLabel(new ImageIcon(img)));
		this.setLayout(new BorderLayout());
		Container contenu = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		
	   
		panelDiseases.setBackground(Color.orange);
		panelDrugs.setBackground(Color.blue);
		contenu.add(panelDiseases);
		contenu.add(panelDrugs);
		
		this.getContentPane().add(contenu);
        // Ou juste this.add(contenu);
        this.setVisible(true);
		
	}

}