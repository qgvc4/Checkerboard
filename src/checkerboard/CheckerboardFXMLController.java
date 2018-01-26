/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkerboard;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author qiwenguo
 */
public class CheckerboardFXMLController implements Initializable {
    private Stage stage;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private MenuBar menuBar;
    private static boolean defaultColor = true;
    private static int numCols = 8;
    private static int numRows = 8;
    private double anchorWidth;
    private double anchorHeight;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void init(Stage stage) {
        this.stage = stage;
        addCheckerBoard(anchorPane.getWidth(), anchorPane.getHeight());
        
        ChangeListener<Number> listener = (ObservableValue<? extends Number> observableValue, Number oldValue, Number newValue) -> {
            anchorWidth = stage.getScene().getWidth();
            anchorHeight = stage.getScene().getHeight() - menuBar.getHeight();
            addCheckerBoard(anchorWidth , anchorHeight);
        };
        
        stage.widthProperty().addListener(listener);
        stage.heightProperty().addListener(listener);       
    }
    
    private void addCheckerBoard(double width, double height) {
        Qgvc4CheckerBoard checkerboard;
        if (defaultColor) {
            checkerboard = new Qgvc4CheckerBoard(numRows, numCols, width, height);
        } else {
            checkerboard = new Qgvc4CheckerBoard(numRows, numCols, width, height, Color.SKYBLUE, Color.DARKBLUE);
        }
        anchorPane.getChildren().setAll(checkerboard.build());
    }
    
    @FXML
    private void size16Click(ActionEvent event) {
        numRows = 16;
        numCols = 16;
        addCheckerBoard(anchorPane.getWidth(), anchorPane.getHeight());
    }

    @FXML
    private void size10Click(ActionEvent event) {
        numRows = 10;
        numCols = 10;
        addCheckerBoard(anchorPane.getWidth(), anchorPane.getHeight());
    }

    @FXML
    private void size8Click(ActionEvent event) {
        numRows = 8;
        numCols = 8;
        addCheckerBoard(anchorPane.getWidth(), anchorPane.getHeight());
    }

    @FXML
    private void size3Click(ActionEvent event) {
        numRows = 3;
        numCols = 3;
        addCheckerBoard(anchorPane.getWidth(), anchorPane.getHeight());
    }

    @FXML
    private void defaultColorClick(ActionEvent event) {
        defaultColor = true;
        addCheckerBoard(anchorPane.getWidth(), anchorPane.getHeight());
    }

    @FXML
    private void blueColorClick(ActionEvent event) {
        defaultColor = false;
        addCheckerBoard(anchorPane.getWidth(), anchorPane.getHeight());
    }
    
}
