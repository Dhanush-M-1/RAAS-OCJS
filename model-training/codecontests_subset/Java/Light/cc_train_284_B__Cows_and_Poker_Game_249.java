import java.util.*;
import java.lang.*;
import java.io.*;




public class Main
{
    
    public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		String str = sc.next();
		int countA =0;
		int countF =0;
		int countI = 0;
		for(int i=0;i<n;i++){
		    if(str.charAt(i)=='A')countA++;
		    else if(str.charAt(i)=='F')countF++;
		    else countI++;
		}
		int result=0;
		if(countI==0) result = countA;
		else if(countI==1) result = countI;
		else result =0;
		System.out.println(result);
		
		
	}
}
