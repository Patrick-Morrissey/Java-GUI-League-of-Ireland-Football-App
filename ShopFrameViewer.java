//Name: Patrick Morrissey
//Date: 10/04/2025
//Function: To make a viewer for the ShopFrame frame

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ShopFrameViewer
{
	public static void main(String[] args)
	{
		JFrame frame = new ShopFrame();
		frame.setTitle("Shop");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setVisible(true);
	}
}