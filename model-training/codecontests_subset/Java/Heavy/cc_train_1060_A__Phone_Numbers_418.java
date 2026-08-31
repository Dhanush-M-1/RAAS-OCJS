//package com.company;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;
import java.util.*;
//import java.math.*;
public class Main
{
    public static void main(String[] args)throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        //String str=br.readLine();    //reads String like 10<enter>
        Scanner scan=new Scanner(System.in);
        int n= scan.nextInt(),cnt=0;
        String s= scan.next();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='8')cnt++;
        }
        System.out.println(Math.min(cnt,n/11));
    }

}

