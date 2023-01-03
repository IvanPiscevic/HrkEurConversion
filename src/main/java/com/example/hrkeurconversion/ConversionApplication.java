package com.example.hrkeurconversion;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;
import java.util.Optional;

public class ConversionApplication extends Application {

    private static Stage mainStage;

    @Override
    public void start(Stage stage) throws IOException {
        mainStage = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("mainScreen.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Caffe Revelin ©");

        Optional<Image> imageOptional = Optional.of(
                new Image(Objects.requireNonNull(
                        getClass().getResourceAsStream("/img/eur_icon.png"))));

        stage.getIcons().add(imageOptional.get());
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static Stage getStage() {
        return mainStage;
    }

    public static void main(String[] args) {
        launch();
    }
}