package fr.amu.iut.cc3;

import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.util.StringConverter;
import javafx.util.converter.DoubleStringConverter;
import javafx.util.converter.NumberStringConverter;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
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
    private Label msgErreur;
    @FXML
    private Pane spider;

    private Circle c1;
    private Circle c2;
    private Circle c3;
    private Circle c4;
    private Circle c5;
    private Circle c6;

    private ArrayList<TextField> listTextfield = new ArrayList<TextField>();
    private ArrayList<Circle> listPoints = new ArrayList<>();
    private ArrayList<Line> listLine = new ArrayList<>();




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        listTextfield.add(comp1);
        listTextfield.add(comp2);
        listTextfield.add(comp3);
        listTextfield.add(comp4);
        listTextfield.add(comp5);
        listTextfield.add(comp6);

    }

    @FXML
    protected void handleTracerAction(ActionEvent e){
        if (c1 != null && c2 != null && c3 != null && c4 != null && c5 != null && c6 != null){
            for (int i = 0; i<listLine.size(); ++i){
                spider.getChildren().remove(listLine.get(i));
            }
            listPoints.addAll(Arrays.asList(c1,c2, c3, c4, c5, c6)); // Permet de tracer dans le bon ordre meme si les points n'ont pas ete rentres dans cet ordre
            for (int i = 0; i<listPoints.size()-1; ++i){
                Line l = new Line(listPoints.get(i).getCenterX(),listPoints.get(i).getCenterY(),listPoints.get(i+1).getCenterX(),listPoints.get(i+1).getCenterY());
                spider.getChildren().add(l);
                listLine.add(l);
            }

            Line l61 = new Line(c6.getCenterX(), c6.getCenterY(), c1.getCenterX(), c1.getCenterY());
            spider.getChildren().add(l61);
            listLine.add(l61);
       }
        else {
            msgErreur.setText("Erreur de trace :\n Manque de points");
        }
    }
    @FXML
    protected void handleViderAction(ActionEvent e){
        spider.getChildren().removeAll(c1, c2, c3, c4, c5, c6);
        msgErreur.setText("");
        for (int i = 0; i<listTextfield.size(); ++i){
            listTextfield.get(i).setText("");
        }
        for (int i = 0; i<listLine.size(); ++i){
            spider.getChildren().remove(listLine.get(i));
        }

    }
    @FXML
    protected void handleCompAction(ActionEvent event) {
        TextField source = (TextField) event.getSource();
        int note = 0;
        try {
            note = Integer.parseInt(source.getText());
        } catch (NumberFormatException e) {
            System.out.println("Probleme de saisie du nombre");
        }
        if (note < 0 || note > 20){
            msgErreur.setText("Erreur de saisie : \nLes valeurs doivent être\nentre 0 et 20");
        } else {
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
                spider.getChildren().remove(c6);    // Enlever un point deja present
                c6 = new Circle( x,y, 5);
                spider.getChildren().add(c6);
            }

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
