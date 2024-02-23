package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import MainandSystem.ShoppingSys;
import UserandOrder.User;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class LoginFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField username;
	private JPasswordField password;
	private User u;
	
	public void setUser(User u) {
		this.u = u;
		System.out.println("User set" + u.toString() + u.getUserId());
}
	public User getUser() {
		return u;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
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
	public LoginFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		username = new JTextField();
		username.setBounds(185, 58, 165, 26);
		contentPane.add(username);
		username.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("User Name:");
		lblNewLabel.setBounds(78, 63, 95, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password: ");
		lblNewLabel_1.setBounds(78, 106, 81, 16);
		contentPane.add(lblNewLabel_1);
		
		password = new JPasswordField();
		password.setBounds(185, 96, 165, 26);
		contentPane.add(password);
		password.setColumns(10);
		
		JLabel errorLabel = new JLabel("");
		errorLabel.setBounds(23, 212, 395, 16);
		contentPane.add(errorLabel);
		
		JButton adminBtn = new JButton("Admin");
		adminBtn.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
			
				if(username.getText().equals("") || password.getText().equals("")) {
					errorLabel.setText("Please enter username and password");
				}else {
					User admin = ShoppingSys.login(username.getText(), password.getText());
					
					if(admin != null) {
						dispose();
						AdminFrame af = new AdminFrame();
						af.setVisible(true);
					}
					else {
						errorLabel.setText("You are not an admin");
					}
				}
				
			}
		});
		adminBtn.setBounds(24, 156, 165, 29);
		contentPane.add(adminBtn);
	
		JButton cstBtn = new JButton("Customer");
		cstBtn.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				
				if(username.getText().equals("") || password.getText().equals("")) {
					errorLabel.setText("Please enter username and password");
				}
				else {
					User cust = ShoppingSys.addUser(username.getText(), password.getText());
					
					if(cust != null) {
						setUser(cust);
						dispose();
						CustomerFrame cf = new CustomerFrame(cust);
						cf.setVisible(true);
					}
					else {errorLabel.setText("Error!! Please try again");
			
					}
					
				}
				
			}
		});
		cstBtn.setBounds(241, 156, 165, 29);
		contentPane.add(cstBtn);
		
		JLabel lblNewLabel_2 = new JLabel("Welcome!");
		lblNewLabel_2.setBounds(200, 18, 61, 16);
		contentPane.add(lblNewLabel_2);
		

	}
}
