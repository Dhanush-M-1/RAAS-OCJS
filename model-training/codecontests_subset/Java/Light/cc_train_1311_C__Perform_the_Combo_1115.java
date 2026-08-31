import java.io.*;
import java.lang.reflect.Array;
import java.util.HashSet;
import java.util.*;

public class Test {
    private static void swap(int arr[], int i, int j){
        int temp  = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void main(String[] args) throws IOException {
            Scanner sc = new Scanner(System.in);
            int test = sc.nextInt();
            for(int ii=0; ii<test; ii++){
               long ans[] = new long[26];
               int n = sc.nextInt();
               int m = sc.nextInt();
               String s = sc.next();
               int arr[] = new int [n];
               for(int i=0; i<m ;i++){
                    int x = sc.nextInt();
                   ++arr[x-1];
               }
               for(int i=n-1; i>0; i--){
                   arr[i-1] += arr[i];
               }
               for(int i=0; i<n; i++){
                   ans[s.charAt(i)-97] += arr[i]+1;
               }
               for(long xx : ans)
                   System.out.print(xx+" ");
               System.out.println();
            }
    }
}
