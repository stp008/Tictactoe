package tictactoe.view;

import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;


public class MenuPanel extends JPanel{
		
	private Frame[] frames = Frame.getFrames();
	private JSlider fieldSize = new JSlider(3, 16);
	private JTextField name1 =  new JTextField("Введите имя первого игрока", 20);
	private JTextField name2 =  new JTextField("Введите имя второго игрока", 20);
	private JButton startGameBtn = new JButton("Играть");
	private JLabel label = new JLabel();
	private JLabel label1 = new JLabel(" Выберите размерность поля: ");
	private int size = 0;
	private int count1 = 0;
	private int count2 = 0;
	
	
	MenuPanel() {
		super();		
		this.setLayout(new GridLayout(6, 1));
		label.setForeground(Color.RED);
		name1.addMouseListener(new name1Clear());
		name2.addMouseListener(new name2Clear());
		
        startGameBtn.addActionListener(new ActionListener()
        {
        	public void actionPerformed(ActionEvent event)
        	{             		
        		if(inputCheck()) return;      		
        		size = fieldSize.getValue();    
        		disposeAll();        	    
        		MainFrame gameFrame = new MainFrame(size, name1.getText(), name2.getText());        		        		        		       		        		         		                 
        	}
        });
        
		fieldSize.setPaintLabels(true);
		fieldSize.setSnapToTicks(true);
		fieldSize.setMajorTickSpacing(1);
		add(label1);
		add(fieldSize);
		add(name1);
		add(name2);
		add(startGameBtn);
		add(label);
		
		
	}
	
	private void disposeAll(){
		
		for (int i = 0; i<frames.length; i++)
	    {
	    	frames[i].dispose();
	    }
		
	}
	
	private boolean inputCheck() {
		
		if (nameCheck()) return true;
		if (lengthCheck()) return true;
		return false;
		
	}
	
	private boolean nameCheck(){
		
		if(name1.getText().equalsIgnoreCase("") && name2.getText().equalsIgnoreCase("")) {
			label.setText(" Не введены имена игроков. Введите, пожалуйста, имена.");
			return true;
		}
		
		if(name1.getText().equalsIgnoreCase("Введите имя первого игрока") || name1.getText().equalsIgnoreCase("") ) {
			label.setText(" Не введено имя первого игрока. Введите, пожалуйста, имя.");
			return true;
		}
		if(name2.getText().equalsIgnoreCase("Введите имя второго игрока") || name2.getText().equalsIgnoreCase("")  ) {
			label.setText(" Не введено имя второго игрока. Введите, пожалуйста, имя.");
			return true;
		}
		
		return false;
		
	}
	
	private boolean lengthCheck(){
		
		if (name1.getText().length() > 25) {
			label.setText(" Слишком длинное имя первого игрока. Введите более короткое имя."); return true;
		}
		
		if (name2.getText().length() > 25) { 
			label.setText(" Слишком длинное имя второго игрока. Введите более короткое имя."); return true;
		}
		
		return false;
	}
   
	private class name1Clear extends MouseAdapter{
		
		public void mouseClicked(MouseEvent event)
		{
			if (count1++ == 0) name1.setText("");
		}
		
	}
	
	private class name2Clear extends MouseAdapter{
		
		public void mouseClicked(MouseEvent event)
		{
			if (count2++ == 0) name2.setText("");
		}
		
	}
	
	
	
}
