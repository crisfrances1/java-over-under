import java.util.ArrayList;

import javax.swing.JOptionPane;


public class Bet {

	//instance variables


	public String usersName;

	private String bet;
	private int usersBet;
	private int betUnder = 1;
	private int betSeven = 2;
	private int betOver = 3;

	private int totalDices;

	private int betCost = 1;
	private int winBetSeven = 5;
	private int winBetUnderOver = 2;
	private int money = 3;

	private int goes = 5;
	private int oneGoLeft = 1;
	private int minusOneGoes = 1;
	private int counter = 0;

	private String output;
	private String arrayOutput;

	public static ArrayList <String> betOutput = new ArrayList <String>();



	public void username () {

		usersName = JOptionPane.showInputDialog("Hello! Please enter your name :)");

	}//end username



	public Bet() {

		username();
		usersBet();

	}//end bet



	public void usersBet () {

		while (money != 0 &&  goes >= oneGoLeft ) {


			bet = JOptionPane.showInputDialog(
					"Welcome " + usersName + "! You have " + goes +  " goes left \n "
							+ "and £" + money + " in your account" 
							+ " \n \n Select one of the menu options to place a bet: "
							+ " \n 1- Bet under seven \n"
							+ " 2- Bet seven \n"
							+ " 3- Bet over seven");

			usersBet = Integer.parseInt(bet); //we convert the string to an integer


			validateInputs(); //the program shifts to this method to validate the user's input


			Dice sumDices = new Dice();
			totalDices = sumDices.returnDice();


			if (usersBet == betOver && totalDices >= 8) {
				//user bets over 7 and the computer rolls over 7 
				output = "The computer rolled " + totalDices + ". You won the bet and £2! ;D \n";
				betOutput.add(output);
			}//end if


			else if (usersBet == betOver && totalDices < 8) {
				//user bets over 7 and the computer rolls under or 7
				output = "The computer rolled " + totalDices + ". You lost the bet :( \n";
				betOutput.add(output);
			}//end first else if 


			else if (usersBet == betUnder && totalDices <= 6) {
				//user bets under 7 and the computer rolls under 7 			
				output = "The computer rolled " + totalDices + ". You won the bet and £2! ;D \n";	
				betOutput.add(output);
			}//end second else if


			else if ( usersBet == betUnder && totalDices >= 7) {
				//user bets under 7 and the computer rolls over or 7			
				output = "The computer rolled " + totalDices + ". You lost the bet :( \n";	
				betOutput.add(output);
			}//end third else if


			else if (usersBet == betSeven && totalDices == 7) {
				//user bets 7 and the computer rolls 7 
				output = "The computer rolled " + totalDices + ". You won the bet and £5! ;D \n";
				betOutput.add(output);
			}//end fourth else if 


			else if (usersBet == betSeven && totalDices >= 7 || totalDices <= 6) {
				//users bets 7 and the computer rolls under or over			
				output = "The computer rolled " + totalDices + ". You lost the bet :( \n";	
				betOutput.add(output);
			}//end fifth else if


			JOptionPane.showMessageDialog(null, output);


			counter ++;
			goes = goes - minusOneGoes; //we have to subtract a go every time the user plays
			money = money - betCost; //each bet costs £1

			moneyGained();

			endOfGame();





		}//end while



	}//end usersBet



	public void validateInputs () {

		while(usersBet < betUnder || usersBet > betOver) {
			bet = JOptionPane.showInputDialog("ERROR - Please enter a valid bet \n 1- Bet under seven "
					+ "\n 2- Bet seven"
					+ "\n 3- Bet over seven");
			//convert String to and integer
			usersBet = Integer.parseInt(bet);
		}//end validation

	}//end validateInputs



	public void endOfGame () {

		if (goes == 0 && money == 0) {
			JOptionPane.showMessageDialog(null,"   END OF THE GAME \nYou have no money or goes left");
			getList();
			System.exit(0);
		}//end if
		else if ( money == 0) {
			JOptionPane.showMessageDialog(null,"   END OF THE GAME \nYou have no money left");
			getList();
			System.exit(0);
		}//end else if
		else if (goes == 0) {
			JOptionPane.showMessageDialog(null,"   END OF THE GAME \nYou have no  goes left");
			getList();
			System.exit(0);
		}//end second else if

	}//end endOfGame



	public void moneyGained () {

		if (usersBet == betUnder && totalDices <= 6) {
			money = money + winBetUnderOver;
		}//end if 
		if (usersBet == betOver && totalDices >= 8) {
			money = money + winBetUnderOver;
		}//end second if 
		if (usersBet == betSeven && totalDices == 7) {
			money = money + winBetSeven;
		}//end third if 

	}//end moneyGained


	public  void getList () {

		arrayOutput = " You have £" + money + " left. \n This is a summary of your bets during the game: \n \n ";
		arrayOutput = arrayOutput + Bet.betOutput.toString().replace("[","").replace("]","").replace("," , "");


		JOptionPane.showMessageDialog(null, arrayOutput);

	}//end arrayList



}//end class Bet
