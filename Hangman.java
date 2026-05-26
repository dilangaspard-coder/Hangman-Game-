import java.util.Scanner;

public class Hangman {
    
    public static void main(String[] args) throws Exception {

    Scanner input = new Scanner ("Exit");

//Start game

        Game game = new Game();
        game.start();
//If want to exit at the biginning 

        if (input.nextLine().equalsIgnoreCase ("Exit")){
                System.exit(0);
            }

        

    }
}


// To compile  : javac src/Hangman.java src/Game.java
// To run : java -cp src Hangman