

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FoxDividingCheese {
	public int equal(int a,int b) {
		if(a==b) {
			return 0;
		}
		int counter=0;
		Map<Integer,Integer>mp1=new HashMap<>();
		Map<Integer,Integer>mp2=new HashMap<>();
		mp1.put(2,0); mp1.put(3,0);  mp1.put(5,0);
		
		mp2.put(2,0); mp2.put(3,0);  mp2.put(5,0);
		
		while(a!=1) {
			if(a%2!=0 && a%3!=0 && a%5!=0) {
				break;
			}
			if(a%2==0) {
				a=a/2;
				mp1.put(2,mp1.get(2)+1);
			}
			else if(a%3==0) {
				a=a/3;
				mp1.put(3,mp1.get(3)+1);
			}
			else if(a%5==0) {
				a=a/5;
				mp1.put(5,mp1.get(5)+1);
			}
		}
		
		while(b!=1) {
			if(b%2!=0 && b%3!=0 && b%5!=0) {
				break;
			}
			if(b%2==0) {
				b=b/2;
				mp2.put(2,mp2.get(2)+1);
			}
			else if(b%3==0) {
				b=b/3;
				mp2.put(3,mp2.get(3)+1);
			}
			else if(b%5==0) {
				b=b/5;
				mp2.put(5,mp2.get(5)+1);
			}
		}
		if(a!=b) {
			return -1;
		}
		
		counter+=Math.abs(mp1.get(2)-mp2.get(2));
		counter+=Math.abs(mp1.get(3)-mp2.get(3));
		counter+=Math.abs(mp1.get(5)-mp2.get(5));
		return counter;
	}
	
	public static void main(String[]args) {
		Scanner scan=new Scanner(System.in);
		int a=scan.nextInt();
		int b=scan.nextInt();
		FoxDividingCheese ob=new FoxDividingCheese();
		System.out.println(ob.equal(a, b));
	}
}
