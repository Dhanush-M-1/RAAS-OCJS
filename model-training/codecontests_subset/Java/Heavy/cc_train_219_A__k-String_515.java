import java.io.*;
import java.util.*;
import java.util.TreeSet;
import java.lang.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class abc{
	public static void main(String args[]){
		Scanner in=new Scanner(System.in);
		int k=in.nextInt(),i,j;
		String z=in.next();
		int l=z.length();
		int []a=new int[26];
		for(i=0;i<l;i++){
			a[(int)(z.charAt(i)-'a')]++;
		}
		StringBuilder sb=new StringBuilder();
		StringBuilder sb1=new StringBuilder();
		int flag=0;
		for(i=0;i<26;i++){
			if(a[i]%k!=0){
				flag=-1;
				break;
			}
			for(j=0;j<a[i]/k;j++){
				char c=(char)(i+97);
				sb.append(c);
			}
		}
		for(i=0;i<k;i++){
			sb1=sb1.append(sb);
		}
		if(flag!=-1)
			System.out.println(sb1.toString());
		else
			System.out.println(-1);
	}
}