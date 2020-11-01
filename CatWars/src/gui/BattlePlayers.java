package gui;

import java.awt.Color;
import java.util.Random;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import io.Mouse;

public class BattlePlayers extends JPanel {
	
	JButton claw1;
	JButton bite1;
	JButton special1;

	JButton claw2;
	JButton bite2;
	JButton special2;
	
	 int p1h = 100;
		
		int p2h = 100;
JLabel p1 = new JLabel(p1h + "%");
		
		JLabel p2 = new JLabel(p2h + "%");

	public BattlePlayers() {

		ImageIcon heart = new ImageIcon(getClass().getClassLoader().getResource("bHeart.png"));

		
		
		JLabel h1 = new JLabel(heart);
		JLabel h2 = new JLabel(heart);
		
		
		
		
		p1.setFont(new Font("Century Gothic", Font.BOLD, 14));
		p1.setForeground(Color.gray);
		p2.setFont(new Font("Century Gothic", Font.BOLD, 14));
		p2.setForeground(Color.gray);
		
		GridBagLayout gbl = new GridBagLayout(); // Create the manager
		setLayout(gbl);

		GridBagConstraints gbc = new GridBagConstraints(); // Create a GridBagConstraints to set everything
		gbc.fill = GridBagConstraints.BOTH; // expand components to fill the panel
		gbc.insets = new Insets(50, 5, 5, 5); // set a margin of 5 pixel around all sides

		gbc.weightx = 1;
		gbc.weighty = 1;

		add(SelectPlayers.firstPlayer);
		add(SelectPlayers.secondPlayer);
		

		claw1 = new SetButton("Claw");
		bite1 = new SetButton("Bite");
		special1 = new SetButton("Special");


		claw2 = new SetButton("Claw");
		bite2 = new SetButton("Bite");
		special2 = new SetButton("Special");
		claw2.setEnabled(false);
		bite2.setEnabled(false);
		special2.setEnabled(false);

		claw1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				setEnabled(1);
				healthDown(1);

			}

		});
		bite1.addActionListener(new ActionListener() {
			
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setEnabled(1);
				healthDown(1);
				

			}

		});
		special1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				setEnabled(1);
				healthDown(1);
			}

		});
		
		
		
		
		claw2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setEnabled(0);
				healthDown(0);

			}

		});
		bite2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				setEnabled(0);
				healthDown(0);

			}

		});
		special2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				setEnabled(0);
				healthDown(0);

			}

		});
		
		
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.ipadx = 5;
		gbc.insets = new Insets(5, 5, 5, 5);
		gbl.setConstraints(h1, gbc);
		
		this.add(h1);
		
		gbc.gridx = 2;
		gbc.gridy = 0;
		gbc.ipadx = 5;
		gbc.insets = new Insets(5, 5, 5, 5);
		gbl.setConstraints(p1, gbc);
		
		this.add(p1);
		
		gbc.gridx =  4;
		gbc.gridy = 0;
//		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.insets = new Insets(5, 5, 5, 5);
		gbl.setConstraints(h2, gbc);
		
		this.add(h2);
		
		gbc.gridx =  5;
		gbc.gridy = 0;
	//	gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.insets = new Insets(5, 5, 5, 5);
		gbl.setConstraints(p2, gbc);
		this.add(p2);
		
		

		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.gridwidth = 3;
		gbc.ipadx = 5;
		gbc.insets = new Insets(5, 5, 5, 5);
		gbl.setConstraints(SelectPlayers.firstPlayer, gbc);

		gbc.gridx = GridBagConstraints.RELATIVE;
		gbc.gridy = 1;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.insets = new Insets(5, 5, 5, 50);
		gbl.setConstraints(SelectPlayers.secondPlayer, gbc);

		gbc.gridwidth = 1;
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.insets = new Insets(5, 20, 50, 0);

		gbl.setConstraints(claw1, gbc);

	
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.insets = new Insets(5, 0, 50, 0);
		gbl.setConstraints(bite1, gbc);

		gbc.gridx = 2;
		gbc.gridy = 2;
		gbc.insets = new Insets(5, 0, 50, 15);
		gbl.setConstraints(special1, gbc);


		gbc.gridx = 4;
		gbc.gridy = 2;
		gbc.insets = new Insets(5, 15, 50, 0);
		gbl.setConstraints(claw2, gbc);

		gbc.gridwidth = 1;
		gbc.gridx = 5;
		gbc.gridy = 2;
		gbc.insets = new Insets(5, 0, 50, 0);
		gbl.setConstraints(bite2, gbc);

		gbc.gridx = 6;
		gbc.gridy = 2;
		gbc.insets = new Insets(5, 0, 50, 20);
		gbl.setConstraints(special2, gbc);

		this.add(claw1);
		this.add(bite1);
		this.add(special1);

		this.add(claw2);
		this.add(bite2);
		this.add(special2);

		this.setOpaque(false);
		this.setVisible(true);

	}
	
	public void setButton(JButton button) {
		button.setBackground(new Color(34,32,32));
		button.setFont(new Font("Century Gothic", Font.PLAIN, 12));
		button.setFocusable(false);
	}
	
	public void healthDown(int i) {
		
		Random rand = new Random();
		int attackSuccess = rand.nextInt(15) + 1;
	
		if (i == 0) {
			p1h-=attackSuccess;
			if (p1h <= 0) {
				p2.setText("0%");
				//popup message player 1 one!
				message(2);
			}
			else
			p1.setText(p1h+"%");
			
		}
		else {
			p2h-=attackSuccess;
			if (p2h <= 0) {
				p2.setText("0%");
				//popup message player 2 one!
				message(1);
			}
			else
			p2.setText(p2h+"%");
		}
	}
	
	public void message(int x) {
		
		ImageIcon player = null;
		
		JOptionPane pane;
		JDialog jd;
		JButton d;
		
		if(x == 1) {
			pane = new JOptionPane(
					"<html><div style = 'color:black;padding:0 30 2 3;font-size:12px;font-family:century;'>Won the battle!",
					JOptionPane.PLAIN_MESSAGE, JOptionPane.DEFAULT_OPTION, SelectPlayers.firstPlayer.getIcon());
					
		}
			
			
		else {
			pane = new JOptionPane(
					"<html><div style = 'color:black;padding:0 30 2 3;font-size:12px;font-family:century;'>Won the battle!",
					JOptionPane.PLAIN_MESSAGE, JOptionPane.DEFAULT_OPTION,  SelectPlayers.secondPlayer.getIcon());
		}
		
	

		
		pane.setBackground(Color.white);
		jd = pane.createDialog(BattlePlayers.this, "Yay!");
		jd.setBackground(Color.white);
		jd.setVisible(true);
		
	}
	

	public void setEnabled(int x) {
		if (x == 1) {
			claw1.setEnabled(false);
			bite1.setEnabled(false);
			special1.setEnabled(false);
			claw2.setEnabled(true);
			bite2.setEnabled(true);
			special2.setEnabled(true);
		} else {
			claw1.setEnabled(true);
			bite1.setEnabled(true);
			special1.setEnabled(true);
			claw2.setEnabled(false);
			bite2.setEnabled(false);
			special2.setEnabled(false);
		}
	}

	public class SetButton extends JButton {
		SetButton(String label) {
			this.setBackground(Color.white);
			this.setFont(new Font("Century Gothic", Font.PLAIN, 10));
			this.setFocusable(false);
			this.setText(label);
			this.setBorder(null);
			this.addMouseListener(new Mouse() {

				@Override
				public void mouseEntered(MouseEvent arg0) {
					

					setBackground(Color.orange);
				}

				@Override
				public void mouseExited(MouseEvent arg0) {
					setBackground(Color.white);

				}

			});

		}
	}
}
