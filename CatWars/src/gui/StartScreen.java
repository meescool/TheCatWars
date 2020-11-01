package gui;

import java.awt.Color;
import java.awt.Container;
// Swing allows you to create Graphical User Interfaces
// You need the Swing library to create GUI interfaces
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

import io.Mouse;
import io.Sound;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;

public class StartScreen extends JFrame {

	public static Color bgGreen = new Color(0, 0, 0);
	public static SelectPlayers selectPlayers;
	public static HelpPanel helpPanel;
	static JFrame mainJFrame; // will store the frame in a member field for the actionListeners
	static Container mainJFramePane; // will store the frame’s pane in a member field for the actionListeners
	Sound audio = new Sound();
	
	public StartScreen() {

		mainJFrame = this;
		mainJFramePane = this.getContentPane();

		// Define the size of the frame
		this.setSize(400, 400);

		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension dim = tk.getScreenSize();
		int xPos = (dim.width / 2) - (this.getWidth() / 2);
		int yPos = (dim.height / 2) - (this.getHeight() / 2);
		
		// setting sound
		
		
		
		URL playURL, clickURL;
		playURL = getClass().getClassLoader().getResource("MintChocolate2A.wav");
		clickURL = getClass().getClassLoader().getResource("click.wav");
		
		

		this.setLocation(xPos, yPos);

		this.setResizable(false);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

		this.getContentPane().setBackground(bgGreen);
		this.setTitle("The Cat Wars");
		
		ImageIcon thumbnail = new ImageIcon(getClass().getClassLoader().getResource("wizard.png"));
		this.setIconImage(thumbnail.getImage()); // setting the icon for the jar file, and getting image from thumbnail

		// Select Players section panel is called and made
		selectPlayers = new SelectPlayers();
		selectPlayers.setVisible(false);
		// this.add(selectPlayers);

		// Help panel is called and made
		helpPanel = new HelpPanel();
		helpPanel.setVisible(false);
		// this.add(helpPanel);

//		 Creating new pane in the main frame to show the title screen with a PNG
		JPanel maine = new JPanel();
		JLabel maineP = new JLabel();
		
		ImageIcon titleIcon = new ImageIcon(getClass().getClassLoader().getResource("title2.png"));
		maineP.setIcon(titleIcon);
		maine.add(maineP);

		JButton startB = new JButton("<html><div style='color:white;padding:0 8 5 8'>Begin");
		
		ImageIcon playBtn = new ImageIcon(getClass().getClassLoader().getResource("play_btn.png"));
		ImageIcon playBtn_s = new ImageIcon(getClass().getClassLoader().getResource("play_btn_s.png"));
	
		startB.setFont(new Font("Century Gothic", Font.PLAIN, 25));
		startB.setText(null);
		startB.setIcon(playBtn);
		startB.setBorder(null);
		startB.setBackground(bgGreen);
		startB.setFocusPainted(false);
		startB.setContentAreaFilled(false);

		maine.setOpaque(false);
		maine.add(startB);

		this.add(maine);

		JMenuBar appMenuBar = new JMenuBar();
		setJMenuBar(appMenuBar);
		appMenuBar.setOpaque(true);
		appMenuBar.setBackground(new Color(255, 150, 96));

		appMenuBar.setBorder(null);

		JMenu demoMenu = new JMenu("<html><div style='color:white;padding:0 0 0 5;'>+");
		demoMenu.setFont(new Font("Century Gothic", Font.PLAIN, 25));

		demoMenu.setOpaque(true);
		demoMenu.setBackground(new Color(255, 150, 96));
		demoMenu.setBorder(null);
		appMenuBar.add(demoMenu);

		JLabel title = new JLabel("<html><div style= 'color:white;padding:0 0 0 130;'>Cat Wars");
		title.setFont(new Font("eastmarket", Font.PLAIN, 20));

		appMenuBar.add(title);

		JMenuItem helpItem = new JMenuItem("<html><div style='color:white;'>Help");
		JMenuItem newGameItem = new JMenuItem("<html><div style='color:white;'>New Game");
		JMenuItem quitMenuItem = new JMenuItem("<html><div style='color:white;'>Quit");
		
		ArrayList<JMenuItem> menuItems = new ArrayList<JMenuItem>(Arrays.asList(helpItem, newGameItem, quitMenuItem));
		
		// iterate through the menu items for cleaner code
		menuItems.forEach(item -> {
			
		item.setOpaque(true);
		item.setBackground(new Color(255, 150, 96));
		item.setBorder(null);
		demoMenu.add(item);
		item.addMouseListener(new Mouse());
		});

		
		startB.addMouseListener(new Mouse() {

			@Override
			public void mouseEntered(MouseEvent e) {
				startB.setIcon(playBtn_s);
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				startB.setIcon(playBtn);
			}
			
		});
		
		
		startB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mainJFramePane.removeAll(); // remove the current JPanel from the frame’s pane

				selectPlayers.setVisible(true);

				mainJFramePane.add(selectPlayers); // add the selected JPanel to the frame’s pane
				mainJFrame.revalidate(); // tell Swing the area is dirty from removeAll
				mainJFrame.repaint(); // tell Swing to recalculate the layout when adding components
				
				audio.setSound(playURL, 1);
				
			}
		});

		helpItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mainJFramePane.removeAll(); // remove the current JPanel from the frame’s pane
				helpPanel.setVisible(true);
				mainJFramePane.add(helpPanel); // add the selected JPanel to the frame’s pane
				mainJFrame.revalidate(); // tell Swing the area is dirty from removeAll
				mainJFrame.repaint(); // tell Swing to recalculate the layout when adding components

				// selectPlayers.setVisible(false);
				// maine.setVisible(false);
			}
		});

		newGameItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mainJFramePane.removeAll(); // remove the current JPanel from the frame’s pane
				SelectPlayers select = new SelectPlayers();
				select.setVisible(true);
				mainJFramePane.add(select); // add the selected JPanel to the frame’s pane
				mainJFrame.revalidate(); // tell Swing the area is dirty from removeAll
				mainJFrame.repaint(); // tell Swing to recalculate the layout when adding components
			}
		});

		quitMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//audio.setSound(clickURL, 0);
				System.exit(0);
			}
		});

		this.setVisible(true);

	}

	


}
