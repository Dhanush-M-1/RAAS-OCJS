import java.util.*;

public class Main
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
		if(!(input.contains("+")))
		{
			System.out.println(input);
			return;
		}
		ArrayList<Integer> plusses = new ArrayList<Integer>();
		for (int index = 0; index<input.length(); index++)
		{
			if(input.charAt(index)=='+')
			{
				plusses.add(index);
			}
		}
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		numbers.add(Integer.parseInt(input.substring(0, plusses.get(0))));
		for (int index = 0; index<plusses.size()-1; index++)
		{
			numbers.add(Integer.parseInt(input.substring(plusses.get(index), plusses.get(index+1))));
		}
		numbers.add(Integer.parseInt(input.substring(plusses.get(plusses.size()-1))));
		int[] sorted = new int[numbers.size()];
		for (int index = 0; index<sorted.length; index++)
		{
			sorted[index] = numbers.get(index);
		}
		Arrays.sort(sorted);
		for (int index = 0; index<sorted.length-1; index++)
		{
			System.out.print(sorted[index]+"+");
		}
		System.out.println(sorted[sorted.length-1]);
		
	}
}

 	   	 		   	 	 				 		 	  	 		