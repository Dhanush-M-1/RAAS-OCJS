 import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.StringTokenizer; 
  import java.util.*;
 
public class Main 
{ 
    public static String ans(int n, String str)
    {
        HashMap<String,Integer>h=new HashMap<>();
        for(int i=0;i<n-1;i++){
            String k= str.substring(i,i+2);
            if(h.containsKey(k)){
                h.put(k,h.get(k)+1);
            }else{
                h.put(k,1);
            }
        }
        Set<String>keys = h.keySet();
        String ans="";
        int max=0;
        for(String x:keys){
            if(h.get(x)>max){
                max=h.get(x);
                ans=ans+x;
            }
        }
        return ans.substring(ans.length()-2);
    }
    
    public static void main(String[] args) throws IOException 
    { 
  
       BufferedReader br = new BufferedReader( 
                              new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
          String str = (br.readLine());
       
        System.out.println(ans(n,str));
       
        
    }}