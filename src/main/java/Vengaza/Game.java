package Vengaza;
import java.util.*;

public class Game implements GameInterface {
    // Variables
    boolean exitProgram;
    int selectionOne;
    int selectionTwo;
    int round;
    int glare;

    /**
     * Function: Game()
     * Usage: Game()
     * -------------------------
     * This is the default constructor for the Game class. This method sets default values for the
     * Game object.
     */
    public void Game() {
        exitProgram = false;
        selectionOne = 1;
        selectionTwo = 1;
        round = 1;
        int glare = 100;
        //characterOne = NULL;
        //characterTwo = NULL;
    }

    /**
     * Function: Game(int selectionOne, int selectionTwo)
     * Usage: Game(selectionOne, selectionTwo)
     * -------------------------
     * This is the overloaded constructor for the Game class. This method sets default values for the
     * Game object.
     */
    public void Game(int selectionOne, int selectionTwo) {
        exitProgram = false;
        this.selectionOne = selectionOne;
        this.selectionTwo = selectionTwo;
    }

    /*
     * Function: Game::menu()
     * Usage: gameObj.menu()
     * -------------------------
     * This is a public member function for the Game class. This function creates the menu for the class
     * and allows the user to play through the game or exit.
     */
    public void menu() {
        Scanner sc = new Scanner(System.in);

        while (!exitProgram) {
            System.out.println("Menu");
            System.out.println("---------------------------------");
            System.out.println("1. Play Game");
            System.out.println("2. Exit");
            System.out.println("Please select a number: ");

            while (!sc.hasNextInt()) {
                System.out.println("Please pick a valid number!");
                sc.next(); // this is important!
            }
            int menuSelection = sc.nextInt();
            System.out.println();
            validate(menuSelection, 1, 2);

            if (menuSelection == 1) {                                    //1. Play Game
                characterSetup();
                battle();

                deleteCharacterObjects();                                //Free Memory
            } else {                                                     //2. Exit
                exitProgram = true;
            }
        }
    }
}
