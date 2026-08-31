
import java.util.Scanner;
import java.util.TreeMap;
import java.util.Map.Entry;

public class AncientProphesy {
	static String s;

	static int days(int x)
	{
		if(x==2)
			return 28;
		if(x==1 || x==3 || x==5 || x==7 ||x==8 ||x==10 ||x==12)
			return 31;
		else
			return 30;
	}

	static boolean isValid(int i)
	{
		if(s.charAt(i+2)!='-' || s.charAt(i+5)!='-')
			return false;
		try
		{
		int month = Integer.parseInt(s.substring(i+3,i+5));
		if(month>12 || month<1 )
			return false;


		int day = Integer.parseInt(s.substring(i,i+2));
		if(day<1 || day>days(month))
			return false;

		int year = Integer.parseInt(s.substring(i+6,i+10));
		if(year>2015 || year<2013 )
			return false;
		}
		catch(Exception e)
		{
			return false;
		}
		return true;

	}


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		s = sc.nextLine();
		TreeMap<String,Integer> map = new TreeMap<String,Integer>();
		for(int i=0;i<s.length()-9;i++)
		{
			if(isValid(i))
			{
				String ss = s.substring(i,i+10);
				if(!map.containsKey(ss))
					map.put(ss, 1);
				else
					map.put(ss, map.get(ss)+1);
			}
		}
		String date = "";
		int max = -1;
		for(Entry<String, Integer> ent : map.entrySet())
		{
			if(ent.getValue()>max)
				date = ent.getKey();
			max = Math.max(max, ent.getValue());
		}
		System.out.println(date);
		
			
	}

}
