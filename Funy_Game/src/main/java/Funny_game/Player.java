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
public class Player {
    private int damage,healthy,money,rHealthy;
    private String name,cName;

    private Inventory inv;
    Scanner scan=new Scanner(System.in);

    public Player(String name){
        this.name=name;
        this.inv=new Inventory();

    }

    public int getDamage() {

        return damage;
    }

    public void setDamage(int damage) {

        this.damage = damage;
    }

    public int getHealthy() {

        return healthy;
    }

    public void setHealthy(int healthy) {

        this.healthy = healthy;
    }

    public int getMoney() {

        return money;
    }

    public void setMoney(int money) {

        this.money = money;
    }


    public String getcName() {

        return cName;
    }

    public void setcName(String cName) {

        this.cName = cName;
    }

    public Inventory getInv() {

        return inv;
    }

    public void setInv(Inventory inv) {

        this.inv = inv;
    }
    public int getrHealthy() {

        return rHealthy;
    }

    public void setrHealthy(int rHealthy) {
        this.rHealthy = rHealthy;
    }
    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public void selectCha(){
        switch(chaMenu()){
//            Samuray seçildi
            case 1:
                initPlayer("Samuray",5,21,15);
                break;

            case 2:
                initPlayer("Bowman",7,18,20);
                break;
            case 3:
                initPlayer("Paladin",8,24,5);
                break;
                
            default:
                initPlayer("Samuray",5,21,15);
                break;
                
        }
        System.out.println("Karakter :"+getcName()+",Damage:"+getDamage()+",The soul:"+getHealthy()+",Money:"+getMoney());
    }
    public int chaMenu(){
        System.out.println("Please select a character:");
        System.out.println("1- Samuray\tDamage:5\tThe soul of Samuray:21\tMoney:15");
        System.out.println("2- Bowman\tDamage:7\tThe soul of Bowman:18\tMoney:20");
        System.out.println("3- Paladin\tDamage:8\tThe soul of Paladin:24\tMoney:5");
        System.out.print("Your choice:");
        int chaId=scan.nextInt();
        while(chaId<1 || chaId>3){
            System.out.println("Please select a valid character:");
            chaId=scan.nextInt();
        }
        return chaId;
    }
    public int getTotalDamage(){
        return this.getDamage()+this.getInv().getDamage();
    }
     public void initPlayer(String cName,int dmg,int hlthy,int mny){
                setcName(cName);
                setDamage(dmg);
                setHealthy(hlthy);
                setMoney(mny);
                setrHealthy(hlthy);

     }

}
