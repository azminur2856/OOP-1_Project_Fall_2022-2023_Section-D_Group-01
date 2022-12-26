package classes;
import java.lang.*;
import interfaces.*;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.border.EmptyBorder;

public class Fish implements ActionListener,IFish
{
	private JFrame frame;
	
	private JCheckBox hilsa;
	private JCheckBox golda_prawn;
	private JCheckBox tilapia;
	private JCheckBox wallago;
	
	private JLabel quantity1;
	private JLabel quantity2;
	private JLabel quantity3;
	private JLabel quantity4;
	
	private JLabel hilsaLabel;
	private JLabel golda_prawnLabel;
	private JLabel tilapiaLabel;
	private JLabel wallagoLabel;
	
	private JLabel hPrice;
	private JLabel gPrice;
	private JLabel tPrice;
	private JLabel wPrice;
	
	private JComboBox<String> hNumber;
	private JComboBox<String> gNumber;
	private JComboBox<String> tNumber;
	private JComboBox<String> wNumber;
	
	private JButton goBack;
	private JButton placeOrder;
	
	private JMenuBar menuBar;  
	private JMenu users, setting;
	private JMenuItem profile, logout, changeBGColor;

	private String a [] = {"1","2","3","4","5","6","7","8","9","10"};
	private String b [] = {"1","2","3","4","5","6","7","8","9","10"};
	private String c [] = {"1","2","3","4","5","6","7","8","9","10"};
	private String d [] = {"1","2","3","4","5","6","7","8","9","10"};
	
	private String f;
	
	public Fish(String user)
	{
		f=user;
		
		frame = new JFrame("Fish");
		ImageIcon framelogo = new ImageIcon("icons/framelogo.jpg");
		
		
		Image image1 = new ImageIcon("icons/hilsa.png").getImage().getScaledInstance(340, 115, Image.SCALE_DEFAULT);
		ImageIcon hilsaIcon = new ImageIcon(image1);
		hilsa = new JCheckBox("Hilsa");
		hilsa.setBounds(40, 170, 150, 20);
		hilsa.setFocusable(false);
		hilsa.setForeground(Color.white);
		hilsa.setBackground(Color.black);
		hilsa.addActionListener(this);
		frame.add(hilsa);
		
		hPrice = new JLabel("Price: 1999 tk/Kg");
		hPrice.setBounds(220, 170, 150, 20);
		hPrice.setBackground(Color.black);
		hPrice.setForeground(Color.white);
		frame.add(hPrice);
		
		hilsaLabel = new JLabel(hilsaIcon);
		hilsaLabel.setBounds(20, 20, 340, 140);
		frame.add(hilsaLabel);
		
		
		hNumber = new JComboBox<String>(a);
		hNumber.setBounds(40, 200, 50, 17);
		frame.add(hNumber);
	
		quantity1 = new JLabel(">>>Kg");
		quantity1.setBounds(95, 200, 80, 17);
		quantity1.setBackground(Color.black);
		quantity1.setForeground(Color.white);
		frame.add(quantity1);
		
		
		Image image2 = new ImageIcon("icons/golda_prawn.png").getImage().getScaledInstance(340, 140, Image.SCALE_DEFAULT);
		ImageIcon golda_prawnIcon = new ImageIcon(image2);
		golda_prawn= new JCheckBox("Golda Prawn");
		golda_prawn.setBounds(480, 170, 150, 20);
		golda_prawn.setFocusable(false);
		golda_prawn.setForeground(Color.white);
		golda_prawn.setBackground(Color.black);
		frame.add(golda_prawn);
		
		gPrice = new JLabel("Price: 745 tk/Kg");
		gPrice.setBounds(650, 170, 150, 20);
		gPrice.setBackground(Color.black);
		gPrice.setForeground(Color.white);
		frame.add(gPrice);
		
		golda_prawnLabel = new JLabel(golda_prawnIcon);
		golda_prawnLabel.setBounds(450, 0, 340, 200);
		frame.add(golda_prawnLabel);
		
		gNumber = new JComboBox<String>(b);
		gNumber.setBounds(480, 200, 50, 17);
		frame.add(gNumber);
		
		quantity2 = new JLabel(">>>Kg");
		quantity2.setBounds(535, 200, 80, 17);
		quantity2.setBackground(Color.black);
		quantity2.setForeground(Color.white);
		frame.add(quantity2);
		
		
		Image image3 = new ImageIcon("icons/tilapia.png").getImage().getScaledInstance(340, 140, Image.SCALE_DEFAULT);
		ImageIcon tilapiaIcon = new ImageIcon(image3);
		tilapia = new JCheckBox("Tilapia");
		tilapia.setBounds(480, 430, 150, 20);
		tilapia.setFocusable(false);
		tilapia.setForeground(Color.white);
		tilapia.setBackground(Color.black);
		frame.add(tilapia);
		
		tPrice = new JLabel("Price: 189 tk/Kg");
		tPrice.setBounds(650, 430, 150, 20);
		tPrice.setBackground(Color.black);
		tPrice.setForeground(Color.white);
		frame.add(tPrice);
		
		tilapiaLabel = new JLabel(tilapiaIcon);
		tilapiaLabel.setBounds(450, 250, 340, 200);
		frame.add(tilapiaLabel);
		
		tNumber = new JComboBox<String>(c);
		tNumber.setBounds(480, 470, 50, 17);
		frame.add(tNumber);
		
		quantity3 = new JLabel(">>>Kg");
		quantity3.setBounds(535, 470, 80, 17);
		quantity3.setBackground(Color.black);
		quantity3.setForeground(Color.white);
		frame.add(quantity3);
		
		
		Image image4 = new ImageIcon("icons/wallago.png").getImage().getScaledInstance(340, 200, Image.SCALE_DEFAULT);
		ImageIcon wallagoIcon = new ImageIcon(image4);
		wallago  = new JCheckBox("Wallago");
		wallago.setBounds(40, 430, 180, 20);
		wallago.setFocusable(false);
		wallago.setForeground(Color.white);
		wallago.setBackground(Color.black);
		frame.add(wallago);
		
	
		wPrice = new JLabel("Price: 310 tk/Kg");
		wPrice.setBounds(230, 430, 180, 20);
		wPrice.setBackground(Color.black);
		wPrice.setForeground(Color.white);
		frame.add(wPrice);
		
		
		wallagoLabel = new JLabel(wallagoIcon);
		wallagoLabel.setBounds(20, 250, 340, 180);
		frame.add(wallagoLabel);
		
		wNumber = new JComboBox<String>(d);
		wNumber.setBounds(40, 470, 50, 17);
		frame.add(wNumber);
		
		quantity4 = new JLabel(">>>Kg");
		quantity4.setBounds(95, 470, 80, 17);
		quantity4.setBackground(Color.black);
		quantity4.setForeground(Color.white);
		frame.add(quantity4);
		

		profile = new JMenuItem ("Profile");
		profile.addActionListener(this);
		profile.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		logout = new JMenuItem ("Logout");
		logout.addActionListener(this);
		logout.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		changeBGColor = new JMenuItem("Change Background Color");
		changeBGColor.addActionListener(this);
		changeBGColor.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		ImageIcon profileImage = new ImageIcon("icons/admin.png");
		users = new JMenu(user);
		users.setCursor(new Cursor(Cursor.HAND_CURSOR));
		users.setBorder(new EmptyBorder(0, 10, 0, 10));
		users.setForeground(Color.white);
		users.setIcon(profileImage);
		users.add(profile);
		users.add(logout);
		
		
		setting = new JMenu ("Settings");
		setting.setCursor(new Cursor(Cursor.HAND_CURSOR));
		setting.setBorder(new EmptyBorder(0, 10, 0, 10));
		setting.setForeground(Color.white);
		setting.add(changeBGColor);
		
		
		goBack= new JButton("Previous Page");
		goBack.setFocusable(false);
		goBack.setBackground(Color.black);
		goBack.setForeground(Color.white);
		goBack.setCursor(new Cursor(Cursor.HAND_CURSOR));
		goBack.setBorder(BorderFactory.createDashedBorder(Color.red));
		goBack.addActionListener(this);
		
		
		menuBar = new JMenuBar();
		menuBar.add(users);
		menuBar.add(setting);
		menuBar.add(goBack);
		menuBar.setBackground(Color.black);
		menuBar.setBorder(BorderFactory.createEmptyBorder());
		frame.setJMenuBar(menuBar);
		
		
		placeOrder= new JButton("Place Order");
		placeOrder.setBounds(770, 0, 100, 30);
		placeOrder.setFocusable(false);
		placeOrder.setBackground(Color.black);
		placeOrder.setForeground(Color.white);
		placeOrder.setBorder(BorderFactory.createDashedBorder(Color.red, 1.9F, 5, 1, true));
		placeOrder.setCursor(new Cursor(Cursor.HAND_CURSOR));
		placeOrder.addActionListener(this);
		frame.add(placeOrder);
		
		
		frame.setIconImage(framelogo.getImage());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(900,600);
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setLayout (null);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
	}
	
	public static void main(String[] args)
	{
		new Rice("Azminur");
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==logout)
		{
			new Login();
			frame.setVisible(false);
			
		}
		else if(e.getSource()==changeBGColor)
		{
			JColorChooser colorChooser = new JColorChooser();

			Color color = JColorChooser.showDialog(null, "Pick Your Background Color", Color.black);
				
			frame.getContentPane().setBackground(color);
				
			menuBar.setBackground(color);
				
			goBack.setBackground(color);
				
			hilsa.setBackground(color);
			golda_prawn.setBackground(color);
			tilapia.setBackground(color);
			wallago.setBackground(color);
				
			quantity1.setBackground(color);
			quantity2.setBackground(color);
			quantity3.setBackground(color);
			quantity4.setBackground(color);
				
			placeOrder.setBackground(color);		
		}
		
		else if(e.getSource()==profile)
		{
			//frame.setVisible(false);
			new UProfile(f);
		}
		
		else if (e.getSource()==goBack)
		{
			new AllItem(f);
			frame.setVisible(false);
			
		}
		else if(e.getSource()==placeOrder)
		{
			double totalAmount=0;
			double hilsaAmount = 0;
			double golda_prawnAmount = 0;
			double tilapiaAmount = 0;
			double wallagoAmount = 0;
			int a = 0;
			int b = 0;
			int c = 0;
			int d = 0;
			
			
			if (hilsa.isSelected()==true)
			{
				a = (hNumber.getSelectedIndex())+1;
				hilsaAmount= a*1999;
			}
			if (golda_prawn.isSelected()==true)
			{
				b = gNumber.getSelectedIndex()+1;
				golda_prawnAmount= b*745;
			}
			if (tilapia.isSelected()==true)
			{
				c = tNumber.getSelectedIndex()+1;
				tilapiaAmount= c*189;
			}
			if (wallago.isSelected()==true)
			{
				d = wNumber.getSelectedIndex()+1;
				wallagoAmount= d*310;
			}
			
			totalAmount = hilsaAmount+golda_prawnAmount+tilapiaAmount+wallagoAmount;
			
			if (totalAmount!=0)
			{
				int x = JOptionPane.showConfirmDialog(null, "Your Bill = "+totalAmount+" tk. Confirm Order?"," Conformation of Order", 0);
				if (x==0) 
				{
					new Payment(totalAmount, "Fish", f);
					frame.setVisible(false);
					
					
					try 
					{
						File newfile = new File("data\\Latest_Order.txt"); 
						newfile.createNewFile();
						FileWriter file = new FileWriter("data\\Latest_Order.txt");
						
						file.write("Hilsa--- "+a+" Kg---"+hilsaAmount+" tk."
						+"\nGolda Prawn---"+b+" Kg---"+tilapiaAmount+" tk."
						+"\nTilapia---"+c+" Kg---"+tilapiaAmount+" tk."
						+"\nWallago---"+d+" Kg---"+wallagoAmount +" tk."
						+"\nTotal= "+totalAmount+" tk.");
						file.close();
			
					}
				catch(IOException io)
					{
					JOptionPane.showMessageDialog(null, "An error Occured and failed to create the file");
					io.printStackTrace();
					}
					
				}
			}
			else 
			{
				JOptionPane.showMessageDialog(null, "Please select something before placing order!", "Message", 0);
			}
		}
		
	}

}
