import java.util.Scanner;


public class GamePlay extends Othello {

	//Declaration of the displayBoard () method which displays the board
    public static void displayBoard (){
    //loop used to display the board
       for (int i = 0; i < numsize [1]+1; i++)
       {
          for (int j = 0; j < numsize [0]+1; j++)
          {
             System.out.print(board [i][j]);
             if (i == 0 && j == numsize[0]){
             //Prints whos turn it is
                if (move == 0){
                   System.out.print ("  It is blacks move");
                }
                else if (move == 1){
                   System.out.print ("  It is whites move");
                }
             }
             if (i == 1 && j == numsize[0]){
             //Prints the points gained/lost 
                System.out.print("  Black total points: "+bpoints+"\tBlack points Gained from move: "+bflankpoints);
             }
             else if (i == 2 && j == numsize[0]){
                System.out.print("  White total points: "+wpoints+"\tWhite points Gained from move: "+wflankpoints);
             }
          }
          System.out.println();
       }
    }
    
  //Declaration of the validMove() method which checks for valid moves
    public static int validMove(){
       String input;
       int already_disk = 0;
       int menu_exit = 0;
       char vertical = ' ', horizontal = ' ' ;
       int exit = 0;
       int menu = 0;
       Scanner sc = new Scanner (System.in);
       System.out.println("Please enter your move(capital letter then lower case letter) or enter M for the menu: ");
       while (exit == 0){
          already_disk = 0;
       //Gets input from the user
          input = sc.nextLine();
          menu = 0;
       //Checks to see if the user input is valid
          try {
             if (input.length() == 2){
                horizontal = input.charAt(0);
                vertical = input.charAt(1);
             }
          }
             catch (StringIndexOutOfBoundsException e){
             }
          intnum = vertical;
          intnum = intnum - 96;
          letternum = horizontal;
          try{
             if (input.equals("M")){
                menu = 1;
                exit = 1;
                menu_exit = 1;
             } 
             //checks to see if the location is valid
             else if ((board [letternum - 65+1] [intnum].equals(" W"))  ||( board [letternum - 65+1] [intnum].equals(" B"))){
                System.out.println("You have not entered a valid move you can not place disks on occupied spaces1");
                already_disk = 1;
             }
          }
             catch (ArrayIndexOutOfBoundsException e){
             }
          if (intnum == numsize [0]){
          //checks to see if the location is valid
             try {
                if ((board [letternum - 65+1+1] [intnum].equals(" W" ))|| (board [letternum - 65+1+1] [intnum-1].equals(" W" ))|| (board [letternum - 65+1] [intnum-1].equals(" W" ))|| (board [letternum - 65] [intnum-1].equals(" W" ))|| (board [letternum - 65] [intnum].equals(" W" ))|| (board [letternum - 65+1+1] [intnum].equals(" B" ))||( board [letternum - 65+1+1] [intnum-1].equals(" B" ))||( board [letternum - 65+1] [intnum-1].equals(" B" ))||( board [letternum - 65] [intnum-1].equals(" B" ))||( board [letternum - 65] [intnum].equals(" B" ))&& already_disk == 0){
                   if (move == 0){
                      board [letternum - 65 + 1] [intnum] = " B"; 
                      bpoints +=1;
                      bflankpoints += 1;
                   }
                   else if (move == 1){
                      board [letternum - 65 + 1] [intnum] = " W"; 
                      wpoints += 1;
                      wflankpoints += 1;
                   }
                   exit = 1;
                }
             }
                catch (ArrayIndexOutOfBoundsException e) {
                //checks to see if the location is valid
                   if ((board [letternum - 65][intnum].equals(" W" ))|| (board [letternum - 65 + 1][intnum - 1].equals(" W" ))||( board [letternum - 65][intnum - 1].equals(" W")) ||( board [letternum - 65][intnum].equals(" B" ))||( board [letternum - 65 + 1][intnum - 1].equals(" B")) ||( board [letternum - 65][intnum - 1] .equals(" B")) && already_disk == 0){
                      if (move == 0){
                         board [letternum - 65 + 1] [intnum] = " B"; 
                         bpoints +=1;
                         bflankpoints += 1;
                      }
                      else if (move == 1){
                         board [letternum - 65 + 1] [intnum] = " W"; 
                         wpoints += 1;
                         wflankpoints += 1;
                      }
                      exit = 1;
                   }
                }
          }
          else if (letternum -64 == numsize [1]){
             try {
             //checks to see if the location is valid
                if ((board [letternum - 65+1] [intnum-1].equals(" W" ))||( board [letternum - 65] [intnum-1].equals(" W" ))||( board [letternum - 65] [intnum].equals(" W" ))|| (board [letternum - 65] [intnum+1].equals(" W" ))||( board [letternum - 65+1] [intnum+1].equals(" W" ))||( board [letternum - 65+1] [intnum-1].equals(" B" ))||( board [letternum - 65] [intnum-1].equals(" B" ))||( board [letternum - 65] [intnum].equals(" B" ))||( board [letternum - 65] [intnum+1] .equals(" B" ))||( board [letternum - 65+1] [intnum+1].equals(" B" ))&& already_disk == 0){
                   if (move == 0){
                      board [letternum - 65 + 1] [intnum] = " B"; 
                      bpoints +=1;
                      bflankpoints += 1;
                   }
                   else if (move == 1){
                      board [letternum - 65 + 1] [intnum] = " W"; 
                      wpoints += 1;
                      wflankpoints += 1;
                   }
                   exit = 1;
                }
             }
                catch (ArrayIndexOutOfBoundsException e){
                }
          }
          else {
          //checks to see if the location is valid
             try{
                if ((board [letternum - 65+1+1] [intnum].equals(" W" )||( board [letternum - 65+1+1] [intnum+1].equals(" W" ))||( board [letternum - 65+1+1] [intnum-1].equals(" W" ))||( board [letternum - 65+1] [intnum-1].equals(" W" ))||( board [letternum - 65] [intnum-1].equals(" W" ))||( board [letternum - 65] [intnum].equals(" W" ))||( board [letternum - 65] [intnum+1].equals(" W" ))||( board [letternum - 65+1] [intnum+1].equals(" W"))||( board [letternum - 65+1+1] [intnum].equals(" B" ))||( board [letternum - 65+1+1] [intnum+1].equals(" B" ))||( board [letternum - 65+1+1] [intnum-1].equals(" B")) ||( board [letternum - 65+1] [intnum-1].equals(" B" ))||( board [letternum - 65] [intnum-1].equals(" B" ))||( board [letternum - 65] [intnum].equals(" B" ))||( board [letternum - 65] [intnum+1].equals(" B" ))||( board [letternum - 65+1] [intnum+1].equals(" B" ))&& already_disk == 0)){
                   if (move == 0 && already_disk == 0){
                      board [letternum - 65 + 1] [intnum] = " B"; 
                      bpoints +=1;
                      bflankpoints += 1;
                   }
                   else if (move == 1 && already_disk == 0){
                      board [letternum - 65 + 1] [intnum] = " W"; 
                      wpoints += 1;
                      wflankpoints += 1;
                   }
                   if (already_disk == 0){
                      exit = 1;
                   }
                }
             }
                catch (ArrayIndexOutOfBoundsException e){
                }
          }
          if (exit == 1 && menu_exit == 0){
             valid = 1;
          }
          else if ((exit != 1 && menu_exit != 1) && already_disk == 0){
             System.out.println("You have not entered a valid move first enter the capital letter then the lower case letter: 2");
             valid = 0;
             menu_exit = 0;
          }
       }
       return menu;
    }
    
  //Declaration of the determinWinner() method which determines who is the winner of the game
    public static void determinWinner (){
    //Checks to see who won
       if (bpoints > wpoints){
          System.out.println("Congratulations Black you are the Winner of the game with a score of "+bpoints+" to "+wpoints+" \n\n");
       }
       else if (wpoints > bpoints){
          System.out.println("Congratulations White you are the Winner of the game with a score of "+wpoints+" to "+bpoints+" \n\n");
       }
       else if (bpoints == wpoints){
          System.out.println("Congratulations Both players you Both are the Winners of the game with a score of "+bpoints+" to "+wpoints+" \n\n");
       }
    
    }
    
    //Declaration of the contGame () method which continues the game after load game
    public static void contGame(){
       int menu, choice;
       Scanner sc = new Scanner (System.in);
    //Get the name the user wants as the auto saved name
       System.out.println("You may now change the name of the game or enter AUTO to have the name of the game to stay the same (this will be the name the auto saved game will be called): ");
       autoname = sc.nextLine();
    
       while (autoname.length() <= 0){
          System.out.println("You have entered a invalid name! Please re-enter the name of the game you wish to continue or enter AUTO to have the name of the game to stay the same (this will be the name the auto saved game will be called): ");
          autoname = sc.nextLine();
       }
       if (autoname.charAt(0) == 'A' && autoname.charAt(1) == 'U' && autoname.charAt(2) == 'T' && autoname.charAt(3) == 'O' && autoname.length() == 4){
          autoname = loadautoname;
       
          autosaveexit = 2;
       }
       if (autosaveexit != 2){ 
          autosaveexit = 0;
       }
       while (autosaveexit == 0){
          autosaveexit = 1;
          first = 0;
          GameIO.autosaveGame();
       //Checks the user input on the name 
          if (autosaveexit == 0){
             System.out.println("The name you have entered is alreadly taken please enter another one (you can delete saved games in the start menu): ");
             autoname = sc.nextLine();
             if (autoname.charAt(0) == 'A' && autoname.charAt(1) == 'U' && autoname.charAt(2) == 'T' && autoname.charAt(3) == 'O' && autoname.length() == 4){
                autoname = loadautoname;
                autosaveexit = 2;
             }
          }
       }
       first = 1;
    
       for (int i = 1; i <= numsize [1] * numsize [0] - gamecount - totalcount + 4 ; i++) {
          GameIO.autosaveGame();
          displayBoard();
          bflankpoints = 0;
          wflankpoints = 0;
       //Gets the user choices and runs the corresponding methods
          menu = validMove();
          if (menu == 1){
             choice = Menu.gameMenu();
             if (choice == 1){
                GameIO.saveGame ();
             }
             else if (choice == 2){
                loadcounter = 1;
                return;
             }
             else if (choice == 3){
                return;
             }
             else if (choice == 5){
                newchoice = 1;
                return;
             }
          }
          else {
          //Runs the outflanking methods
             Flanking.outFlankVert();
             Flanking.outFlankHori();
             Flanking.outFlankDiag();
          }
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
    //Outputs the board and determines the winner
       displayBoard();
       determinWinner();
    }
    
  //Declaration of the Exit() method which exits the program
    public static void Exit (){
       System.out.println("Thank you for playing Othello\nGoodbye and have a nice day!");
    //This exits the java program
       System.exit(0);
    }
}
