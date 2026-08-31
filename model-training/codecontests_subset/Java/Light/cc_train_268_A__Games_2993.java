
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int n = Integer.parseInt(s.nextLine());

        int[] w = new int[n];
        int[] a = new int[n];

        for(int i =0 ; i < n;i++){
            String[] raw = s.nextLine().split(" ");
            a[i] = Integer.parseInt( raw[0]);

            w[i] = Integer.parseInt(raw[1]);

        }


        int count=0;
        for(int i =0 ; i < n; i ++){
            for(int x =0 ; x < n; x ++){
                if(a[i]==w[x]){
            
                    count++;
                }
            }
        }

        System.out.println(count);
    }

}
