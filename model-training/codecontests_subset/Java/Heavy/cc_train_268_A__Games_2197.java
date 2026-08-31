//import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList ;

//https://codeforces.com/problemset/problem/268/A

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in) ;

        int n = sc.nextInt()  ;

        int [] colors = new int[2 * n] ;

        for(int i=0 ; i< 2 * n ; i++){
            colors[i] = sc.nextInt() ;
        }

        ArrayList<Integer> h = new ArrayList<>() ;
        ArrayList<Integer> a = new ArrayList<>() ;

        for (int i=0 ; i<2 * n ; i= i+2){
            h.add(colors[i]) ;
        }

        for (int i=1 ; i<2 * n ; i= i+2){
            a.add(colors[i]) ;
        }

        int [] hm = new int[n] ;
        int [] gs = new int[n] ;

        for (int i=0 ; i<n ; i++){

            hm[i] = h.get(i) ;
            gs[i] = a.get(i) ;

        }

        guest(n , hm , gs);

    }

    public static void guest(int n , int [] h , int [] a  ){

            int count = 0 ;

            for(int i=0 ; i<n ; i++){

                for(int j=0 ; j<n  ; j++){
                    if (j==i)
                        continue;
                    else {

                        int home = h[i] ;
                        int guest = a[j] ;

                        if (home == guest)
                            count++ ;

                    }

                }

            }

            System.out.println(count)   ;





    }



}
