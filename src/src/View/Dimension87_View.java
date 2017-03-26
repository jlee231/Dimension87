package View;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import model.Model;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Dimension87_View extends Group implements Dimension87_ViewInterface<Image>{

	private ImageView[][] images;

	private Model model;
	private int pixelSize;
	
	private int rows;
	private int cols;
	
	public Dimension87_View(){
		this.model = null;
		this.images = null;
		pixelSize = 64;
	}
	
	@Override
	public void setImageAt(int row, int col, Image img) {
		images[row][col].setImage(img);
	}

	@Override
	public Image getImageAt(int row, int col) {
		return images[row][col].getImage();
	}

	@Override
	public int getX(double x) {
		x = x + rows*pixelSize / 2;
		x = x / pixelSize;
		return (int) (x );
	}

	@Override
	public int getY(double y) {
		y = y + cols*pixelSize / 2;
		y = y / pixelSize;
		return (int) (y );
	}

	@Override
	public void setModel(Model _model) {
		model = _model;
		rows = model.getNumRows();
		cols = model.getNumCols();
	}
	
	public void createTitleScreen(double width, double height){
		this.setTranslateX(0);
		this.setTranslateY(0);
		
		Label messageContinue = new Label("Press Spacebar to Continue");
		messageContinue.setFont(new Font(75));
		messageContinue.setTranslateX(width / 10);
		
		Label howToPlay = new Label("How to Play");
		howToPlay.setFont(new Font(100));
		howToPlay.setTranslateY(height / 4);
		howToPlay.setTranslateX(width / 1);
		
		Label about = new Label("Credits");
		about.setFont(new Font(50));
		
		this.getChildren().add(howToPlay);
		this.getChildren().add(messageContinue);
		this.getChildren().add(about);

	}
	
	public void createCharacterSelectScreen(){
		
	}
	
	public void createBattleGrounds(){
		
	}
	
}
