module co.edu.uniquindio.poo.eltrigaljfx {
    requires javafx.controls;
    requires javafx.fxml;


    // Abrir model globalmente para JavaFX y JUnit
    opens co.edu.uniquindio.poo.eltrigaljfx.model;
    exports co.edu.uniquindio.poo.eltrigaljfx.model;

    // Configuración para el resto de capas
    opens co.edu.uniquindio.poo.eltrigaljfx.app to javafx.fxml;
    exports co.edu.uniquindio.poo.eltrigaljfx.app;

    opens co.edu.uniquindio.poo.eltrigaljfx.controller to javafx.fxml;
    exports co.edu.uniquindio.poo.eltrigaljfx.controller;
}