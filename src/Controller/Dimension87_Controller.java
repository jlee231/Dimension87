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
	
	private double screenWidth;
	private double screenHeight;
	
	private Model model = new Model();
	
	private int pixelSize = 64;
	
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
		Heros trueHero = new Heros(model);
		for(int i = 0; i < left.length; i++){
			Image image = left[i].getImageNow();
			if(image.equals(characterSelect.getKnightLeft())){
				Person person = trueHero.createKnight("Knight_Left", knightDirtLeft, 0, i+3);
				person.setImage(knightDirtLeft);
				leftTeam[i] = person;
			}
			if(image.equals(characterSelect.getArcherLeft())){
				Person person = trueHero.createArcher("Archer_left", archerDirtLeft, 0, i+3);
				person.setImage(archerDirtLeft);
				leftTeam[i] = person;

			}
			if(image.equals(characterSelect.getMageLeft())){
				Person person = trueHero.createMage("Mage_Left", mageDirtLeft, 0, i+3);
				person.setImage(mageDirtLeft);
				leftTeam[i] = person;

			}
			if(image.equals(characterSelect.getNurseLeft())){
				Person person = trueHero.createNurse("Nurse_Left", nurseDirtLeft, 0, i+3);
				person.setImage(nurseDirtLeft);
				leftTeam[i] = person;

			}
			if(image.equals(characterSelect.getTankLeft())){
				System.out.println("TANK OK");
				Person person = trueHero.createTank("Tank_Left", tankDirtLeft, 0, i+3);
				person.setImage(tankDirtLeft);
				leftTeam[i] = person;

			}
			if(image.equals(characterSelect.getAssassinLeft())){
				System.out.println("SIn OK");
				Person person = trueHero.createAssassin("Assassin_Left", assassinDirtLeft, 0, i+3);
				person.setImage(assassinDirtLeft);
				leftTeam[i] = person;
			}
		
			
		}
		for(int i = 0; i < right.length; i++){
			Image image = right[i].getImageNow();
			if(image.equals(characterSelect.getKnightRight())){
				Person person = trueHero.createKnight("Knight_Right", knightDirtRight, 9, i+3);
				person.setImage(knightDirtRight);
				rightTeam[i] = person;
			}
			if(image.equals(characterSelect.getArcherRight())){
				Person person = trueHero.createArcher("Archer_Right", archerDirtRight, 9, i+3);
				person.setImage(archerDirtRight);
				rightTeam[i] = person;

			}
			if(image.equals(characterSelect.getMageRight())){
				Person person = trueHero.createMage("Mage_Right", mageDirtRight, 9,i+3);
				person.setImage(mageDirtRight);
				rightTeam[i] = person;

			}
			if(image.equals(characterSelect.getNurseRight())){
				Person person = trueHero.createNurse("Nurse_Right", nurseDirtRight, 9, i+3);
				person.setImage(nurseDirtRight);
				rightTeam[i] = person;

			}
			if(image.equals(characterSelect.getTankRight())){
				Person person = trueHero.createTank("Tank_Right", tankDirtRight, 9, i+3);
				person.setImage(tankDirtRight);
				rightTeam[i] = person;

			}
			if(image.equals(characterSelect.getAssassinRight())){
				Person person = trueHero.createAssassin("Assassin_Right", assassinDirtRight, 9, i+3);
				person.setImage(assassinDirtRight);
				rightTeam[i] = person;

			}
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
			int row = (int) (event.getY() / pixelSize);
			int col = (int) (event.getX() / pixelSize);
			if(event.getButton() == MouseButton.PRIMARY){
				Tile tile = model.getTileData(row, col);
				
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
