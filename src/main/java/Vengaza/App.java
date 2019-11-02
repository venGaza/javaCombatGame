package Vengaza;

/**
 * This is the Fantasy Combat Game which focuses on the development of five
 * characters with special abilities that do battle. The characters include a barbarian, a
 * vampire, a blue men, a medusa, and Harry Potter. This program will also include a basic menu
 * that tests the battle between these characters.
 */
public class App
{
    public static void main( String[] args )
    {
        welcomeMessage();

        Game game = new Game();
        game.menu();

        System.out.println( "Have a nice day!" );
    }

    /**
     * Prints out a welcome message upon launching of the combatGame application
     */
    public static void welcomeMessage()
    {
        System.out.println("Welcome to the Fantasy Combat Game! This game allows the player to choose a fantasy \n" +
                "character to do battle with. The player can choose between the following: Barbarian, Vampire, \n" +
                "Blue Men, Medusa, and the feared Harry Potter! Each character possesses a unique special \n" +
                "special ability to allow them to conquer their opponent. Enjoy!!! \n");
    }
}