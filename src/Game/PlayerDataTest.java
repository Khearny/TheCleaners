package Game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PlayerDataTest {

    private PlayerData player;

    // Reset static values before each test to avoid interference
    @BeforeEach
    public void reset() {
        player = new PlayerData();
        PlayerData.playerCoin = 1000;
        PlayerData.playerHealth = 100;
        PlayerData.playerMana = 100;
        PlayerData.playerHappiness = 100;
    }

    // Test coin deduction logic
    @Test
    public void testCoinDecrease() {
        player.setCoin(-200);
        assertEquals(800, player.getCoin());
    }

    // Test health increase with upper limit cap
    @Test
    public void testHealthCap() {
        player.setPlayerHealth(50);
        assertEquals(100, player.getPlayerHealth());
    }

    // Test mana increase with upper limit cap
    @Test
    public void testManaCap() {
        player.setPlayerMana(50);
        assertEquals(100, player.getPlayerMana());
    }

    // Test happiness decrease logic
    @Test
    public void testHappinessDecrease() {
        player.setPlayerHappiness(-30);
        assertEquals(70, player.getPlayerHappiness());
    }
}
