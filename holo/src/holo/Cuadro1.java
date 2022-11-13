package holo;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controlador.DbHelper;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Cuadro1 extends JFrame {
	
	

	private JPanel contentPane;
	private JTextField textFieldNick;
	private JTextField textFieldPass;
	static DbHelper db;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cuadro1 frame = new Cuadro1();
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
	public Cuadro1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 536, 341);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textFieldPass = new JTextField();
		textFieldPass.setBounds(195, 149, 96, 19);
		contentPane.add(textFieldPass);
		textFieldPass.setColumns(10);
		
		textFieldNick = new JTextField();
		textFieldNick.setBounds(195, 77, 96, 19);
		contentPane.add(textFieldNick);
		textFieldNick.setColumns(10);
		
		JButton showButton = new JButton("Mostrar");
		showButton.setBounds(357, 200, 85, 21);
		showButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				User.setGlobalNick(textFieldNick.getText());
				Cuadro2 cuadroN = new Cuadro2();
				cuadroN.setVisible(rootPaneCheckingEnabled);	
				
			}
		});
		contentPane.add(showButton);
		
		JButton chekInButton = new JButton("Registro");
		chekInButton.setBounds(46, 200, 85, 21);
		contentPane.add(chekInButton);
		chekInButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e){
				System.out.print("hola k ase");
				LogInFrame logIn = new LogInFrame();
				logIn.setVisible(true);
				dispose();
			}
		});
		
		JButton logInButton = new JButton("Log In");
		logInButton.setBounds(200, 200, 85, 21);
		contentPane.add(logInButton);
		logInButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				User.setGlobalNick(textFieldNick.getText());
				System.out.print("Nick metido: "+textFieldNick.getText() + " Pass metido: "+textFieldPass.getText()+"\n");
				db = new DbHelper();
				
				if(!db.conUser(textFieldNick.getText(), textFieldPass.getText())) {
					System.out.println("El usario no existe");
					JOptionPane.showMessageDialog(null, "No existe usario", "Error", JOptionPane.ERROR_MESSAGE);	
				}else {
					Cuadro2 logIn = new Cuadro2();
					logIn.setVisible(true);
					dispose();
				}
				
				
			}
		});
		
		
		
		JLabel lblNewLabel = new JLabel("Log In");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(206, 10, 85, 37);
		contentPane.add(lblNewLabel);
	}
	
	/*
	public static String getText () {
		String texto = nickname ;
		return texto;
	}*/
}
