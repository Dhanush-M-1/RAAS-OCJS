//package com.company;
//import com.sun.tools.corba.se.idl.StructEntry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        String s1 = read.readLine();
        String s[] = s1.split(" ");
        int count=0;
        int t = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);
        PriorityQueue<Integer> a = new PriorityQueue<Integer>();
        PriorityQueue<Integer> b = new PriorityQueue<Integer>();
        PriorityQueue<Integer> ab = new PriorityQueue<Integer>();
        for (int i = 0; i < t; i++) {
            String s2 = read.readLine();
            String s3[] = s2.split(" ");

            int time=Integer.parseInt(s3[0]);
            int A=Integer.parseInt(s3[1]);
            int B=Integer.parseInt(s3[2]);
            if(A==1&&B==1){
                ab.add(time);
                count++;
            }
            else if(A==1)
            {a.add(time);
            count++;
            }
            else if(B==1){
                b.add(time);
                count++;
            }
        }
        if((a.size()+ab.size())<k||(b.size()+ab.size())<k)
            System.out.println("-1");
        else{
            int countA=0;
            int countB=0;
            int tt=0;
            while(countA<k&&countB<k){

                    if(countA<k&&countB<k){
                        if(ab.isEmpty()){
                            tt+=a.poll();
                            tt+=b.poll();
                            countA++;
                            countB++;
                        }
                        else{
                            if(a.isEmpty()){
                                tt+=ab.poll();
                                countA++;
                                countB++;
                            }
                            else if(b.isEmpty()){
                                tt+=ab.poll();
                                countA++;
                                countB++;
                            }
                            else{
                                if(ab.peek()>a.peek()+b.peek()){
                                    tt+=a.poll();
                                    tt+=b.poll();
                                    countA++;
                                    countB++;
                                }
                                else{
                                    tt+=ab.poll();
                                    countA++;
                                    countB++;
                                }
                            }
                        }
                    }else if(countB<k){
                        if(ab.isEmpty()){
                            tt+=b.poll();
                            countB++;
                        }
                        else{
                            if(b.isEmpty()){
                                tt+=ab.poll();
                                countA++;
                                countB++;
                            }
                            else{
                                if(b.peek()<ab.peek()){
                                    tt+=b.poll();
                                    countB++;
                                }else{
                                    tt+=ab.poll();
                                    countA++;
                                    countB++;
                                }
                            }
                        }
                    }
                    else if(countA<k){
                        if(ab.isEmpty()){
                            tt+=a.poll();
                            countA++;
                        }
                        else{
                            if(a.isEmpty()){
                                tt+=ab.poll();
                                countA++;
                                countB++;
                            }
                            else{
                                if(a.peek()<ab.peek()){
                                    tt+=a.poll();
                                    countA++;
                                }else{
                                    tt+=ab.poll();
                                    countA++;
                                    countB++;
                                }
                            }
                        }
                    }


            }
            System.out.println(tt);
        }
    }
}
