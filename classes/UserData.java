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
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class UserData implements ActionListener, MouseListener, IUserData
{
	private JFrame frame;
	private JLabel label1;
	private JButton refresh;
	private JButton previous0;
	private JButton add;
	private JButton delete;
	private JButton exitButton;
	private JTable table;
    private DefaultTableModel model;
    private String[] column = { "User Name", "Password", "Email", "Date and Time" };
    private String[] rows = new String[8];
    private JScrollPane scroll;
    
    private String file = "data\\.user_data.txt";
    private String temp = "data\\temp.txt";
    
	private User x;
	
	public UserData(User a)
	{
		x=a;
		
		frame = new JFrame("User Data");
		
		//icon
		ImageIcon framelogo = new ImageIcon("icons/framelogo.jpg");
		ImageIcon previousImage = new ImageIcon("icons/previous.png");
		ImageIcon refreshImage = new ImageIcon("icons/refresh.png");
		ImageIcon deleteImage = new ImageIcon("icons/deleteuser.png");
		ImageIcon addImage = new ImageIcon("icons/adduser.png");
		ImageIcon exitImage = new ImageIcon("icons/exiticon.png");
		
		//background
		Image background = new ImageIcon("icons/main2.jpg").getImage();
		frame.setContentPane(new ImagePanel(background));
		
		label1 = new JLabel();
	    label1.setText("User Data");
	    label1.setBounds(280, 0, 300, 60);
	    label1.setFont(new Font("Segoe UI Black", Font.BOLD, 50));
	    frame.add(label1);
		
		
	    table = new JTable();
        model = new DefaultTableModel();
        model.setColumnIdentifiers(column);
        
        table.setModel(model);
        table.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        table.setSelectionBackground(Color.decode("#8AC5FF"));
        table.setBackground(Color.WHITE);
        table.setRowHeight(30);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	    
        table.getColumnModel().getColumn(0).setPreferredWidth(120);
        table.getColumnModel().getColumn(1).setPreferredWidth(120);
        table.getColumnModel().getColumn(2).setPreferredWidth(300);
        table.getColumnModel().getColumn(3).setPreferredWidth(220);

        scroll = new JScrollPane(table);
        scroll.setBounds(70, 80, 700, 280);
        scroll.setBackground(Color.WHITE);
        frame.add(scroll);
 
        try
		{
			BufferedReader reader = new BufferedReader(new FileReader(file));
            int totalLines = 0;
            while (reader.readLine() != null)
            {
                totalLines++;
            }
            reader.close();

            for (int i = 0; i < totalLines; i++)
			{
                String line = Files.readAllLines(Paths.get(file)).get(i);
                String x = line.substring(0, 4);
                if (x.equals("User"))
				{
                    rows[0] = Files.readAllLines(Paths.get(file)).get(i).substring(12); // User Name
                    rows[1] = Files.readAllLines(Paths.get(file)).get((i + 1)).substring(11); // Password
                    rows[2] = Files.readAllLines(Paths.get(file)).get((i + 2)).substring(8); // Email
                    rows[3] = Files.readAllLines(Paths.get(file)).get((i + 3)).substring(14); // Date and Time
                    model.addRow(rows);
                }
            }

        } 
        catch (Exception ex)
		{
        	JOptionPane.showMessageDialog(null, "Something went horribly wrong!", "Warning!", 0);
            return;
        }
	   
        refresh= new JButton("Refresh");
		refresh.setFont(new Font("Calibri Light (Headings)", Font.BOLD, 15));
		refresh.setBounds(150, 380, 150, 35);
		refresh.setFocusable(false);
		refresh.setBackground(Color.LIGHT_GRAY);
		refresh.setCursor(new Cursor(Cursor.HAND_CURSOR));
		refresh.setBorder(BorderFactory.createEtchedBorder());
		refresh.setIcon(refreshImage);
		refresh.addActionListener(this);	
		refresh.addMouseListener(this);
		frame.add(refresh);
		
		
		add= new JButton("Add User");
		add.setFont(new Font("Calibri Light (Headings)", Font.BOLD, 15));
		add.setBounds(350, 380, 150, 35);
		add.setFocusable(false);
		add.setBackground(Color.LIGHT_GRAY);
		add.setCursor(new Cursor(Cursor.HAND_CURSOR));
		add.setBorder(BorderFactory.createEtchedBorder());
		add.setIcon(addImage);
		add.addActionListener(this);	
		add.addMouseListener(this);
		frame.add(add);
			
			
		delete= new JButton("Delete User");
		delete.setFont(new Font("Calibri Light (Headings)", Font.BOLD, 15));
		delete.setBounds(550, 380, 150, 35);
		delete.setFocusable(false);
		delete.setBackground(Color.LIGHT_GRAY);
		delete.setCursor(new Cursor(Cursor.HAND_CURSOR));
		delete.setBorder(BorderFactory.createEtchedBorder());
		delete.setIcon(deleteImage);
		delete.addActionListener(this);	
		delete.addMouseListener(this);
		frame.add(delete);
		
		
		previous0 = new JButton ("Back");
		previous0.setFont(new Font("Calibri Light (Headings)", Font.BOLD, 15));
		previous0.setBounds(270, 440, 150, 35);
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
		exitButton.setBounds(460, 440, 150, 35);
		exitButton.setFocusable(false);
		exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
		exitButton.setBackground(Color.LIGHT_GRAY);
		exitButton.setBorder(BorderFactory.createRaisedSoftBevelBorder());
		exitButton.setIcon(exitImage);
		exitButton.addActionListener(this);
		exitButton.addMouseListener(this);
		frame.add(exitButton);
		
		
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
		if (e.getSource()==refresh)
		{
			refresh.setBackground(Color.green);
			refresh.setForeground(Color.white);
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
		else if (e.getSource()==add)
		{
			add.setBackground(Color.cyan);
			add.setForeground(Color.white);
		}
		else if (e.getSource()==delete)
		{
			delete.setBackground(Color.magenta);
			delete.setForeground(Color.white);
		}
	}

	@Override
	public void mouseExited(MouseEvent e)
	{
		if (e.getSource()==refresh)
		{
			refresh.setBackground(Color.LIGHT_GRAY);
			refresh.setForeground(Color.BLACK);
		}
		else if (e.getSource()==exitButton)
		{
			exitButton.setBackground(Color.LIGHT_GRAY);
			exitButton.setForeground(Color.BLACK);
		}
		else if (e.getSource()==previous0)
		{
			previous0.setBackground(Color.LIGHT_GRAY);
			previous0.setForeground(Color.BLACK);
		}
		else if (e.getSource()==add)
		{
			add.setBackground(Color.LIGHT_GRAY);
			add.setForeground(Color.BLACK);
		}
		else if (e.getSource()==delete)
		{
			delete.setBackground(Color.LIGHT_GRAY);
			delete.setForeground(Color.BLACK);
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==refresh)
		{
            new UserData(x);
			frame.setVisible(false);
		}
		else if(e.getSource()==delete)
		{
			if(table.getSelectionModel().isSelectionEmpty())
			{
				 JOptionPane.showMessageDialog(null, "Please select a user to delete", "Warning!",JOptionPane.WARNING_MESSAGE);
             }
			 else 
			 {
				 String removeUser = table.getModel().getValueAt(table.getSelectedRow(), 0).toString();

                 File oldFile = new File(file);
                 File newFile = new File(temp);

                 int q = 0;

                 try
				 {
					 BufferedReader reader = new BufferedReader(new FileReader(file));
                     int totalLines = 0;
                     while (reader.readLine() != null)
						 totalLines++;
					 reader.close();
					 
					 for (int i = 0; i < totalLines; i++)
					 {
                         String line = Files.readAllLines(Paths.get(file)).get(i);
                         String x = line.substring(0, 4);
                         if (x.equals("User"))
						 {
							 String userName = Files.readAllLines(Paths.get(file)).get(i);
                             if (userName.substring(12).equals(removeUser))
							 {
                                 q = i;
                             }
                         }
                     }
                 }				 
                 catch (Exception ex)
				 {
                     return;
                 }
                 	try
					{
                     	FileWriter fw = new FileWriter(temp, true);
                     	BufferedWriter bw = new BufferedWriter(fw);
                     	PrintWriter pw = new PrintWriter(bw);

                     	FileReader fr = new FileReader(file);
                     	BufferedReader br = new BufferedReader(fr);

                     	BufferedReader reader = new BufferedReader(new FileReader(file));
                     	int totalLines = 0;
                     	while (reader.readLine() != null)
						{
                         	totalLines++;
                     	}
                     	reader.close();

                     	for (int j = 0; j < totalLines; j++)
						{
                         	String line = Files.readAllLines(Paths.get(file)).get(j);
                         	String x = line.substring(0, 4);

                         	if (q != 0 && (j == q || j == (q + 1) || j == (q + 2) || j == (q + 3) || j == (q + 4) || j == (q + 5)))
							{
                        	 	String userName = Files.readAllLines(Paths.get(file)).get(j);
                             	pw.println("#Removed! " + userName);
                         	} 
                         	else
							{
                             	String userName = Files.readAllLines(Paths.get(file)).get(j);
                             	pw.println(userName);
                         	}
                     	}
                     	pw.flush();
                     	pw.close();
                     	fr.close();
                     	br.close();
                     	bw.close();
                     	fw.close();

                 	} 
                 	catch (Exception ex) 
                 	{
						System.out.print(ex);
                 	}

                 	oldFile.delete();
                 	File dump = new File(file);
                 	newFile.renameTo(dump);

                 	frame.setVisible(false);
                 	new UserData(x);
			 	}
			}
		
		
		else if (e.getSource()==add)
		{
            new AdminAdd(x);
			frame.setVisible(false);
		}
		
		else if (e.getSource()==previous0)
		{
            new AdminHome(x);
			frame.setVisible(false); 			
		}
		else if (e.getSource()==exitButton)
		{
			int a = JOptionPane.showConfirmDialog(null, "Do you want to exit?", "Exit Confirmation", 0);
			if(a==0)
			{
				System.exit(0);
			}
		}		
	}
}
