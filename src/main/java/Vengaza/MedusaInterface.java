package Vengaza;

public interface MedusaInterface extends CharacterInterface {
    void Medusa();                           //Default Constructor

    //Abstract function implementation
    void attackChar();                      //Attack Function
    void defenseChar(int defense);          //Defense Function
    void printCharacteristic();             //Print characteristics
}
