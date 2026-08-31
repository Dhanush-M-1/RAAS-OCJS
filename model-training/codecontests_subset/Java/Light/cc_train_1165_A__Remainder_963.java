import java.util.Scanner;
import java.io.*;

public class codeforces1
{
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int n,x,y;
		n = in.nextInt();
		x= in.nextInt();
		y= in.nextInt();
		String str=in.nextLine();
		str=in.nextLine();
		str=str.substring(n-x);
		char[] ch= str.toCharArray();
		int count=0;
		if(ch[x-y-1]=='1')
			count--;
		else 
			count++;
		for(int i=0; i<str.length(); i++)
			if(ch[i]=='1') count++; 
		System.out.println(count);
	}
}