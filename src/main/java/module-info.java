module co.edu.uniquindio.poo.eltrigaljfx {
    requires javafx.controls;
    requires javafx.fxml;

    opens co.edu.uniquindio.poo.eltrigaljfx.model to javafx.base;
    exports co.edu.uniquindio.poo.eltrigaljfx.model;

    opens co.edu.uniquindio.poo.eltrigaljfx.app to javafx.fxml;
    exports co.edu.uniquindio.poo.eltrigaljfx.app;

    opens co.edu.uniquindio.poo.eltrigaljfx.controller to javafx.fxml;
    exports co.edu.uniquindio.poo.eltrigaljfx.controller;

    opens co.edu.uniquindio.poo.eltrigaljfx.viewController to javafx.fxml;
    exports co.edu.uniquindio.poo.eltrigaljfx.viewController;
}