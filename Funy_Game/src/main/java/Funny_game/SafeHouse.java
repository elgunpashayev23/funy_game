/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Funny_game;

/**
 *
 * @author CoreTech
 */
public class SafeHouse extends NormalLoc {
    
     SafeHouse(Player player) {

         super(player,"Safe house" );
    }
    public boolean getLocation(){
        player.setHealthy(player.getrHealthy());
        System.out.println("You are healed....");
        System.out.println("You are now in the safe house");
        return true;
    }
}
