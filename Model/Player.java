package java1.oop.tictactoe;

public final class Player {
	/** идентификатор игрока */
	private final int id;
	/** имя игрока */
	private final String name;
	/** фигура, которой играет игрок */
	private final Piece piece;
	
	private boolean Active = false;
	/**
	 * Конструктор класса Player
	 * @param id - идентификатор игрока
	 * @param name - имя игрока
	 * @param piece - фигура, которой играет игрок
	 */
	Player(int id, String name, Piece piece){
		this.id = id;
		this.name = name;
		this.piece = piece;
	}
	
	/**
	 * Вернуть фигуру игрока
	 * @return фигуру
	 */
	public Piece getPiece(){
		return piece;
	}

	/** 
	 * Вернуть идентификатор игрока
	 * @return идентфикатор
	 */
	public int getId() {
		return id;
	}

	/**
	 * Вернуть имя игрока
	 * @return имя
	 */
	public String getName() {
		return name;
	}
	
	public void activate() {
		this.Active = true;
	}
	
	public void deactivate() {
		this.Active = false;
	}
	
	
	public boolean isActive() {
		return Active;
	}
}
