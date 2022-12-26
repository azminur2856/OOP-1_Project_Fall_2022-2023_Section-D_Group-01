package classes;
import java.lang.*;
import interfaces.*;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

public class Payment implements ActionListener, IPayment
{
	private JFrame frame;
	private JLabel title;
	private JLabel title1;
	private JLabel title2;
	private JLabel message;
	private JLabel cardHolderName;
	private JLabel cardNumber;
	private JLabel validOn;
	private JLabel cvc_cvv;
	
	private JTextField tfUName;
	private JTextField tfcn;
	private JTextField tfvo;
	private JPasswordField pfcvc_cvv;
	
	private JButton confirmButton;
	private JButton exitButton;
	private JButton previous;
	
	private Rice x;
	
	private double z;
	
	private String allItem;
	private String f;
	
	public Payment(double amount, String itemName, String user)
	{
		f = user;
		
		allItem = itemName;
		
		z = amount;
		frame = new JFrame("Payment Information");
		
		ImageIcon framelogo = new ImageIcon("icons/framelogo.jpg");
		ImageIcon title1Icon = new ImageIcon("icons/mastercard.png");
		ImageIcon title2Icon = new ImageIcon("icons/visacard.png");
		ImageIcon exitImage = new ImageIcon("icons/exiticon.png");
		ImageIcon previousImage = new ImageIcon("icons/previous.png");
		
		//background
		Image background = new ImageIcon("icons/PaymentBackground.png").getImage().getScaledInstance(1000, 550, Image.SCALE_AREA_AVERAGING);
		frame.setContentPane(new ImagePanel(background));
		
		
		
		title = new JLabel("Complete Your Payment");
		title.setForeground(Color.BLACK);
		title.setFont(new Font("Segoe UI Black", Font.PLAIN, 34));
		title.setBounds(420, 20, 500, 50);
		frame.add(title);
		
		
		title1 = new JLabel("We Accept Only");
		title1.setForeground(Color.BLACK);
		title1.setIcon(title1Icon);
		title1.setHorizontalTextPosition(JLabel.LEFT);
		title1.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 25));
		title1.setBounds(420, 80, 500, 50);
		frame.add(title1);
		
		
		title2= new JLabel(title2Icon);
		title2.setBounds(480, 80, 500, 50);
		frame.add(title2);
		
		
		message = new JLabel("Please Fillup Your Card Details Below:");
		message.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 20));
		message.setBounds(420, 130, 400, 50);
		frame.add(message);
		
		
		cardHolderName = new JLabel("Card Holder Name: ");
		cardHolderName.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		cardHolderName.setBounds(420, 170, 180, 50);
		frame.add(cardHolderName);
		
		
		cardNumber = new JLabel("Enter Card Number: ");
		cardNumber.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		cardNumber.setBounds(420, 210, 500, 50);
		frame.add(cardNumber);
		
		
		validOn = new JLabel("Valid On: ");
		validOn.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		validOn.setBounds(420, 250, 500, 50);
		frame.add(validOn);
		
		cvc_cvv = new JLabel("CVC/CVV: ");
		cvc_cvv.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 18));
		cvc_cvv.setBounds(640, 250, 500, 50);
		frame.add(cvc_cvv);
		
		
		tfUName = new JTextField();
		tfUName.setBounds(600, 185, 240, 23);
		tfUName.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		tfUName.setToolTipText("Enter Your Name.");
		tfUName.setVisible(true);
		frame.add(tfUName);
		
		
		tfcn = new JTextField();
		tfcn.setBounds(600, 225, 240, 23);
		tfcn.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		tfcn.setToolTipText("Enter Your Card Number.");
		tfcn.setVisible(true);
		frame.add(tfcn);
		
		
		tfvo = new JTextField();
		tfvo.setBounds(505, 265, 100, 23);
		tfvo.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		tfvo.setToolTipText("Enter card validity date.");
		tfvo.setVisible(true);
		frame.add(tfvo);
		
		
		pfcvc_cvv = new JPasswordField();
		pfcvc_cvv.setBounds(740, 265, 100, 23);
		pfcvc_cvv.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		pfcvc_cvv.setToolTipText("Enter Your CVC/CVP Code.");
		pfcvc_cvv.setEchoChar('*');
		pfcvc_cvv.setVisible(true);
		frame.add(pfcvc_cvv);
		
		
		confirmButton= new JButton("Confirm Payment");
		confirmButton.setBounds(575, 350, 150, 30);
		confirmButton.setFocusable(false);
		confirmButton.setBackground(Color.green);
		confirmButton.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		confirmButton.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
		confirmButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		confirmButton.addActionListener(this);
		confirmButton.setVisible(true);
		frame.add(confirmButton);
		
		
		exitButton = new JButton("Exit");
		exitButton.setBounds(700, 410, 100, 30);
		exitButton.setFocusable(false);
		exitButton.setBackground(Color.BLACK);
		exitButton.setForeground(Color.WHITE);
		exitButton.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		exitButton.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
		exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		exitButton.setIcon(exitImage);
		exitButton.addActionListener(this);
		exitButton.setVisible(true);
		frame.add(exitButton);
		
		
		previous = new JButton ("Back");
		previous.setBounds(500, 410, 100, 30);
		previous.setFocusable(false);
		previous.setBackground(Color.BLACK);
		previous.setForeground(Color.WHITE);
		previous.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		previous.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
		previous.setCursor(new Cursor(Cursor.HAND_CURSOR));
		previous.setIcon(previousImage);
		previous.addActionListener(this);
		previous.setVisible(true);
		frame.add(previous);
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1000, 550);
		frame.setIconImage(framelogo.getImage());
		frame.getContentPane().setBackground(Color.decode("#F2F2F2"));
		frame.setResizable(false);
		frame.setLayout (null);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}


	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==previous)
		{
			if(allItem=="Rice")
			{
				new Rice(f);
				frame.setVisible(false);
				
			}
			else if(allItem=="Dal")
			{
				new Dal(f);
				frame.setVisible(false);
				
			}
			else if(allItem=="Meat")
			{
				new Meat(f);
				frame.setVisible(false);
				
			}
			else if(allItem=="Fish")
			{
				new Fish(f);
				frame.setVisible(false);
				
			}
			else if(allItem=="Egg")
			{
				new Egg(f);
				frame.setVisible(false);
				
			}
			else if(allItem=="Vegetable")
			{
				new Vegetable(f);
				frame.setVisible(false);
				
			}
			
			
		}
		else if(e.getSource()==exitButton)
		{
			int a = JOptionPane.showConfirmDialog(null, "Do you want to exit?", "Exit Confirmation", 0);
			if(a==0)
			{
				System.exit(0);
			}
		}
		
		else if(e.getSource()==confirmButton)
		{
			String a = tfUName.getText();
			String b = tfcn.getText();
			String c = tfvo.getText();
			String d = pfcvc_cvv.getText();
			if (a.isEmpty()|| b.isEmpty() || c.isEmpty() || d.isEmpty())
			{
				JOptionPane.showInternalMessageDialog(null, "Please fill up all the necessary details");
			}
			else
			{
				try 
				{
					long m = Long.parseLong(b);
					long n = Long.parseLong(c);
					long o = Long.parseLong(d);
					
					if(b.length()!=16)
					{
						JOptionPane.showMessageDialog(null, "Card number should't have more than 16 digit ", "Alert!", 0);
					}
					
					else if (c.length()!=4)
					{
						JOptionPane.showMessageDialog(null, "Valid On must be MMYY ", "Alert!", 0);
					}
					
					else if (d.length()!=3)
					{
						JOptionPane.showMessageDialog(null, "CVV code number should have 3 digit ", "Alert!", 0);
					}
					
					else if(b.length()==16 &&  d.length()==3)
					{
						new PaymentSuccess(z,f);
						frame.setVisible(false);
					}
					try
					{
						File newfile = new File("data\\Latest Payment details.txt"); 
						newfile.createNewFile();
						FileWriter writeFile = new FileWriter("data\\Latest Payment details.txt");
						
						writeFile.write("Card Holder Name : "+a+"\nCard Number :"+b+
								"\nValid On : "+c+"\nCVC/CVV Code : "+d);
						writeFile.close();
						
					}
					
					catch(IOException io)
					{
						JOptionPane.showMessageDialog(null, "An error Occured while writting file");
						io.printStackTrace();
					}
	
				}
				
	
				catch(InputMismatchException a1)
				{
					JOptionPane.showMessageDialog(null, "Please enter valid card no or code!", "Alert!", 0);
				}
				catch(NumberFormatException a2)
				{
					JOptionPane.showMessageDialog(null, "Please enter valid information!", "Alert!", 0);
				}
				
			}
		}
		
	}

}
