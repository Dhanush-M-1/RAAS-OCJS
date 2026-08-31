import java.util.*;
public class Main {
 
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int [] a1 = new int [n];
        int [] a2 = new int [n-1];
        int [] a3 = new int [n-2];
        for (int i = 0; i <n ; i++) {
            a1[i] = s.nextInt();
        }
        for (int i = 0; i < n-1 ; i++) {
            a2[i] = s.nextInt();
        }
        for (int i = 0; i <n-2 ; i++) {
            a3[i] = s.nextInt();
        }
        Arrays.sort(a1);
        Arrays.sort(a2);
        Arrays.sort(a3);
 
        boolean breaked = false;
        int h = n-1;
        for (int i = 0; i < n-1 ; i++) {
            if (a1[i] != a2[i] ){
 
                h = i;
                break;
            }
        }
        System.out.println(a1[h]);
        h = n-2;
 
        for (int i = 0; i < n-2 ; i++) {
            if (a3[i] != a2[i] ){
                h = i;
                break;
            }
        }
        System.out.println(a2[h]);
    }
}