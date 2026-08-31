import java.util.Scanner;

public class Main {
    public static void main(String args[]){
        Scanner stdIn = new Scanner(System.in);
        int n = stdIn.nextInt();
        
        //int x = stdIn.nextInt();
        int a[] = new int[n];
        //String s = stdIn.next();
        //String t = stdIn.next();
        //char c[] = s.toCharArray();
        //int sum = 0;
        //boolean flag = true;
        for(int i = 0; i < n; i++){
            a[i] = stdIn.nextInt();
        }
        
        
        int q = stdIn.nextInt();

        for(int i = 0; i < q; i++){
            int b = stdIn.nextInt();
            int e = stdIn.nextInt();
            int t = stdIn.nextInt();
            
            for(int k = 0; k < e - b; k++){
                int tmp = a[b + k];
                a[b + k] = a[t + k];
                a[t + k] = tmp;
                
            }
            
            
        }
        
        for(int i = 0; i < n - 1; i++){
            System.out.print(a[i] + " ");
        }
        System.out.println(a[n - 1]);

        //System.out.println();
        //System.out.print();

        stdIn.close();
    }
}



