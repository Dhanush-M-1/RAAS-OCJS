import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;
 
public class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int first[] = new int[n];
        int sec[] = new int[n-1];
        int third[] = new int[n-2];
        for(int i = 0; i < n; i++) {
            first[i] = sc.nextInt();
        }
        for(int i = 0; i < n-1; i++) {
            sec[i] = sc.nextInt();
        }
        for(int i = 0; i < n-2; i++) {
            third[i] = sc.nextInt();
        }
        int p1 = 0,p2 = 0,p3 = 0;
        int firstNum = 0;
        int secNum= 0;
        int thirdNum = 0;
        for(int i = 0; i < n; i++) {
            firstNum = firstNum ^ first[i];
        }
        for(int j = 0; j < n-1; j++) {
            secNum = secNum ^ sec[j];
        }
        for(int j = 0; j < n-2; j++) {
            thirdNum = thirdNum ^ third[j];
        }
        System.out.print((firstNum^secNum)+"\n"+(secNum^thirdNum)+"\n");
	}
}