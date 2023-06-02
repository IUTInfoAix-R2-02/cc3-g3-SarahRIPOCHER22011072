package fr.amu.iut.cc3;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.io.IOException;

public class ToileApp extends Application {

    //private static ChangeListener<TextField> pointsListener;



    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("toile.fxml"));
        primaryStage.setResizable(false);
        //primaryStage.setHeight( 420 );
        //primaryStage.setWidth(650);
        primaryStage.setScene( new Scene(root) );
        primaryStage.setTitle("Resultat aux differentes competences du BUT");
        primaryStage.show();
    }

}

