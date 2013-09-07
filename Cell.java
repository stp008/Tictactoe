package java1.oop.tictactoe;

final class Cell {
	/** номер ячейки на поле */
	private final int number;
	

	/** фигура игрока, которая стоит на ячейке; null - ячейка не занята */
	private Piece piece = null;
	
	public Cell(int number){
		this.number = number;
	}
	
	/**
	 * Разместить фигуру на ячейке
	 * @param piece
	 */
	public void setPiece(Piece piece){
		/** Если ячейка не занята, то можно разместить фигуру */
		if(this.piece == null){
			this.piece = piece;
		}
	}
	
	/**
	 * Вернуть фигуру на ячейке
	 * @return фигуру, null - ячейка не занята
	 */
	public Piece getPiece(){
		return piece;
	}
	
	/**
	 * Вернуть номер ячейки на поле
	 * @return номер ячейки
	 */
	public int number(){
		return number;
	}

	
}
