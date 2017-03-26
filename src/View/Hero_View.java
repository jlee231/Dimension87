package View;

import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Hero_View extends Rectangle{

	Rectangle rect;
	ImageView image = new ImageView();
	private boolean selected = false;
	
	public Hero_View(){
		
	}
	
	public void makeSquare(double xPosition, double d, int i) {
		rect = new Rectangle(xPosition, d, i, i);
		rect.setFill(Color.WHITE);
	}

	public double getXPos(){
		return rect.getX();
	}
	
	public double getYPos(){
		return rect.getY();
	}
	
	public double getSize(){
		return rect.getWidth();
	}
	
	public void setImageNow(Image img) {
		image.setImage(img);
	}

	public void setColor(Color c) {
		rect.setFill(c);
	}

	public boolean getSelected() {
		return selected;
	}

	public void setSelected(boolean b) {
		selected = b;
	}

}
