package Controller;
import java.awt.Dimension;
import java.awt.Toolkit;

import View.Dimension87_View;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Dimension87_Controller extends Application{

	private Stage stage;
	private BorderPane root;
	
	private Dimension87_View titleScreen;
	private Dimension87_View characterSelect;
	
	private double screenWidth;
	private double screenHeight;
	
	public static void main(String[] args){
		launch();
	}
	
	@Override
	public void start(Stage _stage) throws Exception {
		stage = _stage;
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

		screenWidth = screenSize.getWidth();
		screenHeight = screenSize.getHeight();
				
		stage.setTitle("Dimension87");
		stage.setWidth(screenWidth);
		stage.setHeight(screenHeight);
		stage.setResizable(true);
		
		root = new BorderPane();
		
		createTitle();

		Scene scene = new Scene(root, stage.getWidth(), stage.getHeight());
		stage.setScene(scene);
		scene.setOnMouseClicked(new MouseHandler());
		stage.show();
	}
	
	public void createTitle(){
		titleScreen = new Dimension87_View();
		titleScreen.createTitleScreen(screenWidth, screenHeight);
		titleScreen.setOnMouseClicked(new MouseHandler());
		root.setCenter(titleScreen);
	}

	private class MouseHandler implements EventHandler<MouseEvent>{

		@Override
		public void handle(MouseEvent event) {
			if(event.getButton() == MouseButton.PRIMARY){
				System.out.println(event.getX() + " " + event.getY());
			}
			
			if(event.getSource() == titleScreen){
				
				characterSelect = new Dimension87_View();
				root.setCenter(characterSelect);
			}
		}
		
	}
	
}
