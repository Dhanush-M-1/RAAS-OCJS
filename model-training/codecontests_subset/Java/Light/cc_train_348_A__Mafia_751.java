/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author sousnake
 */
public class C {
    public static void main(String arga[]) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        long max =-1;
        String s[] = br.readLine().split(" ");
        long arr[] =new long[(int)n];
        long sum=0;
        for(int i=0;i<n;i++){
            arr[i] = Long.parseLong(s[i]);
            if(arr[i]>max){
                max = arr[i];
            }
            sum =sum+arr[i];
        }
        long ans = max;
        sum = sum - (n-2)*max-max;
        if(sum>0){
            double k = (long)Math.ceil((double)sum/(n-1));
            ans = ans+(long)k;
        }
        System.out.println(ans);
    }
}
