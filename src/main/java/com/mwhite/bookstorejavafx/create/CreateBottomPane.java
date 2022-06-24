package com.mwhite.bookstorejavafx.create;

import com.mwhite.bookstorejavafx.CustomEvent;
import com.mwhite.bookstorejavafx.DataHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class CreateBottomPane extends HBox {
    private Button cancel = null;
    private Button ok = null;
    private final CreateInputPane inputPane;

    public CreateBottomPane(CreateInputPane inputPane) {
        this.inputPane = inputPane;
        initPane();
    }

    private void initPane() {
        getChildren().addAll(getCancel(), getOk());
        setStyle("-fx-font-family: Serif; -fx-padding: 10; -fx-spacing: 10");
        //the padding moves the buttons away from the edge. And the spacing puts space between the ok and cancel button
    }

    public Button getCancel() {
        if (cancel == null) {
            cancel = new Button("Cancel");
            cancel.setOnAction((e) -> {
                System.out.println("Cancel...");
                fireEvent(new CustomEvent(CustomEvent.GO_TO_OVERVIEW_SCENE));
            });
        }
        return cancel;
    }

    public Button getOk() {
        if (ok == null) {
            ok = new Button("OK");
            ok.setOnAction((e) -> {
                System.out.println("OK...");
                DataHandler.INSTANCE.createBook(inputPane.book());
                fireEvent(new CustomEvent(CustomEvent.GO_TO_OVERVIEW_SCENE));
            });
        }
        return ok;
    }
}
