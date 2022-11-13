package holo;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Controlador.DbHelper;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.awt.GridBagLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.SpringLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Update extends JFrame{
	private JPanel contentPane;
	JLabel labelLogin;
	static JLabel errorPassword;
	JPasswordField password;
	JTextField textFieldLogin = null;
	ArrayList<JTextField> textList;
	static ArrayList<JPasswordField> passwords;
	JButton logInButton;
	static User user = new User();
	static DbHelper db;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Update frame = new Update();
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
	public Update() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 200, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setResizable(false);
		
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		
		
		
		//nombre, apellidos, contraseña, confiContraseña, Nick, correo.
		String[] logInfo = {"Nombre", "Apellidos", "Contraseña", "Confirmar Contraseña", "Nickname", "Correo Electronico"};
		textList = new ArrayList<JTextField>();
		passwords = new ArrayList<JPasswordField>();
		for(int i = 0; i < 6; i++) {
			
			
			if(i>1 && i<4) {
				
				labelLogin = new JLabel(logInfo[i]);
				contentPane.add(labelLogin);
				labelLogin.setAlignmentX(labelLogin.CENTER_ALIGNMENT);
				
				password = new JPasswordField();
				contentPane.add(password);
				
				passwords.add(password);
				
			}else {
				labelLogin = new JLabel(logInfo[i]);
				contentPane.add(labelLogin);
				labelLogin.setAlignmentX(labelLogin.CENTER_ALIGNMENT);
				
				textFieldLogin = new JTextField("", 100);
				contentPane.add(textFieldLogin);
				
				textList.add(textFieldLogin);
				labelLogin.setAlignmentX(textFieldLogin.CENTER_ALIGNMENT);
			}
		}
		
		
		//String hola = textList.get(1).getTexit(); Sirve para optener info del jtext
				
		
		logInButton = new JButton("Actualizar");
		errorPassword = new JLabel("Contraseña no coincide");
		errorPassword.setVisible(false);
		contentPane.add(errorPassword);
		
		
		logInButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(!(textList.get(0).getText().isEmpty() || textList.get(1).getText().isEmpty() || textList.get(2).getText().isEmpty() || textList.get(3).getText().isEmpty() || converString(0).isEmpty() || converString(1).isEmpty())) {
					if(!converString(0).equals(converString(1))) {
						System.out.println("Se mete en con contraseña");
						passwords.get(0).setText(null);
						passwords.get(1).setText(null);
						
						errorPassword.setForeground(Color.red);
						errorPassword.setAlignmentX(errorPassword.CENTER_ALIGNMENT);
						errorPassword.setText("Contraseña no coinciden");
						
						errorPassword.setVisible(true);
						
					}else {
						System.out.println("Llega a guardar la informacion en userInfo");
						
						errorPassword.setVisible(false);
						userInfo(textList, user, passwords);
						db = new DbHelper();
						if(db.existTable()) {
							db.update(user.getNombre(), user.getNick(), user.getApellidos(), user.getPassword(), user.getCorreo(), User.getGlobalNick());
							
							Cuadro1 cuadro1 = new Cuadro1();
							cuadro1.setVisible(true);
							dispose();
						}else {
							db.createTable();
							db.update(user.getNombre(), user.getNick(), user.getApellidos(), user.getPassword(), user.getCorreo(), User.getGlobalNick());
							
							Cuadro1 cuadro1 = new Cuadro1();
							cuadro1.setVisible(true);
							dispose();
						}
					}
				}else {
					System.out.println("se mete on el error");
					errorPassword.setText("Hay campos sin rellenar");
					
					errorPassword.setForeground(Color.red);
					errorPassword.setAlignmentX(errorPassword.CENTER_ALIGNMENT);
					
					errorPassword.setVisible(true);
					
				}
				
				
			}
		});
		
		contentPane.add(logInButton);
		logInButton.setAlignmentX(logInButton.CENTER_ALIGNMENT);
	}
	
	
	private static void userInfo(ArrayList<JTextField> textList, User user, ArrayList<JPasswordField> passwords) {
		
		user.setNombre(textList.get(0).getText());
		System.out.print(user.getNombre());
		
		user.setApellidos(textList.get(1).getText());   //Crear base de datos 
		System.out.print(user.getApellidos());			//Crear tabla
														//Hacer inserts					
		user.setPassword(converString(0)); 
		System.out.print(user.getPassword());	   		
		
		user.setNick(textList.get(2).getText());
		System.out.print(user.getNick());
		
		user.setCorreo(textList.get(3).getText());
		System.out.print(user.getCorreo());
	}
	
	public static String converString(int i) {
		String password = String.valueOf(passwords.get(i).getPassword());
		return password;	
	}
	
	public static void dbConexion() {
		DbHelper db = new DbHelper();
		db.createDb();
	}
}
	
	
	
