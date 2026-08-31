import java.util.Scanner;

public class trial_1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int it=0; it<t; it++) {
            int n = in.nextInt(), m = in.nextInt();
            //System.out.println("n = " + n + " m = " + m);
            int[] arr_n = new int[n];
            int[] arr_m = new int[m];
            for(int i=0; i<n; i++) {
                arr_n[i] = in.nextInt();
            }
            //System.out.println("Got arr_n");
            boolean found=false;
            for(int i=0; i<m; i++) {
                arr_m[i] = in.nextInt();

                //System.out.println("Got arr_m");
                for(int j=0; j<n; j++) {
                    //System.out.println("Entered J LOOP! j = " + j);
                    if(arr_m[i] == arr_n[j]) {
                        found = true;
                        System.out.println("YES\n" + 1 + " " + arr_m[i]);
                        break;
                    }
                }
                if(found) break;
            }
            if(!found) System.out.println("NO");
            in.nextLine();
            //System.out.println("End of iteration");
        }
    }
}
