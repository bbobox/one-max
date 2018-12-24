package ga_solver;

import java.util.ArrayList;
import java.util.Comparator;

import tsp.Solution;

public class BitArrayGenotype implements Individual<Integer> {
	int[] representation;
	int generation;
	int size;
	int idPopulation;

	public  BitArrayGenotype(int n){
		 representation = new int[n];
		 size = n;

	}

	/**
	 * Affiche la representation de l'individu
	 */
	public void print(){
		System.out.print('[');
		for(int i = 0; i<representation.length; i++){
			System.out.print(representation[i]);
		}
		System.out.print(']');
	}

	/**
	 * Calcule le fitness
	 */
	public Integer getFitness(){
		int result = 0;
		for(int i = 0; i<representation.length; i++){
			result+=representation[i];
		}
		return result;
	}

	/**
	 * Compateur de deux  individus en fonction du resultat de leur evalution
	 */
	public static Comparator<Individual> IndividualFintessComparator = new Comparator<Individual>() {

		public int compare(Individual i1, Individual i2) {
		   int evalOfIndividual1 = (Integer) i1.getFitness();
		   int evalOfIndividual2 =  (Integer) i2.getFitness();

		   //ascending order
		   //return evalOfIndividual1 - evalOfIndividual2;

		   //descending order
		   return evalOfIndividual2 - evalOfIndividual1;
	    }
	};

	public static Comparator<Individual> IndividualAgeComparator = new Comparator<Individual>() {

		public int compare(Individual i1, Individual i2) {
		   int evalOfIndividual1 = i1.getGeneration();
		   int evalOfIndividual2 =  i2.getGeneration();

		   //ascending order
		   //return evalOfIndividual1 - evalOfIndividual2;

		   //descending order
		   return evalOfIndividual2 - evalOfIndividual1;
	    }
	};





	public int getGeneration() {
		return generation;
	}

	public void setGeneration(int generation) {
		this.generation = generation;
	}

	/**
	 * @param id : indice element à modifier dans la representation
	 * @param value : nouvelle value
	 */
	public void changeValue(int id, int value){
		representation[id] = value;
	}


	public int[] getRepresentation() {
		return representation;
	}

	public void setRepresentation(int[] representation) {
		this.representation = representation;
	}



	public int[] getClonedRepresentation(){

		int[] clone = representation.clone();

		return clone;
	}

	public Individual<Integer> cloned() {
		Individual i = new BitArrayGenotype(size);
		i.setRepresentation(getClonedRepresentation());
		i.setGeneration(this.getGeneration());
		i.setIdPopulation(this.getIdPopulation());

		return i;
	}



	public int getIdPopulation() {
		return idPopulation;
	}

	public void setIdPopulation(int idPopulation) {
		this.idPopulation = idPopulation;
	}

	public int compareFiteness(Individual i1, Individual i2) {
		// TODO Auto-generated method stub
		return 0;
	}

	public static void main(String args[]){

		Individual i = new BitArrayGenotype(11);
		Individual i2 = i.cloned(); //.clone();
		i.setRepresentation(new int[3]);

		ArrayList<Individual> list = new ArrayList<Individual>();
		list.add(i2);
		list.add(i);
		Individual get = list.get(0);

		list.remove(get);
		System.out.println(list.size());

	}


}

