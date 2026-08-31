import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public  final class RunForPriceCF {
    public static int max= (int) Math.pow(10,6);
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        String s[]=br.readLine().split(" ");
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(s[i]);
        }
        if(n==1){
            int ans=Math.min(arr[0]-1,max-arr[0]);
            System.out.println(ans);
        }else{
            int min=Integer.MAX_VALUE;
            int time=max-arr[0];
            min=Math.min(min,time);
            for(int i=0;i<n-1;i++){
                time=Math.max(arr[i]-1,max-arr[i+1]);
                min=Math.min(min,time);
            }
            min=Math.min(min,arr[n-1]-1);
            System.out.println(min);
        }


    }
}
