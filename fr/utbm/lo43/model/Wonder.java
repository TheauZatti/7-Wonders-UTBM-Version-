package fr.utbm.lo43.model;

import java.util.ArrayList;
import java.util.HashMap;

public class Wonder {

	private String name;
	private int numberOfSteps;
	private ArrayList<Integer> ECTS;
	private Ressource prod;
	private HashMap<Ressource,Integer> firstStepConstructCost;
	private HashMap<Ressource,Integer> secondStepConstructCost;
	private HashMap<Ressource,Integer> thirdStepConstructCost;
	private boolean stepOneBuilded;
	private boolean stepTwoBuilded;
	private boolean stepThreeBuilded;
	private Bonus stepTwoSpec;
	private boolean step2HasChoice;
	private Ressource choosenRes;
	private String type;

	Wonder(){
		this.name = "";
		this.ECTS = new ArrayList<Integer>();
		this.prod = new Ressource();
		this.firstStepConstructCost = new HashMap<Ressource,Integer>();
		this.secondStepConstructCost = new HashMap<Ressource,Integer>();
		this.thirdStepConstructCost = new HashMap<Ressource,Integer>();
		this.stepOneBuilded = false;
		this.stepTwoBuilded = false;
		this.stepThreeBuilded = false;
		this.stepTwoSpec = new Bonus();
		this.step2HasChoice = false;
		this.choosenRes = new Ressource();
	}
	
	Wonder(String name,ArrayList<Integer> ECTS, Ressource prod, HashMap<Ressource,Integer> firstStepConstructCost, HashMap<Ressource,Integer> secondStepConstructCost, HashMap<Ressource,Integer> thirdStepConstructCost, Bonus stepTwoSpec, boolean step2HasChoice){
		this.name = name;
		this.ECTS = ECTS;
		this.prod = prod;
		this.firstStepConstructCost = firstStepConstructCost;
		this.secondStepConstructCost = secondStepConstructCost;
		this.thirdStepConstructCost = thirdStepConstructCost;
		this.stepOneBuilded = false;
		this.stepTwoBuilded = false;
		this.stepThreeBuilded = false;
		this.stepTwoSpec = stepTwoSpec;
		this.step2HasChoice = step2HasChoice;
		this.choosenRes = new Ressource();
	}
	
	public String getName() {
		return this.name;
	}

	public int getNumberOfSteps() {
		return this.numberOfSteps;
	}

	public int getECTS(int age) {
		return this.ECTS.get(age);
	}

	public Ressource getProd() {
		return this.prod;
	}

	public HashMap<Ressource,Integer> getStepConstructCost(int step) {
		if(step == 1) {
			return this.firstStepConstructCost;
		}else if(step == 2) {
			return this.secondStepConstructCost;
		}else if(step == 3) {
			return this.thirdStepConstructCost;
		}else {
			return null;
		}
	}

	public int getCurrentStep() {
		if(stepOneBuilded) {
			return 1;
		}else if(stepTwoBuilded) {
			return 2;
		}else if(stepThreeBuilded) {
			return 3;
		}else {
			return 0;
		}
	}
	
	public boolean isStepBuilt(int step) {
		if(step == 1) {
			return this.stepOneBuilded;
		}else if(step == 2) {
			return this.stepTwoBuilded;
		}else if(step == 3) {
			return this.stepThreeBuilded;
		}else {
			return false;
		}
	}

	public Bonus getBonus() {
		return this.stepTwoSpec;
	}
	
	public boolean buildStep(int currentStep) {
		if(currentStep == 0) {
			return this.stepOneBuilded = true;
		}else if(currentStep == 1) {
			return this.stepTwoBuilded = true;
		}else if(currentStep == 2) {
			return this.stepThreeBuilded = true;
		}else {
			return false;
		}
	}
	
	public boolean hasChoice() {
		return this.step2HasChoice;
	}
	
	public Ressource getChoosenRes() {
		return this.choosenRes;
	}
	
	public void chooseRes(Ressource choice) {
		this.choosenRes = choice;
	}
	
	public String getType() {
		return this.type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
}
