package MainandSystem;

import GUI.LoginFrame;


public class ShoppingMain {

	public static void main(String[] args) {
		ShoppingSys.readFromFile();
		LoginFrame lf = new LoginFrame();
		lf.setVisible(true);

	}

}
