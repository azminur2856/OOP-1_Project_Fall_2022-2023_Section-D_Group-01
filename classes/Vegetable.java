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

public class Vegetable implements ActionListener,IVegetable
{
	private JFrame frame;
	
	private JCheckBox potato;
	private JCheckBox brinjal;
	private JCheckBox cauliflower;
	private JCheckBox beans;

	private JLabel quantity1;
	private JLabel quantity2;
	private JLabel quantity3;
	private JLabel quantity4;
	
	private JLabel potatoLabel;
	private JLabel brinjalLabel;
	private JLabel cauliflowerLabel;
	private JLabel beansLabel;
	
	private JLabel pPrice;
	private JLabel bPrice;
	private JLabel cPrice;
	private JLabel bePrice;
	
	private JComboBox<String> pNumber;
	private JComboBox<String> bNumber;
	private JComboBox<String> cNumber;
	private JComboBox<String> beNumber;
	
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
	
	public Vegetable(String user)
	{
		f=user;
		
		frame = new JFrame("Vegetable");
		ImageIcon framelogo = new ImageIcon("icons/framelogo.jpg");
		
		
		Image image1 = new ImageIcon("icons/potato.png").getImage().getScaledInstance(340, 150, Image.SCALE_DEFAULT);
		ImageIcon potatoIcon = new ImageIcon(image1);
	    potato = new JCheckBox("Potato");
		potato.setBounds(40, 170, 150, 20);
		potato.setFocusable(false);
		potato.setForeground(Color.white);
		potato.setBackground(Color.black);
		potato.addActionListener(this);
		frame.add(potato);
		
		pPrice = new JLabel("Price: 35 tk/kg");
		pPrice.setBounds(220, 170, 150, 20);
		pPrice.setBackground(Color.black);
		pPrice.setForeground(Color.white);
		frame.add(pPrice);
		
		potatoLabel = new JLabel(potatoIcon);
	    potatoLabel.setBounds(20, 20, 340, 140);
		frame.add(potatoLabel);
		
		
		pNumber = new JComboBox<String>(a);
		pNumber.setBounds(40, 200, 50, 17);
		frame.add(pNumber);
	
		quantity1 = new JLabel(">>>kg");
		quantity1.setBounds(95, 200, 80, 17);
		quantity1.setBackground(Color.black);
		quantity1.setForeground(Color.white);
		frame.add(quantity1);
		
		
		Image image2 = new ImageIcon("icons/brinjal.png").getImage().getScaledInstance(340, 140, Image.SCALE_DEFAULT);
		ImageIcon brinjalIcon = new ImageIcon(image2);
		brinjal= new JCheckBox("Brinjal");
		brinjal.setBounds(480, 170, 150, 20);
		brinjal.setFocusable(false);
		brinjal.setForeground(Color.white);
		brinjal.setBackground(Color.black);
		frame.add(brinjal);
		
		bPrice = new JLabel("Price: 45 tk/kg");
		bPrice.setBounds(650, 170, 150, 20);
		bPrice.setBackground(Color.black);
		bPrice.setForeground(Color.white);
		frame.add(bPrice);
		
		brinjalLabel = new JLabel(brinjalIcon);
		brinjalLabel.setBounds(450, 0, 340, 200);
		frame.add(brinjalLabel);
		
		bNumber = new JComboBox<String>(b);
		bNumber.setBounds(480, 200, 50, 17);
		frame.add(bNumber);
		
		quantity2 = new JLabel(">>>kg");
		quantity2.setBounds(535, 200, 80, 17);
		quantity2.setBackground(Color.black);
		quantity2.setForeground(Color.white);
		frame.add(quantity2);
		
		
		Image image3 = new ImageIcon("icons/cauliflower.png").getImage().getScaledInstance(340, 140, Image.SCALE_DEFAULT);
		ImageIcon cauliflowerIcon = new ImageIcon(image3);
		cauliflower = new JCheckBox("Cauliflower");
		cauliflower.setBounds(480, 430, 150, 20);
		cauliflower.setFocusable(false);
		cauliflower.setForeground(Color.white);
	    cauliflower.setBackground(Color.black);
		frame.add(cauliflower);
		
		cPrice = new JLabel("Price: 30 tk/kg");
		cPrice.setBounds(650, 430, 150, 20);
		cPrice.setBackground(Color.black);
		cPrice.setForeground(Color.white);
		frame.add(cPrice);
		
		cauliflowerLabel = new JLabel(cauliflowerIcon);
		cauliflowerLabel.setBounds(450, 250, 340, 200);
		frame.add(cauliflowerLabel);
		
		cNumber = new JComboBox<String>(c);
		cNumber.setBounds(480, 470, 50, 17);
		frame.add(cNumber);
		
		quantity3 = new JLabel(">>>kg");
		quantity3.setBounds(535, 470, 80, 17);
		quantity3.setBackground(Color.black);
		quantity3.setForeground(Color.white);
		frame.add(quantity3);
		
		
		Image image4 = new ImageIcon("icons/beans.png").getImage().getScaledInstance(340, 150, Image.SCALE_DEFAULT);
		ImageIcon beansIcon = new ImageIcon(image4);
		beans  = new JCheckBox("Beans");
		beans.setBounds(40, 430, 180, 20);
		beans.setFocusable(false);
		beans.setForeground(Color.white);
		beans.setBackground(Color.black);
		frame.add(beans);
		
	
		bePrice = new JLabel("Price: 50 tk/kg");
		bePrice.setBounds(230, 430, 180, 20);
		bePrice.setBackground(Color.black);
		bePrice.setForeground(Color.white);
		frame.add(bePrice);
		
		
		beansLabel = new JLabel(beansIcon);
		beansLabel.setBounds(20, 250, 340, 180);
		frame.add(beansLabel);
		
		beNumber = new JComboBox<String>(d);
		beNumber.setBounds(40, 470, 50, 17);
		frame.add(beNumber);
		
		quantity4 = new JLabel(">>>kg");
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
				
			potato.setBackground(color);
	        brinjal.setBackground(color);
			cauliflower.setBackground(color);
			beans.setBackground(color);
				
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
			double potatoAmount = 0;
			double brinjalAmount = 0;
			double cauliflowerAmount = 0;
			double beansAmount = 0;
			int a = 0;
			int b = 0;
			int c = 0;
			int d = 0;
			
			
			if (potato.isSelected()==true)
			{
				a = (pNumber.getSelectedIndex())+1;
				potatoAmount= a*35;
			}
			if (brinjal.isSelected()==true)
			{
				b = bNumber.getSelectedIndex()+1;
				brinjalAmount= b*45;
			}
			if (cauliflower.isSelected()==true)
			{
				c = cNumber.getSelectedIndex()+1;
				cauliflowerAmount= c*30;
			}
			if (beans.isSelected()==true)
			{
				d = beNumber.getSelectedIndex()+1;
				beansAmount= d*50;
			}
			
			totalAmount = potatoAmount+brinjalAmount+cauliflowerAmount+beansAmount;
			
			if (totalAmount!=0)
			{
				int x = JOptionPane.showConfirmDialog(null, "Your Bill = "+totalAmount+" tk. Confirm Order?"," Conformation of Order", 0);
				if (x==0) 
				{
					new Payment(totalAmount, "Vegetable", f);
					frame.setVisible(false);
					
					
					try 
					{
						File newfile = new File("data\\Latest_Order.txt"); 
						newfile.createNewFile();
						FileWriter file = new FileWriter("data\\Latest_Order.txt");
						
						file.write("Potato--- "+a+" kg---"+potatoAmount+" tk."
						+"\nBrinjal---"+b+" kg---"+brinjalAmount+" tk."
						+"\nCauliflower---"+c+" kg---"+cauliflowerAmount+" tk."
						+"\nBeans---"+d+" kg---"+beansAmount +" tk."
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