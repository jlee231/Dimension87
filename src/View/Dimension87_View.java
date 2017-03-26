package View;
import java.util.ArrayList;

import Controller.Dimension87_Controller;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import model.Model;
import shared.Person;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

public class Dimension87_View extends Group implements Dimension87_ViewInterface<Image>{

	private ImageView[][] images;
	
	private ArrayList<Hero_View> leftTeam = new ArrayList<Hero_View>();
	private ArrayList<Hero_View> rightTeam = new ArrayList<Hero_View>();
	
	private Image titleScreenImage = new Image("file:DImages/screenTitle.png");
	private Image characterSelectImage = new Image("file:DImages/screenSelect.png");
	
	private Image knightLeft = new Image("file:DImages/playerKnightLeft.png");
	private Image archerLeft = new Image("file:DImages/playerArcherLeft.png");
	private Image mageLeft = new Image("file:DImages/playerMageLeft.png");
	private Image nurseLeft = new Image("file:DImages/playerNurseLeft.png");
	private Image tankLeft = new Image("file:DImages/playerTankLeft.png");
	private Image assassinLeft = new Image("file:DIMages/playerAssassinLeft.png");
	
	private Image knightRight = new Image("file:DImages/playerKnightRight.png");
	private Image archerRight = new Image("file:DImages/playerArcherRight.png");
	private Image mageRight = new Image("file:DImages/playerMageRight.png");
	private Image nurseRight = new Image("file:DImages/playerNurseRight.png");
	private Image tankRight = new Image("file:DImages/playerTankRight.png");
	private Image assassinRight = new Image("file:DIMages/playerAssassinRight.png");
	
	private Image knightGrassLeft = new Image("file:DImages/playerKnightGrassLeft.png");
	private Image archerGrassLeft = new Image("file:DImages/playerArcherGrassLeft.png");
	private Image mageGrassLeft = new Image("file:DImages/playerMageGrassLeft.png");
	private Image nurseGrassLeft = new Image("file:DImages/playerNurseGrassLeft.png");
	private Image tankGrassLeft = new Image("file:DImages/playerTankGrassLeft.png");
	private Image assassinGrassLeft = new Image("file:DIMages/playerAssassinGrassLeft.png");
	
	private Image knightGrassRight = new Image("file:DImages/playerKnightGrassRight.png");
	private Image archerGrassRight = new Image("file:DImages/playerArcherGrassRight.png");
	private Image mageGrassRight = new Image("file:DImages/playerMageGrassRight.png");
	private Image nurseGrassRight = new Image("file:DImages/playerNurseGrassRight.png");
	private Image tankGrassRight = new Image("file:DImages/playerTankGrassRight.png");
	private Image assassinGrassRight = new Image("file:DIMages/playerAssassinGrassRight.png");
	
	private Image knightDirtLeft = new Image("file:DImages/playerKnightDirtLeft.png");
	private Image archerDirtLeft = new Image("file:DImages/playerArcherDirtLeft.png");
	private Image mageDirtLeft = new Image("file:DImages/playerMageDirtLeft.png");
	private Image nurseDirtLeft = new Image("file:DImages/playerNurseDirtLeft.png");
	private Image tankDirtLeft = new Image("file:DImages/playerTankDirtLeft.png");
	private Image assassinDirtLeft = new Image("file:DIMages/playerAssassinDirtLeft.png");
	
	private Image knightDirtRight = new Image("file:DImages/playerKnightDirtRight.png");
	private Image archerDirtRight = new Image("file:DImages/playerArcherDirtRight.png");
	private Image mageDirtRight = new Image("file:DImages/playerMageDirtRight.png");
	private Image nurseDirtRight = new Image("file:DImages/playerNurseDirtRight.png");
	private Image tankDirtRight = new Image("file:DImages/playerTankDirtRight.png");
	private Image assassinDirtRight = new Image("file:DIMages/playerAssassinDirtRight.png");
	
	private Image floorDirt = new Image("file:DImages/floorDirt.png");
	private Image floorGrass = new Image("file:DImages/floorGrass.png");
	
	private Image wallDirtBottomLeft = new Image("file:DImages/WallDirtBottomLeft.png");
	private Image wallDirtBottomRight = new Image("file:DImages/WallDirtBottomRight.png");
	private Image wallDirtTopLeft = new Image("file:DImages/WallDirtTopLeft.png");
	private Image wallDirtTopRight = new Image("file:DImages/WallDirtTopRight.png");
	private Image wallDirtHorizontal = new Image("file:DImages/WallDirtHorizontal.png");
	private Image wallDirtVertical = new Image("file:DImages/WallDirtVertical.png");
	
	private Image wallGrassBottomLeft = new Image("file:DImages/WallGrassBottomLeft.png");
	private Image wallGrassBottomRight = new Image("file:DImages/WallGrassBottomRight.png");
	private Image wallGrassTopLeft = new Image("file:DImages/WallGrassTopLeft.png");
	private Image wallGrassTopRight = new Image("file:DImages/WallGrassTopRight.png");
	private Image wallGrassHorizontal = new Image("file:DImages/WallGrassHorizontal.png");
	private Image wallGrassVertical = new Image("file:DImages/WallGrassVertical.png");
	
	private int numCharacters = 6;
	
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
	
	public void setBackground(Image img, double width, double height){
		ImageView background = new ImageView();
		background.setX(0);
		background.setY(0);
		background.setImage(img);
		background.setFitWidth(width);
		background.setFitHeight(height);
		this.getChildren().add(background);
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
		setBackground(titleScreenImage, width, height);
	}
	
	public void createCharacterSelectScreen(double width, double height, Dimension87_Controller controller){
		setBackground(characterSelectImage, width, height);
		
		double xPosition = 0;
		double yIncrement = pixelSize;
		createLeftCharacters(xPosition, yIncrement);
		xPosition = width-pixelSize;
		createRightCharacters(xPosition, yIncrement);
		
		Label howToPlay = new Label("How to Play");
		howToPlay.setFont(new Font(25));
		howToPlay.setTextFill(Color.YELLOW);
		howToPlay.setTranslateX(width / 2 - howToPlay.getWidth());
		howToPlay.setOnMouseEntered(new EventHandler<MouseEvent>(){

			@Override
			public void handle(MouseEvent event) {
				howToPlay.setTextFill(Color.RED);
			}
			
		});
		howToPlay.setOnMouseExited(new EventHandler<MouseEvent>(){

			@Override
			public void handle(MouseEvent event) {
				howToPlay.setTextFill(Color.YELLOW);
			}
			
		});
		howToPlay.setOnMouseClicked(new EventHandler<MouseEvent>(){

			@Override
			public void handle(MouseEvent event) {
				if(event.getButton() == MouseButton.PRIMARY){
					Stage stagePlay = new Stage();
					stagePlay.setTitle("How to Play");
					stagePlay.setResizable(false);
					
					BorderPane root = new BorderPane();
					Scene scene = new Scene(root, 400, 400);
					stagePlay.setScene(scene);
					
					HBox ok = new HBox();
					Text filler = new Text("");
					ok.setSpacing(stagePlay.getWidth() / 2);
					Button button = new Button("OK!");
					ok.getChildren().add(filler);
					ok.getChildren().add(button);
					
					WebView website = new WebView();
					website.getEngine().load("");
					root.setCenter(website);
					root.setBottom(ok);
					button.setOnAction(new EventHandler<ActionEvent>() {

						@Override
						public void handle(ActionEvent event1) {
							if(event1.getSource() == button){
								stagePlay.close();
							}
						}
						
					});
					stagePlay.show();
				}
			}
			
		});
		this.getChildren().add(howToPlay);
		
		Label play = new Label("PLAY NOW");
		play.setFont(new Font(100));
		play.setTextFill(Color.YELLOW);
		play.setTranslateX(width / 5 - width / 12);
		play.setTranslateY(height / 1.5 - play.getHeight());
		play.setOnMouseEntered(new EventHandler<MouseEvent>(){

			@Override
			public void handle(MouseEvent event) {
				play.setTextFill(Color.RED);
			}
			
		});
		play.setOnMouseExited(new EventHandler<MouseEvent>(){

			@Override
			public void handle(MouseEvent event) {
				play.setTextFill(Color.YELLOW);
			}
			
		});
		play.setOnMouseClicked(new EventHandler<MouseEvent>(){

			@Override
			public void handle(MouseEvent event) {
				controller.initialize();
			}
			
		});
		this.getChildren().add(play);
	}

	public void createBattleGrounds(double width, double height, Model _model){
		this.getChildren().remove(0, this.getChildren().size());
		model = _model;
		
		Person[] leftTeam = model.getTeam1();
		Person[] rightTeam = model.getTeam2();
				
		rows = model.getNumRows();
		cols = model.getNumCols();
		
		int r = 0;
		int c = 0;
		int index = 0;
		images = new ImageView[rows][cols];
		for(int i = pixelSize / 2; i < width; i+=pixelSize){
			r=0;
			for(int j = pixelSize / 2; j < height; j+=pixelSize){
				ImageView image = new ImageView();
				if(c == 0){
					if(r >= 3 && r < 7){
						image.setImage(leftTeam[index].getImage());
						image.setX(i);
						image.setY(j);
						index++;
					}else{
						image.setImage(model.getTileData(r, c).getImage());
						image.setX(i);
						image.setY(j);
					}
				}
				else if(c == 9){
					if(r >= 3 && r < 7){
						image.setImage(rightTeam[index].getImage());
						image.setX(i);
						image.setY(j);
						index++;
					}
					else{
						image.setImage(model.getTileData(r, c).getImage());
						image.setX(i);
						image.setY(j);
					}
				}
				else{
					image.setImage(model.getTileData(r, c).getImage());
					image.setX(i);
					image.setY(j);
				}
				images[r][c] = image;
				this.getChildren().add(image);
				r++;
			}
			c++;
			if(c==1){
				index = 0;
			}
		}
	}
	
	public Image getKnightLeft(){
		return knightLeft;
	}
	
	public Image getArcherLeft(){
		return archerLeft;
	}
	
	public Image getMageLeft(){
		return mageLeft;
	}
	
	public Image getNurseLeft(){
		return nurseLeft;
	}
	
	public Image getTankLeft(){
		return tankLeft;
	}
	
	public Image getAssassinLeft(){
		return assassinLeft;
	}

	public Image getKnightRight(){
		return knightRight;
	}
	
	public Image getArcherRight(){
		return archerRight;
	}
	
	public Image getMageRight(){
		return mageRight;
	}
	
	public Image getNurseRight(){
		return nurseRight;
	}
	
	public Image getTankRight(){
		return tankRight;
	}
	
	public Image getAssassinRight(){
		return assassinRight;
	}
	
	private void createLeftCharacters(double xPosition, double yIncrement) {
		for(int i = 0; i < numCharacters; i++){
			ImageView sprite = new ImageView();
			switch(i){
				case 0: sprite.setImage(knightLeft); break;
				case 1: sprite.setImage(archerLeft); break;
				case 2: sprite.setImage(mageLeft); break;
				case 3: sprite.setImage(nurseLeft);	break;
				case 4: sprite.setImage(tankLeft);	break;
				case 5: sprite.setImage(assassinLeft); break;
			}
			Hero_View hero = new Hero_View();
			leftTeam.add(hero);
			hero.makeSquare(xPosition, pixelSize/2 + yIncrement*i, pixelSize);
			hero.setImageNow(sprite.getImage());
			hero.setColor(Color.WHITE);
			
			Rectangle rectangle = new Rectangle(hero.getXPos(), hero.getYPos(), hero.getSize(), hero.getSize());
			rectangle.setFill(Color.WHITE);
			rectangle.setStroke(Color.BLACK);
			
			rectangle.setOnMouseClicked(new EventHandler<MouseEvent>(){

				@Override
				public void handle(MouseEvent event) {
					if(!hero.getSelected()){
						rectangle.setFill(Color.BLUE);
						hero.setSelected(true);
						
					}else{
						rectangle.setFill(Color.WHITE);
						hero.setSelected(false);
					}
				}
				
			});
			
			rectangle.setOnMouseEntered(new EventHandler<MouseEvent>(){

				@Override
				public void handle(MouseEvent event) {
					if(!hero.getSelected()){
						rectangle.setFill(Color.RED);
					}
				}
				
			});
			
			rectangle.setOnMouseExited(new EventHandler<MouseEvent>(){

				@Override
				public void handle(MouseEvent event) {
					if(!hero.getSelected()){
						rectangle.setFill(Color.WHITE);
					}
				}
				
			});
			

			sprite.setOnMouseClicked(new EventHandler<MouseEvent>(){

				@Override
				public void handle(MouseEvent event) {
					if(!hero.getSelected()){
						rectangle.setFill(Color.BLUE);
						hero.setSelected(true);
					}else{
						rectangle.setFill(Color.WHITE);
						hero.setSelected(false);
					}
				}
				
			});
			
			sprite.setOnMouseEntered(new EventHandler<MouseEvent>(){

				@Override
				public void handle(MouseEvent event) {
					if(!hero.getSelected()){
						rectangle.setFill(Color.RED);
					}
				}
				
			});
			
			sprite.setOnMouseExited(new EventHandler<MouseEvent>(){

				@Override
				public void handle(MouseEvent event) {
					if(!hero.getSelected()){
						rectangle.setFill(Color.WHITE);
					}
				}
				
			});
			
			sprite.setX(xPosition);
			sprite.setY(pixelSize / 2 + yIncrement * i);
			this.getChildren().add(rectangle);
			this.getChildren().add(sprite);

		}
		
	}
	
	private void createRightCharacters(double xPosition, double yIncrement) {
		for(int i = 0; i < numCharacters; i++){
			ImageView sprite = new ImageView();
			switch(i){
				case 0: sprite.setImage(knightRight); break;
				case 1: sprite.setImage(archerRight); break;
				case 2: sprite.setImage(mageRight);	break;
				case 3: sprite.setImage(nurseRight); break;
				case 4: sprite.setImage(tankRight);	break;
				case 5: sprite.setImage(assassinRight); break;
			}
			Hero_View hero = new Hero_View();
			rightTeam.add(hero);
			hero.makeSquare(xPosition, pixelSize/2 + yIncrement*i, pixelSize);
			hero.setImageNow(sprite.getImage());
			hero.setColor(Color.WHITE);
			
			Rectangle rectangle = new Rectangle(hero.getXPos(), hero.getYPos(), hero.getSize(), hero.getSize());
			rectangle.setFill(Color.WHITE);
			rectangle.setStroke(Color.BLACK);
			
			rectangle.setOnMouseClicked(new EventHandler<MouseEvent>(){

				@Override
				public void handle(MouseEvent event) {
					if(!hero.getSelected()){
						rectangle.setFill(Color.BLUE);
						hero.setSelected(true);
					}else{
						rectangle.setFill(Color.WHITE);
						hero.setSelected(false);
					}
				}
				
			});
			
			rectangle.setOnMouseEntered(new EventHandler<MouseEvent>(){

				@Override
				public void handle(MouseEvent event) {
					if(!hero.getSelected()){
						rectangle.setFill(Color.RED);
					}
				}
				
			});
			
			rectangle.setOnMouseExited(new EventHandler<MouseEvent>(){

				@Override
				public void handle(MouseEvent event) {
					if(!hero.getSelected()){
						rectangle.setFill(Color.WHITE);
					}
				}
				
			});
			

			sprite.setOnMouseClicked(new EventHandler<MouseEvent>(){

				@Override
				public void handle(MouseEvent event) {
					if(!hero.getSelected()){
						rectangle.setFill(Color.BLUE);
						hero.setSelected(true);
					}else{
						rectangle.setFill(Color.WHITE);
						hero.setSelected(false);
					}
				}
				
			});
			
			sprite.setOnMouseEntered(new EventHandler<MouseEvent>(){

				@Override
				public void handle(MouseEvent event) {
					if(!hero.getSelected()){
						rectangle.setFill(Color.RED);
					}
				}
				
			});
			
			sprite.setOnMouseExited(new EventHandler<MouseEvent>(){

				@Override
				public void handle(MouseEvent event) {
					if(!hero.getSelected()){
						rectangle.setFill(Color.WHITE);
					}
				}
				
			});
			
			sprite.setX(xPosition);
			sprite.setY(pixelSize / 2 + yIncrement * i);
			this.getChildren().add(rectangle);
			this.getChildren().add(sprite);

		}
		
	}
	
	public Hero_View[] getLeftTeam(){
		for(int i = 0; i < leftTeam.size(); i++){
			if(!leftTeam.get(i).getSelected()){
				leftTeam.remove(i);
				i--;
			}
		}
		Hero_View[] left = new Hero_View[leftTeam.size()];
		for(int i = 0; i < left.length; i++){
			left[i] = leftTeam.get(i);
			left[i].setImageNow(leftTeam.get(i).getImageNow());
			System.out.println(left[i].getImageNow().toString());
		}
		return left;
	}
	
	public Hero_View[] getRightTeam(){
		for(int i = 0; i < rightTeam.size(); i++){
			if(!rightTeam.get(i).getSelected()){
				rightTeam.remove(i);
				i--;
			}
		}
		Hero_View[] right = new Hero_View[rightTeam.size()];
		for(int i = 0; i < right.length; i++){
			right[i] = rightTeam.get(i);
		}
		return right;
	}
	
	
}
