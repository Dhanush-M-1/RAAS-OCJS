import java.util.*;
import java.math.*;


public class q_1 {
    static Scanner sc;

    public static void main(String[] args){
        sc = new Scanner(System.in);
        int n = getInt();
        int non_8 = 0;
        int eight  = 0;
        String s = sc.next();
        for(int i=0 ; i<s.length() ; i++){
            if(s.charAt(i)=='8'){
                eight++;
            }
            else
                non_8 ++;
        }
        int count = 0;
        for(int i=0 ; eight>0 && non_8>=10; i++){
            eight--;
            non_8-=10;
            count++;
        }
        if(eight>0 && non_8+eight>=11){
            count+=(eight+non_8)/11;
        }
        System.out.println(count);
    }





    public static int getInt(){
        return sc.nextInt();
    }

    public static String getString(){
        return sc.next();
    }

    public static String nextLine(){
        return sc.nextLine();
    }

    public static long nextLong(){
        return sc.nextLong();
    }

}


