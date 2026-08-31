import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    
    public static void ngram(String str, int n){
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0; i<n-1; i++){
            String x = str.substring(i, i+2);
            if(map.containsKey(x)) map.put(x, map.get(x)+1);
            else map.put(x, 1);
        }
        
        ArrayList<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>(){
            public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2){
                return e2.getValue()-e1.getValue();
            }
        });
        
        if(list.get(0).getValue()==1){
            System.out.println(str.substring(0,2));
            return;
        }
        System.out.println(list.get(0).getKey());
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        String str = br.readLine().trim();
        ngram(str, n);
    }
}
