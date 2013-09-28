package tictactoe.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuBar extends JMenuBar {
	
	JMenu gameBtn = new JMenu("Игра");
	JMenu help = new JMenu("Помощь");
	JMenuItem about = new JMenuItem("О программе");
	JMenuItem rules = new JMenuItem("Правила");
	JMenuItem exit = new JMenuItem("Выход");
	JMenuItem local_game = new JMenuItem("Новая игра на одном компьютере");
	JMenuItem network_game = new JMenuItem("Новая сетевая игра");
	
	public MenuBar() {
		
		super();
		exit.addActionListener(new ActionListener()
        {
        	public void actionPerformed(ActionEvent event)
        	{             		      		
        		System.exit(0);      		
        		       		        		         		                 
        	}
        });
		
		local_game.addActionListener(new ActionListener()
        {
        	public void actionPerformed(ActionEvent event)
        	{             		      		
        		MainFrame gameFrame = new MainFrame();        		
        		       		        		         		                 
        	}
        });
		
		add(gameBtn);
		gameBtn.add(local_game);
		gameBtn.add(network_game);
		help.add(about);
		help.add(rules);
		add(help);
		add(exit);
		
	}

}
