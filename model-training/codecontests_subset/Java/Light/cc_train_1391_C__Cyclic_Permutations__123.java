//package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.Scanner;

public class Main
{

    public static void main(String[] args)throws IOException
    {
	Scanner sc=new Scanner(System.in);
	//int t=sc.nextInt();
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        //int t=Integer.parseInt(br.readLine());
        StringBuffer sb=new StringBuffer();
         long mod=(long)(1e9+7);
	//while(t-->0)
    //{

        int n=sc.nextInt();
        long ans=1;
        for(int i=1;i<=n;i++)
       ans=(ans*i)%mod;
        long pow=1;
        for(int i=1;i<n;i++)
        {
            pow=(pow*2)%mod;
        }
        sb.append((ans-pow+mod)%mod+"\n");
    //}
	System.out.println(sb);
    }
}
