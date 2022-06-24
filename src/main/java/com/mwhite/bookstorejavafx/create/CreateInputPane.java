package com.mwhite.bookstorejavafx.create;

import com.mwhite.bookstorejavafx.Book;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.text.Text;

public class CreateInputPane extends GridPane {

    private Text txtTitle;  //Text is like the Label
    private TextField title;
    private Text txtAuthor;
    private TextField author;
    private Text txtPrice;
    private TextField price;


    //constructor
    public CreateInputPane(){
        initPane();
    }

    private void initPane() {
        getChildren().addAll(
                getTxtTitle(), getTitle(),
                getTxtAuthor(), getAuthor(),
                getTxtPrice(), getPrice()
        );
        ColumnConstraints c1 = new ColumnConstraints(200);
        ColumnConstraints c2 = new ColumnConstraints(300);
        c2.setHgrow(Priority.ALWAYS);
        getColumnConstraints().addAll(c1, c2);
        int row = 0;
        int column = 0;
        setRowIndex(getTxtTitle(), row);
        setRowIndex(getTitle(), row++);
        setColumnIndex(getTxtTitle(), column++);
        setColumnIndex(getTitle(), column);
        column = 0;
        setRowIndex(getTxtAuthor(), row);
        setRowIndex(getAuthor(), row++);
        setColumnIndex(getTxtAuthor(), column++);
        setColumnIndex(getAuthor(), column);
        column = 0;
        setRowIndex(getTxtPrice(), row);
        setRowIndex(getPrice(), row++);
        setColumnIndex(getTxtPrice(), column++);
        setColumnIndex(getPrice(), column);

        setStyle("-fx-font-family: Serif");  //running on Macbook pro Monterey and IntelliJ 2021.2.
    }

    private Text getTxtTitle() {
        if(txtTitle == null) {
            txtTitle = new Text("Title");
        }
        return txtTitle;
    }

    public TextField getTitle() {
        if(title == null) {
            title = new TextField("NOT_SET");
        }
        return title;
    }

    public Text getTxtAuthor() {
        if(txtAuthor == null) {
            txtAuthor = new Text("Author");
        }
        return txtAuthor;
    }

    public TextField getAuthor() {
        if(author == null) {
            author = new TextField("NOT_SET");
        }
        return author;
    }

    public Text getTxtPrice() {
        if(txtPrice == null) {
            txtPrice = new Text("Price");
        }
        return txtPrice;
    }

    public TextField getPrice() {
        if(price == null) {
            price = new TextField("NOT_SET");
        }
        return price;
    }

    public Book book() {
        return new Book(
                getTitle().getText(),
                getAuthor().getText(),
                Double.parseDouble(getPrice().getText())
        );
    }
}
