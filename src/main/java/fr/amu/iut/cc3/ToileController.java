package fr.amu.iut.cc3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;

import java.net.URL;
import java.util.ResourceBundle;

public class ToileController implements Initializable {

    private static int rayonCercleExterieur = 200;
    private static int angleEnDegre = 60;
    private static int angleDepart = 90;
    private static int noteMaximale = 20;

    @FXML
    private TextField comp1;
    @FXML
    private TextField comp2;
    @FXML
    private TextField comp3;
    @FXML
    private TextField comp4;
    @FXML
    private TextField comp5;
    @FXML
    private TextField comp6;

    @FXML
    private HBox scene;

    @FXML
    private Pane spider;

    private Circle c1;
    private Circle c2;
    private Circle c3;
    private Circle c4;
    private Circle c5;
    private Circle c6;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    @FXML
    protected void handleCompAction(ActionEvent event) {
        TextField source = (TextField) event.getSource();
        int note = 0;
        try {
            note = Integer.parseInt(source.getText());
            System.out.println(note);
        } catch (NumberFormatException e) {
            System.out.println("Probleme de saisie du nombre");
        }
        // Calcul des coordonées du centre du cercle en fonction de l'axe
        int x = 0;
        int y = 0;
        if (source.getId() == comp1.getId()){
            x = getXRadarChart(note, 1);
            y = getYRadarChart(note, 1);
            // Dessin du cercle
            spider.getChildren().remove(c1);    // Enlever un point deja present
            c1 = new Circle( x,y, 5);
            spider.getChildren().add(c1);
        } else if (source.getId() == comp2.getId()){
            x = getXRadarChart(note, 2);
            y = getYRadarChart(note, 2);
            // Dessin du cercle
            spider.getChildren().remove(c2);    // Enlever un point deja present
            c2 = new Circle( x,y, 5);
            spider.getChildren().add(c2);
        } else if (source.getId() == comp3.getId()){
            x = getXRadarChart(note, 3);
            y = getYRadarChart(note, 3);
            // Dessin du cercle
            spider.getChildren().remove(c3);    // Enlever un point deja present
            c3 = new Circle( x,y, 5);
            spider.getChildren().add(c3);
        } else if (source.getId() == comp4.getId()){
            x = getXRadarChart(note, 4);
            y = getYRadarChart(note, 4);
            // Dessin du cercle
            spider.getChildren().remove(c4);    // Enlever un point deja present
            c4 = new Circle( x,y, 5);
            spider.getChildren().add(c4);
        } else if (source.getId() == comp5.getId()){
            x = getXRadarChart(note, 5);
            y = getYRadarChart(note, 5);
            // Dessin du cercle
            spider.getChildren().remove(c5);    // Enlever un point deja present
            c5 = new Circle( x,y, 5);
            spider.getChildren().add(c5);
        } else if (source.getId() == comp6.getId()){
            x = getXRadarChart(note, 6);
            y = getYRadarChart(note, 6);
            // Dessin du cercle
            spider.getChildren().remove(c6);    // Enlever un point deja present
            c6 = new Circle( x,y, 5);
            spider.getChildren().add(c6);
        }


    }

    int getXRadarChart(double value, int axe ){
        return (int) (rayonCercleExterieur + Math.cos(Math.toRadians(angleDepart - (axe-1)  * angleEnDegre)) * rayonCercleExterieur
                *  (value / noteMaximale));
    }

    int getYRadarChart(double value, int axe ){
        return (int) (rayonCercleExterieur - Math.sin(Math.toRadians(angleDepart - (axe-1)  * angleEnDegre)) * rayonCercleExterieur
                *  (value / noteMaximale));
    }

}
