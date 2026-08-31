/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//package codeforces;

import java.util.*;

public class Candles {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        int count=a;
        int r=a/b;
        int m=a%b;
        int s=r+m;
        int k=0;
        if(s>=b)
        {
            count+=r;
            while(r>0)
            {
                m+=r%b;
                r=r/b;
                count+=r;
            }
            if(m>=b)
            {
                while(m>0)
                {
                    k+=m%b;
                    m=m/b;
                    count+=m;
                    if(k>=b)
                    {
                        m=k;
                        k=0;
                        continue;
                    }
                }
                
                
            }
        }
        else
            count+=r;
        
        System.out.println("" + count);
    }
    
}
