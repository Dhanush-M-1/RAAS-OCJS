import java.util.*;
import java.io.*;
public class help {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner (System.in);
		String s = in.next();
		char [] s1 = s.toCharArray();
		char [] s2 = new char [s.length()/2+1] ;
		
		for (int i=0,j=0 ; i <s1.length&& j < s2.length ; i+=2,j++)
		{
				s2[j]=s1[i];
		}
		Arrays.sort(s2);
		System.out.print(s2[0]);
		for (int r = 1 ; r <s2.length;r++)
			System.out.print("+"+s2[r]);	
	}

}
