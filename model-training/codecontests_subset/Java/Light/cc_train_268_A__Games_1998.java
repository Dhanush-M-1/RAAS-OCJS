import java.util.Scanner;


public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        
        int [] home = new int[101];
        int [] away = new int[101];
        
        for(int i = 0; i<n; i++) {
            home[sc.nextInt()]++;
            away[sc.nextInt()]++;
        }
        int total = 0;
        for(int i = 1; i<=100; i++) {
            total += home[i] * away[i];
        }
        
        System.out.println(total);
        sc.close();
    }
    
}
