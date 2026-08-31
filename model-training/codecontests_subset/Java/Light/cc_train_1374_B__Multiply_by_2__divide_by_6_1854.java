import java.util.Scanner;

public class B {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
       int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int cnt = 0;
            while(n % 6 ==0 || n%6 ==3){
                if(n%6==0){
                    n/=6;
                }else {
                    n*=2;
                }
                cnt++;
            }
            if(n ==1){
                System.out.println(cnt);
            }else {
                System.out.println(-1);
            }
        }
    }
}