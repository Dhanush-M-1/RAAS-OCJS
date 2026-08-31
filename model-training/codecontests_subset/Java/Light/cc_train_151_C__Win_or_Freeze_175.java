import java.io.*;
import java.util.*;
import java.lang.*;

public class Rextester{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        br.close();
        int min = -1;
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i==0){
                min = i;
                break;
            }
        }
        if(min==-1){
            System.out.println("1\n0");
        }
        else{
            long w = n/min;
            int min2 = -1;
            for(int i=2;i<=Math.sqrt(w);i++){
                if(w%i==0){
                    min2=i;
                    break;
                }
            }
            if(min2==-1){
                System.out.println("2");
            }
            else{
                System.out.println("1\n"+(min*min2));
            }
        }
    }
}