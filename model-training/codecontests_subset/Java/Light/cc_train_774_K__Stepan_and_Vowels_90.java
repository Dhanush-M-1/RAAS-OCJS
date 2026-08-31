import java.util.*;

public class Sol{
	public static void main(String[] argc){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String s = sc.nextLine();
		s = sc.nextLine();
		StringBuilder ans = new StringBuilder();
		
		int len = 1;
		for (int i = 1; i<n; ++i)
		{
		    if (s.charAt(i) == s.charAt(i-1) && (s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'o' || s.charAt(i) == 'u' || s.charAt(i) == 'y' || s.charAt(i) == 'i'))
		        ++len;
		    else
    		{
    		    if (len == 2 && (s.charAt(i-1) == 'e' || s.charAt(i-1) == 'o'))
	               ans.append(s.charAt(i-1));
		        ans.append(s.charAt(i-1));
        	    len = 1;
		    }
        		        
		}
	    if (len == 2 && (s.charAt(n-1) == 'e' || s.charAt(n-1) == 'o'))
           ans.append(s.charAt(n-1));
        ans.append(s.charAt(n-1));
        
        String sans = ans.toString();
        System.out.println(sans);
	}
}