import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class elements {
 public Image img;
 public int x,y;
 public Boolean act;
 private Timer timerUpdate;
 
	public elements(Image img) {
		timerUpdate =new Timer(500, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				vniz();
				
			}
		});
		this.img= img;
		act=false;
	}
 
	public void draw(Graphics gr) {
		if(act==true) {
			gr.drawImage(img,x,y,null);
		}
	}

public void start() {
		timerUpdate.start();
		y=0;
		x=(int)(Math.random()*700);
		act=true;
	}

public void vniz()
{
	if(act==true) 
	{
		y+=6;
	}
	if(y+img.getHeight(null)>=470) {
		timerUpdate.stop();
	}
	
}
}

	

	
	



	
