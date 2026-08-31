import java.util.*;
import java.io.*;

public class TwoGram{
   public static void main(String[] args) throws IOException{
      BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(f.readLine());
      String st = f.readLine();
      HashMap<String, Integer> occurences = new HashMap<String, Integer>();
      for(int i = 0; i < n-1; i++){
         String curr = st.substring(i, i+2);
         if(!occurences.containsKey(curr)){
            occurences.put(curr, 0);
         }
         occurences.put(curr, occurences.get(curr)+1);
      }
      String highestKey = "";
      int highestValue = 0;
      for(String s: occurences.keySet()){
         if(occurences.get(s) > highestValue){
            highestKey = s;
            highestValue = occurences.get(s);
         }
      }
      System.out.println(highestKey);
   }
}