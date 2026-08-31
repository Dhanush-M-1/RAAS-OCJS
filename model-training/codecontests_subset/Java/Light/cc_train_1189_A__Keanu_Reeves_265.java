import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        int n = sc.nextInt();
        String s = sc.next();
        int len = s.length();
        if(isValid(s)){
            System.out.println(1);
            System.out.println(s);
            return;
        }
        for(int i=0;i<len;i++){
            String first = s.substring(0,i+1);
            String second = s.substring(i+1,len);
            if(isValid(first) && isValid(second)){
                System.out.println(2);
                System.out.println(first+ " "+second);
                return;
            }
        }
    }
    private static boolean isValid(String s){
        int count1 = 0;
        int count0 = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1'){
                count1++;
            }else{
                count0++;
            }
        }
        return !(count0==count1) || (count0+count1 ==0);
    }
}