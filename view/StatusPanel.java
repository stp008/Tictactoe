package tictactoe.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class StatusPanel extends JPanel {
	
	private JLabel status = new JLabel();
	private JLabel piece = new JLabel();
	private JLabel move = new JLabel();
	private Border border = BorderFactory.createEtchedBorder();
	private Border border_title = BorderFactory.createTitledBorder(border, "Информация об игре");
	private JButton[] cells;
	private MainFrame frame;
	private GamePanel gamePanel;
	private static int count = 0;
	
	 StatusPanel(MainFrame frame, GamePanel gamepanel){
		 super();
		 this.frame = frame;
		 this.gamePanel = gamepanel;
		 init();
	 }
	
	 private void init(){
		 
		 setLayout(new BorderLayout());
		 setBorder(border_title);
		 add(status, BorderLayout.NORTH);
		 add(piece, BorderLayout.CENTER);
		 add(move, BorderLayout.SOUTH);
		 cells = gamePanel.getCells();
		 for(int i=0; i < cells.length; i++) {
			    final int number = i;
				cells[i].addActionListener(new ActionListener()
		        {
		        	public void actionPerformed(ActionEvent event)
		        	{       
		        	int	id = frame.game.getActivePlayer();			         
		            status.setText("Ход игрока: " + frame.game.getNextPlayer(id).getName());	
		            piece.setText("Ваша фигура: " + frame.game.getNextPlayer(id).getPiece().toString());
		            move.setText("Всего ходов: " + (++count));
		           
		        	}
		        });
			   
			}
		 
		 
		 
	 }
	 
	
}
