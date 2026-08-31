import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;


public class D{
	
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
	static StringBuilder st = new StringBuilder();
	
	public static boolean check(int sum[][],int n,int x)
	{	
		for(int i = 0; i < n; i+= x)
		{
			for(int j = 0; j < n; j+= x)
			{
				int bottomr = i+x-1;
				int bottomc = j+x-1;
				int csum = sum[bottomr][bottomc];
				
				if(i > 0) csum -= sum[i-1][bottomc];
				if(j > 0) csum -= sum[bottomr][j-1];
				if(i > 0 && j > 0) csum += sum[i-1][j-1];
				
				if(csum > 0 && csum < x*x) return false;
			}
		}
		return true;
	}
	public static void main(String[] args) 
	{
		OutputStream outputStream = System.out;
        FastReader sc = new FastReader();
        PrintWriter out = new PrintWriter(outputStream);
        int n = sc.nextInt();
		
		char [][] mat = new char [n][n] ; 
		int [][] sum2D = new int [n][n] ; 
		
		for(int i = 0 ; i < n ;i++)
		{
			char [] hex = sc.next().toCharArray();
			
			st = new StringBuilder(); 
			
			for(char x : hex)
			{
				String curr =  Integer.toBinaryString(Integer.parseInt(x+"", 16));
				
				while(curr.length() < 4) curr = "0" + curr ; 
				
				st.append(curr);
				
			}
			
			mat[i] = st.toString().toCharArray();
			//out.println(mat[i]);
		}
		for(int i = 0 ; i < n ;i++)
			for(int j = 0 ;j < n ; j++)
			{
				sum2D[i][j] = mat[i][j] - '0';

	            if (i > 0) sum2D[i][j] += sum2D[i - 1][j];
	            if (j > 0) sum2D[i][j] += sum2D[i][j - 1];
	            if (i > 0 && j > 0) sum2D[i][j] -= sum2D[i - 1][j - 1];
	  
			}
		
		/*for(int i = 0; i < n; i++)
		{	
			for(int j = 0; j < n; j++)
			{
				out.print(sum2D[i][j]+" ");
			}
			out.println();
		}*/
		
		for(int i = n; i >= 2; i--)
		{
			if(n%i == 0 && check(sum2D,n,i))
			{
				out.println(i);
				out.close();
				return;
			}
		}
		out.println(1);
		out.close();
		
	}

}
