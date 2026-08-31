import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		double a[] = new double[200];
		a[0] = 0;
		for(int i = 3; i < 200; i += 2){
		    double angle = 180.0 / (i * 2);
		    double val1 = Math.cos(Math.toRadians(angle / 2)) / Math.sin(Math.toRadians(angle));
		    a[i] = val1;
		}
		int t = Integer.parseInt(br.readLine());
		while(t-- > 0){
		    int n = Integer.parseInt(br.readLine());
		    sb.append(a[n]+"\n");
		}
		System.out.println(sb);
	}	
}
