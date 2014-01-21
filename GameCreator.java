import java.util.Scanner;


public class GameCreator extends Othello {
	
	//Declaration of the newGame() method which creates and runs a new game for the users to play
    public static void newGame(){
    //Declaration of local variables
       int menu, choice;
       bpoints = 2;
       wpoints = 2;
       Scanner sc = new Scanner (System.in);
       System.out.println("Please enter the name of the game you wish to create (this will be the name the auto saved game will be called): ");
    //Gets the name of the auto saved game that the user wants
       autoname = sc.nextLine();
    //Calls the method initBoardsize() which asks the user for the size of the board
       initBoardsize();
       autosaveexit = 0;
    //Runs a loop for the autosave to start running
       while (autosaveexit == 0){
          autosaveexit = 1;
          first = 0;
       //Runs the method autosaveGame() which auto saves the game after both players have gone
          GameIO.autosaveGame();
       //Asks the user to re-enter the name, because the name is taken
          if (autosaveexit == 0){
             System.out.println("The name you have entered is alreadly taken please enter another one (you can delete auto saved games in the start menu): ");
             autoname = sc.nextLine();
             initBoardsize();
          }
       }
       first = 1;
       board = new String [numsize[1]+1][numsize[0]+1];
    //Calls the method initBoard() which creats the game board
       initBoard();
    //The counted loop that is the number of turns the users can go before the game ends
       for (int i = 1; i <= numsize [1] * numsize [0] - gamecount; i++) {
       //Runs the method autosaveGame() which auto saves the game after both players have gone
          GameIO.autosaveGame();
       //Runs the displayBoard() method which displays the game board for the users
          GamePlay.displayBoard();
          bflankpoints = 0;
          wflankpoints = 0;
       //Gets the result from the method validMove()
          menu = GamePlay.validMove();
       //Checks if the user wants to enter the game menu 
          if (menu == 1){
             choice = Menu.gameMenu();
          //Checks if the user wants to save the game 
             if (choice == 1){
                GameIO.saveGame ();
             }
             else if (choice == 2){
                loadcounter = 1;
                return;
             }
             //This exits the method and goes back to the start menu
             else if (choice == 3){
                return;
             }
             else if (choice == 5){
                newchoice = 1;
                return;
             }
          }
          //Runs the outflanking methods
          else {
             Flanking.outFlankVert();
             Flanking.outFlankHori();
             Flanking.outFlankDiag();
          }
       //counters to check who's turn it is
          if (move == 0 && valid == 1){
             move = 1;
          }
          else if (move == 1 && valid == 1){
             move = 0;
          }
          if (valid == 0){
             i -= 1;
          }
          valid = 0;
       }
       GamePlay.displayBoard();
    //Runs the method determinWinner() to check for the winner
       GamePlay.determinWinner();
    }
    
  //Declaration of the initBoardsize() which asks the user for the size of the game board
    public static void initBoardsize(){
       String [] size = new String [2];
       int check = 0;
       Scanner sc = new Scanner (System.in);
       while (check == 0){
          System.out.print("Please enter the length of sides of the board (An integer below 27 and above 2): ");
       //The user enters the size of the game board
          size[0]=sc.nextLine();
       //Checks to see if the size the user entered is valid
          try {
             if (Integer.parseInt(size[0])>2 && Integer.parseInt(size[0])<=26)
             {
                numsize[0] = Integer.parseInt(size[0]);
                numsize[1] = numsize[0];
                check = 1; 
             }
             else {
                System.out.println("Error you have not entered an integer below 27 and above 2");
             }
          }
             catch (NumberFormatException e){ 
                System.out.println("Error you have not entered an integer below 27 and above 2");
             }
       }
       System.out.println();
    } 
    
  //Declaration of the initBoard() method which creats the game board for a new game
    public static void initBoard (){
       int charcount = 64;
       int lowcharcount = 96;
       String [] sboard = {" "," ."};
       char character;
    //Gives the array board the different string values to make it the game board
       for (int i = 0; i < numsize [1]+1; i++){
          for (int j = 0; j < numsize [0]+1; j++){
             if (i == 0 && j != 0 && j != 1 || i == 0 && j == 1){
                board [i][j] = " " + (char)(lowcharcount);
             }
             else if (j==0 && i != 0){
                character = (char)charcount;
                board [i][j] = Character.toString(character);
             }
             else if (i == 0 && j == 0){
                board [i][j] = " ";
             }
             else if ((i == numsize [1]/2 && j == numsize [0]/2 )|| (i == numsize [1]/2+1 && j == numsize [0]/2+1)){
                board [i][j] = " W";
             }  
             else if ((i == numsize [1]/2+1 && j == numsize [0]/2 )||( i== numsize [1]/2 && j == numsize [0]/2+1)){
                board [i][j] = " B";
             } 
             else {
                board [i][j] = " .";
             }
             lowcharcount += 1;
          }
          charcount += 1;
       }
    }
}
