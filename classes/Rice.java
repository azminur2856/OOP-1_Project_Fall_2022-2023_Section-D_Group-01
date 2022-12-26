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

public class Rice implements ActionListener,IRice
{
	private JFrame frame;
	
	private JCheckBox miniket_rice;
	private JCheckBox basmati_rice;
	private JCheckBox nazirshail_rice;
	private JCheckBox chinigura_rice;
	
	private JLabel quantity1;
	private JLabel quantity2;
	private JLabel quantity3;
	private JLabel quantity4;
	
	private JLabel miniket_riceLabel;
	private JLabel basmati_riceLabel;
	private JLabel nazirshail_riceLabel;
	private JLabel chinigura_riceLabel;
	
	private JLabel mPrice;
	private JLabel bPrice;
	private JLabel nPrice;
	private JLabel cPrice;
	
	private JComboBox<String> mNumber;
	private JComboBox<String> bNumber;
	private JComboBox<String> nNumber;
	private JComboBox<String> cNumber;
	
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
	
	public Rice(String user)
	{
		f=user;
		
		frame = new JFrame("Rice");
		ImageIcon framelogo = new ImageIcon("icons/framelogo.jpg");
		
		
		Image image1 = new ImageIcon("icons/miniket_rice.png").getImage().getScaledInstance(340, 200, Image.SCALE_DEFAULT);
		ImageIcon miniket_riceIcon = new ImageIcon(image1);
		miniket_rice = new JCheckBox("Miniket Rice");
		miniket_rice.setBounds(40, 170, 150, 20);
		miniket_rice.setFocusable(false);
		miniket_rice.setForeground(Color.white);
		miniket_rice.setBackground(Color.black);
		miniket_rice.addActionListener(this);
		frame.add(miniket_rice);
		
		mPrice = new JLabel("Price: 71 tk/Kg");
		mPrice.setBounds(220, 170, 150, 20);
		mPrice.setBackground(Color.black);
		mPrice.setForeground(Color.white);
		frame.add(mPrice);
		
		miniket_riceLabel = new JLabel(miniket_riceIcon);
		miniket_riceLabel.setBounds(20, 20, 340, 140);
		frame.add(miniket_riceLabel);
		
		
		mNumber = new JComboBox<String>(a);
		mNumber.setBounds(40, 200, 50, 17);
		frame.add(mNumber);
	
		quantity1 = new JLabel(">>>Kg");
		quantity1.setBounds(95, 200, 80, 17);
		quantity1.setBackground(Color.black);
		quantity1.setForeground(Color.white);
		frame.add(quantity1);
		
		
		Image image2 = new ImageIcon("icons/basmati_rice.png").getImage().getScaledInstance(340, 140, Image.SCALE_DEFAULT);
		ImageIcon basmati_riceIcon = new ImageIcon(image2);
		basmati_rice= new JCheckBox("Basmati Rice");
		basmati_rice.setBounds(480, 170, 150, 20);
		basmati_rice.setFocusable(false);
		basmati_rice.setForeground(Color.white);
		basmati_rice.setBackground(Color.black);
		frame.add(basmati_rice);
		
		bPrice = new JLabel("Price: 250 tk/Kg");
		bPrice.setBounds(650, 170, 150, 20);
		bPrice.setBackground(Color.black);
		bPrice.setForeground(Color.white);
		frame.add(bPrice);
		
		basmati_riceLabel = new JLabel(basmati_riceIcon);
		basmati_riceLabel.setBounds(450, 0, 340, 200);
		frame.add(basmati_riceLabel);
		
		bNumber = new JComboBox<String>(b);
		bNumber.setBounds(480, 200, 50, 17);
		frame.add(bNumber);
		
		quantity2 = new JLabel(">>>Kg");
		quantity2.setBounds(535, 200, 80, 17);
		quantity2.setBackground(Color.black);
		quantity2.setForeground(Color.white);
		frame.add(quantity2);
		
		
		Image image3 = new ImageIcon("icons/nazirshail_rice.png").getImage().getScaledInstance(340, 140, Image.SCALE_DEFAULT);
		ImageIcon nazirshail_riceIcon = new ImageIcon(image3);
		nazirshail_rice = new JCheckBox("Nazirshail Rice");
		nazirshail_rice.setBounds(480, 430, 150, 20);
		nazirshail_rice.setFocusable(false);
		nazirshail_rice.setForeground(Color.white);
		nazirshail_rice.setBackground(Color.black);
		frame.add(nazirshail_rice);
		
		nPrice = new JLabel("Price: 72 tk/Kg");
		nPrice.setBounds(650, 430, 150, 20);
		nPrice.setBackground(Color.black);
		nPrice.setForeground(Color.white);
		frame.add(nPrice);
		
		nazirshail_riceLabel = new JLabel(nazirshail_riceIcon);
		nazirshail_riceLabel.setBounds(450, 250, 340, 200);
		frame.add(nazirshail_riceLabel);
		
		nNumber = new JComboBox<String>(c);
		nNumber.setBounds(480, 470, 50, 17);
		frame.add(nNumber);
		
		quantity3 = new JLabel(">>>Kg");
		quantity3.setBounds(535, 470, 80, 17);
		quantity3.setBackground(Color.black);
		quantity3.setForeground(Color.white);
		frame.add(quantity3);
		
		
		Image image4 = new ImageIcon("icons/chinigura_rice.png").getImage().getScaledInstance(340, 200, Image.SCALE_DEFAULT);
		ImageIcon chinigura_riceIcon = new ImageIcon(image4);
		chinigura_rice  = new JCheckBox("Chinigura Rice");
		chinigura_rice .setBounds(40, 430, 180, 20);
		chinigura_rice.setFocusable(false);
		chinigura_rice.setForeground(Color.white);
		chinigura_rice.setBackground(Color.black);
		frame.add(chinigura_rice);
		
	
		cPrice = new JLabel("Price: 135 tk/Kg");
		cPrice.setBounds(230, 430, 180, 20);
		cPrice.setBackground(Color.black);
		cPrice.setForeground(Color.white);
		frame.add(cPrice);
		
		
		chinigura_riceLabel = new JLabel(chinigura_riceIcon);
		chinigura_riceLabel.setBounds(20, 250, 340, 180);
		frame.add(chinigura_riceLabel);
		
		cNumber = new JComboBox<String>(d);
		cNumber.setBounds(40, 470, 50, 17);
		frame.add(cNumber);
		
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
				
			miniket_rice.setBackground(color);
			basmati_rice.setBackground(color);
			nazirshail_rice.setBackground(color);
			chinigura_rice.setBackground(color);
				
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
			double miniket_riceAmount = 0;
			double basmati_riceAmount = 0;
			double nazirshail_riceAmount = 0;
			double chinigura_riceAmount = 0;
			int a = 0;
			int b = 0;
			int c = 0;
			int d = 0;
			
			
			if (miniket_rice.isSelected()==true)
			{
				a = (mNumber.getSelectedIndex())+1;
				miniket_riceAmount= a*71;
			}
			if (basmati_rice.isSelected()==true)
			{
				b = bNumber.getSelectedIndex()+1;
				basmati_riceAmount= b*250;
			}
			if (nazirshail_rice.isSelected()==true)
			{
				c = nNumber.getSelectedIndex()+1;
				nazirshail_riceAmount= c*72;
			}
			if (chinigura_rice.isSelected()==true)
			{
				d = cNumber.getSelectedIndex()+1;
				chinigura_riceAmount= d*135;
			}
			
			totalAmount = miniket_riceAmount+basmati_riceAmount+nazirshail_riceAmount+chinigura_riceAmount;
			
			if (totalAmount!=0)
			{
				int x = JOptionPane.showConfirmDialog(null, "Your Bill = "+totalAmount+" tk. Confirm Order?"," Conformation of Order", 0);
				if (x==0) 
				{
					new Payment(totalAmount, "Rice", f);
					frame.setVisible(false);
					
					try 
					{
						File newfile = new File("data\\Latest_Order.txt"); 
						newfile.createNewFile();
						FileWriter file = new FileWriter("data\\Latest_Order.txt");
						
						file.write("Miniket_Rice--- "+a+" Kg---"+miniket_riceAmount+" tk."
						+"\nBasmati Rice---"+b+" Kg---"+basmati_riceAmount+" tk."
						+"\nNazirshail_Rice---"+c+" Kg---"+nazirshail_riceAmount+" tk."
						+"\nChinigura_Rice---"+d+" Kg---"+chinigura_riceAmount +" tk."
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
