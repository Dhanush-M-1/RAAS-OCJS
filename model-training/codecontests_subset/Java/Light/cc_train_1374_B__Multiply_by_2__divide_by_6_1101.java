import java.util.*;
import java.io.*;

public class multiple{
    // static int step = 0;
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        for(int i = 0; i<t; i++){
            int n = scan.nextInt();
            int step = 0;
            if(n==1){
                System.out.println(0);
                continue;
            }
            while(n<=1000000001){
                
                if(n%6 == 0){
                    n = n/6;
                    step++;
                }else{
                    n = n*2;
                    step++;
                }
                if(n == 1 ){
                    System.out.println(step);
                    break;
                }
                if(n>1000000000){
                    System.out.println(-1);
                    break;
                }
            }
        }
    }
}