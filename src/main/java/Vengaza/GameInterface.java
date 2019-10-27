package Vengaza;

public interface GameInterface {
    // Public Functions
    public void Game();                         //Constructor
    public void Game(int x, int y);             //Overloaded Constructor
    void menu();                                //Game Menu

    // Private Functions
    void validate(int choice, int startRange , int endRange);       //Validates input is in range
    void characterSetup();                      //Controls character creation process
    void characterSelection();                  //User selects characters
    void createCharacterObjects();              //Dynamic creation of characters
    void deleteCharacterObjects();              //Frees memory from characters at end of game
    void battle();                              //Starts the character battle
    void printRound();                          //Prints out current round
    void advanceRound();                        //Advances current round
    void characterOneAttack();                  //Character one attacks character two
    void characterTwoAttack();                  //Character two attacks character one
    void characterOneDefend();                  //Character one defends an attack
    void characterTwoDefend();                  //Character two defends an attack
    void printWinner();                         //Prints out winner of battle
    void pause();                               //Pauses game
}
