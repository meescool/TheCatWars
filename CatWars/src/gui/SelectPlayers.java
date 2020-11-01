package gui;
import io.Mouse;
import io.Sound;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Panel;
import java.awt.RenderingHints;
import java.awt.Cursor;
import java.awt.event.*;
import java.net.URL;

import javax.swing.*;
import javax.swing.plaf.ColorUIResource;

public class SelectPlayers extends JPanel {
	JButton button1;
	int checkCombo1;
	int checkCombo2;
	JComboBox firstCombo;
	JComboBox secCombo;
	static JLabel firstPlayer;
	static JLabel secondPlayer;
	ImageIcon firstIcon = new ImageIcon(getClass().getClassLoader().getResource("player1.png"));
	ImageIcon secondIcon = new ImageIcon(getClass().getClassLoader().getResource("player2.png"));
	ImageIcon questionIcon = new ImageIcon(getClass().getClassLoader().getResource("question.png"));
	ImageIcon errorIcon = new ImageIcon(getClass().getClassLoader().getResource("error.png"));
	ImageIcon warningIcon = new ImageIcon(getClass().getClassLoader().getResource("surprise.png"));
	ImageIcon dwarfIcon = new ImageIcon(getClass().getClassLoader().getResource("dwarf.png"));
	ImageIcon orcIcon = new ImageIcon(getClass().getClassLoader().getResource("orc.png"));
	ImageIcon thiefIcon = new ImageIcon(getClass().getClassLoader().getResource("default.png"));
	ImageIcon wizIcon = new ImageIcon(getClass().getClassLoader().getResource("wizard.png"));
	ImageIcon elfIcon = new ImageIcon(getClass().getClassLoader().getResource("elf.png"));
	ImageIcon knightIcon = new ImageIcon(getClass().getClassLoader().getResource("knight.png"));

	// Names for the combo box
	public final static String[] names = { "<html><p style =' color:#ffffff;padding: 0 0 0 10;'>Dwarf",
			"<html><p style =' color:#ffffff;padding: 0 0 0 10;'>Orc",
			"<html><p style =' color:#ffffff;padding: 0 0 0 10;'>Thief",
			"<html><p style =' color:#ffffff;padding: 0 0 0 10;'>Wizard",
			"<html><p style =' color:#ffffff;padding: 0 0 0 10;'>Elf",
			"<html><p style =' color:#ffffff;padding: 0 0 0 10;'>Knight" };

	public SelectPlayers() {

		javax.swing.border.Border labelBorder = BorderFactory.createLineBorder(Color.white, 2);

		GridBagLayout gbl = new GridBagLayout(); // Create the manager
		setLayout(gbl);

		GridBagConstraints gbc = new GridBagConstraints(); // Create a GridBagConstraints to set everything
		gbc.fill = GridBagConstraints.BOTH; // expand components to fill the panel
		gbc.insets = new Insets(50, 5, 5, 5); // set a margin of 5 pixel around all sides

		gbc.weightx = 1;
		gbc.weighty = 1;

		JLabel selectP = new JLabel(
				"<html><br><p style='color:lightgrey;padding: 0 0 15 30;margin:0'>Select your player's class</p></html>");
		selectP.setBorder(null);
		// selectP.setOpaque(true);
		// selectP.setBackground(new Color(255, 150, 96));
		selectP.setFont(new Font("Luna", Font.PLAIN, 14));
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 1;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.insets = new Insets(10, 50, 5, 40);
		gbc.ipadx = 300;
		gbl.setConstraints(selectP, gbc);
		this.add(selectP);

		firstPlayer = new JLabel("<html><br><p style='color:#2B2D42;padding: 0 0 10 50'>Player 1</p></html>");
		setLabel(firstPlayer);

		firstPlayer.setText(null);
		firstPlayer.setIcon(firstIcon);
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.weightx = 0.9;
		gbc.gridwidth = 1;
		gbc.insets = new Insets(5, 50, 5, 5);
		gbl.setConstraints(firstPlayer, gbc);
		this.add(firstPlayer);


		// This adds a combo box
		firstCombo = new JComboBox(names);
		firstCombo.setBackground(new Color(255, 150, 96));
		firstCombo.setSelectedIndex(-1);
		firstCombo.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		gbc.weightx = 0.0;
		gbc.gridx = GridBagConstraints.RELATIVE;
		gbc.gridy = 1;
		gbc.ipadx = 0;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.insets = new Insets(5, 5, 5, 90);
		gbl.setConstraints(firstCombo, gbc);

		this.add(firstCombo);

		secondPlayer = new JLabel("<html><br><p style='color:#2B2D42;padding: 0 0 10 50'>Player 2</p></html>");

		setLabel(secondPlayer);

		// secondPlayer.setBorder(labelBorder);
		secondPlayer.setText(null);
		secondPlayer.setIcon(secondIcon);
		// secondPlayer.setOpaque(true);
		// secondPlayer.setBackground(new Color(255, 255, 255));

		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 2;
		gbc.insets = new Insets(5, 50, 5, 5);
		gbc.weightx = 0.9;
		gbl.setConstraints(secondPlayer, gbc);
		this.add(secondPlayer);

		secCombo = new JComboBox(names);
		secCombo.setBackground(new Color(255, 150, 96));
		secCombo.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		secCombo.setSelectedIndex(-1);
		gbc.gridx = GridBagConstraints.RELATIVE;
		gbc.gridy = GridBagConstraints.RELATIVE;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.insets = new Insets(5, 5, 5, 90);
		gbc.weightx = 0.0;
		gbl.setConstraints(secCombo, gbc);

		ListenForCombo combo1 = new ListenForCombo(firstCombo, firstPlayer);
		ListenForCombo combo2 = new ListenForCombo(secCombo, secondPlayer);
		firstCombo.addActionListener(combo1);

		secCombo.addActionListener(combo2);
		
		firstCombo.addMouseListener(new Mouse());
		secCombo.addMouseListener(new Mouse());

		this.add(secCombo);

		// How to create a button -----------------------

		ImageIcon beginBtn = new ImageIcon(getClass().getClassLoader().getResource("begin_btn.png"));
		ImageIcon beginBtn_s = new ImageIcon(getClass().getClassLoader().getResource("begin_btn_s.png"));

		button1 = new JButton("<html><p style=color:white>Begin War!");
		button1.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		button1.setBackground(Color.white);
		button1.setText(null);
		button1.setContentAreaFilled(false);
		button1.setFocusPainted(false);
		button1.setIcon(beginBtn);

		gbc.gridx = 0;
		gbc.gridy = 5;

		gbc.insets = new Insets(0, 50, 15, 50);
		gbc.ipadx = 20;
		gbc.ipady = 20;

		gbl.setConstraints(button1, gbc);

		button1.setBackground(new Color(255, 150, 96));
		button1.setBorder(null);

		ListenForButton lForButton = new ListenForButton();

		button1.addActionListener(lForButton);

		button1.addMouseListener(new Mouse() {

			@Override
			public void mouseClicked(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				button1.setIcon(beginBtn_s);

			}

			@Override
			public void mouseExited(MouseEvent e) {
				button1.setIcon(beginBtn);

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

		});

		this.add(button1);

		this.setOpaque(false);
		this.setBackground(new Color(0, 0, 0, 0));
		this.setVisible(true);

	}

	public void setLabel(JLabel player) {
		player.setFont(new Font("Century Gothic", Font.PLAIN, 17));
		player.setBorder(null);
		player.setBackground(Color.white);
	}

	/**
	 * 
	 * @author Marce
	 *
	 */
	public class ListenForCombo implements ActionListener {

		JComboBox combo;
		JLabel player;

		public ListenForCombo(JComboBox combo, JLabel player) {
			this.combo = combo;
			this.player = player;
		}

		public void actionPerformed(ActionEvent e) {

			switch (combo.getSelectedIndex()) {
			case 0:
				player.setIcon(dwarfIcon);
				player.setText(null);
				break;
			case 1:
				player.setIcon(orcIcon);
				player.setText(null);
				break;
			case 2:
				player.setIcon(thiefIcon);
				player.setText(null);
				break;
			case 3:
				player.setIcon(wizIcon);
				player.setText(null);
				break;
			case 4:
				player.setIcon(elfIcon);
				player.setText(null);
				break;
			case 5:
				player.setIcon(knightIcon);
				player.setText(null);
				break;

			}

		}
	}

	private class ListenForButton implements ActionListener {

		// This method is called when an event occurs

		public void actionPerformed(ActionEvent e) {



			// Check if the source of the event was the button
			checkCombo2 = (Integer) secCombo.getSelectedIndex();
			checkCombo1 = (Integer) firstCombo.getSelectedIndex();
			if (firstPlayer.getIcon().equals(firstIcon) || secondPlayer.getIcon().equals(secondIcon)) {
				JOptionPane pane;
				JDialog jd;
				JButton d;

				pane = new JOptionPane(
						"<html><div style = 'color:black;padding:0 30 2 3;font-size:12px;font-family:century;'>You haven't chosen a class<br>for you cats!",
						JOptionPane.PLAIN_MESSAGE, JOptionPane.DEFAULT_OPTION, warningIcon);
				pane.setBackground(Color.white);
				jd = pane.createDialog(SelectPlayers.this, "Oops!");
				jd.setBackground(Color.white);
				jd.setVisible(true);

			}

			else if (e.getSource() == button1) {

				if (checkCombo1 == checkCombo2) {

					JOptionPane pane;
					JDialog jd;

					pane = new JOptionPane(
							"<html><div style = 'color:rgb(0, 0, 0);padding:0 30 2 3;font-size:12px;font-family:century;'>Your cats can't be <br> of the same class!",
							JOptionPane.PLAIN_MESSAGE, JOptionPane.DEFAULT_OPTION, errorIcon);
					// getComponent(pane);
					pane.setBackground(Color.white);
					jd = pane.createDialog(SelectPlayers.this, "Oops!");
					jd.setBackground(Color.white);
					jd.setVisible(true);
				}

				else {

//					JComponent source = (JComponent) e.getSource();
//					JPanel parentPanel = (JPanel) source.getParent();
//				parentPanel.setVisible(false);
					StartScreen.mainJFramePane.removeAll(); // remove the current JPanel from the frame’s pane
					BattlePlayers intro = new BattlePlayers();
					intro.setVisible(true);
					// Main.helpPanel.setVisible(true);
					StartScreen.mainJFramePane.add(intro); // add the selected JPanel to the frame’s pane
					StartScreen.mainJFrame.revalidate(); // tell Swing the area is dirty from removeAll
					StartScreen.mainJFrame.repaint(); // tell Swing to recalculate the layout when adding components

				}

			}

		}

	}



}

