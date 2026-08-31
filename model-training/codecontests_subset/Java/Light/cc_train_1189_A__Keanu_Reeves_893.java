

import java.util.Scanner;

public class Keaven {
public static void main(String[] args) {
	Scanner scan=new Scanner(System.in);
	int one=scan.nextInt();
	String a=scan.next();
	int count0=0,count1=0;
	for(int i=0;i<a.length();i++) {
		if(a.charAt(i)=='0')count0++;
		if(a.charAt(i)=='1') count1++;
	}
if(count0!=count1)System.out.println(1+"\n"+a);
else System.out.println(2+"\n"+ a.substring(0,1)+" "+a.substring(1));
}
}
