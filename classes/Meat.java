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

public class Meat implements ActionListener,IMeat
{
	private JFrame frame;
	
	private JCheckBox beef;
	private JCheckBox mutton;
	private JCheckBox country_chicken;
	private JCheckBox foreign_chicken;
	
	private JLabel quantity1;
	private JLabel quantity2;
	private JLabel quantity3;
	private JLabel quantity4;
	
	private JLabel beefLabel;
	private JLabel muttonLabel;
	private JLabel country_chickenLabel;
	private JLabel foreign_chickenLabel;
	
	private JLabel bPrice;
	private JLabel mPrice;
	private JLabel cPrice;
	private JLabel fcPrice;
	
	private JComboBox<String> bNumber;
	private JComboBox<String> mNumber;
	private JComboBox<String> cNumber;
	private JComboBox<String> fcNumber;
	
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
	
	public Meat(String user)
	{
		f=user;
		
		frame = new JFrame("Meat");
		ImageIcon framelogo = new ImageIcon("icons/framelogo.jpg");
		
		
		Image image1 = new ImageIcon("icons/beef.png").getImage().getScaledInstance(340, 150, Image.SCALE_DEFAULT);
		ImageIcon beefIcon = new ImageIcon(image1);
		beef = new JCheckBox("Beef");
		beef.setBounds(40, 170, 150, 20);
		beef.setFocusable(false);
		beef.setForeground(Color.white);
		beef.setBackground(Color.black);
		beef.addActionListener(this);
		frame.add(beef);
		
		bPrice = new JLabel("Price: 799 tk/Kg");
		bPrice.setBounds(220, 170, 150, 20);
		bPrice.setBackground(Color.black);
		bPrice.setForeground(Color.white);
		frame.add(bPrice);
		
		beefLabel = new JLabel(beefIcon);
		beefLabel.setBounds(20, 20, 340, 140);
		frame.add(beefLabel);
		
		
		bNumber = new JComboBox<String>(a);
		bNumber.setBounds(40, 200, 50, 17);
		frame.add(bNumber);
	
		quantity1 = new JLabel(">>>Kg");
		quantity1.setBounds(95, 200, 80, 17);
		quantity1.setBackground(Color.black);
		quantity1.setForeground(Color.white);
		frame.add(quantity1);
		
		
		Image image2 = new ImageIcon("icons/mutton.png").getImage().getScaledInstance(340, 140, Image.SCALE_DEFAULT);
		ImageIcon muttonIcon = new ImageIcon(image2);
		mutton= new JCheckBox("Mutton");
		mutton.setBounds(480, 170, 150, 20);
		mutton.setFocusable(false);
		mutton.setForeground(Color.white);
		mutton.setBackground(Color.black);
		frame.add(mutton);
		
		mPrice = new JLabel("Price: 920 tk/Kg");
		mPrice.setBounds(650, 170, 150, 20);
		mPrice.setBackground(Color.black);
		mPrice.setForeground(Color.white);
		frame.add(mPrice);
		
		muttonLabel = new JLabel(muttonIcon);
		muttonLabel.setBounds(450, 0, 340, 200);
		frame.add(muttonLabel);
		
		mNumber = new JComboBox<String>(b);
		mNumber.setBounds(480, 200, 50, 17);
		frame.add(mNumber);
		
		quantity2 = new JLabel(">>>Kg");
		quantity2.setBounds(535, 200, 80, 17);
		quantity2.setBackground(Color.black);
		quantity2.setForeground(Color.white);
		frame.add(quantity2);
		
		
		Image image3 = new ImageIcon("icons/country_chicken.png").getImage().getScaledInstance(340, 200, Image.SCALE_DEFAULT);
		ImageIcon country_chickenIcon = new ImageIcon(image3);
		country_chicken = new JCheckBox("Country Chicken");
		country_chicken.setBounds(480, 430, 150, 20);
		country_chicken.setFocusable(false);
		country_chicken.setForeground(Color.white);
		country_chicken.setBackground(Color.black);
		frame.add(country_chicken);
		
		cPrice = new JLabel("Price: 399 tk/Kg");
		cPrice.setBounds(650, 430, 150, 20);
		cPrice.setBackground(Color.black);
		cPrice.setForeground(Color.white);
		frame.add(cPrice);
		
		country_chickenLabel = new JLabel(country_chickenIcon);
		country_chickenLabel.setBounds(450, 250, 340, 200);
		frame.add(country_chickenLabel);
		
		cNumber = new JComboBox<String>(c);
		cNumber.setBounds(480, 470, 50, 17);
		frame.add(cNumber);
		
		quantity3 = new JLabel(">>>Kg");
		quantity3.setBounds(535, 470, 80, 17);
		quantity3.setBackground(Color.black);
		quantity3.setForeground(Color.white);
		frame.add(quantity3);
		
		
		Image image4 = new ImageIcon("icons/foreign_chicken.png").getImage().getScaledInstance(340, 200, Image.SCALE_DEFAULT);
		ImageIcon foreign_chickenIcon = new ImageIcon(image4);
		foreign_chicken  = new JCheckBox("Foreign Chicken");
		foreign_chicken.setBounds(40, 430, 180, 20);
		foreign_chicken.setFocusable(false);
		foreign_chicken.setForeground(Color.white);
		foreign_chicken.setBackground(Color.black);
		frame.add(foreign_chicken);
		
	
		fcPrice = new JLabel("Price: 170 tk/Kg");
		fcPrice.setBounds(230, 430, 180, 20);
		fcPrice.setBackground(Color.black);
		fcPrice.setForeground(Color.white);
		frame.add(fcPrice);
		
		
		foreign_chickenLabel = new JLabel(foreign_chickenIcon);
		foreign_chickenLabel.setBounds(20, 250, 340, 180);
		frame.add(foreign_chickenLabel);
		
		fcNumber = new JComboBox<String>(d);
		fcNumber.setBounds(40, 470, 50, 17);
		frame.add(fcNumber);
		
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
				
			beef.setBackground(color);
			mutton.setBackground(color);
			country_chicken.setBackground(color);
			foreign_chicken.setBackground(color);
				
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
			double beefAmount = 0;
			double muttonAmount = 0;
			double country_chickenAmount = 0;
			double foreign_chickenAmount = 0;
			int a = 0;
			int b = 0;
			int c = 0;
			int d = 0;
			
			
			if (beef.isSelected()==true)
			{
				a = (bNumber.getSelectedIndex())+1;
				beefAmount= a*799;
			}
			if (mutton.isSelected()==true)
			{
				b = mNumber.getSelectedIndex()+1;
				muttonAmount= b*920;
			}
			if (country_chicken.isSelected()==true)
			{
				c = cNumber.getSelectedIndex()+1;
				country_chickenAmount= c*399;
			}
			if (foreign_chicken.isSelected()==true)
			{
				d = fcNumber.getSelectedIndex()+1;
				foreign_chickenAmount= d*170;
			}
			
			totalAmount = beefAmount+muttonAmount+country_chickenAmount+foreign_chickenAmount;
			
			if (totalAmount!=0)
			{
				int x = JOptionPane.showConfirmDialog(null, "Your Bill = "+totalAmount+" tk. Confirm Order?"," Conformation of Order", 0);
				if (x==0) 
				{
					new Payment(totalAmount, "Meat", f);
					frame.setVisible(false);
					
					
					try 
					{
						File newfile = new File("data\\Latest_Order.txt"); 
						newfile.createNewFile();
						FileWriter file = new FileWriter("data\\Latest_Order.txt");
						
						file.write("Beef--- "+a+" Kg---"+beefAmount+" tk."
						+"\nMutton---"+b+" Kg---"+muttonAmount+" tk."
						+"\nCountry Chicken---"+c+" Kg---"+country_chickenAmount+" tk."
						+"\nForeign Chicken---"+d+" Kg---"+foreign_chickenAmount +" tk."
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
