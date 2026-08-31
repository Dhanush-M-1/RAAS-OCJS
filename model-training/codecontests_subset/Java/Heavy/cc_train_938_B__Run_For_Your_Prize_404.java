import java.util.*;
import java.io.*;
/*
*/
public class Main{

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int[] arr=new int[n];
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        int ans=Integer.MAX_VALUE;
        if(1000000-arr[0]<ans){
            ans=1000000-arr[0];
        }
        for(int i=0;i<n-1;i++){
            int temp=arr[i]-1;
            int temp2=1000000-arr[i+1];
            temp=Math.max(temp,temp2);
            if(temp<ans){
                ans=temp;
            }
        }
        if(arr[n-1]-1<ans){
            ans=arr[n-1]-1;
        }
        pw.println(ans);
        pw.close();




    }

}

