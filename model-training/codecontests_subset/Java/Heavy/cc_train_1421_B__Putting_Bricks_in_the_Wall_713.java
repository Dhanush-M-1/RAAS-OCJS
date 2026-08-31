
import java.util.Scanner;

public class BrickIntheWall {
    private static Scanner scanner=new Scanner(System.in);
    public static void main(String[] args){
        int test = scanner.nextInt();
        for(int t=0;t<test;t++){
            int n=scanner.nextInt();
            char[][] arr=new char[n][n];
            for(int i=0;i<n;i++){
                String s=scanner.next();
                for(int j=0;j<n;j++){
                    if((i==0&&j==0)||(i==n-1&&j==n-1)){
                        scanner.nextLine();
                    }else{
                       arr[i][j]=s.charAt(j);
                    }
                }
            }
            if(arr[0][1]==arr[1][0]&&arr[n-1][n-2]==arr[n-2][n-1]&&arr[0][1]!=arr[n-1][n-2]){
                System.out.println(0);
            }
            if(arr[0][1]==arr[1][0]&&arr[n-1][n-2]==arr[n-2][n-1]&&arr[0][1]==arr[n-1][n-2]){
                System.out.println(2);
                System.out.println(n+" "+(n-1));
                System.out.println(n-1+" "+(n));
            }
            if(arr[0][1]==arr[1][0]&&arr[n-1][n-2]!=arr[n-2][n-1]){
                System.out.println(1);
                if(arr[n-1][n-2]==arr[0][1]) {
                    System.out.println(n  + " " + (n - 1));
                }
                if(arr[n-2][n-1]==arr[1][0]) {
                    System.out.println(n - 1 + " " + (n));
                }
            }
            if(arr[0][1]!=arr[1][0]&&arr[n-1][n-2]==arr[n-2][n-1]){
                System.out.println(1);
                if(arr[n-1][n-2]==arr[0][1]) {
                    System.out.println(1 + " " + 2);
                }
                if(arr[n-2][n-1]==arr[1][0]) {
                    System.out.println(2 + " " + 1);
                }
            }
            if(arr[0][1]!=arr[1][0]&&arr[n-1][n-2]!=arr[n-2][n-1]){
                System.out.println(2);
                System.out.println(2+" "+1);
                if(arr[0][1]==arr[n-1][n-2]){
                    System.out.println(n+" "+(n-1));
                }
                if(arr[0][1]==arr[n-2][n-1]){
                    System.out.println(n-1+" "+n);
                }
            }
        }
    }
}
