package classes;
import java.lang.*;
import interfaces.*;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class UProfile implements ActionListener,IUProfile
{
	private JButton previous0;
	private JTextArea display;
	private JFrame frame;
	
	private String f;
	
	public UProfile(String user)
	{
		f=user;
		frame = new JFrame("Profile");
		
		ImageIcon framelogo = new ImageIcon("icons/framelogo.jpg");
		//ImageIcon previousImage = new ImageIcon("icons/previous.png");
		
		Image background = new ImageIcon("icons/Uprofilebg.png").getImage().getScaledInstance(600, 500, Image.SCALE_SMOOTH);
		frame.setContentPane(new ImagePanel(background));
		
		
		display = new JTextArea (5, 5);
		display.setBounds(65,170,450,150);
		display.setFont(new Font("Times New Roman",Font.BOLD,19));
		display.setBackground(Color.LIGHT_GRAY);
		frame.add(display);


		String line1=" ";
		String line2=" ";
		String line3=" ";
		
            try
			{
                String userNameS = "User Name : " + f;
                BufferedReader reader = new BufferedReader(new FileReader("data\\.user_data.txt"));

                int totalLines = 0;
                while (reader.readLine() != null)
				{
                    totalLines++;
                }
                reader.close();

                for (int i = 0; i <= totalLines; i++) 
                {
                    line1 = Files.readAllLines(Paths.get("data\\.user_data.txt")).get(i);
                    
                    if (line1.equals(userNameS)) 
                    {
                        line2 = Files.readAllLines(Paths.get("data\\.user_data.txt")).get((i + 2));
                        line3 = Files.readAllLines(Paths.get("data\\.user_data.txt")).get((i + 3));
						break;
                    }
                }
                
            } 
            catch (Exception ex) 
            {
                new Home(f);
                JOptionPane.showMessageDialog(null, "Something went horribly wrong", "Warning!", 0);
                return;
            }
        
		display.setText(" User Details:"+"\n\n "+line1+"\n "+line2+"\n User creation "+line3);
		display.setEditable(false);
		

		previous0 = new JButton ("Close");
		previous0.setBounds(230, 350, 100, 30);
		previous0.setFocusable(false);
		previous0.setBackground(Color.LIGHT_GRAY);
		previous0.setBorder(BorderFactory.createRaisedSoftBevelBorder());
		previous0.addActionListener(this);
		previous0.setCursor(new Cursor(Cursor.HAND_CURSOR));
		//previous0.setIcon(previousImage);
		frame.add(previous0);
		
		frame.setIconImage(framelogo.getImage());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600,500);
		frame.getContentPane().setBackground(Color.white);
		frame.setLayout (null);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
	}

	//public static void main(String[] args)
	//{
	//	new UProfile("Azminur");
	//}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==previous0)
		{
			frame.setVisible(false);
			//new Home(f);
		}
		
	}

}
