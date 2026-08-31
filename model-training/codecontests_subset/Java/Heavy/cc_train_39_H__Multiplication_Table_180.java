import java.io.BufferedReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

import javax.swing.plaf.synth.SynthSpinnerUI;
public class q2 {
//	public static int gcd(int a, int b) 
//	{ return b==0 ? a : gcd(b, a%b); }
	
	public static void main(String[] args) throws IOException
    {				
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));	
		StringTokenizer st = new StringTokenizer(bf.readLine(), " ");
		int n=Integer.parseInt(st.nextToken());
		int x[][]=new int [n+1][n+1];
		for(int i=1;i<n+1;i++){
			x[i][0]=i;
		}
		for(int i=1;i<n+1;i++){
			x[0][i]=i;
		}
		for(int i=1;i<n+1;i++){
			for(int j=1;j<n+1;j++){
				if(j!=0&i!=0){
					x[i][j]=Integer.parseInt(Integer.toString(i*j,n));
				}
			}
		}
		
		for(int i=1;i<n;i++){
			for(int j=1;j<n;j++){
				if(j==1)
				System.out.print(x[i][j]);	
				else if(x[i][j]>9)
				System.out.print(" "+x[i][j]);
				else
				 System.out.print("  "+x[i][j]);
			}
			System.out.println();
		}
		
//		String s = Integer.toString(n, 2);
       
    }

}