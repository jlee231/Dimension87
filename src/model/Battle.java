package model;

import shared.Person;

/**
 * Created by phani on 3/25/2017.
 */
public class Battle {
    Person attacker;
    Person defender;

    public Battle(Person hero, Person villian) {
        attacker = hero;
        defender = villian;
    }

    public void attack(){
        int dmg = attacker.getAtk() - defender.getDef();
        int health = defender.getHealth()-dmg;
        defender.setHealth(health);
    }


}
