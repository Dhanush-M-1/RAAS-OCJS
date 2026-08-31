/**
 * Created by Vaibhav Singh on 2/23/2017.
 */

import java.io.*;
import java.util.*;

public class Codeforces7 {

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String p = sc.next();
        String q = sc.next();
        int n = sc.nextInt();
        String str[][] = new String[n+1][2];

        for(int i=1;i<=n;i++){
            for(int j=0;j<2;j++){
                str[i][j] = sc.next();
            }
        }

        String ans[][] = new String[n+1][2];
        ans[0][0] = p; ans[0][1] = q;


        //System.out.println(ans[0][0]+" + "+ans[0][1]);
        for(int i=1;i<=n;i++){

                if(ans[i-1][0].equals(str[i][0])){
                    ans[i][0] = ans[i-1][1];
                    ans[i][1] = str[i][1];
                    //System.out.println("1 ->");
                }

                if(ans[i-1][0].equals(str[i][1])){
                    ans[i][0]= ans[i-1][1];
                    ans[i][1]= str[i][0];
                    //System.out.println("2 ->");
                }

                if(ans[i-1][1].equals(str[i][1])){
                    ans[i][0] = ans[i-1][0];
                    ans[i][1]= str[i][0];
                    //System.out.println("3 ->");
                }

                if(ans[i-1][1].equals(str[i][0])){
                    ans[i][0]= ans[i-1][0];
                    ans[i][1] = str[i][1];
                    //System.out.println("4 ->");
                }


        }


        for(int i=0;i<=n;i++){

                System.out.println(ans[i][0]+" "+ans[i][1]);


        }


    }

}
