package media;

import com.oms.bean.Media;

import abstractdata.ADataListPane;
import abstractdata.ADataPageController;
import cart.CartController;

public abstract class AdminMediaPageController extends ADataPageController<Media> {
	private CartController cartController;

	public AdminMediaPageController() {
		super();
	}
	
	public AdminMediaPageController(CartController cartController) {
		this();
		setCartController(cartController);
	}
	
	public void setCartController(CartController cartController) {
		this.cartController = cartController;
	}
	
	@Override
	public ADataListPane<Media> createListPane() {
		return new AdminMediaListPane(this);
	}
	
	public void addToCart(String productId, String productTitle, float productCost, int productQuantity) {
		cartController.addToCart(productId, productTitle, productCost, productQuantity);
	}

}
