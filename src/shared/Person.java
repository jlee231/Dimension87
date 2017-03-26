package shared;

import javafx.scene.image.ImageView;

import javafx.scene.image.Image;
import model.Model;
import java.awt.geom.Point2D;
import java.util.ArrayList;

/**
 * Created by phani on 3/25/2017.
 */
public class Person {
    Image image;
    //Model model;
    int x;
    int y;
    int width = 2;
    int height = 2;
    String name;

    int radius;
    int health;
    int def;
    int atk;
    int range;

    public Person(Model model,String name,Image image, int x, int y, int radius, int health, int atk, int range, int def ) {
        this.name = name;
        this.image = image;
        //this.model = model;
        this.x = x;
        this.y = y;
        //model.setPlayerSpot(y,x);
    }

    /*
    public void moveUp(){
=======
    public void LegalMoves(){
        ArrayList<Integer> xPos = new ArrayList<Integer>();
        ArrayList<Integer> yPos = new ArrayList<Integer>();
        ArrayList<Point2D> legalMoves = new ArrayList<Point2D>();
        for (int i = 0; i <= radius ; i++) {
            xPos.add(x+i);
            xPos.add(x-i);
            yPos.add(y+i);
            yPos.add(y-i);
        }
        for (int i = 0; i < xPos.size() ; i++) {
            for (int j = 0; j < xPos.size() ; j++) {
                if(model.inBounds(xPos.get(i),yPos.get(j))){
                    Point2D move = new Point2D.Double(xPos.get(i),yPos.get(j));
                    legalMoves.add(move);
                }
            }
        }
    }

    public void moveUp(int num){
>>>>>>> 320dcca588df83d0ef96d5db6033058b08fe5a93
        int x1 = x;
        int y1 = y + num;
        if(model.inBounds(x1,y1)){
            x = x1;
            y = y1;
            Tile t;
            t = model.getMapVal(y,x);
            //t.setPlayer(this);
        }
    }
    public void moveDown(int num){
        int x1 = x;
        int y1 = y - num;
        if(model.inBounds(x1,y1)){
            x = x1;
            y = y1;
            Tile t;
            t = model.getMapVal(y,x);
            //t.setPlayer(this);
            x = x1;
            y = y1;
        }
    }
    public void moveRight(int num){
        int x1 = x + num;
        int y1 = y;
        if(model.inBounds(x1,y1)){
            x = x1;
            y = y1;
            Tile t;
            t = model.getMapVal(y,x);
            //t.setPlayer(this);
            x = x1;
            y = y1;
        }
    }
    public void moveLeft(int num){
        int x1 = x - num;
        int y1 = y;
        if(model.inBounds(x1,y1)){
            x = x1;
            y = y1;
            Tile t;
            t = model.getMapVal(y,x);
            //t.setPlayer(this);
            x = x1;
            y = y1;
        }
    }*/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public int getCol() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getRow() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }
}
