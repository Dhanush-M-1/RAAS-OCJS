/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package codeforces;

import java.util.HashSet;
import java.util.Scanner;

/**
 *
 * @author HOME
 */
public class BarkToUnlock {
    public static void main(String[] args){
     
    Scanner sc = new Scanner(System.in);
    String pass = sc.next();
    int num_attempts = sc.nextInt();
    sc.nextLine();
    HashSet<String> hs1 = new HashSet<>();
    HashSet<String> hs2 = new HashSet<>();
    boolean flag = false;
    while(num_attempts-- > 0){
      String attempt = sc.next();
        hs1.add(attempt.substring(1,2));
      hs2.add(attempt.substring(0,1));
      if(attempt.equals( pass)){
          //System.out.println("YES");
          flag = true;
         // break;
      }
    
    }
    if(hs1.contains(pass.substring(0,1)) && hs2.contains(pass.substring(1,2)))
        System.out.println("YES");
    
    else {if(flag == false)
        System.out.println("NO");
    if(flag == true)
        System.out.println("YES");
    
         //System.out.println(flag);
        
        
    }
    
}
}
