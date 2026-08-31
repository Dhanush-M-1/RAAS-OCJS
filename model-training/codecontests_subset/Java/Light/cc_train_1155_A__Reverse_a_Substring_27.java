import java.util.Scanner;
import java.io.*;
public class ECRA {
	public static void main(String args[]) 
	throws java.io.IOException{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		String str = sc.nextLine();
		char forchange='a';
		int idx=0;
		boolean flag=true;
		for(int i=0; i<n;i++) {
			if(str.charAt(i)!='a') {
				forchange=str.charAt(i);
				idx=i;
				break;
			}
			
		}
		for(int i=idx; i<n;i++) {
			if(str.charAt(i)<forchange) {
				System.out.println("YES");
				System.out.println((idx+1)+" "+(i+1));
				flag=false;
				break;
			}
			else {
				idx=i;
				forchange=str.charAt(i);
			}
		}
		if(flag) {
			System.out.println("NO");
		}
	}

}
