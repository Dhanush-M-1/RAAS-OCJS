import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		int t=scn.nextInt();
		while(t-->0) {
			String str=scn.next();
			char []arr=str.toCharArray();
			int count=0;
			for(int i=1;i<arr.length;i++) {
				if(arr[i]==arr[i-1]) {//remove palindromes of length 2
					arr[i]='@';
					count++;
				}else {
					if(i>1&&arr[i]==arr[i-2]) {
						arr[i]='@';
						count++;
					}
				}
			}
			System.out.println(count);
		}
	}
}