package java1.oop.tictactoe;

import java.util.HashMap;
import java.util.Map;

public class Game {
	/** свойство объекта игра - поле = переменная типа класса Field (Поле) */
	private static Field field;
	/**  свойство объекта игра - игроки = переменная типа класса Player (Игрок) */
	//private Player[] players = new Player[2];
	private Map<Integer, Player> players = new HashMap<Integer, Player>();
	
	/**
	 *  Конструктор класса Game, с помощью которого создается объект класса
	 * @param size - размер стороны квадратного игрового поля
	 */
	private Game(int size){
		/** создание объекта игрового поля */
		field = new Field(size);
		
	}
	
	/** инициализация игры */
	public static Game init(int size){
		return new Game(size);
	}
	
	/**
	 * Добавить игрока в игру
	 * @param id - идентификатор игрока
	 * @param name - имя игрока
	 * @return true в случае успешного добавления
	 */
	public boolean addPlayer(String name){
		/** Через содержимое ячеек массива определить, были ли уже добавлены игроки */
		if(players.size() == 0 || players.size() == 1){
			/** объект класса Piece (Фигура игрока) */
			Piece piece = null;
			int index;
			/** первый играет за крестики */
			if(players.get(1) == null){
				piece = Piece.x;
				index = 1;
				players.put(index, new Player(index, name, piece));
				players.get(1).activate();
			}else{
				/** второй играет за нолики */
				piece = Piece.o;
				index = 2;
				players.put(index, new Player(index, name, piece));
			}
			/** создать объект класса Player (Игрок) и запомнить его в массиве игроков */
			
			return true;
		}
		return false;
	}
	
	/**
	 * Совершить ход в игре
	 * @param id - идентификатор игрока
	 * @param value - номер ячейки, куда ставить фигуру
	 */
	public void move(int id, int value){
		/** получить игрока по id */
		Player player = getPlayer(id);
		if(player == null  || id > 2 || id < 1){
			return;
		}
		/** "дать задание" объекту класса Поле разместить фигуру на нем */
		if (!players.get(id).isActive()) System.out.println("Ваша очередь еще не настала.");
		if (players.get(id).isActive()) {
			field.place(player.getPiece(), value);
			players.get(id).deactivate();
			// говночасть, надо подумать как реализовать лучшую масштабируемость, чтобы играли 3 и более игроков и все разными фигурам
			if (id == 1)  players.get(2).activate();
			else players.get(1).activate();

		}
		
	}

	/**
	 * Вернуть текущее состояние игры: начата, закончена, ничья, победа и т.п.
	 * @return
	 */
	public String getState() {
		return null;
	}
	
	/**
	 * Получить игрока по идентификатору
	 * @param id - идентфикатор
	 * @return игрока или null, если нет игрока с заданнным id
	 */
	public Player getPlayer(int id){
		return players.get(id);
	}

	/**
	 * Вернуть текстовое представление игрового поля
	 * @return поле
	 */
	public String getField() {
		return field.getField();
	}
}
