package Controller;
import java.awt.Dimension;

import java.awt.Toolkit;
import java.io.File;

import View.Dimension87_View;
import model.*;
import shared.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
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

	private boolean isInCharacterSelect = false;
	private boolean yetToBeInCS = true;



	private double screenWidth;
	private double screenHeight;

	private Model model = new Model();

	public static void main(String[] args){
		launch();
	}

	@Override
	public void start(Stage _stage) throws Exception {
		stage = _stage;
		//File file = new File("C:\\Users\\School\\Semester2\\D87\\map1.txt");
		File file = new File("C:\\Users\\phani\\Documents\\GitHub\\dim87\\map1.txt");
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
		characterSelect.createCharacterSelectScreen(screenWidth, screenHeight, model);
		root.setCenter(characterSelect);
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
