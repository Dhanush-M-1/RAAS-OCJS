import java.io.*;
import java.util.*;
public class acm977B {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        String ch = in.readLine();
        HashMap<String,Integer> map = new HashMap<>();
        for (int i = 0; i < ch.length()-1; i++) {
            String r=ch.substring(i, i+2);
            if(map.get(r)!=null){map.put(r,map.get(r)+1);continue;}
            if(map.get(r.charAt(1)+r.charAt(0))!=null){map.put(""+r.charAt(1)+r.charAt(0), map.get(r.charAt(1)+r.charAt(0)+"")+1);continue;}
            map.put(r,1);
        }
        String res=ch.substring(0,2);
        for (String s : map.keySet()) {
            if (map.get(res) <map.get(s)){
                res=s;
            }
        }
        System.out.println(res);
        /*for (String s : map.keySet()) {
            System.out.println(s+"\t"+map.get(s));
        }*/
    }
}
