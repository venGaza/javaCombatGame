package Vengaza;
import java.util.*; //Scanner

public class Game implements GameInterface {
    // Variables
    private boolean exitProgram;
    private int selectionOne;
    private int selectionTwo;
    private int round;
    private int glare;
    private Character characterOne;
    private Character characterTwo;
    private Scanner sc = new Scanner(System.in);

    /**
     * Method: Game()
     * Usage: Game()
     * -------------------------
     * This is the default constructor for the Game class. This method sets default values for the
     * Game object.
     */
    public Game() {
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
    public Game(int selectionOne, int selectionTwo) {
        exitProgram = false;
        this.selectionOne = selectionOne;
        this.selectionTwo = selectionTwo;
    }

    /*
     * Method: Game::menu()
     * Usage: gameObj.menu()
     * -------------------------
     * This is a public member method for the Game class. This function creates the menu for the class
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
                battle();
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
    private int getInteger(int min, int max) {
        int number = 0;
        number = sc.nextInt();

        /*
        while(number < min || number > max) {
            while (!sc.hasNextInt()) {
                System.out.println("Selection must be number!");
                sc.next();
            }
            number = sc.nextInt();
            System.out.println("Please pick a valid number!");
        }*/

        return number;
    }

    /**
     * Method: characterSetup()
     * Usage: characterSetup()
     * -------------------------
     * This is a private member method for the Game class. This function sets up the characters for the
     * game.
     */
    private void characterSetup() {
        characterSelection();                                        //Choose Characters
        createCharacterObjects();                                    //Create Character Two
    }

    /**
     * Method: characterSelection()
     * Usage: Game()
     * -------------------------
     * This is a private member method for the Game class. This function allows the user to choose
     * two characters to battle each other.
     */
    private void characterSelection() {
        System.out.println("Character Selection");
        System.out.println("---------------------------------");
        System.out.println("1. Barbarian \n2. Vampire \n3. Blue Men \n4. Medusa \n5. Harry Potter");
        System.out.println("Please select a character(choose corresponding number): ");

        selectionOne = getInteger(1, 5);                            //Select character one
        System.out.println("Please select a 2nd character: ");
        selectionTwo = getInteger(1, 5);                            //Select character two
        System.out.println();
    }

    /**
     * Method: createCharacterObject(Character*, const int&)
     * Usage: createCharacterObject(characterOne, 1)
     * -------------------------
     * This is a private member method for the Game class. This function dynamically creates a character
     * object based on user selection.
     */
    private void createCharacterObjects() {
        if (selectionOne == 1) {                            //Create character one dynamic character
            characterOne = new Barbarian();
        } else if (selectionOne == 2) {
            characterOne = new Vampire();
        } else if (selectionOne == 3) {
            characterOne = new BlueMen();
        } else if (selectionOne == 4) {
            characterOne = new Medusa();
        } else {
            characterOne = new HarryPotter();
        }

        if (selectionTwo == 1) {                            //Create character two dynamic character
            characterTwo = new Barbarian();
        } else if (selectionTwo == 2) {
            characterTwo = new Vampire();
        } else if (selectionTwo == 3) {
            characterTwo = new BlueMen();
        } else if (selectionTwo == 4) {
            characterTwo = new Medusa();
        } else {
            characterTwo = new HarryPotter();
        }

        if (characterOne.getName().equals(characterTwo.getName())) {               //Change characterTwo name
            characterTwo.setName(characterOne.getName() + " Clone");    //if same type of character
        }
    }

    /*
     * Method: battle()
     * Usage: battle()
     * -------------------------
     * This is a private member method for the Game class. This function battles the two characters.
     */
    private void battle() {
        System.out.printf("Prepare for a grand battle between the mighty %s ", characterOne.getName());
        System.out.printf(" and nefarious %s %n", characterTwo.getName());

        characterOne.printCharacteristic();
        characterTwo.printCharacteristic();
        pause();

        while (characterOne.getStrength() > 0 && characterTwo.getStrength() > 0) {
            printRound();
            advanceRound();
            round++;
        }

        printWinner();
    }

    /**
     * Method: printRound()
     * Usage: printRound()
     * -------------------------
     * This is a private member method for the Game class. This function prints the current round.
     */
    private void printRound() {
        System.out.printf("Round %d%n", round);
        System.out.println("---------------------------------");
    }

    /**
     * Method: Game::advanceRound()
     * Usage: battle()
     * -------------------------
     * This is a private member method for the Game class. This function advances the battle by one round.
     */
    private void advanceRound() {
        characterOneAttack();
        System.out.println("---------------------------------");
        characterTwoDefend();

        pause();

        if (characterTwo.getStrength() > 0) {

            System.out.println("---------------------------------");
            characterTwoAttack();
            System.out.println("---------------------------------");
            characterOneDefend();
        }

        pause();
    }

    /**
     * Method: characterOneAttack()
     * Usage: characterOneAttack()
     * -------------------------
     * This is a private member method for the Game class. This function allows character one to attack
     * opponent.
     */
    private void characterOneAttack() {
        System.out.printf("%s attacking %s (Armor: %d Strength: %d)",
                            characterOne.getName(),
                            characterTwo.getName(),
                            characterTwo.getArmor(),
                            characterTwo.getStrength());

        characterOne.attackChar();
    }

    /**
     * Method: characterTwoAttack()
     * Usage: characterTwoAttack()
     * -------------------------
     * This is a private member method for the Game class. This function allows character two to attack
     * opponent.
     */
    private void characterTwoAttack() {
        System.out.printf("%s attacking %s (Armor: %d Strength: %d)%n",
                characterTwo.getName(),
                characterOne.getName(),
                characterOne.getArmor(),
                characterOne.getStrength());

        characterTwo.attackChar();
    }

    /**
     * Method: characterOneDefend()
     * Usage: characterOneDefend()
     * -------------------------
     * This is a private member method for the Game class. This function allows character one to defend.
     */
    private void characterOneDefend() {
        if (characterTwo.getAttackRoll() == glare){              //Check for Medusa's GLARE special
            System.out.printf("%s has turned to stone. %n", characterOne.getName());
            characterOne.setStrength(0);
        } else {
            characterOne.defenseChar(characterTwo.getAttackRoll());
        }
    }

    /**
     * Method: characterTwoDefend()
     * Usage: characterTwoDefend()
     * -------------------------
     * This is a private member method for the Game class. This function allows character two to defend.
     */
    private void characterTwoDefend() {
        if (characterOne.getAttackRoll() == glare){               //Check for Medusa's GLARE special
            System.out.printf("%s has turned to stone. %n", characterTwo.getName());
            characterTwo.setStrength(0);
        } else {
            characterTwo.defenseChar(characterOne.getAttackRoll());
        }
    }

    /**
     * Method: printWinner()
     * Usage: printWinner()
     * -------------------------
     * This is a private member method for the Game class. This function prints the winner of the game.
     */
    private void printWinner() {
        if (characterTwo.getStrength() <= 0) {
            System.out.printf("%s is the WINNER after %d rounds! %n", characterOne.getName(), round);
        } else {
            System.out.printf("%s is the WINNER after %d rounds! %n", characterTwo.getName(), round);
        }

        round = 1;                                  //Reset round counter for next game
    }

    /**
     * Method: pause
     * Usage: pause()
     * -------------------------
     * This is a private member method for the Game class. This function pauses the program.
     */
    private void pause() {
        System.out.println();
        System.out.println("Press enter to continue");
        sc.nextLine();
        System.out.println();
    }
}
