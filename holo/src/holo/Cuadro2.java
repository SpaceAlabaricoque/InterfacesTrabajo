package holo;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import Controlador.DbHelper;

import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Panel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Cuadro2 extends JFrame {
	
	JTable table;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cuadro2 frame = new Cuadro2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	/**
	 * Create the frame. 
	 */
	public Cuadro2() {
		
		Container con = getContentPane(); 
		boolean check;
		DbHelper db = new DbHelper();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		view();
		
		
		//getContentPane().setLayout(gridBagLayout);
		
		
		//System.out.print(texto);
		
		
		//JPanel panel = new JPanel();
		/*
		String[][] rec = {
				   { "1", "Steve", "AUS" },
				   { "2", "Virat", "IND" },
				   { "3", "Kane", "NZ" },
				   { "4", "David", "AUS" },
				   { "5", "Ben", "ENG" },
				   { "6", "Eion", "ENG" },
				};*/
		//String[] header = { "NickName", "Nombre", "Apellidos","Email" };
		
		//JTable table = new JTable(cosasArray(), header);
		
		//panel.add(new JScrollPane(table));
		//con.add(panel);
		
		
	}
	
	public void  view() {
		System.out.println("JJJJJJJJJ: " + User.getGlobalNick());
		Container con = getContentPane();
		DbHelper db = new DbHelper();
		
		JButton b;
		ArrayList<JButton> buttonList = new ArrayList<>();
		
		GridBagLayout grid = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		setLayout(grid);
		setTitle("GridBagLayout Example");
		GridBagLayout layout = new GridBagLayout();
		this.setLayout(layout);
		
		String s [] = {"Datos de Usuario: ", "Nombre", "Apellidos", "Nickname", "Email"};		
		String button [] = {"Volver", "Actualizar", "Borrar"};
		
		for(int i = 0; i < 5; i++) {
			gbc.ipadx = 10; 
			gbc.gridx = i;
			gbc.gridy = 0;
			this.add(new JLabel(s[i]), gbc);
		}
		
		for(int i = 1; i < 4; i++) {
			b = new JButton(button[i-1]);
			gbc.ipadx = 10; 
			gbc.gridx = i+1;
			gbc.gridy = 2;
			this.add(b, gbc);
			buttonList.add(b);
		}
		
		
		dataUser(db, gbc);
		
		
		
		buttonList.get(2).addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				db.deleteUser(User.getGlobalNick());
				Cuadro2 frame = new Cuadro2();
				frame.setVisible(true);
				getContentPane().setVisible(false);
				dispose();
				
				//check = true;
				
			}
		});
		
		
		buttonList.get(1).addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Update update = new Update();
				update.setVisible(true);
				dispose();
				
				
				//check = true;
				
			}
		});
		
		buttonList.get(0).addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Cuadro1 frame = new Cuadro1();
				frame.setVisible(true);
				getContentPane().setVisible(false);
				dispose();
				
				//check = true;
				
			}
		});
	}
	
	public void dataUser(DbHelper db, GridBagConstraints gbc) {
	
		if(db.selectTodo(User.getGlobalNick()).size() != 0) {
			for(int i = 1; i < 5; i++) {
				gbc.ipadx = 10; 
				gbc.gridx = i;
				gbc.gridy = 1;
				this.add(new JLabel(db.selectTodo(User.getGlobalNick()).get(i-1)), gbc);
			}
		}else {
			
			for(int i = 1; i < 5; i++) {
				gbc.ipadx = 10; 
				gbc.gridx = i;
				gbc.gridy = 1;
				this.add(new JLabel("------"), gbc);
			}
		}
			
		
	}
	/*
	public static String[][] cosasArray() {
		DbHelper db = new DbHelper();
		String usersData[][] = new String [db.selectIdNickname().size()][4];
		
		
		
		//System.out.println(s[0][0] +"/"+s[0][1]+"/"+s[1][0]+"/"+s[1][1]);
		
		
		for(int j = 0; j < db.selectIdNickname().size(); j++) {
			usersData[j][0] = db.selectIdNickname().get(j);
			System.out.println(usersData[j][0]);
		}
		
		for(int j = 0; j < db.selectNombre().size(); j++) {
			usersData[j][1] = db.selectNombre().get(j);
			System.out.println(usersData[j][1]);
		}
		
		for(int j = 0; j < db.selectApellidos().size(); j++) {
			usersData[j][2] = db.selectApellidos().get(j);
			System.out.println(usersData[j][2]);
		}
		
		for(int j = 0; j < db.selectEmail().size(); j++) {
			usersData[j][3] = db.selectIdNickname().get(j);
			System.out.println(usersData[j][3]);
		}
		return usersData;
		
	}*/
	
	
}



  