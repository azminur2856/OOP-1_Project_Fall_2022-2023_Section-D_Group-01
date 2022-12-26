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

public class Egg implements ActionListener,IEgg
{
	private JFrame frame;
	
	private JCheckBox chicken_eggs;
	private JCheckBox duck_eggs;
	private JCheckBox quail_eggs;
	private JCheckBox swan_eggs;

	private JLabel quantity1;
	private JLabel quantity2;
	private JLabel quantity3;
	private JLabel quantity4;
	
	private JLabel chicken_eggsLabel;
	private JLabel duck_eggsLabel;
	private JLabel quail_eggsLabel;
	private JLabel swan_eggsLabel;
	
	private JLabel cPrice;
	private JLabel dPrice;
	private JLabel qPrice;
	private JLabel sPrice;
	
	private JComboBox<String> cNumber;
	private JComboBox<String> dNumber;
	private JComboBox<String> qNumber;
	private JComboBox<String> sNumber;
	
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
	
	public Egg(String user)
	{
		f=user;
		
		frame = new JFrame("Egg");
		ImageIcon framelogo = new ImageIcon("icons/framelogo.jpg");
		
		
		Image image1 = new ImageIcon("icons/chicken_eggs.png").getImage().getScaledInstance(340, 150, Image.SCALE_DEFAULT);
		ImageIcon chicken_eggsIcon = new ImageIcon(image1);
	    chicken_eggs = new JCheckBox("Chicken Eggs");
		chicken_eggs.setBounds(40, 170, 150, 20);
		chicken_eggs.setFocusable(false);
		chicken_eggs.setForeground(Color.white);
		chicken_eggs.setBackground(Color.black);
		chicken_eggs.addActionListener(this);
		frame.add(chicken_eggs);
		
		cPrice = new JLabel("Price: 9 tk/piece");
		cPrice.setBounds(220, 170, 150, 20);
		cPrice.setBackground(Color.black);
		cPrice.setForeground(Color.white);
		frame.add(cPrice);
		
		chicken_eggsLabel = new JLabel(chicken_eggsIcon);
	    chicken_eggsLabel.setBounds(20, 20, 340, 140);
		frame.add(chicken_eggsLabel);
		
		
		cNumber = new JComboBox<String>(a);
		cNumber.setBounds(40, 200, 50, 17);
		frame.add(cNumber);
	
		quantity1 = new JLabel(">>>piece");
		quantity1.setBounds(95, 200, 80, 17);
		quantity1.setBackground(Color.black);
		quantity1.setForeground(Color.white);
		frame.add(quantity1);
		
		
		Image image2 = new ImageIcon("icons/duck_eggs.png").getImage().getScaledInstance(340, 140, Image.SCALE_DEFAULT);
		ImageIcon duck_eggsIcon = new ImageIcon(image2);
		duck_eggs= new JCheckBox("Duck Eggs");
		duck_eggs.setBounds(480, 170, 150, 20);
		duck_eggs.setFocusable(false);
		duck_eggs.setForeground(Color.white);
		duck_eggs.setBackground(Color.black);
		frame.add(duck_eggs);
		
		dPrice = new JLabel("Price: 15 tk/piece");
		dPrice.setBounds(650, 170, 150, 20);
		dPrice.setBackground(Color.black);
		dPrice.setForeground(Color.white);
		frame.add(dPrice);
		
		duck_eggsLabel = new JLabel(duck_eggsIcon);
		duck_eggsLabel.setBounds(450, 0, 340, 200);
		frame.add(duck_eggsLabel);
		
		dNumber = new JComboBox<String>(b);
		dNumber.setBounds(480, 200, 50, 17);
		frame.add(dNumber);
		
		quantity2 = new JLabel(">>>piece");
		quantity2.setBounds(535, 200, 80, 17);
		quantity2.setBackground(Color.black);
		quantity2.setForeground(Color.white);
		frame.add(quantity2);
		
		
		Image image3 = new ImageIcon("icons/quail_eggs.png").getImage().getScaledInstance(340, 140, Image.SCALE_DEFAULT);
		ImageIcon quail_eggsIcon = new ImageIcon(image3);
		quail_eggs = new JCheckBox("Quail Eggs");
		quail_eggs.setBounds(480, 430, 150, 20);
		quail_eggs.setFocusable(false);
		quail_eggs.setForeground(Color.white);
	    quail_eggs.setBackground(Color.black);
		frame.add(quail_eggs);
		
		qPrice = new JLabel("Price: 3.5tk/piece");
		qPrice.setBounds(650, 430, 150, 20);
		qPrice.setBackground(Color.black);
		qPrice.setForeground(Color.white);
		frame.add(qPrice);
		
		quail_eggsLabel = new JLabel(quail_eggsIcon);
		quail_eggsLabel.setBounds(450, 250, 340, 200);
		frame.add(quail_eggsLabel);
		
		qNumber = new JComboBox<String>(c);
		qNumber.setBounds(480, 470, 50, 17);
		frame.add(qNumber);
		
		quantity3 = new JLabel(">>>piece");
		quantity3.setBounds(535, 470, 80, 17);
		quantity3.setBackground(Color.black);
		quantity3.setForeground(Color.white);
		frame.add(quantity3);
		
		
		Image image4 = new ImageIcon("icons/swan_eggs.png").getImage().getScaledInstance(340, 140, Image.SCALE_DEFAULT);
		ImageIcon swan_eggsIcon = new ImageIcon(image4);
		swan_eggs  = new JCheckBox("Swan Eggs");
		swan_eggs.setBounds(40, 430, 180, 20);
		swan_eggs.setFocusable(false);
		swan_eggs.setForeground(Color.white);
		swan_eggs.setBackground(Color.black);
		frame.add(swan_eggs);
		
	
		sPrice = new JLabel("Price: 21tk/piece");
		sPrice.setBounds(230, 430, 180, 20);
		sPrice.setBackground(Color.black);
		sPrice.setForeground(Color.white);
		frame.add(sPrice);
		
		
		swan_eggsLabel = new JLabel(swan_eggsIcon);
		swan_eggsLabel.setBounds(20, 250, 340, 180);
		frame.add(swan_eggsLabel);
		
		sNumber = new JComboBox<String>(d);
		sNumber.setBounds(40, 470, 50, 17);
		frame.add(sNumber);
		
		quantity4 = new JLabel(">>>piece");
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
				
			chicken_eggs.setBackground(color);
	        duck_eggs.setBackground(color);
			quail_eggs.setBackground(color);
			swan_eggs.setBackground(color);
				
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
			double chicken_eggsAmount = 0;
			double duck_eggsAmount = 0;
			double quail_eggsAmount = 0;
			double swan_eggsAmount = 0;
			int a = 0;
			int b = 0;
			int c = 0;
			int d = 0;
			
			
			if (chicken_eggs.isSelected()==true)
			{
				a = (cNumber.getSelectedIndex())+1;
				chicken_eggsAmount= a*9;
			}
			if (duck_eggs.isSelected()==true)
			{
				b = dNumber.getSelectedIndex()+1;
				duck_eggsAmount= b*15;
			}
			if (quail_eggs.isSelected()==true)
			{
				c = qNumber.getSelectedIndex()+1;
				quail_eggsAmount= c*3.5;
			}
			if (swan_eggs.isSelected()==true)
			{
				d = sNumber.getSelectedIndex()+1;
				swan_eggsAmount= d*21;
			}
			
			totalAmount = chicken_eggsAmount+duck_eggsAmount+quail_eggsAmount+swan_eggsAmount;
			
			if (totalAmount!=0)
			{
				int x = JOptionPane.showConfirmDialog(null, "Your Bill = "+totalAmount+" tk. Confirm Order?"," Conformation of Order", 0);
				if (x==0) 
				{
					new Payment(totalAmount, "Egg", f);
					frame.setVisible(false);
					
					
					try 
					{
						File newfile = new File("data\\Latest_Order.txt"); 
						newfile.createNewFile();
						FileWriter file = new FileWriter("data\\Latest_Order.txt");
						
						file.write("Chicken_Eggs--- "+a+" piece---"+chicken_eggsAmount+" tk."
						+"\nDuck_Eggs---"+b+" piece---"+duck_eggsAmount+" tk."
						+"\nQuail_Eggs---"+c+" piece---"+quail_eggsAmount+" tk."
						+"\nSwan_Eggs---"+d+" piece---"+swan_eggsAmount +" tk."
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