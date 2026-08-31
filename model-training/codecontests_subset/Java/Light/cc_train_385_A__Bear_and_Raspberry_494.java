import java.util.Scanner;

/**
 *
 * @author user
 */
public class BearsRasberry {
    public   static void main(String args[]){
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int c=in.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=in.nextInt();
        }
        int profit=0;
        for(int i=0;i<n-1;i++){
            if(arr[i]>arr[i+1]){
                if(arr[i]-arr[i+1]-c>profit){
                    profit=arr[i]-arr[i+1]-c;
                }
            }
        }
        System.out.println(profit);
    }
}
