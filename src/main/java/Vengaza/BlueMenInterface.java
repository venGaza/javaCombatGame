package Vengaza;

public interface BlueMenInterface extends CharacterInterface {
    void BlueMen();                          //Default Constructor

    //Abstract Function implementation
    void attackChar();                      //Attack Function
    void defenseChar(int defense);          //Defense Function
    void printCharacteristic();             //Print characteristics
}
