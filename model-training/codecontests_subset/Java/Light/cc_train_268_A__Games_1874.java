import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();

        int[] home = new int[n];
        int[] out = new int[n];

        for (int i = 0; i < n; i++) {
            home[i] = scan.nextInt();
            out[i] = scan.nextInt();
        }
        int count=0;
        for (int k = 0; k < n; k++) {
            for(int l=0;l<n;l++){
                if(home[k]==out[l]){
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}



