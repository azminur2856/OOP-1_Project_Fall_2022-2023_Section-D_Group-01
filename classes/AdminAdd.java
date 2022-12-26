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
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class AdminAdd implements ActionListener, MouseListener, IAdminAdd
{
	private JFrame frame;
	private JLabel back1;
	private JLabel back2;
	private JLabel label1;
	private JLabel userName;
	private JLabel userPass;
	private JLabel email;
	private JTextField tfUName;
	private JPasswordField pfUPass;
	private JTextField tfemail;
	private JButton addUser;
	
	private User x;
	
	public AdminAdd(User a)
	{
		x=a;
		
		frame = new JFrame("Admin Add");
		
		ImageIcon framelogo = new ImageIcon("icons/framelogo.jpg");
		ImageIcon userNameImage = new ImageIcon("icons/username.png");
		ImageIcon UserPassImage = new ImageIcon("icons/userpass.png");
		ImageIcon EmailImage = new ImageIcon("icons/email.png");
		ImageIcon addImage = new ImageIcon("icons/adduser.png");
		
		Image background = new ImageIcon("icons/adminAddBG.png").getImage().getScaledInstance(465, 550, Image.SCALE_SMOOTH);
		frame.setContentPane(new ImagePanel(background));
		
		Image image1 = new ImageIcon("icons/backicon.png").getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon back1Icon = new ImageIcon(image1);
		
		Image image2 = new ImageIcon("icons/backicon2.png").getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon back2Icon = new ImageIcon(image2);
		
		
		back2 = new JLabel(back2Icon);
		back2.setBounds(200, 390, 50, 50);
		back2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		back2.addMouseListener(this);
		frame.add(back2);
		back2.setVisible(false);

		
		back1 = new JLabel(back1Icon);
		back1.setBounds(200, 390, 50, 50);
		back1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		back1.addMouseListener(this);
		frame.add(back1);
		
		
		label1 = new JLabel();
		label1.setText("Add User");
	    	label1.setBounds(170, 70, 250, 60);
		label1.setFont(new Font("Segoe UI Black", Font.BOLD, 25));
		frame.add(label1);
		
		
		userName = new JLabel("Username:* ");
		userName.setBounds(100, 180, 110, 30);
		userName.setFont(new Font("Calibri",Font.BOLD,16));
		userName.setIcon(userNameImage);
		userName.setForeground(Color.black);
		frame.add(userName);
		
		
		userPass = new JLabel("Password:* ");
		userPass.setBounds(100, 220, 110, 30);
		userPass.setFont(new Font("Calibri",Font.BOLD,16));
		userPass.setIcon(UserPassImage);
		userPass.setForeground(Color.black);
		frame.add(userPass);
		
		email = new JLabel("Email:* ");
		email.setBounds(100, 260, 110, 30);
		email.setFont(new Font("Calibri",Font.BOLD,16));
		email.setForeground(Color.black);
		email.setIcon(EmailImage);
		frame.add(email);
		
		
		tfUName = new JTextField();
		tfUName.setBounds(210, 180, 140, 23);
		tfUName.setBorder(BorderFactory.createLineBorder(Color.GREEN, 1));
		tfUName.setToolTipText("Enter your name here");
		frame.add(tfUName);
		
		
		pfUPass = new JPasswordField();
		pfUPass.setBounds(210, 220, 140, 23);
		pfUPass.setBorder(BorderFactory.createLineBorder(Color.GREEN, 1));
		pfUPass.setEchoChar('*');
		pfUPass.setToolTipText("Enter your password here");
		frame.add(pfUPass);
		
		
	    	tfemail = new JTextField();
		tfemail.setBounds(210, 260, 140, 23);
		tfemail.setBorder(BorderFactory.createLineBorder(Color.GREEN, 1));
		tfemail.setToolTipText("Your Email Address?");
		frame.add(tfemail);
		
		
		addUser= new JButton("Add User");
		addUser.setBounds(180, 340, 100, 30);
		addUser.setFocusable(false);
		addUser.setBackground(Color.LIGHT_GRAY);
		addUser.setBorder(BorderFactory.createEtchedBorder());
		addUser.setIcon(addImage);
		addUser.setCursor(new Cursor(Cursor.HAND_CURSOR));
		addUser.addActionListener(this);
		addUser.addMouseListener(this);
		frame.add(addUser);
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(480, 600);
		frame.setIconImage(framelogo.getImage());
		frame.setResizable(false);
		frame.setLayout (null);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
	}


	@Override
	public void mouseClicked(MouseEvent e)
	{
		if (e.getSource()==back2) 
		{
			new UserData(x);
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
		if (e.getSource()==back1) 
		{
			back2.setVisible(true);
		}
		else if (e.getSource()==addUser) 
		{
			addUser.setBackground(Color.GREEN);
			addUser.setForeground(Color.white);
		}
		
	}

	@Override
	public void mouseExited(MouseEvent e)
	{
		if (e.getSource()==back1) 
		{
			back2.setVisible(false);
		}
		else if (e.getSource()==addUser) 
		{
			addUser.setBackground(Color.LIGHT_GRAY);
			addUser.setForeground(Color.black);
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource()==addUser) 
		{
			String textField1 = tfUName.getText();
            String textField2 = pfUPass.getText();
            String textField3 = tfemail.getText();

            if (textField1.isEmpty() || textField2.isEmpty() || textField3.isEmpty()) 
            {
                JOptionPane.showMessageDialog(null, "Please fill all of the fields.", "Warning!",JOptionPane.WARNING_MESSAGE);
            } 
            else 
            {

                try
				{
                    File file = new File("data\\.user_data.txt");
                    if (!file.exists())
					{
                        file.createNewFile();
                    }
                    FileWriter fw = new FileWriter(file, true);
                    BufferedWriter bw = new BufferedWriter(fw);
                    PrintWriter pw = new PrintWriter(bw);

                    LocalDateTime myDateObj = LocalDateTime.now();
                    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("HH:mm a, dd/MM/yyyy");

                    String timeAndDate = myDateObj.format(myFormatObj);

                    pw.println("             ## Added by Admin ##");
                    pw.println("User Name : " + textField1);
                    pw.println("Password : " + textField2);
                    pw.println("Email : " + textField3);
                    pw.println("Time & Date : " + timeAndDate);
                    pw.println("==================================================");
                    pw.println("==~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~==");
                    pw.println("==================================================");
                    pw.close();

                } 
                catch (Exception ex) 
                {
                    System.out.print(ex);
                }

                JOptionPane.showMessageDialog(null, "User has been added.", "User Added",JOptionPane.INFORMATION_MESSAGE);
                //frame.setVisible(false);
                //new UserData(x);
				tfUName.setText(null);
                pfUPass.setText(null);
                tfemail.setText(null);
            }
			
		}
		
	}

}
