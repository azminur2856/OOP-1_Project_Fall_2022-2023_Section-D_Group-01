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
import java.util.Scanner;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class PaymentSuccess implements ActionListener, IPaymentSuccess
{
	private JFrame frame;
	private JLabel transactionMessage;
	private JLabel amountPaid;
	
	private JButton home;
	private JButton exit;
	private JButton recipt;
	private String f;
	public PaymentSuccess(double amount,String user)
	{
		f=user;
		
		frame= new JFrame("Payment Successful");
		
		ImageIcon framelogo = new ImageIcon("icons/framelogo.jpg");
		ImageIcon exitImage = new ImageIcon("icons/exiticon.png");
		Image image1 = new ImageIcon("icons/success.png").getImage().getScaledInstance(120, 120, Image.SCALE_DEFAULT);
		ImageIcon successIcon = new ImageIcon(image1);
		
		//background
		Image background = new ImageIcon("icons/PaymentSuccessBackground.png").getImage().getScaledInstance(800, 500, Image.SCALE_AREA_AVERAGING);
		frame.setContentPane(new ImagePanel(background));
		
		transactionMessage = new JLabel("Transaction Completed Successfully!!!");
		transactionMessage.setIcon(successIcon);
		transactionMessage.setVerticalTextPosition(JLabel.BOTTOM);
		transactionMessage.setHorizontalTextPosition(JLabel.CENTER);
		transactionMessage.setForeground(Color.BLACK);
		transactionMessage.setFont(new Font("Segoe UI Black", Font.PLAIN, 28));
		transactionMessage.setBounds(135, 00, 570, 200);
		frame.add(transactionMessage);
		
		
		amountPaid = new JLabel("Amount Paid :    "+amount+" tk");
		amountPaid.setForeground(Color.BLACK);
		amountPaid.setFont(new Font("Segoe UI Black", Font.PLAIN, 15));
		amountPaid.setBounds(300, 200, 400, 100);
		frame.add(amountPaid);
		
		
		home= new JButton("Home");
		home.setBounds(250, 300, 100, 30);
		home.setFocusable(false);
		home.setForeground(Color.black);
		home.setBorder(BorderFactory.createDashedBorder(Color.green, 1, 5, 1, true));
		home.setCursor(new Cursor(Cursor.HAND_CURSOR));
		home.addActionListener(this);
		frame.add(home);
		
		
		exit= new JButton("Exit");
		exit.setBounds(350, 370, 100, 30);
		exit.setFocusable(false);
		exit.setForeground(Color.black);
		exit.setBorder(BorderFactory.createDashedBorder(Color.red, 1, 5, 1, true));
		exit.setCursor(new Cursor(Cursor.HAND_CURSOR));
		exit.setIcon(exitImage);
		exit.addActionListener(this);
		frame.add(exit);
		
		recipt= new JButton("Print Recipt");
		recipt.setBounds(450, 300, 100, 30);
		recipt.setFocusable(false);
		recipt.setForeground(Color.black);
		recipt.setBorder(BorderFactory.createDashedBorder(Color.cyan, 1, 5, 1, true));
		recipt.setCursor(new Cursor(Cursor.HAND_CURSOR));
		recipt.addActionListener(this);
		frame.add(recipt);
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 500);
		frame.setIconImage(framelogo.getImage());
		frame.getContentPane().setBackground(Color.decode("#F2F2F2"));
		frame.setResizable(false);
		frame.setLayout (null);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	public static void main(String[] args)
	{
		new PaymentSuccess(100.0,"Azminur");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==exit)
		{
			int a = JOptionPane.showConfirmDialog(null, "Do you want to exit?", "Exit Confirmation", 0);
			if(a==0)
			{
				System.exit(0);
			}
		}
	
		else if(e.getSource()==home)
		{
			new Home(f);
			frame.setVisible(false);
			
		}
		else if(e.getSource()==recipt)
		{
			
			try 
			{

				File newfile = new File("data\\Latest_Order.txt"); 
				Scanner sc = new Scanner(newfile);
				
				String line1 = null;
				String line2 = null;
				String line3 = null;
				String line4 = null;
				String line5 = null;
				String line6 = null;
				String line7 = null;
				String line8 = null;
				String line9 = null;
	
			while(sc.hasNext())
			{
				line1 = sc.nextLine();
				line2 = sc.nextLine();
				line3 = sc.nextLine();
				line4 = sc.nextLine();
				line5 = sc.nextLine();

			}
			sc.close();  
			File newfile2 = new File("data\\Latest Payment details.txt");
			Scanner sc2 = new Scanner(newfile2);
			while(sc2.hasNext())
			{
				line6 = sc2.nextLine();
				line7 = sc2.nextLine();
				line8 = sc2.nextLine();
				line9 = sc2.nextLine();

			}
			sc2.close();  
			File recipt = new File("data\\Recipt.doc"); 
			recipt.createNewFile();
			FileWriter writeFile = new FileWriter("data\\Recipt.doc");
			
			writeFile.write(line1+"\n"+
					line2+"\n"+
					line3+"\n"+
					line4+"\n"+
					line5+"\n        \n*************************\n        \n"+
					line6+"\n"+
					line7+"\n"+
					line8+"\n"+
					line9+"\n \n////////////////////////////\n \n"+
					"Thank You for your order.");
			
			writeFile.close();
			
			//newfile.delete();
			//newfile2.delete();
			
			JOptionPane.showMessageDialog(null, "Recipt printed here--"+recipt.getAbsolutePath());
	
			}
			catch(IOException io)
			{
				JOptionPane.showMessageDialog(null, "An error Occured and failed to create the file");
				return;
			}
		}
		
	}

}
