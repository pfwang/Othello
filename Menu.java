import java.util.Scanner;


public class Menu {

	//Declaration of the startMenu() method which gives the user a choice between several different actions
    public static int startMenu()
    {
       String choice;
       int numchoice=0, exit=0;
       Scanner sc = new Scanner (System.in);
       System.out.print("\nWelcome to Othello\n1. New Game\n2. Load Game\n3. Exit Program\n4. Delete Saved Game(s)\n Please enter the integer that represents your choice (1-4): ");
       while (exit == 0){
    	 //Gets the user input of their choice as a string
          choice = sc.nextLine();
          // tries to convert the user input (string) into an integer, and if it's not possible the exception (NumberFormatException) is caught
          try {
             numchoice = Integer.parseInt(choice);
          }
             catch (NumberFormatException e ){
             }
        //Gives exit, the value 1 to break out of the startMenu loop if the user input is correct
          if (numchoice == 1 || numchoice == 2 || numchoice == 3 || numchoice == 4){
             exit = 1;
          }
          //Tells the user they have entered a incorrect choice and to re-enter their choice
          else {
             System.out.print("You did not enter a integer that is between 1-4\n");
             System.out.print("Welcome to the Start Menu\n1. New Game\n2. Load Game\n3. Quite Game\n4. Delete Saved Game(s)\nPlease enter the integer that represents your choice (1-4): ");
          }
       }
       return numchoice;
    }
    
    //Declares the gameMenu() method, this method get user decisions made from the game menu
    public static int gameMenu(){
       String choice;
       int numchoice=0, exit=0;
       Scanner sc = new Scanner (System.in);
       System.out.print("Welcome to the game menu\n1. Save Game\n2. Load Game\n3. Quit Game\n4. Resume Game\n5. New Game\nPlease enter the integer that represents your choice (1-4): ");
       while (exit == 0){
       //Gets the user input of their choice as a string
          choice = sc.nextLine();
       // tries to convert the user input (string) into an integer, and if it's not possible the exception (NumberFormatException) is caught
          try {
             numchoice = Integer.parseInt(choice);
          }
             catch (NumberFormatException e ){
             }
       //Gives exit, the value 1 to break out of the gameMenu loop if the user input is correct
          if (numchoice >= 1 && numchoice <=5){
             exit = 1;
          }
          //Informs the user they have entered a incorrect choice and to re-enter their choice
          else {
             System.out.print("You did not enter an integer that is between 1-5\n Please enter the integer that repersents your choice (1-5): ");
             System.out.print("Welcome to the game menu\n1. Save Game\n2. Load Game\n3. Quit Game\n4. Resume Game\n5. New Game\nPlease enter the integer that represents your choice (1-5): ");
          }
       }
       return numchoice;
    }
   
}
