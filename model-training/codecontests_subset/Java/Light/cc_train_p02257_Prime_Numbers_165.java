import java.util.Scanner;

public class Main{
    static boolean is_prime(int p){
        for(int i = 2; i * i <= p; i++)
            if(p % i == 0) return false;
        return true;
    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int ps = scan.nextInt(); int r = 0;
        for(int i = 0; i < ps; i++)
            if(is_prime(scan.nextInt())) r++;
        System.out.println(r);
    }
}