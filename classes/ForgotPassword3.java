package classes;
import java.lang.*;
import interfaces.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import java.io.*;
import java.nio.file.*;
import classes.*;

public class ForgotPassword3 implements ActionListener, IForgotPassword3
{
    private JFrame frame;
    private JLabel newPasslabel;
    private JLabel confpasslabel;
    private JPasswordField newPass;
    private JPasswordField confpass;
    private JButton next2;
    private JButton exitButton;
    private JButton backButton;
    private JToggleButton toggleButton;
    private JToggleButton toggleButton2;

    private ImageIcon on;
    private ImageIcon off;
    private Container c;
    private ImageIcon forgotUser;
    private Cursor cursor;
    protected static boolean loginFlag;
    protected static String USERNAME;
    private int totalLines;

    public ForgotPassword3()
	{
        frame = new JFrame();
        frame.setBounds(50, 50, 850, 550);
        frame.setTitle("Reset Password");
		frame.setResizable(false);
        frame.setLayout(null);
        frame.setVisible(true);
        c = frame.getContentPane();
        c.setBackground(Color.decode("#000000"));
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon icon = new ImageIcon("icons/framelogo.jpg");
        frame.setIconImage(icon.getImage());
        frame.setLocationRelativeTo(null);

        cursor = new Cursor(Cursor.HAND_CURSOR);

        JLabel forget = new JLabel("Reset Password");
        forget.setBounds(365, 0, 200, 50);
        Font forgetFont = new Font("Times New Roman", Font.PLAIN, 22);
        forget.setFont(forgetFont);
        forget.setForeground(Color.white);
        frame.add(forget);

        forgotUser = new ImageIcon("icons/forgot_user3.png");
        JLabel imgLabel = new JLabel(forgotUser);
        imgLabel.setBounds(2, 130, forgotUser.getIconWidth(), forgotUser.getIconHeight());
        frame.add(imgLabel);

        newPasslabel = new JLabel("New Password :");
        newPasslabel.setBounds(385, 230, 180, 50);
        Font newPassFont = new Font("Verdana", Font.PLAIN, 18);
        newPasslabel.setFont(newPassFont);
        newPasslabel.setVisible(true);
        newPasslabel.setForeground(Color.white);
        frame.add(newPasslabel);

        newPass = new JPasswordField();
        newPass.setBounds(575, 242, 180, 30);
        Font newPasslFont = new Font("Monospace", Font.BOLD, 18);
        newPass.setFont(newPasslFont);
        newPass.setVisible(true);
        newPass.setOpaque(false);
        newPass.setForeground(new Color(219, 226, 233));
        newPass.setBorder(BorderFactory.createEmptyBorder());
        Border redBorder2 = BorderFactory.createMatteBorder(2, 2, 2, 0, new Color(179, 63, 64));
        newPass.setBorder(redBorder2);
        newPass.setEchoChar('*');
        frame.add(newPass);

        confpasslabel = new JLabel("Confirm Password :");
        confpasslabel.setBounds(385, 266, 190, 50);
        Font confpasslabelFont = new Font("Verdana", Font.PLAIN, 18);
        confpasslabel.setFont(confpasslabelFont);
        confpasslabel.setForeground(Color.white);
        confpasslabel.setVisible(true);
        frame.add(confpasslabel);

        confpass = new JPasswordField();
        confpass.setBounds(575, 278, 180, 30);
        Font confpassFont = new Font("Monospace", Font.BOLD, 18);
        confpass.setFont(confpassFont);
        confpass.setOpaque(false);
        confpass.setForeground(new Color(219, 226, 233));
        confpass.setBorder(BorderFactory.createEmptyBorder());
        Border redBorder3 = BorderFactory.createMatteBorder(2, 2, 2, 0, new Color(179, 63, 64));
        confpass.setBorder(redBorder3);
        confpass.setVisible(true);
        confpass.setEchoChar('*');
        frame.add(confpass);

        ImageIcon fnext = new ImageIcon("icons/fnext.png");
        next2 = new JButton(fnext);
        next2.setBounds(752, 316, 45, 45);
        next2.setBackground(new Color(0, 0, 0, 0));
        next2.setOpaque(false);
        next2.setBorder(BorderFactory.createEmptyBorder());
        next2.setCursor(cursor);
        next2.setVisible(true);
        frame.add(next2);

        ImageIcon exit = new ImageIcon("icons/exiticon1.png");
        exitButton = new JButton(exit);
        exitButton.setBounds(770, 450, exit.getIconWidth(), exit.getIconHeight());
        exitButton.setBackground(Color.black);
        exitButton.setOpaque(false);
        exitButton.setBorder(BorderFactory.createEmptyBorder());
		exitButton.setCursor(cursor);
        frame.add(exitButton);

        ImageIcon backimg = new ImageIcon("icons/backicon2.png");
        backButton = new JButton(backimg);
        backButton.setBounds(15, 450, backimg.getIconWidth(), backimg.getIconHeight());
        backButton.setBackground(Color.black);
        backButton.setOpaque(false);
        backButton.setBorder(BorderFactory.createEmptyBorder());
		backButton.setCursor(cursor);
        frame.add(backButton);

        on = new ImageIcon("icons/tg1.png");
        off = new ImageIcon("icons/tg2.png");
        toggleButton = new JToggleButton(off);
        toggleButton.setBounds(755, 278, 35, 30);
        toggleButton.setBackground(new Color(0, 0, 0, 0));
        toggleButton.setForeground(new Color(0, 0, 0, 0));
        toggleButton.setOpaque(false);
        toggleButton.setBorder(BorderFactory.createEmptyBorder());
        Border redBorder5 = BorderFactory.createMatteBorder(2, 0, 2, 2, new Color(179, 63, 64));
        toggleButton.setBorder(redBorder5);
        frame.add(toggleButton);

        toggleButton2 = new JToggleButton(off);
        toggleButton2.setBounds(755, 242, 35, 30);
        toggleButton2.setBackground(new Color(0, 0, 0, 0));
        toggleButton2.setForeground(new Color(0, 0, 0, 0));
        toggleButton2.setOpaque(false);
        toggleButton2.setBorder(BorderFactory.createEmptyBorder());
        Border redBorder6 = BorderFactory.createMatteBorder(2, 0, 2, 2, new Color(179, 63, 64));
        toggleButton2.setBorder(redBorder6);
        frame.add(toggleButton2);

        toggleButton.addActionListener(this);
        toggleButton2.addActionListener(this);
        next2.addActionListener(this);
        backButton.addActionListener(this);
        exitButton.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e)
	{

        boolean yes = false;
        if (e.getSource() == next2)
		{
            try 
			{
                File userfile = new File(".\\data\\.user_data.txt");
                if (userfile.exists()) 
				{
                    BufferedReader readFile = new BufferedReader(new FileReader(".\\data\\.user_data.txt"));

                    while (readFile.readLine() != null) 
					{
                        totalLines++;
                    }
                    readFile.close();
                }

                String newpass1 = newPass.getText();
                String newpass2 = "Password : " + newPass.getText();
                boolean newpass3 = newpass1.isEmpty();

                String confpass1 = confpass.getText();
                String confpass2 = "Password : " + confpass.getText();
                boolean confpass3 = confpass1.isEmpty();
                boolean check = newpass1.equals(confpass1);

                if (newpass3 == true || confpass3 == true) 
				{
                    showMessageDialog(null, "Enter password", "Error",
                            JOptionPane.WARNING_MESSAGE);
                } 
				
				else if (check == false) 
				{
                    showMessageDialog(null, "Password not matching", "Error",
                            JOptionPane.WARNING_MESSAGE);
                } 
				
				else 
				{
                    String tempfile = ".\\data\\temp.txt";
                    File oldFile = new File(".\\data\\.user_data.txt");
                    File newFile = new File(".\\data\\temp.txt");
                    int l = 0;
                    // deleteLine = ForgetPass1.i + 2;
                    String currentline;

                    FileWriter fileWriter = new FileWriter(tempfile, true);
                    BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                    PrintWriter printWriter = new PrintWriter(bufferedWriter);

                    FileReader fr = new FileReader(".\\data\\.user_data.txt");
                    BufferedReader br = new BufferedReader(fr);

                    int n = (ForgotPassword.deleteLine) + 2;
                    while ((currentline = br.readLine()) != null) 
					{
                        l++;
                        if (n != l) 
						{
                            printWriter.println(currentline);
                        }
						else 
						{
                            printWriter.println(confpass2);
                        }
                    }
                    printWriter.flush();
                    printWriter.close();
                    fr.close();
                    br.close();
                    bufferedWriter.close();
                    fileWriter.close();

                    oldFile.delete();
                    File dumb = new File(".\\data\\.user_data.txt");
                    newFile.renameTo(dumb);
                    new Login();
					frame.setVisible(false);

                }
            } 
			
			catch (Exception ex)
			{
                System.out.println(ex);
				
			}

        }

		else if (e.getSource() == exitButton) 
		{
            int yesORno = JOptionPane.showConfirmDialog(null, "Do you want to exit?", "Exit Confirmation", JOptionPane.YES_NO_OPTION);

            if (yesORno == 0) 
			{
                System.exit(1);
            }
        } 
		
		else if (e.getSource() == backButton)
		{
            new ForgotPassword2();
			frame.setVisible(false);
        }

		else if (e.getSource() == toggleButton) 
		{
            if (toggleButton.isSelected()) 
			{
                toggleButton.setIcon(on);
                confpass.setEchoChar((char) 0);
            } 
			
			else 
			{
                toggleButton.setIcon(off);
                confpass.setEchoChar('*');
            }
        }

        else if (e.getSource() == toggleButton2) 
		{
            if (toggleButton2.isSelected()) 
			{
                toggleButton2.setIcon(on);
                newPass.setEchoChar((char) 0);
            } 
			
			else 
			{
                toggleButton2.setIcon(off);
                newPass.setEchoChar('*');
            }
        }
    }
}
