import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
public class Main {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int k = s.nextInt();
        int arr[] = new int[n];
        int max = -1;
        for(int i = 0; i < n; i++){
            arr[i] = s.nextInt();
            max = Math.max(max,arr[i]);
        }
        Arrays.sort(arr);
        int ans = Integer.MAX_VALUE;
        for(int i = max; i >= 0; i--){
            ArrayList<Integer> list = new ArrayList<>();
            for(int j = n - 1;j >= 0; j--){
                int opt = 0,safe = arr[j];
                while(safe > i){
                    safe = safe/2;
                    opt++;
                }
                if(safe == i){
                    list.add(opt);
                }
            }
            if(list.size() >= k){
                int sum = 0;
                int times = 0;
                for(int start = list.size() - 1; start >= 0 && times < k; start--){
                    sum += list.get(start);
                    times++;
                }
                ans = Math.min(ans,sum);
            }

        }
        System.out.println(ans);
        
    }
   

    
}