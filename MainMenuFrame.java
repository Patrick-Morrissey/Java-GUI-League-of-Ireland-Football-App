//Name: Patrick Morrissey
//Date: 15/04/2025
//Function: To make a frame for League of Ireland Football App main menu

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.*; // for colours

public class MainMenuFrame extends JFrame
{
	private static final int FRAME_WIDTH = 800;
	private static final int FRAME_HEIGHT = 800;
	
	// labels
	private JLabel menuHeadingLabel; 
	
	// textAreas
	private JTextArea menuInstructionsTextArea;
	
	// menu images
	private ImageIcon registerIcon;
	private JLabel registerIconLabel;
	private ImageIcon scoreBoardIcon;
	private JLabel scoreBoardIconLabel;
	
	// buttons
	private JButton goToShopButton;
	private JButton goToScoresTrackerButton;
	private JButton exitAppButton;
	
	// panels
	private JPanel menuHeaderPanel;
	private JPanel menuInstructionsPanel;
	private JPanel goToScoreTrackerPanel;
	private JPanel goToShopPanel;
	private JPanel menuContainerPanel;
	
	public MainMenuFrame()
	{
		createGoToScoresTrackerButton();
		createGoToShopButton();
		creatExitAppButton();
		
		createMenuInstructionsPanel();
		createGoToScoreTrackerPanel();
		createGoToShopPanel();
		createMenuHeaderPanel();
		
		createMenuContainerPanel(); // calls the method to create the main menu container panel
		
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
	}
	
	private JPanel createMenuHeaderPanel()
	{
		menuHeaderPanel = new JPanel();
		menuHeaderPanel.setBackground(new Color(101,92,92));
		menuHeaderPanel.setBounds(0,0,800,100); // setbounds(x,y of top left corner,width,height)
		menuHeaderPanel.setLayout(null);
		
		menuHeadingLabel = new JLabel("League of Ireland Football App");
		menuHeadingLabel.setFont(new Font(null,Font.PLAIN,25)); // for setting font style
		menuHeadingLabel.setForeground(Color.white);
		
		menuHeaderPanel.add(menuHeadingLabel);
		menuHeadingLabel.setBounds(200,35,400,30);
		
		menuHeaderPanel.add(exitAppButton);
		exitAppButton.setBounds(675,25,100,50);
		
		return menuHeaderPanel;
	}
	
	private JPanel createMenuInstructionsPanel()
	{
		menuInstructionsPanel = new JPanel();
		menuInstructionsPanel.setBackground(Color.green);
		menuInstructionsPanel.setBounds(100,125,600,50);
		menuInstructionsPanel.setLayout(null);
		
		menuInstructionsTextArea = new JTextArea("Welcome to the League of Ireland Football App. Select Match Scores if you would like to use the Match Score Tracker or League Shop if you want to buy gear or merchandise.");
		menuInstructionsTextArea.setFont(new Font(null,Font.PLAIN,15));
		menuInstructionsTextArea.setLineWrap(true);
		menuInstructionsTextArea.setEditable(false);
		
		menuInstructionsPanel.add(menuInstructionsTextArea);
		menuInstructionsTextArea.setBackground(Color.green);
		menuInstructionsTextArea.setBounds(0,0,600,50);
		
		return menuInstructionsPanel;
	}
	
	private JPanel createGoToScoreTrackerPanel()
	{
		goToScoreTrackerPanel = new JPanel();
		goToScoreTrackerPanel.setBackground(Color.white);
		goToScoreTrackerPanel.setBounds(100,200,250,400); // setbounds(x,y of top left corner,width,height)
		goToScoreTrackerPanel.setLayout(null);
		
		goToScoreTrackerPanel.add(goToScoresTrackerButton);
		goToScoresTrackerButton.setBounds(25,25,200,50);
		
		scoreBoardIcon = new ImageIcon("Images/scoreboard.jpg"); // adding the scoreboard image
		scoreBoardIconLabel = new JLabel(scoreBoardIcon);
		
		goToScoreTrackerPanel.add(scoreBoardIconLabel);
		scoreBoardIconLabel.setBounds(25,150,200,200);
		
		return goToScoreTrackerPanel;
	}
	
	private JPanel createGoToShopPanel()
	{
		goToShopPanel = new JPanel();
		goToShopPanel.setBackground(Color.white);
		goToShopPanel.setBounds(450,200,250,400); // setbounds(x,y of top left corner,width,height)
		goToShopPanel.setLayout(null);

		goToShopPanel.add(goToShopButton);
		goToShopButton.setBounds(25,25,200,50);
		
		registerIcon = new ImageIcon("Images/cashregister.jpg"); // adding the scoreboard image
		registerIconLabel = new JLabel(registerIcon);
		
		goToShopPanel.add(registerIconLabel);
		registerIconLabel.setBounds(25,150,200,200);
		
		return goToShopPanel;
	}
	
	// the container panel for the main menu frame
	private void createMenuContainerPanel()
	{
		menuContainerPanel = new JPanel();
		menuContainerPanel.setBackground(Color.green);
		menuContainerPanel.setBounds(0,0,FRAME_WIDTH,FRAME_HEIGHT); // setbounds(x,y of top left corner,width,height)
		menuContainerPanel.setLayout(null);
		
		menuContainerPanel.add(menuHeaderPanel);
		menuContainerPanel.add(menuInstructionsPanel);
		menuContainerPanel.add(goToScoreTrackerPanel);
		menuContainerPanel.add(goToShopPanel);
		
		add(menuContainerPanel);
	}
	
	// button to open the football scores tracker frame
	private void createGoToScoresTrackerButton()
	{
		goToScoresTrackerButton = new JButton("Match Scores Tracker");
		goToScoresTrackerButton.setBackground(new Color(101,92,92));
		goToScoresTrackerButton.setForeground(Color.white);
		goToScoresTrackerButton.setFont(new Font(null,Font.PLAIN,15));
		
		ActionListener listener = new goToScoresTrackerListener();
		goToScoresTrackerButton.addActionListener(listener);
	}
	
	class goToScoresTrackerListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			dispose(); // closes the main menu frame
			JFrame scoresFrame = new FootballScoresFrame();
			scoresFrame.setTitle("League of Ireland Football App - Match Score Tracker");
			scoresFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			scoresFrame.setLayout(null);
			scoresFrame.setVisible(true);
		}
	}
	
	// button to open the shop
	private void createGoToShopButton()
	{
		goToShopButton = new JButton("League Football Shop");
		goToShopButton.setBackground(new Color(101,92,92));
		goToShopButton.setForeground(Color.white);
		goToShopButton.setFont(new Font(null,Font.PLAIN,15));
		
		ActionListener listener = new goToShopListener();
		goToShopButton.addActionListener(listener);
	}
	
	class goToShopListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			dispose(); // closes the main menu frame
			JFrame shopFrame = new ShopFrame();
			shopFrame.setTitle("League of Ireland Football App - Shop");
			shopFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			shopFrame.setLayout(null);
			shopFrame.setVisible(true);
		}
	}
	
	// button to exit the app
	private void creatExitAppButton()
	{
		exitAppButton = new JButton("Exit App");
		//myButton.setFocusable(false); // not necessary
		
		ActionListener listener = new exitAppListener();
		exitAppButton.addActionListener(listener);
	}
	
	class exitAppListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			dispose(); // closes the main menu frame
		}
	}
}