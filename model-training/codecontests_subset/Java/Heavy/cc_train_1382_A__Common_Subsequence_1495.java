import java.util.*;
import java.lang.*;
import java.io.*;
public class Main
{
	public static void main (String[] args) throws java.lang.Exception
	{
	   // Scanner sc=new Scanner(System.in);
		FastReader sc=new FastReader(); 
		Writer w=new PrintWriter(System.out);
		int t=sc.nextInt();
		while(t-->0){
		    HashMap<Integer,Integer> map=new HashMap<>();
		    int n=sc.nextInt();int m=sc.nextInt();
		    int[] a=new int[n];int[] b=new int[m];
		    for(int i=0;i<n;i++){
		        a[i]=sc.nextInt();
		        map.put(a[i],1);
		    }
		  //  Arrays.sort(a);
		  int f=0,v=0;
		    for(int i=0;i<m;i++){
		        
		        b[i]=sc.nextInt();
		        if(f==0 && map.containsKey(b[i])){f=1;v=b[i];}
		    }
		  //  Arrays.sort(a);
		  if(f==0)
		    System.out.println("NO");
		    else{
		        System.out.println("YES");
		        System.out.println("1 "+v);
		    }
		}
		w.flush();
		w.close();
	}
}
class FastReader 
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
                catch (IOException  e) 
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