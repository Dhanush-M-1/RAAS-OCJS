
import java.util.Scanner;

public class Main {
    public static void main(String... args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int a[] = new int[n];
        for(int i = 0;i < n;i++)a[i] = scan.nextInt();

        int t = 0; 
        for(int i = 0;i < n;i++){
            int minj = i;
            for(int j = i;j < n;j++){
                if(a[j] < a[minj])minj = j;
            }
            if(i != minj){
                int x = a[i];
                a[i] = a[minj];
                a[minj] = x;
                t++;
            }
        }

        for(int i = 0;i < n;i++){
            if(i != 0)System.out.print(" ");
            System.out.print(a[i]);
        }
        System.out.println("\n" + t);

        scan.close();
    }

}
