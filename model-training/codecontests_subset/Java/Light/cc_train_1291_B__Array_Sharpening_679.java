import java.util.Scanner;

public class Cf2 {

    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- != 0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            
            String ans = "Yes";
            for (int i = 0; i < arr.length/2; i++) {
                if(arr[i] < i || arr[n-1-i] < i){
                    ans = "No";
                    break;
                }
                
                if(n%2==0 && i == n/2-1){
                    if(arr[i] == arr[i+1] && arr[i] == i && arr[i+1] == i){
                        ans = "No";
                        break;
                    }
                }
                
            }
            if(n%2 != 0 && arr[n/2] < n/2){
                ans = "No";
            }
            System.out.println(ans);
            
        }
        
    }

    
    
    
}