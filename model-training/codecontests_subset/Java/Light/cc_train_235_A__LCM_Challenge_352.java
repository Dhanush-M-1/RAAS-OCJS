/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//package codeforcespractice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author admin
 */
public class CodeforcesPractice {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        long n=Integer.parseInt(br.readLine());
        long ans;
        
        if(n<3){
            ans=n;
        }
        else if(n==3){
        ans=6;
        }
        else{
        if(n%2!=0){
        ans=n*(n-1)*(n-2);
        }
        else{
                if(n%3!=0){
                ans=Math.max((n*(n-1)*(n-2))/2,n*(n-1)*(n-3));
                }
                else{
                ans=Math.max((n*(n-1)*(n-2))/2,(n-1)*(n-2)*(n-3));
                }
        }
        }
        System.out.println(ans);
    }
}
