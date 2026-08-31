import java.io.*;
import java.util.*;

public class Main {
    static Scanner in;
    static PrintWriter out;
    public static void main(String[] args) throws IOException {
        in  = new Scanner(System.in);
        out = new PrintWriter(System.out);

        
        int n = in.nextInt();
        
        int[][] table = new int[n][n];
        
        for(int i=1;i<n;i++)
            for(int j=1;j<n;j++) table[i][j] = perevod(i*j,n);
        
        for(int i=1;i<n;i++){
            for(int j=1;j<n;j++) System.out.print(table[i][j]+" ");
            System.out.println("");
        }
        
        out.close();
    }   
    
    static int perevod(int a,int k){
        
        StringBuilder str = new StringBuilder("");
        
        while(a>0){
            str.append(a%k);
            a=a/k;
        }
        str.reverse();
        
        return Integer.parseInt(str.toString());
    }
    
}
