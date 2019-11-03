package Vengaza;

public interface VampireInterface extends CharacterInterface {
    //Abstract Functions from Character being implemented
    void attackChar();                      //Attack Function
    void defenseChar(int defense);          //Defense Function
    void printCharacteristic();             //Print characteristics
}
