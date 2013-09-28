package tictactoe.view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

public class GamePanel extends JPanel {
	
	private int size;	
	private JButton[] cells = null;
	
	
	private final MainFrame frame;
	
	GamePanel(int size, MainFrame frame){
		this.setSize(size); 
		this.frame = frame;
		init();       				
	}

	private void init(){
		
		if(size < 0){
			return;
		}
		GridLayout layout = new GridLayout(size, size);
		layout.setHgap(1);
		layout.setVgap(1);
		setLayout(layout);
		cells = new JButton[size * size];
		
	
	   for(int i=0; i < cells.length; i++){
		   
			cells[i] = new JButton("");
            final JButton button = cells[i];
            final int value = i;
			cells[i].addActionListener(new ActionListener()
	        {
	        	public void actionPerformed(ActionEvent event)
	        	{          
	           int	id = frame.game.getActivePlayer(); 
	           frame.game.move(id, value);
	           button.setText(frame.game.getPlayer(id).getPiece().toString());
	           button.setEnabled(false);		
	        	}
	        });
		   add(cells[i]);
		}
		
		
	}
	
	public JButton[] getCells(){		
		return cells;		
	}
	
	public void setSize(int size) {
		this.size = size;
	}		

}
