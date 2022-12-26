package classes;
import java.lang.*;
import interfaces.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.swing.*;

public class Login implements ActionListener,ILogin
{
	private JFrame frame;
	private JButton loginButton1;
	private JButton loginButton2;
	private JButton signUpButton1;
	private JButton forgotPassword;
	private JButton exitButton;
	private JButton adminButton;
	private JButton previous0;
	private JLabel userName;
	private JLabel userPass;
	private JTextField tfUName;
	private JPasswordField pfUPass;
	
	public Login()
	{
		//frame
		frame = new JFrame("Login");
		
		//icon 
		ImageIcon framelogo = new ImageIcon("icons/framelogo.jpg");
		ImageIcon loginImage = new ImageIcon("icons/login.png");
		ImageIcon signupImage = new ImageIcon("icons/signup.png");
		ImageIcon adminImage = new ImageIcon("icons/admin.png");
		ImageIcon userNameImage = new ImageIcon("icons/username.png");
		ImageIcon UserPassImage = new ImageIcon("icons/userpass.png");
		ImageIcon previousImage = new ImageIcon("icons/previous.png");
		ImageIcon forgotImage = new ImageIcon("icons/forgotLogo.png");
		ImageIcon exitImage = new ImageIcon("icons/exiticon.png");
		
		//background
		Image background = new ImageIcon("icons/mainBackground.jpg").getImage().getScaledInstance(800, 550, Image.SCALE_AREA_AVERAGING);
		frame.setContentPane(new ImagePanel(background));
		
		//userLogin
		loginButton1= new JButton("User Login");
		loginButton1.setBounds(300, 340, 100, 30);
		loginButton1.setFocusable(false);
		loginButton1.setBackground(Color.LIGHT_GRAY);
		loginButton1.setBorder(BorderFactory.createRaisedSoftBevelBorder());
		loginButton1.setIcon(loginImage);
		loginButton1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		loginButton1.addActionListener(this);
		frame.add(loginButton1);
		
		//signUp
		signUpButton1 = new JButton("Sign up");
		signUpButton1.setBounds(420, 340, 100, 30);
		signUpButton1.setFocusable(false);
		signUpButton1.setBackground(Color.LIGHT_GRAY);
		signUpButton1.setBorder(BorderFactory.createRaisedSoftBevelBorder());
		signUpButton1.setIcon(signupImage);
		signUpButton1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		signUpButton1.addActionListener(this);
		frame.add(signUpButton1);
		
		//forgotPassword
		forgotPassword = new JButton("Forgot Password?");
		forgotPassword.setBounds(300, 390, 220, 30);
		forgotPassword.setFocusable(false);
		forgotPassword.setBackground(Color.LIGHT_GRAY);
		forgotPassword.setBorder(BorderFactory.createRaisedSoftBevelBorder());
		forgotPassword.setIcon(forgotImage);
		forgotPassword.setCursor(new Cursor(Cursor.HAND_CURSOR));
		forgotPassword.addActionListener(this);
		frame.add(forgotPassword);
		
		//exit
		exitButton = new JButton("Exit");
		exitButton.setBounds(360, 440, 80, 30);
		exitButton.setFocusable(false);
		exitButton.setBackground(Color.LIGHT_GRAY);
		exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		exitButton.setBorder(BorderFactory.createRaisedSoftBevelBorder());
		exitButton.setIcon(exitImage);
		exitButton.addActionListener(this);
		frame.add(exitButton);
		
		//uname
		userName = new JLabel("Username:* ");
		userName.setBounds(260, 220, 110, 30);
		userName.setFont(new Font("Calibri",Font.BOLD,16));
		userName.setIcon(userNameImage);
		userName.setForeground(Color.black);
		userName.setVisible(false);
		frame.add(userName);
		
		//upassword
		userPass = new JLabel("Password:* ");
		userPass.setBounds(260, 260, 110, 30);
		userPass.setFont(new Font("Calibri",Font.BOLD,16));
		userPass.setIcon(UserPassImage);
		userPass.setForeground(Color.black);
		userPass.setVisible(false);
		frame.add(userPass);
		
		//uname
		tfUName = new JTextField();
		tfUName.setBounds(380, 220, 140, 23);
		tfUName.setBorder(BorderFactory.createLineBorder(Color.GREEN, 1));
		tfUName.setToolTipText("Enter your name here");
		tfUName.setVisible(false);
		frame.add(tfUName);
		
		//upassword
		pfUPass = new JPasswordField();
		pfUPass.setBounds(380, 260, 140, 23);
		pfUPass.setBorder(BorderFactory.createLineBorder(Color.GREEN, 1));
		pfUPass.setEchoChar('*');
		pfUPass.setToolTipText("Enter your password here");
		pfUPass.setVisible(false);
		frame.add(pfUPass);
	
		//login
		loginButton2= new JButton("Login");
		loginButton2.setBounds(300, 380, 80, 30);
		loginButton2.setFocusable(false);
		loginButton2.setBackground(Color.LIGHT_GRAY);
		loginButton2.setBorder(BorderFactory.createRaisedSoftBevelBorder());
		loginButton2.setIcon(loginImage);
		loginButton2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		loginButton2.addActionListener(this);
		loginButton2.setVisible(false);
		frame.add(loginButton2);
		
		//previous
		previous0 = new JButton ("Back");
		previous0.setBounds(420, 380, 80, 30);
		previous0.setFocusable(false);
		previous0.setBackground(Color.LIGHT_GRAY);
		previous0.setBorder(BorderFactory.createRaisedSoftBevelBorder());
		previous0.addActionListener(this);
		previous0.setCursor(new Cursor(Cursor.HAND_CURSOR));
		previous0.setIcon(previousImage);
		previous0.setVisible(false);
		frame.add(previous0);
		
		//adminLogin
		adminButton = new JButton("Admin");
		adminButton.setBounds(715, 0, 70, 20);
		adminButton.setFocusable(false);
		adminButton.setBackground(Color.red);
		adminButton.setBorder(BorderFactory.createLoweredSoftBevelBorder());
		adminButton.setIcon(adminImage);
		adminButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		adminButton.addActionListener(this);
		frame.add(adminButton);
		
		//frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 550);
		frame.setIconImage(framelogo.getImage());
		frame.setResizable(false);
		frame.setLayout (null);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==loginButton1)
		{
			signUpButton1.setVisible(false);
			loginButton1.setVisible(false);
			forgotPassword.setVisible(false);
			loginButton2.setVisible(true);
			userName.setVisible(true);
			userPass.setVisible(true);
			tfUName.setVisible(true);
			pfUPass.setVisible(true);
			previous0.setVisible(true);
			tfUName.setText(null);
			pfUPass.setText(null);
		}
		
		else if(e.getSource()==signUpButton1)
		{
			
			new SignUp();
			frame.setVisible(false);
			
		}
		
		else if (e.getSource()==previous0)
		{
			loginButton1.setVisible(true);
			loginButton2.setVisible(false);
			userName.setVisible(false);
			userPass.setVisible(false);
			tfUName.setVisible(false);
			pfUPass.setVisible(false);
			previous0.setVisible(false);
			signUpButton1.setVisible(true);
			forgotPassword.setVisible(true);
		}
		
		else if(e.getSource()==exitButton)
		{
			int a = JOptionPane.showConfirmDialog(null, "Do you want to exit?", "Exit Confirmation", 0);
			if(a==0)
			{
				System.exit(0);
			}
		}
		
		else if(e.getSource()==loginButton2)
		{  
			String user = tfUName.getText();
			String pass = pfUPass.getText();
            if (user.isEmpty()|| pass.isEmpty()) 
            {
                JOptionPane.showMessageDialog(null, "Please fill all of the fields.", "Warning!",
                        JOptionPane.WARNING_MESSAGE);
            }
            
            
            else
			{

                try
				{
                    String userNameS = "User Name : " + user;
                    String passwordS = "Password : " + pass;
                    BufferedReader reader = new BufferedReader(new FileReader("data\\.user_data.txt"));

                    int totalLines = 0;
                    while (reader.readLine() != null)
                        totalLines++;
                    reader.close();

                    for (int i = 0; i <= totalLines; i++)
					{
                        String line = Files.readAllLines(Paths.get("data\\.user_data.txt")).get(i);
                        if (line.equals(userNameS))
						{
                            String line2 = Files.readAllLines(Paths.get("data\\.user_data.txt")).get((i + 1));
                            if (line2.equals(passwordS))
							{
                                new Home(user);
								frame.setVisible(false);
                                break;
                            }
                        }
                    }
                } 
                catch (Exception ex)
				{
                    JOptionPane.showMessageDialog(null, "Invalid User Name or Password!", "Warning!",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
            
        }
		
		else if(e.getSource()==forgotPassword)
		{
			new ForgotPassword();
			frame.setVisible(false);
		}
		
		else if(e.getSource()==adminButton)
		{
			new AdminLogin();
			frame.setVisible(false);
		}	
	}	
}
