//main class file: 1st FILE

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
    

// Game class file entirerly: 2nd FILE

    import java.util.Scanner;
    import java.util.ArrayList;
    import java.io.File;
    import java.util.Random;
    
    class Win{
        int wins = 0;
    }
    class Lose {
        int loses = 0;
    }
    
    
    
    
    class Figures {
    
        public static void figure0() {
            System.out.print ("___");
            System.out.println ("__");
            System.out.print ("\\|  ");
            System.out.println ("|");
            System.out.println(" |");
            System.out.println(" |");
            System.out.println(" |");
            System.out.println(" |");
            System.out.println(" |");
            System.out.println(" |");
            System.out.println(" ---");
            System.out.println("");
            
        }
        public static void figure1() {
            System.out.print ("___");
            System.out.println ("____");
            System.out.print ("\\|   ");
            System.out.println ("|___");
            System.out.println (" |   |__|");
            System.out.println(" |");
            System.out.println(" |");
            System.out.println(" |");
            System.out.println(" |");
            System.out.println(" |");
            System.out.println(" ---");
            System.out.println("");
        }
        public static void figure2() {
            System.out.print ("___");
            System.out.println ("____");
            System.out.print ("\\|  ");
            System.out.println ("|___");
            System.out.println (" |  |__|");
            System.out.println (" |  /");
            System.out.println(" |");
            System.out.println(" |");
            System.out.println(" |");
            System.out.println(" ---");
            System.out.println("");
        }
        public static void figure3() {
            System.out.print ("___");
            System.out.println ("____");
            System.out.print ("\\|  ");
            System.out.println ("|___");
            System.out.println (" |  |__|");
            System.out.println (" |  /  \\");
            System.out.println(" |");
            System.out.println(" |");
            System.out.println(" |");
            System.out.println(" ---");
            System.out.println("");
    }
        public static void figure4() {
            System.out.print ("___");
            System.out.println ("____");
            System.out.print ("\\|  ");
            System.out.println ("|___");
            System.out.println (" |  |__|");
            System.out.println (" |  /||\\");
            System.out.println (" |   ||");
            System.out.println (" |   ");
            System.out.println (" |   ");
            System.out.println (" |   ");
            System.out.println (" ---   ");
            System.out.println("");
        }
        public static void figure5() {
            System.out.print ("___");
            System.out.println ("____");
            System.out.print ("\\|  ");
            System.out.println ("|__");
            System.out.println (" |  |__|");
            System.out.println (" |  /||\\");
            System.out.println (" |   ||");
            System.out.println (" |   /");
            System.out.println (" |  /");
            System.out.println (" |   ");
            System.out.println (" ---   ");
            System.out.println("");
        }
        public static void figure6() {
            System.out.print ("___");
            System.out.println ("____");
            System.out.print ("\\|  ");
            System.out.println ("|__");
            System.out.println (" |  |__|        YOU");
            System.out.println (" |  /||\\        ARE");
            System.out.println (" |   ||         DEAD!");
            System.out.println (" |   /\\         X(");
            System.out.println (" |  /  \\");
            System.out.println (" |");
            System.out.println (" ---   ");
            System.out.println ("");
            System.out.println ("GAME OVER!");
            System.out.println("");
        }
    
    }

// Game class 



    public class Game {

    Win winsCount = new Win ();
    Lose losesCount = new Lose ();


    


//Method to decide which figure we output depending on the number of failures 

    public void ShowFigure(int tries){
        
        switch (tries) {
        case 0:
            Figures.figure0();
            break;
        case 1:
            Figures.figure1();
            break;
        case 2:
            Figures.figure2();
            break;
        case 3:
            Figures.figure3();
            break;
        case 4:
            Figures.figure4();
            break;
        case 5:
            Figures.figure5();
            break;
        case 6:
            Figures.figure6();
            break;
        }   
    }

    
    public void start() throws Exception {
        while (winsCount.wins <= 10 && losesCount.loses <= 5){
          int tries = 0;

        System.out.println("WELCOME TO HANGMAN!");
        System.out.println("");
        System.out.println("");
        System.out.println("Press Enter to start the game...");
        System.out.println("");
        System.out.println("Press 'Exit' to quit the game...");
        System.out.println("");
        System.out.println("");

        Scanner input = new Scanner(System.in);

//Reads words.txt and stores the words in an ArrayList

        File file = new File("words.txt");
            Scanner fileScanner = new Scanner(file);

            ArrayList<String> words = new ArrayList<>();
            while (fileScanner.hasNextLine()) {
                String word = fileScanner.nextLine();
                words.add(word);
            }
        fileScanner.close();

// wait to press enter to start the game 

       String debut = input.nextLine();

// Randomizes the selection of words to get the secretWord 

        Random random = new Random();
        int randomIndex = random.nextInt(words.size());

        String secretWord = words.get(randomIndex);


        if (debut.equalsIgnoreCase("exit")){
            System.out.println("Thanks for playing! Goodbye!");
            return;

            //input.close();
            //System.exit(0);
            // je suis hesitant sur ces 2 lignes 

        }
// THE GAME STARTS HERE

        System.out.println("");
        System.out.println("THE GAME HAS STARTED, GOOD LUCK!");
        System.out.println("");
        System.out.print ("");


//Base case

        //Figures figure = new Figures();
        //figure.figure0();
        //System.out.println("");
        //for (int i = 0; i < secretWord.length(); i++) {
         //   System.out.print("_ ");
        //}
        //System.out.println("");
        //System.out.println("Choose a letter!");

//Player start guessing letters 

        
        char letter;
        ArrayList<Character> guessedLetters = new ArrayList<>();
        char [] guessedWord = new char [secretWord.length()];

//While loop to stay in the game until the man was hanged or the word found 

        while (tries < 6 ){  // !!! CONDITION PAS BONNE. GUESSEDWORD ALREADY SIZE SECRETWORD. JE DOIS CHECK SI CHAQUE CHAR SONT EGAUX A CEUX DE SECRETWORD 

            
                ShowFigure(tries);
                System.out.println("");
                System.out.println("Letters you tried: " + guessedLetters + ", ");
                System.out.println("");
            
                System.out.println("Current word:");
                System.out.println("");

                
//Show the current word to keep on track !!! PROBLEM !!!

            for (int i = 0; i < guessedWord.length; ++i){
                if (guessedWord[i] == secretWord.charAt(i)){
                System.out.print(guessedWord[i]+ " ");
                }
                else {
                    System.out.print("_ ");
                }

            }
            System.out.println("");
            System.out.println("");
            System.out.println("Your try :");
            System.out.println("");


//Checks if the letter imput is valid otherwise, ask again for another one (invalid is wierd input or enter by mistake, I should take out the spaces but flemme)

        while(true){

            String enter = input.nextLine().trim();

            if (enter.length() != 1){
                System.out.println("Please enter a valid letter (a-z or A-Z).");
                continue;
            }
            letter = enter.charAt(0);
            if (letter >= 'a' && letter <= 'z' || letter >= 'A' && letter <= 'Z'){
                break;
            }
            System.out.println("Please enter a valid letter (a-z or A-Z).");
        }

// Check if the letter is already in guessedLetters 


        boolean alreadyTried = false;
    
            for (int i = 0; i < guessedLetters.size() ; ++i){
                
                if(letter == guessedLetters.get(i)){
                    alreadyTried = true;
                    break;
                }
            }
            if (alreadyTried){
            System.out.println("You already chose this letter. Choose an other one.");
            System.out.println("");
            }
            else {
                 guessedLetters.add(letter);
            }

// Check if the letter is in secretWord

    boolean successLetter = false;
    
    System.out.println("");
    
    for (int i = 0; i < secretWord.length(); ++i){
        if (letter == secretWord.charAt(i) || letter == guessedWord[i]){
            System.out.print(letter + " ");
            guessedWord[i] = secretWord.charAt(i);
            successLetter = true;
        }
        else if (letter != secretWord.charAt(i)){
            System.out.print("_ ");
        }
    }
    System.out.println(" ");
    
    
    if (successLetter == true){
        System.out.println ("");
        System.out.println ("");
        System.out.println("Good Choice!!");
        System.out.println ("");
    }
    else {
        ++tries;
        System.out.println ("");
        System.out.println ("");
        System.out.println ("Wrong choice!! Keep Trying!");
        System.out.println ("");
    }

// Win case    

    int winCount = 0;
    
    for (int i = 0; i < guessedWord.length;++i){
                if (guessedWord[i] == secretWord.charAt(i)){
                    ++winCount;
                }
            }
            if (winCount == secretWord.length()){
                for (int i = 0; i < guessedWord.length; ++i){
                    if (guessedWord[i] == secretWord.charAt(i)){
                    System.out.print(guessedWord[i]+ " ");
                    }
                    else {
                        System.out.print("_ ");
                    }
                }
                System.out.println("");
                System.out.println("YOU WON!!! CONGRATULATIONS!!!");
                System.out.println("");
                System.out.println("The secret word was indeed : " + secretWord.toUpperCase());
                System.out.println("");
                System.out.println("");
                ++winsCount.wins ;
                System.out.println("YOU'RE AT " + winsCount.wins + " / 10 WINS");
                System.out.println("");
    
    
                System.out.println("DO YOU WANT TO PLAY AGAIN?");
    
    
                
                if (winsCount.wins == 10){
    
                    System.out.println("");
                    System.out.println("YOU DEFINITLY WON, CONGRATULATIONS... I DIDN'T THINK YOU'D MAKE IT ;)");
                    System.out.println("");
                    System.out.println("BYE MY BIG WINNER !!!");
                    System.out.println("");
                    input.close();
                    return;
                }
                    break;
                
            }
       

//Fail case 

        if (tries == 6){
            ShowFigure(tries);
            System.out.println("The secret word was: " + secretWord.toUpperCase());
            System.out.println("");
            System.out.println("");
            ++losesCount.loses;
            System.out.println("YOU'RE AT " + losesCount.loses + " / 5 LOSES");
            System.out.println("");
            
            if (losesCount.loses == 5){
                System.out.println("");
                System.out.println("YOU DEFINITLY LOST, I KNOW... IT'S NOT THAT EASY HAHA ;)");
                System.out.println("");
                System.out.println("BYE LOSEEEER !!!");
                System.out.println("");
                input.close();
                return;
            }
            break;
        }
    }

}
}


}
