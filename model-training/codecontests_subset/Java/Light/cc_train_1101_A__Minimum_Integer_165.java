import java.util.*;
import java.io.*;

public class Main 
{
	public static void main(String[] args) throws IOException {	
        
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int x, d, y, ans, mod;
		for(int i = 0; i < n; i++) {
			x = in.nextInt();
		    y = in.nextInt();
		    d = in.nextInt();
		    if(x > d)
		        System.out.println(d);
		    else
		    {
		        mod = y % d;
		        ans = y + d - mod; 
		        System.out.println(ans);
		    }
		}
	}
}