import java.util.*;
public class GFG {
	public static void main (String[] args) {
	Scanner sc=new Scanner(System.in);
	long t=sc.nextLong();
	while (t-->0)
	{
	    int n=sc.nextInt();
	    int m=sc.nextInt();
	    String s=sc.next();
	    long p[]=new long[m];
	    long fre[][]=new long[26][n];
	    for(int i=0;i<m;i++)
	    p[i]=sc.nextLong();
	    for(char i='a';i<='z';i++)
	    {
	        for(int j=0;j<n;j++){
	        if(j==0&&s.charAt(j)==i){
	        fre[(int)i-97][j]=1;continue;}
	        if(j!=0&&s.charAt(j)==i){
	        fre[(int)i-97][j]=fre[(int)i-97][j-1]+1;continue;}
	        if(j!=0&&s.charAt(j)!=i)
	        fre[(int)i-97][j]=fre[(int)i-97][j-1];
	        }
	    }
	    /*for(long i=0;i<26;i++)
	    {
	        for(long j=0;j<n;j++)
	        System.out.prlong(fre[i][j]+" ");
	        System.out.prlongln();
	    }*/
	    long ans[]=new long[26];
	    for(int i=0;i<m;i++)
	    {
	        for(int j=0;j<26;j++)
	        ans[j]=ans[j]+fre[j][(int)p[i]-1];
	    }
	    for(int i=0;i<n;i++)
	    ans[(int)s.charAt(i)-97]++;
	    for(long i:ans)
	    System.out.print(i+" ");
	    System.out.println();
	}
	}
}