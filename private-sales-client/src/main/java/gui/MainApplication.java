package gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MainApplication extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainApplication frame = new MainApplication();
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
	public MainApplication() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("file");
		menuBar.add(mnNewMenu);

		JMenuItem mntmAnnoncementList = new JMenuItem("annoncement list");
		mntmAnnoncementList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AnnoncementsList annoncementsList = new AnnoncementsList();
				annoncementsList.setVisible(true);
			}
		});

		mnNewMenu.add(mntmAnnoncementList);

		JMenuItem mntmStatistique = new JMenuItem("statistique");
		mntmStatistique.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PieChart_ANNONCEMENT pieChart_ANNONCEMENT = new PieChart_ANNONCEMENT("stat");
				pieChart_ANNONCEMENT.setVisible(true);
				pieChart_ANNONCEMENT.pack();
			}
		});
		mnNewMenu.add(mntmStatistique);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING).addGap(0, 424, Short.MAX_VALUE));
		gl_contentPane.setVerticalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING).addGap(0, 251, Short.MAX_VALUE));
		contentPane.setLayout(gl_contentPane);
	}

}
