package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import MainandSystem.ShoppingSys;

import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ButtonGroup;
import javax.swing.JButton;

public class AddProductFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField product;
	private JTextField name;
	private JTextField desc;
	private JTextField price;
	private JTextField quantity;
	private JTextField width;
	private JTextField height;
	private JTextField material;
	private JTextField clotheSize;
	private JTextField fabType;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField shoeSize;
	private JTextField shoeType;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddProductFrame frame = new AddProductFrame();
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
	public AddProductFrame() {
		setTitle("Add Product");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JRadioButton Bagsrdbtn = new JRadioButton("Bags");
		buttonGroup.add(Bagsrdbtn);
		Bagsrdbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Bagsrdbtn.isSelected()) {
	                  width.setEditable(true);
	                  height.setEditable(true);
	                  material.setEditable(true);
	                  clotheSize.setEditable(false);
	                  fabType.setEditable(false);
	                  shoeSize.setEditable(false);
	                  shoeType.setEditable(false);
			}
				
			}
		});
		Bagsrdbtn.setSelected(true);
		Bagsrdbtn.setBounds(33, 6, 69, 23);
		contentPane.add(Bagsrdbtn);
		
		
		JRadioButton Shoesrdbtn = new JRadioButton("Shoes");
		Shoesrdbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Shoesrdbtn.isSelected()) {
	                  width.setEditable(false);
	                  height.setEditable(false);
	                  material.setEditable(false);
	                  clotheSize.setEditable(false);
	                  fabType.setEditable(false);
	                  shoeSize.setEditable(true);
	                  shoeType.setEditable(true);
			}
				
				
			}
		});
		buttonGroup.add(Shoesrdbtn);
		Shoesrdbtn.setBounds(145, 6, 87, 23);
		contentPane.add(Shoesrdbtn);
		
		JRadioButton Clothesrdbtn = new JRadioButton("Clothes");
		Clothesrdbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(Clothesrdbtn.isSelected()) {
	                  width.setEditable(false);
	                  height.setEditable(false);
	                  material.setEditable(false);
	                  clotheSize.setEditable(true);
	                  fabType.setEditable(true);
	                  shoeSize.setEditable(false);
	                  shoeType.setEditable(false);
			}
				
			}
		});
		buttonGroup.add(Clothesrdbtn);
		Clothesrdbtn.setBounds(269, 6, 87, 23);
		contentPane.add(Clothesrdbtn);
		
		product = new JTextField();
		product.setBounds(87, 52, 130, 26);
		contentPane.add(product);
		product.setColumns(10);
		
		name = new JTextField();
		name.setBounds(87, 90, 130, 26);
		contentPane.add(name);
		name.setColumns(10);
		
		desc = new JTextField();
		desc.setBounds(87, 128, 130, 26);
		contentPane.add(desc);
		desc.setColumns(10);
		
		price = new JTextField();
		price.setBounds(87, 160, 130, 26);
		contentPane.add(price);
		price.setColumns(10);
		
		quantity = new JTextField();
		quantity.setBounds(87, 198, 130, 26);
		contentPane.add(quantity);
		quantity.setColumns(10);
		
		width = new JTextField();
		width.setBounds(314, 36, 130, 26);
		contentPane.add(width);
		width.setColumns(10);
		
		height = new JTextField();
		height.setBounds(314, 64, 130, 26);
		contentPane.add(height);
		height.setColumns(10);
		
		material = new JTextField();
		material.setBounds(314, 90, 130, 32);
		contentPane.add(material);
		material.setColumns(10);
		
		clotheSize = new JTextField();
		clotheSize.setEditable(false);
		clotheSize.setBounds(314, 122, 130, 26);
		contentPane.add(clotheSize);
		clotheSize.setColumns(10);
		
		fabType = new JTextField();
		fabType.setEditable(false);
		fabType.setBounds(314, 150, 130, 26);
		contentPane.add(fabType);
		fabType.setColumns(10);
		
		JLabel labe = new JLabel("Product ID");
		labe.setBounds(6, 57, 84, 16);
		contentPane.add(labe);
		
		JLabel da = new JLabel("Name");
		da.setBounds(6, 95, 47, 16);
		contentPane.add(da);
		
		JLabel sda = new JLabel("Description");
		sda.setBounds(6, 127, 84, 16);
		contentPane.add(sda);
		
		JLabel sd = new JLabel("Price");
		sd.setBounds(6, 165, 61, 16);
		contentPane.add(sd);
		
		JLabel sdf = new JLabel("Quantity");
		sdf.setBounds(6, 202, 61, 16);
		contentPane.add(sdf);
		
		JLabel sdsd = new JLabel("Width");
		sdsd.setBounds(241, 41, 61, 16);
		contentPane.add(sdsd);
		
		JLabel sdfsdf = new JLabel("Height");
		sdfsdf.setBounds(241, 69, 61, 16);
		contentPane.add(sdfsdf);
		
		JLabel sfasaj = new JLabel("Material");
		sfasaj.setBounds(241, 95, 61, 16);
		contentPane.add(sfasaj);
		
		JLabel sfddşkssaşk = new JLabel("Clothe Size");
		sfddşkssaşk.setBounds(241, 128, 77, 16);
		contentPane.add(sfddşkssaşk);
		
		JLabel zlkcjz = new JLabel("Fabric Type");
		zlkcjz.setBounds(241, 155, 77, 16);
		contentPane.add(zlkcjz);
		
		JLabel şdlsd = new JLabel("Shoe Size");
		şdlsd.setBounds(241, 183, 61, 16);
		contentPane.add(şdlsd);
		
		JLabel sdsdalkeşdgjbgofısşzkl = new JLabel("Shoe Type");
		sdsdalkeşdgjbgofısşzkl.setBounds(241, 211, 70, 16);
		contentPane.add(sdsdalkeşdgjbgofısşzkl);
		
		shoeSize = new JTextField();
		shoeSize.setEditable(false);
		shoeSize.setBounds(314, 177, 130, 26);
		contentPane.add(shoeSize);
		shoeSize.setColumns(10);
		
		shoeType = new JTextField();
		shoeType.setEditable(false);
		shoeType.setBounds(314, 203, 130, 26);
		contentPane.add(shoeType);
		shoeType.setColumns(10);
		
		JLabel added = new JLabel("");
		added.setBounds(145, 241, 156, 16);
		contentPane.add(added);
		
		JButton Addbtn = new JButton("Add Product");
		Addbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean val;
			
				if(Bagsrdbtn.isSelected()) {
					if(product.getText().equalsIgnoreCase("") || name.getText().equalsIgnoreCase("") || desc.getText().equalsIgnoreCase("") ||
							price.getText().equalsIgnoreCase("") || quantity.getText().equalsIgnoreCase("") || width.getText().equalsIgnoreCase("") ||
							height.getText().equalsIgnoreCase("") || material.getText().equalsIgnoreCase("")) {
						added.setText("Please fill all the fields");
					}
					
					else {
					val =ShoppingSys.addProduct("Bags", Integer.parseInt(product.getText()) , name.getText(), desc.getText(),
							Double.parseDouble(price.getText()), Integer.parseInt(quantity.getText()), 
							Integer.parseInt(width.getText()), Integer.parseInt(height.getText()), material.getText(), 0, null, null, null);
					if(val) added.setText("Product is added");
					else added.setText("Product is NOT added");
					}
				}
				else if(Shoesrdbtn.isSelected()){
					if(product.getText().equalsIgnoreCase("") || name.getText().equalsIgnoreCase("") || desc.getText().equalsIgnoreCase("") ||
							price.getText().equalsIgnoreCase("") || quantity.getText().equalsIgnoreCase("") || shoeSize.getText().equalsIgnoreCase("") ||
							shoeType.getText().equalsIgnoreCase("")) {
						added.setText("Please fill all the fields");
					}
					
					else {
					val = ShoppingSys.addProduct("Shoes", Integer.parseInt(product.getText()), name.getText(), desc.getText(), Double.parseDouble(price.getText()), Integer.parseInt(quantity.getText()), 0, 0, null, Integer.parseInt(shoeSize.getText()), shoeType.getText(), null, null);
					if(val) added.setText("Product is added");
					else added.setText("Product is NOT added");
					}
				} else {
					if(product.getText().equalsIgnoreCase("") || name.getText().equalsIgnoreCase("") || desc.getText().equalsIgnoreCase("") ||
							price.getText().equalsIgnoreCase("") || quantity.getText().equalsIgnoreCase("") || clotheSize.getText().equalsIgnoreCase("") ||
							fabType.getText().equalsIgnoreCase("")) {
						added.setText("Please fill all the fields");
					}
					else {
					val = ShoppingSys.addProduct("Clothes", Integer.parseInt(product.getText()), name.getText(), desc.getText(), Double.parseDouble(price.getText()), Integer.parseInt(quantity.getText()), 0, 0, null, 0, null, clotheSize.getText(), fabType.getText());
					if(val) added.setText("Product is added");
					else added.setText("Product is NOT added");
					}
				}
			}
		});
		Addbtn.setBounds(6, 236, 117, 29);
		contentPane.add(Addbtn);
		
		JButton btnNewButton = new JButton("Close");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				AdminFrame af = new AdminFrame();
				af.setVisible(true);
			}
		});
		btnNewButton.setBounds(327, 236, 117, 29);
		contentPane.add(btnNewButton);

	}
}
