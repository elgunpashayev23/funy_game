/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Funny_game;

/**
 *
 * @author CoreTech
 */
public abstract class BattleLoc extends Location{
     protected Obstacle obstacle;
     protected String award;
     BattleLoc(Player player,String name,Obstacle obstacle,String award) {
        super(player);
        this.obstacle=obstacle;
        this.name=name;
        this.award=award;
    }
    public boolean getLocation(){
        int obsCount=obstacle.count();
        System.out.println("You are here now:"+this.getName());
        System.out.println("Be carefully!!! Here "+obsCount+" number "+obstacle.getName()+" live!");
        System.out.print("<F>ind or <R>un");
        String selCase=scan.nextLine();
        selCase=selCase.toUpperCase();
        if(selCase.equals("F")){
            if(combat(obsCount)){
                System.out.println(this.getName()+" In the you have cleared all the enemies");
                if (this.award.equals("Food") && player.getInv().isFood()==false){
                    System.out.println(" You have earned "+this.award+"!");
                    player.getInv().setFood(true);
                } else if (this.award.equals("Water") && player.getInv().isWater()==false){
                    System.out.println(" You have earned "+this.award+"!");
                    player.getInv().setWater(true);

                }
                else if (this.award.equals("Firewood") && player.getInv().isFirewood()==false){
                    System.out.println(" You have earned "+this.award+"!");
                    player.getInv().setFirewood(true);

                }
                return true;

            }
            else {

            }
            if (player.getHealthy()<=0){
                System.out.println("You are dead!!!");
                return false;
            }

        }
        
        return true;
    }
    public boolean combat(int obsCount){
        for(int i=0;i<obsCount;i++){
            int defObsHealth=obstacle.getHealth();
            playerStats();
            enemyStats();
            while (player.getHealthy()>0 && obstacle.getHealth()>0){
                System.out.print("<H>it or <R>un:");
                String selCase=scan.nextLine();
                selCase=selCase.toUpperCase();
                if (selCase.equals("H")){
                    System.out.println("You hit");
                    obstacle.setHealth(obstacle.getHealth()-player.getTotalDamage());
                    afterHit();
                    if (obstacle.getHealth()>0){
                        System.out.println();
                        System.out.println("The monster hit you!");
                        player.setHealthy(player.getHealthy()-(obstacle.getDamage()-player.getInv().getArmor()));
                        afterHit();
                    }

                }
                else {
                    break;
                }
            }
            if (obstacle.getHealth()<player.getHealthy() ){
                System.out.println("You defeated  enemy !");
                player.setMoney(player.getMoney()+obstacle.getAward());
                System.out.println("Your current money :"+player.getMoney());
                obstacle.setHealth(defObsHealth);

            }
            else {
                return false;
            }
            System.out.println("--------------------------------");


        }
        return true;
    }
    public void playerStats(){
        System.out.println("Player values\n----------");
        System.out.println("Soul:"+player.getHealthy());
        System.out.println("Damage:"+player.getDamage());
        System.out.println("Money:"+player.getMoney());
        if(player.getInv().getDamage()>0){
            System.out.println("Weapon "+player.getInv().getwName());
        }
        if(player.getInv().getArmor()>0){
            System.out.println("Armor "+player.getInv().getaName());
        }
        
    }
    public void enemyStats(){
        System.out.println("\n" + obstacle.getName()+" Values\n-----------------");
        System.out.println("Soul:"+obstacle.getHealth());
        System.out.println("Damage:"+obstacle.getDamage());
        System.out.println("Award:"+obstacle.getAward());
    }
    public void afterHit(){
        System.out.println("Player health:"+player.getHealthy());
        System.out.println(obstacle.getName()+" Health:"+obstacle.getHealth());
        System.out.println();
    }
}
