package View;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

public class Dimension87_View extends Group implements Dimension87_ViewInterface<Image>{

	private ImageView[][] images;
	
	private Image titleScreenImage = new Image("file:DImages/screenTitle.png");
	private Image characterSelectImage = new Image("file:DImages/screenSelect.png");
	
	private Image knightLeft = new Image("file:DImages/playerKnightLeft.png");
	private Image archerLeft = new Image("file:DImages/playerArcherLeft.png");
	private Image mageLeft = new Image("file:DImages/playerMageLeft.png");
	private Image nurseLeft = new Image("file:DImages/playerNurseLeft.png");
	
	private Image knightRight = new Image("file:DImages/playerKnightRight.png");
	private Image archerRight = new Image("file:DImages/playerArcherRight.png");
	private Image mageRight = new Image("file:DImages/playerMageRight.png");
	private Image nurseRight = new Image("file:DImages/playerNurseRight.png");
	
	private Image floorDirt = new Image("file:DImages/floorDirt.png");
	private Image floorGrass = new Image("file:DImages/floorGrass.png");
	
	private Image wallCornerBottomLeft = new Image("file:DImages/WallCornerBottomLeft.png");
	private Image wallCornerBottomRight = new Image("file:DImages/WallCornerBottomRight.png");
	private Image wallCornerTopLeft = new Image("file:DImages/WallCornerTopLeft.png");
	private Image wallCornerTopRight = new Image("file:DImages/WallCornerTopRight.png");
	
	private int numCharacters = 4;
	
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
	
	public void createCharacterSelectScreen(double width, double height, Model model){
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
		play.setTranslateY(height / 2 - play.getHeight());
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
				createBattleGrounds(width, height, model);
			}
			
		});
		this.getChildren().add(play);
	}

	public void createBattleGrounds(double width, double height, Model _model){
		this.getChildren().remove(0, this.getChildren().size());
		model = _model;
		
		rows = model.getNumRows();
		cols = model.getNumCols();
		
		int y = 0;
		int x = 0;
		images = new ImageView[rows][cols];
		for(int i = pixelSize / 2; i < width; i+=pixelSize){
			x=0;
			for(int j = pixelSize / 2; j < height; j+=pixelSize){
				ImageView image = new ImageView(floorDirt);
				image.setImage(model.getTileData(x, y).getImage());
				image.setX(i);
				image.setY(j);
				images[y][x] = image;
				this.getChildren().add(image);
				x++;
			}
			y++;
		}
	}

	private void createLeftCharacters(double xPosition, double yIncrement) {
		for(int i = 0; i < numCharacters; i++){
			ImageView sprite = new ImageView();
			switch(i){
				case 0: sprite.setImage(knightLeft); break;
				case 1: sprite.setImage(archerLeft); break;
				case 2: sprite.setImage(mageLeft); break;
				case 3: sprite.setImage(nurseLeft);	break;
			}
			Hero_View hero = new Hero_View();
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
			}
			Hero_View hero = new Hero_View();
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
	
	
}
