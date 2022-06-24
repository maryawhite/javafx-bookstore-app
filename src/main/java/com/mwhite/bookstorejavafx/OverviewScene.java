package com.mwhite.bookstorejavafx;

import javafx.scene.Scene;

public class OverviewScene extends Scene {
    private OverviewPane overviewPane;

    public OverviewScene() {
        super(new OverviewPane());
        overviewPane = (OverviewPane)getRoot();
    }

    public void refreshData() {
        overviewPane.refreshData();
    }

}
