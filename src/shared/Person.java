package shared;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import model.Model;

/**
 * Created by phani on 3/25/2017.
 */
public class Person {
    Image image;
    Model model;
    int x;
    int y;
    String name;
    int radius;

    int health;
    int def;
    int atk;
    int range;
    public Person(String name,Image image, int x, int y, int radius, int health, int atk, int range, int def ) {
        this.name = name;
        this.image = image;
        this.model = model;
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.health = health;
        this.atk = atk;
        this.range = range;
        this.def = def;
        model.setPlayerSpot(this,y,x);
    }


    public void moveUp(){
        int x1 = x;
        int y1 = y + 1;
        if(model.inBounds(x1,y1)){
            Tile t;
            t = model.getMapVal(x1,y1);
            t.setPlayer(this);
            t = model.getMapVal(x,y);
            t.removePlayer();
        }
    }
    public void moveDown(){
        int x1 = x;
        int y1 = y - 1;
        if(model.inBounds(x1,y1)){
            Tile t;
            t = model.getMapVal(x1,y1);
            t.setPlayer(this);
            t = model.getMapVal(x,y);
            t.removePlayer();
        }
    }
    public void moveRight(){
        int x1 = x + 1;
        int y1 = y;
        if(model.inBounds(x1,y1)){
            Tile t;
            t = model.getMapVal(x1,y1);
            t.setPlayer(this);
            t = model.getMapVal(x,y);
            t.removePlayer();
        }
    }
    public void moveLeft(){
        int x1 = x - 1;
        int y1 = y;
        if(model.inBounds(x1,y1)){
            Tile t;
            t = model.getMapVal(x1,y1);
            t.setPlayer(this);
            t = model.getMapVal(x,y);
            t.removePlayer();
        }

    }

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
}
