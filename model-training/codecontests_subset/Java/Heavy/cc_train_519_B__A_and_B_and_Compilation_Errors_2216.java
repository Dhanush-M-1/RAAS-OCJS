import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class B294 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int n1 = 0;
        int n2 = 0;
        int n3 = 0;

        n1=in.nextInt();
        for(int i=0;i<n-1;i++){
            n1^=in.nextInt();
            
        }
        n2=in.nextInt();
        for(int i=0;i<n-2;i++){
            n2^=in.nextInt();
        }
        int ans1=n1^n2;
        n3=in.nextInt();
        for(int i=0;i<n-3;i++){
            n3^=in.nextInt();
        }
        

        System.out.println(n1^n2);
        System.out.println(n2^n3);

    }

}
