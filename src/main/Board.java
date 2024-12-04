package main;

import java.util.List;
import java.util.Map;
import java.util.Random;

public class Board {
	private int boardSize;
	
	private int diceSize;
	
	private List<Player> players;
	
	private Map<Integer, Integer> snakes;
	
	private Map<Integer, Integer> ladders;
	
	Board() {}

	public Board(int boardSize, int diceSize, List<Player> players,Map<Integer, Integer> snakes ,Map<Integer, Integer> ladders) {
		super();
		this.boardSize = boardSize;
		this.diceSize = diceSize;
		this.players = players;
		this.snakes = snakes;
		this.ladders = ladders;
	}

	public int getBoardSize() {
		return boardSize;
	}

	public void setBoardSize(int boardSize) {
		this.boardSize = boardSize;
	}

	public int getDiceSize() {
		return diceSize;
	}

	public void setDiceSize(int diceSize) {
		this.diceSize = diceSize;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	public Map<Integer, Integer> getSnakes() {
		return snakes;
	}

	public void setSnakes(Map<Integer, Integer> snakes) {
		this.snakes = snakes;
	}

	public Map<Integer, Integer> getLadders() {
		return ladders;
	}

	public void setLadders(Map<Integer, Integer> ladders) {
		this.ladders = ladders;
	}
	
	public void play() {
		int turn = 0; 
		while(true) {
			Random rand = new Random();
			Player player = this.players.get(turn);
			int diceNumber = rand.nextInt(this.diceSize)+1;
			int position = player.getCurrentPosition() + diceNumber;
			if(this.ladders.containsKey(position)) {
				position = ladders.get(position);
				System.out.println("Yaaayy" + player.getName() + " got a ladder");
			} else if(this.ladders.containsKey(position)) {
				position = ladders.get(position);
				System.out.println("aahhh!" + player.getName() + " got a ladder");
			}
			if(position == this.boardSize) {
				System.out.println(player.getName() + " got " + diceNumber + " so " +player.getName() + " is the Winner");
				return;
			} else if(position < boardSize) {
				player.setCurrentPosition(position);
				System.out.println(player.getName() + " got " + diceNumber + " so the new position is " + position);
			} else {
				System.out.println(player.getName() + " got " + diceNumber + " with is more than " + this.diceSize + "so the position of this player will not change");
			}
			
			turn = (turn+1) % players.size();
		}
	}
}
