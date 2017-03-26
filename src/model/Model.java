package model;


import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import shared.Person;
import shared.Tile;
import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import Controller.*;

/**
 * Created by phani on 3/25/2017.
 */
public class Model implements InterfaceModel {


    Tile map [][];
    Person team1[];
    Person team2[];
    ArrayList<Image> spriteData;
    Dimension87_Controller controller;
    File f1;

    public Model() {

        //this.controller = controller;
        //load(f);
        spriteData = new ArrayList<Image>();
    }

    public int getNumRows(){
    	return map.length;
    }
    
    public int getNumCols(){
    	return map[0].length;
    }
    
    
    public void loadMap(File f){
        /*load(f);
        try {
            for (int i = 0; i <  ; i++) {

            }
        }*/
        int i = 0;
        int j = 0;
        try {
            Scanner in = new Scanner(f);
//            String ls = System.getProperty("line.separator");
//            String lines = "";
            int xsize = in.nextInt();
            int ysize = in.nextInt();
            System.out.println(xsize + ", " + ysize);
            map = new Tile[ysize][xsize];
            while (in.hasNext()) {
//            	System.out.println(i + ", " + j);
                String imageName = in.next();
                String walkable = in.next();
                imageName = imageName.substring(1);
                walkable = walkable.substring(0,walkable.length()-1);
                Image image = new Image("file:DImages/" +imageName);
                Tile tile;
                if(walkable.equals("true")){
                    tile = new Tile(true,image);
                }else{
                    tile = new Tile(false,image);
                }
                map[j][i] = tile;
                i++;
                if (i >= xsize){
                    i =0;
                    j++;
                }
                if(j >= ysize){
                    break;
                }
                //map[j][i] = tile;
            }
            in.close();
        }catch (Exception e){
            System.out.println(e.toString() + f.toString());
        }
    }
    public void setMapVal (Tile tile, int x, int y) {
        map[y][x] = tile;
    }

    public Tile getTileData(int row, int col) {
        return map[row][col];
    }
    
    public boolean isPerson(int row, int col){
    	for(int i = 0; i < team1.length; i++){
    		if(team1[i].getX() == col && team1[i].getY() == row){
    			return true;
    		}
    	}
    	for(int i = 0; i < team2.length; i++){
    		if(team2[i].getX() == col && team2[i].getY() == row  ){
    			return true;
    		}
    	}
    	return false;
    }
    
    public Person getPerson(int row, int col){
    	for(int i = 0; i < team1.length; i++){
    		if(team1[i].getX() == col && team1[i].getY() == row){
    			return team1[i];
    		}
    	}
    	for(int i = 0; i < team2.length; i++){
    		if(team2[i].getX() == row && team2[i].getY() == col){
    			return team2[i];
    		}
    	}
    	return null;
    }
    
    @Override
    public Person[] getTeam1() {
        return team1;
    }

    @Override
    public Person[] getTeam2() {
        return team2;
    }
    
    public void setTeam1(Person[] team) {
    	this.team1 = team;
    }

    public void setTeam2(Person[] team) {
        this.team2 = team;
    }

    public void setPlayerSpot(Person person, int newX, int newY){
        Tile tile = getMapVal(newX,newY);
        tile.setPlayer(person);
        map[newX][newY] =tile;
    }
    public void removePlayerSpot(int x, int y){
        Tile tile = getMapVal(x,y);
        tile.removePlayer();
        map[x][y] =tile;

    }

    public Tile getMapVal(int x, int y){
        return map[x][y];
    }

    public Boolean inBounds(int x, int y){
        System.out.println("(" + y + ", " + x + ")");
        if (x >= 0 && x < map[0].length-1 && y >= 0 && y < map.length-1){
            if (map[y][x].isWalkable()){
                return true;
            }else{
                return false;
            }
        }
        return false;
    }

    public ArrayList<Point2D> nearbyEnemies(int range, int x, int y){
        ArrayList<Integer> xPos = new ArrayList<Integer>();
        ArrayList<Integer> yPos = new ArrayList<Integer>();
        ArrayList<Point2D> enemies = new ArrayList<Point2D>();
        for (int i = 0; i <= range ; i++) {
            xPos.add(x+i);
            xPos.add(x-i);
            yPos.add(y+i);
            yPos.add(y-i);
        }
        for (int i = 0; i < xPos.size() ; i++) {
            for (int j = 0; j < yPos.size() ; j++) {
                if(map[xPos.get(i)][yPos.get(j)].getPlayer() != null){
                    Point2D point = new Point2D.Double(xPos.get(i),yPos.get(j));
                    enemies.add(point);
                }
            }
        }
        return enemies;
    }

    public boolean turnOver(){
        if (turnLeft){
            for (int i = 0; i < team1.length; i++) {
                if (!team1[i].isMoved()){
                    return false;
                }
            }
        }
        if (!turnLeft){
            for (int i = 0; i < team1.length; i++) {
                if (!team2[i].isMoved()){
                    return false;
                }
            }
        }
        return true;
    }

    public void setNextTurn(boolean turnLeft) {
        this.turnLeft = turnLeft;
    }
}
