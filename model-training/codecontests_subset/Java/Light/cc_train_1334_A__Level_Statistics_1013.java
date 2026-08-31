import java.util.*;
import java.io.*;
public class LevelStats{
    public static void main(String args[]){
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        try{
            int t=Integer.parseInt(br.readLine());
            while(t-- > 0){
                int n=Integer.parseInt(br.readLine());
                int[][] a=new int[n][2];
                String[] temp;
                for (int i = 0; i < n; i++) {
                    temp=br.readLine().trim().split(" ");
                    a[i][0]=Integer.parseInt(temp[0]);
                    a[i][1]=Integer.parseInt(temp[1]);
                }
                if(a[0][1]> a[0][0]){
                    System.out.println("NO");
                    continue;
                }
                boolean flag=true;
                for (int i = 1; i < n; i++) {
                    if(a[i][1]>a[i][0] || a[i][0]<a[i-1][0] || a[i][1]<a[i-1][1] || (a[i][0]-a[i-1][0] < a[i][1]-a[i-1][1])){
                        flag=false;
                        break;
                    }
                }
                if(flag)
                    System.out.println("YES");
                else
                    System.out.println("NO");
            }
            br.close();
        }
        catch(IOException e){}
    }
}