package com.keyin;

public class Game {
    private String gameTitle;
    private double price;
    private int gameID;

    // Constructor
    public Game (String gameTitle, double price, int gameID){
        this.gameTitle = gameTitle;
        this.price = price;
        this.gameID = gameID;
    }

    // Getters and Setters
    public String getTitle(){
        return gameTitle;
    }

    public double getPrice(){
        return price;
    }
    public int getGameID() {
        return gameID;
    }

    public void setGameTitle(String gameTitle){
        this.gameTitle = gameTitle;
    }

    public void setPrice(double price){
        this.price = price;
    }

    public void setGameId(int gameID){
        this.gameID = gameID;
    }

}
