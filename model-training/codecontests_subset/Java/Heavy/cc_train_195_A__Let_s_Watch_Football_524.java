import java.util.Scanner;


public class A 
{

	static int dataNeededToWatchOneSecond;
	static int dataDownloadedPerSecond;
	static int secondsInVideo;
	static int minimumValue = 0;
	static int maximumValue;
	final public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		dataNeededToWatchOneSecond = s.nextInt();
		dataDownloadedPerSecond = s.nextInt();
		secondsInVideo = s.nextInt();
		maximumValue = secondsInVideo * dataNeededToWatchOneSecond / dataDownloadedPerSecond;
		int low = minimumValue;
		int high = maximumValue;
		int current = (high + low)/2;
		while (low < current)
		{
			if (testCase(current) == false)
			{
				low = current;
				//System.out.println("Low = " + low);
			} else
			{
				high = current;
				//System.out.println("High = " + high);
			}
			current = (high + low)/2;
		}
		int print = high;
		if (testCase(current) == true)
		{
			print = current;
		}
		if (testCase(low) == true)
		{
			print = low;
		}
		System.out.println(print);
	}
	
	//return true if waiting testValue seconds is big enough
	//return false if that does not
	final public static boolean testCase(int testValue)
	{
		int startingData = dataDownloadedPerSecond * testValue;
		int dataAmount = startingData;
		for (int seconds = 1; seconds <= secondsInVideo; seconds++)
		{
			dataAmount -= dataNeededToWatchOneSecond;
			dataAmount += dataDownloadedPerSecond;
			if (dataAmount < 0)
			{
				return false;
			}
		}
		return true;
	}
}
	  		 	   	  		 		      	