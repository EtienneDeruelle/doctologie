package display;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JTextArea;

import main.MainSearch;
import business.DiseasesCollection;

import java.awt.Color;



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
		this.setSize(950, 500);
		this.setLocationRelativeTo(null);
		
		JTextArea textAreaDisease = new JTextArea();
		textAreaDisease.setBackground(new Color(0, 204, 0));
		textAreaDisease.setForeground(Color.WHITE);		
		textAreaDisease.setColumns(37);
		getContentPane().add(textAreaDisease, BorderLayout.WEST);
		//textAreaDisease.setText("test");
		
		JTextArea textAreaDrugs = new JTextArea();
		textAreaDrugs.setBackground(new Color(0, 153, 0));
		textAreaDrugs.setForeground(Color.WHITE);
		textAreaDrugs.setColumns(37);
		getContentPane().add(textAreaDrugs, BorderLayout.EAST);
		//textAreaDrugs.setText("test");
		
		JScrollPane scroll = new JScrollPane(textAreaDisease);
		scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		getContentPane().add(scroll, BorderLayout.WEST);
		
		JScrollPane scroll2 = new JScrollPane(textAreaDrugs);
		scroll2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		getContentPane().add(scroll2, BorderLayout.EAST);
		
		
		DiseasesCollection diseases = MainSearch.searchDiseaseBySign(TopPanel.textField.getText());
		System.out.println(diseases);
		System.out.println("TEXT FIELD : "+TopPanel.textField.getText());
		
		
		for(int i = 0 ; i <  diseases.getGenteticalDiseases().size() ; i++)
		{
			textDiseaseGenetical += diseases.getGenteticalDiseases().get(i)+"\n";
		}
		
		for(int i = 0 ; i <  diseases.getRareDiseases().size() ; i++)
		{
			textDiseaseRare += diseases.getRareDiseases().get(i)+"\n";
		}
		textAreaDisease.setText(getTextDiseaseGenetical()+getTextDiseaseRare());
		//textAreaDisease.setText("pute");
		
		
		this.setVisible(true);
		
	}

}