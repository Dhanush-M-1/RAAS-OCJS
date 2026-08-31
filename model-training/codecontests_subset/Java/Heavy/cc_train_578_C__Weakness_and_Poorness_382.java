import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;


public class CF_320_E {
    
    private static double p(int[] arr1, double mid){
        
        double[] arr = new double[arr1.length];
        
        for(int i = 0; i < arr.length; i++){
            arr[i] = (double)arr1[i] - mid;
        
        }
        int index = 0;
        while(index < arr.length && arr[index] < 0)index++;
        double max = Integer.MIN_VALUE;
        double cum = 0;
        for(int i = index; i < arr.length; i++){
            if(arr[i] >= 0){
                cum += arr[i];
                max = Math.max(max, cum);
            }else{
                if(cum + arr[i] <= 0){
                    cum = 0;
                }else{
                    cum += arr[i];
                }
            }
        }
        
        //-ve
        for(int i = 0; i < arr.length; i++){
            arr[i] *= -1;
        
        }
            
        
         index = 0;
    
        while(index < arr.length && arr[index] < 0)index++;
        double max1 = Integer.MIN_VALUE;
        cum = 0;
        for(int i = index; i < arr.length; i++){
        
            if(arr[i] >= 0){
                cum += arr[i];
                max1 = Math.max(max1, cum);
            }else{
                if(cum + arr[i] <= 0){
                    cum = 0;
                }else{
                    cum += arr[i];
                }
            }
        }
        
    
        if(max == Integer.MIN_VALUE){
            return -1*max1;
        }else if(max1 == Integer.MIN_VALUE){
            return max;
        }
        return (max > max1)? max:-1*max1;
    }
    
    public static void main(String[] args) throws IOException{
        PrintWriter pw = new PrintWriter(System.out, true);
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String[] line;
        int n = Integer.parseInt(input.readLine());
        int[] N = new int[n];
        line = input.readLine().split(" ");
        for(int i = 0; i < n; i++){
            N[i] = Integer.parseInt(line[i]);
        }
        double lo = -100001, hi = 100001, mid;
        double val;
        int iter = 100;
        while((hi-lo) > 1e-15){
        
            if(iter-- == 0){
                break;
            }
            mid = lo+(hi-lo)/2;
        
            val = p(N, mid);
    
        
            if(val < 0){
                hi = mid;
            }else{
                lo = mid;
            }
        }
        if(n == 1){
            pw.println(0);
        }else{
            pw.println(Math.abs(p(N, lo)));
        }
        
        pw.close();
        input.close();
    }
}
