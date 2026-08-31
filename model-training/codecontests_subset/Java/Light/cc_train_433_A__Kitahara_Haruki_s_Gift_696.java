import java.io.*;
import java.math.BigInteger;
import java.util.*;
public class Temp3 {
	public static void main(String[] args) throws Throwable {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int two = 0;
		int one = 0;
		for (int i = 0; i < n; i++) {
			int x = Integer.parseInt(st.nextToken());
			if(x==100)
				one++;
			else
				two++;
		}
		if( (one>0 && one%2==0)|| (one==0 && two%2==0) )
			System.out.println("YES");
		else
			System.out.println("NO");
			
	}
}
