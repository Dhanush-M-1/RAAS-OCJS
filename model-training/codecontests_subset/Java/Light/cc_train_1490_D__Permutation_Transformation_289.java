import java.util.*;
import java.lang.*;
import java.io.*;
 
public class Codechef
{
    public static void cal(int a[],int d[],int i,int j,int k){
        if(i>j){
            return ;
        }
        if(i==j){
            d[i]=k;
            return;
        }
        int max=i;
        for(int x=i;x<=j;x++){
            if(a[max]<a[x]){
                max=x;
            }
        }
        d[max]=k;
        cal(a,d,i,max-1,k+1);
        cal(a,d,max+1,j,k+1);
        
    }
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner scan=new Scanner(System.in);
        int t=scan.nextInt();
        while(t-- !=0){
            int n=scan.nextInt();
            int a[]=new int[n];
            int d[]=new int[n];
            for(int i=0;i<n;i++){
                a[i]=scan.nextInt();
            }
            cal(a,d,0,n-1,0);
            for(int i=0;i<n;i++){
                System.out.print(d[i]+" ");
            }
            System.out.println();
        }
	}
}