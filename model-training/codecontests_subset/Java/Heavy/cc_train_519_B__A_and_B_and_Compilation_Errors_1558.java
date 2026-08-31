import java.io.*;
import java.util.Arrays;
public class errors {


    public static void main(String[] args)throws NumberFormatException, IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        int []x=new int[n];
        int []y=new int[n-1];
        int []z=new int[n-2];
        String s[]=br.readLine().split(" ");
        for(int i=0;i<n;i++)
            x[i]=Integer.parseInt(s[i]);
        Arrays.sort(x);
        String t[]=br.readLine().split(" ");
        for(int i=0;i<n-1;i++)
            y[i]=Integer.parseInt(t[i]);
        Arrays.sort(y);
        String u[]=br.readLine().split(" ");
        for(int i=0;i<n-2;i++)
            z[i]=Integer.parseInt(u[i]);
        Arrays.sort(z);
        for(int i=0;i<n-1;i++){
            if(x[i]!=y[i]){
                System.out.println(x[i]);
                break;
            }
            if(i==n-2)
                System.out.println(x[n-1]);
        }
        for(int i=0;i<n-2;i++){
            if(y[i]!=z[i]){
                System.out.println(y[i]);
                break;
            }
            if(i==n-3)
                System.out.println(y[n-2]);
        }
    }

}
