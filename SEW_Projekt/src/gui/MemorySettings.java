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
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.Color;

public class MemorySettings extends JFrame {

	private static JPanel panel;

	public static MemorySettings game = new MemorySettings();

	public MemorySettings() {

		JPanel panelSettings = new JPanel();

		JButton btnBack = new JButton("Zurück");
		JLabel lblMousespeed = new JLabel("Zeigergeschwindigkeit");
		JLabel lblMusicvolume = new JLabel("Musiklautstärke");
		JLabel lblAudiovolume = new JLabel("Allgemeine Lautstärke");
		JLabel lblSettings = new JLabel("Einstellungen");

		JSlider slider_audio = new JSlider();
		JSlider slider_mousespeed = new JSlider();
		JSlider slider_music = new JSlider();

		btnBack.setBackground(Color.WHITE);
		btnBack.setBounds(10, 21, 89, 23);

		lblSettings.setIgnoreRepaint(true);
		lblSettings.setBackground(Color.WHITE);
		lblSettings.setHorizontalAlignment(SwingConstants.CENTER);
		lblSettings.setFont(new Font("Segoe UI Light", Font.PLAIN, 26));
		lblSettings.setBounds(10, 11, 1260, 51);

		lblAudiovolume.setHorizontalAlignment(SwingConstants.CENTER);
		lblAudiovolume.setFont(new Font("Segoe UI Semibold", Font.BOLD, 16));
		lblAudiovolume.setBounds(410, 136, 223, 39);

		slider_music.setOpaque(false);
		slider_music.setFont(new Font("Segoe UI Light", Font.PLAIN, 11));
		slider_music.setValue(20);
		slider_music.setMinorTickSpacing(10);
		slider_music.setSnapToTicks(true);
		slider_music.setBackground(Color.WHITE);
		slider_music.setForeground(Color.WHITE);
		slider_music.setBounds(643, 137, 223, 39);

		lblMusicvolume.setHorizontalAlignment(SwingConstants.CENTER);
		lblMusicvolume.setFont(new Font("Segoe UI Semibold", Font.BOLD, 16));
		lblMusicvolume.setBounds(410, 186, 223, 39);

		slider_mousespeed.setOpaque(false);
		slider_mousespeed.setFont(new Font("Segoe UI Light", Font.PLAIN, 11));
		slider_mousespeed.setValue(20);
		slider_mousespeed.setMinorTickSpacing(10);
		slider_mousespeed.setSnapToTicks(true);
		slider_mousespeed.setBackground(Color.WHITE);
		slider_mousespeed.setForeground(Color.WHITE);
		slider_mousespeed.setBounds(643, 187, 223, 39);

		lblMousespeed.setHorizontalAlignment(SwingConstants.CENTER);
		lblMousespeed.setFont(new Font("Segoe UI Semibold", Font.BOLD, 16));
		lblMousespeed.setBounds(410, 236, 223, 39);

		slider_audio.setOpaque(false);
		slider_audio.setFont(new Font("Segoe UI Light", Font.PLAIN, 11));
		slider_audio.setValue(20);
		slider_audio.setMinorTickSpacing(10);
		slider_audio.setSnapToTicks(true);
		slider_audio.setBackground(Color.WHITE);
		slider_audio.setForeground(Color.WHITE);
		slider_audio.setBounds(643, 237, 223, 38);

		panelSettings.setBackground(Color.WHITE);
		panelSettings.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(panelSettings);
		getContentPane().add(lblMusicvolume);
		getContentPane().add(lblMousespeed);
		getContentPane().add(slider_audio);
		getContentPane().add(lblSettings);
		getContentPane().add(lblAudiovolume);
		getContentPane().add(slider_music);
		getContentPane().add(slider_mousespeed);
		getContentPane().setLayout(null);

		getContentPane().add(btnBack);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setBounds(100, 100, 1280, 650);
		setIconImage(new ImageIcon(getClass().getResource("../images/logo.png")).getImage());
		
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				MemoryMenu.memorysettings.setVisible(false);
				MemoryMenu.memorymenu.setVisible(true);
				revalidate();

			}
		});

	}

}
