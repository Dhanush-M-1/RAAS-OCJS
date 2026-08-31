// TLE? (hope not)
// machhar ki maa ki c...
import java.util.*;
import java.util.regex.*;

public class Codechef
{
	public static void main (String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String s = sc.next();
		HashMap<String, Integer> has = new HashMap<>();
		for(int i = 0; i < s.length()-1; i++)
		{
		    String sub = "" + s.charAt(i) + s.charAt(i+1);
		    Pattern pat = Pattern.compile(sub);
		    Matcher mat = pat.matcher(s);
		    int cin = 0;
		    while(mat.find())
    		{
    		    cin++;
    		}
    		if(has.get(sub)==null)
    		{
    		    has.put(sub,cin);
    		}
    		else
    		{
    		    int k = (int)has.get(sub);
    		    k = k + cin;
    		    has.put(sub,k);
    		}
		}
		int count = 0;
		String ans = "";
	    for (Map.Entry mapElement : has.entrySet()) 
	    { 
            String key = (String)mapElement.getKey(); 
            int value = ((int)mapElement.getValue()); 
            if(count < value)
            {
                count = value;
                ans = key;
            }
        } 
		System.out.println(ans);
	}
}
