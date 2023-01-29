package gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;


import java.awt.Color;

public class MemoryMode extends JFrame {

	public MemoryMode() {

		// Definitions
		JLabel lblTitle = new JLabel("M E M O R Y");
		JLabel lblAuthor = new JLabel("Heidl Lukas | Adam Altalbani");
		JButton btnSingleplayer = new JButton("EINZELSPIELER");
		JButton btnMultiplayer = new JButton("MEHRSPIELER");
		JButton btnBack = new JButton("ZURÜCK");
		JPanel typePanel = new JPanel();

		// Options
		lblTitle.setFont(new Font("Segoe UI Light", Font.PLAIN, 39));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(10, 11, 1244, 83);

		lblAuthor.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAuthor.setFont(new Font("Segoe UI Light", Font.PLAIN, 13));
		lblAuthor.setBounds(10, 576, 1244, 24);

		btnSingleplayer.setBackground(Color.WHITE);
		btnSingleplayer.setFont(new Font("Segoe UI Light", Font.BOLD, 20));
		btnSingleplayer.setBounds(490, 186, 280, 60);

		btnMultiplayer.setBackground(Color.WHITE);
		btnMultiplayer.setFont(new Font("Segoe UI Light", Font.BOLD, 20));
		btnMultiplayer.setBounds(490, 257, 280, 60);

		btnBack.setBackground(Color.WHITE);
		btnBack.setFont(new Font("Segoe UI Light", Font.BOLD, 20));
		btnBack.setBounds(490, 328, 280, 60);

		typePanel.setBackground(Color.WHITE);
		typePanel.setBorder(new EmptyBorder(13, 5, 5, 5));
		typePanel.setLayout(null);

		// Adding to view
		typePanel.add(lblTitle);
		typePanel.add(lblAuthor);
		typePanel.add(btnSingleplayer);
		typePanel.add(btnMultiplayer);
		typePanel.add(btnBack);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 650);
		setResizable(false);
		setContentPane(typePanel);
		setIconImage(new ImageIcon(getClass().getResource("../images/logo.png")).getImage());
		// Listener
		btnSingleplayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				EventQueue.invokeLater(() -> {
					MemorySinglePlayer frame = MemorySinglePlayer.getInstanceOf();
					frame.isAlwaysOnTop();
				});

			}
		});

		btnMultiplayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();

			}
		});

		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				setVisible(false);
				MemoryMenu.memorymenu.dispose();
				MemoryMenu.memorymenu.setVisible(true);
				revalidate();
			}
		});
	}

}
