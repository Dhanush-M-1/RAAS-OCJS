import java.util.*;
import java.io.*;
public class Main {
	public static void main(String args[]) throws java.lang.Exception	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String s[] = br.readLine().split(" ");
		int n = Integer.parseInt(s[0]);
		int k = Integer.parseInt(s[1]);
		int person = 1;
		if (k > 1){
		    int a = 2;
		    while (person + a < k){
		        person += a;
		        a++;
		    }
		    person = k - person;
		}
		s = br.readLine().split(" ");
		System.out.println(s[person-1]);
	}
}