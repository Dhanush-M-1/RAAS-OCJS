import java.io.*;
import java.util.*;
import java.math.BigInteger;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Codeforces 
{
	
    public static void main(String[] args) throws IOException
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String s = sc.next();
		String res = "";
		HashMap<String , Integer> map = new HashMap<String , Integer>();
		int i , max = 0;
		for(i = 0; i < n-1; i++)
		{
			String t = s.charAt(i) + "" + s.charAt(i+1);
			if(map.containsKey(t))
				map.put(t , map.get(t)+1);
			else
				map.put(t , 1);
			if(map.get(t) > max)
			{
				res = t;
				max = map.get(t);
			}
		}
		System.out.println(res);
        sc.close();
    }
}

