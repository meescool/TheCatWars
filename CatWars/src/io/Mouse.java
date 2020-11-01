package io;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;

public class Mouse implements MouseListener {
	
		private Sound audio = new Sound();
	
		private URL hoverURL, clickURL= null;
		
		

		public void mouseClicked(MouseEvent e) {
			
		}

		public void mouseEntered(MouseEvent arg0) {
			hoverURL = getClass().getClassLoader().getResource("hover.wav");
			audio.setSound(hoverURL, 0);

		}
		

		public void mouseExited(MouseEvent arg0) {

		}	

		public void mousePressed(MouseEvent arg0) {
			clickURL = getClass().getClassLoader().getResource("click.wav");
			audio.setSound(clickURL, 0);
			
			
		}

		public void mouseReleased(MouseEvent arg0) {
		}

	}


