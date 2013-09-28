package tictactoe.view;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

import tictactoe.model.Game;

public class MainFrame extends JFrame  {
	
	public Game game;
	private int width;
	private int height;
	JPanel contentPane = new JPanel();
	GridBagConstraints gbc = new GridBagConstraints();
	JPanel MenuPanel = new MenuPanel();
	GamePanel GamePanel;
	JPanel StatusPanel; 
	MenuBar menuBar = new MenuBar();
		
	public MainFrame(){
	super();	
	init_menu();		
	}
	
	public MainFrame(int size, String name1, String name2){
		super();
		GamePanel = new GamePanel(size, this);
		init_game();
		game = Game.init(size);
		game.addPlayer(name1);
		game.addPlayer(name2);						
	}
		
	private void init_menu(){		
		width = 550;
		height = 300;
		this.setResizable(false); 
		setTitle("Крестики-нолики");
	    setDefaultCloseOperation(MainFrame.HIDE_ON_CLOSE); 
	    frameDisplayCenter(width, height, this);
	    add(MenuPanel);
	    setVisible(true);	
	}
	
	private void init_game(){
				
		StatusPanel = new StatusPanel(this, GamePanel);
		add(contentPane);
		contentPane.setLayout(new GridBagLayout());
		gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 0.01;		
		setJMenuBar(menuBar);
		contentPane.add(StatusPanel, gbc);
		gbc.weighty = 0.1;
        gbc.gridy = 1;	
		width = 800;
		height = 800;
		setTitle("Крестики-нолики");
	    setDefaultCloseOperation(MainFrame.EXIT_ON_CLOSE); 
	    frameDisplayCenter(width, height, this);
	    contentPane.add(GamePanel, gbc);
	    setVisible(true);	
	}
	
	private static void frameDisplayCenter (int sizeWidth, int sizeHeight, JFrame frame) {
	    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    frame.setSize(sizeWidth, sizeHeight);
	    int locationX = (screenSize.width - sizeWidth) / 2;
	    int locationY = (screenSize.height - sizeHeight) / 2;
	    frame.setBounds(locationX, locationY, sizeWidth, sizeHeight);
	}
}
