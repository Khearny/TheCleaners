package Game;


public class PlayerData {
    
    public static int playerCoin = 1000;
    public static int playerHealth = 100;
    public static int playerMana = 100;
    public static int playerHappiness = 100;
    
    static public boolean isGetLicence = false;
    static public boolean isLearnSkill = false;
    public static boolean isGetEquipment = false;
    
    //Getters And Setters
    
    //Get Coin Value
    public int getCoin(){
        return playerCoin;
    }
    
    //Set Coin Value
    public void setCoin(int coin){
        playerCoin += coin;
    }
    
    //Get Health Value
    public int getPlayerHealth(){
        return playerHealth;
    }
    
    //Set Health Value
    public void setPlayerHealth(int health){
        playerHealth += health;
    }
    
    //Get Mana Value
    public int getPlayerMana(){
        return playerMana;
    }
    
    //Set Mana Value
    public void setPlayerMana(int mana){
        playerMana += mana;
    }
    
    //Get Happiness Value
    
    public int getPlayerHappiness(){
        return playerHappiness;
    }
    
    //Set Happiness Value
    public void setPlayerHappiness(int happiness){
        playerHappiness += happiness;
    }
    
    //Get Licence Bool
    public boolean getIsGetLicence(){
        return isGetLicence;
    }
    
    //Set Licence Bool
    public void setIsGetLicence(boolean bool){
        isGetLicence = bool;
    }
    
    //Get Skill Bool
    public boolean getIsLearnSkill(){
        return isLearnSkill;
    }
    
    //Set Skill Bool
    public void setIsLearnSkill(boolean bool){
        isLearnSkill = bool;
    }
    
    //Get Equipment Bool
    public boolean getIsGetEquipment(){
        return isGetEquipment;
    }
    
    //Set Equipment Bool
    public void setIsGetEquipment(boolean bool){
        isGetEquipment = bool;
    }
}
