import java.io.*;
import java.math.BigInteger;
import java.util.*; 

public class Main { 
   private void solve() {
      ArrayList<String> patterns = new ArrayList<>();
      ArrayList<Integer> numbers = new ArrayList<>();
      
      int n = nextInt();
      String s = next();
      
      for(int i = 0; i < n-1; i++) {
         String sub = s.substring(i, i+2);
         if(!patterns.contains(sub)) {
            patterns.add(sub);
            numbers.add(1);
         } else {
            int index = patterns.indexOf(sub);
            numbers.set(index, numbers.get(index)+1);
         }
      }
      
      int max = 0;
      for(int i = 0; i < numbers.size(); i++) {
         if(numbers.get(i) > max) max = numbers.get(i);
      }
      
      int index = numbers.indexOf(max);
      out.println(patterns.get(index));
   }
   
   public static void main(String[] args) { 
         new Main().run(); 
   } 

   BufferedReader br; 
   StringTokenizer st; 
   PrintWriter out; 

   private void run() { 
         try { 
            br = new BufferedReader(new InputStreamReader(System.in )); 
            out = new PrintWriter(System.out); 
            //br = new BufferedReader(new FileReader("birthday.in ")); 
            //out = new PrintWriter(new FileWriter("birthday.out")); 
            solve(); 
            br.close(); 
            out.close(); 
         } catch (IOException e) { 
            e.printStackTrace(); 
         } 
   } 

   private int nextInt() { 
      return Integer.parseInt(next()); 
   } 

   private String next() { 
      while (st == null || !st.hasMoreTokens()) { 
         try { 
            st = new StringTokenizer(br.readLine()); 
         } catch (IOException e) { 
            e.printStackTrace(); 
            return "END_OF_FILE"; 
         } 
      } 
      return st.nextToken(); 
   } 
   
   private int[] nextIntArr(int n) {
      int[] arr = new int[n];
      for(int i = 0; i < n; i++) arr[i] = nextInt();
      return arr;
   }
   
   private String[] nextArr(int n) {
      String[] arr = new String[n];
      for(int i = 0; i < n; i++) arr[i] = next();
      return arr;
   }
}