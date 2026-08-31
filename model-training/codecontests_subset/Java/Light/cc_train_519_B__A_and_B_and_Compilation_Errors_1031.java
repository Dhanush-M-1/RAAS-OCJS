import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in) ;
        int n=in.nextInt() ;
        int xor1 = 0;
        for(int i=0;i<n;i++){
            int tmp=in.nextInt() ;
            xor1^=tmp ;
        }
        int xor2 = 0;
        for(int i=0;i<n-1;i++){
            int tmp=in.nextInt() ;
            xor2^=tmp ;
        }
        
         int xor3 = 0;
        for(int i=0;i<n-2;i++){
            int tmp=in.nextInt() ;
            xor3^=tmp ;
        }
        System.out.println(xor1^xor2) ;
        System.out.println(xor2^xor3) ;
    }
}