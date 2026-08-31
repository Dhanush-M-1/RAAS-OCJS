

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		int n,s[]=new int[2],s1[]=new int[2],s2[]=new int[2];
		String str="";
		n=sc.nextInt();
		sc.nextLine();
		str=sc.nextLine();
		char a;
		for(int i=0;i<str.length();i++) {
			a=str.charAt(i);
			if(a=='0') {
				s[0]++;
			}else {
				s[1]++;
			}
		}
		if(s[0]!=s[1]) {
			System.out.println("1"+"\n"+str);
			return;
		}
		s2[0]=s[0];
		s2[1]=s[1];
		for(int i=0;i<str.length();i++) {
			a=str.charAt(i);
			if(a=='1') {
				s1[1]++;
				s2[1]--;
			}else {
				s1[0]++;
				s2[0]--;
			}
			if(s1[0]!=s1[1]&&s2[0]!=s2[1]) {
				System.out.println("2"+"\n"+str.substring(0, i+1)+" "+str.substring(i+1));
				return;
			}
		}
	}
}
