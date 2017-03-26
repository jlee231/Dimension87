package shared;

import javafx.scene.image.Image;
import model.Model;

/**
 * Created by phani on 3/25/2017.
 */
public class Heros {
	Model model;
	Person knight;
    Person archer;
    Person mage;
    Person nurse;
    Person tank;
    Person assassin;
    
	// public Person(Model model,String name,Image image, int x, int y, int radius, int health, int atk, int range, int def )
	public Heros(Model _model){
		model = _model;
	}
	
	public Person createKnight(String name, Image img, int x, int y){
		knight = new Person(model, name, img, x, y, 1, 1, 1, 1, 1);
		return knight;
	}
	
	public Person createArcher(String name, Image img, int x, int y){
		archer = new Person(model, name, img, x, y, 1, 1, 1, 1, 1);
		return archer;
	}

	public Person createMage(String name, Image img, int x, int y){
		mage = new Person(model, name, img, x, y, 1, 1, 1, 1, 1);
		return mage;
	}

	public Person createNurse(String name, Image img, int x, int y){
		nurse = new Person(model, name, img, x, y, 1, 1, 1, 1, 1);
		return nurse;
	}
	
	public Person createTank(String name, Image img, int x, int y){
		tank = new Person(model, name, img, x, y, 1, 1, 1, 1, 1);
		return tank;
	}
	
	public Person createAssassin(String name, Image img, int x, int y){
		assassin = new Person(model, name, img, x, y, 1, 1, 1, 1, 1);
		return assassin;
	}



}
