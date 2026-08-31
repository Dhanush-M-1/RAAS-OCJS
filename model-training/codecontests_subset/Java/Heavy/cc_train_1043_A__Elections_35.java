
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Sed {

	public static boolean arr(ArrayList<Integer> ins, int k)
	{
		int ik = 0;
		for (int i:ins)
		{
			ik+=i;
		}
		int ok = 0;
		for (int i:ins)
		{
			if (k-i<0)
			{
				return false;
			}
			else
			{
				ok+=k-i;
			}
		}
		if (ok>ik)
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	public static void main(String[] args) 
	{
		Scanner jk = new Scanner(System.in);
		int n = jk.nextInt();
		ArrayList<Integer> ins = new ArrayList<Integer>();
		for (int i=0; i<n; i++)
		{
			ins.add(jk.nextInt());
		}
		int k = 0;
		while (!arr(ins,k))
		{
			k++;
		}
		System.out.println(k);

	}

}
