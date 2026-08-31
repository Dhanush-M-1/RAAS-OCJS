import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.Scanner; 
import java.util.StringTokenizer; 
import java.util.HashMap;

public class Main
{   static class FastReader 
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
	
    public static void main(String [] args)
    {  
        FastReader fr=new FastReader();
        int testcases=fr.nextInt();
     asg:   while(testcases>0)
        {
            int n=fr.nextInt();
            int m=fr.nextInt();
            
            HashMap <Integer,Integer> alaska=new HashMap<Integer,Integer>();
            for(int i=0;i<n;i++)
            {
                alaska.put(fr.nextInt(),1);
            }
             int [] nums=new int[m];
             for(int i=0;i<m;i++)
             {
                 nums[i]=fr.nextInt();
             }
             for(int i=0;i<m;i++)
             {
                 int x=nums[i];
                  
                 if(alaska.containsKey(x))
                 {
                     System.out.println("Yes");
                     System.out.println("1 "+x);
                      testcases--;
                      continue asg;
                 }
                 
             }
             
            System.out.println("No");
            
            
            
            
            testcases--;
        }
        
        
        
        
        
    }
}