package Vengaza;
import java.util.Random; //Random number generator

/**
 * Class: Barbarian
 * -------------------------
 * This is the implementation for the Barbarian class. This subclass of Character stores the
 * characteristics and special abilities of the Barbarian class.
 */
public class Barbarian extends Character implements BarbarianInterface{
    Random rand = new Random();

    /**
     * Method: Barbarian()
     * Usage: Barbarian()
     * -------------------------
     * This is the default constructor for the Barbarian class. This function sets default values for the
     * Barbarian object.
     */
    public void Barbarian() {
        name = "Barbarian";
        type = "Barbarian";
        attack = 1;              //2d6
        defense = 4;             //2d6
        armor = 0;
        strength = 12;
    }

    /**
     * Method: attackChar()
     * Usage: obj.attackChar()
     * -------------------------
     * This is a public member method for the Barbarian class. This function calculates and returns an
     * attack number for the Barbarian object.
     */
    public void attackChar() {
        int die1 = rand.nextInt(5) + 1;                  //Barbarian rolls 2x 6 sided die for attack
        int die2 = rand.nextInt(5) + 1;
        int attack = die1 + die2;

        System.out.println();

        System.out.printf("%s attacks with a dice roll of %d %d ", getName(), die1, die2);
        System.out.printf("for a total attack of %d! %n", attack);
        setAttackRoll(attack);
    }

    /**
     * Method: defenseChar()
     * Usage: obj.defenseChar()
     * -------------------------
     * This is a public member method for the Barbarian class. This function takes an attack number and
     * returns how much damage was done.
     */
    public void defenseChar(int attack) {
        int die1 = rand.nextInt(5) + 1;
        int die2 = rand.nextInt(5) + 1;
        int defense = die1 + die2;

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
            } else {
                System.out.printf("%s's strength is DEPLETED!%n", getName());
            }
        }
    }

    /**
     * Method: printCharacteristic()
     * Usage: obj.printCharacteristic()
     * -------------------------
     * This is a public member method for the Barbarian class. This function prints out the Barbarian
     * characteristics.
     */
    public void printCharacteristic() {
        System.out.println("Barbarian: Think Conan or Hercules from the movies. Big sword, ");
        System.out.println("big muscles, bare torso.\n");
    }
}