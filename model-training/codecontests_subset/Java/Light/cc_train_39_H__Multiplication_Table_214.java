import java.util.*;
public class multtable{
     public static void main(String[] args) {
        Scanner br = new Scanner(System.in);
        int n = br.nextInt();
        String[][] table = new String[n-1][n-1];
        for(int i = 1;i<n;i++){
            for(int j = 1;j<n;j++){
                table[i-1][j-1] = Integer.toString(i*j, n);
            }
        }
        for(int i = 0;i<n-1;i++){
            for(int j = 0;j<n-1;j++){
                System.out.print(table[i][j]+" ");
            }
            System.out.println();
        }
    }
}

