package Vengaza;
import java.util.Random; //Random number generator
import java.lang.Math; //Max
/*
 * Class: BlueMen
 * -------------------------
 * This is the implementation file for the BlueMen class. This subclass of Character stores the
 * characteristics and special abilities of the BlueMen class.
 */
public class BlueMen extends Character implements BlueMenInterface {
    Random rand = new Random();
    //private int defense;
    private int damage;

    /**
     * Method: BlueMen()
     * Usage: BlueMen()
     * -------------------------
     * This is the default constructor for the BlueMen class. This function sets default values for the
     * Barbarian object.
     */
    public BlueMen() {
        super();
        name = "Blue Men";
        type = "Blue Men";
        attack = 2;              //2d10
        defense = 5;             //3d6
        armor = 3;
        strength = 12;
    }

    /**
     * Method: attackChar()
     * Usage: obj.attackChar()
     * -------------------------
     * This is a public member method for the BlueMen class. This function calculates and returns an
     * attack number for the BlueMen object.
     */
    public void attackChar() {
        int die1 = rand.nextInt(9) + 1;                  //Blue Men rolls 2x 10 sided die for attack
        int die2 = rand.nextInt(9) + 1;
        int attack = die1 + die2;

        System.out.printf("Blue men attacks with a dice roll of: %d %d ", die1, die2);
        System.out.printf(" for a total attack of %s!%n", attack);
        setAttackRoll(attack);
    }

    /**
     * Method: defenseChar()
     * Usage: obj.defenseChar()
     * -------------------------
     * This is a public member method for the BlueMen class. This function takes an attack number and
     * returns how much damage was done.
     */
    public void defenseChar(int attack) {
        if (getStrength() > 8) {                 //Mob Level 3 Defense (3 die)
            int die1 = rand.nextInt(5) + 1;
            int die2 = rand.nextInt(5) + 1;
            int die3 = rand.nextInt(5) + 1;
            defense = die1 + die2 + die3;

            System.out.printf("%s (Mob Level: 3) defends with a dice roll of: ", getName());
            System.out.printf("%d %d %d for a total defense of %d!%n", die1, die2, die3, defense);

            printDefenseResult(attack);
        } else if (getStrength() < 4) {          //Mob Level 2 Defense (2 die)
            setDefense(4);

            int die1 = rand.nextInt(5) + 1;
            int die2 = rand.nextInt(5) + 1;
            defense = die1 + die2;

            System.out.printf("%s (Mob Level: 2) defends with a dice roll of: ", getName());
            System.out.printf("%d %d for a total defense of %d!%n", die1, die2, defense);

            printDefenseResult(attack);
        } else {                                            //Mob Level 1 Defense (1 die)
            setDefense(3);

            int die1 = rand.nextInt(5) + 1;
            defense = die1;

            System.out.printf("%s (Mob Level: 1) defends with a dice roll of: ", getName());
            System.out.printf("%d for a total defense of %d!%n", die1, defense);

            printDefenseResult(attack);
        }
    }

    /**
     * Method: printDefenseResult()
     * Usage: obj.printDefenseResult()
     * -------------------------
     * This is a public member method for the BlueMen class. This function prints out the results
     * of the Blue Men defense.
     */
    private void printDefenseResult(int attack) {
        damage = Math.max(0, attack - defense - getArmor());

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
     * This is a public member method for the BlueMen class. This function prints out the BlueMen
     * characteristics.
     */
    public void printCharacteristic() {
        System.out.println("Blue Men: They are small, 6 inch tall, but fast and tough. They are hard to hit so ");
        System.out.println("they can take some damage. They can also do a LOT of damage when they crawl inside ");
        System.out.println("enemies’ armor or clothing, but they lose the ability to defend themselves after ");
        System.out.println("taking damage (lose mob levels). ");
    }
}

