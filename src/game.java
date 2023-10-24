import javax.swing.JOptionPane;

public class game {

	public static void main(String[] args) {
		
		String rez=JOptionPane.showInputDialog(null,"¬ведите сложность от 1 до 7","сложность игры",1);
		int sloshost=rez.charAt(0)-'0';
		if ((sloshost>=1)&&(sloshost<=7)) {
			okno window= new okno(sloshost);
		}
	}

}
