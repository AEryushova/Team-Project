package ru.netology;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

public class GameStoreTest {


    /* добавление игры в лист + + какой ассерт используется для сравнения словарей?*/
    @Test
    public void shouldAddGame() {
        GameStore store = new GameStore();
        Game game1 = store.publishGame("Покер", "Карточные");
        List<Game> expected = ;
        List<Game> actual = store.getGames();
        Assertions.assertLinesMatch(expected, actual);
    }

    /* проверка наличия игры в каталоге, если ее там нет */
    @Test
    public void shouldCheckThatTheGameIsNotInTheStore() {
        GameStore store = new GameStore();
        Game game1 = store.publishGame("Покер", "Карточные");
        boolean expected = false;
        boolean actual = store.containsGame(game1);
        Assertions.assertEquals(expected, actual);
    }

    /* проверка наличия игры в каталоге, если она там уже есть (изменить т.к выкидывает исключение)*/
    @Test
    public void shouldCheckThatTheGameInTheStore() {
        GameStore store = new GameStore();
        Game game1 = store.publishGame("Покер", "Карточные");
        Game game2 = store.publishGame("Нарды", "Настольные");
        Game game3 = store.publishGame("Покер", "Карточные");
        boolean expected = true;
        boolean actual = store.containsGame(game2);
        Assertions.assertEquals(expected, actual);
    }
    /* регистрация количества времени,которое игрок провел за игрой, если игрока нет в мапе
    + какой ассерт используется для сравнения словарей?*/

    @Test
    public void shouldAddPlayerAndPlayTime() {
        GameStore store = new GameStore();
        store.addPlayTime("Kolya", 2);
        Map<String, Integer> expected = ("Kolya", 2);
        Map<String, Integer> actual = store.getPlayedTime();
        Assertions. assert
    }

    /* регистрация количества времени,которое игрок провел за игрой, если игрок уже есть в мапе
     + какой ассерт используется для сравнения словарей?*/
    @Test
    public void shouldRecordTheTimeThatThePlayerSpentInTheGame() {
        GameStore store = new GameStore();
        store.addPlayTime("Kolya", 2);
        store.addPlayTime("Kolya", 3);
        Map<String, Integer> expected = ("Kolya", 3);
        Map<String, Integer> actual = store.getPlayedTime();
        Assertions. assert
    }

    /* поиск имени игрока, который играл в игры этого каталога больше всего времени*/
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

    /* поиск имени игрока, который играл в игры этого каталога больше всего времени, если игроков вообще нет*/
    @Test
    public void shouldFindThePlayerWhoPlayedTheMostTimeIfThereAreNoPlayers() {
        GameStore store = new GameStore();
        String expected = null;
        String actual = store.getMostPlayer();
        Assertions.assertEquals(expected, actual);
    }

    /* суммирование общего количества времени всех игроков*/
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
}
