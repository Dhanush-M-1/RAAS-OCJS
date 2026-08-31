import java.util.Scanner;

public class A379 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int temp = n;
        int count = 0;
        int rem = 0;
        while(temp >= 1){
            rem += temp%m;
            temp /= m;
            count += temp;
            if(rem >= m){
                temp += rem;
                rem = 0;
            }
        }
        System.out.println(n+count);
    }
}
