package classes;
import java.lang.*;
import interfaces.*;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class AdminLogin implements MouseListener, IAdminLogin
{
	private JFrame frame;
	private JLabel label1;
	private JLabel back1;
	private JLabel back2;
	private JButton aLogin;
	private JLabel userName;
	private JLabel userPass;
	private JTextField tfUName;
	private JPasswordField pfUPass;
	private User u1,u2;
	private User users[];
	
	public AdminLogin()
	{
		//frame
		frame = new JFrame("Admin Login");
		
		//icon
		ImageIcon framelogo = new ImageIcon("icons/framelogo.jpg");
		ImageIcon userNameImage = new ImageIcon("icons/username.png");
		ImageIcon UserPassImage = new ImageIcon("icons/userpass.png");
		
		Image background = new ImageIcon("icons/adminLogin.jpg").getImage().getScaledInstance(550, 550, Image.SCALE_AREA_AVERAGING);
		frame.setContentPane(new ImagePanel(background));
		
		
		Image image1 = new ImageIcon("icons/backicon.png").getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon back1Icon = new ImageIcon(image1);
		Image image2 = new ImageIcon("icons/backicon2.png").getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon back2Icon = new ImageIcon(image2);
		
		
		u1 = new User("azminur","22", "azminur");
		u2 = new User("admin","100", "admin");
		users = new User[2];
		users[0] = u1;
		users[1] = u2;
		
		
		label1 = new JLabel("Admin LogIn");
		label1.setForeground(Color.white);
		label1.setFont(new Font("Imprint MT Shadow",Font.PLAIN,25));
		label1.setBounds(200, 130, 200, 80);
		frame.add(label1);
		
		
		aLogin = new JButton("Admin In");
		aLogin.setBackground(Color.LIGHT_GRAY);
		aLogin.setFont(new Font("Segoe UI Black",Font.PLAIN,18));
		aLogin.setBounds(240, 340, 120, 30);
		aLogin.setCursor(new Cursor(Cursor.HAND_CURSOR));
		aLogin.addMouseListener(this);
		frame.add(aLogin);
		
		
		userName = new JLabel("Admin name: ");
		userName.setBounds(110, 240, 120, 30);
		userName.setFont(new Font("Calibri",Font.BOLD,16));
		userName.setIcon(userNameImage);
		userName.setForeground(Color.decode("#FFFF00"));
		frame.add(userName);
		
		
		userPass = new JLabel("Password: ");
		userPass.setBounds(110, 280, 100, 30);
		userPass.setFont(new Font("Calibri",Font.BOLD,16));
		userPass.setIcon(UserPassImage);
		userPass.setForeground(Color.decode("#FFFF00"));
		frame.add(userPass);
		
		
		tfUName = new JTextField();
		tfUName.setBounds(230, 240, 140, 23);
		tfUName.setBorder(BorderFactory.createLineBorder(Color.GREEN, 1));
		tfUName.setToolTipText("Enter your name here");
		frame.add(tfUName);
		
		
		pfUPass = new JPasswordField();
		pfUPass.setBounds(230, 280, 140, 23);
		pfUPass.setBorder(BorderFactory.createLineBorder(Color.GREEN, 1));
		pfUPass.setEchoChar('*');
		pfUPass.setToolTipText("Enter your password here");
		frame.add(pfUPass);
		
		
		back2 = new JLabel(back2Icon);
		back2.setBounds(250, 400, 50, 50);
		back2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		back2.addMouseListener(this);
		frame.add(back2);
		back2.setVisible(false);

		
		back1 = new JLabel(back1Icon);
		back1.setBounds(250, 400, 50, 50);
		back1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		back1.addMouseListener(this);
		frame.add(back1);
		

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(550, 585);
		frame.getContentPane().setBackground(Color.black);
		frame.setIconImage(framelogo.getImage());
		frame.setResizable(false);
		frame.setLayout (null);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
	}
	public User searchUser(String username)
	{
		User a = null;
		
		for(int i=0; i<users.length; i++)
	    {
			if(users[i]!=null)
			{
				if(users[i].getName().equals(username))
				{
					a = users[i];
	        		break;
	        	}
	    	}
	    }
	    return a;
	}
	
	/*public static void main(String[] args)
	{
		new AdminLogin();
	}*/

	@Override
	public void mouseClicked(MouseEvent e)
	{
		if (e.getSource()==aLogin)
		{
			String user = tfUName.getText();
			String pass = pfUPass.getText();
			int flag=0;
			if(user.isEmpty()==false && pass.isEmpty()==false)
			{
				for(int i = 0; i<users.length; i++)
				{
					if(users[i]!=null)
					{
						if(user.equals(users[i].getName()) && pass.equals(users[i].getPassword()))
						{
							flag = 1;
							break;
						}
					}
				}
				if (flag == 1)
				{
					User x= this.searchUser(user);
					new AdminHome(x);
					frame.setVisible(false);
				}
				else
				{
				JOptionPane.showMessageDialog(null, "Invalid Admin name or Password!");
				}
			}
			else
			{
			JOptionPane.showMessageDialog(null,"Admin Name & Password field can't be empty!");
			}
		}
		
		else if (e.getSource()==back2) 
		{
			new Login();
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
		if (e.getSource()==aLogin)
		{
			aLogin.setForeground(Color.blue);
		}
		
		else if (e.getSource()==back1) 
		{
			back2.setVisible(true);
		}		
	}

	@Override
	public void mouseExited(MouseEvent e)
	{
		if (e.getSource()==aLogin)
		{
			aLogin.setForeground(Color.black);
		}
		
		else if (e.getSource()==back1) 
		{
			back2.setVisible(false);
		}		
	}
}
