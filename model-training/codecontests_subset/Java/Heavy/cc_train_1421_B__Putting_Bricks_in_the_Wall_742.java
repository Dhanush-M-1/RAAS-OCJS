import java.util.*;
import java.io.*;

public class codeforces 
{
    public static void main (String[] args) 
    {
        FastReader scn = new FastReader();
        int t = scn.nextInt();
        // int t = 1;
        
        while(t > 0)
        {
            int n = scn.nextInt();
            int startright = -1;
            int startdown = -1;
            int finishup = -1;
            int finishleft = -1;
            for(int i=0; i<n; i++)
            {
                String s = scn.nextLine();

                if(i == 0) startright = s.charAt(1) - '0';
                if(i == 1) startdown = s.charAt(0) - '0';
                if(i == n-2) finishup = s.charAt(n - 1) - '0';
                if(i == n-1) finishleft = s.charAt(n - 2) - '0';
            }

            if(startdown == 0 && startright == 0)
            {
                if(finishleft == 0 && finishup == 0)
                {
                    System.out.println(2);
                    System.out.println(1 + " " + 2);
                    System.out.println(2 + " " + 1);
                }
                else if(finishleft == 1 && finishup == 1)
                {
                    System.out.println(0);
                }
                else
                {
                    System.out.println(1);
                    if(finishleft == 0) System.out.println(n + " " + (n-1));
                    else System.out.println((n-1) + " " + n);
                }
            }
            else if(startdown == 1 && startright == 1)
            {
                if(finishleft == 0 && finishup == 0)
                {
                    System.out.println(0);
                }
                else if(finishleft == 1 && finishup == 1)
                {
                    System.out.println(2);
                    System.out.println(1 + " " + 2);
                    System.out.println(2 + " " + 1);
                }
                else
                {
                    System.out.println(1);
                    if(finishleft == 1) System.out.println(n + " " + (n-1));
                    else System.out.println((n-1) + " " + n);
                }
            }
            else
            {
                if(finishleft == 0 && finishup == 0)
                {
                    System.out.println(1);
                    if(startdown == 0) System.out.println(2 + " " + 1);
                    else System.out.println(1 + " " + 2);
                }
                else if(finishleft == 1 && finishup == 1)
                {
                    System.out.println(1);
                    if(startdown == 1) System.out.println(2 + " " + 1);
                    else System.out.println(1 + " " + 2);
                }
                else
                {
                    System.out.println(2);
                    if(startdown == 0)
                    {
                        System.out.println(2 + " " + 1);
                        if(finishleft == 1)
                        {
                            System.out.println(n + " " + (n - 1));
                        }
                        else
                        {
                            System.out.println((n-1) + " " + (n));
                        }
                    }
                    else
                    {
                        System.out.println(1 + " " + 2);
                        if(finishleft == 1)
                        {
                            System.out.println(n + " " + (n - 1));
                        }
                        else
                        {
                            System.out.println((n-1) + " " + (n));
                        }
                    }
                }
            }

            t--;
        }
    }

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
}