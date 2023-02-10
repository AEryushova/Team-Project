package ru.netology;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

public class GameStoreTest {

    @Test
    public void shouldAddGameThatTheGameIsNotInTheStore() {
        GameStore store = new GameStore();
        Game game1 = store.publishGame("Покер", "Карточные");
        boolean expected = true;
        boolean actual = store.containsGame(game1);
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void shouldNoAddGameThatTheGameInTheStore() {
        GameStore store = new GameStore();
        Game game1 = store.publishGame("Покер", "Карточные");
        Game game2 = store.publishGame("Нарды", "Настольные");
        Assertions.assertThrows(RuntimeException.class, () -> {store.publishGame("Покер", "Карточные");});
    }
    @Test
    public void shouldRegisteredTimeAndAddPlayerAndSumPlayTime() {
        GameStore store = new GameStore();
        Game game1 = store.publishGame("Покер", "Карточные");
        int expected = 2;
        int actual = store.addPlayTime("Kolya", 2);
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void shouldRegisteredTimeAndSumPlayTime() {
        GameStore store = new GameStore();
        store.addPlayTime("Kolya", 2);
        store.addPlayTime("Kolya", 3);
        int expected = 9;
        int actual = store.addPlayTime("Kolya", 4);
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void shouldFindThePlayerWhoPlayedTheMostTime() {
        GameStore store = new GameStore();
        store.addPlayTime("Kolya", 2);
        store.addPlayTime("Masha", 5);
        store.addPlayTime("Lena", 4);
        String expected = "Masha";
        String actual = store.getMostPlayer();
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void shouldFindThePlayerWhoPlayedTheMostTimeIfThereAreOnePlayers() {
        GameStore store = new GameStore();
        store.addPlayTime("Kolya", 2);
        String expected = "Kolya";
        String actual = store.getMostPlayer();
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void shouldFindThePlayerWhoPlayedTheMostTimeIfThereAreNoPlayers() {
        GameStore store = new GameStore();
        String expected = null;
        String actual = store.getMostPlayer();
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void mustSumUpTheTotalAmountOfTimeOfAllPlayers() {
        GameStore store = new GameStore();
        store.addPlayTime("Kolya", 2);
        store.addPlayTime("Masha", 5);
        store.addPlayTime("Lena", 4);
        int expected = 11;
        int actual = store.getSumPlayedTime();
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void mustSumUpTheTotalAmountOfTimeOfAllPlayersIfThereAreOnePlayers() {
        GameStore store = new GameStore();
        store.addPlayTime("Masha", 5);
        int expected = 5;
        int actual = store.getSumPlayedTime();
        Assertions.assertEquals(expected, actual);
    }
    @Test
    public void mustSumUpTheTotalAmountOfTimeOfAllPlayersIfThereAreNoPlayers() {
        GameStore store = new GameStore();
        int expected = 0;
        int actual = store.getSumPlayedTime();
        Assertions.assertEquals(expected, actual);
    }
}
