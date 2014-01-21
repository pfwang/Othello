


//Imports two java packages to be used in the java program
import java.io.*;
import java.util.*;
//Declaration of the class Othello
public class Othello{
	//Declaration of all the global variables used in the program
	public static  String [][] board;
	public static int [] numsize = new int [2];
	public static int move = 0;
	public static int bpoints = 0;
	public static int wpoints = 0;
	public static int letternum, intnum = -1;
	public static int bflankpoints = 0;
	public static int wflankpoints = 0;
	public static String filename;
	public static int newchoice = 0;
	public static String autoname;
	public static int gamecount = 4;
	public static int valid = 0;
	public static String [] normalsavednames;
	public static int first;
	public static int autosaveexit;
	public static int load = 0;
	public static String loadautoname;
	public static int totalcount;
	public static int loadcounter = 0;
	//Declaration of the main class
	public static void main (String[]args){
		int choice = 0;
		int run = 0;
		//This infinite loop makes it so the user can only exit the program with the Exit() method
		while (run == 0){
			//Gets the user input for the start menu
			choice = Menu.startMenu(); 
			//The if and else if statements runs the part of the program that the user wants to run
			if (choice == 1) {
				newchoice = 1;
				//This loop allows the newGame() method to be re-run from user input from the game menu
				while (newchoice == 1){
					newchoice = 0;
					//Runs the newGame() method which creates and runs a new game of Othello
					GameCreator.newGame();
				}
			}
			if (loadcounter == 1){
				//Runs the loadGame() method which loads a pre-existing saved game from user instructions
				GameIO.loadGame();
				newchoice = 1;
				while (newchoice == 1){
					newchoice = 0;
					//Runs the contGame() method which allows the users to play Othello after the saved game is loaded to the program
					GamePlay.contGame();
				}
			}
			else if (choice == 2){
				//Runs the loadGame() method which loads a pre-existing saved game from user instructions
				GameIO.loadGame();
				//Runs the contGame() method which allows the users to play Othello after the saved game is loaded to the program
				newchoice = 1;
				while (newchoice == 1){
					newchoice = 0;
					//Runs the contGame() method which allows the users to play Othello after the saved game is loaded to the program
					GamePlay.contGame();
				}
			}
			if (loadcounter == 1){
				//Runs the loadGame() method which loads a pre-exisiting saved game from user instructions
				GameIO.loadGame();
				newchoice = 1;
				while (newchoice == 1){
					newchoice = 0;
					//Runs the contGame() method which allows the users to play Othello after the saved game is loaded to the program
					GamePlay.contGame();
				}
			}
			else if (choice == 3){
				//Runs the Exit() method which exits the java program of Othello
				GamePlay.Exit();
			}
			else if (choice == 4){
				//Runs the deletsaveGame() method which allows the user to delete pre-exisiting saved games 
				GameIO.deletsaveGame();
			}

			loadcounter = 0;
		}
	}

}
