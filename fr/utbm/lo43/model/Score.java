package fr.utbm.lo43.model;

/**
 * Class that represent a Score and that implements the Comparable interface to sort the Score objects
 * @author Francesco
 * @author Théau
 * @author Quentin
 * @author Malek
 */
public class Score implements Comparable<Score>{

	private int score;
	private Player player;
	
	/**
	 * Default constructor
	 */
	Score(){
		this.score = 0;
		this.player = new Player();
	}
	
	/**
	 * Constructor with parameter
	 * @param player Player that has this score
	 */
	Score(Player player){
		this.score = 0;
		this.player = player;
	}
	
	/**
	 * Getting the player
	 * @return the player
	 */
	public Player getPlayer() {
		return this.player;
	}
	
	/**
	 * Adding a certain amount of points to the score
	 * @param points number of points to add
	 */
	public void addScore(int points) {
		this.score += points;
	}
	
	/**
	 * Getting the score
	 * @return the score of the player
	 */
	public int getScore() {
		return this.score;
	}

	@Override
	/**
	 * <p>Method from the interface Comparable that we have to override,
	 * and allows us to compare to Score objects </p>
	 */
	public int compareTo(Score otherScore) {
		if(this.score < otherScore.getScore()) {
			return -1;
		}else if(this.score > otherScore.getScore()){
			return 1;
		}else {
			return 0;
		}
	}
}
