import java.util.Random;

public class Dice {

	private int dice1Result;
	private int dice2Result;
	private int sumDices;


	public Dice() {

		Random numGenerator1 = new Random();
		dice1Result = numGenerator1.nextInt(6) + 1;


		Random numGenerator2 = new Random();
		dice2Result = numGenerator2.nextInt(6) + 1;

	}//end dice



	public int returnDice() {

		return sumDices = dice1Result + dice2Result;

	}//end return  dice



}//end class Dice

