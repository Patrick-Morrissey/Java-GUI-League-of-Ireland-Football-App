//Name: Patrick Morrissey
//Date: 15/04/2025
//Function: To make a viewer for the main menu frame of the League of Ireland App

import javax.swing.JFrame;

public class FootballAppFrameViewer
{
	public static void main(String[] args)
	{
		JFrame appMainMenuFrame = new MainMenuFrame();
		appMainMenuFrame.setTitle("League of Ireland Football App - Main Menu");
		appMainMenuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		appMainMenuFrame.setLayout(null);
		appMainMenuFrame.setVisible(true);
	}
}