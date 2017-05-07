package display;

import java.awt.BorderLayout;
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


public class MainWindow extends JFrame {
	//static SearchResult searchResult;
	private ButtonWindow buttonwindow = new ButtonWindow();
	private TopPanel TopP = new TopPanel();
	private JPanel JPG = new JPanel();
	private JPanel JPD = new JPanel();
	//public JPDown JPDownie = new JPDown();
	int y;
	int x;
	static boolean testVid=false;
	static JPanel lastvideo;
	
	public MainWindow () throws IOException {
		
		this.setResizable(false);
		this.setTitle("AlmostLegalTube");
		BufferedImage img = ImageIO.read(new File("Images/backgroundred.jpg"));
		this.setIconImage(new ImageIcon("Images/IconRed.jpg").getImage());
		this.setContentPane(new JLabel(new ImageIcon(img)));
		this.setLayout(new BorderLayout());
		JPG.setLayout(new BorderLayout());
		JPD.setLayout(new BorderLayout());
			
	    Insets insets = Toolkit.getDefaultToolkit().getScreenInsets(java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration());
	    DisplayMode mode = java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode();
	    Rectangle bounds = new Rectangle();
	    bounds.x = insets.left;
	    bounds.y = insets.top;
	    bounds.width = mode.getWidth() - (insets.left + insets.right);
	    bounds.height = mode.getHeight() - (insets.top + insets.bottom);
	    
		//System.out.println("Bounds :" + bounds.width);
		
		this.add(JPG, BorderLayout.NORTH);
		this.add(JPD, BorderLayout.EAST);
		JPD.add(buttonwindow, BorderLayout.EAST);
		JPG.add(TopP, BorderLayout.NORTH);
		
		//this.add(YoutubeViewer.getBrowserPanel("https://www.youtube.com/embed/b3KUyPKbR7Q"), BorderLayout.CENTER); // displays the video
		JPG.setOpaque(false);
		JPG.setVisible(true);
		JPD.setOpaque(false);
		JPD.setVisible(true);
		//JPDownie.setVisible(false);
		//this.add(JPDownie, BorderLayout.SOUTH);
		this.setSize(bounds.width, bounds.height);
		setVisible(true);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	/*
	public static void setVideoInfo( SearchResult searchResulta) {
		searchResult=searchResulta;
	}

	public SearchResult getVideoInfo() {
		return searchResult;
	}
	*/
	
	public ButtonWindow getButtonWindow() {
		return buttonwindow;
	}
	/*
	public JPDown getJPDownie() {
		return JPDownie;
	}
	*/
	

}