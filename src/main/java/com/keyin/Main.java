package com.keyin;

import java.util.Scanner;
import java.lang.NumberFormatException;

// Make CLI system
// Replace console into scanner
public class Main {
    private static Cart cart = new Cart();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean loading = true;
        while (loading) {
            System.out.println("\n----- Game Craft Store Menu ------");
            System.out.println("1. View Games");
            System.out.println("2. Cart");
            System.out.println("3. Checkout");
            System.out.println("4. Exit");

            System.out.print("Enter your option (1-4):");
            String input = scanner.nextLine();

            try {
                int option = Integer.parseInt(input.trim());

                switch (option) {
                    case 1:
                        LoadsViewGames(scanner); // add logic
                        break;
                    case 2:
                        cart.displayCart();
                        break;
                    case 3:
                        LoadsCheckout(scanner); // add logic
                        break;
                    case 4:
                        loading = false;
                        System.out.println("Thank you choosing Game Craft!");
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                }
            } catch (NumberFormatException error) {
                System.out.println("Please enter a valid number.");
            }
        }
        scanner.close();

    }
//
    private static void LoadsViewGames(Scanner scanner) {
        ViewGames.getInventory().forEach(game ->
                System.out.println(game.getTitle() + " - $" + String.format("%.2f", game.getPrice()) + " " + "Game ID - " + game.getGameID() )
        );
        System.out.print("\nEnter game ID to add to cart: ");
        String input = scanner.nextLine();
        GameSelection(input, scanner);
    }
    //
    private static void GameSelection(String input, Scanner scanner){
        try {
            int gameId = Integer.parseInt(input.trim());
            if (gameId == 0) {
                System.out.println("Loading to main menu");
            } else {
                Game gameOption = null;
                for (Game game : ViewGames.getInventory()) {
                    if (game.getGameID() == gameId) {
                        gameOption = game;
                        break;
                    }
                }
                if (gameOption != null) {
                    cart.addGame(gameOption,true);
                    System.out.println("Game has been added to your cart: " + gameOption.getTitle());
                } else {

                    System.out.println("No game found with ID: " + gameId);
                }
            }
        } catch (NumberFormatException error) {
            System.out.println("Please try another game ID.");
        }
    }
    //
    private static void LoadsCheckout(Scanner scanner) {
        cart.displayCart();
        if (cart.cartIsEmpty()) {
            System.out.println("Your cart is empty.");
            return;
        }

        while (true) {
            System.out.print("\nProceed to checkout? (y/n): ");
            String processed  = scanner.nextLine().trim().toLowerCase();

            if (processed.equals("y")) {
                double total = cart.getTotal();
                cart.deleteGames();
                System.out.printf("Total amount paid: $%.2f%n", total);
                break;
            } else if (processed.equals("n")) {
                System.out.println("Returning to main menu.");
                break;
            } else {
                System.out.println("Invalid input. Please try again.");
            }
        }
    }

}

