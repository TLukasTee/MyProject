package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.miginfocom.layout.PlatformDefaults;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import java.awt.Color;

public class MemoryMenu extends JFrame {

	public static MemorySettings memorysettings = new MemorySettings();
	public static MemoryMode memorymode = new MemoryMode();
	public static MemoryMenu memorymenu = new MemoryMenu();

	public MemoryMenu() {
		
		// Definitions
		JPanel panelMenu = new JPanel();
		JLabel lblTitle = new JLabel("M E M O R Y");
		JLabel lblAuthor = new JLabel("Heidl Lukas | Adam Altalbani");
		JButton btnPlay = new JButton("SPIELEN");
		JButton btnEinstellungen = new JButton("EINSTELLUNGEN");
		JButton btnBeenden = new JButton("BEENDEN");
		

		// Options
		panelMenu.setBackground(Color.WHITE);
		panelMenu.setBorder(new EmptyBorder(13, 5, 5, 5));
		panelMenu.setLayout(null);
		
		lblTitle.setFont(new Font("Segoe UI Light", Font.PLAIN, 39));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(10, 11, 1244, 83);

		lblAuthor.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAuthor.setFont(new Font("Segoe UI Light", Font.PLAIN, 13));
		lblAuthor.setBounds(10, 576, 1244, 24);

		btnPlay.setBackground(Color.WHITE);
		btnPlay.setFont(new Font("Segoe UI Light", Font.BOLD, 20));
		btnPlay.setBounds(490, 186, 280, 60);

		btnEinstellungen.setBackground(Color.WHITE);
		btnEinstellungen.setFont(new Font("Segoe UI Light", Font.BOLD, 20));
		btnEinstellungen.setBounds(490, 257, 280, 60);

		btnBeenden.setBackground(Color.WHITE);
		btnBeenden.setFont(new Font("Segoe UI Light", Font.BOLD, 20));
		btnBeenden.setBounds(490, 328, 280, 60);
		

		
		
		// Adding to View
		panelMenu.add(lblTitle);
		panelMenu.add(lblAuthor);
		panelMenu.add(btnPlay);
		panelMenu.add(btnEinstellungen);
		panelMenu.add(btnBeenden);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 650);
		setResizable(false);
		setContentPane(panelMenu);
		setIconImage(new ImageIcon(getClass().getResource("../images/logo.png")).getImage());

		// Listener
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				setVisible(false);	
				memorymode.setVisible(true);
				revalidate();
			}
		});
		btnEinstellungen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
				memorysettings.setVisible(true);
				revalidate();

			}
		});
		btnBeenden.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				dispose();
			}
		});

	}

	public void startMenu() {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemoryMenu frame = new MemoryMenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}
}
