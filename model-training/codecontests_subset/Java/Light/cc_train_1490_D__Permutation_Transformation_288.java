import java.io.*;
import java.util.*;

public class D {

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        //int T = Integer.parseInt(br.readLine());
        
        while(T-->0){
            int N = sc.nextInt();
            int arr[] = new int[N];
            for(int i=0; i<N; i++) arr[i] = sc.nextInt();
            int brr[] = new int[N];
            for(int i=0; i<N; i++){
                if(i!=0){
                    int j = i-1;
                    while(j>=0 && arr[i]>arr[j]) {
                        brr[j]++;
                        j--;
                    }
                }
                if(i!=N-1){
                    int j = i+1;
                    while(j<N && arr[i]>arr[j]) {
                        brr[j]++;
                        j++;
                    }
                }
            }
            for(int i=0; i<N; i++){
                System.out.print(brr[i]+" ");
            }
            System.out.println();
        }
    }
}