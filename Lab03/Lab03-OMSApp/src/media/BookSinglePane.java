package media;

import com.oms.bean.Book;
import com.oms.bean.Media;
import com.oms.bean.PhysicalMedia;

import javax.swing.*;

@SuppressWarnings("serial")
public class BookSinglePane extends PhysicalMediaSinglePane {
    private JLabel labelPublisher;
    private JLabel labelPublicationDate;
    private JLabel labelAuthor;
    private JLabel labelNumberOfPages;
    private JLabel labelLanguage;

    public BookSinglePane() {
        super();
    }

    public BookSinglePane(Media media) {
        this();
        this.t = media;

        displayData();
    }

    @Override
    public void buildControls() {
        super.buildControls();
        int row = getLastRowIndex();
        c.gridx = 0;
        c.gridy = row;
        labelPublisher = new JLabel();
        add(labelPublisher, c);

        row = getLastRowIndex();
        c.gridx = 0;
        c.gridy = row;
        labelPublicationDate = new JLabel();
        add(labelPublicationDate, c);

        row = getLastRowIndex();
        c.gridx = 0;
        c.gridy = row;
        labelAuthor = new JLabel();
        add(labelAuthor, c);

        row = getLastRowIndex();
        c.gridx = 0;
        c.gridy = row;
        labelNumberOfPages = new JLabel();
        add(labelNumberOfPages, c);

        row = getLastRowIndex();
        c.gridx = 0;
        c.gridy = row;
        labelLanguage = new JLabel();
        add(labelLanguage, c);
    }

    @Override
    public void displayData() {
        super.displayData();
        if (t instanceof Book) {
            Book book = (Book) t;

            labelPublisher.setText("Publisher: " + book.getPublisher());
            labelPublicationDate.setText("Publication Date: " + book.getPublicationDate());
            labelAuthor.setText("Author: " + book.getAuthors());
            labelNumberOfPages.setText("Number of Pages: " + book.getNumberOfPages());
            labelLanguage.setText("Language: " + book.getLanguage());
        }
    }
}
