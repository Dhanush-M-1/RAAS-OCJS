import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int count = 0;
        int num =1;
        for(int i = 0;i < N; i+=1){
            num = sc.nextInt();
            count += isPrime(num);
        }
        System.out.println(count);
    }
    public static int isPrime(int num){
        for(int i = 2;i*i <= num;i +=1){
            if( num %i == 0){return 0;}
        }
        return 1;
    }
}
