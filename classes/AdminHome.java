package classes;
import java.lang.*;
import interfaces.*;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JOptionPane;

public class AdminHome implements ActionListener, MouseListener, IAdminHome
{
	private JFrame frame;
	private JLabel label1;
	private JButton userData;
	private JButton previous0;
	private JButton exitButton;
	private JTextArea display;
	private User x;
	
	public AdminHome(User a)
	{
		x=a;
		
		frame = new JFrame("Admin Home");
		
		ImageIcon framelogo = new ImageIcon("icons/framelogo.jpg");
		ImageIcon previousImage = new ImageIcon("icons/previous.png");
		ImageIcon exitImage = new ImageIcon("icons/exiticon.png");
		
		Image background = new ImageIcon("icons/adminPanelBackground.jpg").getImage().getScaledInstance(950, 550, Image.SCALE_SMOOTH);
		frame.setContentPane(new ImagePanel(background));
		
		Image image1 = new ImageIcon("icons/adminSetting.png").getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
		ImageIcon adminImage = new ImageIcon(image1);
		
		
		label1 = new JLabel("Admin Panel");
		label1.setForeground(Color.white);
		label1.setIcon(adminImage);
		label1.setVerticalTextPosition(JLabel.BOTTOM);
		label1.setHorizontalTextPosition(JLabel.CENTER);
		label1.setFont(new Font("Imprint MT Shadow",Font.BOLD,25));
		label1.setBounds(290, 00, 400, 300);
		frame.add(label1);
		
		
		userData= new JButton("User Data");
		userData.setFont(new Font("Calibri Light (Headings)", Font.BOLD, 15));
		userData.setBounds(300, 380, 100, 30);
		userData.setFocusable(false);
		userData.setBackground(Color.LIGHT_GRAY);
		userData.setCursor(new Cursor(Cursor.HAND_CURSOR));
		userData.setBorder(BorderFactory.createEtchedBorder());
		userData.addActionListener(this);	
		userData.addMouseListener(this);
		frame.add(userData);
		
	
		previous0 = new JButton ("Back");
		previous0.setFont(new Font("Calibri Light (Headings)", Font.BOLD, 15));
		previous0.setBounds(420, 380, 100, 30);
		previous0.setFocusable(false);
		previous0.setBackground(Color.LIGHT_GRAY);
		previous0.setCursor(new Cursor(Cursor.HAND_CURSOR));
		previous0.setBorder(BorderFactory.createRaisedSoftBevelBorder());
		previous0.addActionListener(this);
		previous0.addMouseListener(this);
		previous0.setIcon(previousImage);
		frame.add(previous0);
		
		
		exitButton = new JButton("Exit");
		exitButton.setFont(new Font("Calibri Light (Headings)", Font.BOLD, 15));
		exitButton.setBounds(360, 440, 100, 30);
		exitButton.setFocusable(false);
		exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		exitButton.setBackground(Color.LIGHT_GRAY);
		exitButton.setBorder(BorderFactory.createRaisedSoftBevelBorder());
		exitButton.addActionListener(this);
		exitButton.addMouseListener(this);
		exitButton.setIcon(exitImage);
		frame.add(exitButton);
		
		
		display = new JTextArea (5, 5);
		display.setBounds(10,20,270,250);
		display.setBackground(Color.black);
		display.setForeground(Color.white);
		display.setFont(new Font("Times New Roman",Font.BOLD,19));
		String name= a.getName();
		String age = a.getAge();
		String pass = a.getPassword();
		display.setText("Admin Name: "+name+"\n\nAdmin Age: "+age);
		display.setEditable(false);
		frame.add(display);
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(850, 550);
		frame.setIconImage(framelogo.getImage());
		frame.setResizable(false);
		frame.setLayout (null);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}


	@Override
	public void mouseClicked(MouseEvent e)
	{
		
	}

	@Override
	public void mousePressed(MouseEvent e)
	{
		
	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
		
	}


	@Override
	public void mouseEntered(MouseEvent e)
	{
		if (e.getSource()==userData)
		{
			userData.setBackground(Color.green);
			userData.setForeground(Color.white);
		}
		else if (e.getSource()==exitButton)
		{
			exitButton.setBackground(Color.red);
			exitButton.setForeground(Color.white);
		}
		else if (e.getSource()==previous0)
		{
			previous0.setBackground(Color.blue);
			previous0.setForeground(Color.white);
		}	
	}


	@Override
	public void mouseExited(MouseEvent e)
	{
		if (e.getSource()==userData)
		{
			userData.setBackground(Color.LIGHT_GRAY);
			userData.setForeground(Color.black);
		}
		else if (e.getSource()==exitButton)
		{
			exitButton.setBackground(Color.LIGHT_GRAY);
			exitButton.setForeground(Color.black);
		}
		else if (e.getSource()==previous0)
		{
			previous0.setBackground(Color.LIGHT_GRAY);
			previous0.setForeground(Color.black);
		}	
		
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==exitButton)
		{
			int a = JOptionPane.showConfirmDialog(null, "Do you want to exit?", "Exit Confirmation", 0);
			if(a==0)
			{
				System.exit(0);
			}
		}
		else if (e.getSource()==previous0)
		{
			new AdminLogin();
			frame.setVisible(false);
		}
		else if (e.getSource()==userData)
		{
			new UserData(x);
			frame.setVisible(false);
		}
		
	}

}
