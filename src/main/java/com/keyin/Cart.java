package com.keyin;

import java.util.ArrayList;
import java.util.List;

// Unit Test - Cart total calculation
public class Cart {
    private List<Game> items;

    // Constructor
    public Cart(){
        this.items = new ArrayList<>();
    }

    // Add to the cart
    // Delete from cart
    // Display The cart
    // ? maybe total price of the cart

    public void addGame(Game game){
        items.add(game);
        // double check if the space is needed in the string
        System.out.println(game.getTitle() + " has been successfully added to your cart.");
    }

    public void deleteGames(){
        items.clear();
    }

    public void displayCart(){
        if (items.isEmpty()) {
            System.out.println("No items in your cart.");
            return;
        }

        System.out.println("Shopping Cart Contains:");
        for (Game game : items){
            System.out.println(gamr);
        }

        // Make get total method
        System.out.print("Total Amount:", getTotal());
    }






}
