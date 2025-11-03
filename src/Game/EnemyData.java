package Game;

import java.util.Random;

public class EnemyData {
    public Random rand = new Random();
    public static int enemyHealth = 100;
    public static int enemyDamage = 0;
    
    //Getter And Setters
    
    //For Health
    public int getEnemyHealth(){
        return enemyHealth;
    }
    
    public void setEnemyHealth(int health){
        enemyHealth += health; 
    }
    
    //For Damage
    public int getEnemyDamage(){
        return enemyDamage;
    }
    
    public void setEnemyDamage(){
        enemyDamage = rand.nextInt(25);
        System.out.println(enemyDamage);
    }
}
