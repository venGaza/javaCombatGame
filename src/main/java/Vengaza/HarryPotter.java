package Vengaza;
import java.util.Random; //Random number generator

/**
 * Class: HarryPotter
 * -------------------------
 * This is the implementation file for the HarryPotter class. This subclass of Character stores the
 * characteristics and special abilities of the HarryPotter class.
 */
public class HarryPotter extends Character implements HarryPotterInterface {
    private Random rand = new Random();
    private boolean hogwarts;

    /**
     * Method: HarryPotter()
     * Usage: HarryPotter()
     * -------------------------
     * This is the default constructor for the HarryPotter class. This function sets default values for the
     * HarryPotter object.
     */
    public HarryPotter() {
        super();
        name = "Harry Potter";
        type = "Harry Potter";
        attack = 1;              //2d6
        defense = 4;             //2d6
        armor = 0;
        strength = 10;
        hogwarts = false;
    }

    /**
     * Method: attackChar()
     * Usage: obj.attackChar()
     * -------------------------
     * This is a public member method for the HarryPotter class. This function calculates and returns an
     * attack number for the HarryPotter object.
     */
    public void attackChar() {
        int die1 = rand.nextInt(5) + 1;                  //HarryPotter rolls 2x 6 sided die for attack
        int die2 = rand.nextInt(5) + 1;
        attack = die1 + die2;

        System.out.printf("%s attacks with a dice roll of %d %d ", getName(), die1, die2);
        System.out.printf("for a total attack of %d! %n", attack);
        setAttackRoll(attack);
    }

    /**
     * Method: defenseChar()
     * Usage: obj.defenseChar()
     * -------------------------
     * This is a public member method for the HarryPotter class. This function takes an attack number and
     * returns how much damage was done.
     */
    public void defenseChar(int attack) {
        int die1 = rand.nextInt(5) + 1;                  //HarryPotter rolls 2x 6 sided die for defense
        int die2 = rand.nextInt(5) + 1;
        defense = die1 + die2;

        System.out.printf("%s defends with a dice roll of: %d %d", getName(), die1, die2);
        System.out.printf(" for a total defense of %d!%n", defense);

        int damage = attack - defense - getArmor();

        System.out.printf("%d(attack) - %d(defense) - %d(armor)", attack, defense, getArmor());
        System.out.printf(" = %d damage taken %n", damage);

        if (damage <= 0) {
            System.out.printf("%s takes not damage and still has %d strength.%n", getName(), getStrength());
        } else {
            setStrength(getStrength() - damage);
            if (getStrength() > 0) {
                System.out.printf("%s now has %d strength.%n", getName(), getStrength());
            } else if (getStrength() <= 0 && !hogwarts) {   //Special Ability activates at 0
                System.out.printf("%s's strength is DEPLETED! However, his special ability, %n", getName());
                System.out.printf("HOGWARTS has revived him! %n");
                hogwarts = true;                                        //Hogwarts can only be used once
                setStrength(20);                             //Reset Harry Potter health
            } else {
                System.out.printf("%s's strength is DEPLETED!%n", getName());
            }
        }
    }

    /**
     * Method: printCharacteristic()
     * Usage: obj.printCharacteristic()
     * -------------------------
     * This is a public member method for the HarryPotter class. This function prints out the HarryPotter
     * characteristics.
     */
    public void printCharacteristic() {
        System.out.println("Harry Potter: He is a powerful wizard who can revive himself!");
    }
}