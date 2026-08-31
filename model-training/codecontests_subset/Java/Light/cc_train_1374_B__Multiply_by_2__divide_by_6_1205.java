import java.util.Scanner;

public class maxwellFailedThis {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int test = scan.nextInt();

        for(int l = 0;l<test;l++){
            int n = scan.nextInt();
            int count = 0;
            while(true){
                if(n % 6 == 0){
                    count++;
                    n /= 6;
                }
                if(n == 1){
                    System.out.println(count);
                    break;
                }
                if(n % 6 == 1 || n % 6 == 2 || n % 6 == 4 || n % 6 == 5){
                    System.out.println(-1);
                    break;
                }
                if(n % 6 == 3){
                    count++;
                    n *= 2;
                }
            }
        }

    }
}
