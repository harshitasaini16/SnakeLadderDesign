package main;

public class Player {
	private int id;
	
	private String name;
	
	private int currentPosition;
	
	Player(){}

	public Player(int id, String name) {
		super();
		this.id = id;
		this.name = name;
		this.currentPosition = 0;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCurrentPosition() {
		return currentPosition;
	}

	public void setCurrentPosition(int currentPosition) {
		this.currentPosition = currentPosition;
	}
}
