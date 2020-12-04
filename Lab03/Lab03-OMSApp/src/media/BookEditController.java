package media;

import abstractdata.IDataManageController;
import api.MediaApi;
import com.oms.bean.Book;
import com.oms.bean.Media;

public class BookEditController  implements IDataManageController {
    @Override
    public void create(Object o) {

    }

    @Override
    public void read(Object o) {

    }

    @Override
    public void delete(Object o) {

    }

    @Override
    public void update(Object o) {
        new MediaApi().updateBook((Book) o);
    }
}
