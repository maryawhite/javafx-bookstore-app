package com.mwhite.bookstorejavafx;

import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.VBox;
import java.util.Optional;

public class OverviewLeftPane extends VBox {
    private Button buttonCreateBook = null;
    private Button buttonDeleteBook = null;
    private final OverviewTableView OVERVIEW_TABLE_VIEW;


    public OverviewLeftPane(OverviewTableView overviewTableView) {
        this.OVERVIEW_TABLE_VIEW = overviewTableView;
        initStuff();
    }

    private void initStuff(){
        this.getChildren().add(getButtonCreateBook());
        this.getChildren().add(getButtonDeleteBook());
        this.setSpacing(10);
        this.setPadding(new Insets(5));
    }

    private Button getButtonCreateBook() {
        if(buttonCreateBook == null) {
            buttonCreateBook = new Button("Create Book");
            buttonCreateBook.setOnAction((e) -> {
                System.out.println("create book");
                fireEvent(new CustomEvent(CustomEvent.GO_TO_CREATE_SCENE));
            });
        }
        return buttonCreateBook;
    }

    private Button getButtonDeleteBook() {
        if(buttonDeleteBook == null) {
            buttonDeleteBook = new Button("Delete Book");
            buttonDeleteBook.setOnAction((e) -> {
                System.out.println("Delete Book BEGIN");
                Book selectedBook = (Book) OVERVIEW_TABLE_VIEW
                        .getSelectionModel()
                        .getSelectedItem();
                if(selectedBook == null){
                    System.out.println("No book selected");
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.getDialogPane().setStyle("-fx-font-family: Serif");
                    alert.setContentText("No book selected");
                    alert.showAndWait();
                    return; //bc we don't want to continue with the rest of the code now
                }
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setContentText("Are you sure you want to delete the book");
                alert.setHeaderText(selectedBook.toString());  //make sure you have the toString method in the Book class
                alert.setTitle("Delete book?");
                alert.getDialogPane().setStyle("-fx-font-family: Serif");
                Optional<ButtonType> buttonType = alert.showAndWait();
                System.out.println("ButtonType " + buttonType.get().getText());

                if(buttonType.get() == ButtonType.OK) {
                    DataHandler.INSTANCE.deleteBook(selectedBook);
                    OVERVIEW_TABLE_VIEW.setItems(DataHandler.INSTANCE.booksList());
                } else {
                    System.out.println("cancel the delete");
                }
                System.out.println("END of delete book");
            });
        }
        return buttonDeleteBook;
    }
}
