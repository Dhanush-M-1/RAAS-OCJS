
import java.util.Scanner;


public class Triangle_1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while(t-->0){
            int n = s.nextInt();
            int[] arr = new int[n];
            for(int i=0;i<n;i++){
                arr[i] = s.nextInt();
            }
            if(arr[0]+arr[1]<=arr[arr.length-1]){
                System.out.println("1 "+"2 "+arr.length);
            }else{
                System.out.println(-1);
            }
        }
    }
}
