package java1.oop.tictactoe;

import java.util.ArrayList;
import java.util.List;

final class Field {
	/** массив ячеек, из которых состоит поле */
	//private Cell[] cells;
	//private Set<Cell> cells;
	private List<Cell> cells;
	private int size;
	/**
	 * Конструктор объекта класса Поле
	 * @param size - размер стороны квадратного игрового поля
	 */
	public Field(int size){
		createCells(size);
		this.size = size;
	}
	
	/**
	 * Создать ячейки поля
	 * @param size
	 */
	private void createCells(int size){
		/*
		cells = new Cell[size*size];
		for(int i=0; i < cells.length; i++){
			cells[i] = new Cell(i);
		}
		*/
		cells = new ArrayList<Cell>();
		for(int i=0; i < size*size; i++){
			cells.add(new Cell(i));
		}
	}

	/**
	 * Разместить фигуру на ячейки с заданным номером
	 * @param piece - фигура игрока
	 * @param number - номер ячейки
	 */
	public void place(Piece piece, int number){
		if(number >= 0 && number < cells.size() && piece != null){
			Cell cell = cells.get(number);
			cell.setPiece(piece);
		}
	}

	/**
	 * Вернуть текстовое представление поля
	 * @return текстовое представление
	 */
	public String getField(){
		StringBuilder str = new StringBuilder();
		Piece piece = null;
		for(int i=0; i < cells.size(); i++){
			str.append('['); 
			str.append(i); str.append(',');
			piece = cells.get(i).getPiece();
			if(piece != null){
				str.append(piece.name()); 
			}else{
				str.append(' ');
			}
			str.append(']');
			if ((i+1) % this.getSize() == 0 ) str.append("\n");
		}
		return str.toString();
	}
	
	private int getSize(){
		return size;
	}
}
