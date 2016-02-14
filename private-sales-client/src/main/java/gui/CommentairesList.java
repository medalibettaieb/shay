package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;

import delegate.CommentaireDelegate;
import entities.Commentaire;

public class CommentairesList extends JFrame {

	private JPanel contentPane;
	List<Commentaire> commentaires;
	private JTable table;

	/**
	 * Create the frame.
	 */
	public CommentairesList(Integer idAnnoncement) {
		commentaires = CommentaireDelegate.doFindAllCommentairesByAnnoncementId(idAnnoncement);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JScrollPane scrollPane = new JScrollPane();

		JButton btnGoToThe = new JButton("go to the list");
		btnGoToThe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				AnnoncementsList annoncementsList = new AnnoncementsList();
				annoncementsList.setVisible(true);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addGap(36)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING).addComponent(btnGoToThe)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 313, GroupLayout.PREFERRED_SIZE))
				.addContainerGap(75, Short.MAX_VALUE)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap()
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 34, Short.MAX_VALUE).addComponent(btnGoToThe)));

		table = new JTable();
		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);
		initDataBindings();
	}

	protected void initDataBindings() {
		JTableBinding<Commentaire, List<Commentaire>, JTable> jTableBinding = SwingBindings
				.createJTableBinding(UpdateStrategy.READ, commentaires, table);
		//
		BeanProperty<Commentaire, String> commentaireBeanProperty = BeanProperty.create("text");
		jTableBinding.addColumnBinding(commentaireBeanProperty).setColumnName("text of the comment");
		//
		jTableBinding.bind();
	}
}
