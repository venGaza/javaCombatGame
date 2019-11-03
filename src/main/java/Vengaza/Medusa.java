package Vengaza;
import java.util.Random; //Random number generator

/*
 * Class: Medusa
 * -------------------------
 * This is the implementation file for the Medusa class. This subclass of Character stores the
 * characteristics and special abilities of the Medusa class.
 */
public class Medusa extends Character implements MedusaInterface {
    private Random rand = new Random();

    /**
     * Method: Medusa()
     * Usage: Medusa()
     * -------------------------
     * This is the default constructor for the Medusa class. This function sets default values for the
     * Medusa object.
     */
    public void Medusa() {
        name = "Medusa";
        type = "Medusa";
        attack = 1;              //2d6
        defense = 3;             //1d6
        armor = 3;
        strength = 8;
    }

    /**
     * Method: attackChar()
     * Usage: obj.attackChar()
     * -------------------------
     * This is a public member method for the Medusa class. This function calculates and returns an
     * attack number for the Barbarian object.
     */
    public void attackChar() {
        int die1 = rand.nextInt(5) + 1;                  //Medusa rolls 2x 6 sided die for attack
        int die2 = rand.nextInt(5) + 1;
        int attack = die1 + die2;

        if (attack == 12) {                             //Simulate Medusa's glare ability
            System.out.println("Medusa's special ability, GLARE, has activated and turned the target to stone!");
            attack = 100;                               //Knock out opponent
        } else {
            System.out.printf("%s attacks with a roll of: %d %d ", getName(), die1, die2);
            System.out.printf(" for a total attack of %d!%n", attack);
            setAttackRoll(attack);
        }
    }

    /**
     * Method: defenseChar()
     * Usage: obj.defenseChar()
     * -------------------------
     * This is a public member method for the Medusa class. This function takes an attack number and
     * returns how much damage was done.
     */
    public void defenseChar(int attack) {              //Medusa rolls 1x 6 sided die for defense
        int die1 = rand.nextInt(5) + 1;
        defense = die1;

        System.out.printf("%s defends with a dice roll of: %d ", getName(), die1);
        System.out.printf(" for a total defense of %d!%n", defense);

        int damage = attack - defense - getArmor();          //Calculate total damage

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
     * Method: Medusa::printCharacteristic()
     * Usage: obj.printCharacteristic()
     * -------------------------
     * This is a public member method for the Medusa class. This function prints out the Medusa
     * characteristics.
     */
    public void printCharacteristic() {
        System.out.println("Medusa: Scrawny lady with snakes for hair which helps her during combat. Just ");
        System.out.println("don’t look at her!");
    }
}