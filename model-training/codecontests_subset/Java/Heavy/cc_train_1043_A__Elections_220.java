import java.util.Scanner;

public class Main{

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int N = s.nextInt();
        int elodreip = 0;
        int max = 0;

        for (int i = 0; i < N; i++) {
            int k = s.nextInt();

            if (k > max) {
                max = k;
            }
            elodreip += k;

        }

        int re;

        for (int i = max; true; i++) {
            int awruk = N * i - elodreip;

            if(awruk > elodreip){
                re = i;
                break;
            }
            
        }
        
        System.out.println(re);
    }
}