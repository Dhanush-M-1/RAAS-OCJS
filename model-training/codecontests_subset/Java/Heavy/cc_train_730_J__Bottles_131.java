import java.util.*;
import java.math.BigInteger;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
public class Main {
	static StreamTokenizer in=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
	static PrintWriter out=new PrintWriter(new OutputStreamWriter(System.out));
	static int nextInt() throws IOException{
		in.nextToken();
		return (int)in.nval;
	}
	static int[][][] f=new int[105][105][10005];
	static int[] a=new int[105];
	static int[] b=new int[105];
	static int[] c=new int[105];
	static int[][] d=new int[105][105];
	static int dfs(int i,int k,int v){
		if(k>i)return 0;  
	    if(k<=0)return 0;  	  
	    if(i<1)return 0;   
	    if(v<=0) return 0;    
	    if(f[i][k][v]!=0)return f[i][k][v];  
	    f[i][k][v]=dfs(i-1,k-1,v-b[i])+a[i];  
	    if(d[i-1][k]>=v){  
	        f[i][k][v]=Math.max(f[i][k][v],dfs(i-1,k,v));  
	    }    
	    return f[i][k][v];  
	}
	public static void main(String args[])throws IOException{
		int n=nextInt();
		int sum=0;
		int sum2=0;
		int k=0;
		for(int i=1;i<=n;i++){
			a[i]=nextInt();
			sum+=a[i];
		}
		for(int i=1;i<=n;i++){
			b[i]=nextInt();	
			c[i]=-b[i];
		}
		int temp=0;
		for(int i=1;i<=n;i++){
			for(int j=1;j<=n-i;j++){
				if(b[j]>b[j+1]){
					temp=b[j];
					b[j]=b[j+1];
					b[j+1]=temp;
					temp=a[j];
					a[j]=a[j+1];
					a[j+1]=temp;
				}
			}
		}
		Arrays.sort(c);
		while(sum2<sum){
			k++;
			sum2-=c[k-1];
		}	
		for(int i=1;i<=n;i++){  
            d[i][1] =b[i];  
            for (int j=2;j<=i;j++){  
                d[i][j]=d[i][j-1]+b[i-j+1];  
            }  
        }
		out.println(k+" "+(sum-dfs(n,k,sum)));
		out.flush();
	}
}

			 	 		 		  		 		 						    	