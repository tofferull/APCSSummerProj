package arraylist.Purse;

/** 
 * NewPurse.java
 *
 * Description:	
 * @author			David Farrell
 * @version			
 */
/**
 * 
 * // OUTPUT:
 * /*
 * the total in the purse is 100.35
 * the total in the purse is 100.0
 * the total Objects in purse is 3
 * the total COINS in purse is 2
 * the total Travelers Checks in purse is 1
 * myStuff[0] is a SuperClass
 * myStuff[0] is a Coin
 * 0.1 Compared to 100.0 returned -1
 */

public class NewPurse {
	public NewPurse() {
	}

	// Main entry point
	static public void main(String[] args) {
		new NewPurse();

		Purse myPurse = new Purse();

		Top[] myStuff = new Top[3];

		myStuff[0] = new Coin(.25, "Quarter");
		myStuff[1] = new Coin();
		// assume TravelerCheck is another child ofSuperObject
		myStuff[2] = new TravelerCheck(100.0, "TC", "American Express");

		myPurse.add(myStuff[0]); // adds .25 to purse and sets THIS Coin object as max
		myPurse.add(myStuff[1]); // adds .10 to purse
		myPurse.add(myStuff[2]); // adds 100.0 to purse and sets THIS TravelerCheck object as max

		/*
		 * Edited Ver. NewPurse.java
		 * 
		 * Edited Output: 	
		 * 	the total in the purse is 101.25
			There are a total of 2 Coins totaling 1.25 in the purse
			There is one Traveler Check totaling 100.0 in the purse
			Removed a TC
			There are NO Traveler Checks in the purse
			The Minimum valued item in the Purse is a Quarter and it is for 0.25
			The Maximum valued item in the purse is a dollar and it is for 1.0
		 */


		System.out.println("the total in the purse is " + myPurse.getTotal()); // prints out 100.35

		// #1
		int[] types = myPurse.numOfType();
		int coinNum = types[0];
		int tcNum = types[1];

		if (coinNum > 0)
			System.out.println("There " + (coinNum == 1 ? "is" : "are") + " a total of " + coinNum + " Coin"
					+ (coinNum > 1 ? "s " : " ") + "totaling " + Coin.getTotalValue() + " in the purse");

		if (tcNum > 0)
			System.out.println("There "
					+ (tcNum > 1 ? "are " + tcNum : "is one") +
					" Traveler Check totaling " + TravelerCheck.getTotalValue() + " in the purse");

		// #2
		myPurse.RemoveElement(2);//removes TC
		int[] itemTypes = myPurse.numOfType();
		System.out.println("Removed a TC");
		System.out.println("There are "+(itemTypes[1] == 0 ? "NO" : itemTypes[1])+" Traveler Checks in the purse");

		SuperObject[] vals = myPurse.getMinMax();

		System.out.println("The Minimum valued item in the Purse is a "
				+ vals[0].getMyName() +
				" and it is for " + vals[0].getMyValue());
		System.out.println("The Maximum valued item in the purse is a "
				+ vals[1].getMyName() +
				" and it is for " + vals[1].getMyValue());

	} // end of SPVM

} // END OF Wrapper Class
