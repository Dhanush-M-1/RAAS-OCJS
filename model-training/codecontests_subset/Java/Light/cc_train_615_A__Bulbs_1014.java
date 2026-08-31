import java.util.*;
//import java.math.*;

/*Author LAVLESH*/
public class solution
{  	public static void main(String[]args){
    Scanner in=new Scanner(System.in); 
	int n=in.nextInt(); 
    int m=in.nextInt();
    int i,j=0,q,count=0;
    int[]a=new int[m*m];
    for(i=0;i<m*m;i++)
    a[i]=0;
    for(i=0;i<n;i++)		
    	{int p=in.nextInt();
    	  while(p>0&&j<m*m){a[j]=in.nextInt();p--;j++;}
    	}
    
    for(j=1;j<=m;j++)
    {  count=0;
    	for(i=0;i<m*m;i++)
    	{if(a[i]==j){count=1;break;}}
       if(count==0) break;  
    }
    if(count==0)System.out.print("NO");
    else System.out.print("YES");
}}