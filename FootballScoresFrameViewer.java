//Name: Patrick Morrissey
//Date: 06/04/2025
//Function: To make a viewer for the FootballScoresFrame frame

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FootballScoresFrameViewer
{
	public static void main(String[] args)
	{
		JFrame frame = new FootballScoresFrame();
		frame.setTitle("Match Score Tracker");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setVisible(true);
	}
}