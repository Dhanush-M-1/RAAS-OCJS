

import java.io.*;
import java.util.*;
import java.math.*;

public class Main {
    //**CHANGE TASK**
    static final String taskname = "REPLACETHIS";
    //**CHANGE TASK**

    public static void main(String[] args) throws IOException {

        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        // input file name goes above

        int n=Integer.parseInt(f.readLine());
        int []arr=new int[n];
        StringTokenizer st=new StringTokenizer(f.readLine());
        int total=0;
        int max=0;
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
            total+=arr[i];
            max=Math.max(max,arr[i]);
        }
        int temp=0;
        int j;
        int min=Integer.MAX_VALUE;

        for(int i=max;i<5000;i++){
            //try all
            //can?
            if(total>=(i*n)-total){
                continue;
            }
            min=Math.min(min,i);
        }

        int ans=0;
        f.close();
        System.out.println(min);


        //check if you changed everything
    }

}



