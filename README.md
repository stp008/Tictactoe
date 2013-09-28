Крестики-нолики (Tictactoe).
=========

Стадия альфа тестирования.

##### Задача:
Игра крестики-нолики.

#####Объекты игры:
Поле, ячейка, игрок, знаки, игра (отвечает за инициализацию).

#####Описание:
Игроки по очереди ставят на свободные клетки поля 3х3 знаки (один всегда крестики, другой всегда нолики). 
Первый, выстроивший в ряд 3 своих фигуры по вертикали, горизонтали или диагонали, выигрывает. 
Первый ход делает игрок, ставящий крестики. 
Обычно по завершении партии выигравшая сторона зачёркивает чертой свои три знака (нолика или крестика), 
составляющих сплошной ряд.

#####Особенности реализациии:
######Поле: Поле может иметь размерность от 3х3 до 100х100. Количество знаков в ряд варьируется в зависимости от размера поля (от 3 до 5).
######Ячейка: Содержит в себе знак. Имеет свой уникальный норме в зависимости от расположения на поле.
######Игрок: Может делать ходы и привязан к определенному знаку.
######Знаки: Содержит знаки. В данной реализации содержит либо крестик, либо нолик (X или О).
######Игра: Инициализирует игру, то есть создает поле с ячейками, добавляет игроков с привязкой к знаку, делает ходы.

Игра реализована через модель MVC.
