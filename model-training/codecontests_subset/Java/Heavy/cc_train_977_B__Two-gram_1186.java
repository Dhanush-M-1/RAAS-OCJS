

import java.util.ArrayList;
import java.util.Scanner;

public class Qw1 {

	public static void main(String[] args) 
	{
		Scanner jk = new Scanner(System.in);
		int v = jk.nextInt();
		jk.nextLine();
		String ins = jk.nextLine();
		ArrayList<String> ios = new ArrayList<String>();
		ArrayList<Integer> indc = new ArrayList<Integer>();
		for (int i=0; i<ins.length()-1; i++)
		{
			String toput = ins.substring(i, i+2);
			if (ios.contains(toput))
			{
				int indi = ios.indexOf(toput);
				indc.set(indi, indc.get(indi)+1);
			}
			else
			{
				ios.add(toput);
				indc.add(1);
			}
		}
		int max = -1;
		for (int i:indc)
		{
			if (i>max)
			{
				max = i;
			}
		}
		int ind = 0;
		int temp = 0;
		for (int i:indc)
		{
			if (max==i)
			{
				ind = temp;
			}
			temp++;
		}
		System.out.println(ios.get(ind));
		
	}

}

