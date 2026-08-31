import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
 public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrintWriter pw=new PrintWriter(System.out);
        
        int n=in.nextInt();
        int x=in.nextInt();
        int y=in.nextInt();

        in.nextLine();
        StringBuilder str=new StringBuilder(in.nextLine());
        str.reverse();
   // pw.println(str);
        int cnt=0;
        for(int i=0;i<x;i++){
            if(i==y || i==x){
                if(str.charAt(i)!='1')cnt++;
            }else if(str.charAt(i)!='0')cnt++;
        }
        pw.println(cnt);

        pw.flush();
        pw.close();
        
   }
   static class Pair implements Comparable<Pair>{
        int x;
        int y;
        Pair(int a,int b){
            x=a;
            y=b;
        }
        @Override
        public int compareTo(Pair t){
            if(x>t.x)return 1;
            else if(x==t.x){
                if(y>=t.y)return 1;
                else return -1;
            }
            else return -1;
        }
    }
}
