import java.io.*;
import java.util.*;
import java.math.*;

public class c347B {

    public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		//parse and count the number of question marks added, and the number subtracted
		char[] c = in.nextLine().toCharArray();
		int posQ = 0;
		int negQ = 0;
		boolean isNeg = false;
		int ind = 0;
		while(c[ind] != '='){
			if(c[ind] == '?'){
				if(isNeg)
					negQ++;
				else
					posQ++;
			}
			if(c[ind] == '+')
				isNeg = false;
			if(c[ind] == '-')
				isNeg = true;
			ind++;
		}
		while(c[ind] < 48 || c[ind] > 57){
			ind++;
		}
		int n = Integer.parseInt(String.valueOf(c, ind, c.length-ind));
		
		//the min number that can be reached is by setting each positive questionmark to 1 and each negative to n
		int min = posQ - (n*negQ);
		//for max, set each positive questionmark to n and each negative questionmark to 1
		int max = (n*posQ) - negQ;
		if(n<=max && n>=min){
			System.out.println("Possible");
			if(posQ - negQ >= n){
				int extraNegNeeded = posQ-negQ-n;
				isNeg = false;
				ind = 0;
				while(c[ind] != '='){
					if(c[ind] == '?'){
						if(isNeg){
							if(extraNegNeeded >= (n-1)){
								System.out.print(n);
								extraNegNeeded -= (n-1);
							}
							else{
								System.out.print(1+extraNegNeeded);
								extraNegNeeded = 0;
							}
						}
						else{
							System.out.print("1");
						}
					}
					else{
						if(c[ind] == '+')
							isNeg = false;
						if(c[ind] == '-')
							isNeg = true;
						System.out.print(c[ind]);
					}
					ind++;
				}
				System.out.println("= "+n);		
			}
			else{
				int extraPosNeeded = n-(posQ-negQ);
				isNeg = false;
				ind = 0;
				while(c[ind] != '='){
					if(c[ind] == '?'){
						if(isNeg){
							System.out.print("1");
						}
						else{
							if(extraPosNeeded >= (n-1)){
								System.out.print(n);
								extraPosNeeded -= (n-1);
							}
							else{
								System.out.print(1+extraPosNeeded);
								extraPosNeeded = 0;
							}
						}
					}
					else{
						if(c[ind] == '+')
							isNeg = false;
						if(c[ind] == '-')
							isNeg = true;
						System.out.print(c[ind]);
					}
					ind++;
				}
				System.out.println("= "+n);	
			}
		}
		else
			System.out.println("Impossible");
	}
	
}