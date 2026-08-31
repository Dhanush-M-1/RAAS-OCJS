import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int t=scan.nextInt();
        for (int i = 0; i < t; i++) {
            int n=scan.nextInt();
            int m=scan.nextInt();
            int[] arr=new int[1001];
            int[] arr1=new int[1001];
            for (int j = 0; j < n; j++) {
                ++arr[scan.nextInt()];
            }
            for (int j = 0; j < m; j++) {
                ++arr1[scan.nextInt()];
            }
            boolean flag=false;
            for (int j = 0; j < 1001; j++) {
                if(arr[j]>=1 && arr1[j]>=1){
                    System.out.println("YES");
                    System.out.println("1 "+j);
                    flag=true;
                    break;
                }
            }
            if(!flag){
                System.out.println("NO");
            }
        }
    }
}