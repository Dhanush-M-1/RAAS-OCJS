import java.util.*;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        
        int[][]table = new int[N-1][N-1];
        for (int i = 0; i<N-1; i++){
            table[i][0] = i+1;
            table[0][i] = i+1;
        }
        
        for (int i = 0; i<N-1; i++){
            for (int j = 0; j<N-1; j++){
                table[i][j] = main.toSystem(main.toDEC(table[i][0], N) * main.toDEC(table[0][j], N), N); 
                System.out.print(table[i][j]+" ");
            }System.out.println();
        }
    }   
    int toSystem(int A, int n){     
        String S = "";
        int k = 0;
        while (A>0){
            k = A%n;
            A = A/n;
            S = k + S;
        }
        A = Integer.parseInt(S);
        return A;
    }
    
    int toDEC(int A, int n){
        int l = 0;
        int DEC = 0;
        while (A>0){
            DEC = DEC + A%10 * (int)Math.pow(n, l);
            l++;
            A = A/10;
        }       
        return DEC;
    }
}