package Deliverable_3;

/**
 * A class that models each Player in the game. Players have an identifier, which should be unique.
 * @author dancye
 */
public abstract class Player {

	private String playerID;

	/**
	 * A constructor that allows you to set the player's unique ID
	 * @param name the unique ID to assign to this player.
	 */
	public Player(String name) {
            this.setPlayerID(name);
	}
        
        public Player() {
            
        }

        //returns the name of the player
	public String getPlayerID() {
            return this.playerID;
	}

        //sets the name of the player
	public void setPlayerID(String name) {
            this.playerID = name;
	}

}