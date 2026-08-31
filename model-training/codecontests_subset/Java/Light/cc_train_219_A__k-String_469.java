import java.util.*;
import java.lang.*;
import java.io.*;

public class sample{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        String s = sc.next();
        Set<Character> set = new HashSet<>();

        for(int i = 0; i < s.length(); i++) set.add(s.charAt(i));
        String p = "";
        for(char c : set){
            int cnt = 0;
            for(int i = 0; i < s.length(); i++){
                if(c == s.charAt(i)) cnt++;
            }
            if(cnt % k != 0){
                System.out.println(-1);
                return;
            }
            else{
                String temp = Character.toString(c);
                p += temp.repeat(cnt/k);
            }
        }
        System.out.println(p.repeat(k));
    }

}