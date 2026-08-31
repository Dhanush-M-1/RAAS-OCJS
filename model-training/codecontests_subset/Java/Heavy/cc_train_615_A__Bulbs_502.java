/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package javaapplication1;

import java.util.Scanner;

/**
 *
 * @author TaMeEm
 */
public class JavaApplication1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int n,m;
        Scanner in=new Scanner(System.in);
        n=in.nextInt();
        m=in.nextInt();
        boolean[] bulbs=new boolean[101];
        for(int i=0;i<n;i++)
        {
            int count=in.nextInt();
            for(int j=0,temp;j<count;j++)
            {
                temp=in.nextInt();
                bulbs[temp]=true;
            }
        }
        boolean flag=true;
        for(int i=1;i<=m;i++)
        {
            if(!bulbs[i])
            {
                flag=false;
                break;
            }
        }
        if(flag)
            System.out.println("YES");
        else
            System.out.println("NO");
    }
}
