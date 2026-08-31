import java.util.Collections;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int k=s.nextInt();
        while (k>0){
            k--;
            int a=s.nextInt();
            int two=0;
            int three=0;
            int ans=0;
            while (a%3==0){
                three++;
                a/=3;
            }
            while (a%2==0){
                two++;
                a/=2;
            }
            if (a!=1){
                System.out.println(-1);
            } else {
                if (two>three){
                    System.out.println(-1);
                } else {
                    ans=2*(three-two)+two;
                    System.out.println(ans);
                }
            }
        }
    }
}