/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
public final class Ideone
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner in = new Scanner(System.in);
		int tc = in.nextInt();
		
		for(int i=0;i<tc;i++){
			int moments = in.nextInt();
			int previousPlays = 0, previousClears = 0;
			boolean isValid = true;
			for(int j=0;j<moments;j++){
				int currPlays = in.nextInt();
				int currClears = in.nextInt();
				//System.out.println(currPlays+" "+currClears);
				int diffInPlays = currPlays-previousPlays;
				int diffInClears = currClears-previousClears;
				
				if(isValid){
					if(diffInPlays < 0 || diffInClears < 0){
						System.out.println("NO"); isValid = false;
					}else if(diffInPlays < diffInClears){
						System.out.println("NO"); isValid = false;
					}
				}
				previousPlays = currPlays;
				previousClears = currClears;
				
			}
			if(isValid) System.out.println("YES");
			//System.out.println();
		}
	}
}