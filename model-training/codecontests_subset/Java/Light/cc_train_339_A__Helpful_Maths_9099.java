import java.io.*;
import java.util.Scanner;
public class Solution {
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		if (System.getProperty("ONLINE_JUDGE") == null) {
			try {
				System.setOut(new PrintStream(
					new FileOutputStream("output.txt")));
				sc = new Scanner(new File("input.txt"));
			}
			catch (Exception e) {
			}
		}
		//problem code
		String s = sc.nextLine();
		int len=s.length();
		int i;
		int c1=0,c2=0,c3=0;
		char ch;
		StringBuilder sb=new StringBuilder("");
		for(i=0;i<len;i++){
			ch=s.charAt(i);
			if(ch=='+')
				continue;
			if(ch=='1')
				c1++;
			if(ch=='2')
				c2++;
			if(ch=='3')
				c3++;
		}
		i=0;
		while(i<c1){
			sb.append("1+");
			i++;
		}
		while(i<c1+c2){
			sb.append("2+");
			i++;
		}
		while(i<c1+c2+c3){
			sb.append("3+");
			i++;
		}
		sb.delete(sb.length()-1,sb.length());
		System.out.print(sb);
	}
}
