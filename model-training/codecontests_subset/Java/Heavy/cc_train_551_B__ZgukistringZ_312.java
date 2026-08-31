
import java.util.*;
import java.io.*;

public class B
{
   public static void main(String[] args)
   {
      PrintWriter out = new PrintWriter(System.out);
      new B(new FastScanner(), out);
      out.close();
   }

   int[] getFreq(char[] cs)
   {
      int[] freq = new int[26];
      for (char c : cs)
         freq[c-'a']++;
      return freq;
   }

   public B(FastScanner in, PrintWriter out)
   {
      char[] s = in.next().toCharArray();
      int[] f1 = getFreq(s);
      char[] s1 = in.next().toCharArray(), s2 = in.next().toCharArray();
      int[] f2 = getFreq(s1);
      int[] f3 = getFreq(s2);
  
      int res = 0, bestNumA = 0, bestNumB = 0;
      int[] tmp = new int[26];
      int numA = 0;
      while (true)
      {
         boolean passed = true;
         for (int i=0; i<26; i++) if((tmp[i] = f1[i] - numA*f2[i]) < 0)
            passed = false;
         if (!passed) break;
      
         int numB = Integer.MAX_VALUE;
         for (int i=0; i<26; i++) if (f3[i] > 0)
            numB = Math.min(numB, tmp[i] / f3[i]);
      
         int rr = numA + numB;
         if (rr > res)
         {
            res = rr;
            bestNumA = numA;
            bestNumB = numB;
         }

         numA++;
      }

      for (int i=0; i<26; i++)
         f1[i] -= (bestNumA*f2[i]+bestNumB*f3[i]);
      int ptr = 0;
      while (bestNumA-->0)
         for (char c : s1)
            s[ptr++] = c;
      while (bestNumB-->0)
         for (char c : s2)
            s[ptr++] = c;
   
      for (int i=0; i<26; i++)
         while (f1[i]-->0)
            s[ptr++] = (char)(i+'a');
      out.println(new String(s));
   }
}

class FastScanner{
   private InputStream stream;
   private byte[] buf = new byte[1024];
   private int curChar;
   private int numChars;

   public FastScanner()
   {
      stream = System.in;
   }

   int read()
   {
      if (numChars == -1)
         throw new InputMismatchException();
      if (curChar >= numChars){
         curChar = 0;
         try{
            numChars = stream.read(buf);
         } catch (IOException e) {
            throw new InputMismatchException();
         }
         if (numChars <= 0)
            return -1;
      }
      return buf[curChar++];
   }

   boolean isSpaceChar(int c)
   {
      return c==' '||c=='\n'||c=='\r'||c=='\t'||c==-1;
   }
   
   boolean isEndline(int c)
   {
      return c=='\n'||c=='\r'||c==-1;
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

   String next(){
      int c = read();
      while (isSpaceChar(c))
         c = read();
      StringBuilder res = new StringBuilder();
      do{
         res.appendCodePoint(c);
         c = read();
      }while(!isSpaceChar(c));
      return res.toString();
   }
   
   String nextLine(){
      int c = read();
      while (isEndline(c))
         c = read();
      StringBuilder res = new StringBuilder();
      do{
         res.appendCodePoint(c);
         c = read();
      }while(!isEndline(c));
      return res.toString();
   }
}
