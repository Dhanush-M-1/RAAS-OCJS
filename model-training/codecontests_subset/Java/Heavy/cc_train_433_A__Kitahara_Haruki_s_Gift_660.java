import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class A {

    public static void main(String[] args) throws Exception {
        try{
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            int[]arr = new int[n];
            int sum=0;
            for(int i=0;i<arr.length;i++){
                arr[i] = sc.nextInt();
                if(arr[i]==100){
                    sum+=1;
                }
            }
            if(sum%2==0 && sum!=0){
                System.out.println("YES");
            }
            else if(sum==0){
                if(n%2==0){
                    System.out.println("YES");
                }
                else{
                    System.out.println("NO");
                }
            }
            else{
                System.out.println("NO");
            }




        }
        catch (Exception e) {
        }
    }
}