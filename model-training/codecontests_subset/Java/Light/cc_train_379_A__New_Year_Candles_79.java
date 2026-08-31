import java.util.Scanner;


public class candles {
    public static void main(String[] args) {
        Scanner sc=new  Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        
        long sum=a;
        while(a>=b){
            a-=b;
            sum++;
            a++;
        }
        System.out.println(sum);
    }
}
