import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public final class GamesOfRobotsCDF {
    public static  int max= (int) 1e5;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String s[]=br.readLine().split(" ");
        int n=Integer.parseInt(s[0]);
        int k=Integer.parseInt(s[1]);
        String st[]=br.readLine().split(" ");
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st[i]);
        }
        if(k==1){
            System.out.println(arr[0]);
        }else{
            long prefix[]=new long[max];
            prefix[1]=1;
            for(int i=2;i<max;i++){
                prefix[i]=prefix[i-1]+i;
            }

            int index=0;
            while (k>prefix[index]){
                index++;
            }
            k-=prefix[index-1];
            System.out.println(arr[k-1]);
        }
    }
}
