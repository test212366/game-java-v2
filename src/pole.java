import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

class pole extends JPanel {
	public Image korxina, fon, endgame;
	public int x = 350;
	private elements[] gameElem;
	private int sloshost;
	Timer timerUpdate, timerDraw;

	public pole(int sloshost) {
		this.sloshost = sloshost;
		gameElem = new elements[7];
		try {
			fon = ImageIO.read(new File("./images\\fon.png"));
			korxina = ImageIO.read(new File("./images\\korzina.png"));
			endgame = ImageIO.read(new File("./images\\end_game.png"));

			
			for (int i = 0; i < 7; i++) {
				gameElem[i] = new elements(ImageIO.read(new File("./images\\p" + i + ".png")));
			}

		} catch (IOException e) {
			System.out.println("404");
		}

		timerDraw = new Timer(50, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				repaint();
			}
		});
		timerDraw.start();
		
		

		timerUpdate = new Timer(3000, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				updateStart();

			}
		});
		timerUpdate.start();

	}

	public void paintComponent(Graphics gr) {
		// super.paintComponent(gr);
		gr.drawImage(fon, 0, 0, 800, 600, null);
		gr.drawImage(korxina, x, 455, null);
		for (int i = 0; i < 7; i++) {
			gameElem[i].draw(gr);
			if (gameElem[i].act == true) {
				if ((gameElem[i].y + gameElem[i].img.getHeight(null)) >= 470) {
					if (Math.abs(gameElem[i].x - x) > 75) {
						gr.drawImage(endgame, 300, 300, null);
						timerDraw.stop();
						timerUpdate.stop();
						break;
					} else {
						gameElem[i].act = false;
					}
				}
			}

		}

	}

	private void updateStart() {
		int kol = 0;
		for (int i = 0; i < 7; i++) {
			if (!gameElem[i].act) {
				if (kol < sloshost) {
					gameElem[i].start();
					break;
				}
			} else
				kol++;

		}
	}

}
