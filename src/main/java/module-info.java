module com.mwhite.bookstorejavafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.mwhite.bookstorejavafx to javafx.fxml;
    exports com.mwhite.bookstorejavafx;
}