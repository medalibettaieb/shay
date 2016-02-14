package gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.beansbinding.Bindings;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;

import delegate.AnnoncementDelegate;
import entities.Annoncement;

public class AnnoncementsList extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	List<Annoncement> annoncements;
	Annoncement annoncementSelected = new Annoncement();
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AnnoncementsList frame = new AnnoncementsList();
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
	public AnnoncementsList() {
		annoncements = AnnoncementDelegate.doFindAllAnnoncements();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JScrollPane scrollPane = new JScrollPane();

		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane
				.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup().addGap(19)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(panel, GroupLayout.PREFERRED_SIZE, 384,
												GroupLayout.PREFERRED_SIZE)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 385, GroupLayout.PREFERRED_SIZE))
				.addContainerGap(20, Short.MAX_VALUE)));
		gl_contentPane
				.setVerticalGroup(
						gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup().addContainerGap()
										.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 123,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(panel, GroupLayout.PREFERRED_SIZE, 103,
												GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		JLabel lblName = new JLabel("name");

		JLabel lblPrice = new JLabel("price");

		textField = new JTextField();
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setColumns(10);

		JButton btnNewButton = new JButton("update");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				annoncementSelected.setName(textField.getText());
				annoncementSelected.setPrice(Float.valueOf(textField_1.getText()));
				AnnoncementDelegate.doUpdateAnnoncement(annoncementSelected);
				setVisible(false);
				AnnoncementsList annoncementsList = new AnnoncementsList();
				annoncementsList.setVisible(true);
				initDataBindings();
			}
		});

		JButton btnNewButton_1 = new JButton("delete");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AnnoncementDelegate.doDeleteAnnoncementById(annoncementSelected.getId());
				initDataBindings();
				setVisible(false);
				AnnoncementsList annoncementsList = new AnnoncementsList();
				annoncementsList.setVisible(true);
			}
		});

		JButton btnNewButton_2 = new JButton("add comment");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				AddCommentaire addCommentaire = new AddCommentaire(annoncementSelected.getId());
				addCommentaire.setVisible(true);
			}
		});

		JButton btnShowCommentaires = new JButton("show commentaires");
		btnShowCommentaires.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				CommentairesList commentairesList = new CommentairesList(annoncementSelected.getId());
				commentairesList.setVisible(true);
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addGap(10)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup().addComponent(lblName)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup().addComponent(lblPrice)
								.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(textField_1,
										GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)))
				.addGap(32)
				.addGroup(gl_panel.createParallelGroup(Alignment.LEADING).addComponent(btnNewButton_1)
						.addComponent(btnNewButton)).addPreferredGap(ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
				.addGroup(gl_panel.createParallelGroup(Alignment.LEADING).addComponent(btnShowCommentaires)
						.addComponent(btnNewButton_2)).addGap(28)));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup().addGap(15)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(lblName)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNewButton).addComponent(btnShowCommentaires))
				.addGap(6)
				.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE).addComponent(lblPrice)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNewButton_1).addComponent(btnNewButton_2)).addGap(29)));
		panel.setLayout(gl_panel);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				annoncementSelected = AnnoncementDelegate
						.doFindAnnoncementById(annoncements.get(table.getSelectedRow()).getId());
				System.out.println(annoncementSelected.getName());
				textField.setText(annoncementSelected.getName());
				textField_1.setText(String.valueOf(annoncementSelected.getPrice()));
			}
		});

		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);
		initDataBindings();
	}

	protected void initDataBindings() {
		JTableBinding<Annoncement, List<Annoncement>, JTable> jTableBinding = SwingBindings
				.createJTableBinding(UpdateStrategy.READ, annoncements, table);
		//
		BeanProperty<Annoncement, Integer> annoncementBeanProperty = BeanProperty.create("id");
		jTableBinding.addColumnBinding(annoncementBeanProperty).setColumnName("id");
		//
		BeanProperty<Annoncement, String> annoncementBeanProperty_1 = BeanProperty.create("name");
		jTableBinding.addColumnBinding(annoncementBeanProperty_1).setColumnName("name");
		//
		BeanProperty<Annoncement, Float> annoncementBeanProperty_2 = BeanProperty.create("price");
		jTableBinding.addColumnBinding(annoncementBeanProperty_2).setColumnName("price");
		//
		BeanProperty<Annoncement, String> annoncementBeanProperty_3 = BeanProperty.create("user.name");
		jTableBinding.addColumnBinding(annoncementBeanProperty_3).setColumnName("user name");
		//
		jTableBinding.bind();
		//
		BeanProperty<JTextField, String> jTextFieldBeanProperty = BeanProperty.create("text");
		BeanProperty<Annoncement, String> annoncementBeanProperty_4 = BeanProperty.create("name");
		AutoBinding<JTextField, String, Annoncement, String> autoBinding = Bindings.createAutoBinding(
				UpdateStrategy.READ_WRITE, textField, jTextFieldBeanProperty, annoncementSelected,
				annoncementBeanProperty_4);
		autoBinding.bind();
	}
}
