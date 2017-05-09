package business;

import java.util.ArrayList;

public class DiseasesCollection {
	
	private ArrayList<String> genteticalDiseases;
	private ArrayList<String> rareDiseases;
	
	public DiseasesCollection(ArrayList<String> genteticalDiseases, ArrayList<String> rareDiseases) {
		super();
		this.genteticalDiseases = genteticalDiseases;
		this.rareDiseases = rareDiseases;
	}
	
	public ArrayList<String> getGenteticalDiseases() {
		return genteticalDiseases;
	}
	public void setGenteticalDiseases(ArrayList<String> genteticalDiseases) {
		this.genteticalDiseases = genteticalDiseases;
	}
	public ArrayList<String> getRareDiseases() {
		return rareDiseases;
	}
	public void setRareDiseases(ArrayList<String> rareDiseases) {
		this.rareDiseases = rareDiseases;
	}
	

}
