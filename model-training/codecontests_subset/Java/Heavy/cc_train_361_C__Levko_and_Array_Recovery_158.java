import java.util.Scanner;

public class CF1 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int min = -1000000000;
        int n = s.nextInt();
        int m = s.nextInt();
        int[] arr = new int[n];
        int[][] rules = new int[m][4];
        for(int i = 0; i < n; i++){
            arr[i] = min;
        }
        for(int i = 0; i < m; i++){
            rules[i][0] = s.nextInt();
            rules[i][1] = s.nextInt();
            rules[i][2] = s.nextInt();
            rules[i][3] = s.nextInt();
        }
        for(int i = m - 1; i >= 0; i--){            
            for(int j = rules[i][1] - 1; j < rules[i][2]; j++){
                if(rules[i][0] == 2){
                    if(arr[j] == min){
                        arr[j] = rules[i][3];
                    } else {
                        if(arr[j] > rules[i][3]){
                            arr[j] = rules[i][3];
                        }
                    }                    
                }else if(arr[j] != min){
                    arr[j] -= rules[i][3]; 
                }                
            }
        }         
        int[] arrcp = new int[n];
        System.arraycopy(arr, 0, arrcp,  0, arr.length);
        for(int i = 0; i < m; i++){            
            if(rules[i][0] == 2){
                int max = arr[rules[i][1]-1];
                for(int j = rules[i][1] - 1; j < rules[i][2]; j++){
                    if(arr[j] > max){
                        max = arr[j];
                    }
                }
                if(max != rules[i][3]){
                    System.out.println("NO");
                    return;
                }
            } else {
                for(int j = rules[i][1] - 1; j < rules[i][2]; j++){
                    arr[j] += rules[i][3];
                }
            }            
        }
        System.out.println("YES");
        for(int i = 0; i < n; i++){
            System.out.print(arrcp[i] + " ");
        }
    }
}