import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.Map.Entry;


public class Main {
	
	
	public static void main(String [] args)
	{
		Scanner in = new Scanner(System.in);
		int count = in.nextInt();
		String input = in.next();
		
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		
		for(int i=0; i<input.length(); i++)
		{
			if(map.containsKey(input.charAt(i)))
			{
				int counter = map.get(input.charAt(i));
				counter++;
				map.put(input.charAt(i), counter);
			}
			else
				map.put(input.charAt(i), 1);
		}
		Iterator<Entry<Character, Integer>> it = map.entrySet().iterator();
		while(it.hasNext())
		{
			Entry<Character, Integer> pair = it.next();
			if(pair.getValue()%count!=0)
			{
				System.out.println("-1");
				return;
			}
		}
		// valid count construct string
		it = map.entrySet().iterator();
		String  chunk="";
		while(it.hasNext())
		{
			Entry<Character, Integer> pair = it.next();
			int charCount = pair.getValue()/count;
			for(int i =0; i<charCount; i++)
			{
				chunk+=pair.getKey();
			}
		}
		//System.out.println(chunk);
		String result = "";
		for(int i =0; i<count; i++)
		{
			result+=chunk;
		}
		System.out.println(result);
		
	}

}