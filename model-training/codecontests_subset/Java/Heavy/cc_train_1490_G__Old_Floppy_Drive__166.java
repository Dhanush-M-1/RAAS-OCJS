/*
 * akshaygupta26
 */
import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.Scanner; 
import java.util.Random;
import java.util.Arrays;
import java.util.StringTokenizer; 
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Collections;

public class G 
{ 
	static class Pair{
		int in;
		long val;
		Pair(int i,long v){
			in=i;
			val=v;
		}
	}
    public static void main(String[] args) 
	{ 
		FastReader sc=new FastReader(); 
		StringBuffer ans=new StringBuffer();
		int test=sc.nextInt();
		while(test-->0)
		{
			int n=sc.nextInt(),m=sc.nextInt();
			long arr[]=new long[n];
			long sum=0l;
			ArrayList<Pair> vals=new ArrayList<>();
			long lastGreatest=Long.MIN_VALUE;
			for(int i=0;i<n;i++) {
				arr[i]=sc.nextLong();
				sum+=arr[i];
				if(sum>lastGreatest) {
					vals.add(new Pair(i,sum));
					lastGreatest=sum;
				}
			}
			int valn =vals.size();
			long pre[]=new long[n];
			pre[0]=arr[0];
			for(int i=1;i<n;i++)
			{
				pre[i]=pre[i-1]+arr[i];
			}
			
			while(m-->0) {
				long val=sc.nextLong();
				
				if(sum<=0 || val<=lastGreatest) {
					int res= bins(vals,valn,val);
					
					ans.append(res+" ");
					continue;
				}
				
				
				/*
				 * sum*rot + lastVal >= val
				 * rot >= (val-lastGreatest)/sum;
				 */
				
				
				
				long rot =(long)Math.ceil((double)(val-lastGreatest)/(double)sum);
//				System.out.println("Rotations: "+rot);
				long res= (Math.min(rot,1)*((long)(n-1)));
				if(rot>1)
					res+=((rot-1)*((long)(n)));
				long residual =val-(sum*rot);
				if(residual == 0 && rot>0) {
					ans.append(res+" ");
					continue;
				}
				int index =bins(vals,valn,residual);
				if(res == 0) {
					res=index;
				}
				else {
					res+=(index+1);
				}
				ans.append(res+" ");
			}
			
			ans.append("\n");
		
		}
		
	    System.out.print(ans);
	} 
    static int bins(ArrayList<Pair> vals,int n,long sum) {
    	int low= 0;
    	int high =n-1;
    	int ans=-1;
    	while(low<=high) {
    		int mid =(low+high)/2;
    		if(vals.get(mid).val>=sum) {
    			ans=vals.get(mid).in;
    			high=mid-1;
    		}
    		else {
    			low=mid+1;
    		}
    	}
    	return ans;
    }
    
    static final Random random=new Random();
    
	static void ruffleSort(int[] a) {
		int n=a.length;//shuffle, then sort 
		for (int i=0; i<n; i++) {
			int oi=random.nextInt(n), temp=a[oi];
			a[oi]=a[i]; a[i]=temp;
		}
		Arrays.sort(a);
	}
	
	static void ruffleSort(long[] a) {
		int n=a.length;//shuffle, then sort 
		for (int i=0; i<n; i++) {
			int oi=random.nextInt(n);
			long temp=a[oi];
			a[oi]=a[i]; a[i]=temp;
		}
		Arrays.sort(a);
	}
	
	static class FastReader 
	{ 
		BufferedReader br; 
		StringTokenizer st; 

		public FastReader() 
		{ 
			br = new BufferedReader(new
					InputStreamReader(System.in)); 
		} 

		String next() 
		{ 
			while (st == null || !st.hasMoreElements()) 
			{ 
				try
				{ 
					st = new StringTokenizer(br.readLine()); 
				} 
				catch (IOException e) 
				{ 
					e.printStackTrace(); 
				} 
			} 
			return st.nextToken(); 
		} 

		int nextInt() 
		{ 
			return Integer.parseInt(next()); 
		} 

		long nextLong() 
		{ 
			return Long.parseLong(next()); 
		} 

		double nextDouble() 
		{ 
			return Double.parseDouble(next()); 
		} 

		String nextLine() 
		{ 
			String str = ""; 
			try
			{ 
				str = br.readLine(); 
			} 
			catch (IOException e) 
			{ 
				e.printStackTrace(); 
			} 
			return str; 
		} 
	} 


} 
