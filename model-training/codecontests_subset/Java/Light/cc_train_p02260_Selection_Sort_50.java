import java.util.Scanner;
public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int d,cou=0,minj;
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }

        for(int i=0;i<=n-1;i++){
            minj=i;
            for(int j=i;j<=n-1;j++){
                if(arr[j] < arr[minj]){
                    minj=j;
                }
            }
            if(minj != i){
                d=arr[i];
                arr[i]=arr[minj];
                arr[minj]=d;
                cou++;
            }
        }

        for(int k=0;k<n;k++){
            System.out.print(arr[k]);
            if(k!=n-1){
                System.out.print(" ");
            }
        }
        System.out.println("\n"+cou);
        sc.close();
    }
}
