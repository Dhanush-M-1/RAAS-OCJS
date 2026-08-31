import java.io.*;
import java.util.*;

public class Compile
{
	public static void main(String[] args) {
		int n, i, xor1=0, xor2=0, elem;
		Scanner sc = new Scanner(System.in);
		n=sc.nextInt();
		for(i=0; i<n; i++)
			xor1=xor1^sc.nextInt();
		for(i=0; i<n-1; i++)
		{
			elem=sc.nextInt();
			xor1=xor1^elem;
			xor2=xor2^elem;
		}
		for(i=0; i<n-2; i++)
			xor2=xor2^sc.nextInt();
		System.out.println(xor1+"\n"+xor2);
	}
}