package gui;



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
import java.awt.RenderingHints;
import java.awt.Cursor;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;

public class HelpPanel extends JPanel {
	
	
	public HelpPanel() {
		
		javax.swing.border.Border labelBorder = BorderFactory.createLineBorder(new Color(113, 128, 185), 1);

		GridBagLayout gbl = new GridBagLayout(); // Create the manager
		setLayout(gbl);

		GridBagConstraints gbc = new GridBagConstraints(); // Create a GridBagConstraints to set everything
		gbc.fill = GridBagConstraints.BOTH; // expand components to fill the panel
		//gbc.insets = new Insets(50, 5, 5, 5); // set a margin of 5 pixel around all sides

		gbc.weightx = 1;
		gbc.weighty = 1;
		
		ImageIcon helpIcon = new ImageIcon("res/question.png");
		
		JLabel help = new JLabel(helpIcon);
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.insets = new Insets(0, 0, 0, 0);
		gbl.setConstraints(help, gbc);
		
		this.add(help);
		
		JLabel helpLabel = new JLabel("<html><b><span style='color:white'>Are you unsure about this game?</b><br><br>"
				+ "<span style='color:white'>Then you came to the right place!<br>"
				+ "<span style='color:white'>First off you select your cat's class.<br>"
				+ "<span style='color:white'>Next you will get a description of each cat<br>"
				+ "<span style='color:white'>and you'll be able to start your battles.");
		helpLabel.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		int w =(400-(helpLabel.getWidth()))/6;
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.insets = new Insets(0, w, 0, w);
		
		gbc.gridwidth = GridBagConstraints.RELATIVE;
		gbl.setConstraints(helpLabel, gbc);
		this.add(helpLabel);
		
		
	
	    
		
	    this.setBackground(null);
		
		
	}
}

