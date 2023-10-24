import java.awt.Container;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;




class okno extends JFrame{
	int sloshost;
 private pole gameP;
 

 public okno(int sloshost) {
	   
	    addKeyListener(new myKey());
	    setFocusable(true);
	    setBounds(10,10,800,600);
	    setTitle("Игруха топ гаме");
	    gameP=new pole(sloshost);
	   Container con= getContentPane();
	   con.add(gameP);
	     setVisible(true);
	   
	   
	 
   }

private class myKey implements KeyListener {

	@Override
	public void keyPressed(KeyEvent arg0) {
		int key_=arg0.getKeyCode();
		System.out.println(key_);
		if (key_==27) {
			System.exit(0);
		}
		else if (key_==37) {
			if(gameP.x-30>-48) {
			   gameP.x-=30;
			}
			else {
				gameP.x=752;
			}}
			
			else if (key_==39) {
				if(gameP.x+30< 752) {
				   gameP.x+=30;
				}
				else {
					gameP.x=-48;
				}
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {

		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {

		
	}
	   


}

	}
  

