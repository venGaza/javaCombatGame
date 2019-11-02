package Vengaza;

public interface CharacterInterface {
    //Constructors
    public void Character();
    public void Character(String name, String type, int attack, int defense, int armor, int strength);

    //Getters
    String getName();
    String getType();
    int getAttack();
    int getDefense();
    int getArmor();
    int getStrength();
    int getAttackRoll();
    int getDefenseRoll();

    //Setters
    void setName(String name);
    void setType(String type);
    void setAttack(int attack);
    void setDefense(int defense);
    void setArmor(int armor);
    void setStrength(int strength);
    void setAttackRoll(int attackRoll);
    void setDefenseRoll(int defenseRoll);

    //Abstract Methods
    abstract void attackChar();           //Attack function
    abstract void defenseChar(int d);       //Defense function
    abstract void printCharacteristic();  //Prints character description
}
