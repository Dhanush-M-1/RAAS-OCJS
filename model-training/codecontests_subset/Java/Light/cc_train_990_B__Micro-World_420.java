import java.util.*;

public class MicroWorld{
    
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] arr = new int[10000000];
        int max = 0, min = 0;
        for(int i =0; i < n; i++){
            int num = in.nextInt();
            if(num > max){
                max = num;
            }
            arr[num]++;
        }
        int count = 0;
        for(int i = min + 1; i <= max; i++){
            if(arr[i] != 0){
                if(min + k >= i){
                    count += arr[min];
                }
                min = i;
            }
        }
        System.out.println(n-count);
    }
}