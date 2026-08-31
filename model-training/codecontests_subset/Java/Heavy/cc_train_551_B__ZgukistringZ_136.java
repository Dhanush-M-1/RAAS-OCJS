import java.util.*;
public class Main {
public static void main(String [] args){
	Scanner in=new Scanner(System.in);
	String a1=in.next();
	String b1=in.next();
	String c1=in.next();
	
	int a[]=new int[26];
	int b[]=new int[26];
	int c[]=new int[26];
	for(int i=0;i<a1.length();i++)
		a[a1.charAt(i)-'a']++;
	for(int i=0;i<b1.length();i++)
		b[b1.charAt(i)-'a']++;
	for(int i=0;i<c1.length();i++)
		c[c1.charAt(i)-'a']++;
		
		int min=100005;
		int min1=100005;
		boolean flag=true;
		boolean flag1=true;
	for(int i=0;i<26;i++){
		if(a[i] < b[i])flag=false;
		if(a[i] < c[i])flag1=false;
		if(b[i] > 0)
		min=Math.min(min,a[i]/b[i]);
		if(c[i] > 0)
		min1=Math.min(min1,a[i]/c[i]);
	}
	//System.out.println(flag +" "+flag1);
	 StringBuilder sb=new StringBuilder();
	 if(!flag1 && !flag){
	 	System.out.print(a1);
	 }
	 if(flag1 && !flag){
	 	for(int i=0;i<min1;i++){
	 		sb.append(c1);
	 	}
	 	for(int i=0;i<26;i++){
	 		for(int j=0;j<a[i]-min1*c[i];j++)sb.append((char)(i+97));
	 	}
	 	System.out.print(sb);
	 }
	 if(!flag1 && flag){
	 	for(int i=0;i<min;i++)sb.append(b1);
	 	for(int i=0;i<26;i++)
	 		for(int j=0;j<a[i]-min*b[i];j++)sb.append((char)(i+97));
	 		System.out.print(sb);
	 }
	 if(flag && flag1){
	 	int cnt=0;
	 	int ansB=0;int ansC=0;
	 	for(int i=0;i<=min;i++){
	 		flag=true;
	 		int var=10000000;
	 		for(int j=0;j<26;j++){
	 			cnt=a[j]-i*b[j];
	 		    if(c[j] > 0)var=Math.min(var,cnt/c[j]);
	 		}
	 		if(ansB + ansC < i+var){
	 			ansB=i;ansC=var;
	 		}
	 	}
	 	//System.out.println(ansB+" "+ansC);
	 	for(int i=0;i<ansB;i++)sb.append(b1);
	 	for(int i=0;i<ansC;i++)sb.append(c1);
	 	for(int i=0;i<26;i++)for(int j = 0;j < a[i] - ansB*b[i] - ansC*c[i];j++)sb.append((char)(i+97));
	 	System.out.print(sb);
	 }
	}
}