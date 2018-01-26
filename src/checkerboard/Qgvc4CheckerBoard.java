/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkerboard;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author qiwenguo
 */
public class Qgvc4CheckerBoard {
    private int numRows;
    private int numCols;
    private double boardWidth;
    private double boardHeight;
    private Color lightColor = Color.RED;
    private Color darkColor = Color.BLACK;
    private AnchorPane anchorPane;
        
    public Qgvc4CheckerBoard(int numRows, int numCols, double boardWidth, double boardHeight) {
        this.numRows = numRows;
        this.numCols = numCols;
        this.boardWidth = boardWidth;
        this.boardHeight = boardHeight;
        anchorPane = new AnchorPane();
    }
    
    public Qgvc4CheckerBoard(int numRows, int numCols, double boardWidth, double boardHeight, Color lightColor, Color darkColor) {
        this(numRows, numCols, boardWidth, boardHeight);
        this.lightColor = lightColor;
        this.darkColor = darkColor;
    }
    
    public AnchorPane build() {
        double rectWidth = boardWidth / numRows;
        double rectHeight = boardHeight / numCols;
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                Rectangle rect;
                if ((i + j) % 2 == 0) {
                    rect = new Rectangle(rectWidth, rectHeight, lightColor); 
                } else {
                    rect = new Rectangle(rectWidth, rectHeight, darkColor); 
                }
                anchorPane.getChildren().add(rect);
                AnchorPane.setTopAnchor(rect, rectHeight * j);
                AnchorPane.setLeftAnchor(rect, rectWidth * i);
            }
        }
        return anchorPane;
    }
    
    public AnchorPane getBoard() {
        return anchorPane;
    }
    
    //getters
    public int getNumRows() {
        return numRows;
    }
    
    public int getNumCols() {
        return numCols;
    }
    
    public double getWidth() {
        return boardWidth;
    }
    
    public double getHeight() {
        return boardHeight;
    }
    
    public Color getLightColor() {
        return lightColor;
    }
    
    public Color getDarkColor() {
        return darkColor;
    }
    
}
