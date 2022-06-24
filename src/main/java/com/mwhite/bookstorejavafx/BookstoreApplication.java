package com.mwhite.bookstorejavafx;

import com.mwhite.bookstorejavafx.create.CreateScene;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class BookstoreApplication extends Application {

    private OverviewScene overviewScene = null;
    private CreateScene createScene = null;
    private Stage stage;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        this.stage = stage;
        stage.setTitle("Bookstore Application");
        stage.setScene(getOverviewScene());
        stage.show();

    }

    private OverviewScene getOverviewScene() {
        if (overviewScene == null) {
            overviewScene = new OverviewScene();
            overviewScene.getRoot().setStyle("-fx-background-color: red; -fx-font-family: Serif;");
            overviewScene.addEventFilter(CustomEvent.GO_TO_CREATE_SCENE, (e) -> {
                stage.setScene(getCreateScene());
            });
        }
        return overviewScene;
    }

    private CreateScene getCreateScene() {
        if (createScene == null) {
            createScene = new CreateScene();
            createScene.addEventFilter(CustomEvent.GO_TO_OVERVIEW_SCENE, (e) -> {
                System.out.println("Change scene to Overview Book BEGIN");
                stage.setScene(getOverviewScene());  //when using lazy load use the getter
                overviewScene.refreshData();
            });
        }
        return createScene;
    }
}

//from Java Code Geeks on Youtube, https://youtu.be/RDvAx1_rIxk