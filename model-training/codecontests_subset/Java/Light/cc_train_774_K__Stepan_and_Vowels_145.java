import java.util.*;
import java.io.*;

public class A778 {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		char[] ss = (in.nextLine()).toCharArray();
		char[] s = (in.nextLine()).toCharArray();
		int i = 0;
		while (i < n)
		{
		    if (s[i] != 'a' && s[i] != 'e' && s[i] != 'o' && s[i] != 'u' && s[i] != 'i' && s[i] != 'y')
		    {
		        System.out.print(s[i]);
		        i++;
		        continue;
		    }
		    int j = i;
		    while (j < n && s[i] == s[j])
		        j ++;
		    if (i == j - 2 && (s[i] == 'o' || s[i] == 'e'))
		        {
		            System.out.print(s[i]);
		            System.out.print(s[i + 1]);
		        }
		    else
		        System.out.print(s[i]);
		    i = j;
		}
	}
}