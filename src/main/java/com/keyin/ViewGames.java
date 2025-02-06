package com.keyin;

import java.util.ArrayList;
import java.util.List;

// Unit test - Validate game addition/removal
public class ViewGames {
    private static List<Game> inventory = new ArrayList<>();

    static{
        inventory.add(new Game("Overcooked 2", 29.99,1));
        inventory.add(new Game("The First Descendant", 39.99,2));
        inventory.add(new Game("Dreamlight Vally", 25.99,3));
        inventory.add(new Game("House Flipper 2", 69.99,4));
        inventory.add(new Game("Moving Out", 19.99,5));
        inventory.add(new Game("Hogwarts Legacy", 89.99,6));
    }

    public static List<Game> getInventory() {
        return new ArrayList<>(inventory);
    }
}
}
