import java.util.*;
import java.io.*;


public class kString {
    public static int i(String s){
        return Integer.parseInt(s);
    }
    public static void main(String args[]) throws Exception {
        HashMap<Character, Integer> m = new HashMap<Character, Integer>();
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int k  = i(r.readLine());
        String word = r.readLine();
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(m.containsKey(c)){
                m.put(c, m.get(c)+1);
            } else {
                m.put(c, 1);
            }
        }
        String rest = "";
        for(Character c : m.keySet()){
            if(m.get(c) % k!=0){
                System.out.println("-1");
                return;
            }
            for (int i=0;i<m.get(c)/k;i++) rest += c.toString();
        }
        String result = "";
        for(int i = 0; i < k; i++)
            result += rest;
        System.out.println(result);
        
    }
}
