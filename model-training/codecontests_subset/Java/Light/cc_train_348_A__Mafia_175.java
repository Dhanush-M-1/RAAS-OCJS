import java.util.Scanner;

public class Saleelo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        long sum = 0 ;
        long max = 0 ;
        for(int i = 0 ; i < n ; i++){
            int x = scan.nextInt();
            sum+= x;
            max = Math.max(max, x);
        }
        n--;
        if(sum % (n) == 0){
            sum/=n;
            System.out.println(Math.max(sum, max)); 
        }
        else {
            sum = (sum / n ) + 1 ;
            System.out.println(Math.max(sum, max));
        }
    }
}