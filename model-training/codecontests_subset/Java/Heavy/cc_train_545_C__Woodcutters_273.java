import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        
        int n = input.nextInt();
        
        int[][] a = new int[n][2];
        
        for(int i=0; i<n; i++) {
            a[i][0] = input.nextInt();
            a[i][1] = input.nextInt();
        }
        
        if(n<=2) {
            System.out.println(n);
        }
        else {
            
            int count = 2;
            
            int leftSpace = a[1][0] - a[0][0];
        
            for(int i=1; i<n-1; i++) {
            
                if(a[i][1] < leftSpace) {
                    count++;
                    leftSpace = a[i+1][0] - a[i][0];
                }
                else if(a[i][0]+a[i][1] < a[i+1][0]) {
                    count++;
                
                    leftSpace = a[i+1][0] - (a[i][0] + a[i][1]);
                }
                else {
                    leftSpace = a[i+1][0] - a[i][0];
                }
            }
        
            System.out.println(count);
        }
        
    }
    
}
