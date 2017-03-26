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
        this.attack();
    }

    public void attack(){
        int dmg = attacker.getAtk() - defender.getDef();
        int health = defender.getHealth()-dmg;
        if(health <= 0){
            defender.die();

        }else {
            defender.setHealth(health);
            dmg = defender.getAtk()-(attacker.getDef()/2);
            health = attacker.getHealth()-dmg;
                    if(health <= 0){
                        attacker.die();
                    }
        }

    }


}