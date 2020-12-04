package main;

import javax.swing.JPanel;

import cart.CartController;
import media.AdminBookPageController;

public class OMSAdminController {
	private CartController cartController;
	
	public OMSAdminController() {
		cartController = new CartController();
	}
	
	public JPanel getCartPane() {
		return cartController.getCartPane();
	}
	
	public JPanel getBookPage() {
		AdminBookPageController controller = new AdminBookPageController();
		controller.setCartController(cartController);
		return controller.getDataPagePane();
	}
}
