package com.mwhite.bookstorejavafx.create;

import javafx.scene.layout.BorderPane;

public class CreatePane extends BorderPane {
    private CreateInputPane createInputPane = null;  //this is called lazy loading, you need a getter too
    private CreateBottomPane createBottomPane = null;

    public CreatePane() {
        initPane();
    }

    private void initPane() {
        setCenter(getCreateInputPane());
        setBottom(getCreateBottomPane());
        setPrefHeight(600);
        setPrefWidth(800);
    }

    public CreateInputPane getCreateInputPane() {
        if (createInputPane == null) {
            createInputPane = new CreateInputPane();
        }
        return createInputPane;
    }

    public CreateBottomPane getCreateBottomPane() {
        if (createBottomPane == null) {
            createBottomPane = new CreateBottomPane(getCreateInputPane());
        }
        return createBottomPane;
    }
}
