package fr.utbm.lo43.model;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import fr.utbm.lo43.model.RessourceList;

@SuppressWarnings("serial")
/**CardList is an enum that list all the existing cards in the 7 Wonders game
 * @author Francesco
 */
public enum CardList{	
	
	VOL_DE_STYLO(new RessourceCard(new HashMap<Ressource, Integer>(){{put(RessourceList.STYLOS.getRes(), new Integer(1));}}, false, "vol_de_stylo", new Color(97, 37, 0), 1 , 0, true ,new ArrayList<Integer>() {{add(3);add(4);}})),
	PATES(new RessourceCard(new HashMap<Ressource, Integer>(){{put(RessourceList.NOURRITURE.getRes(), new Integer(1));}}, false, "pates", new Color(97, 37, 0), 1 , 0, true,new ArrayList<Integer>() {{add(3);add(5);}})),
	EAU(new RessourceCard(new HashMap<Ressource, Integer>(){{put(RessourceList.BOISSON.getRes(), new Integer(1));}}, false, "eau", new Color(97, 37, 0), 1 , 0, true,new ArrayList<Integer>() {{add(3);add(5);}})),
	PETITE_SIESTE(new RessourceCard(new HashMap<Ressource, Integer>(){{put(RessourceList.SOMMEIL.getRes(), new Integer(1));}}, false, "petite_sieste", new Color(97, 37, 0), 1, 0, true,new ArrayList<Integer>() {{add(3);add(4);}})),
	
	GOURDE(new RessourceCard(new HashMap<Ressource, Integer>(){{put(RessourceList.STYLOS.getRes(), new Integer(1));put(RessourceList.BOISSON.getRes(), new Integer(1));}}, true, "gourde", new Color(97, 37, 0), 1 , 1, false ,new ArrayList<Integer>() {{add(6);}})),
	MAMAN(new RessourceCard(new HashMap<Ressource, Integer>(){{put(RessourceList.NOURRITURE.getRes(), new Integer(1));put(RessourceList.BOISSON.getRes(), new Integer(1));}}, true, "maman", new Color(97, 37, 0), 1, 1, false,new ArrayList<Integer>() {{add(4);}})),
	CAFE(new RessourceCard(new HashMap<Ressource, Integer>(){{put(RessourceList.BOISSON.getRes(), new Integer(1));put(RessourceList.SOMMEIL.getRes(), new Integer(1));}}, true, "cafe", new Color(97, 37, 0), 1, 1, false,new ArrayList<Integer>() {{add(3);}})),
	RU(new RessourceCard(new HashMap<Ressource, Integer>(){{put(RessourceList.NOURRITURE.getRes(), new Integer(1));put(RessourceList.STYLOS.getRes(), new Integer(1));}}, true, "ru", new Color(97, 37, 0), 1 , 1, false,new ArrayList<Integer>() {{add(3);}})),
	PROF_ABSENT(new RessourceCard(new HashMap<Ressource, Integer>(){{put(RessourceList.SOMMEIL.getRes(), new Integer(1));put(RessourceList.STYLOS.getRes(), new Integer(1));}}, true, "prof_absent", new Color(97, 37, 0), 1, 1, false,new ArrayList<Integer>() {{add(5);}})),
	RACLETTE(new RessourceCard(new HashMap<Ressource, Integer>(){{put(RessourceList.SOMMEIL.getRes(), new Integer(1));put(RessourceList.NOURRITURE.getRes(), new Integer(1));}}, true, "raclette", new Color(97, 37, 0), 1 , 1, false,new ArrayList<Integer>() {{add(6);}})),
	
	RENTREE(new RessourceCard(new HashMap<Ressource, Integer>(){{put(RessourceList.STYLOS.getRes(), new Integer(2));}}, true, "rentree", new Color(97, 37, 0), 2, 1, false,new ArrayList<Integer>() {{add(3);add(4);}})),
	TACOS(new RessourceCard(new HashMap<Ressource, Integer>(){{put(RessourceList.NOURRITURE.getRes(), new Integer(2));}}, true, "tacos", new Color(97, 37, 0), 2, 1, false,new ArrayList<Integer>() {{add(3);add(4);}})),
	SODA(new RessourceCard(new HashMap<Ressource, Integer>(){{put(RessourceList.BOISSON.getRes(), new Integer(2));}}, true, "soda", new Color(97, 37, 0), 2 , 1, false, new ArrayList<Integer>() {{add(3);add(4);}})),
	GRASSE_MAT(new RessourceCard(new HashMap<Ressource, Integer>(){{put(RessourceList.SOMMEIL.getRes(), new Integer(2));}}, true, "grasse_mat", new Color(97, 37, 0), 2, 1, false ,new ArrayList<Integer>() {{add(3);add(4);}})),
	
	JEUX_VIDEOS(new RessourceCard(new HashMap<Ressource, Integer>(){{put(RessourceList.JEUX.getRes(), new Integer(1));}}, false, "jeux_videos", new Color(138, 138, 138), 1, 0, true,new ArrayList<Integer>() {{add(3);add(6);}})),
	RDV(new RessourceCard(new HashMap<Ressource, Integer>(){{put(RessourceList.AMOUR.getRes(), new Integer(1));}}, false, "rdv", new Color(138, 138, 138), 1,0, true,new ArrayList<Integer>() {{add(3);add(6);}})),
	SERIES(new RessourceCard(new HashMap<Ressource, Integer>(){{put(RessourceList.DIVERTISSEMENT.getRes(), new Integer(1));}}, false, "series", new Color(138, 138, 138), 1, 0, true,new ArrayList<Integer>() {{add(3);add(6);}})),
	JEUX_VIDEOS_AGE2(new RessourceCard(new HashMap<Ressource, Integer>(){{put(RessourceList.JEUX.getRes(), new Integer(1));}}, false, "jeux_videos_age2", new Color(138, 138, 138), 1, 0, true,new ArrayList<Integer>() {{add(3);add(5);}})),
	RDV2_AGE2(new RessourceCard(new HashMap<Ressource, Integer>(){{put(RessourceList.AMOUR.getRes(), new Integer(1));}}, false, "rdv_age2", new Color(138, 138, 138), 1, 0, true,new ArrayList<Integer>() {{add(3);add(5);}})),
	SERIES_AGE2(new RessourceCard(new HashMap<Ressource, Integer>(){{put(RessourceList.DIVERTISSEMENT.getRes(), new Integer(1));}}, false, "series_age2", new Color(138, 138, 138), 1, 0, true ,new ArrayList<Integer>() {{add(3);add(5);}})),
	
	GYMNASE(new ScienceCard("Muscle","gymnase",1, new HashMap<Ressource,Integer>(){{put(RessourceList.JEUX.getRes(), new Integer(1));}},new Card(), new ArrayList<Integer>(){{add(3);add(5);}})),
	BDS(new MilitaryCard(2,"bds", 2, new HashMap<Ressource,Integer>() {{put(RessourceList.SOMMEIL.getRes(), new Integer(1));put(RessourceList.STYLOS.getRes(), new Integer(1));put(RessourceList.BOISSON.getRes(), new Integer(1));}}, CardList.GYMNASE.getCard(), new ArrayList<Integer>() {{add(3);add(5);}})),
	FOYER(new ScienceCard("Soirées","foyer",1, new HashMap<Ressource,Integer>(){{put(RessourceList.AMOUR.getRes(), new Integer(1));}},new Card(), new ArrayList<Integer>(){{add(3);add(7);}})),
	BAR(new ScienceCard("Soirées","bar",2, new HashMap<Ressource,Integer>(){{put(RessourceList.DIVERTISSEMENT.getRes(), new Integer(1));put(RessourceList.BOISSON.getRes(), new Integer(2));}},CardList.FOYER.getCard(), new ArrayList<Integer>(){{add(3);add(5);}})),
	
	WEI(new MilitaryCard(1,"wei", 1, new HashMap<Ressource,Integer>() {{put(RessourceList.STYLOS.getRes(), new Integer(1));}}, new Card(), new ArrayList<Integer>() {{add(3);add(7);}})),
	SDM(new MilitaryCard(1,"sdm", 1, new HashMap<Ressource,Integer>() {{put(RessourceList.SOMMEIL.getRes(), new Integer(1));}}, new Card(), new ArrayList<Integer>() {{add(3);add(5);}})),
	FESTIVUT(new MilitaryCard(1,"festivut", 1, new HashMap<Ressource,Integer>() {{put(RessourceList.BOISSON.getRes(), new Integer(1));}}, new Card(), new ArrayList<Integer>() {{add(3);add(4);}})),
	REPAS_TC(new MilitaryCard(2,"repas_tc", 2, new HashMap<Ressource,Integer>() {{put(RessourceList.STYLOS.getRes(), new Integer(1));put(RessourceList.SOMMEIL.getRes(), new Integer(2));}}, new Card(), new ArrayList<Integer>() {{add(4);add(6);add(7);}})),
	SOIREE_PARRAINAGE(new MilitaryCard(2,"soiree_parrainage", 2, new HashMap<Ressource,Integer>() {{put(RessourceList.NOURRITURE.getRes(), new Integer(3));}}, new Card(), new ArrayList<Integer>() {{add(3);add(7);}})),
	SOIREE_SURNOMS(new MilitaryCard(3,"soiree_surnoms", 3, new HashMap<Ressource,Integer>() {{put(RessourceList.SOMMEIL.getRes(), new Integer(3));put(RessourceList.NOURRITURE.getRes(), new Integer(1));}}, CardList.SOIREE_PARRAINAGE.getCard(), new ArrayList<Integer>() {{add(3);add(7);}})),
	REPAS_PROMO(new MilitaryCard(3,"repas_promo", 3, new HashMap<Ressource,Integer>() {{put(RessourceList.SOMMEIL.getRes(), new Integer(1));put(RessourceList.NOURRITURE.getRes(), new Integer(3));}}, CardList.REPAS_TC.getCard(), new ArrayList<Integer>() {{add(4);add(5);add(7);}})),
	GALA(new MilitaryCard(3,"gala", 3, new HashMap<Ressource,Integer>() {{put(RessourceList.SOMMEIL.getRes(), new Integer(1));put(RessourceList.STYLOS.getRes(), new Integer(2));put(RessourceList.JEUX.getRes(), new Integer(1));}}, new Card(), new ArrayList<Integer>() {{add(3);add(4);add(7);}})),
	JEU_A_BOIRE(new MilitaryCard(2,"jeu_a_boire", 2, new HashMap<Ressource,Integer>() {{put(RessourceList.STYLOS.getRes(), new Integer(2));put(RessourceList.SOMMEIL.getRes(), new Integer(1));}}, CardList.FOYER.getCard(), new ArrayList<Integer>() {{add(3);add(6);}})),
	SHOT(new MilitaryCard(3,"shot", 3, new HashMap<Ressource,Integer>() {{put(RessourceList.BOISSON.getRes(), new Integer(3));}}, CardList.BAR.getCard(), new ArrayList<Integer>() {{add(3);add(5);}})),
	
	BU(new ScienceCard("Connaissances","bu",1, new HashMap<Ressource,Integer>(){{put(RessourceList.DIVERTISSEMENT.getRes(), new Integer(1));}},new Card(), new ArrayList<Integer>(){{add(3);add(4);}})),
	PISCINE(new ScienceCard("Muscle","piscine",2, new HashMap<Ressource,Integer>(){{put(RessourceList.SOMMEIL.getRes(), new Integer(2));put(RessourceList.AMOUR.getRes(), new Integer(1));}},CardList.GYMNASE.getCard(), new ArrayList<Integer>(){{add(3);add(4);}})),
	PATINOIRE(new ScienceCard("Muscle","patinoire",3, new HashMap<Ressource,Integer>(){{put(RessourceList.BOISSON.getRes(), new Integer(2));put(RessourceList.JEUX.getRes(), new Integer(1));put(RessourceList.DIVERTISSEMENT.getRes(), new Integer(1));}},CardList.PISCINE.getCard(), new ArrayList<Integer>(){{add(3);add(6);}})),
	
	BOITE_DE_NUIT(new ScienceCard("Soirées","boite_de_nuit",3, new HashMap<Ressource,Integer>(){{put(RessourceList.SOMMEIL.getRes(), new Integer(2));put(RessourceList.AMOUR.getRes(), new Integer(1));put(RessourceList.JEUX.getRes(), new Integer(1));}}, CardList.BAR.getCard(), new ArrayList<Integer>(){{add(3);add(7);}})),
	TP(new ScienceCard("Connaissances","tp",2, new HashMap<Ressource,Integer>(){{put(RessourceList.NOURRITURE.getRes(), new Integer(2));put(RessourceList.JEUX.getRes(), new Integer(1));}},CardList.BU.getCard(), new ArrayList<Integer>(){{add(3);add(6);}})),
	LABO(new ScienceCard("Connaissances","labo",3, new HashMap<Ressource,Integer>(){{put(RessourceList.STYLOS.getRes(), new Integer(2));put(RessourceList.STYLOS.getRes(), new Integer(2));put(RessourceList.DIVERTISSEMENT.getRes(), new Integer(1));put(RessourceList.AMOUR.getRes(), new Integer(1));}},CardList.TP.getCard(), new ArrayList<Integer>(){{add(3);add(4);}})),
	LION_BELFORT(new ScienceCard("Connaissances","lion_belfort",2, new HashMap<Ressource,Integer>(){{put(RessourceList.STYLOS.getRes(), new Integer(1));put(RessourceList.DIVERTISSEMENT.getRes(), new Integer(1));}},new Card(), new ArrayList<Integer>(){{add(3);add(7);}})),
	BASICFIT(new ScienceCard("Muscle","basicfit",3, new HashMap<Ressource,Integer>(){{put(RessourceList.NOURRITURE.getRes(), new Integer(3));put(RessourceList.AMOUR.getRes(), new Integer(1));}},CardList.LION_BELFORT.getCard(), new ArrayList<Integer>(){{add(3);add(7);}})),
	EUROCKS(new ScienceCard("Soirées","eurocks",3, new HashMap<Ressource,Integer>(){{put(RessourceList.DIVERTISSEMENT.getRes(), new Integer(1));put(RessourceList.JEUX.getRes(), new Integer(1));put(RessourceList.STYLOS.getRes(), new Integer(1));}},CardList.LION_BELFORT.getCard(), new ArrayList<Integer>(){{add(3);add(5);}})),
		
	LE03(new CivilCard(3,"le03",1, new HashMap<Ressource,Integer>() ,true, new Card(), new ArrayList<Integer>() {{add(4);add(7);}})),
	IFA(new CivilCard(3,"ifa",1, new HashMap<Ressource,Integer>(){{put(RessourceList.NOURRITURE.getRes(), new Integer(1));}} ,false, new Card(), new ArrayList<Integer>() {{add(3);add(7);}})),
	MTA(new CivilCard(2,"mta",1, new HashMap<Ressource,Integer>() ,true, new Card(), new ArrayList<Integer>() {{add(3);add(5);}})),
	PSA(new CivilCard(2,"psa",1, new HashMap<Ressource,Integer>() ,true, new Card(), new ArrayList<Integer>() {{add(3);add(6);}})),
	LP24(new CivilCard(5,"lp24",2, new HashMap<Ressource,Integer>(){{put(RessourceList.NOURRITURE.getRes(), new Integer(3));}} ,false, CardList.IFA.getCard(), new ArrayList<Integer>() {{add(3);add(7);}})),
	MTC(new CivilCard(3,"mtc",2, new HashMap<Ressource,Integer>(){{put(RessourceList.STYLOS.getRes(), new Integer(1));put(RessourceList.BOISSON.getRes(), new Integer(1));put(RessourceList.AMOUR.getRes(), new Integer(1));}} ,false, CardList.MTA.getCard(), new ArrayList<Integer>() {{add(3);add(6);}})),
	PS26(new CivilCard(4,"ps26",2, new HashMap<Ressource,Integer>(){{put(RessourceList.NOURRITURE.getRes(), new Integer(2));put(RessourceList.STYLOS.getRes(), new Integer(1));}} ,false, CardList.PSA.getCard(), new ArrayList<Integer>() {{add(3);add(7);}})),
	MT42(new CivilCard(7,"mt42",3, new HashMap<Ressource,Integer>(){{put(RessourceList.BOISSON.getRes(), new Integer(2));put(RessourceList.SOMMEIL.getRes(), new Integer(1));put(RessourceList.DIVERTISSEMENT.getRes(), new Integer(1));put(RessourceList.JEUX.getRes(), new Integer(1));put(RessourceList.AMOUR.getRes(), new Integer(2));}} ,false, CardList.MTC.getCard(), new ArrayList<Integer>() {{add(3);add(6);}})),
	TF40(new CivilCard(5,"tf40",3, new HashMap<Ressource,Integer>(){{put(RessourceList.BOISSON.getRes(), new Integer(2));put(RessourceList.STYLOS.getRes(), new Integer(1));}} ,false, CardList.PS26.getCard(), new ArrayList<Integer>() {{add(3);add(4);}})),
	MA41(new CivilCard(6,"ma41",3, new HashMap<Ressource,Integer>(){{put(RessourceList.STYLOS.getRes(), new Integer(2));put(RessourceList.JEUX.getRes(), new Integer(1));}} ,false, CardList.BU.getCard(), new ArrayList<Integer>() {{add(3);add(5);}})),
	CG(new CivilCard(4,"cg",2, new HashMap<Ressource,Integer>(){{put(RessourceList.BOISSON.getRes(), new Integer(2));put(RessourceList.NOURRITURE.getRes(), new Integer(1));put(RessourceList.SOMMEIL.getRes(), new Integer(1));}} ,false, CardList.TP.getCard(), new ArrayList<Integer>() {{add(3);add(5);}})),
	SEE(new CivilCard(6,"see",3, new HashMap<Ressource,Integer>(){{put(RessourceList.NOURRITURE.getRes(), new Integer(2));put(RessourceList.SOMMEIL.getRes(), new Integer(1));put(RessourceList.AMOUR.getRes(), new Integer(1));}} ,false, new Card(), new ArrayList<Integer>() {{add(3);add(5);add(6);}})),
	STAGE(new CivilCard(8,"stage",3, new HashMap<Ressource,Integer>(){{put(RessourceList.BOISSON.getRes(), new Integer(1));put(RessourceList.STYLOS.getRes(), new Integer(1));put(RessourceList.NOURRITURE.getRes(), new Integer(1));put(RessourceList.SOMMEIL.getRes(), new Integer(1));put(RessourceList.JEUX.getRes(), new Integer(1));put(RessourceList.AMOUR.getRes(), new Integer(1));put(RessourceList.DIVERTISSEMENT.getRes(), new Integer(1));}} ,false, new Card(), new ArrayList<Integer>() {{add(3);add(7);}})),
	
	MAMY(new TradeCard("mamy",1, false, new HashMap<Ressource,Integer>(), true, new Card(), new ArrayList<Integer>() {{add(4);add(5);add(7);}}, null)),
	BOURSES(new TradeCard("bourses",1,false, new HashMap<Ressource,Integer>(), true, new Card(), new ArrayList<Integer>() {{add(3);add(7);}}, null)),
	APPRENTISSAGE(new TradeCard("apprentissage",1,false, new HashMap<Ressource,Integer>(), true, new Card(), new ArrayList<Integer>() {{add(3);add(7);}}, null)),
	CAF(new TradeCard("caf",1,false, new HashMap<Ressource,Integer>(), true, new Card(), new ArrayList<Integer>() {{add(3);add(6);}}, null)),
	BOURSE_MERITE(new TradeCard("bourse_merite",2, true,new HashMap<Ressource,Integer>(){{put(RessourceList.BOISSON.getRes(), new Integer(2));}}, false, CardList.BOURSES.getCard(), new ArrayList<Integer>() {{add(3);add(6);add(7);}}, null)),
	AIDE_REGIONALE(new TradeCard("aide_regionale",3,false, new HashMap<Ressource,Integer>(){{put(RessourceList.JEUX.getRes(), new Integer(1));put(RessourceList.SOMMEIL.getRes(), new Integer(1));put(RessourceList.STYLOS.getRes(), new Integer(1));}}, false, CardList.BOURSE_MERITE.getCard(), new ArrayList<Integer>() {{add(3);add(4);}},  new Bonus("Trade_Brown"))),
	APL(new TradeCard("apl",2, true, new HashMap<Ressource,Integer>(){{put(RessourceList.STYLOS.getRes(), new Integer(2));}}, false, CardList.CAF.getCard(), new ArrayList<Integer>() {{add(3);add(5);add(6);}},null)),
	CARTE_ISIC(new TradeCard("carte_isic",3,false, new HashMap<Ressource,Integer>(){{put(RessourceList.AMOUR.getRes(), new Integer(1));put(RessourceList.NOURRITURE.getRes(), new Integer(1));}}, false, CardList.APL.getCard(),new ArrayList<Integer>() {{add(3);add(6);}}, new Bonus("Trade_Yellow"))),	
	TAF_RU(new TradeCard("taf_ru",2,false, new HashMap<Ressource,Integer>(), true, new Card(), new ArrayList<Integer>() {{add(3);add(6);}}, new Bonus("Trade_RU"))),
	TAF_ETUDIANT(new TradeCard("taf_etudiant",2,false, new HashMap<Ressource,Integer>(), true, new Card(), new ArrayList<Integer>() {{add(4);add(7);}}, new Bonus("Trade_Job"))),
	BLABLACAR(new TradeCard("blablacar",3,false, new HashMap<Ressource,Integer>(){{put(RessourceList.BOISSON.getRes(), new Integer(2));put(RessourceList.DIVERTISSEMENT.getRes(), new Integer(1));}}, false, new Card(), new ArrayList<Integer>() {{add(4);add(6);}}, new Bonus("Trade_Gray"))),	
	COMPET_SPORTIVE(new TradeCard("compet_sportive",3,false, new HashMap<Ressource,Integer>(){{put(RessourceList.SOMMEIL.getRes(), new Integer(1));put(RessourceList.NOURRITURE.getRes(), new Integer(2));}}, false, CardList.PISCINE.getCard(), new ArrayList<Integer>() {{add(3);add(5);add(7);}}, new Bonus("Trade_Wonder"))),
	
	UNE_TRES_BONNE_MOUSSE(new GuildCard(new Bonus("Guild_biere"),"une_tres_bonne_mousse", new HashMap<Ressource,Integer>() {{put(RessourceList.SOMMEIL.getRes(), new Integer(2));put(RessourceList.NOURRITURE.getRes(), new Integer(1));put(RessourceList.JEUX.getRes(), new Integer(1));}})),
	CLUB_WELCOME(new GuildCard(new Bonus("Guild_welcome"),"club_welcome", new HashMap<Ressource,Integer>() {{put(RessourceList.BOISSON.getRes(), new Integer(3));put(RessourceList.JEUX.getRes(), new Integer(1));put(RessourceList.DIVERTISSEMENT.getRes(), new Integer(1));}})),
	GAZETT_UT(new GuildCard(new Bonus("Guild_gazett"),"gazett_ut", new HashMap<Ressource,Integer>() {{put(RessourceList.BOISSON.getRes(), new Integer(3));put(RessourceList.AMOUR.getRes(), new Integer(1));}})),
	POTARDS(new GuildCard(new Bonus("Guild_potards"),"potards", new HashMap<Ressource,Integer>() {{put(RessourceList.SOMMEIL.getRes(), new Integer(2));put(RessourceList.STYLOS.getRes(), new Integer(1));put(RessourceList.BOISSON.getRes(), new Integer(1));put(RessourceList.NOURRITURE.getRes(), new Integer(1));}})),
	REFLEX(new GuildCard(new Bonus("Guild_reflex"),"reflex", new HashMap<Ressource,Integer>() {{put(RessourceList.STYLOS.getRes(), new Integer(3));put(RessourceList.DIVERTISSEMENT.getRes(), new Integer(1));put(RessourceList.AMOUR.getRes(), new Integer(1));}})),
	TROLL(new GuildCard(new Bonus("Guild_troll"),"troll", new HashMap<Ressource,Integer>() {{put(RessourceList.SOMMEIL.getRes(), new Integer(2));put(RessourceList.SOMMEIL.getRes(), new Integer(2));put(RessourceList.DIVERTISSEMENT.getRes(), new Integer(1));}})),
	UNITEC(new GuildCard(new Bonus("Guild_robot"),"unitec", new HashMap<Ressource,Integer>() {{put(RessourceList.STYLOS.getRes(), new Integer(3));put(RessourceList.NOURRITURE.getRes(), new Integer(1));put(RessourceList.JEUX.getRes(), new Integer(1));}})),
	UTBPM(new GuildCard(new Bonus("Guild_dj"),"utbpm", new HashMap<Ressource,Integer>() {{put(RessourceList.SOMMEIL.getRes(), new Integer(2));put(RessourceList.NOURRITURE.getRes(), new Integer(2));}})),
	UT_PROD(new GuildCard(new Bonus("Guild_cinema"),"ut_prod", new HashMap<Ressource,Integer>() {{put(RessourceList.DIVERTISSEMENT.getRes(), new Integer(1));put(RessourceList.AMOUR.getRes(), new Integer(1));put(RessourceList.JEUX.getRes(), new Integer(1));}})),
	ZIK(new GuildCard(new Bonus("Guild_zik"),"zik", new HashMap<Ressource,Integer>() {{put(RessourceList.BOISSON.getRes(), new Integer(2));put(RessourceList.NOURRITURE.getRes(), new Integer(2));put(RessourceList.AMOUR.getRes(), new Integer(1));}}));
		
	private Card card = new RessourceCard();
	
	/**
	 * Constructor of an element of this enum
	 * @param card The card that will be encapsulated in the enum element
	 */
	CardList(Card card){
		this.card = card;
	}
	
	public String toString() {
		return null;
	}
	
	/**
	 * Getting the card encapsulated in the element
	 * @return the card encapsulated in the element
	 */
	public Card getCard() {
		return this.card;
	}
	
	/**
	 * Method that take a card name and return the corresponding card by running a search in all elements of the enum
	 * @param name The name of the card searched
	 * @return The corresponding card object
	 */
	public static Card findByName(String name) {
		CardList[] listOfCards = CardList.values();
		
		for(int i=0;i < listOfCards.length - 1;i++) {
			if(listOfCards[i].getCard().getName().equalsIgnoreCase(name)) {
				return listOfCards[i].getCard();
			}
		}
		
		return null;
	}
	
}
