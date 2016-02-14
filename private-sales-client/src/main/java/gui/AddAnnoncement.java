package gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import delegate.AnnoncementDelegate;
import entities.Annoncement;

public class AddAnnoncement extends JFrame {

	private JPanel contentPane;
	private JTextField nameAnnonce;
	private JTextField priceAnnonce;
	private JTextField userAnnonce;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddAnnoncement frame = new AddAnnoncement();
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
	public AddAnnoncement() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addGap(17)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 376, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(31, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap()
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(60, Short.MAX_VALUE)));

		JLabel lblNewLabel = new JLabel("name");

		JLabel lblPrice = new JLabel("price");

		JLabel lblUser = new JLabel("user");

		nameAnnonce = new JTextField();
		nameAnnonce.setColumns(10);

		priceAnnonce = new JTextField();
		priceAnnonce.setColumns(10);

		userAnnonce = new JTextField();
		userAnnonce.setColumns(10);

		JButton btnAdd = new JButton("add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Annoncement annoncement = new Annoncement();
				annoncement.setName(nameAnnonce.getText());
				annoncement.setPrice(Float.valueOf(priceAnnonce.getText()));

				AnnoncementDelegate.doAddAnnoncement(annoncement, Integer.valueOf(userAnnonce.getText()));
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addGap(25)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING).addComponent(lblNewLabel)
								.addComponent(lblPrice).addComponent(lblUser))
				.addGap(18)
				.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(userAnnonce, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(priceAnnonce, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(nameAnnonce, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
						.addContainerGap(179, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING,
						gl_panel.createSequentialGroup().addContainerGap(286, Short.MAX_VALUE).addComponent(btnAdd)));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addGap(26)
						.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addComponent(nameAnnonce, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel))
				.addGap(18)
				.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(lblPrice).addComponent(
						priceAnnonce, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(18)
				.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(lblUser).addComponent(
						userAnnonce, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED, 11, Short.MAX_VALUE).addComponent(btnAdd)));
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}
}
