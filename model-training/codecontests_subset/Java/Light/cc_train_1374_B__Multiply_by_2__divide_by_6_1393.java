import java.util.Scanner;


public class Codeforces {


    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        
        int t = cin.nextInt();
        
        while(t > 0){
            int n = cin.nextInt();
            int counter = 0;
            while( n > 1 ){
                if(n % 6 == 0)
                    n /= 6;
                else
                    n *= 2;
                counter++;
            }
            if(n == 1)
                System.out.println(counter);
            else
                System.out.println(-1);
            t--;
        }
        
    }
}
