package java1.oop.tictactoe.test;

import java1.oop.tictactoe.Game;

/** 
 * Класс для тестирования игры
 * Здесь задаются вызовы методов объекта класса Game, которые эмулируют действия пользователя в игре
 */
public class Test {
	public static void main(String[] args) {
		
		/* Игра состоит из инициализации, ходов и завершения, которое возникает в случае выигрыша.  */
		
		
		
		
		/* инициализация игры */
		Game game = Game.init(10);
		String str= null; //
		

		
		/* Добавление игроков. Допускается иметь одинаковые имена. В принципе сама реализация сводит к минимуму возможные ошибки. */
		game.addPlayer("John");
		game.addPlayer("Josh");
		
		
		/* Тестирование записи третьего игрока */
		game.addPlayer("Jodie");
		game.move(3, 58);
		
		
		
		/* Тестирование ходов. Благодаря TDD удалось быстро и эффективно реализовать очередность игроков. */
		
		
		/* Тестирование стандартных ходов по очереди*/
		game.move(1, 6);
		game.move(2, 4);
		game.move(1, 7);
		game.move(2, 4);
		game.move(1, 5);
		game.move(2, 60);
		
		/* Тестирование ходов вне очереди */
		
		game.move(1, 1);
		game.move(1, 20);
		game.move(1, 17);
		game.move(2, 13);
		game.move(2, 55);
		game.move(2, 60);
		
		/* Тестирование на запись в одну ячейку */
		game.move(1, 49);
		game.move(2, 49);
		
		/* Тестирование на запись вне диапозона */
		game.move(1, 0);
		game.move(2, 100);
		
		/* Тестирование на запись с несуществующим айди */
		game.move(0, 1);
		game.move(3, 99);
		
		
		/* Вывод начального поля на экран */
		str = game.getField();
		System.out.println(str);
	}
	}
