/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Funny_game;

import java.util.Scanner;

/**
 *
 * @author CoreTech
 */
public class Game {
    Player player;
    Location location;
    Scanner scan=new Scanner(System.in);
    
    public void login(){
        Scanner scan=new Scanner(System.in);
        System.out.println("Welcome to the adventure game");
        System.out.println("Enter your name before starting the game:");
        player=new Player("a");
        player.selectCha();
        start();
    }
    public void start(){
        while(true){
        System.out.println();
        System.out.println("*****************************************************************");
        System.out.println();
        System.out.println("Choose a place to perform the action");
        System.out.println("1. Safe house-->A safe place for you, no enemies!");
        System.out.println("2. Cave-->You may encounter zombies!");
        System.out.println("3. Forest-->You may encounter vapmires!");
        System.out.println("4. River-->You may encounter bears!");
        System.out.println("5. Shopping centre-->You can get Weapons or Armor!");
        System.out.print("Where you want to go:");
        int selLoc=scan.nextInt();
        
        while(selLoc<0 || selLoc>5){
            System.out.print("Please select a valid location:");
            selLoc=scan.nextInt();
        }
        switch(selLoc){
            case 1:
                location=new SafeHouse(player);
                break;
            case 2:
                location=new Cave(player);
                break;
            case 3:
                location=new Forest(player);
                break;
            case 4:
                location=new River(player);
                break;
            case 5:
                location=new ToolStore(player);
                break;
            default:
                location=new SafeHouse(player);
        }
        if (location.getClass().getName().equals("SafeHouse")){
            if (player.getInv().isFirewood() && player.getInv().isFood() && player.getInv().isWater()){
                System.out.println(" Congratulations you won the game !");
            }
        }
        if(!location.getLocation()){
            System.out.println("Game over!!!");
            break;
        }
        }
    
    }
}
