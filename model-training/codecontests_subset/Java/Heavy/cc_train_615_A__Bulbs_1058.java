import java.util.Scanner;

public class Bulbs {
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int[] bulbs = new int[m+1];
        for (int i = 0; i < n; i++) {
            int li = scan.nextInt();
            for (int j = 0; j < li; j++) {
                bulbs[scan.nextInt()]++;
            }
        }
        boolean ch = false;
        for (int i = 1; i <=m; i++) {
            if(bulbs[i]==0){
                ch = true;
                break;
            }
        }
        System.out.println(ch?"NO":"YES");
        
        
    }
}
