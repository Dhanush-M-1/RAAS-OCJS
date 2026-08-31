import java.util.*;
import java.io.*;
import static java.lang.Math.*;
 
public class GenericProblem
{
	/*
	 * This FastReader code is taken from GeeksForGeeks.com
	 * https://www.geeksforgeeks.org/fast-io-in-java-in-competitive-programming/
	 * 
	 * The article was written by Rishabh Mahrsee
	 */
	public static class FastReader 
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

	
	public static FastReader file = new FastReader();
	public static PrintWriter out = new PrintWriter(System.out);

	public static void main(String[] args)
	{
		double a = file.nextInt(), b = file.nextInt(), c = file.nextInt();
		
		if (a == 0 && b == 0 && c == 0)
		{
			out.println(-1);
			out.close();
			return;
		}
		
		if (a == 0 && b == 0)
		{
			out.println(0);
			out.close();
			return;
		}
		
		if (a == 0)
		{
			out.println(1);
			out.printf("%.15f\n", -c / b);
			out.close();
			return;
		}
			
		
		double discriminant = b*b - 4*a*c;
		
		if (discriminant < 0)
		{
			out.println(0);
		}
		else if (discriminant == 0)
		{
			out.println(1);
			out.printf("%.15f\n", -b / (2 * a));
		}
		else
		{
			out.println(2);
			double[] roots = new double[2];
			
			roots[0] = (-b + Math.sqrt(discriminant)) / (2 * a);
			roots[1] = (-b - Math.sqrt(discriminant)) / (2 * a);
			
			Arrays.sort(roots);
			
			out.printf("%.15f\n", roots[0]);
			out.printf("%.15f\n", roots[1]);
		}
		
		out.close();
	}


}