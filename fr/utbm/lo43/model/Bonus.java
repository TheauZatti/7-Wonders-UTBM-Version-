package fr.utbm.lo43.model;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

public class Bonus {

	private String name;
	
	Bonus(){
		this.name = "";
	}
	
	Bonus(String name){
		this.name = name;
	}
	
	public String getBonusName() {
		return this.name;
	}
	

	public String giveBonus(Player p, boolean gameEnd) {
		if (this.name.equalsIgnoreCase("Trade_Wonder")) {
			if(!gameEnd) {
				int step = p.getWonder().getCurrentStep();
				p.addIzlyMoney(step * 3);
			}else {
				int step = p.getWonder().getCurrentStep();
				p.addECTS(step);
			}
		} else if (this.name.equalsIgnoreCase("Trade_Brown")) {
			if(!gameEnd) {
				for(Card c : p.getBuildings()) {
					if(c instanceof RessourceCard) {
						if(((RessourceCard)c).getColor().equals(new Color(97, 37, 0))){
							p.addIzlyMoney(1);
						}
					}
				}
			}else {
				for(Card c : p.getBuildings()) {
					if(c instanceof RessourceCard) {
						if(((RessourceCard)c).getColor().equals(new Color(97, 37, 0))){
							p.addECTS(1);
						}
					}
				}
			}
		} else if (this.name.equalsIgnoreCase("Trade_Yellow")) {
			if(!gameEnd) {
				for(Card c : p.getBuildings()) {
					if(c instanceof TradeCard) {
						p.addIzlyMoney(1);
					}
				}
			}else {
				for(Card c : p.getBuildings()) {
					if(c instanceof TradeCard) {
						p.addECTS(1);
					}
				}
			}
		} else if (this.name.equalsIgnoreCase("Trade_Gray")) {
			if(!gameEnd) {
				for(Card c : p.getBuildings()) {
					if(c instanceof RessourceCard) {
						if(((RessourceCard)c).getColor().equals(new Color(138, 138, 138))){
							p.addIzlyMoney(2);
						}
					}
				}
			}else {
				for(Card c : p.getBuildings()) {
					if(c instanceof RessourceCard) {
						if(((RessourceCard)c).getColor().equals(new Color(138, 138, 138))){
							p.addECTS(2);
						}
					}
				}
			}
		} else if (this.name.equalsIgnoreCase("Trade_RU")) {
			if(!gameEnd) {
				for(Card c : p.getBuildings()) {
					if(c instanceof RessourceCard) {
						if(((RessourceCard)c).getColor().equals(new Color(97, 37, 0))){
							p.addIzlyMoney(1);
						}
					}
				}
				
				for(Card c : p.getNeighbours().get(0).getBuildings()) {
					if(c instanceof RessourceCard) {
						if(((RessourceCard)c).getColor().equals(new Color(97, 37, 0))){
							p.addIzlyMoney(1);
						}
					}
				}
				
				for(Card c : p.getNeighbours().get(1).getBuildings()) {
					if(c instanceof RessourceCard) {
						if(((RessourceCard)c).getColor().equals(new Color(97, 37, 0))){
							p.addIzlyMoney(1);
						}
					}
				}
			}
		} else if (this.name.equalsIgnoreCase("Trade_Job")) {
			if(!gameEnd) {
				for(Card c : p.getBuildings()) {
					if(c instanceof RessourceCard) {
						if(((RessourceCard)c).getColor().equals(new Color(138, 138, 138))){
							p.addIzlyMoney(2);
						}
					}
				}

				for(Card c : p.getNeighbours().get(0).getBuildings()) {
					if(c instanceof RessourceCard) {
						if(((RessourceCard)c).getColor().equals(new Color(138, 138, 138))){
							p.addIzlyMoney(2);
						}
					}
				}
				
				for(Card c : p.getNeighbours().get(1).getBuildings()) {
					if(c instanceof RessourceCard) {
						if(((RessourceCard)c).getColor().equals(new Color(138, 138, 138))){
							p.addIzlyMoney(2);
						}
					}
				}
			}
		} else if (this.name.equalsIgnoreCase("Guild_biere")) {
			p.addECTS(p.getNeighbours().get(0).getLooseCoins() + p.getNeighbours().get(1).getLooseCoins());
		} else if (this.name.equalsIgnoreCase("Guild_welcome")) {
			for(Card c : p.getNeighbours().get(0).getBuildings()) {
				if(c instanceof ScienceCard) {
						p.addECTS(1);
				}
			}
			for(Card c : p.getNeighbours().get(1).getBuildings()) {
				if(c instanceof ScienceCard) {
						p.addECTS(1);
				}
			}
		} else if (this.name.equalsIgnoreCase("Guild_gazett")) {
			for(Card c : p.getNeighbours().get(0).getBuildings()) {
				if(c instanceof MilitaryCard) {
						p.addECTS(1);
				}
			}
			for(Card c : p.getNeighbours().get(1).getBuildings()) {
				if(c instanceof MilitaryCard) {
						p.addECTS(1);
				}
			}
		} else if (this.name.equalsIgnoreCase("Guild_potards")) {
			for(Card c : p.getNeighbours().get(0).getBuildings()) {
				if(c instanceof RessourceCard) {
					if(((RessourceCard)c).getColor().equals(new Color(97, 37, 0))){
						p.addECTS(1);
					}
				}
			}
			for(Card c : p.getNeighbours().get(1).getBuildings()) {
				if(c instanceof RessourceCard) {
					if(((RessourceCard)c).getColor().equals(new Color(97, 37, 0))){
						p.addECTS(1);
					}
				}
			}
		} else if (this.name.equalsIgnoreCase("Guild_reflex")) {
			for(Card c : p.getBuildings()) {
				if(c instanceof RessourceCard || c instanceof GuildCard) {
					p.addECTS(1);
				}
			}
		} else if (this.name.equalsIgnoreCase("Guild_troll")) {
			ArrayList<String> symbols = new ArrayList<String>();
			symbols.add("Muscles");
			symbols.add("Connaissances");
			symbols.add("Soirees");
			
			Random r = new Random();
			int choice = r.nextInt(3);
			String symbol = symbols.get(choice);
			return symbol;
			
		} else if (this.name.equalsIgnoreCase("Guild_robot")) {
			for(Card c : p.getNeighbours().get(0).getBuildings()) {
				if(c instanceof CivilCard) {
						p.addECTS(1);
				}
			}
			for(Card c : p.getNeighbours().get(1).getBuildings()) {
				if(c instanceof CivilCard) {
						p.addECTS(1);
				}
			}
		} else if (this.name.equalsIgnoreCase("Guild_dj")) {
			for(Card c : p.getNeighbours().get(0).getBuildings()) {
				if(c instanceof RessourceCard) {
					if(((RessourceCard)c).getColor().equals(new Color(138, 138, 138))){
						p.addECTS(2);
					}
				}
			}
			for(Card c : p.getNeighbours().get(1).getBuildings()) {
				if(c instanceof RessourceCard) {
					if(((RessourceCard)c).getColor().equals(new Color(138, 138, 138))){
						p.addECTS(2);
					}
				}
			}
		} else if (this.name.equalsIgnoreCase("Guild_cinema")) {
			for(Card c : p.getNeighbours().get(0).getBuildings()) {
				if(c instanceof TradeCard) {
						p.addECTS(1);
				}
			}
			for(Card c : p.getNeighbours().get(1).getBuildings()) {
				if(c instanceof TradeCard) {
						p.addECTS(1);
				}
			}
		} else if (this.name.equalsIgnoreCase("Guild_zik")) {
			int step = p.getWonder().getCurrentStep();
			int stepRight = p.getNeighbours().get(1).getWonder().getCurrentStep();
			int stepLeft = p.getNeighbours().get(0).getWonder().getCurrentStep();
			p.addIzlyMoney((step + stepLeft + stepRight)*3);
		}
		return "";
	}
}
