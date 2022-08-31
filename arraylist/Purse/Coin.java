package arraylist.Purse;

public class Coin extends SuperObject  implements Top
{
	private static int numCoins = 0;
	private static double totalValue = 0;

	public Coin(double value, String name) 
	{  
		totalValue += value;
		setMyValue(value);	
		setMyName(name);
		numCoins++;
	}
	
	public Coin( )
	{
		this(1, "dollar");  // calls Coins constructor that takes 2 arguments
	} 
	
	public double getTop( )  
	{  
	return getMyValue(); 
	}
	
	public int getNum()
	{
		return numCoins;
	}

	public static double getTotalValue() {
		return totalValue;
	}
} 