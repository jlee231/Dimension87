package Controller;
import java.awt.Dimension;

import java.awt.Toolkit;
import java.io.File;

import View.Dimension87_View;
import View.Hero_View;
import model.*;
import shared.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Dimension87_Controller extends Application{

	private Stage stage;
	private BorderPane root;
	
	private Dimension87_View titleScreen;
	private Dimension87_View characterSelect;
	private Dimension87_View battleGround;

	
	private boolean isInCharacterSelect = false;
	private boolean yetToBeInCS = true;
	
	private Image knightLeft = new Image("file:DImages/playerKnightLeft.png");
	private Image archerLeft = new Image("file:DImages/playerArcherLeft.png");
	private Image mageLeft = new Image("file:DImages/playerMageLeft.png");
	private Image nurseLeft = new Image("file:DImages/playerNurseLeft.png");
	
	private Image knightRight = new Image("file:DImages/playerKnightRight.png");
	private Image archerRight = new Image("file:DImages/playerArcherRight.png");
	private Image mageRight = new Image("file:DImages/playerMageRight.png");
	private Image nurseRight = new Image("file:DImages/playerNurseRight.png");
	
	private Image knightGrassLeft = new Image("file:DImages/playerKnightGrassLeft.png");
	private Image archerGrassLeft = new Image("file:DImages/playerArcherGrassLeft.png");
	private Image mageGrassLeft = new Image("file:DImages/playerMageGrassLeft.png");
	private Image nurseGrassLeft = new Image("file:DImages/playerNurseGrassLeft.png");
	
	private Image knightGrassRight = new Image("file:DImages/playerKnightGrassRight.png");
	private Image archerGrassRight = new Image("file:DImages/playerArcherGrassRight.png");
	private Image mageGrassRight = new Image("file:DImages/playerMageGrassRight.png");
	private Image nurseGrassRight = new Image("file:DImages/playerNurseGrassRight.png");
	
	private Image knightDirtLeft = new Image("file:DImages/playerKnightDirtLeft.png");
	private Image archerDirtLeft = new Image("file:DImages/playerArcherDirtLeft.png");
	private Image mageDirtLeft = new Image("file:DImages/playerMageDirtLeft.png");
	private Image nurseDirtLeft = new Image("file:DImages/playerNurseDirtLeft.png");
	
	private Image knightDirtRight = new Image("file:DImages/playerKnightDirtRight.png");
	private Image archerDirtRight = new Image("file:DImages/playerArcherDirtRight.png");
	private Image mageDirtRight = new Image("file:DImages/playerMageDirtRight.png");
	private Image nurseDirtRight = new Image("file:DImages/playerNurseDirtRight.png");
	
	private double screenWidth;
	private double screenHeight;
	
	private Model model = new Model();
	
	public static void main(String[] args){
		launch();
	}
	
	@Override
	public void start(Stage _stage) throws Exception {
		stage = _stage;
		File file = new File("map4.txt");
		model.loadMap(file);
		screenWidth = 640;
		screenHeight = 640;
				
		stage.setTitle("Dimension87");
		stage.setWidth(screenWidth);
		stage.setHeight(screenHeight);
		stage.setResizable(false);
		
		root = new BorderPane();
		
		createTitle();

		Scene scene = new Scene(root, stage.getWidth(), stage.getHeight());
		stage.setScene(scene);
		scene.setOnKeyPressed(new KeyHandler());
		scene.setOnMouseClicked(new MouseHandler());
		stage.show();
	}
	
	public void createTitle(){
		titleScreen = new Dimension87_View();
		titleScreen.createTitleScreen(screenWidth, screenHeight);
		root.setCenter(titleScreen);
	}
	
	public void createCharacterSelect(){
		characterSelect = new Dimension87_View();
		characterSelect.createCharacterSelectScreen(screenWidth, screenHeight, this);
		root.setCenter(characterSelect);
	}
	
	
	
	public void initialize() {
		Hero_View left[] = characterSelect.getLeftTeam();
		Hero_View right[] = characterSelect.getRightTeam();
		
		Person leftTeam[] = new Person[left.length];
		Person rightTeam[] = new Person[right.length];
		
		for(int i = 0; i < left.length; i++){
			Image image = left[i].getImageNow();
			Person person = new Person();
			if(image == knightLeft){
				
			}
			else if(image == archerLeft){
				
			}
			else if(image == mageLeft){
				
			}
			else if(image == nurseLeft){
				
			}
			leftTeam[i] = person;
		}
		for(int i = 0; i < right.length; i++){
			Image image = right[i].getImageNow();
			Person person = new Person();
			if(image == knightRight){
				
			}
			else if(image == archerRight){
				
			}
			else if(image == mageRight){
				
			}
			else if(image == nurseRight){
				
			}
			rightTeam[i] = person;
		}
		model.setTeam1(leftTeam);
		model.setTeam2(rightTeam);
		
		battleGround = new Dimension87_View();
		battleGround.createBattleGrounds(screenWidth, screenHeight, model);
		root.setCenter(battleGround);
	}


	private class MouseHandler implements EventHandler<MouseEvent>{

		@Override
		public void handle(MouseEvent event) {
			if(event.getButton() == MouseButton.PRIMARY){
				System.out.println(event.getX() + " " + event.getY());
			}
			
		}
		
	}
	
	public class KeyHandler implements EventHandler<KeyEvent>{

		@Override
		public void handle(KeyEvent event) {
			if(event.getCode() == KeyCode.SPACE){
				isInCharacterSelect = true;
			}
			if(isInCharacterSelect && yetToBeInCS){
				createCharacterSelect();
				yetToBeInCS = false;
			}
		}
		
	}
	
}
