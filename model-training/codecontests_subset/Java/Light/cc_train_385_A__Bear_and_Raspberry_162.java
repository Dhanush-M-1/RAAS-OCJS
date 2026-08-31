import java.util.Scanner;


public class bearR {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        
        int n=sc.nextInt();
        int c=sc.nextInt();
        
        
        int max=0;
        int[] arr=new int[n];
        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();
        for(int i=0;i<n-1;i++){
            max=Math.max(arr[i]-arr[i+1]-c, max);
        }
        
        System.out.println(max);
    }
}
