import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.IntStream;

/**
 *
 * @author Aniis
 */
public class Main {

    public static void main(String[] args) {
        InputStream inputStream = null;
        /*    try {
            inputStream = new FileInputStream("test.txt");
        } catch (IOException e) {
           throw new RuntimeException(e);
        }*/
        OutputStream outputStream = System.out;
        FastScanner in = new FastScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        FuckTheWorld solver = new FuckTheWorld();
        solver.solve(1, in, out);
        out.close();
    }

static boolean allCharactersSame(String s) 
{ 
    int n = s.length(); 
    for (int i = 1; i < n; i++) 
        if (s.charAt(i) != s.charAt(0)) 
            return false; 
          
    return true; 
} 
 static long countDivisibles(long A, long B, long K) {
long firstDivisible = A%K == 0 ? A : A + (K - A%K);
        long lastDivisible = B%K == 0 ? B : B - B%K; //B/K behaves this way by default.
        return (lastDivisible - firstDivisible)/K + 1;
    }
  static String join(String x, String y){

   Set<Character> cx=new HashSet<Character>();
   Set<Character> cy=new HashSet<Character>();

   for (int k=0;k<x.length();k++)
       cx.add(x.charAt(k));

   for (int k=0;k<y.length();k++)
       cy.add(y.charAt(k));

   String result="";

   for (Character common: cx)
       if (cy.contains(common))
           result+=common;

   return result;
 }
   static String swap(String str, int i, int j) 
    { 
        if (j == str.length() - 1) 
            return str.substring(0, i) + str.charAt(j) 
             + str.substring(i + 1, j) + str.charAt(i); 
  
        return str.substring(0, i) + str.charAt(j) 
               + str.substring(i + 1, j) + str.charAt(i)  
               + str.substring(j + 1, str.length()); 
    }
   static int count(final String string, final String substring)
  {
     int count = 0;
     int idx = 0;

     while ((idx = string.indexOf(substring, idx)) != -1)
     {
        idx++;
        count++;
     }

     return count;
  }
   static  int search(String a)
{
	int ans = 0;
	for(int i=1;i<a.length();i++)
	{
		int flag = 1;
		for(int j=i;j<a.length();j++)
		{
			if(a.charAt(j)!=a.charAt(j-i))
			{
				flag = 0;
				break;
			 } 
		}
			ans = i;
		if(flag ==1) 
		{
			return ans; 
		}
	}
	return ans+1;
}
   
static int countUniqueCharacters(String input) {
    boolean[] isItThere = new boolean[Character.MAX_VALUE];
    for (int i = 0; i < input.length(); i++) {
        isItThere[input.charAt(i)] = true;
    }

    int count = 0;
    for (int i = 0; i < isItThere.length; i++) {
        if (isItThere[i] == true){
            count++;
        }
    }

    return count;
}
 static int count(String s, char c) 
    { 
        int res = 0; 
  
        for (int i=0; i<s.length(); i++) 
        { 
            // checking character in string 
            if (s.charAt(i) == c) 
            res++; 
        }  
        return res; 
    } 
    static class FuckTheWorld {

      public void solve(int testNumber, FastScanner in, PrintWriter out) {
    
          int n = in.nextInt();
          int []a = new int[n];
          int []b = new int[n];
          for (int i = 0; i < n; i++) {
              a[i] = in.nextInt();
          }
          int sum1 = IntStream.of(a).sum();
          Arrays.sort(a);
          int p = a[n-1];
          outerloop:
          while(IntStream.of(b).sum()<=sum1){
              
              for (int i = 0; i < n; i++) {
                  b[i]=p-a[i];
              }
              if(IntStream.of(b).sum()>sum1) {break outerloop;}
              else 
              p++;
          }

          System.out.println(p);
       
      }    
    }
    static class FastScanner {

        private BufferedReader br;
        private StringTokenizer st;

        public FastScanner(InputStream inputStream) {
            //br = new BufferedReader (new InputStreamReader(inputStream));
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }
    }
}