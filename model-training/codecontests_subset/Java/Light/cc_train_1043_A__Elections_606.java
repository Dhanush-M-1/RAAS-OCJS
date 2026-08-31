//codeforces basic code class must be "" public ""

import java.io.*;
import java.util.*;

public class Solution{

    public static void main(String args[]) throws IOException{

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n=Integer.parseInt(br.readLine());
    String str[]=br.readLine().split(" ");
    int max=-999999,sum=0;
    int arr[]=new int[n];
    for(int i=0;i<n;i++){
        arr[i]=Integer.parseInt(str[i]);
        sum+=arr[i];
        if(arr[i]>max)
            max=arr[i];
    }
    
    while(n*max-sum<=sum)
        max++;
    System.out.println(max);
    }
}


