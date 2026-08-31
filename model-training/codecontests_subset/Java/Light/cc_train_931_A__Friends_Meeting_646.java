import java.util.Scanner;
import java.lang.*;
import java.io.*;

public class S
{
	public static int getPos(int a){
		if(a>=0)
		return a;
		else
		return -1*a;
	}
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int y = getPos(a-b);
		int z = y/2;
		long A = z*(z+1)/2;
		if(y%2==0)
			System.out.println(A*2);
		else
			System.out.println(A*2+(z+1));
	}
}