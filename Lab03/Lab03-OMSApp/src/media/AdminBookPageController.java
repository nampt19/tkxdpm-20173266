package media;

import java.util.List;
import java.util.Map;

import com.oms.bean.Book;
import com.oms.bean.Media;

import api.MediaApi;
import cart.CartController;
import editdialog.BookEditDialog;

public class AdminBookPageController extends AdminMediaPageController {
	public AdminBookPageController() {
		super();
	}
	public AdminBookPageController(CartController cartController) {
		super(cartController);
	}
	@Override
	public List<? extends Media> search(Map<String, String> searchParams) {
		return new MediaApi().getBooks(searchParams);
	}
	@Override
	public MediaSinglePane createSinglePane() {
		return new BookSinglePane();
	}
	@Override
	public MediaSearchPane createSearchPane() {
		return new BookSearchPane();
	}


	public  void getBookEditDialog(Book book,BookEditController controller){
		new BookEditDialog(book,controller);}

}
