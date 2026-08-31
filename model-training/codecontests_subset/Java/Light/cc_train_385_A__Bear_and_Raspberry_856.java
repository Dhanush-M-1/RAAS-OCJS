import java.util.Scanner;

public class BearAndRaspberry {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int v = sc.nextInt();
        int[] a = new int[n];
        int max = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            a[i] = sc.nextInt();
        }
        for(int i=0; i<n-1; i++){
            max = Math.max(max, a[i] - a[i+1]);
        }
        if(max > v){
            System.out.println(max - v);
        }else{
            System.out.println(0);
        }
    }
}