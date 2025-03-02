package ui;

import model.Bacon;
import model.Ingredients;
import model.Pickle;
import model.Sandwich;
import persistence.*;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.IOException;


// A sandwich game that allows the player to make and serve sandwiches to customers
public class SandwichGame {

    private Sandwich sandwich;
    List<String> ingredList;

    private Scanner scanner;
    private boolean programRunning;
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;
    private static final String JSON_STORE = "./data/Sandwich.json";


    // EFFECTS: Creates an instance of the sandwich game in the terminal console
    // Attribution: code structure based on the Flashcards lab
    public SandwichGame() {
        inital();

        while (this.programRunning) {
            mainGameMenu();
        }

    }

    // MODIFIES: this
    // EFFECTS: initializes the game with the starting values
    // Attribution: code structure based on the Flashcards lab
    public void inital() {
        this.scanner = new Scanner(System.in);
        this.programRunning = true;

        sandwich = new Sandwich();
        ingredList = new ArrayList<>();
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
    }

    // EFFECTS: displays and checks the user's inputs for the main game menu.
    // Attribution: code structure based on the Flashcards lab
    public void mainGameMenu() {
        System.out.println("Please select an option:\n");
        System.out.println("b: Add a bacon");
        System.out.println("p: Add a pickle");
        System.out.println("v: View all ingredients in the sandwich");
        System.out.println("r: Remove the most recently added ingredient from the sandwich");
        System.out.println("s: Save the current sandwich I am working on");
        System.out.println("l: Load the sandwich that I saved");
        System.out.println("q: Exit the game");
        System.out.println("---------------------------------------------------------------");

        String input = this.scanner.nextLine();
        processInput(input);

    }

    // EFFECTS: processes the user's input in the game 
    // Attribution: code structure based on the Flashcards lab
    public void processInput(String input) {
        System.out.println("---------------------------------------------------------------");
        switch (input) {
            case "b": addBacon();
                break;
            case "p": addPickle();
                break;
            case "v": viewSandwich();
                break;
            case "r": removeIngredient();
                break;
            case "s": saveSandwich();
                break;
            case "l": loadSandwich();
                break;
            case "q": exitGame();
                break;
            default:
                System.out.println("This input is invalid. Please try again.");
        }
        System.out.println("---------------------------------------------------------------");

    }

    // MODIFIES: this
    // EFFECTS: adds a new bacon to the sandwich
    public void addBacon() {

        System.out.println("\nShould this bacon be raw(enter 1), or cooked(enter 2):");
        int baconProperty = this.scanner.nextInt();
        scanner.nextLine();
        
        if (baconProperty == 1) {
            Bacon bacon = new Bacon(baconProperty);
            this.sandwich.addIngredient(bacon);
            ingredList.add("Raw Bacon");
            System.out.println("\nA raw bacon is added to the sandwich!");
        } else if (baconProperty == 2) {
            Bacon bacon = new Bacon(baconProperty);            
            this.sandwich.addIngredient(bacon);
            ingredList.add("Cooked Bacon");
            System.out.println("\nA cooked bacon is added to the sandwich!");
        } else {
            System.out.println(baconProperty + "\n is not a valid input, this bacon will not be added, try again.");
        }
    }

    // MODIFIES: this
    // EFFECTS: adds a new pickle to the sandwich
    public void addPickle() {

        System.out.println("\nShould this pickle be dill(enter 1), or sweet(enter 2):");
        int pickleProperty = this.scanner.nextInt();
        scanner.nextLine();
        
        if (pickleProperty == 1) {
            Pickle pickle = new Pickle(pickleProperty);
            this.sandwich.addIngredient(pickle);
            ingredList.add("Dill Pickle");
            System.out.println("\nA dill pickle is added to the sandwich!");
        } else if (pickleProperty == 2) {
            Pickle pickle = new Pickle(pickleProperty);            
            this.sandwich.addIngredient(pickle);
            ingredList.add("Sweet Pickle");
            System.out.println("\nA sweet pickle is added to the sandwich!");
        } else {
            System.out.println(pickleProperty + "\n is not a valid input, this pickle will be discarded, try again.");
        }
    }

    // MODIFIES: this
    // EFFECTS: displays all the ingredients inside the sandwich
    public void viewSandwich() {
        if (sandwich.viewIngredients().isEmpty() && ingredList.isEmpty()) {
            System.out.println("The sandwich is empty:( !");
        } else {
            System.out.println("Here are the ingredients currently in the sandwich: \na" + ingredList);
        }
    }
     
    // MODIFIES: this
    // EFFECTS: remove the last ingredient added from the sandwich, print a message if there is no ingredients
    public void removeIngredient() {
        if (sandwich.viewIngredients().isEmpty()) {
            System.out.println("This sandwich is empty! No ingredient to remove!");
        } else {
            int last = ingredList.size() - 1;
            String removed = ingredList.get(last);
            System.out.println("This " + removed + " will be removed from the sandwich!");
            sandwich.removeIngredients();
            ingredList.remove(last);
        }
    }

    // MODIFIES: this
    // EFFECTS: Prints a message to tell the user that the game has stopped and stops the game from running
    // Attribution: this code structure is based on the Flashcards lab
    public void exitGame() {
        System.out.println("The game has ended!");
        this.programRunning = false;
    }

    // EFFECTS: saves the workroom to file
    // Attribution: this code structure is based on the JsonSerializationDemo
    private void saveSandwich() {
        try {
            jsonWriter.open();
            jsonWriter.write(sandwich);
            jsonWriter.close();
            System.out.println("Saved current sandwich to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }
    
    // MODIFIES: this
    // EFFECTS: loads sandwich from file
    // Attribution: this code structure is based on the JsonSerializationDemo
    private void loadSandwich() {
        try {
            sandwich = jsonReader.read();
            for (Ingredients i : sandwich.viewIngredients()) {
                String ing = i.getQuality() + " " + i.getName();
                ingredList.add(ing);
            }
            System.out.println("Loaded sandwich from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }        
    }
}
