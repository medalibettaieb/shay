package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import delegate.CommentaireDelegate;

public class AddCommentaire extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */

	public AddCommentaire() {
		// TODO Auto-generated constructor stub
	}

	public AddCommentaire(Integer idAnnoncement) {
		System.out.println(idAnnoncement);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JLabel lblAddComment = new JLabel("add comment ");

		JTextArea textArea = new JTextArea();

		JButton btnValidate = new JButton("validate");
		btnValidate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CommentaireDelegate.doAddCommentaireOnAnnouncement(textArea.getText(), idAnnoncement,
						Integer.valueOf(textField.getText()));

				dispose();
				AnnoncementsList annoncementsList = new AnnoncementsList();
				annoncementsList.setVisible(true);

			}
		});

		textField = new JTextField();
		textField.setColumns(10);

		JLabel lblIdUser = new JLabel("id user");
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout
				.setHorizontalGroup(
						groupLayout.createParallelGroup(Alignment.TRAILING)
								.addGroup(groupLayout.createSequentialGroup().addGap(24).addComponent(lblAddComment)
										.addGap(32)
										.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 232,
												GroupLayout.PREFERRED_SIZE)
										.addContainerGap(79, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup().addContainerGap(32, Short.MAX_VALUE)
						.addComponent(lblIdUser).addGap(28).addComponent(textField, GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGap(79).addComponent(btnValidate).addGap(92)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addGap(35)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblAddComment)
								.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
				.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnValidate).addComponent(textField, GroupLayout.PREFERRED_SIZE,
								GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblIdUser)).addGap(42)));
		getContentPane().setLayout(groupLayout);
		// TODO Auto-generated constructor stub
	}

}
