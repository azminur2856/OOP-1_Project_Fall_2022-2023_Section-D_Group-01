package classes;
import java.lang.*;
import interfaces.*;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Home implements ActionListener, IHome
{
	private JFrame frame;
	private JLabel iFood;
	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	private JLabel label4;
	private JLabel label5;
	//private JLabel uProfile;
	private JButton goAhead;
	private JMenuBar menuBar;  
	private JMenu users, setting, aboutUs;   
	private JMenuItem azminur, faculty, mehedi, tridib, profile, logout, changeBGColor;
	private String f="Azminur";
	
	public Home(String user)
	{
		f=user;
		
		frame = new JFrame("Home");
		
		ImageIcon framelogo = new ImageIcon("icons/framelogo.jpg");
		ImageIcon food = new ImageIcon("icons/food.png");
		ImageIcon profileImage = new ImageIcon("icons/admin.png");
		ImageIcon deliveryLogo = new ImageIcon("icons/delivery.png");
		ImageIcon emojiIcon = new ImageIcon("icons/emoji.png");
		
		azminur = new JMenuItem ("Project Leader");
		azminur.addActionListener(this);
		azminur.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		faculty = new JMenuItem ("Faculty");
		faculty.addActionListener(this);
		faculty.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		mehedi = new JMenuItem ("Project Member-1");
		mehedi.addActionListener(this);
		mehedi.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		tridib = new JMenuItem ("Project Member-2");
		tridib.addActionListener(this);
		tridib.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		profile = new JMenuItem ("Profile");
		profile.addActionListener(this);
		profile.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		logout = new JMenuItem ("Logout");
		logout.addActionListener(this);
		logout.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		changeBGColor = new JMenuItem("Change Background Color");
		changeBGColor.addActionListener(this);
		changeBGColor.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		
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
		
		aboutUs = new JMenu("Developer Information");
		aboutUs.setCursor(new Cursor(Cursor.HAND_CURSOR));
		aboutUs.setBorder(new EmptyBorder(0, 10, 0, 10));
		aboutUs.setForeground(Color.white);
		aboutUs.add(faculty);
		aboutUs.add(azminur);
		aboutUs.add(mehedi);
		aboutUs.add(tridib);
		
		
		menuBar = new JMenuBar();
		menuBar.add(users);
		menuBar.add(setting);
		menuBar.add(aboutUs);
		menuBar.setBackground(Color.black);
		menuBar.setBorder(BorderFactory.createEmptyBorder());
		frame.setJMenuBar(menuBar);
		
		
		iFood = new JLabel (food);
		iFood.setBounds(430, 50, 450, 450);
		frame.add(iFood);
		
		
		label1 = new JLabel("ORDER FRESH");
		label1.setBounds(30, 30, 300, 150);
		label1.setForeground(Color.white);
		label1.setFont(new Font("Lucida Console",Font.BOLD,28));
		frame.add(label1);
		
		
		label2 = new JLabel("  DAILY GOODS");
		label2.setBounds(30, 70, 300, 150);
		label2.setForeground(Color.white);
		label2.setFont(new Font("Lucida Console",Font.BOLD,28));
		frame.add(label2);
		
		
		label3 = new JLabel("    ANYTIME!!!");
		label3.setBounds(30, 110, 300, 150);
		label3.setForeground(Color.red);
		label3.setFont(new Font("Lucida Console",Font.BOLD,28));
		frame.add(label3);
		
		
		label4 = new JLabel(deliveryLogo);
		label4.setBounds(20, 300, 300, 200);
		frame.add(label4);
		
		
		label5 = new JLabel("EASY WAY TO ORDER DAILY GOODS");
		label5.setIcon(emojiIcon);
		label5.setBounds(30, 10, 250, 100);
		label5.setForeground(Color.white);
		label5.setFont(new Font("Lucida Console",Font.PLAIN,10));
		frame.add(label5);
		
		//profile show
		//uProfile = new JLabel (user);
		//uProfile.setBounds(800, 0, 80, 20);
		//uProfile.setForeground(Color.black);
		//uProfile.setBackground(Color.white);
		//uProfile.setHorizontalAlignment(JLabel.CENTER);
		//uProfile.setOpaque(true);
		//uProfile.setIcon(profileImage);
		//frame.add(uProfile);
		
		
		goAhead= new JButton("Go Ahead =>>>");
		goAhead.setBounds(240, 250, 150, 30);
		goAhead.setFocusable(false);
		goAhead.setBackground(Color.black);
		goAhead.setForeground(Color.white);
		goAhead.setBorder(BorderFactory.createDashedBorder(Color.red, 1.9F, 5, 1, true));
		goAhead.setCursor(new Cursor(Cursor.HAND_CURSOR));
		goAhead.addActionListener(this);
		frame.add(goAhead);
		
		
		frame.setIconImage(framelogo.getImage());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(900,600);
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setLayout (null);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	//public static void main (String [] args)
	//{
	//	new Home("Azminur");
	//}

	@Override
	public void actionPerformed(ActionEvent e) {
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
		}
		else if(e.getSource()==goAhead)
		{
			new AllItem(f);
			frame.setVisible(false);
		}
		else if(e.getSource()==profile)
		{
			new UProfile(f);
			//frame.setVisible(false);
		}
	
		
		else if(e.getSource()==azminur)
		{
			new AzminurProfile(f);
			frame.setVisible(false);
		}
		else if(e.getSource()==faculty)
		{
			new FacultyProfile(f);
			frame.setVisible(false);
		}
		else if(e.getSource()==mehedi)
		{
			new MehediProfile(f);
			frame.setVisible(false);
		}
		else if(e.getSource()==tridib)
		{
			new TridibProfile(f);
			frame.setVisible(false);
		}
		
	}
}


