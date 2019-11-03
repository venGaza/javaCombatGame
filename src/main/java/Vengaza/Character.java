package Vengaza;

public abstract class Character implements CharacterInterface {
    // Variables
    String name;
    String type;
    int attack;                             //0 = 1d12 , 1 = 2d6 , 2 = 2d10
    int defense;                            //3 = 1d6 , 4 = 2d6 , 5 = 3d6
    int armor;
    int strength;
    private int attackRoll;
    private int defenseRoll;

    /**
     * Method: Character()
     * Usage: Character()
     * -------------------------
     * This is the default constructor for the Character class. This function sets default values for the
     * Character object.
     */
    public Character() {
        name = "Barbarian";
        type = "Barbarian";
        attack = 0;
        defense = 0;
        armor = 0;
        strength = 0;
        attackRoll = 0;
    }

    /**
     * Method: Character(char, int, int, int, int)
     * Usage: Character(char, int, int, int, int)
     * -------------------------
     * This is the overloaded constructor for the Character class. This function takes 5 parameters to
     * set the traits of the character object.
     */
    public Character(String name, String type, int attack, int defense, int armor, int strength) {
        this.name = name;
        this.type = type;
        this.attack = attack;
        this.defense = defense;
        this.armor = armor;
        this.strength = strength;
    }

    /**
     * Method: getName()
     * Usage: obj.getName()
     * -------------------------
     * This is a public member function of the Character class. This function returns the object name.
     */
    public String getName() {
        return name;
    }

    /**
     * Method: getType()
     * Usage: obj.getType()
     * -------------------------
     * This is a public member function of the Character class. This function returns the object type.
     */
    public String getType() {
        return type;
    }

    /**
     * Method: getAttack()
     * Usage: obj.getAttack()
     * -------------------------
     * This is a public member function of the Character class. This function returns the object attack
     * type int: 0 = 1d12 , 1 = 2d6 , 2 = 2d10 (eg 2x 10 sided die).
     */
    public int getAttack() {
        return attack;
    }

    /**
     * Method: getDefense()
     * Usage: obj.getDefense()
     * -------------------------
     * This is a public member function of the Character class. This function returns the object attack
     * type int: 0 = 1d6 , 1 = 2d6 , 2 = 3d6 (eg 3x 6 sided die).
     */
    public int getDefense() {
        return defense;
    }

    /**
     * Method: int Character::getArmor()
     * Usage: obj.getArmor()
     * -------------------------
     * This is a public member function of the Character class. This function returns the object armor
     * number.
     */
    public int getArmor() {
        return armor;
    }

    /**
     * Method: int Character::getStrength()
     * Usage: obj.getStrength()
     * -------------------------
     * This is a public member function of the Character class. This function returns the object strength
     * number.
     */
    public int getStrength() {
        return strength;
    }

    public int getAttackRoll() {
        return attackRoll;
    }

    public int getDefenseRoll() {
        return defenseRoll;
    }

    /**
     * Method: setName()
     * Usage: obj.setName("string")
     * -------------------------
     * This is a public member function of the Character class. This function sets the object name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Method: setType()
     * Usage: obj.setType('char')
     * -------------------------
     * This is a public member function of the Character class. This function sets the object type.
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Method: setAttack(int attack)
     * Usage: obj.setAttack(int)
     * -------------------------
     * This is a public member function of the Character class. This function sets the object attack.
     */
    public void setAttack(int attack) {
        this.attack = attack;
    }

    /**
     * Method: setDefense(int defense)
     * Usage: obj.setDefense(int)
     * -------------------------
     * This is a public member function of the Character class. This function sets the object defense.
     */
    public void setDefense(int defense) {
        this.defense = defense;
    }

    /**
     * Method: setArmor(int armor)
     * Usage: obj.setArmor(int)
     * -------------------------
     * This is a public member function of the Character class. This function sets the object armor.
     */
    public void setArmor(int armor) {
        this.armor = armor;
    }

    /**
     * Method: setStrength(int strength)
     * Usage: obj.setStrength(int)
     * -------------------------
     * This is a public member function of the Character class. This function sets the object strength.
     */
    public void setStrength(int strength) {
        this.strength = strength;
    }

    public void setAttackRoll(int attackRoll) {
        this.attackRoll = attackRoll;
    }

    public void setDefenseRoll(int defenseRoll) {
        this.defenseRoll = defenseRoll;
    }

}
