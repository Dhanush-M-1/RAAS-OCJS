import java.util.Scanner;
public class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int sum = 0;
        int rem;
        sum = a;
        while(true){
            rem = a/b;
            a = rem+(a%b);
            sum+=rem;
            if(a<b)
                break;
        }
        System.out.println(sum);
    }
}