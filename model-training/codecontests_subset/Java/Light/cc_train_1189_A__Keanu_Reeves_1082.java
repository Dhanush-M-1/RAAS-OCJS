import java.util.*;
import java.io.*;
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			int n = sc.nextInt();
			String str = sc.next();
			char [] s = str.toCharArray();
			int sum1=0;int sum2=0;
			for(int i=0;i<s.length;i++) {
				if(s[i]-'0'==0) {
					sum1++;
				}
				else {
					sum2++;
				}
			}
			if(sum1!=sum2) {
				System.out.println(1);
				System.out.println(str);
			}
			else {
				System.out.println(2);
				System.out.println(s[0]+" "+str.substring(1));
			}
		}
	}

}
