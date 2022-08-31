package arraylist.Purse;

public class TravelerCheck extends SuperObject  implements Top
{
	private static int numTC = 0;
    private static double totalValue = 0;
	private String checkType;
	
	public TravelerCheck(double value, String name, String t) 
	{  
        totalValue += value;
		checkType = t;
		numTC++;
		setMyValue(value);	
		setMyName(name);
	}
	
	public TravelerCheck()
	{
		this(100.0, "TC", "American Express");
	} 
	
	public double getTop()  
	{  
	    return getMyValue(); 
	}
	
	public String getCheckType()
	{
		return checkType;
	}
	
	public int getNum()
	{
		return numTC;
	}

    public static double getTotalValue() {
        return totalValue;
    }
} 