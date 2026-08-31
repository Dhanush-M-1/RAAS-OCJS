import java.util.*;
import java.io.*;

public class a{

	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		String s = in.next();
		int mem[] = new int[255];

		for(int i=0;i<s.length();i++)
			mem[s.charAt(i)]++;

		System.out.println(funny(mem));

	}

	public static int funny(int mem[]){
		if(mem['I']>1) return 0;
		if(mem['I']==1) return 1;
		return mem['A'];
	}

}