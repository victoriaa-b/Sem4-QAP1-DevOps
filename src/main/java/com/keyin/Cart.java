package com.keyin;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Game> items;

    // Constructor
    public Cart(){
        this.items = new ArrayList<>();
    }

    public void addGame(Game game, boolean noPrint) {
        items.add(game);
        if (!noPrint) {
            System.out.println(game.getTitle() + " has been successfully added to your cart.");
        }
    }

    public void deleteGames(){
        items.clear();
    }

    public boolean cartIsEmpty(){
        return items.isEmpty();
    }

    public double getTotal(){
        double total = 0;
        for (Game game : items) {
            total += game.getPrice();
        }
return total;
    }

    public void displayCart(){
        if (items.isEmpty()) {
            System.out.println("No items in your cart.");
            return;
        }

        System.out.println("Shopping Cart Contains:");
        for (Game game : items){
            System.out.println(game);
        }
       System.out.printf("Total Amount: $%.2f%n", getTotal());
    }

    // Changed Checkout into method
    public String processingCheckOut(){
        if(cartIsEmpty()){
            return "Your Cart is empty. There is no items to checkout";
        }
        double total = getTotal();
        deleteGames();
        return "Your order was processed.";
    }








}
