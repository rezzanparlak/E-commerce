package GUI;

import java.awt.EventQueue;
import java.awt.TextArea;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import MainandSystem.ShoppingSys;
import ProductsInheritance.Products;
import UserandOrder.User;

import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.JSpinner;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class CustomerFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField search;
	private JTextField payments;
	private JComboBox <String> productId;
	private User loggedUser;
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				LoginFrame lf = new LoginFrame();

				User u = lf.getUser();
				try {
					CustomerFrame frame = new CustomerFrame(u);
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
	
	public CustomerFrame(User user) {
		this.loggedUser = user;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(17, 10, 159, 240);
		contentPane.add(scrollPane);

		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setWrapStyleWord(true);
		
		JLabel warning = new JLabel("");
		warning.setBounds(197, 221, 234, 16);
		contentPane.add(warning);

		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		productId = new JComboBox(ShoppingSys.getIdArray());
		
		productId.setBounds(197, 11, 105, 27);
		contentPane.add(productId);
		JButton shoppingCardBtn = new JButton("Add to Card");
		shoppingCardBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = Integer.parseInt((String) productId.getSelectedItem());
				 boolean val = ShoppingSys.addShoppingCard(id);
				 if(val == true) warning.setText("Product is added");
				 else warning.setText("Product is NOT added");
				
			}
		});
		shoppingCardBtn.setBounds(314, 6, 117, 29);
		contentPane.add(shoppingCardBtn);
		
		
		
		search = new JTextField();
		search.setBounds(197, 39, 105, 26);
		contentPane.add(search);
		search.setColumns(10);
		
		JButton searchBtn = new JButton("Search ID");
		searchBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int searchId = Integer.parseInt(search.getText());
				Products p = ShoppingSys.searchProduct(searchId);
				textArea.setText(p.toString());
			}
		});
		searchBtn.setBounds(314, 39, 117, 29);
		contentPane.add(searchBtn);
		
		JButton calculateBtn = new JButton("Calculate Payments");
		calculateBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 double totPrice = ShoppingSys.calculateTotalPrice();
				 if(totPrice > 0) { payments.setText(totPrice + "");
				 warning.setText("If product has any discount, applied");}
				 else  warning.setText("Please add product to shopping card");
			}
		});
		calculateBtn.setBounds(188, 118, 243, 29);
		contentPane.add(calculateBtn);
		
		payments = new JTextField();
		payments.setBounds(301, 159, 130, 26);
		contentPane.add(payments);
		payments.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Total Payment: ");
		lblNewLabel.setBounds(197, 164, 105, 16);
		contentPane.add(lblNewLabel);
		
		

		
		JButton btnNewButton = new JButton("Display Products");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText(ShoppingSys.displayAvailableProducts());
			}
		});
		btnNewButton.setBounds(188, 77, 130, 29);
		contentPane.add(btnNewButton);
		
		JButton orderBtn = new JButton("Pay & Create Order");
		orderBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginFrame lf = new LoginFrame();

				if(ShoppingSys.getShoppingCard() != null) {
					
					boolean val = ShoppingSys.addOrder(user);
					if(val == true) {
						warning.setText("Order is created");
					}
					else warning.setText("Errorr!!");
				}
				else {
					warning.setText("Shoppping card is empty");
				}
				
			}
		});
		orderBtn.setBounds(225, 192, 159, 27);
		contentPane.add(orderBtn);
		
		JButton btnNewButton_1 = new JButton("Close");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				LoginFrame lf = new LoginFrame();
				lf.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(235, 237, 117, 29);
		contentPane.add(btnNewButton_1);
		
		JButton shoppingCardDisp = new JButton("Display Card");
		shoppingCardDisp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText(ShoppingSys.displayShoppingCard());
			}
		});
		shoppingCardDisp.setBounds(324, 77, 117, 29);
		contentPane.add(shoppingCardDisp);
		

		
		

	}
}
