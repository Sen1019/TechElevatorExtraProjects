package TicTacToePac;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TicTacGui extends JFrame{

	
    JPanel buttonPanel = new JPanel();
    JButton a1 = new JButton("A1");
	
	public TicTacGui(){
		
		a1.setBounds(60, 400, 220, 30);
		
		buttonPanel.setBounds(800, 800, 200, 100);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Example GUI");
		setSize(400, 400);
		setLocationRelativeTo(null);
		setVisible(true);
		setBackground(Color.BLACK);
	    
	    buttonPanel.add(a1);
	    add(buttonPanel);
	}
	
}
