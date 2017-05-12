package display;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JTextArea;

import main.MainSearch;
import business.DiseasesCollection;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JLabel;



public class DiseaseWindow extends JFrame {
	
	
	private String textDiseaseGenetical = "";
	private String textDiseaseRare = "";
	private String textDrug = "";
	
	public String getTextDiseaseGenetical()
	{
		return textDiseaseGenetical;
	}

	public void setTextDiseaseGenetical(String textDiseaseGenetical)
	{
		this.textDiseaseGenetical = textDiseaseGenetical;
	}

	public String getTextDiseaseRare()
	{
		return textDiseaseRare;
	}

	public void setTextDiseaseRare(String textDiseaseRare)
	{
		this.textDiseaseRare = textDiseaseRare;
	}

	public String getTextDrug()
	{
		return textDrug;
	}

	public void setTextDrug(String textDrug)
	{
		this.textDrug = textDrug;
	}

	public DiseaseWindow () {		
		this.setTitle("Doctologie");
		this.setSize(1000, 600);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setIconImage(new ImageIcon("Images/IconRed.jpg").getImage());
		
		JTextArea textAreaDisease = new JTextArea();
		textAreaDisease.setBackground(new Color(0, 204, 0));
		textAreaDisease.setForeground(Color.WHITE);		
		textAreaDisease.setColumns(30);
		getContentPane().add(textAreaDisease, BorderLayout.WEST);
		//textAreaDisease.setText("test");
		
		JTextArea textAreaDrugs = new JTextArea();
		textAreaDrugs.setBackground(new Color(0, 153, 0));
		textAreaDrugs.setForeground(Color.WHITE);
		textAreaDrugs.setColumns(30);
		getContentPane().add(textAreaDrugs, BorderLayout.EAST);
		//textAreaDrugs.setText("test");
		
		JTextArea textAreaGenetical = new JTextArea();
		textAreaGenetical.setBackground(new Color(51, 204, 51));
		textAreaGenetical.setColumns(30);
		getContentPane().add(textAreaGenetical, BorderLayout.CENTER);
		
		
		JScrollPane scroll = new JScrollPane(textAreaDisease);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		getContentPane().add(scroll, BorderLayout.WEST);
		
		JScrollPane scroll2 = new JScrollPane(textAreaDrugs);
		scroll2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		getContentPane().add(scroll2, BorderLayout.EAST);
		
		JScrollPane scroll3 = new JScrollPane(textAreaGenetical);
		scroll3.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		getContentPane().add(scroll3, BorderLayout.CENTER);
		
		
		DiseasesCollection diseases = MainSearch.searchDiseaseBySign(TopPanel.textField.getText());
		//System.out.println(diseases);
		//System.out.println("TEXT FIELD : "+TopPanel.textField.getText());
		ArrayList<String> drugs = MainSearch.searchDrugBySign(TopPanel.textField.getText());
		
		
		for(int i = 0 ; i <  diseases.getGenteticalDiseases().size() ; i++)
		{
			textDiseaseGenetical += diseases.getGenteticalDiseases().get(i)+"\n";
		}
		
		for(int i = 0 ; i <  diseases.getRareDiseases().size() ; i++)
		{
			textDiseaseRare += diseases.getRareDiseases().get(i)+"\n";
		}
		textAreaDisease.setText(getTextDiseaseGenetical());
		
		for(int i = 0 ; i < drugs.size() ; i++)
		{
			textDrug += drugs.get(i)+"\n";
		}
		textAreaDrugs.setText(textDrug);
		textAreaGenetical.setText(getTextDiseaseRare());
		textAreaDisease.setEnabled(false);
		textAreaDrugs.setEnabled(false);
		textAreaGenetical.setEnabled(false);
		
		Font police = new Font("Arial", Font.BOLD, 14);
		
		JLabel lblGeneticalDiseases = new JLabel("Rare diseases :");
		lblGeneticalDiseases.setFont(police);
		scroll3.setColumnHeaderView(lblGeneticalDiseases);
		
		JLabel lblRareAndGenetical = new JLabel("Genetical diseases : ");
		lblRareAndGenetical.setForeground(new Color(0, 0, 0));		
		lblRareAndGenetical.setBackground(new Color(0, 204, 0));
		lblRareAndGenetical.setFont(police);
		scroll.setColumnHeaderView(lblRareAndGenetical);		
		
		JLabel lblDrugs = new JLabel("Drugs : ");
		lblDrugs.setBackground(new Color(0, 153, 0));
		lblDrugs.setFont(police);
		scroll2.setColumnHeaderView(lblDrugs);
		
		
		
		this.setVisible(true);
		
	}

}