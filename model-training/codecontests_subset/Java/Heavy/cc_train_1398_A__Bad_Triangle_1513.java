import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for(int i = 0; i < t; i++){
            int n = scanner.nextInt();
            int[] arr = new int[n];
            for(int j = 0; j < n; j++){
                arr[j] = scanner.nextInt();
            }
            int x1 = arr[0];
            int x2 = arr[1];
            int x3 = -1;
            for(int j = 2; j < n; j++){
                if(arr[j] >= x1+x2){
                    x3 = j+1;
                    break;
                }
            }
            if(x3 == -1){
                System.out.println(-1);
            }else{
                System.out.println( "1 2 " + x3);
            }
        }
    }
}
