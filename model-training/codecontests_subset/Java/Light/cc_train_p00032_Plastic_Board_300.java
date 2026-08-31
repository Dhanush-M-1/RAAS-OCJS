import java.lang.*;
import java.util.*;
import java.io.*;

public class Main
{
	public static void main (String[] arg)throws IOException
	{
		BufferedReader input =new BufferedReader (new InputStreamReader (System.in));
		String line;
		StringTokenizer token1;
		int a[]=new int[3];
		int sum1=0, sum2=0;
		while ((line = input.readLine()) != null && !line.isEmpty()) {
			token1 = new StringTokenizer(line,",");
			for(int i=0;i<3;i++){
				a[i]=Integer.parseInt(token1.nextToken());
			}
			//Arrays.sort(a);
			if(a[1]*a[1]+a[0]*a[0]==a[2]*a[2]){
				sum1++;
			}
			if(a[1]==a[0]){
				sum2++;
			}
		}
		System.out.println(sum1);
		System.out.println(sum2);
	}
}	