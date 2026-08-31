import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt()  , x = sc.nextInt()  , y = sc.nextInt();
        String s = sc.next() ;
        int ans = 0 ;
        for( int i = n-1 , j = 0 ; j < x ; i-- , j++ ){
//            System.out.println(s.charAt(i));
            if(j==y){
                if(s.charAt(i)=='0')
                    ans++ ;
            }else if(s.charAt(i)=='1')
                ans++ ;

        }
        System.out.println(ans);
    }
}
