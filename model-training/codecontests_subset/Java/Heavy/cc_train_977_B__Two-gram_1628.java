import java.util.*;
import java.io.*;
public class Codeforces{
    public static BufferedReader buffer=new BufferedReader(new InputStreamReader(System.in));
    public static BufferedWriter logger=new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args){
        try{
            int n=Integer.parseInt(buffer.readLine());
            String s=buffer.readLine();
            Map<String,Integer> map=new HashMap<>();
            for(int i=0;i<n-1;i++){
                String _2_gram_=s.substring(i,i+2);
                if(!map.containsKey(_2_gram_)){
                    map.put(_2_gram_,0);
                }
                map.put(_2_gram_,map.get(_2_gram_)+1);
            }
            int max_occ=0;
            String _2_gram_="";
            for(Map.Entry<String,Integer> entry:map.entrySet()){
                if(entry.getValue()>max_occ){
                    _2_gram_=entry.getKey();
                    max_occ=entry.getValue();
                }
            }
            logger.write(_2_gram_);
            logger.flush();
        }
        catch(IOException exc){}
    }
}