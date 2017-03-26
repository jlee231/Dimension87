package model;


import shared.Person;
import shared.Tile;

/**
 * Created by phani on 3/25/2017.
 */
public interface InterfaceModel {
    public Tile getTileData(int row, int col);		//returns the 2D array of tile objects representing the map
    public Person[] getTeam1();
    public Person[] getTeam2();

}
