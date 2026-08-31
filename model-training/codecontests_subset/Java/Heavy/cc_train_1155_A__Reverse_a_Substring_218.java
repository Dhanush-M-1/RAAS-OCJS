/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package codeforces;

/**
 *
 * @author Dhruv
 */
import java.io.*;
import java.util.*;

public class Reverse_a_Substring {
    public static void main(String args[]) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        String str=br.readLine();
        ele e[]=new ele[n];
        for(int i=0;i<n;i++){
            char r=str.charAt(i);
            e[i]=new ele(i+1,r);
        }
        Arrays.sort(e);
        int prev=e[0].index;
        int curr=e[0].index;
        boolean flag=false;
        for(int i=0;i<n;i++){
            //System.out.println(a.ch+" "+a.index);
            curr=e[i].index;
            if(curr<prev){
                flag=true;
                break;
            }
            prev=e[i].index;
        }
        if(flag){
            System.out.println("YES");
            System.out.println(curr+" "+prev);
        }
        else{
            System.out.println("NO");
        }
    }
}
class ele implements Comparable<ele>{
    int index;
    char ch;
    ele(int i,char ch){
        index=i;
        this.ch=ch;
    }
    @Override
    public int compareTo(ele o) {
        
        //To change body of generated methods, choose Tools | Templates.
        if(ch<o.ch)
            return -1;
        else if(ch > o.ch)
            return 1;
        else
        return 0;
    }
    
}
