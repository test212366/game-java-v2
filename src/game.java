import javax.swing.JOptionPane;

public class game {

	public static void main(String[] args) {
		
		String rez=JOptionPane.showInputDialog(null,"������� ��������� �� 1 �� 7","��������� ����",1);
		int sloshost=rez.charAt(0)-'0';
		if ((sloshost>=1)&&(sloshost<=7)) {
			okno window= new okno(sloshost);
		}
	}

}
