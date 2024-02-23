package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import MainandSystem.ShoppingSys;


import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class AdminFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	AddProductFrame af = new AddProductFrame();
	private JTextField removePro;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminFrame frame = new AdminFrame();
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
	public AdminFrame() {
		setTitle("Admin");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 6, 270, 260);
		contentPane.add(scrollPane);
		
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JButton Orderbtn = new JButton("Order");
		Orderbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ShoppingSys.displayOrders().equalsIgnoreCase("")) {
					textArea.setText("No order");
					
				}
				else
				{  
					textArea.setText(ShoppingSys.displayOrders());
				}
					
			
			}
		});
		Orderbtn.setBounds(288, 30, 117, 29);
		contentPane.add(Orderbtn);
		
	
		
		JButton Productbtn = new JButton("Product");
		Productbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textArea.setText(ShoppingSys.displayAvailableProducts());
				
			}
		});
		Productbtn.setBounds(288, 71, 117, 29);
		contentPane.add(Productbtn);
		
		JButton Addbtn = new JButton("Add Product");
		Addbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				af.setVisible(true);
				
			}
		});
		Addbtn.setBounds(288, 112, 117, 29);
		contentPane.add(Addbtn);
		
		JButton btnNewButton = new JButton("Close");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				LoginFrame lf = new LoginFrame();
				lf.setVisible(true);
			}
		});
		btnNewButton.setBounds(288, 237, 146, 29);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Product Id to Remove");
		lblNewLabel.setBounds(288, 153, 146, 16);
		contentPane.add(lblNewLabel);
		
		removePro = new JTextField();
		removePro.setBounds(288, 169, 146, 26);
		contentPane.add(removePro);
		removePro.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Remove Product");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String productId = removePro.getText();
				boolean res = ShoppingSys.removeProduct(Integer.parseInt(productId));
				if(res) textArea.setText(productId + " is removed");
				else textArea.setText(productId + " is not removed");
			}
		});
		btnNewButton_1.setBounds(288, 209, 146, 29);
		contentPane.add(btnNewButton_1);
	
	
	}
}
