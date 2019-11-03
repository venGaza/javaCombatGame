package Vengaza;

public interface HarryPotterInterface extends CharacterInterface {
    void HarryPotter();                      //Default Constructor

    //Abstract functions from Character class
    void attackChar();                      //Attack Function
    void defenseChar(int defense);          //Defense Function
    void printCharacteristic();             //Print characteristics
}
