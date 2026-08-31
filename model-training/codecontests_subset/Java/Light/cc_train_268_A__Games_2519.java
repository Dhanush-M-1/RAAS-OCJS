
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[][] = new int[n][2];
        for(int i=0;i<n;i++){
            for(int j=0;j<2;j++){
                a[i][j] = in.nextInt();
            }
        }
        int count = 0;
        for(int i=0;i<n;i++){
            int num = a[i][1];
            for(int j=0;j<n;j++){
                if(num == a[j][0]){
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
