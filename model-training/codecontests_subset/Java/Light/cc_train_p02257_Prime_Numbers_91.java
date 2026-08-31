import java.util.*;
import java.io.*;
public class Main{

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.next());
        int count=0;
        for(int i=0; i<n; i++){
            if(isPrime(Integer.parseInt(sc.next()))) count++;
        }
        System.out.println(count);

    }
    //素数判定
    public static boolean isPrime(int x){
        if(x == 2) return true;
        if(x < 2 || x % 2 == 0) return false;
        
        int i = 3;
        while(i <= Math.sqrt(x)){
            if(x % i == 0) return false;
            i = i + 2;
        }
        return true;
    }
}

