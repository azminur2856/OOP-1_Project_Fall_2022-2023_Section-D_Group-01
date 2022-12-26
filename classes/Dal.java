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

public class Dal implements ActionListener,IDal
{
	private JFrame frame;
	
	private JCheckBox mug_dal;
	private JCheckBox moshur_dal;
	private JCheckBox chola_dal;
	private JCheckBox boot_dal;
	
	private JLabel quantity1;
	private JLabel quantity2;
	private JLabel quantity3;
	private JLabel quantity4;
	
	private JLabel mug_dalLabel;
	private JLabel moshur_dalLabel;
	private JLabel chola_dalLabel;
	private JLabel boot_dalLabel;
	
	private JLabel mPrice;
	private JLabel moPrice;
	private JLabel cPrice;
	private JLabel bPrice;
	
	private JComboBox<String> mNumber;
	private JComboBox<String> moNumber;
	private JComboBox<String> cNumber;
	private JComboBox<String> bNumber;
	
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
	
	public Dal(String user)
	{
		f=user;
		
		frame = new JFrame("Dal");
		ImageIcon framelogo = new ImageIcon("icons/framelogo.jpg");
		
		
		Image image1 = new ImageIcon("icons/mug_dal.png").getImage().getScaledInstance(340, 140, Image.SCALE_DEFAULT);
		ImageIcon mug_dalIcon = new ImageIcon(image1);
		mug_dal = new JCheckBox("Mug Dal");
		mug_dal.setBounds(40, 170, 150, 20);
		mug_dal.setFocusable(false);
		mug_dal.setForeground(Color.white);
		mug_dal.setBackground(Color.black);
		mug_dal.addActionListener(this);
		frame.add(mug_dal);
		
		mPrice = new JLabel("Price: 170 tk/Kg");
		mPrice.setBounds(220, 170, 150, 20);
		mPrice.setBackground(Color.black);
		mPrice.setForeground(Color.white);
		frame.add(mPrice);
		
		mug_dalLabel = new JLabel(mug_dalIcon);
		mug_dalLabel.setBounds(20, 20, 340, 140);
		frame.add(mug_dalLabel);
		
		
		mNumber = new JComboBox<String>(a);
		mNumber.setBounds(40, 200, 50, 17);
		frame.add(mNumber);
	
		quantity1 = new JLabel(">>>Kg");
		quantity1.setBounds(95, 200, 80, 17);
		quantity1.setBackground(Color.black);
		quantity1.setForeground(Color.white);
		frame.add(quantity1);
		
		
		Image image2 = new ImageIcon("icons/moshur_dal.png").getImage().getScaledInstance(340, 140, Image.SCALE_DEFAULT);
		ImageIcon moshur_dalIcon = new ImageIcon(image2);
		moshur_dal= new JCheckBox("Moshur Dal");
		moshur_dal.setBounds(480, 170, 150, 20);
		moshur_dal.setFocusable(false);
		moshur_dal.setForeground(Color.white);
		moshur_dal.setBackground(Color.black);
		frame.add(moshur_dal);
		
		moPrice = new JLabel("Price: 99 tk/Kg");
		moPrice.setBounds(650, 170, 150, 20);
		moPrice.setBackground(Color.black);
		moPrice.setForeground(Color.white);
		frame.add(moPrice);
		
		moshur_dalLabel = new JLabel(moshur_dalIcon);
		moshur_dalLabel.setBounds(450, 0, 340, 200);
		frame.add(moshur_dalLabel);
		
		moNumber = new JComboBox<String>(b);
		moNumber.setBounds(480, 200, 50, 17);
		frame.add(moNumber);
		
		quantity2 = new JLabel(">>>Kg");
		quantity2.setBounds(535, 200, 80, 17);
		quantity2.setBackground(Color.black);
		quantity2.setForeground(Color.white);
		frame.add(quantity2);
		
		
		Image image3 = new ImageIcon("icons/chola_dal.png").getImage().getScaledInstance(340, 200, Image.SCALE_DEFAULT);
		ImageIcon chola_dalIcon = new ImageIcon(image3);
		chola_dal = new JCheckBox("Chola Dal");
		chola_dal.setBounds(480, 430, 150, 20);
		chola_dal.setFocusable(false);
		chola_dal.setForeground(Color.white);
		chola_dal.setBackground(Color.black);
		frame.add(chola_dal);
		
		cPrice = new JLabel("Price: 80 tk/Kg");
		cPrice.setBounds(650, 430, 150, 20);
		cPrice.setBackground(Color.black);
		cPrice.setForeground(Color.white);
		frame.add(cPrice);
		
		chola_dalLabel = new JLabel(chola_dalIcon);
		chola_dalLabel.setBounds(450, 250, 340, 200);
		frame.add(chola_dalLabel);
		
		cNumber = new JComboBox<String>(c);
		cNumber.setBounds(480, 470, 50, 17);
		frame.add(cNumber);
		
		quantity3 = new JLabel(">>>Kg");
		quantity3.setBounds(535, 470, 80, 17);
		quantity3.setBackground(Color.black);
		quantity3.setForeground(Color.white);
		frame.add(quantity3);
		
		
		Image image4 = new ImageIcon("icons/boot_dal.png").getImage().getScaledInstance(340, 200, Image.SCALE_DEFAULT);
		ImageIcon boot_dalIcon = new ImageIcon(image4);
		boot_dal  = new JCheckBox("Boot Dal");
		boot_dal.setBounds(40, 430, 180, 20);
		boot_dal.setFocusable(false);
		boot_dal.setForeground(Color.white);
		boot_dal.setBackground(Color.black);
		frame.add(boot_dal);
		
	
		bPrice = new JLabel("Price: 95 tk/Kg");
		bPrice.setBounds(230, 430, 180, 20);
		bPrice.setBackground(Color.black);
		bPrice.setForeground(Color.white);
		frame.add(bPrice);
		
		
		boot_dalLabel = new JLabel(boot_dalIcon);
		boot_dalLabel.setBounds(20, 250, 340, 180);
		frame.add(boot_dalLabel);
		
		bNumber = new JComboBox<String>(d);
		bNumber.setBounds(40, 470, 50, 17);
		frame.add(bNumber);
		
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
				
			mug_dal.setBackground(color);
			moshur_dal.setBackground(color);
			chola_dal.setBackground(color);
			boot_dal.setBackground(color);
				
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
			double mug_dalAmount = 0;
			double moshur_dalAmount = 0;
			double chola_dalAmount = 0;
			double boot_dalAmount = 0;
			int a = 0;
			int b = 0;
			int c = 0;
			int d = 0;
			
			
			if (mug_dal.isSelected()==true)
			{
				a = (mNumber.getSelectedIndex())+1;
				mug_dalAmount= a*170;
			}
			if (moshur_dal.isSelected()==true)
			{
				b = moNumber.getSelectedIndex()+1;
				moshur_dalAmount= b*99;
			}
			if (chola_dal.isSelected()==true)
			{
				c = cNumber.getSelectedIndex()+1;
				chola_dalAmount= c*80;
			}
			if (boot_dal.isSelected()==true)
			{
				d = bNumber.getSelectedIndex()+1;
				boot_dalAmount= d*95;
			}
			
			totalAmount = mug_dalAmount+moshur_dalAmount+chola_dalAmount+boot_dalAmount;
			
			if (totalAmount!=0)
			{
				int x = JOptionPane.showConfirmDialog(null, "Your Bill = "+totalAmount+" tk. Confirm Order?"," Conformation of Order", 0);
				if (x==0) 
				{
					new Payment(totalAmount, "Dal", f);
					frame.setVisible(false);
					
					
					try 
					{
						File newfile = new File("data\\Latest_Order.txt"); 
						newfile.createNewFile();
						FileWriter file = new FileWriter("data\\Latest_Order.txt");
						
						file.write("Mug Dal--- "+a+" Kg---"+mug_dalAmount+" tk."
						+"\nMoshur Dal---"+b+" Kg---"+moshur_dalAmount+" tk."
						+"\nChola Dal---"+c+" Kg---"+chola_dalAmount+" tk."
						+"\nBoot Dal---"+d+" Kg---"+boot_dalAmount +" tk."
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
