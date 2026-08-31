import java.util.*;
import java.io.*;
public class demo{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st = null;
    public static void main(String[] args)throws IOException {
        int v = 0;
        HashSet<String> set = new HashSet<>();
        while(true){
            try{
                String s = br.readLine().trim();
                if(s.charAt(0)=='+'){
                    set.add(s.substring(1,s.length()));
                }else if(s.charAt(0)=='-'){
                    set.remove(s.substring(1,s.length()));
                }else{
                    String sa = s.substring(s.indexOf(':')+1,s.length());
                    int l = sa.length();
                    v+=(set.size())*l;
                }
            }catch(Exception e){
                break;
            }
        }
        System.out.println(v);
        
   }
}