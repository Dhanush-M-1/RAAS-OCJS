import java.io.*;
import java.util.*;

import static java.lang.Math.*;
import static java.util.Arrays.*;

public class KString {
	public static void main(String[] args) throws IOException {
	  Scanner sc = new Scanner(System.in);
		
	  //READ----------------------------------------------------
    int k = sc.nextInt(); sc.nextLine();
    char[] s = sc.nextLine().toCharArray();
    
		//SOLVE----------------------------------------------------
		String res = "";
		
		Arrays.sort(s);
		char last=s[0];
		int count = 1;
		HashMap<Character, Integer> h = new HashMap<Character, Integer>();
		for (int i = 1; i < s.length; i++)
    {
      if(last==s[i])
        count++;
      else{
        if(count%k!=0){
          res = "-1";
          break;
        }
        h.put(last, count);
        count=1;
        last=s[i];
      }
    }
		
		if(count%k!=0)
      res = "-1";
		else
		  h.put(last, count);
		
		if(res.equals("")){
  		Set set = h.keySet();
  		for (Iterator iterator = set.iterator(); iterator.hasNext();)
      {
        Character c = (Character) iterator.next();
        for (int i = 0; i < h.get(c)/k; i++)
        {
          res += c;
        }
      }
		}
    //CLOSE----------------------------------------------------
		if(!res.equals("-1"))
		  for (int i = 0; i < k; i++)
		    System.out.print(res);
		else
		  System.out.print(res);
		
    sc.close();
	}
}