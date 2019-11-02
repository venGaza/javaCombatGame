package Vengaza;
import java.util.*; //Scanner

public class Game implements GameInterface {
    // Variables
    boolean exitProgram;
    int selectionOne;
    int selectionTwo;
    int round;
    int glare;

    /**
     * Method: Game()
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
        Character characterOne = null;
        Character characterTwo = null;
    }

    /**
     * Method: Game(int selectionOne, int selectionTwo)
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
     * Method: Game::menu()
     * Usage: gameObj.menu()
     * -------------------------
     * This is a public member function for the Game class. This function creates the menu for the class
     * and allows the user to play through the game or exit.
     */
    public void menu() {
        while (!exitProgram) {
            System.out.println("Menu");
            System.out.println("---------------------------------");
            System.out.println("1. Play Game");
            System.out.println("2. Exit");
            System.out.println("Please select a number: ");

            int menuSelection = getInteger(1, 2);
            System.out.println();

            if (menuSelection == 1) {                                    //1. Play Game
                characterSetup();
                //battle();
            } else {                                                     //2. Exit
                exitProgram = true;
            }
        }
    }

    /**
     * Method: getInteger()
     * Usage: getInteger()
     * -------------------------
     * This is a private member method for the Game class. This method gets an integer input from the user
     * and validates it falls within the specified range.
     */
    public int getInteger(int min, int max) {
        Scanner sc = new Scanner(System.in);

        int number = 0;
        while(number < min || number > max) {
            while (!sc.hasNextInt()) {
                System.out.println("Selection must be number!");
                sc.next();
            }
            number = sc.nextInt();
            System.out.println("Please pick a valid number!");
        }

        sc.close();
        return number;
    }

    /**
     * Method: characterSetup()
     * Usage: characterSetup()
     * -------------------------
     * This is a private member method for the Game class. This function sets up the characters for the
     * game.
     */
    public void characterSetup() {
        //characterSelection();                                        //Choose Characters
        //createCharacterObjects();                                    //Create Character Two
    }


}
