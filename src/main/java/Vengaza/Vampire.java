package Vengaza;
import java.util.Random; //Random number generator

/*
 * Class: Vampire
 * -------------------------
 * This is the implementation file for the Vampire class. This subclass of Character stores the
 * characteristics and special abilities of the Vampire class.
 */
public class Vampire extends Character implements VampireInterface {
    Random rand = new Random();

    /**
     * Method: Vampire()
     * Usage: Vampire()
     * -------------------------
     * This is the default constructor for the Vampire class. This function sets default values for the
     * Vampire object.
     */
    public Vampire() {
        super();
        name = "Vampire";
        type = "Vampire";
        attack = 0;              //1d12
        defense = 3;             //1d6
        armor = 1;
        strength = 18;
    }

    /**
     * Method: attackChar()
     * Usage: obj.attackChar()
     * -------------------------
     * This is a public member method for the Vampire class. This function calculates and returns an
     * attack number for the Vampire object.
     */
    public void attackChar() {
        int die1 = rand.nextInt(11) + 1;                  //Vampire rolls 2x 6 sided die for attack
        int attack = die1;

        System.out.printf("%s attacks with a dice roll of: %d ", getName(), die1);
        System.out.printf("for a total attack of %d!%n", attack);

        setAttackRoll(attack);
    }

    /**
     * Method: defenseChar()
     * Usage: obj.defenseChar()
     * -------------------------
     * This is a public member method for the Vampire class. This function takes an attack number and
     * returns how much damage was done.
     */
    public void defenseChar(int attack) {                 //Special ability charm at 50% chance
        int charm = rand.nextInt(1) + 1;
        if (charm == 1) {
            System.out.printf("%s's special ability, CHARM, has activated and ", getName());
            System.out.printf("the attack has been stopped this round!%n");
        } else {
            int die1 = rand.nextInt(5) + 1;                  //Vampire rolls 1x 6 sided die for defense
            int defense = die1;

            System.out.printf("%s defends with a dice roll of %d", getName(), die1);
            System.out.printf(" for a total defense of %d!%n", defense);

            int damage = attack - defense - getArmor();

            System.out.printf("%d(attack) - %d(defense) - %d(armor)", attack, defense, getArmor());
            System.out.printf(" = %d damage taken %n", damage);

            if (damage <= 0) {
                System.out.printf("%s takes not damage and still has %d strength.%n", getName(), getStrength());
            } else {
                setStrength(getStrength() - damage);
                if (getStrength() > 0) {
                    System.out.printf("%s now has $d strength.%n", getName(), getStrength());
                } else {
                    System.out.printf("%s's strength is DEPLETED!%n", getName());
                }
            }
        }
    }

    /**
     * Method: printCharacteristic()
     * Usage: obj.printCharacteristic()
     * -------------------------
     * This is a public member method for the Vampire class. This function prints out the Vampire
     * characteristics.
     */
    public void printCharacteristic() {
        System.out.printf("Vampire: Suave, debonair, but vicious and surprisingly resilient.%n");
    }
}
