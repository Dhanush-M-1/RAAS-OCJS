
import java.util.*;

public class Main {
    static int prime[] = {2 , 3 , 5} ;
    public static void main(String[] args){
        Scanner cin = new Scanner(System.in) ;
        while(cin.hasNext()){
            int a = cin.nextInt() ;
            int b = cin.nextInt() ;
            int maxGcd = gcd(a , b) ;
            a /= maxGcd ;
            b /= maxGcd ;
            int ans = 0 ;
            if(divNumber(a) == -1 || divNumber(b) == -1)
                System.out.printf("-1%n") ;
            else{
                ans += (divNumber(a) + divNumber(b)) ;
                System.out.printf("%d%n" , ans) ;
            }
        }
    }
    public static int gcd(int a , int b){
        int r;
        while(b > 0){
            r = a % b ;
            a = b ; 
            b = r ;
        }
        return a ;
    }
    public static int divNumber(int a){
        int i = 0;
        int count = 0 ;
        while(a != 1){
            if(i == prime.length)
                return -1 ;
            for(i = 0; i < prime.length ; i++){
                if(a % prime[i] == 0){
                    a /= prime[i] ;
                    break ;
                }
            }
            count++ ;
        }
        return count ;
    }

}
