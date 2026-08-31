import java.util.Scanner;

public class problem1334A {
    public static void main(String[] args) throws Exception{
        Scanner scan = new Scanner(System.in);

        int t = Integer.parseInt(scan.next());

        for (int i = 0; i < t; i++){
            scan.nextLine();
            int n = Integer.parseInt(scan.next());

            int[] p = new int[n];
            int[] c = new int[n];
            boolean valid = true;

            for (int j = 0; j < n; j++){
                scan.nextLine();
                p[j] = Integer.parseInt(scan.next());
                c[j] = Integer.parseInt(scan.next());
            }

            if (p[0] < c[0]){
                valid = false;
            }else {
                for (int j = 1; j < n; j++) {
                    if (p[j] < c[j]) {
                        valid = false;
                        break;
                    }
                    if (p[j]-p[j-1] < c[j]-c[j-1]){
                        valid = false;
                        break;
                    }
                    if (c[j] < c[j-1]){
                        valid = false;
                        break;
                    }
                }
            }

            if (valid){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }
}
