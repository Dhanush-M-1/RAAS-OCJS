/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		sc.nextInt();
		char[] p = sc.next().toCharArray();
		int[] dists = new int[101];
		boolean works = false;
		for(int i = 0; i < p.length; i++){
			if(p[i] == '*'){
				for(int j = i+1; j < p.length; j++){
					if(p[j] == '*'){
						int curCounter = 1;
						int jump = j - i;
						for(int k = j+jump; k < p.length; k+=jump){
							if(p[k] == '*'){
								curCounter++;
							} else {
								break;
							}
							if(curCounter > 3){
								works = true;
							}
						}
					}
				}
			}
		}
		if(works){
			System.out.println("yes");
		} else {
			System.out.println("no");
		}
	}
}