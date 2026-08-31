import java.io.*;
import java.util.*;
public class Problem551B
{
   boolean DEBUG=false;

   public static void main(String[] args) throws Exception
   {
      new Problem551B();
   }
   public Problem551B() throws Exception{
      main();
   }   
   public void main() throws Exception{
      BufferedReader br;
      br = new BufferedReader(new InputStreamReader(System.in));
      PrintWriter pw = new PrintWriter(System.out);
      StringTokenizer st;
      st = getst(br);
      String a =st.nextToken();
      st = getst(br);
      String b =st.nextToken();
      st = getst(br);
      String c =st.nextToken();
      HashMap<Character, Integer> hA = hashify(a);
      HashMap<Character, Integer> hB = hashify(b);
      HashMap<Character, Integer> hC = hashify(c);
      String first="",second="";
      int numOccBC=numOccurances(hA,hB,hC);
      int numOccCB=numOccurances(hA,hC,hB);
      StringBuilder sb = new StringBuilder();
      int numB=numOccurances(hA,hB);
      int numC=numOccurances(hA,hC);
      while(numB>0 || numC>0)
      {
         if(numB>=numC)
         {
            sb.append(b);
            reduce(hA,hB,1);
            numB--;
            numC=numOccurances(hA,hC);
         }
         else{
            sb.append(c);
            reduce(hA,hC,1);
            numC--;
            numB=numOccurances(hA,hB);
         }
      }
      for(Character ch:hA.keySet())
      {
         for(int i=0; i<hA.get(ch); i++)
            sb.append(ch);
      }
      pw.println(sb.toString());
      pw.close();
   }
   public HashMap<Character, Integer> hashify(String a) 
   {
      HashMap<Character, Integer> h =new HashMap<Character, Integer>();
      for(Character ch:a.toCharArray())
      {
         if(!h.containsKey(ch))
            h.put(ch,1);
         else h.put(ch,h.get(ch)+1);
      }
      return h;
   }
   public int numOccurances(HashMap<Character, Integer> h,HashMap<Character, Integer> h1)
   {
      int numB=numReductions(h,h1);
      return numB;
   }
   public int numOccurances(HashMap<Character, Integer> h,HashMap<Character, Integer> h1, HashMap<Character, Integer> h2)
   {
      h=(HashMap<Character, Integer>)h.clone();
      int ct=0;
      int numB=numReductions(h,h1);
      reduce(h,h1,numB);
      int numC=numReductions(h,h2);
      return numB+numC;
   }
   public int numReductions(HashMap<Character, Integer> h1,HashMap<Character, Integer> h2)
   {
      int ct=Integer.MAX_VALUE;
      for(Character c:h2.keySet())
      {
         if(h1.containsKey(c))
         {
            int num = h1.get(c)/h2.get(c);
            if(ct>num) ct=num;
         }
         else ct=0;
      }
      return ct;
   }
   public void reduce(HashMap<Character, Integer> h1,HashMap<Character, Integer> h2, int ct)
   {
      if(ct<=0) 
         return;
      for(Character c:h2.keySet())
      {
         h1.put(c,h1.get(c)-(h2.get(c)*ct));
      }
   }
   public static StringTokenizer getst(BufferedReader br) throws Exception{
      return new StringTokenizer(br.readLine(), " ");
   }
   public static int nextInt(StringTokenizer st) throws Exception{
      return Integer.parseInt(st.nextToken());
   }

}