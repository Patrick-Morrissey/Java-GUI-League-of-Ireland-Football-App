//Name: Patrick Morrissey
//Date: 10/04/2025
//Function: To make a frame for the League of Ireland Football app shop

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.BoxLayout;
import java.awt.Font;
import java.awt.*; // adds everything in the awt library - needed for setting colours and borders
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShopFrame extends JFrame
{
	private static final int FRAME_WIDTH = 800;
	private static final int FRAME_HEIGHT = 800;
	
	private JLabel headingLabel; // main menu heading
	private ImageIcon headerIcon;
	private JLabel headerIconLabel; // the header icon image
	
	private JPanel shopHeaderPanel; // header panel
	private JPanel shopContainerPanel; // shop container panel
	
	// shop instructions panel components
	private JPanel shopInstructionsPanel;
	private JTextArea shopInstructionsTextArea;
	
	// the show and hide basket panel button
	private JButton showHideBasketButton; 
	
	private JButton purchaseButton;
	private JButton exitShopButton;
	
	private JPanel jerseyPanel;
	private JLabel jerseyPriceLabel;
	private ImageIcon jerseyIcon;
	private JLabel jerseyIconLabel;
	private JButton jerseyAddButton;
	
	private JPanel hatPanel;
	private JLabel hatPriceLabel;
	private ImageIcon hatIcon;
	private JLabel hatIconLabel;
	private JButton hatAddButton;
	
	private JPanel ballPanel;
	private JLabel ballPriceLabel;
	private ImageIcon ballIcon;
	private JLabel ballIconLabel;
	private JButton ballAddButton;
	
	private JPanel bootsPanel;
	private JLabel bootsPriceLabel;
	private ImageIcon bootsIcon;
	private JLabel bootsIconLabel;
	private JButton bootsAddButton;
	
	// components for the basket panel
	private JPanel basketPanel;
	private JPanel jBasketPanel;
	private JPanel ballBasketPanel;
	private JPanel hBasketPanel;
	private JPanel bootsBasketPanel;
	private JPanel voucherPanel;
	private JPanel priceNoDiscountBasketPanel;
	private JPanel priceBasketPanel;
	
	// components for the jersey basket panel
	private JLabel jBasketLabel1;
	private JButton jQtySubButton;
	private JTextField jQtyField;
	private JButton jQtyApplyButton;
	private JButton jQtyAddButton;
	private JLabel jQtyResultLabel;
	private JLabel jBasketPriceLabel;
	
	// components for the hat basket panel
	private JLabel hBasketLabel1;
	private JButton hQtySubButton;
	private JTextField hQtyField;
	private JButton hQtyApplyButton;
	private JButton hQtyAddButton;
	private JLabel hQtyResultLabel;
	private JLabel hBasketPriceLabel;
	
	// components for the ball basket panel
	private JLabel ballBasketLabel1;
	private JButton ballQtySubButton;
	private JTextField ballQtyField;
	private JButton ballQtyApplyButton;
	private JButton ballQtyAddButton;
	private JLabel ballQtyResultLabel;
	private JLabel ballBasketPriceLabel;
	
	// components for the boots basket panel
	private JLabel bootsBasketLabel1;
	private JButton bootsQtySubButton;
	private JTextField bootsQtyField;
	private JButton bootsQtyApplyButton;
	private JButton bootsQtyAddButton;
	private JLabel bootsQtyResultLabel;
	private JLabel bootsBasketPriceLabel;
	
	// components for the voucher basket panel
	private JLabel discountLabel;
	private JTextField voucherField;
	private JButton applyVoucherButton;
	private JLabel voucherResultLabel;
	
	// components for the priceNoDiscount basket panel
	private JLabel priceNoDiscountResultBasketLabel;
	
	// components for the price basket panel
	private JLabel priceResultBasketLabel;
	private JLabel priceWithDiscBasketLabel;
	
	// components for the order confirmed panel
	private JPanel orderConfirmedPanel;
	private JLabel orderConfirmed;
	private JTextArea orderConfirmedTextArea;
	
	// setting textfield box widths
	final int QTY_FIELD_WIDTH = 2;
	final int FIELD_WIDTH = 8;
	
	// setting item quantity variables
	private int jerseyQty = 0;
	private int hatQty = 0;
	private int ballQty = 0;
	private int bootsQty = 0;
	
	// setting the item prices
	private double jerseyPrice = 75;
	private double hatPrice = 25;
	private double ballPrice = 20;
	private double bootsPrice = 90;
	
	private double jerseyTotalPrice = 0;
	private double hatTotalPrice = 0;
	private double ballTotalPrice = 0;
	private double bootsTotalPrice = 0;
	
	private int totalQty = 0;
	private double totalPrice = 0;
	private double discountAmount = 0.25;
	private double discountedTotalPrice = 0;
	
	private boolean voucherAccepted = false;
	private boolean basketVisible = false;
	
	public ShopFrame()
	{
		createJerseyPanel();
		createHatPanel();
		createBallPanel();
		createBootsPanel();
		//createHeaderIconLabel();
		createShowHideBasketButton();
		createPurchaseButton();
		createExitShopButton();
		createShopHeaderPanel();
		
		createShopInstructionsPanel();
		createBasketPanel();
		createOrderConfirmedPanel();
		createShopContainerPanel();
		
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
	}
	
	private JPanel createShopHeaderPanel()
	{
		shopHeaderPanel = new JPanel();
		shopHeaderPanel.setBackground(new Color(101,92,92));
		shopHeaderPanel.setBounds(0,0,800,100); // setbounds(x,y of top left corner,width,height)
		shopHeaderPanel.setLayout(null);
		
		headingLabel = new JLabel("League Football Shop");
		headingLabel.setFont(new Font(null,Font.PLAIN,25)); // for setting font style
		headingLabel.setForeground(Color.white);  // Set text color
		
		shopHeaderPanel.add(headingLabel);
		headingLabel.setBounds(300,35,250,30);
		shopHeaderPanel.add(exitShopButton);
		exitShopButton.setBounds(675,25,100,50);
		//shopHeaderPanel.add(headerIconLabel);
		
		return shopHeaderPanel;
	}
	
	private JPanel createShopInstructionsPanel()
	{
		shopInstructionsPanel = new JPanel();
		shopInstructionsPanel.setBackground(Color.green);
		shopInstructionsPanel.setBounds(75,125,650,50);
		shopInstructionsPanel.setLayout(null);
		
		shopInstructionsTextArea = new JTextArea("Welcome to the League of Ireland App Shop. Click the plus button on any item you want to buy or press Show Basket to view your basket at any time. Voucher Hint: 2025 is a good year!");
		shopInstructionsTextArea.setFont(new Font(null,Font.PLAIN,15));
		shopInstructionsTextArea.setLineWrap(true);
		shopInstructionsTextArea.setEditable(false);
		
		shopInstructionsPanel.add(shopInstructionsTextArea);
		shopInstructionsTextArea.setBackground(Color.green);
		shopInstructionsTextArea.setBounds(0,0,650,50);
		
		return shopInstructionsPanel;
	}
	
	/*
	private JLabel createHeaderIconLabel()
	{
		headerIcon = new ImageIcon("Images/LoIFootball.jpg"); // adding the header icon
		headerIconLabel = new JLabel(headerIcon);
		jerseyPanel.setBounds(25,25,75,75);
		
		return headerIconLabel;
	}
	*/
	
	private JPanel createJerseyPanel()
	{
		jerseyPanel = new JPanel();
		jerseyPanel.setBounds(50,200,100,150);
		jerseyPanel.setLayout(new BoxLayout(jerseyPanel, BoxLayout.Y_AXIS));
		
		jerseyIcon = new ImageIcon("Images/jersey.jpg"); // adding the jersey image
		jerseyIconLabel = new JLabel(jerseyIcon);
		jerseyPriceLabel = new JLabel("Jersey: EUR 75");
		
		jerseyAddButton = new JButton("+");
		ActionListener listener = new createJerseyPanelAddListener();
		jerseyAddButton.addActionListener(listener);
		
		jerseyPanel.add(jerseyIconLabel);
		jerseyPanel.add(jerseyPriceLabel);
		jerseyPanel.add(jerseyAddButton);
		
		return jerseyPanel;
	}
	
	private JPanel createHatPanel()
	{
		hatPanel = new JPanel();
		hatPanel.setBounds(200,200,100,150);
		hatPanel.setLayout(new BoxLayout(hatPanel, BoxLayout.Y_AXIS));
		
		hatIcon = new ImageIcon("Images/hat.jpg"); // adding the hat image
		hatIconLabel = new JLabel(hatIcon);
		hatPriceLabel = new JLabel("Hat: EUR 25");
		
		hatAddButton = new JButton("+");
		ActionListener listener = new hatPanelAddListener();
		hatAddButton.addActionListener(listener);
		
		hatPanel.add(hatIconLabel);
		hatPanel.add(hatPriceLabel);
		hatPanel.add(hatAddButton);
		
		return hatPanel;
	}
	
	private JPanel createBallPanel()
	{
		ballPanel = new JPanel();
		ballPanel.setBounds(50,400,100,150);
		ballPanel.setLayout(new BoxLayout(ballPanel, BoxLayout.Y_AXIS));
		
		ballIcon = new ImageIcon("Images/football.jpg"); // adding the hat image
		ballIconLabel = new JLabel(ballIcon);
		ballPriceLabel = new JLabel("Ball: EUR 20");
		
		ballAddButton = new JButton("+");
		ActionListener listener = new ballPanelAddListener();
		ballAddButton.addActionListener(listener);
		
		ballPanel.add(ballIconLabel);
		ballPanel.add(ballPriceLabel);
		ballPanel.add(ballAddButton);
		
		return ballPanel;
	}
	
	private JPanel createBootsPanel()
	{
		bootsPanel = new JPanel();
		bootsPanel.setBounds(200,400,100,150);
		bootsPanel.setLayout(new BoxLayout(bootsPanel, BoxLayout.Y_AXIS));
		
		bootsIcon = new ImageIcon("Images/boots.jpg"); // adding the hat image
		bootsIconLabel = new JLabel(bootsIcon);
		bootsPriceLabel = new JLabel("Boots: EUR 90");
		
		bootsAddButton = new JButton("+");
		ActionListener listener = new bootsPanelAddListener();
		bootsAddButton.addActionListener(listener);
		
		bootsPanel.add(bootsIconLabel);
		bootsPanel.add(bootsPriceLabel);
		bootsPanel.add(bootsAddButton);
		
		return bootsPanel;
	}
	
	// the basket panel
	private JPanel createBasketPanel()
	{
		basketPanel = new JPanel();
		basketPanel.setBackground(Color.red);
		basketPanel.setBounds(350,200,400,350);
		basketPanel.setLayout(new BoxLayout(basketPanel, BoxLayout.Y_AXIS));
		basketPanel.setVisible(false);
		
		// basket heading panel
		JPanel basketHeadingPanel = new JPanel();
		basketHeadingPanel.setBackground(Color.white);
		basketPanel.add(basketHeadingPanel);
		
		JLabel basketHeadingLabel = new JLabel("Basket");
		
		basketHeadingPanel.add(basketHeadingLabel);
		
		// jersey basket panel
		jBasketPanel = new JPanel();
		jBasketPanel.setBackground(Color.white);
		basketPanel.add(jBasketPanel);
		
		jBasketLabel1 = new JLabel("Jersey");
		
		jQtySubButton = new JButton("-");
		ActionListener jSubListener = new jerseySubListener();
		jQtySubButton.addActionListener(jSubListener);
		
		jQtyField = new JTextField(QTY_FIELD_WIDTH);
		jQtyApplyButton = new JButton("Apply");
		ActionListener jerseyInputListener = new inputJerseyQtyListener();
		jQtyApplyButton.addActionListener(jerseyInputListener);
		
		jQtyAddButton = new JButton("+");
		ActionListener jAddListener = new createJerseyPanelAddListener();
		jQtyAddButton.addActionListener(jAddListener);
		
		jQtyResultLabel = new JLabel("Qty: " + jerseyQty);
		jBasketPriceLabel = new JLabel("Price: EUR " + jerseyTotalPrice);
		
		jBasketPanel.add(jBasketLabel1);
		jBasketPanel.add(jQtySubButton);
		jBasketPanel.add(jQtyField);
		jBasketPanel.add(jQtyApplyButton);
		jBasketPanel.add(jQtyAddButton);
		jBasketPanel.add(jQtyResultLabel);
		jBasketPanel.add(jBasketPriceLabel);
		
		// hat basket panel
		hBasketPanel = new JPanel();
		hBasketPanel.setBackground(Color.white);
		basketPanel.add(hBasketPanel);
		
		hBasketLabel1 = new JLabel("Hat");
		
		hQtySubButton = new JButton("-");
		ActionListener subHatListener = new hatSubListener();
		hQtySubButton.addActionListener(subHatListener);
		
		hQtyField = new JTextField(QTY_FIELD_WIDTH);
		hQtyApplyButton = new JButton("Apply");
		ActionListener hatInputListener = new inputHatQtyListener();
		hQtyApplyButton.addActionListener(hatInputListener);
		
		hQtyAddButton = new JButton("+");
		ActionListener hAddListener = new hatPanelAddListener();
		hQtyAddButton.addActionListener(hAddListener);
		
		hQtyResultLabel = new JLabel("Qty: " + hatQty);
		hBasketPriceLabel = new JLabel("Price: EUR " + hatTotalPrice);
		
		hBasketPanel.add(hBasketLabel1);
		hBasketPanel.add(hQtySubButton);
		hBasketPanel.add(hQtyField);
		hBasketPanel.add(hQtyApplyButton);
		hBasketPanel.add(hQtyAddButton);
		hBasketPanel.add(hQtyResultLabel);
		hBasketPanel.add(hBasketPriceLabel);
		
		// ball basket panel
		ballBasketPanel = new JPanel();
		ballBasketPanel.setBackground(Color.white);
		basketPanel.add(ballBasketPanel);
		
		ballBasketLabel1 = new JLabel("Ball");
		
		ballQtySubButton = new JButton("-");
		ActionListener subBallListener = new ballSubListener();
		ballQtySubButton.addActionListener(subBallListener);
		
		ballQtyField = new JTextField(QTY_FIELD_WIDTH);
		ballQtyApplyButton = new JButton("Apply");
		ActionListener ballInputListener = new inputBallQtyListener();
		ballQtyApplyButton.addActionListener(ballInputListener);
		
		ballQtyAddButton = new JButton("+");
		ActionListener addBallListener = new ballPanelAddListener();
		ballQtyAddButton.addActionListener(addBallListener);
		
		ballQtyResultLabel = new JLabel("Qty: " + ballQty);
		ballBasketPriceLabel = new JLabel("Price: EUR " + ballTotalPrice);
		
		ballBasketPanel.add(ballBasketLabel1);
		ballBasketPanel.add(ballQtySubButton);
		ballBasketPanel.add(ballQtyField);
		ballBasketPanel.add(ballQtyApplyButton);
		ballBasketPanel.add(ballQtyAddButton);
		ballBasketPanel.add(ballQtyResultLabel);
		ballBasketPanel.add(ballBasketPriceLabel);
		
		// boots basket panel
		bootsBasketPanel = new JPanel();
		bootsBasketPanel.setBackground(Color.white);
		basketPanel.add(bootsBasketPanel);
		
		bootsBasketLabel1 = new JLabel("Boots");
		
		bootsQtySubButton = new JButton("-");
		ActionListener subBootslistener = new bootsSubListener();
		bootsQtySubButton.addActionListener(subBootslistener);
		
		bootsQtyField = new JTextField(QTY_FIELD_WIDTH);
		bootsQtyApplyButton = new JButton("Apply");
		ActionListener bootsInputListener = new inputBootsQtyListener();
		bootsQtyApplyButton.addActionListener(bootsInputListener);
		
		bootsQtyAddButton = new JButton("+");
		ActionListener addBootslistener = new bootsPanelAddListener();
		bootsQtyAddButton.addActionListener(addBootslistener);
		
		bootsQtyResultLabel = new JLabel("Qty: " + bootsQty);
		bootsBasketPriceLabel = new JLabel("Price: EUR " + bootsTotalPrice);
		
		bootsBasketPanel.add(bootsBasketLabel1);
		bootsBasketPanel.add(bootsQtySubButton);
		bootsBasketPanel.add(bootsQtyField);
		bootsBasketPanel.add(bootsQtyApplyButton);
		bootsBasketPanel.add(bootsQtyAddButton);
		bootsBasketPanel.add(bootsQtyResultLabel);
		bootsBasketPanel.add(bootsBasketPriceLabel);
		
		//basket voucher panel
		voucherPanel = new JPanel();
		voucherPanel.setBackground(Color.white);
		basketPanel.add(voucherPanel);
		
		discountLabel = new JLabel("Add Voucher Number");
		voucherPanel.add(discountLabel);
		
		voucherField = new JTextField(FIELD_WIDTH);
		voucherPanel.add(voucherField);
		
		applyVoucherButton = new JButton("Apply");
		ActionListener voucherListener = new voucherListener();
		applyVoucherButton.addActionListener(voucherListener);
		voucherPanel.add(applyVoucherButton);
		
		voucherResultLabel = new JLabel(""); // will say voucher applied if succussful
		voucherPanel.add(voucherResultLabel);
		
		// price with no discount basket panel
		priceNoDiscountBasketPanel = new JPanel();
		priceNoDiscountBasketPanel.setBackground(Color.white);
		priceNoDiscountBasketPanel.setVisible(false);
		basketPanel.add(priceNoDiscountBasketPanel);
		
		priceNoDiscountResultBasketLabel = new JLabel("Total Non-discounted Price: EUR " + totalPrice);
		priceNoDiscountBasketPanel.add(priceNoDiscountResultBasketLabel);
		
		// price basket panel
		priceBasketPanel = new JPanel();
		priceBasketPanel.setBackground(Color.white);
		basketPanel.add(priceBasketPanel);
		
		priceResultBasketLabel = new JLabel("Total Price: EUR " + totalPrice);
		priceWithDiscBasketLabel = new JLabel("With 25% Discount Applied!");
		priceWithDiscBasketLabel.setForeground(Color.RED); // Set text color
		priceWithDiscBasketLabel.setVisible(false);
		
		priceBasketPanel.add(priceResultBasketLabel);
		priceBasketPanel.add(priceWithDiscBasketLabel);
		
		return basketPanel;
	}
	
	// creating the order confirmed panel to replace the basket panel
	private JPanel createOrderConfirmedPanel()
	{
		orderConfirmedPanel = new JPanel();
		orderConfirmedPanel.setBackground(new Color(192, 194, 190)); // gray
		orderConfirmedPanel.setBounds(200,200,400,400);
		orderConfirmedPanel.setLayout(null);
		orderConfirmedPanel.setVisible(false);
		
		orderConfirmed = new JLabel("Order Confirmed");
		orderConfirmed.setBounds(100,10,200,30);
		orderConfirmed.setFont(new Font(null,Font.PLAIN,25));
		
		orderConfirmedTextArea = new JTextArea("");
		orderConfirmedTextArea.setBounds(50,50,300,300);
		orderConfirmedTextArea.setFont(new Font(null,Font.PLAIN,15));
		orderConfirmedTextArea.setLineWrap(true);
		orderConfirmedTextArea.setEditable(false);
		
		orderConfirmedPanel.add(orderConfirmed);
		orderConfirmedPanel.add(orderConfirmedTextArea);
		
		return orderConfirmedPanel;
	}
	
	// creates the container panel for all the other panels and components
	private void createShopContainerPanel()
	{
		shopContainerPanel = new JPanel();
		shopContainerPanel.setBackground(Color.green);
		shopContainerPanel.setBounds(0,0,FRAME_WIDTH,FRAME_HEIGHT); // setbounds(x,y of top left corner,width,height)
		shopContainerPanel.setLayout(null);
		
		shopContainerPanel.add(shopHeaderPanel);
		shopContainerPanel.add(shopInstructionsPanel);
		shopContainerPanel.add(jerseyPanel);
		shopContainerPanel.add(hatPanel);
		shopContainerPanel.add(ballPanel);
		shopContainerPanel.add(bootsPanel);
		shopContainerPanel.add(basketPanel);
		shopContainerPanel.add(orderConfirmedPanel);
		shopContainerPanel.add(purchaseButton);
		shopContainerPanel.add(showHideBasketButton);
		add(shopContainerPanel);
	}
	
	// listeners
	
	// the event listener for getting the total cost and quantity of jerseys added to the cart
	class createJerseyPanelAddListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			jerseyQty++;
			jerseyTotalPrice = jerseyQty * jerseyPrice;
			totalQty = jerseyQty + hatQty + ballQty + bootsQty;
			totalPrice = jerseyTotalPrice + hatTotalPrice + ballTotalPrice + bootsTotalPrice;
			jQtyResultLabel.setText("Qty: " + jerseyQty);
			jBasketPriceLabel.setText("Price: EUR " + jerseyTotalPrice);
			priceNoDiscountResultBasketLabel.setText("Total Non-discounted Price: EUR " + totalPrice);
			if(totalQty == 0)
			{
				basketPanel.setVisible(false);
				showHideBasketButton.setText("Show Basket");
				purchaseButton.setVisible(false);
				basketVisible = false;
			}
			else
			{
				basketPanel.setVisible(true);
				showHideBasketButton.setText("Hide Basket");
				purchaseButton.setVisible(true);
				basketVisible = true;
			}
			if(voucherAccepted == false)
			{
				priceResultBasketLabel.setText("Total Price: EUR " + totalPrice);
			}
			else
			{
				discountedTotalPrice = totalPrice-(totalPrice * discountAmount);
				priceResultBasketLabel.setText("Total Price: EUR " + discountedTotalPrice);
			}
		}
	}
	
	// the event listener for getting the total cost and quantity of hats added to the cart
	class hatPanelAddListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			hatQty++;
			hatTotalPrice = hatQty * hatPrice;
			totalQty = jerseyQty + hatQty + ballQty + bootsQty;
			totalPrice = jerseyTotalPrice + hatTotalPrice + ballTotalPrice + bootsTotalPrice;
			hQtyResultLabel.setText("Qty: " + hatQty);
			hBasketPriceLabel.setText("Price: EUR " + hatTotalPrice);
			priceNoDiscountResultBasketLabel.setText("Total Non-discounted Price: EUR " + totalPrice);
			if(totalQty == 0)
			{
				basketPanel.setVisible(false);
				showHideBasketButton.setText("Show Basket");
				purchaseButton.setVisible(false);
				basketVisible = false;
			}
			else
			{
				basketPanel.setVisible(true);
				showHideBasketButton.setText("Hide Basket");
				purchaseButton.setVisible(true);
				basketVisible = true;
			}
			if(voucherAccepted == false)
			{
				priceResultBasketLabel.setText("Total Price: EUR " + totalPrice);
			}
			else
			{
				discountedTotalPrice = totalPrice-(totalPrice*discountAmount);
				priceResultBasketLabel.setText("Total Price: EUR " + discountedTotalPrice);
			}
		}
	}
	
	// the event listener for getting the total cost and quantity of footballs added to the cart
	class ballPanelAddListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			ballQty++;
			ballTotalPrice = ballQty * ballPrice;
			totalQty = jerseyQty + hatQty + ballQty + bootsQty;
			totalPrice = jerseyTotalPrice + hatTotalPrice + ballTotalPrice + bootsTotalPrice;
			ballQtyResultLabel.setText("Qty: " + ballQty);
			ballBasketPriceLabel.setText("Price: EUR " + ballTotalPrice);
			priceNoDiscountResultBasketLabel.setText("Total Non-discounted Price: EUR " + totalPrice);
			if(totalQty == 0)
			{
				basketPanel.setVisible(false);
				showHideBasketButton.setText("Show Basket");
				purchaseButton.setVisible(false);
				basketVisible = false;
			}
			else
			{
				basketPanel.setVisible(true);
				showHideBasketButton.setText("Hide Basket");
				purchaseButton.setVisible(true);
				basketVisible = true;
			}
			if(voucherAccepted == false)
			{
				priceResultBasketLabel.setText("Total Price: EUR " + totalPrice);
			}
			else
			{
				discountedTotalPrice = totalPrice-(totalPrice*discountAmount);
				priceResultBasketLabel.setText("Total Price: EUR " + discountedTotalPrice);
			}
		}
	}
	
	// the event listener for getting the total cost and quantity of boots added to the cart
	class bootsPanelAddListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			bootsQty++;
			bootsTotalPrice = bootsQty * bootsPrice;
			totalQty = jerseyQty + hatQty + ballQty + bootsQty;
			totalPrice = jerseyTotalPrice + hatTotalPrice + ballTotalPrice + bootsTotalPrice;
			bootsQtyResultLabel.setText("Qty: " + bootsQty);
			bootsBasketPriceLabel.setText("Price: EUR " + bootsTotalPrice);
			priceNoDiscountResultBasketLabel.setText("Total Non-discounted Price: EUR " + totalPrice);
			if(totalQty == 0)
			{
				basketPanel.setVisible(false);
				showHideBasketButton.setText("Show Basket");
				purchaseButton.setVisible(false);
				basketVisible = false;
			}
			else
			{
				basketPanel.setVisible(true);
				showHideBasketButton.setText("Hide Basket");
				purchaseButton.setVisible(true);
				basketVisible = true;
			}
			if(voucherAccepted == false)
			{
				priceResultBasketLabel.setText("Total Price: EUR " + totalPrice);
			}
			else
			{
				discountedTotalPrice = totalPrice-(totalPrice*discountAmount);
				priceResultBasketLabel.setText("Total Price: EUR " + discountedTotalPrice);
			}
		}
	}
	
	// substracting items
	class jerseySubListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			if(jerseyQty>0)
			{
				jerseyQty--;
				jerseyTotalPrice = jerseyQty * jerseyPrice;
				totalQty = jerseyQty + hatQty + ballQty + bootsQty;
				totalPrice = jerseyTotalPrice + hatTotalPrice + ballTotalPrice + bootsTotalPrice;
				jQtyResultLabel.setText("Qty: " + jerseyQty);
				jBasketPriceLabel.setText("Price: EUR " + jerseyTotalPrice);
				priceNoDiscountResultBasketLabel.setText("Total Non-discounted Price: EUR " + totalPrice);
				if(totalQty == 0)
				{
					basketPanel.setVisible(false);
					showHideBasketButton.setText("Show Basket");
					purchaseButton.setVisible(false);
					basketVisible = false;
				}
				else
				{
					basketPanel.setVisible(true);
					showHideBasketButton.setText("Hide Basket");
					purchaseButton.setVisible(true);
					basketVisible = true;
				}
				if(voucherAccepted == false)
				{
					priceResultBasketLabel.setText("Total Price: EUR " + totalPrice);
				}
				else
				{
					discountedTotalPrice = totalPrice-(totalPrice*discountAmount);
					priceResultBasketLabel.setText("Total Price: EUR " + discountedTotalPrice);
				}
			}
		}
	}
	
	class hatSubListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			if(hatQty>0)
			{
				hatQty--;
				hatTotalPrice = hatQty * hatPrice;
				totalQty = jerseyQty + hatQty + ballQty + bootsQty;
				totalPrice = jerseyTotalPrice + hatTotalPrice + ballTotalPrice + bootsTotalPrice;
				hQtyResultLabel.setText("Qty: " + hatQty);
				hBasketPriceLabel.setText("Price: EUR " + hatTotalPrice);
				priceNoDiscountResultBasketLabel.setText("Total Non-discounted Price: EUR " + totalPrice);
				if(totalQty == 0)
				{
					basketPanel.setVisible(false);
					showHideBasketButton.setText("Show Basket");
					purchaseButton.setVisible(false);
					basketVisible = false;
				}
				else
				{
					basketPanel.setVisible(true);
					showHideBasketButton.setText("Hide Basket");
					purchaseButton.setVisible(true);
					basketVisible = true;
				}
				if(voucherAccepted == false)
				{
					priceResultBasketLabel.setText("Total Price: EUR " + totalPrice);
				}
				else
				{
					discountedTotalPrice = totalPrice-(totalPrice*discountAmount);
					priceResultBasketLabel.setText("Total Price: EUR " + discountedTotalPrice);
				}
			}
		}
	}
	
	class ballSubListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			if(ballQty>0)
			{
				ballQty--;
				ballTotalPrice = ballQty * ballPrice;
				totalQty = jerseyQty + hatQty + ballQty + bootsQty;
				totalPrice = jerseyTotalPrice + hatTotalPrice + ballTotalPrice + bootsTotalPrice;
				ballQtyResultLabel.setText("Qty: " + ballQty);
				ballBasketPriceLabel.setText("Price: EUR " + ballTotalPrice);
				priceNoDiscountResultBasketLabel.setText("Total Non-discounted Price: EUR " + totalPrice);
				if(totalQty == 0)
				{
					basketPanel.setVisible(false);
					showHideBasketButton.setText("Show Basket");
					purchaseButton.setVisible(false);
					basketVisible = false;
				}
				else
				{
					basketPanel.setVisible(true);
					showHideBasketButton.setText("Hide Basket");
					purchaseButton.setVisible(true);
					basketVisible = true;
				}
				if(voucherAccepted == false)
				{
					priceResultBasketLabel.setText("Total Price: EUR " + totalPrice);
				}
				else
				{
					discountedTotalPrice = totalPrice-(totalPrice*discountAmount);
					priceResultBasketLabel.setText("Total Price: EUR " + discountedTotalPrice);
				}
			}
		}
	}
	
	class bootsSubListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			if(bootsQty>0)
			{
				bootsQty--;
				bootsTotalPrice = bootsQty * bootsPrice;
				totalQty = jerseyQty + hatQty + ballQty + bootsQty;
				totalPrice = jerseyTotalPrice + hatTotalPrice + ballTotalPrice + bootsTotalPrice;
				bootsQtyResultLabel.setText("Qty: " + bootsQty);
				bootsBasketPriceLabel.setText("Price: EUR " + bootsTotalPrice);
				priceNoDiscountResultBasketLabel.setText("Total Non-discounted Price: EUR " + totalPrice);
				if(totalQty == 0)
				{
					basketPanel.setVisible(false);
					showHideBasketButton.setText("Show Basket");
					purchaseButton.setVisible(false);
					basketVisible = false;
				}
				else
				{
					basketPanel.setVisible(true);
					showHideBasketButton.setText("Hide Basket");
					purchaseButton.setVisible(true);
					basketVisible = true;
				}
				if(voucherAccepted == false)
				{
					priceResultBasketLabel.setText("Total Price: EUR " + totalPrice);
				}
				else
				{
					discountedTotalPrice = totalPrice-(totalPrice*discountAmount);
					priceResultBasketLabel.setText("Total Price: EUR " + discountedTotalPrice);
				}
			}
		}
	}
	
	// the listeners for taking user input for item quantity - doesn't allow inputs of less than 0 to alter the item quantities
	class inputJerseyQtyListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			int inputJerseyQty = Integer.parseInt(jQtyField.getText());
			if(inputJerseyQty>=0)
			{
				jerseyQty = inputJerseyQty;
				jerseyTotalPrice = jerseyQty * jerseyPrice;
				totalQty = jerseyQty + hatQty + ballQty + bootsQty;
				totalPrice = jerseyTotalPrice + hatTotalPrice + ballTotalPrice + bootsTotalPrice;
				jQtyResultLabel.setText("Qty: " + jerseyQty);
				jBasketPriceLabel.setText("Price: EUR " + jerseyTotalPrice);
				priceNoDiscountResultBasketLabel.setText("Total Non-discounted Price: EUR " + totalPrice);
				if(totalQty == 0)
				{
					basketPanel.setVisible(false);
					showHideBasketButton.setText("Show Basket");
					purchaseButton.setVisible(false);
					basketVisible = false;
				}
				else
				{
					basketPanel.setVisible(true);
					showHideBasketButton.setText("Hide Basket");
					purchaseButton.setVisible(true);
					basketVisible = true;
				}
				if(voucherAccepted == false)
				{
					priceResultBasketLabel.setText("Total Price: EUR " + totalPrice);
				}
				else
				{
					discountedTotalPrice = totalPrice-(totalPrice*discountAmount);
					priceResultBasketLabel.setText("Total Price: EUR " + discountedTotalPrice);
				}
			}
		}
	}
	
	class inputHatQtyListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			int inputHatQty = Integer.parseInt(hQtyField.getText());
			if(inputHatQty>=0)
			{
				hatQty = inputHatQty;
				hatTotalPrice = hatQty * hatPrice;
				totalQty = jerseyQty + hatQty + ballQty + bootsQty;
				totalPrice = jerseyTotalPrice + hatTotalPrice + ballTotalPrice + bootsTotalPrice;
				hQtyResultLabel.setText("Qty: " + hatQty);
				hBasketPriceLabel.setText("Price: EUR " + hatTotalPrice);
				priceNoDiscountResultBasketLabel.setText("Total Non-discounted Price: EUR " + totalPrice);
				if(totalQty == 0)
				{
					basketPanel.setVisible(false);
					showHideBasketButton.setText("Show Basket");
					purchaseButton.setVisible(false);
					basketVisible = false;
				}
				else
				{
					basketPanel.setVisible(true);
					showHideBasketButton.setText("Hide Basket");
					purchaseButton.setVisible(true);
					basketVisible = true;
				}
				if(voucherAccepted == false)
				{
					priceResultBasketLabel.setText("Total Price: EUR " + totalPrice);
				}
				else
				{
					discountedTotalPrice = totalPrice-(totalPrice*discountAmount);
					priceResultBasketLabel.setText("Total Price: EUR " + discountedTotalPrice);
				}
			}
		}
	}
	
	class inputBallQtyListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			int inputBallQty = Integer.parseInt(ballQtyField.getText());
			if(inputBallQty>=0)
			{
				ballQty = inputBallQty;
				ballTotalPrice = ballQty * ballPrice;
				totalQty = jerseyQty + hatQty + ballQty + bootsQty;
				totalPrice = jerseyTotalPrice + hatTotalPrice + ballTotalPrice + bootsTotalPrice;
				ballQtyResultLabel.setText("Qty: " + ballQty);
				ballBasketPriceLabel.setText("Price: EUR " + ballTotalPrice);
				priceNoDiscountResultBasketLabel.setText("Total Non-discounted Price: EUR " + totalPrice);
				if(totalQty == 0)
				{
					basketPanel.setVisible(false);
					showHideBasketButton.setText("Show Basket");
					purchaseButton.setVisible(false);
					basketVisible = false;
				}
				else
				{
					basketPanel.setVisible(true);
					showHideBasketButton.setText("Hide Basket");
					purchaseButton.setVisible(true);
					basketVisible = true;
				}
				if(voucherAccepted == false)
				{
					priceResultBasketLabel.setText("Total Price: EUR " + totalPrice);
				}
				else
				{
					discountedTotalPrice = totalPrice-(totalPrice*discountAmount);
					priceResultBasketLabel.setText("Total Price: EUR " + discountedTotalPrice);
				}
			}
		}
	}
	
	class inputBootsQtyListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			int inputBootsQty = Integer.parseInt(bootsQtyField.getText());
			if(inputBootsQty>=0)
			{
				bootsQty = inputBootsQty;
				bootsTotalPrice = bootsQty * bootsPrice;
				totalQty = jerseyQty + hatQty + ballQty + bootsQty;
				totalPrice = jerseyTotalPrice + hatTotalPrice + ballTotalPrice + bootsTotalPrice;
				bootsQtyResultLabel.setText("Qty: " + bootsQty);
				bootsBasketPriceLabel.setText("Price: EUR " + bootsTotalPrice);
				priceNoDiscountResultBasketLabel.setText("Total Non-discounted Price: EUR " + totalPrice);
				if(totalQty == 0)
				{
					basketPanel.setVisible(false);
					showHideBasketButton.setText("Show Basket");
					purchaseButton.setVisible(false);
					basketVisible = false;
				}
				else
				{
					basketPanel.setVisible(true);
					showHideBasketButton.setText("Hide Basket");
					purchaseButton.setVisible(true);
					basketVisible = true;
				}
				if(voucherAccepted == false)
				{
					priceResultBasketLabel.setText("Total Price: EUR " + totalPrice);
				}
				else
				{
					discountedTotalPrice = totalPrice-(totalPrice*discountAmount);
					priceResultBasketLabel.setText("Total Price: EUR " + discountedTotalPrice);
				}
			}
		}
	}
	
	// the listener for applying the voucher discount
	class voucherListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			String voucherNum = "2025";
			if (voucherField.getText().equals(voucherNum))
			{
				voucherAccepted = true;
				priceNoDiscountBasketPanel.setVisible(true);
				priceWithDiscBasketLabel.setVisible(true);
				voucherResultLabel.setText("Voucher Applied!");
				discountedTotalPrice = totalPrice-(totalPrice*discountAmount);
				priceResultBasketLabel.setText("Total Price: EUR " + discountedTotalPrice);
			}
			else
			{
				voucherAccepted = false;
				priceNoDiscountBasketPanel.setVisible(false);
				priceWithDiscBasketLabel.setVisible(false);
				voucherResultLabel.setText("Invalid Voucher");
				priceResultBasketLabel.setText("Total Price: EUR " + totalPrice);
			}
		}
	}
	
	// the listener for the show hide basket button
	class showHideBasketButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			if(basketVisible == false)
			{
				basketPanel.setVisible(true);
				showHideBasketButton.setText("Hide Basket");
				purchaseButton.setVisible(true);
				basketVisible = true;
			}
			else
			{
				basketPanel.setVisible(false);
				showHideBasketButton.setText("Show Basket");
				purchaseButton.setVisible(false);
				basketVisible = false;
			}
		}
	}
	
	// the show hide basket button
	private void createShowHideBasketButton()
	{
		showHideBasketButton = new JButton("Show Basket");
		showHideBasketButton.setBounds(75,600,200,50);
		
		ActionListener listener = new showHideBasketButtonListener();
		showHideBasketButton.addActionListener(listener);
	}
	
	// this button will only appear if the basket is not empty
	private void createPurchaseButton()
	{
		purchaseButton = new JButton("Buy Now");
		purchaseButton.setVisible(false);
		purchaseButton.setBounds(450,600,200,100);
		
		ActionListener listener = new showOrderConfirmedPanelListener();
		purchaseButton.addActionListener(listener);
	}
	
	class showOrderConfirmedPanelListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			orderConfirmedPanel.setVisible(true);
			if(voucherAccepted == false)
			{
				orderConfirmedTextArea.setText("Thank you for your purchase! The total price was EUR " + totalPrice + ". Your items will be dispatched soon.");
			}
			else
			{
				orderConfirmedTextArea.setText("Thank you for your purchase! The total price was EUR " + discountedTotalPrice + ". Your items will be dispatched soon.");
			}
			basketPanel.setVisible(false);
			jerseyPanel.setVisible(false);
			hatPanel.setVisible(false);
			ballPanel.setVisible(false);
			bootsPanel.setVisible(false);
			showHideBasketButton.setVisible(false);
			purchaseButton.setVisible(false);
		}
	}
	
	// Exit frame action listener
	class exitShopListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			dispose(); // closes the shop frame
			JFrame appMainMenuFrame = new MainMenuFrame(); // reopens the main menu frame
			appMainMenuFrame.setTitle("League of Ireland Football App - Main Menu");
			appMainMenuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			appMainMenuFrame.setLayout(null);
			appMainMenuFrame.setVisible(true);
		}
	}
	
	// Exit frame button
	private void createExitShopButton()
	{
		exitShopButton = new JButton("Exit");
		exitShopButton.setBounds(675,25,100,50);
		
		ActionListener listener = new exitShopListener();
		exitShopButton.addActionListener(listener);
	}
}