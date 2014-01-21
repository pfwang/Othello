import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class GameIO extends Othello{
	
	//Declaration of the autosaveGame() method for auto saving the game every time both player have made a move 
    public static void autosaveGame(){
       try{
       //Sets values for files
          File file = new File ("autosavedgames.txt");
          File autofile = new File (autoname+"-auto.txt");
          if (!file.exists()){
             file.createNewFile();
          }
       //Calls a BufferedReader for reading text documents
          BufferedReader read = new BufferedReader (new FileReader ("autosavedgames.txt"));
          int count = 0;
          String input;
       //Creats array/arraylists 
          ArrayList <String> autosavednamesL = new ArrayList <String> ();
          Object [] autosavednamesO;
          String [] autosavednames;
       
          if(first == 0){
          
             boolean exists = autofile.exists();
          //Gets the names of the auto saved games 
             if (exists == false){
                autofile.createNewFile();
                while ((input = read.readLine()) != null){
                   autosavednamesL.add(input);
                   count += 1;
                }
             
                autosavednamesO = new Object [autosavednamesL.size()];
                autosavednamesO = autosavednamesL.toArray();
                autosavednames = new String [autosavednamesL.size()];
             
                for (int i = 0; i < count; i++){
                   autosavednames [i] = autosavednamesO[i].toString();
                }
             //Deletes and recreats the file, because the file is set to Read Only.
                file.delete();
                file.createNewFile();
             //Write changes to the list of auto saved names
                BufferedWriter write = new BufferedWriter (new FileWriter("autosavedgames.txt"));
                for (int i = 0; i < count; i++){
                   write.write(autosavednames [i]);
                   write.newLine();
                }
                write.write(autoname+"-auto");
                write.close();
                autosaveexit = 1;
             }
             else {
                autosaveexit = 0;
             }
          }
       
       
          if (move == 0 && first != 0 && autosaveexit == 1){
             autofile.delete();
             autofile.createNewFile();
          //Writes to the newly created text file the game board
             BufferedWriter write2 = new BufferedWriter (new FileWriter(autoname+"-auto.txt"));
             for (int j = 0; j < board.length; j++){
                for (int i = 0; i < board[0].length; i++){
                   write2.write(board[j][i]);
                }
                write2.newLine();
             }
             write2.close();
          } 
       //Sets the files Read Only so they cannot be change
          file.setReadOnly();
          autofile.setReadOnly();
       }
          catch (IOException e){
          
          }
    
    
    }
 //Declaration of the saveGame () method which allows the user to save the game
    public static void saveGame (){
       boolean exists;
       int exit = 0;
       int count = 0;
       String input;
       ArrayList <String> savednamesL = new ArrayList <String> ();
       Object [] savednamesO;
       String [] savednames;
    
       Scanner sc = new Scanner (System.in);
    
       File file = new File ("savedgames.txt");
    
    //asks the user for the name of the game the wish to save as
       System.out.println("Please enter the name of the game you wish to save or enter R (capital) to return to the game or enter AUTO (capital) for the name of the saved game to be the same as the name of the game: ");
       filename = sc.nextLine();
       if (filename.equalsIgnoreCase("R")){
          return;
       }
       else if (filename.charAt(0) == 'A' && filename.charAt(1) == 'U' && filename.charAt(2) == 'T' && filename.charAt(3) == 'O' && filename.length() == 4){
          filename = autoname;
       }
    
       File savefile = new File (filename + ".txt");
    //Checks for the existence of the file
       exists = savefile.exists();
       while (exit != 1){
          if(exists == true){
             System.out.println("There is already a saved game with that name or you have entered an invalid name.\n Please enter another name for the game you wish to save or enter R (capital) to return to the game or enter AUTO (capital) for the name of the saved game to be the same as the name of the game: ");
             filename = sc.nextLine();
             if (filename.equalsIgnoreCase("R")){
                return;
             }
             if (filename.charAt(0) == 'A' && filename.charAt(1) == 'U' && filename.charAt(2) == 'T' && filename.charAt(3) == 'O' && filename.length() == 4){
                filename = autoname;
             }
          
             File savefileexit = new File (filename + ".txt");
             exists = savefileexit.exists();
          }
          else  {
             exit = 1;
          }
       }
    
       if (filename.equals("M") == false){
       
       
          try {

             if (exists == false){
                file.createNewFile();
             }
          //Reads the list of saved games
             BufferedReader read = new BufferedReader (new FileReader ("savedgames.txt"));
             while ((input = read.readLine()) != null){
                savednamesL.add(input);
                count += 1;
             }
          
             savednamesO = new Object [savednamesL.size()];
             savednamesO = savednamesL.toArray();
             savednames = new String [savednamesL.size()];
          
             for (int i = 0; i < count; i++){
                savednames [i] = savednamesO[i].toString();
             }
          //Deletes the file and recreats it so it can be written to
             file.delete();
             file.createNewFile();
          //Writes the changes to the file
             BufferedWriter write = new BufferedWriter (new FileWriter("savedgames.txt"));
             for (int i = 0; i < count; i++){
                write.write(savednames [i]);
                write.newLine();
             }
             write.write(filename);
             write.close();
          //Writes the game board to a text file
             BufferedWriter write2 = new BufferedWriter (new FileWriter (filename + ".txt"));
          
             for (int i = 0; i < board.length; i++){
                for (int j = 0; j < board[0].length; j++){
                   write2.write(board[i][j]);
                }
                write2.newLine();
             }
             write2.close();
          
             file.setReadOnly();
             savefile.setReadOnly();
          }
          
             catch (IOException e){
                System.out.println("Error");
             }
       }
    }
 
 
 
 //Declaration of the loadGame() method that allows the user to load a game
    public static void loadGame (){
    //Declaration of variables
       String input = "";
       String userinput = "";
       int exit = 0;
       int auto = 0;
       int error;
       int numchoice = 0;
       totalcount = 0;
       bpoints = 0;
       wpoints = 0;
       load = 1;
    //Declaration of arrays/arraylists
       ArrayList <String> savedgamenamesL = new ArrayList <String> ();
       Object [] savedgamenamesO;
       String [] savedgamenames; 
       ArrayList <String> gameboardL = new ArrayList <String> ();
       Object [] gameboardO;
       String [] gameboard;
       int count = 0;
       int addcount = 1;
       int addcount2 = 1;
       Scanner sc = new Scanner (System.in);
    //Asks the user for the selection of saved games to load
       System.out.println("Please choose which group of saved games is the game you wish to load located\n1. Most Recent Auto Saved Game\n2. Most Recent Normally Saved Game\n3. A Normally Saved Game\n4. A Auto Saved Game\nPlease enter the integer that represents your choice (1-4): ");
       input = sc.nextLine();
    //Checks the input so see if its valid
       try{
          numchoice = Integer.parseInt(input);
       }
          catch (NumberFormatException e){
          }
       if (numchoice > 0 && numchoice < 5){
          exit = 1;
       }
       while (exit == 0){
          System.out.println("You have entered an invalid choice!\nPlease choose in which group of saved games is the game you wish to load located\n1. Most Recent Auto Saved Game\n2. Most Recent Normally Saved Game\n3. A Normally Saved Game\n4. A Auto Saved Game\nPlease enter the integer that represents your choice (1-4): ");
          input = sc.nextLine();
          try{
             numchoice = Integer.parseInt(input);
          }
             catch (NumberFormatException e){
             }
          if (numchoice > 0 && numchoice < 5){
             exit = 1;
          }
       }
    
       if (numchoice == 1){
          int count1 = 0;
       //Reads the auto saved names
          try{
             BufferedReader rautoread = new BufferedReader (new FileReader ("autosavedgames.txt"));
          
             while ((input = rautoread.readLine()) != null){
                savedgamenamesL.add(input);
             }
             if (savedgamenamesL.size() == 0){
                System.out.println("No auto-saved games exisits!");
                return;
             }
             savedgamenamesO = new Object [savedgamenamesL.size()];
             savedgamenamesO = savedgamenamesL.toArray();
             savedgamenames = new String [savedgamenamesO.length];
             for (int i = 0; i < savedgamenames.length; i++){
                savedgamenames [i] = savedgamenamesO [i].toString();
             }
             for (int i = 0; i < savedgamenames.length - 1; i++){
                File rautofile = new File (savedgamenames [auto]+".txt");
                File rautofile2 = new File (savedgamenames [i+1]+".txt");
                if (rautofile.lastModified() < rautofile2.lastModified()){
                   auto = i+1;
                }
             }
             loadautoname = savedgamenames[auto];
             BufferedReader rautogameread = new BufferedReader (new FileReader (savedgamenames[auto]+".txt"));
          //Reads in the game board and gives the array Board [][] its values.
             while ((input = rautogameread.readLine()) != null){
                gameboardL.add(input); 
             }
             gameboardO = new Object [gameboardL.size()];
             gameboard = new String [gameboardO.length];
             gameboardO = gameboardL.toArray();
          //Reads in the game board and gives the array Board [][] its values.
             for (int i = 0; i < gameboardO.length; i++){
                gameboard [i] = gameboardO [i].toString();
             }
             board = new String [gameboard.length] [gameboard.length];
             for (int i = 0; i < gameboardO.length - 1; i++){
                if (gameboard [i].length() != gameboard [i+1].length()){
                   error = 1;
                }
             }
             for (int j = 0; j < gameboard.length; j++){
                addcount = 1;
                for( int i = 0; i < gameboard.length; i++){
                   if (i != 0){
                      addcount2 = addcount + 2;
                   }
                   if (i == 0 && j != 0){
                      board [j][i] = gameboard [j].substring(0,1);
                   }
                   else if (j == 0&& i ==0){
                      board [j][i] = " ";
                   }
                   //Reads in the game board and gives the array Board [][] its values.
                   else  if (i < gameboard[j].length()){
                      board [j][i] = gameboard [j].substring(addcount,addcount2);
                   //Gives the points and tells the program whos turn it is
                      if (board [j][i].charAt(0)== ' ' && board [j][i].charAt(1)== 'W'){
                         wpoints ++;
                         totalcount ++;
                      }
                      else if (board [j][i].charAt(0)== ' ' && board [j][i].charAt(1)== 'B'){
                         bpoints ++;
                         totalcount++;
                      }
                   } 
                   if (i != 0){
                      addcount = addcount2;
                   }
                }
             }
             numsize [0] = board.length - 1;
             numsize [1] = board.length - 1;
             if (totalcount % 2 == 0){
                move = 0;
             }
             else {
                move = 1;
             }
             rautogameread.close();
          }
             catch (IOException e){
             }
       }
       
       else if (numchoice == 2){
          int count1 = 0;
       //Reads the auto saved names
          try{
             BufferedReader rautoread = new BufferedReader (new FileReader ("savedgames.txt"));
          
             while ((input = rautoread.readLine()) != null){
                savedgamenamesL.add(input);
             }
             if (savedgamenamesL.size() == 0){
                System.out.println("No saved games exisits!");
                return;
             }
             savedgamenamesO = new Object [savedgamenamesL.size()];
             savedgamenamesO = savedgamenamesL.toArray();
             savedgamenames = new String [savedgamenamesO.length];
             for (int i = 0; i < savedgamenames.length; i++){
                savedgamenames [i] = savedgamenamesO [i].toString();
             }
             for (int i = 0; i < savedgamenames.length - 1; i++){
                File rautofile = new File (savedgamenames [auto]+".txt");
                File rautofile2 = new File (savedgamenames [i+1]+".txt");
                if (rautofile.lastModified() > rautofile2.lastModified()){
                   auto = i+1;
                }
             }
          //Reads in the game board and gives the array Board [][] its values.
             loadautoname = savedgamenames[auto];
             BufferedReader autogameread = new BufferedReader (new FileReader (loadautoname+".txt"));
             while ((input = autogameread.readLine()) != null){
                gameboardL.add(input); 
             }
             gameboardO = new Object [gameboardL.size()];
             gameboard = new String [gameboardO.length];
             gameboardO = gameboardL.toArray();
          
             for (int i = 0; i < gameboardO.length; i++){
                gameboard [i] = gameboardO [i].toString();
             }
          //Reads in the game board and gives the array Board [][] its values.
             board = new String [gameboard.length] [gameboard.length];
             for (int i = 0; i < gameboardO.length - 1; i++){
                if (gameboard [i].length() != gameboard [i+1].length()){
                   error = 1;
                }
             }
             for (int j = 0; j < gameboard.length; j++){
                addcount = 1;
                for( int i = 0; i < gameboard.length; i++){
                   if (i != 0){
                      addcount2 = addcount + 2;
                   }
                //Reads in the game board and gives the array Board [][] its values.
                   if (i == 0 && j != 0){
                      board [j][i] = gameboard [j].substring(0,1);
                   }
                   else if (j == 0&& i ==0){
                      board [j][i] = " ";
                   }
                   else  if (i < gameboard[j].length()){
                      board [j][i] = gameboard [j].substring(addcount,addcount2);
                      if (board [j][i].charAt(0)== ' ' && board [j][i].charAt(1)== 'W'){
                         wpoints ++;
                         totalcount ++;
                      }
                      else if (board [j][i].charAt(0)== ' ' && board [j][i].charAt(1)== 'B'){
                         bpoints ++;
                         totalcount++;
                      }
                   } 
                   if (i != 0){
                      addcount = addcount2;
                   }
                }
             }
             numsize [0] = board.length - 1;
             numsize [1] = board.length - 1;
             if (totalcount % 2 == 0){
                move = 0;
             }
             else {
                move = 1;
             }
             autogameread.close();
             rautoread.close();
          }
             catch (IOException e){
             }
       }
       
       else if (numchoice == 3){
          try{
          //Get the saved game names
             BufferedReader read = new BufferedReader (new FileReader ("savedgames.txt"));
             System.out.println("Please enter the number corresponding to the name of the saved game you wish to enter or the name of the saved game or enter M (capital) for the menue");
          
             while ((input = read.readLine()) != null){
                System.out.println(count+1+". "+input);
                savedgamenamesL.add(input);
                count += 1;
             }
             savedgamenamesO = new Object [savedgamenamesL.size()];
             savedgamenamesO = savedgamenamesL.toArray();
             savedgamenames = new String [savedgamenamesO.length];
             for (int i = 0; i < savedgamenames.length; i++){
                savedgamenames [i] = savedgamenamesO [i].toString();
             }
             exit = 0;
             while (exit == 0){
             //Gets user input for which game to load
                userinput = sc.nextLine();
             //Checks the user input to see if its valid
                try{
                   numchoice = Integer.parseInt(userinput);
                   if (numchoice <= count){
                      userinput = savedgamenames [numchoice - 1];
                      exit = 1;
                   }
                }
                   catch (NumberFormatException e){
                   }
                try {
                   if (userinput.charAt(0) == 'M' && userinput.length() == 1){
                      return;
                   }
                }
                   catch (StringIndexOutOfBoundsException e){
                   }
                if (exit != 1){
                   for (int i = 0; i < count; i++){
                      if (userinput.equals(savedgamenames [i])){
                         exit = 1;
                      }
                   }
                }
                else if (exit != 1){
                   System.out.println("You have entered an invalid choice, enter the number repersenting the save game or enter the name of the save game or enter M (capital) for the menu");
                }
             }
          //Reads in the game board and gives the array Board [][] its values.
             BufferedReader read2 = new BufferedReader (new FileReader (userinput+".txt"));
             while ((input = read2.readLine()) != null){
                gameboardL.add(input); 
             }
             gameboardO = new Object [gameboardL.size()];
             gameboard = new String [gameboardO.length];
             gameboardO = gameboardL.toArray();
          
             for (int i = 0; i < gameboardO.length; i++){
                gameboard [i] = gameboardO [i].toString();
             }
          
             for (int i = 0; i < gameboardO.length - 1; i++){
                if (gameboard [i].length() != gameboard [i+1].length()){
                   error = 1;
                }
             }
          //Reads in the game board and gives the array Board [][] its values.
             board = new String [gameboard.length][gameboard.length];
             for (int j = 0; j < gameboard.length; j++){
                addcount = 1;
                for( int i = 0; i < gameboard.length; i++){
                   if (i != 0){
                      addcount2 = addcount + 2;
                   }
                   if (i == 0 && j != 0){
                      board [j][i] = gameboard [j].substring(0,1);
                   }
                   else if (j == 0&& i ==0){
                      board [j][i] = " ";
                   }
                   //Reads in the game board and gives the array Board [][] its values.
                   else  if (i < gameboard[j].length()){
                      board [j][i] = gameboard [j].substring(addcount,addcount2);
                      if (board [j][i].charAt(0)== ' ' && board [j][i].charAt(1)== 'W'){
                         wpoints ++;
                         totalcount ++;
                      }
                      else if (board [j][i].charAt(0)== ' ' && board [j][i].charAt(1)== 'B'){
                         bpoints ++;
                         totalcount++;
                      }
                   } 
                   if (i != 0){
                      addcount = addcount2;
                   }
                }
             }
             numsize [0] = board.length - 1;
             numsize [1] = board.length - 1;
             if (totalcount % 2 == 0){
                move = 0;
             }
             else {
                move = 1;
             }
          
          }
             catch (IOException e){
             }
       }
       
       
       else if (numchoice == 4){
          try{
          //Reads in the saved game names
             BufferedReader read = new BufferedReader (new FileReader ("autosavedgames.txt"));
             System.out.println("Please enter the number corresponding to the name of the saved game you wish to enter or the name of the saved game or enter M (capital) for the menue");
          
             while ((input = read.readLine()) != null){
                System.out.println(count+1+". "+input);
                savedgamenamesL.add(input);
                count += 1;
             }
             savedgamenamesO = new Object [savedgamenamesL.size()];
             savedgamenamesO = savedgamenamesL.toArray();
             savedgamenames = new String [savedgamenamesO.length];
             for (int i = 0; i < savedgamenames.length; i++){
                savedgamenames [i] = savedgamenamesO [i].toString();
             }
             exit = 0;
             while (exit == 0){
             //Gets the user input
                userinput = sc.nextLine();
             //Checks the user input to see if its correct
                try{
                   numchoice = Integer.parseInt(userinput);
                   if (numchoice <= count){
                      userinput = savedgamenames [numchoice - 1];
                      exit = 1;
                   }
                }
                   catch (NumberFormatException e){
                   }
             
                if (userinput.charAt(0) == 'M' && userinput.length() == 1){
                   return;
                }
                else if (exit != 1){
                   for (int i = 0; i < count; i++){
                      if (userinput.equals(savedgamenames [i])){
                         exit = 1;
                      }
                   }
                }
                else if (exit != 1){
                   System.out.println("You have entered an invalid choice, enter the number repersenting the save game or enter the name of the save game or enter M (capital) for the menu");
                }
             }
          //Reads in the game board and gives the array Board [][] its values.
             BufferedReader read2 = new BufferedReader (new FileReader (userinput+".txt"));
             while ((input = read2.readLine()) != null){
                gameboardL.add(input); 
             }
             gameboardO = new Object [gameboardL.size()];
             gameboard = new String [gameboardO.length];
             gameboardO = gameboardL.toArray();
          
             for (int i = 0; i < gameboardO.length; i++){
                gameboard [i] = gameboardO [i].toString();
             }
          //Reads in the game board and gives the array Board [][] its values.
             for (int i = 0; i < gameboardO.length - 1; i++){
                if (gameboard [i].length() != gameboard [i+1].length()){
                   error = 1;
                }
             }
             board = new String [gameboard.length][gameboard.length];
             for (int j = 0; j < gameboard.length; j++){
                addcount = 1;
                for( int i = 0; i < gameboard.length; i++){
                   if (i != 0){
                      addcount2 = addcount + 2;
                   }
                   if (i == 0 && j != 0){
                      board [j][i] = gameboard [j].substring(0,1);
                   }
                   else if (j == 0&& i ==0){
                      board [j][i] = " ";
                   }
                   //Reads in the game board and gives the array Board [][] its values.
                   else  if (i < gameboard[j].length()){
                      board [j][i] = gameboard [j].substring(addcount,addcount2);
                      if (board [j][i].charAt(0)== ' ' && board [j][i].charAt(1)== 'W'){
                         wpoints ++;
                         totalcount ++;
                      }
                      else if (board [j][i].charAt(0)== ' ' && board [j][i].charAt(1)== 'B'){
                         bpoints ++;
                         totalcount++;
                      }
                   } 
                   if (i != 0){
                      addcount = addcount2;
                   }
                }
             }
             numsize [0] = board.length - 1;
             numsize [1] = board.length - 1;
             if (totalcount % 2 == 0){
                move = 0;
             }
             else {
                move = 1;
             }
          read.close();
          read2.close();
          
          }
             catch (IOException e){
             }
       }
       
    }

 
 
 //Declaration of the deletsaveGame() method which delets saved games
    public static void deletsaveGame(){
       String input = "";
       String userinput = "";
       int exit = 0;
       int auto = 0;
       int error;
       int numchoice = 0;
    
       ArrayList <String> savedgamenamesL = new ArrayList <String> ();
       Object [] savedgamenamesO;
       String [] savedgamenames; 
    
       int count = 0;
       int addcount = 1;
       int addcount2 = 1;
       Scanner sc = new Scanner (System.in);
    //Asks for the section the saved game is located
       System.out.println("Please choice in which group of saved games is the game you wish to delete located\n1. Most Recent Auto Saved Game\n2. Most Recent Normally Saved Game\n3. A Normally Saved Game\n4. A Auto Saved Game\nPlease enter the integer that represents your choice (1-4): ");
       input = sc.nextLine();
    //Validates the user input
       try{
          numchoice = Integer.parseInt(input);
       }
          catch (NumberFormatException e){
          }
       if (numchoice > 0 && numchoice < 5){
          exit = 1;
       }
       while (exit == 0){
          System.out.println("You have entered an invalid choice!\nPlease choice in which group of saved games is the game you wish to load located\n1. Most Recent Auto Saved Game\n2. Most Recent Normally Saved Game\n3. A Normally Saved Game\n4. A Auto Saved Game\nPlease enter the integer that represents your choice (1-4): ");
          input = sc.nextLine();
          try{
             numchoice = Integer.parseInt(input);
          }
             catch (NumberFormatException e){
             }
       }
    
       if (numchoice == 1){
          int count1 = 0;
       //Reads in names of saved games
          try{
             BufferedReader rautoread = new BufferedReader (new FileReader ("autosavedgames.txt"));
          
             while ((input = rautoread.readLine()) != null){
                savedgamenamesL.add(input);
             }
             if (savedgamenamesL.size() == 0){
                System.out.println("No auto saved game exisits!");
                return;
             }
             savedgamenamesO = new Object [savedgamenamesL.size()];
             savedgamenamesO = savedgamenamesL.toArray();
             savedgamenames = new String [savedgamenamesO.length];
             for (int i = 0; i < savedgamenames.length; i++){
                savedgamenames [i] = savedgamenamesO [i].toString();
             }
             for (int i = 0; i < savedgamenames.length - 1; i++){
                File rautofile = new File (savedgamenames [auto]+".txt");
                File rautofile2 = new File (savedgamenames [i+1]+".txt");
                if (rautofile.lastModified() < rautofile2.lastModified()){
                   auto = i+1;
                }
             }
             loadautoname = savedgamenames[auto];
          //deletes the file to rewrite to it
             File file = new File ("autosavedgames.txt");
             File deletefile = new File (loadautoname + ".txt");
          
             file.delete();
             file.createNewFile();
             BufferedWriter write = new BufferedWriter (new FileWriter("autosavedgames.txt"));
             for (int i = 0; i < savedgamenames.length; i++){
                if (i != auto){
                   write.write(savedgamenames [i]);
                   write.newLine();
                }
             }
             write.close();
          //Deletes the file
             deletefile.delete();
             file.setReadOnly();
          }
             catch (IOException e){
             }
       
       }
    
    
       if (numchoice == 2){
          int count1 = 0;
       //Reads in the saved game names
          try{
             BufferedReader rautoread = new BufferedReader (new FileReader ("savedgames.txt"));
          
             while ((input = rautoread.readLine()) != null){
                savedgamenamesL.add(input);
             }
             if (savedgamenamesL.size() == 0){
                System.out.println("No such saved game exisits!");
                return;
             }
             savedgamenamesO = new Object [savedgamenamesL.size()];
             savedgamenamesO = savedgamenamesL.toArray();
             savedgamenames = new String [savedgamenamesO.length];
             for (int i = 0; i < savedgamenames.length; i++){
                savedgamenames [i] = savedgamenamesO [i].toString();
             }
          //Reads in the saved game names
             for (int i = 0; i < savedgamenames.length - 1; i++){
                File rautofile = new File (savedgamenames [auto]+".txt");
                File rautofile2 = new File (savedgamenames [i+1]+".txt");
                if (rautofile.lastModified() < rautofile2.lastModified()){
                   auto = i+1;
                }
             }
             loadautoname = savedgamenames[auto];
             File file = new File ("savedgames.txt");
             File deletefile = new File (loadautoname + ".txt");
          //Deletes the file to change it
             file.delete();
             file.createNewFile();
             BufferedWriter write = new BufferedWriter (new FileWriter("savedgames.txt"));
             for (int i = 0; i < savedgamenames.length; i++){
                if (i != auto){
                   write.write(savedgamenames [i]);
                   write.newLine();
                }
             }
             write.close();
          //Deletes the saved game 
             deletefile.delete();
          
          
             file.setReadOnly();
          
          
          }
             catch (IOException e){
             }
       
       }
    
    
       if (numchoice == 3){
          int count1 = 0;
       //Reads in the saved game names
          try{
             BufferedReader read = new BufferedReader (new FileReader ("savedgames.txt"));
             System.out.println("Please enter the number corresponding to the name of the saved game you wish to enter or the name of the saved game or enter M (capital) for the menu");
          
             while ((input = read.readLine()) != null){
                System.out.println(count+1+". "+input);
                savedgamenamesL.add(input);
                count += 1;
             }
          //Reads in the saved game names
             savedgamenamesO = new Object [savedgamenamesL.size()];
             savedgamenamesO = savedgamenamesL.toArray();
             savedgamenames = new String [savedgamenamesO.length];
             for (int i = 0; i < savedgamenames.length; i++){
                savedgamenames [i] = savedgamenamesO [i].toString();
             }
             exit = 0;
          //Gets the user input on which game to delete
             while (exit == 0){
                userinput = sc.nextLine();
             //Validates the users choice
                try{
                   numchoice = Integer.parseInt(userinput);
                   if (numchoice <= count){
                      userinput = savedgamenames [numchoice - 1];
                      exit = 1;
                   }
                }
                   catch (NumberFormatException e){
                   }
             //Validates the users choice
                if (userinput.charAt(0) == 'M' && userinput.length() == 1){
                   return;
                }
                else if (exit != 1){
                   for (int i = 0; i < count; i++){
                      if (userinput.equals(savedgamenames [i])){
                         exit = 1;
                      }
                   }
                }
                else if (exit != 1){
                   System.out.println("You have entered an invalid choice, enter the number repersenting the save game or enter the name of the save game or enter M (capital) for the menu");
                }
             }
             loadautoname = userinput;
          
             File file = new File ("savedgames.txt");
             File deletefile = new File (loadautoname + ".txt");
          
             file.delete();
             file.createNewFile();
             BufferedWriter write = new BufferedWriter (new FileWriter("savedgames.txt"));
             for (int i = 0; i < savedgamenames.length; i++){
                if (i != auto){
                   write.write(savedgamenames [i]);
                   write.newLine();
                }
             }
             write.close();
          //Deletes the saved game 
             deletefile.delete();
          
          
             file.setReadOnly();
          
          
          }
             catch (IOException e){
             }
       
       }
    
       if (numchoice == 4){
          int count1 = 0;
       //Reads in the saved game names
          try{
             BufferedReader read = new BufferedReader (new FileReader ("autosavedgames.txt"));
             System.out.println("Please enter the number corresponding to the name of the saved game you wish to enter or the name of the saved game or enter M (capital) for the menue");
          
             while ((input = read.readLine()) != null){
                System.out.println(count+1+". "+input);
                savedgamenamesL.add(input);
                count += 1;
             }
             savedgamenamesO = new Object [savedgamenamesL.size()];
             savedgamenamesO = savedgamenamesL.toArray();
             savedgamenames = new String [savedgamenamesO.length];
             for (int i = 0; i < savedgamenames.length; i++){
                savedgamenames [i] = savedgamenamesO [i].toString();
             }
             exit = 0;
             while (exit == 0){
             //Gets user input on the saved game to delete
                userinput = sc.nextLine();
             //Validates the users choice
                try{
                   numchoice = Integer.parseInt(userinput);
                   if (numchoice <= count){
                      userinput = savedgamenames [numchoice - 1];
                      exit = 1;
                   }
                }
                   catch (NumberFormatException e){
                   }
             //Validates the users choice
                if (userinput.charAt(0) == 'M' && userinput.length() == 1){
                   return;
                }
                else if (exit != 1){
                   for (int i = 0; i < count; i++){
                      if (userinput.equals(savedgamenames [i])){
                         exit = 1;
                      }
                   }
                }
                else if (exit != 1){
                   System.out.println("You have entered an invalid choice, enter the number repersenting the save game or enter the name of the save game or enter M (capital) for the menu");
                }
             }
             loadautoname = userinput;
          
             File file = new File ("autosavedgames.txt");
             File deletefile = new File (loadautoname + ".txt");
          //Delete file to change it
             file.delete();
             file.createNewFile();
             BufferedWriter write = new BufferedWriter (new FileWriter("autosavedgames.txt"));
             for (int i = 0; i < savedgamenames.length; i++){
                if (i != auto){
                   write.write(savedgamenames [i]);
                   write.newLine();
                }
             }
             write.close();
          //Delete saved game
             deletefile.delete();
             file.setReadOnly();
          }
             catch (IOException e){
             }
       }
       System.out.println("The saved game has been deleted");
    }
 }

