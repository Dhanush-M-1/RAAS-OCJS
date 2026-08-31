/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * @author Rohini Chandra
 */
import java.util.*;
import java.io.*;
public class XORINACCI{
    public static void main(String args[]) throws IOException{
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       PrintWriter pw = new PrintWriter(System.out);
       int t = Integer.parseInt(br.readLine().trim());
       while(t--!=0){
           String str[];
           str = br.readLine().trim().split(" ");
           int a = Integer.parseInt(str[0]);
           int b = Integer.parseInt(str[1]);
           int n = Integer.parseInt(str[2]);
           if(n%3==0)
               pw.print(a);
           else if(n%3==1)
               pw.print(b);
           else
               pw.print(a^b);
           pw.print("\n");
           pw.flush();
       }
    }    
}
