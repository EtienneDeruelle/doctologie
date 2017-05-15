package business;

import java.util.ArrayList;

public class DiseasesCollection {
	
	private ArrayList<String> genteticalDiseases;
	private ArrayList<String> rareDiseases;
	
	/**
	 * Constructor of the class
	 * @param genteticalDiseases
	 * @param rareDiseases
	 */
	public DiseasesCollection(ArrayList<String> genteticalDiseases, ArrayList<String> rareDiseases) {
		super();
		this.genteticalDiseases = genteticalDiseases;
		this.rareDiseases = rareDiseases;
	}
	
	/**
	 * Recovers genetic diseases
	 * @return a ArralyList of String(genetic diseases)
	 */
	public ArrayList<String> getGenteticalDiseases() {
		return genteticalDiseases;
	}
	
	/**
	 * Allows to modify genetic diseases
	 * @param genteticalDiseases
	 */
	public void setGenteticalDiseases(ArrayList<String> genteticalDiseases) {
		this.genteticalDiseases = genteticalDiseases;
	}
	
	/**
	 * Recovers rare diseases
	 * @return
	 */
	public ArrayList<String> getRareDiseases() {
		return rareDiseases;
	}
	
	/**
	 * Recovers rare diseases
	 * @param rareDiseases
	 */
	public void setRareDiseases(ArrayList<String> rareDiseases) {
		this.rareDiseases = rareDiseases;
	}
	

}
