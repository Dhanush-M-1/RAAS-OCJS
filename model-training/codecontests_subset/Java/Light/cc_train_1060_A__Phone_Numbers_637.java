/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.*;
/**
 *
 * @author a
 */
public class Solver {
 
    public static void main(String args[]){
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    String s=sc.next();
    int m=n/11;
    int c=0;
    for(int i=0;i<n;i++){
    if(s.charAt(i)=='8'){
    c++;
    }
    }
    if(c>=m){
    System.out.println(m);
    }else{
    System.out.println(c);
    }
    
    }
}
