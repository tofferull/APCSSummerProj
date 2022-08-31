package arraylist.Purse;

import java.util.ArrayList;

public class Purse {
	private double sum;
	private int count = 0;
	private Top max;
	private ArrayList myArray;

	public Purse() {
		myArray = new ArrayList(100);
		// initial capacity of 100 objects

	}

	public void add(Top ci) {
		// code here
		if (count == 0 || max.getTop() < ci.getTop()) {
			max = ci;
		}
		count++;
		sum += ci.getTop();
		// added for arraylist
		// add new "coin" or "TC" superobject to list
		myArray.add(ci);

	}

	public SuperObject[] getMinMax() {
		SuperObject min, max;
		min = max = (SuperObject) myArray.get(0);

		for (int i = 1; i < myArray.size(); i++) {
			SuperObject obj = (SuperObject) myArray.get(i);
			double num = obj.getMyValue();
			if (num < min.getMyValue())
				min = obj;
			else if (num > max.getMyValue())
				max = obj;
		}
		return new SuperObject[] { min, max };
	}

	public boolean findObj(SuperObject obj) {
		for (int i = 0; i < myArray.size(); i++) {
			if (obj == (SuperObject) myArray.get(i))
				return true;
		}
		return false;
	}

	public boolean isCoin(Object obj) {
		try {
			obj = (Coin) obj;
			return true;
		} catch (ClassCastException e) {
			return false;
		}
	}

	public int[] numOfType() {
		int coinNums, tcNums;
		coinNums = tcNums = 0;

		for (int i = 0; i < myArray.size(); i++) {
			if (isCoin(myArray.get(i))) coinNums++;
			else tcNums++; 
		}
		return new int[] {coinNums, tcNums};
	}

	public double getTotal() {
		return sum;
	}

	public Top getTop() {
		return max;
	}

	public int getCount() {
		// return count;
		return myArray.size();
	}

	public Object getElement(int i) {
		return myArray.get(i);
	}

	public Object RemoveElement(int i) {
		return myArray.remove(i);
	}

	public Object setElement(int e, Object o) {
		return myArray.set(e, o);
	}

	public String toString() {
		String s = " ";

		for (int x = 0; x < myArray.size(); x++) {

			s += ((SuperObject) myArray.get(x)).toString();
			s += " ";
		}
		return s;
	}

}
