import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ExecutionException;

import javax.management.Query;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import java.util.PriorityQueue;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.Double.parseDouble;

public class Solution { 
 	static  int mod=1000000007;
 	static int count=1;
	public static void main(String[] args) throws IOException, InterruptedException {
		PrintWriter out=new PrintWriter(System.out); 
		BufferedReader br=new  BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
	    //reviser complement 2
		//hexadecimal
	    st=new StringTokenizer(br.readLine());
	    int n=parseInt(st.nextToken());
	    int k=parseInt(st.nextToken());
	    int[] arr=new int[n];
	    st=new StringTokenizer(br.readLine());
	    int h_min=Integer.MAX_VALUE;
	    for(int i=0 ; i < n; ++i){
	    	arr[i]=parseInt(st.nextToken());
	    	if(k%arr[i] == 0 && k/arr[i] < h_min  ) h_min=k/arr[i];
	    }
	    out.println(h_min);
	    
	    
	    		
	    
			   
		
		
		
		out.close();
		
	
	
	
	
	}
	
	static void color(LinkedList<Integer>[] list,int[] color,  int parent){
		
		for(int i=0; i < list[parent].size(); ++i){
			if(color[parent] != color[list[parent].get(i)]){
				++count;
				//System.out.println(parent+":             "+list[parent].get(i));
			
			}
			try{
				color(list, color, list[parent].get(i));
			}catch(Exception e){
				System.out.println(parent+"    "+list[parent].get(i)+"   "+e.getMessage());
				
			}
			
			
		}	
		/*for(int i=0 ; i < list[child].size();++i){
			if(color[child] != color[list[child].get(i)]){
				System.out.println(child+":             "+list[child].get(i));
					color(list, color, list[child].get(i));
			}
		}*/
	}
	static boolean answer(int n){
		if(n < 0) return false;
		else if(n == 0) return true;
		return (answer(n - 3) || answer(n - 7));
		
	}
	static int[][] createMatrix(int n, int m){
		int[][] matrix=new int[n][m];
		for(int i=0 ; i < n   ;++i){
			for(int k = 0; k < m;++k){
				if(k==0 || k==1) matrix[i][k]=i*m + k+1;
				else if (i%2 == 0){
					int inter=matrix[i][k-2];
					matrix[i][k] = inter;
					matrix[i][k-2]=i*m + k+1;
				}else{
					matrix[i][k]=i*m + k+1;
				}
			}
		}
		
		
		for(int i = 1; i < n; i+=2){
			for(int k=0; k < m; k+=2){
				int inter=matrix[i][k];
				matrix[i][k]=matrix[i-1][k];
				matrix[i-1][k]=inter;
			}
		}
		return matrix;
	}
	static boolean nim_game(int n){
		int[] win_pos=new int[]{2, 3, 5, 4};
		if(n > 0){
			for(int x: win_pos){
				if(x == n) return true;
			}
			if(n == 1) return false;
			if(!nim_game(n - 5)|| !nim_game(n - 3)|| !nim_game(n - 2)) return true;
		}
		return false;
	}
	static int xor_range(int n){
		if(n == 0) return 0;
		int r= n% 4;
		if(r == 0) return n; 
		if(r == 1) return 1;
		if(r == 2) return n+1;
		return 0;
	}
	static void sol(int[] arr, int index, int time, int k, HashMap<Integer, Integer> map, int sum){
		if( time == k+1){ 
				if(map.containsKey(sum)) map.put(sum, map.get(sum) + 1);
				else map.put(sum, 1);
		}
		
		if(time <= k){
			for(int i=index ; i  < arr.length; ++i){
				sol(arr, i + 1 , time + 1 , k, map, sum + arr[i]);
			}
		}
	}
	
	static int combinaison(double n, double k){//c(n, k)= (k+1)/(n-k)
		double res= 1;
		for(int i= 1; i<=k; ++i){
			res *= (n-i+1)/(i);
		}
		return (int)res;
	}
	static int countmin(int a, int b, int c){
		//Given a sequence of three binary sequences A, B and C of N bits. Count the minimum bits
		//required to flip in A and B such that XOR of A and B is equal to C
		int res= a ^ b ^ c;
		int count=0;
		while(res != 0){
			++count;
			res&=res - 1;
		}
		return count;
	}
	static int countval(int n){//Given a positive integer n, find count of positive integers i such that 0 <= i <= n and n+i = n^i
		int count=0;
		while(n != 0){
			if((n & 1) == 0) ++count;
		}
		return 1<<count;
	}
	static int firstright(int x){
		
		int y=1;
		int pos=1;
		while((x&y) == 0){
			pos++;
			y<<=1;
		}
		return pos;
	}
	
	static int atob(int a, int b){
		int c= a^b;
		int count=0;
		while(c != 0){
			c&=(c-1);
			++count;
		}
		return count;
	}
	  
	
	static int setBits(int x){
		int count=0;
		if(x == 0) return 0;
		while(x != 0){
			if(x % 2 == 1){
				--x;
				++count;
			}
			x/=2;
			
		}
		return count;
	}
	static boolean isPower4(long x){
			if((x & (x-1)) != 0) return false;
			int count=0;
			while(x != 1){
				x>>=1;
				++count;
			}
			
			if(count % 2 == 0) return true;
			return false;
	
	}
	
	
	
	static long addOne(long x){// add one using bit manipulation
	    long y = 1; 
		while((x & y) != 0){
			x ^= y;
			y<<=1;
		}
		
		return x ^ y;
	}
	
	static int compute_xor_range(int n){// compute xor from 1 to n
		int r= n % 4;
		if(r== 0) return n;
		else if(r== 1) return 1;
		else if(r== 2) return n+1;
		else return 0;
				
	}
	
	static long number_combinaisons(long n){//n cardinal of set 
		//fonction return number of combinaisons
		return (1 << n) ;
	}
	
	static boolean isPoweroftwo(long x){
		//check a number is power of two 
		//we use x & (x-1) to eliminate the first set bit
		
		return (x!=0 && (x & (x-1)) == 0)?true:false;
	}
	
	static long findxor(long[] Set,long n){// this function find xor of xor's of all subsets
		//n is length of set array
		if(n >1 ) return 0;
		else return Set[0];
	}
	// pour generer un nombre entier a partir de binaire int a=0b111;
	
	static long MSB(long n){// most significant bit
		while((n&(n-1)) != 0){
			n &= n-1;
		}
		return n;
	}
	
	static long LSB(long n){
	      if(n == 0) return 0;
	      return n-(n & (n-1));
	}
	
	
	 
	
		
}




