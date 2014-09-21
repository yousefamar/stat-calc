import java.awt.Dimension;
import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		
		//TODO: Fake startup thing.
		
		JFrame frame = new JFrame("StatCalc");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		MainGUI gui = new MainGUI(frame);

		frame.setSize(new Dimension(450,150));
		frame.setResizable(false);
		frame.getContentPane().add(gui);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
