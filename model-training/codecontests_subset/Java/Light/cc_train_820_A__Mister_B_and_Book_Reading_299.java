/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
/**
 *
 * @author rahul kumar
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws IOException {
        BufferedReader in =new BufferedReader(new InputStreamReader(System.in));
        String s=in.readLine();
        String ss[]=s.split(" ");
        int c=Integer.parseInt(ss[0]);
        int v0=Integer.parseInt(ss[1]);
        int v1=Integer.parseInt(ss[2]);
        int a=Integer.parseInt(ss[3]);
        int l=Integer.parseInt(ss[4]);
        int count=0;
        int i;
        for(i=0;i<c;i++){
            if(count<c){
            if(i>0){
              count=count-l;  
            }
            if(count<c){
                if(v0+i*a>v1){
                    count+=v1;
                }
                else{
                count+=v0+i*a;}
            }
            }
            else{
                break;
            }
        }
        System.out.print(i);
    }
    
}
