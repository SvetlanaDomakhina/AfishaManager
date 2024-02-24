package ru.netology;

import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class AfishaManagerTest {

    @Test
    public void testFindAll() {

        AfishaManager manager = new AfishaManager();
        String movie1 = "Исчезнувшая";
        String movie2 = "Леон";
        String movie3 = "Начало";

        manager.add(movie1);
        manager.add(movie2);
        manager.add(movie3);

        String [] actual = manager.findAll();
        String [] expected = { "Исчезнувшая", "Леон", "Начало"};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testFindLastIfLimitUnderSize() {
        AfishaManager manager = new AfishaManager();

        String movie1 = "Исчезнувшая";
        String movie2 = "Леон";
        String movie3 = "Начало";
        String movie4 = "Семь";
        String movie5 = "Гладиатор";
        String movie6 = "Джентльмены";

        manager.add(movie1);
        manager.add(movie2);
        manager.add(movie3);
        manager.add(movie4);
        manager.add(movie5);
        manager.add(movie6);

        String [] actual = manager.findLast();
        String [] expected = { "Джентльмены", "Гладиатор", "Семь", "Начало", "Леон" };
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void testFindLastIfLimitUnderSizeWithParameter() {
        AfishaManager manager = new AfishaManager(3);

        String movie1 = "Исчезнувшая";
        String movie2 = "Леон";
        String movie3 = "Начало";
        String movie4 = "Семь";
        String movie5 = "Гладиатор";
        String movie6 = "Джентльмены";

        manager.add(movie1);
        manager.add(movie2);
        manager.add(movie3);
        manager.add(movie4);
        manager.add(movie5);
        manager.add(movie6);

        String [] actual = manager.findLast();
        String [] expected = { "Джентльмены", "Гладиатор", "Семь" };
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void testFindLastWhenOversizeLimit() {
        AfishaManager manager = new AfishaManager(5);

        String movie1 = "Исчезнувшая";
        String movie2 = "Леон";
        String movie3 = "Начало";

        manager.add(movie1);
        manager.add(movie2);
        manager.add(movie3);

        String [] actual = manager.findLast();
        String [] expected = { "Начало", "Леон", "Исчезнувшая" };
        Assertions.assertArrayEquals(expected, actual);

    }

}
