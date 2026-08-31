import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Arrays;

public class HelpfulMaths {
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
	
	public static void main(String[] args)
    {
        FastReader s=new FastReader();
        String word1 = s.nextLine();
        int[] num1 = new int[(word1.length()+1)/2];
        int j = 0;
        for(int i = 0; i < word1.length(); i++){
        	if(word1.charAt(i) == '1' || word1.charAt(i) == '2' ||word1.charAt(i) == '3'){
        		num1[j] = Integer.parseInt(word1.charAt(i) + "");
        		j++;
        	}
        }
        Arrays.sort(num1);
        String bob = "";
        for(int k = 0; k < num1.length - 1; k++){
        	bob += "" + num1[k] + "+";
        }
        bob += num1[num1.length-1];
        System.out.println(bob);
    }
}