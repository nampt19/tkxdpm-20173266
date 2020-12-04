package media;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import com.oms.bean.Book;
import com.oms.bean.Media;

import abstractdata.ADataListPane;
import abstractdata.ADataPageController;
import abstractdata.ADataSinglePane;

@SuppressWarnings("serial")
public class AdminMediaListPane extends ADataListPane<Media>{

	private BookEditController bookEditController = new BookEditController();

	public AdminMediaListPane(ADataPageController<Media> controller) {
		this.controller = controller;
	}
	

	@Override
	public void decorateSinglePane(ADataSinglePane<Media> singlePane) {
//		JSpinner spin = new JSpinner();
//		spin.setModel(new SpinnerNumberModel(1, 0, null, 1));
//		singlePane.addDataHandlingComponent(spin);
//		spin.setPreferredSize(new Dimension(100, 20));

		//JButton button = new JButton("Add to cart");
		JButton button = new JButton("Edit");

		singlePane.addDataHandlingComponent(button);
		
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
//				if (controller instanceof UserMediaPageController) {
//				((UserMediaPageController) controller).addToCart(singlePane.getData().getId(), singlePane.getData().getTitle(), singlePane.getData().getCost(), (int)spin.getValue());
//
//				}
				if(controller instanceof AdminBookPageController){
					((AdminBookPageController) controller).getBookEditDialog((Book) singlePane.getData(),bookEditController);
				}
			}
		});
	}
}
