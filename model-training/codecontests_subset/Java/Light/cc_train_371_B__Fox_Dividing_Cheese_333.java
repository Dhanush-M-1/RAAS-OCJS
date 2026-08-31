import java.io.*;
import java.util.*;
import java.io.*;
import java.util.*;
 
public class  FoxDividingCheese{
   public static int a = 0;
   public static int b = 0;
   public static void main(String args[]) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
      
      StringTokenizer st = new StringTokenizer(br.readLine());
      a = Integer.parseInt(st.nextToken());
      b = Integer.parseInt(st.nextToken());
      
      HashMap<Integer,Integer> map = new HashMap<>();
      
      int [] div = {2,3,5};
      int i = 0;
      int dC = 0;
      while(a != 1 && i < 3){
         if(a%div[i] == 0){
            a = a/div[i];
            dC++;
            map.put(div[i],map.getOrDefault(div[i],0)+1);
         }else{
            i++;
         }
      }
      int steps = 0;
      i = 0;
      while(b != 1 && i < 3){
         if(b%div[i] == 0){
            b = b/div[i];
            if(map.containsKey(div[i]) && map.get(div[i])>0){
               map.put(div[i],map.get(div[i])-1);
               dC--;
            }else{
               dC++;
            }
         }else{
            i++;
         }
      }
      
      if(a != b)
         bw.write(-1 +"\n");
      else
         bw.write(dC+"\n");
     
      bw.flush();
      br.close();
      bw.close();
   } 
   
}