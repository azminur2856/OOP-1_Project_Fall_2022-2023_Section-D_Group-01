package classes;
import java.lang.*;
import interfaces.*;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.border.EmptyBorder;

public class AllItem implements ActionListener, MouseListener, IAllItem
{
	private JFrame frame;
	
	private JLabel rice;
	private JLabel dal;
	private JLabel meat;
	private JLabel fish;
	private JLabel egg;
	private JLabel vegetable;
	
	private JButton goBack;
	
	private JMenuBar menuBar;  
	private JMenu users, setting;
	private JMenuItem profile, logout, changeBGColor;
	
	private String f ="Azminur";
	
	public AllItem (String user)
	{
		f=user;
		frame = new JFrame("Available Items");
		
		
		//rice
		ImageIcon framelogo = new ImageIcon("icons/framelogo.jpg");
		Image image1 = new ImageIcon("icons/rice.png").getImage().getScaledInstance(240, 180, Image.SCALE_DEFAULT);
		ImageIcon riceLogo = new ImageIcon(image1);
		rice = new JLabel("RICE");
		rice.setIcon(riceLogo);
		rice.setForeground(Color.WHITE);
		rice.setVerticalTextPosition(JLabel.BOTTOM);
		rice.setHorizontalTextPosition(JLabel.CENTER);
		rice.setCursor(new Cursor(Cursor.HAND_CURSOR));
		rice.setFont(new Font("Lucida Console",Font.PLAIN,20));
		rice.addMouseListener(this);
		frame.add(rice);
		
		//dal
		Image image2 = new ImageIcon("icons/dal.png").getImage().getScaledInstance(240, 180, Image.SCALE_DEFAULT);
		ImageIcon dalLogo = new ImageIcon(image2);
		dal = new JLabel("DAL");
		dal.setIcon(dalLogo);
		dal.setForeground(Color.WHITE);
		dal.setVerticalTextPosition(JLabel.BOTTOM);
		dal.setHorizontalTextPosition(JLabel.CENTER);
		dal.setCursor(new Cursor(Cursor.HAND_CURSOR));
		dal.setFont(new Font("Lucida Console",Font.PLAIN,20));
		dal.addMouseListener(this);
		frame.add(dal);
		
		//meat
		Image image3 = new ImageIcon("icons/meat.png").getImage().getScaledInstance(240, 180, Image.SCALE_DEFAULT);
		ImageIcon meatLogo = new ImageIcon(image3);
		meat = new JLabel("MEAT");
		meat.setIcon(meatLogo);
		meat.setForeground(Color.WHITE);
		meat.setVerticalTextPosition(JLabel.BOTTOM);
		meat.setHorizontalTextPosition(JLabel.CENTER);
		meat.setCursor(new Cursor(Cursor.HAND_CURSOR));
		meat.setFont(new Font("Lucida Console",Font.PLAIN,20));
		meat.addMouseListener(this);
		frame.add(meat);
		
		//fish
		Image image4 = new ImageIcon("icons/fish.png").getImage().getScaledInstance(240, 180, Image.SCALE_DEFAULT);
		ImageIcon fishLogo = new ImageIcon(image4);
		fish = new JLabel("FISH");
		fish.setIcon(fishLogo);
		fish.setForeground(Color.WHITE);
		fish.setVerticalTextPosition(JLabel.BOTTOM);
		fish.setHorizontalTextPosition(JLabel.CENTER);
		fish.setCursor(new Cursor(Cursor.HAND_CURSOR));
		fish.setFont(new Font("Lucida Console",Font.PLAIN,20));
		fish.addMouseListener(this);
		frame.add(fish);
		
		//egg
		Image image5 = new ImageIcon("icons/egg.png").getImage().getScaledInstance(240, 180, Image.SCALE_DEFAULT);
		ImageIcon eggLogo = new ImageIcon(image5);
		egg = new JLabel("EGG");
		egg.setIcon(eggLogo);
		egg.setForeground(Color.WHITE);
		egg.setVerticalTextPosition(JLabel.BOTTOM);
		egg.setHorizontalTextPosition(JLabel.CENTER);
		egg.setCursor(new Cursor(Cursor.HAND_CURSOR));
		egg.setFont(new Font("Lucida Console",Font.PLAIN,20));
		egg.addMouseListener(this);
		frame.add(egg);
		
		//vegetable
		Image image6 = new ImageIcon("icons/vegetable.png").getImage().getScaledInstance(240, 180, Image.SCALE_DEFAULT);
		ImageIcon vegetableLogo = new ImageIcon(image6);
		vegetable = new JLabel("VEGETABLE");
		vegetable.setIcon(vegetableLogo);
		vegetable.setForeground(Color.WHITE);
		vegetable.setVerticalTextPosition(JLabel.BOTTOM);
		vegetable.setHorizontalTextPosition(JLabel.CENTER);
		vegetable.setCursor(new Cursor(Cursor.HAND_CURSOR));
		vegetable.setFont(new Font("Lucida Console",Font.PLAIN,20));
		vegetable.addMouseListener(this);
		frame.add(vegetable);


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
	
		
		frame.setIconImage(framelogo.getImage());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(900,600);
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setLayout (new GridLayout(2,3));
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	public static void main (String [] args)
	{
		new AllItem("Azminur");
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
		}
		
		else if(e.getSource()==profile)
		{
			//frame.setVisible(false);
			new UProfile(f);
		}
		
		else if (e.getSource()==goBack)
		{
			new Home (f);
			frame.setVisible(false);
		}
		
	}
	
	@Override
	public void mouseClicked(MouseEvent e)
	{
		if(e.getSource()==rice)
		{
			new Rice(f);
			frame.setVisible(false);
			
		}
		
		else if(e.getSource()==dal)
		{
			new Dal(f);
			frame.setVisible(false);
			
		}
		
		else if(e.getSource()==meat)
		{
			new Meat(f);
			frame.setVisible(false);
			
		}
		
		else if(e.getSource()==fish)
		{
			new Fish(f);
			frame.setVisible(false);
			
		}
		
		else if(e.getSource()==egg)
		{
			new Egg(f);
			frame.setVisible(false);
			
		}
		
		else if(e.getSource()==vegetable)
		{
			new Vegetable(f);
			frame.setVisible(false);
			
		}
	
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
		if(e.getSource()==rice)
			{
			rice.setForeground(Color.red);
			}
		
		else if(e.getSource()==dal)
			{
			dal.setForeground(Color.red);
			}
		
		else if(e.getSource()==meat)
			{
			meat.setForeground(Color.red);
			}
		
		else if(e.getSource()==fish)
			{
			fish.setForeground(Color.red);
			}
		
		else if(e.getSource()==egg)
			{
			egg.setForeground(Color.red);
			}
		else if(e.getSource()==vegetable)
			{
			vegetable.setForeground(Color.red);
			}
		
	}
			
	@Override
	public void mouseExited(MouseEvent e)
	{
		rice.setForeground(Color.white);
		dal.setForeground(Color.white);
		meat.setForeground(Color.white);
		fish.setForeground(Color.white);
		egg.setForeground(Color.white);
		vegetable.setForeground(Color.white);
	}

}
