/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Funny_game;

/**
 *
 * @author CoreTech
 */
public class ToolStore extends NormalLoc{
    
     ToolStore(Player player) {

         super(player, "Store");
    }
    public  boolean getLocation(){
        System.out.println("Money:"+player.getMoney());
        System.out.println("1.Weapons");
        System.out.println("2.Armors");
        System.out.println("3.Exit");
        System.out.print("Your choice:");
        int selTool=scan.nextInt();
        int selItemID;
        switch(selTool){
            case 1:
                selItemID=weaponMenu();
                buyWeapon(selItemID);
                break;
            case 2:
                selItemID=armorMenu();
                buyArmor(selItemID);
                break;
            default:
                break;
                
        }
        
         return true;
    }
    public int armorMenu(){
        System.out.println("1. Light\t  <Money:15-Damage: 1>");
        System.out.println("2. Normal\t  <Money:25-Damage: 3>");
        System.out.println("3. Hard\t     <Money:40-Damage: 5>");
        System.out.println("4. Exit");
        System.out.print("5. Choose a weapon: ");
        int selArmorID=scan.nextInt();
        return  selArmorID;
    }
    public void buyArmor(int itemID){
        int avoid=0,price=0;
        String aName=null;
        switch(itemID){
            case 1:
                avoid=1;
                aName="Light armor";
                price=25;
                break;
            case 2:
                avoid=3;
                aName="Normal armor";
                price=15;
                break;
            case 3:
                avoid=5;
                aName="Hard armor";
                price=40;
                break;
            case 4:
                System.out.println("Exit is being made");
                break;
            default:
                System.out.println("Invalid operation !");
                break;

        }
        if(price>0){
            if(player.getMoney()>=price ){
                player.getInv().setArmor(avoid);
                player.getInv().setwName(aName);
                player.setMoney(player.getMoney()-price);
                System.out.println(aName+" You bought, Blocked Damage:"+player.getInv().getDamage()+", New Damage:"
                        +player.getTotalDamage());
                System.out.println("Remaining money:"+player.getMoney());

            }
        }


        else{
            System.out.println("Not enough money.!");
        }


    }

    public int weaponMenu(){
        System.out.println("1. Gun\t      <Money:5-Damage: 2>");
        System.out.println("2. Sword\t  <Money:35-Damage: 3>");
        System.out.println("3. Rifle\t  <Money:45-Damage: 7>");
        System.out.println("4. Exit");
        System.out.print("5. Choose a weapon: ");
        int selWeaponID=scan.nextInt();
        return  selWeaponID;
    }
    public void buyWeapon(int itemID){
        int damage=0,price=0;
        String wName=null;
        switch(itemID){
            case 1:
                damage=2;
                wName="Gun";
                price=5;
                break;
            case 2:
                damage=3;
                wName="Sword";
                price=35;
                break;
            case 3:
                damage=7;
                wName="Rifle";
                price=45;
                break;
            case 4:
                System.out.println("Exit is being made");
                break;
            default:
                System.out.println("Invalid operation !");
                break;
                    
            }
            if(price>0){
                if(player.getMoney()>price ){
                    player.getInv().setDamage(damage);
                    player.getInv().setwName(wName);
                    player.setMoney(player.getMoney()-price);
                    System.out.println(wName+"You bought the gun, Previous Damage:"+player.getDamage()+", New Damage:"
                            +player.getTotalDamage());
                    System.out.println("Remaining money:"+player.getMoney());

                }
            }
            

            else{
                System.out.println("Not enough money.!");
            }

            
        
    }

    
}
