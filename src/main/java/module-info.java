module org.example.java_client_desktop {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.bootstrapfx.core;
    requires com.almasb.fxgl.all;

    opens org.example.java_client_desktop to javafx.fxml;
    exports org.example.java_client_desktop;
    exports org.example.java_client_desktop.UI;
    opens org.example.java_client_desktop.UI to javafx.fxml;
}