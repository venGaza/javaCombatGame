package Vengaza;

/*
 * Class: Barbarian
 * -------------------------
 * This is the implementation for the Barbarian class. This subclass of Character stores the
 * characteristics and special abilities of the Barbarian class.
 */
public class Barbarian extends Character implements BarbarianInterface{
    /*
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

    /*
     * Function: Barbarian::attackChar()
     * Usage: obj.attackChar()
     * -------------------------
     * This is a public member function for the Barbarian class. This function calculates and returns an
     * attack number for the Barbarian object.
     */
    public void attackChar() {
        int die1 = randomNumber(1, 6);                  //Barbarian rolls 2x 6 sided die for attack
        int die2 = randomNumber(1, 6);
        int attack = die1 + die2;

        cout << Character::getName() << " attacks with a dice roll of: " << die1 << " " << die2
                << " for a total attack of " <<  attack << "!" << endl << endl;
        Character::setAttackRoll(attack);
    }

    /*
     * Function: Barbarian::defenseChar()
     * Usage: obj.defenseChar()
     * -------------------------
     * This is a public member function for the Barbarian class. This function takes an attack number and
     * returns how much damage was done.
     */
    public void defenseChar(int attack) {
        int die1 = randomNumber(1, 6);
        int die2 = randomNumber(1, 6);
        int defense = die1 + die2;

        cout << Character::getName() << " defends with a dice roll of: " << die1 << " " << die2
                <<  " for a total defense of " << defense <<  "!" << endl << endl;

        int damage = attack - defense - Character::getArmor();

        if (damage <= 0) {
            cout << attack << "(attack) - " << defense << "(defense) - " << Character::getArmor()
                    << "(armor) = " << damage << " damage taken" << endl << endl;

            cout << Character::getName() << " takes no damage and still has " << Character::getStrength()
                    << " strength."
                    << endl << endl;
        } else {
            cout << attack << "(attack) - " << defense << "(defense) - " << Character::getArmor()
                    << "(armor) = " << damage << " damage taken" << endl << endl;

            Character::setStrength(Character::getStrength() - damage);
            if (Character::getStrength() > 0) {
                cout << Character::getName() << " now has " << Character::getStrength()
                        << " strength." << endl << endl;
            } else {
                cout << Character::getName() << "'s strength is DEPLETED!" << endl << endl;
            }
        }
    }

    /*
     * Function: Barbarian::printCharactersitic()
     * Usage: obj.printCharacteristic()
     * -------------------------
     * This is a public member function for the Barbarian class. This function prints out the Barbarian
     * characteristics.
     */
    public void printCharacteristic() {
        cout << "Barbarian: Think Conan or Hercules from the movies. Big sword, "
                << "big muscles, bare torso." << endl << endl;
    }
}
