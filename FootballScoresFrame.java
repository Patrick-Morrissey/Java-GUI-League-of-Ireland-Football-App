//Name: Patrick Morrissey
//Date: 06/04/2025
//Function: To make a frame for tracking Football scores

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*; // adds everything in the awt library - needed for setting colours and borders
import java.util.ArrayList; // import the ArrayList class
import java.util.Collections; // importing the collections class for managing the arraylist used for adding and removing players

public class FootballScoresFrame extends JFrame
{
	private static final int FRAME_WIDTH = 800;
	private static final int FRAME_HEIGHT = 800;
	private static final int AREA_ROWS = 10;
	private static final int AREA_COLUMNS = 20;
	
	private JLabel headingLabel; // main menu heading
	private JLabel homeTeamScoreLabel;
	private JLabel awayTeamScoreLabel;
	private JLabel scoreboardLabel; //scoreboard label
	private JLabel homeLabel; 
	private JLabel awayLabel; 
	private JLabel homeGoalsLabel;
	private JLabel awayGoalsLabel; 
	
	private JPanel homeTeamNameLabelPanel;
	private JPanel awayTeamNameLabelPanel;
	private JLabel homeTeamNameLabel; 
	private JLabel awayTeamNameLabel;
	
	private JPanel scoresHeaderPanel; // header panel
	private JPanel scoresContainerPanel; //scores container panel
	
	private JPanel homeTeamScorePanel;
	private JPanel awayTeamScorePanel;
	private JPanel scoreBoardPanel;
	private JPanel homeInfoPanel;
	private JPanel awayInfoPanel;
	private JPanel changeHomeTeamPanel;
	private JPanel changeAwayTeamPanel;
	private JPanel changeHomePlayersPanel;
	private JPanel changeAwayPlayersPanel;
	
	// buttons for home goals
	private JButton hGoalAddButton;
	private JButton hGoalSubButton;
	private JButton resetHGButton;
	
	// buttons for away goals
	private JButton aGoalAddButton;
	private JButton aGoalSubButton;
	private JButton aResetButton;
	
	// match result button
	private JButton matchResultButton;
	
	// the exit button
	private JButton exitScoresTrackerButton;
	
	// team badge panels
	private JPanel homeTeamBadgePanel; 
	private JPanel awayTeamBadgePanel; 
	
	// Setting up the arrays for the list of teams
	private String[] teams = {"Drogheda United","St Patrick's Athletic","Galway United FC","Shelbourne","Shamrock Rovers",
	"Derry City","Bohemians","Waterford","Cork City","Sligo Rovers"};
	
	private String[] playersArray = {"Padraig Amond","Cristiano Ronaldo","Lionel Messi","Thomas Muller","Jack Byrne", "Michael Duffy","Ross Tierney","Kian Best",
	"Erling Haaland","Mohamed Salah","Toni Kroos","Fede Valverde","Robert Lewandowski","Peter Cherrie","Pedri","Rodri","Kylian Mbappe","Lamine Yamal","Alexander Isak","Brendan Clarke"};
	
	// the vector for the list of players
	private ArrayList<String> homePlayers = new ArrayList<String>();
	private ArrayList<String> awayPlayers = new ArrayList<String>();
	
	// components for adding and removing teams
	private JComboBox homeTeamsComboBox;
	private JComboBox awayTeamsComboBox;
	
	private JLabel addHomeTeamLabel; 
	private JLabel addAwayTeamLabel;
	
	private String teamNameLabelDefault = "Please Select A Team";
	private String selectedHomeTeamName = "";
	private String selectedAwayTeamName = "";
	private int selectedHTeamIndex = 0;
	private int selectedATeamIndex = 0;
	
	private JButton removeHomeTeamButton;
	private JButton removeAwayTeamButton;
	
	private boolean homeTeamSelected = false;
	private boolean awayTeamSelected = false;
	
	// components for adding and removing players
	private JPanel homePlayersDisplayPanel;
	private JPanel awayPlayersDisplayPanel;
	private JLabel homePlayersDisplayLabel;
	private JLabel awayPlayersDisplayLabel;
	private JComboBox addHomePlayersComboBox;
	private JComboBox addAwayPlayersComboBox;
	private JComboBox removeHomePlayersComboBox;
	private JComboBox removeAwayPlayersComboBox;
	private JLabel addHomePlayersLabel;
	private JLabel addAwayPlayersLabel;
	private JLabel removeHomePlayersLabel;
	private JLabel removeAwayPlayersLabel;
	private JTextArea homePlayersTextArea;
	private JTextArea awayPlayersTextArea;
	private JScrollPane homePlayersScrollPane;
	private JScrollPane awayPlayersScrollPane;
	
	private JPanel matchResultPanel;
	private JLabel matchResultLabel;
	private String matchOutcome;
	
	private JButton showHideHomePlayersDisplayButton;
	private JButton showHideAwayPlayersDisplayButton;
	private boolean homePlayersDisplayVisible = false;
	private boolean awayPlayersDisplayVisible = false;
	
	private int numPlayerHT;
	private int numPlayerAT;
	private JLabel numPlayerHTLabel;
	private JLabel numPlayerATLabel;
	
	// setting variables
	private int homeTeamScore = 0;
	private int awayTeamScore = 0;
	
	public FootballScoresFrame()
	{
		//ImageIcon icon = new ImageIcon("Images/LoIFootball.jpg"); // adding an image
		
		// Add, sub, and reset home goals method calls
		createAddHGoalButton();
		createSubHGoalButton();
		createResetHGoalButton();
		
		// Add, sub, and reset away goals methods calls
		createAddAGoalButton();
		createSubAGoalButton();
		createResetAGoalButton();
		
		createMatchResultButton();
		
		// Exit button
		createExitScoresTrackerButton();
		
		createHomeTeamsComboBox();
		createAwayTeamsComboBox();
		createRemoveHomeTeamButton();
		createRemoveAwayTeamButton();
		
		createAddHomePlayersComboBox();
		createAddAwayPlayersComboBox();
		createRemoveHomePlayersComboBox();
		createRemoveAwayPlayersComboBox();
		createShowHideHomePlayersDisplayButton();
		createShowHideAwayPlayersDisplayButton();
		
		createScoresHeaderPanel();
		createHomeTeamNameLabelPanel();
		createAwayTeamNameLabelPanel();
		createHomeInfoPanel();
		createAwayInfoPanel();
		createHomeTeamScorePanel();
		createAwayTeamScorePanel();
		createScoreBoardPanel();
		createHomeTeamBadgePanel();
		createAwayTeamBadgePanel();
		createChangeHomeTeamPanel();
		createChangeAwayTeamPanel();
		createChangeHomePlayersPanel();
		createChangeAwayPlayersPanel();
		createHomePlayersDisplayPanel();
		createAwayPlayersDisplayPanel();
		createMatchResultPanel();
		
		createScoresContainerPanel();
		
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
	}
	
	private JPanel createScoresHeaderPanel()
	{
		scoresHeaderPanel = new JPanel();
		scoresHeaderPanel.setBackground(new Color(101,92,92));
		scoresHeaderPanel.setBounds(0,0,800,100); // setbounds(x,y of top left corner,width,height)
		scoresHeaderPanel.setLayout(null);
		
		headingLabel = new JLabel("Match Score Tracker");
		headingLabel.setFont(new Font(null,Font.PLAIN,25)); // for setting font style
		headingLabel.setForeground(Color.white);  // Set text color
		scoresHeaderPanel.add(headingLabel);
		headingLabel.setBounds(300,35,250,25);
		
		scoresHeaderPanel.add(exitScoresTrackerButton);
		exitScoresTrackerButton.setBounds(675,25,100,50);
		
		return scoresHeaderPanel;
	}
	
	private JPanel createScoreBoardPanel()
	{
		scoreBoardPanel = new JPanel();
		scoreBoardPanel.setBackground(Color.green);
		scoreBoardPanel.setBounds(300,200,200,100); // setbounds(x,y of top left corner,width,height)
		
		scoreboardLabel = new JLabel(homeTeamScore + " - " + awayTeamScore);
		scoreboardLabel.setFont(new Font(null,Font.PLAIN,60)); // for setting font style
		scoreBoardPanel.add(scoreboardLabel);
		
		return scoreBoardPanel;
	}
	
	// home team name label panel top of screen
	private JPanel createHomeTeamNameLabelPanel()
	{
		homeTeamNameLabelPanel = new JPanel();
		homeTeamNameLabelPanel.setBackground(Color.green);
		homeTeamNameLabelPanel.setBounds(100,110,150,25);
		homeTeamNameLabel = new JLabel(teamNameLabelDefault);
		homeTeamNameLabel.setFont(new Font(null,Font.PLAIN,15));
		
		homeTeamNameLabelPanel.add(homeTeamNameLabel);
		
		return homeTeamNameLabelPanel;
	}
	
	// away team name label panel top of screen
	private JPanel createAwayTeamNameLabelPanel()
	{
		awayTeamNameLabelPanel = new JPanel();
		awayTeamNameLabelPanel.setBackground(Color.green);
		awayTeamNameLabelPanel.setBounds(600,110,150,25);
		awayTeamNameLabel = new JLabel(teamNameLabelDefault);
		awayTeamNameLabel.setFont(new Font(null,Font.PLAIN,15));
		
		awayTeamNameLabelPanel.add(awayTeamNameLabel);
		
		return homeTeamNameLabelPanel;
	}
	
	private JPanel createHomeTeamScorePanel()
	{
		homeTeamScorePanel = new JPanel();
		homeTeamScorePanel.setBackground(Color.green);
		homeTeamScorePanel.setBounds(0,600,400,100);
		
		homeGoalsLabel = new JLabel("Goal");
		homeTeamScoreLabel = new JLabel("0");
		
		homeTeamScorePanel.add(homeGoalsLabel);
		homeTeamScorePanel.add(hGoalAddButton);
		homeTeamScorePanel.add(hGoalSubButton);
		homeTeamScorePanel.add(resetHGButton);
		homeTeamScorePanel.add(homeTeamScoreLabel);
		
		return homeTeamScorePanel;
	}
	
	private JPanel createAwayTeamScorePanel()
	{
		awayTeamScorePanel = new JPanel();
		awayTeamScorePanel.setBackground(Color.green);
		awayTeamScorePanel.setBounds(400,600,400,100);
		
		awayGoalsLabel = new JLabel("Goal");
		awayTeamScoreLabel = new JLabel("0");
		
		awayTeamScorePanel.add(awayGoalsLabel);
		awayTeamScorePanel.add(aGoalAddButton);
		awayTeamScorePanel.add(aGoalSubButton);
		awayTeamScorePanel.add(aResetButton);
		awayTeamScorePanel.add(awayTeamScoreLabel);
		
		return awayTeamScorePanel;
	}
	
	// panel with the text home team
	private JPanel createHomeInfoPanel()
	{
		homeInfoPanel = new JPanel();
		homeInfoPanel.setBackground(Color.red);
		homeInfoPanel.setBounds(100,150,100,50);
		
		homeLabel = new JLabel("Home Team");
		homeInfoPanel.add(homeLabel);
		
		return homeInfoPanel;
	}
	
	// panel with the text away team
	private JPanel createAwayInfoPanel()
	{
		awayInfoPanel = new JPanel();
		awayInfoPanel.setBackground(Color.red);
		awayInfoPanel.setBounds(600,150,100,50);
		
		awayLabel = new JLabel("Away Team");
		awayInfoPanel.add(awayLabel);
		
		return awayInfoPanel;
	}
	
	// home team badge panel
	private JPanel createHomeTeamBadgePanel()
	{
		homeTeamBadgePanel = new JPanel();
		homeTeamBadgePanel.setBackground(Color.white);
		homeTeamBadgePanel.setBounds(100,200,100,100); // setbounds(x,y of top left corner,width,height)
		
		return homeTeamBadgePanel;
	}
	
	// away team badge panel
	private JPanel createAwayTeamBadgePanel()
	{
		awayTeamBadgePanel = new JPanel();
		awayTeamBadgePanel.setBackground(Color.white);
		awayTeamBadgePanel.setBounds(600,200,100,100); // setbounds(x,y of top left corner,width,height)
		
		return awayTeamBadgePanel;
	}
	
	// panel for changing the home team
	private JPanel createChangeHomeTeamPanel()
	{
		changeHomeTeamPanel = new JPanel();
		changeHomeTeamPanel.setBackground(Color.green);
		changeHomeTeamPanel.setBounds(0,350,350,100); // setbounds(x,y of top left corner,width,height)
		
		addHomeTeamLabel = new JLabel("Add Home Team");
		
		changeHomeTeamPanel.add(addHomeTeamLabel);
		changeHomeTeamPanel.add(homeTeamsComboBox);
		changeHomeTeamPanel.add(removeHomeTeamButton);
		
		return changeHomeTeamPanel;
	}
	
	// panel for changing the away team
	private JPanel createChangeAwayTeamPanel()
	{
		changeAwayTeamPanel = new JPanel();
		changeAwayTeamPanel.setBackground(Color.green);
		changeAwayTeamPanel.setBounds(450,350,350,100); // setbounds(x,y of top left corner,width,height)
		
		addAwayTeamLabel = new JLabel("Add Away Team");
		
		changeAwayTeamPanel.add(addAwayTeamLabel);
		changeAwayTeamPanel.add(awayTeamsComboBox);
		changeAwayTeamPanel.add(removeAwayTeamButton);
		
		return changeAwayTeamPanel;
	}
	
	private JPanel createChangeHomePlayersPanel()
	{
		changeHomePlayersPanel = new JPanel();
		changeHomePlayersPanel.setBackground(Color.green);
		changeHomePlayersPanel.setBounds(0,450,350,150); // setbounds(x,y of top left corner,width,height)
		
		addHomePlayersLabel = new JLabel("Add Home Players");
		removeHomePlayersLabel = new JLabel("Remove Home Players");
		numPlayerHTLabel = new JLabel("Number of players: " + numPlayerHT);
		
		changeHomePlayersPanel.add(addHomePlayersLabel);
		changeHomePlayersPanel.add(addHomePlayersComboBox);
		changeHomePlayersPanel.add(removeHomePlayersLabel);
		changeHomePlayersPanel.add(removeHomePlayersComboBox);
		changeHomePlayersPanel.add(numPlayerHTLabel);
		changeHomePlayersPanel.add(showHideHomePlayersDisplayButton);
		
		return changeHomePlayersPanel;
	}
	
	private JPanel createChangeAwayPlayersPanel()
	{
		changeAwayPlayersPanel = new JPanel();
		changeAwayPlayersPanel.setBackground(Color.green);
		changeAwayPlayersPanel.setBounds(450,450,350,150); // setbounds(x,y of top left corner,width,height)
		
		addAwayPlayersLabel = new JLabel("Add Away Players");
		removeAwayPlayersLabel = new JLabel("Remove Away Players");
		numPlayerATLabel = new JLabel("Number of players: " + numPlayerAT);
		
		changeAwayPlayersPanel.add(addAwayPlayersLabel);
		changeAwayPlayersPanel.add(addAwayPlayersComboBox);
		changeAwayPlayersPanel.add(removeAwayPlayersLabel);
		changeAwayPlayersPanel.add(removeAwayPlayersComboBox);
		changeAwayPlayersPanel.add(numPlayerATLabel);
		changeAwayPlayersPanel.add(showHideAwayPlayersDisplayButton);
		
		return changeAwayPlayersPanel;
	}
	
	// panel for displaying home players
	private void createHomePlayersDisplayPanel()
	{
		homePlayersDisplayPanel = new JPanel();
		homePlayersDisplayPanel.setBounds(275,150,250,200);
		homePlayersDisplayPanel.setBackground(Color.white);
		homePlayersDisplayPanel.setVisible(false);
		
		homePlayersDisplayLabel = new JLabel("Home Team Players");
		homePlayersDisplayPanel.add(homePlayersDisplayLabel);
		
		homePlayersTextArea = new JTextArea(AREA_ROWS, AREA_COLUMNS);
		homePlayersTextArea.setEditable(false);
		
		homePlayersScrollPane = new JScrollPane(homePlayersTextArea);
		homePlayersDisplayPanel.add(homePlayersScrollPane);
	}
	
	// panel for displaying away players
	private void createAwayPlayersDisplayPanel()
	{
		awayPlayersDisplayPanel = new JPanel();
		awayPlayersDisplayPanel.setBounds(275,150,250,200);
		awayPlayersDisplayPanel.setBackground(Color.white);
		awayPlayersDisplayPanel.setVisible(false);
		
		awayPlayersDisplayLabel = new JLabel("Away Team Players");
		awayPlayersDisplayPanel.add(awayPlayersDisplayLabel);
		
		awayPlayersTextArea = new JTextArea(AREA_ROWS, AREA_COLUMNS);
		awayPlayersTextArea.setEditable(false);
		
		awayPlayersScrollPane = new JScrollPane(awayPlayersTextArea);
		awayPlayersDisplayPanel.add(awayPlayersScrollPane);
	}
	
	// match result panel
	private JPanel createMatchResultPanel()
	{
		matchResultPanel = new JPanel();
		matchResultPanel.setBackground(Color.green);
		matchResultPanel.setBounds(300,100,200,50);
		
		matchResultPanel.add(matchResultButton);
		matchResultButton.setVisible(true);
		
		matchResultLabel = new JLabel(matchOutcome + " won!");
		matchResultPanel.add(matchResultLabel);
		matchResultLabel.setVisible(false);
		
		return matchResultPanel;
	}
	
	// the container panel for the football scores frame
	private void createScoresContainerPanel()
	{
		scoresContainerPanel = new JPanel();
		scoresContainerPanel.setBackground(Color.green);
		scoresContainerPanel.setBounds(0,0,FRAME_WIDTH,FRAME_HEIGHT); // setbounds(x,y of top left corner,width,height)
		scoresContainerPanel.setLayout(null);
		
		scoresContainerPanel.add(scoresHeaderPanel);
		scoresContainerPanel.add(homeTeamScorePanel);
		scoresContainerPanel.add(awayTeamScorePanel);
		scoresContainerPanel.add(scoreBoardPanel);
		scoresContainerPanel.add(homeTeamNameLabelPanel);
		scoresContainerPanel.add(awayTeamNameLabelPanel);
		scoresContainerPanel.add(homeInfoPanel);
		scoresContainerPanel.add(awayInfoPanel);
		scoresContainerPanel.add(homeTeamBadgePanel);
		scoresContainerPanel.add(awayTeamBadgePanel);
		scoresContainerPanel.add(homePlayersDisplayPanel);
		scoresContainerPanel.add(awayPlayersDisplayPanel);
		scoresContainerPanel.add(matchResultPanel);
		scoresContainerPanel.add(changeHomeTeamPanel);
		scoresContainerPanel.add(changeAwayTeamPanel);
		scoresContainerPanel.add(changeHomePlayersPanel);
		scoresContainerPanel.add(changeAwayPlayersPanel);
		
		add(scoresContainerPanel);
	}
	
	// adding a home goal
	class homeAddGoalListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			homeTeamScore++;
			homeTeamScoreLabel.setText("" + homeTeamScore);
			scoreboardLabel.setText(homeTeamScore + " - " + awayTeamScore);
		}
	}
	
	private void createAddHGoalButton()
	{
		hGoalAddButton = new JButton("+");
		
		ActionListener listener = new homeAddGoalListener();
		hGoalAddButton.addActionListener(listener);
	}
	
	// subbing a home goal
	class homeSubGoalListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			if(homeTeamScore>0) // prevents the goal count going below 0
			{
				homeTeamScore--;
				homeTeamScoreLabel.setText("" + homeTeamScore);
				scoreboardLabel.setText(homeTeamScore + " - " + awayTeamScore);
			}
		}
	}
	
	private void createSubHGoalButton()
	{
		hGoalSubButton = new JButton("-");
		
		ActionListener listener = new homeSubGoalListener();
		hGoalSubButton.addActionListener(listener);
	}
	
	// reseting the home goal counter
	class resetHGListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			homeTeamScore = 0;
			homeTeamScoreLabel.setText("" + homeTeamScore);
			scoreboardLabel.setText(homeTeamScore + " - " + awayTeamScore);
		}
	}
	
	private void createResetHGoalButton()
	{
		resetHGButton = new JButton("Reset");
		
		ActionListener listener = new resetHGListener();
		resetHGButton.addActionListener(listener);
	}
	
	// adding an away goal
	class awayAddGoalListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			awayTeamScore++;
			awayTeamScoreLabel.setText("" + awayTeamScore);
			scoreboardLabel.setText(homeTeamScore + " - " + awayTeamScore);
		}
	}
	
	private void createAddAGoalButton()
	{
		aGoalAddButton = new JButton("+");
		
		ActionListener listener = new awayAddGoalListener();
		aGoalAddButton.addActionListener(listener);
	}
	
	// subbing an away goal
	class awaySubGoalListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			if(awayTeamScore>0) // prevents the goal count going below 0
			{
				awayTeamScore--;
				awayTeamScoreLabel.setText("" + awayTeamScore);
				scoreboardLabel.setText(homeTeamScore + " - " + awayTeamScore);
			}
		}
	}
	
	private void createSubAGoalButton()
	{
		aGoalSubButton = new JButton("-");
		
		ActionListener listener = new awaySubGoalListener();
		aGoalSubButton.addActionListener(listener);
	}
	
	// reseting the away goal counter
	class aResetListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			awayTeamScore = 0;
			awayTeamScoreLabel.setText("" + homeTeamScore);
			scoreboardLabel.setText(homeTeamScore + " - " + awayTeamScore);
		}
	}
	
	private void createResetAGoalButton()
	{
		aResetButton = new JButton("Reset");
		
		ActionListener listener = new aResetListener();
		aResetButton.addActionListener(listener);
	}
	
	
	// add home team combo box
	class hTComboBoxListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			if(event.getSource()==homeTeamsComboBox)
			{
				homeTeamSelected = true;
				selectedHTeamIndex = homeTeamsComboBox.getSelectedIndex();
				selectedHomeTeamName = teams[selectedHTeamIndex];
				homeTeamNameLabel.setText(selectedHomeTeamName);
			}
		}
	}
	
	private void createHomeTeamsComboBox()
	{
		homeTeamsComboBox = new JComboBox(teams);
		ActionListener listener = new hTComboBoxListener();
		homeTeamsComboBox.addActionListener(listener);
	}
	
	// add away team combo box
	class aTComboBoxListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			if(event.getSource()==awayTeamsComboBox)
			{
				awayTeamSelected = true;
				selectedATeamIndex = awayTeamsComboBox.getSelectedIndex();
				selectedHomeTeamName = teams[selectedATeamIndex];
				awayTeamNameLabel.setText(selectedHomeTeamName);
			}
		}
	}
	
	private void createAwayTeamsComboBox()
	{
		awayTeamsComboBox = new JComboBox(teams);
		ActionListener listener = new aTComboBoxListener();
		awayTeamsComboBox.addActionListener(listener);
	}
	
	// remove home team listener
	class rmHomeTeamListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			homeTeamSelected = false;
			homeTeamNameLabel.setText(teamNameLabelDefault);
		}
	}
	
	private void createRemoveHomeTeamButton()
	{
		removeHomeTeamButton = new JButton("Remove Team");
		removeHomeTeamButton.setBounds(675,25,100,50);
		
		ActionListener listener = new rmHomeTeamListener();
		removeHomeTeamButton.addActionListener(listener);
	}
	
	// remove away team listener
	class rmAwayTeamListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			awayTeamSelected = false;
			awayTeamNameLabel.setText(teamNameLabelDefault);
		}
	}
	
	private void createRemoveAwayTeamButton()
	{
		removeAwayTeamButton = new JButton("Remove Team");
		removeAwayTeamButton.setBounds(675,25,100,50);
		
		ActionListener listener = new rmAwayTeamListener();
		removeAwayTeamButton.addActionListener(listener);
	}
	
	// combo box for adding home players
	class addHomePlayersComboBoxListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			int selectedAddHomePlayersIndex = 0;
			String selectedAddHomePlayer = "";
			if(event.getSource()==addHomePlayersComboBox)
			{
				selectedAddHomePlayersIndex = addHomePlayersComboBox.getSelectedIndex();
				selectedAddHomePlayer = playersArray[selectedAddHomePlayersIndex];
				homePlayers.add(selectedAddHomePlayer); // new names are added into the arraylist
				homePlayersTextArea.setText(""); // this clears the home players text area each time a new name is added
				// the loop prints each element in the array list
				for (int i = 0; i < homePlayers.size(); i++) 
				{
					homePlayersTextArea.append((homePlayers.get(i)) + "\n");
				}
				numPlayerHT = homePlayers.size();
				numPlayerHTLabel.setText("Number of players: " + numPlayerHT);
			}
		}
	}
	
	private void createAddHomePlayersComboBox()
	{
		addHomePlayersComboBox = new JComboBox(playersArray);
		ActionListener listener = new addHomePlayersComboBoxListener();
		addHomePlayersComboBox.addActionListener(listener);
	}
	
	// combo box for removing home players
	class removeHomePlayersComboBoxListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			int selectedRemoveHomePlayersIndex = 0;
			String selectedRemoveHomePlayer = "";
			if(event.getSource()==removeHomePlayersComboBox)
			{
				selectedRemoveHomePlayersIndex = removeHomePlayersComboBox.getSelectedIndex();
				selectedRemoveHomePlayer = playersArray[selectedRemoveHomePlayersIndex];
				homePlayers.remove(selectedRemoveHomePlayer); // individual names are removed from the home team arraylist
				homePlayersTextArea.setText(""); // this clears the home players text area each time a name is removed
				// the loop prints each element in the array list
				for (int i = 0; i < homePlayers.size(); i++) 
				{
					homePlayersTextArea.append((homePlayers.get(i)) + "\n");
				}
				numPlayerHT = homePlayers.size();
				numPlayerHTLabel.setText("Number of players: " + numPlayerHT);
			}
		}
	}
	
	private void createRemoveHomePlayersComboBox()
	{
		removeHomePlayersComboBox = new JComboBox(playersArray);
		ActionListener listener = new removeHomePlayersComboBoxListener();
		removeHomePlayersComboBox.addActionListener(listener);
	}

	
	// combo box for adding away players
	class addAwayPlayersComboBoxListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			int selectedAddAwayPlayersIndex = 0;
			String selectedAddAwayPlayer = "";
			if(event.getSource()==addAwayPlayersComboBox)
			{
				selectedAddAwayPlayersIndex = addAwayPlayersComboBox.getSelectedIndex();
				selectedAddAwayPlayer = playersArray[selectedAddAwayPlayersIndex];
				awayPlayers.add(selectedAddAwayPlayer); // new names are added into the arraylist
				awayPlayersTextArea.setText(""); // this clears the away players text area each time a new name is added
				// the loop prints each name in the array list
				for (int i = 0; i < awayPlayers.size(); i++) 
				{
					awayPlayersTextArea.append((awayPlayers.get(i)) + "\n");
				}
				numPlayerAT = awayPlayers.size();
				numPlayerATLabel.setText("Number of players: " + numPlayerAT);
			}
		}
	}
	
	private void createAddAwayPlayersComboBox()
	{
		addAwayPlayersComboBox = new JComboBox(playersArray);
		ActionListener listener = new addAwayPlayersComboBoxListener();
		addAwayPlayersComboBox.addActionListener(listener);
	}
	
	
	// combo box for removing away players
	class removeAwayPlayersComboBoxListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			int selectedRemoveAwayPlayersIndex = 0;
			String selectedRemoveAwayPlayer = "";
			if(event.getSource()==removeAwayPlayersComboBox)
			{
				selectedRemoveAwayPlayersIndex = removeAwayPlayersComboBox.getSelectedIndex();
				selectedRemoveAwayPlayer = playersArray[selectedRemoveAwayPlayersIndex];
				awayPlayers.remove(selectedRemoveAwayPlayer); // individual names are removed from the away team arraylist
				awayPlayersTextArea.setText(""); // this clears the away players text area each time a name is removed
				// the loop prints each element in the array list
				for (int i = 0; i < homePlayers.size(); i++) 
				{
					awayPlayersTextArea.append((awayPlayers.get(i)) + "\n");
				}
				numPlayerAT = awayPlayers.size();
				numPlayerATLabel.setText("Number of players: " + numPlayerAT);
			}
		}
	}
	
	private void createRemoveAwayPlayersComboBox()
	{
		removeAwayPlayersComboBox = new JComboBox(playersArray);
		ActionListener listener = new removeAwayPlayersComboBoxListener();
		removeAwayPlayersComboBox.addActionListener(listener);
	}
	
	// listener and button for displaying and hiding the home players list
	class showHideHomePlayersDisplayListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			if(homePlayersDisplayVisible == false)
			{
				scoreBoardPanel.setVisible(false);
				homePlayersDisplayPanel.setVisible(true);
				showHideHomePlayersDisplayButton.setText("Hide Home Player List");
				homePlayersDisplayVisible = true;
			}
			else
			{
				scoreBoardPanel.setVisible(true);
				homePlayersDisplayPanel.setVisible(false);
				showHideHomePlayersDisplayButton.setText("Show Home Player List");
				homePlayersDisplayVisible = false;
			}
			// hides the away players panel when the home players panel is turned on
			if(awayPlayersDisplayVisible == true)
			{
				scoreBoardPanel.setVisible(false);
				awayPlayersDisplayPanel.setVisible(false);
				showHideAwayPlayersDisplayButton.setText("Show Away Player List");
				awayPlayersDisplayVisible = false;
			}
		}
	}
	
	private void createShowHideHomePlayersDisplayButton()
	{
		showHideHomePlayersDisplayButton = new JButton("Show Home Player List");
		showHideHomePlayersDisplayButton.setBounds(100,425,200,25);
		
		ActionListener listener = new showHideHomePlayersDisplayListener();
		showHideHomePlayersDisplayButton.addActionListener(listener);
	}
	
	// listener and button for displaying and hiding the away players list
	class showHideAwayPlayersDisplayListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			if(awayPlayersDisplayVisible == false)
			{
				scoreBoardPanel.setVisible(false);
				awayPlayersDisplayPanel.setVisible(true);
				showHideAwayPlayersDisplayButton.setText("Hide Away Player List");
				awayPlayersDisplayVisible = true;
			}
			else
			{
				scoreBoardPanel.setVisible(true);
				awayPlayersDisplayPanel.setVisible(false);
				showHideAwayPlayersDisplayButton.setText("Show Away Player List");
				awayPlayersDisplayVisible = false;
			}
			// hides the home players panel when the away players panel is turned on
			if(homePlayersDisplayVisible == true)
			{
				scoreBoardPanel.setVisible(false);
				homePlayersDisplayPanel.setVisible(false);
				showHideHomePlayersDisplayButton.setText("Show Home Player List");
				homePlayersDisplayVisible = false;
			}
		}
	}
	
	private void createShowHideAwayPlayersDisplayButton()
	{
		showHideAwayPlayersDisplayButton = new JButton("Show Home Player List");
		showHideAwayPlayersDisplayButton.setBounds(500,425,200,25);
		
		ActionListener listener = new showHideAwayPlayersDisplayListener();
		showHideAwayPlayersDisplayButton.addActionListener(listener);
	}
	
	// Displaying the winner button and listener - if a team isn't selected Home Team and Away Team are used as names instead
	class endMatchDisplayResultListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			if(homeTeamScore > awayTeamScore)
			{
				if(homeTeamSelected == true)
				{
					matchOutcome = teams[selectedHTeamIndex];
					matchResultLabel.setText(matchOutcome + " won the match!");
				}
				else
				{
					matchResultLabel.setText("The Home Team won the match!");
				}
			}
			else if(homeTeamScore < awayTeamScore)
			{
				if(awayTeamSelected == true)
				{
					matchOutcome = teams[selectedATeamIndex];
					matchResultLabel.setText(matchOutcome + " won the match!");
				}
				else
				{
					matchResultLabel.setText("The Away Team won the match!");
				}
			}
			else
			{
				matchOutcome = "The match ended in a draw!";
				matchResultLabel.setText(matchOutcome);
			}
			matchResultButton.setVisible(false);
			changeHomeTeamPanel.setVisible(false);
			changeAwayTeamPanel.setVisible(false);
			changeHomePlayersPanel.setVisible(false);
			changeAwayPlayersPanel.setVisible(false);
			homeTeamScorePanel.setVisible(false);
			awayTeamScorePanel.setVisible(false);
			
			matchResultLabel.setVisible(true);
		}
	}
	
	private void createMatchResultButton()
	{
		matchResultButton = new JButton("End Match and Display the Result");
		
		ActionListener listener = new endMatchDisplayResultListener();
		matchResultButton.addActionListener(listener);
	}
	
	// Exit frame action listener and button
	class exitListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			dispose(); // closes the football scores tracker frame
			// reopens the main menu frame
			JFrame appMainMenuFrame = new MainMenuFrame();
			appMainMenuFrame.setTitle("League of Ireland Football App - Main Menu");
			appMainMenuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			appMainMenuFrame.setLayout(null);
			appMainMenuFrame.setVisible(true);
		}
	}
	
	private void createExitScoresTrackerButton()
	{
		exitScoresTrackerButton = new JButton("Exit");
		exitScoresTrackerButton.setBounds(675,25,100,50);
		
		ActionListener listener = new exitListener();
		exitScoresTrackerButton.addActionListener(listener);
	}
}