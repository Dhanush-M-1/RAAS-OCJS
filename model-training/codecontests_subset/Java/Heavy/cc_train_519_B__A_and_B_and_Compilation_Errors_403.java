/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package codeforces.problems;
import java.util.*;
import java.util.Scanner; 
import java.math.*;
/**
 *
 * @author Sehs
 */
public class CodeforcesProblems {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int x= input.nextInt();
        Vector <Long> v1 = new Vector<>();
        Vector <Long> v2 = new Vector<>();
        Vector <Long> v3 = new Vector<>();
        Vector <Long> result = new Vector<>();
        for (int i=0;i<x;i++)
        {
            long y = input.nextLong();
            v1.add(y);
        }
            for (int i=0;i<x-1;i++)
        {
            long y = input.nextLong();
            v2.add(y);
        }
            for (int i=0;i<x-2;i++)
        {
            long y = input.nextLong();
            v3.add(y);
        }
            long z=-1;
            Collections.sort(v1);
            Collections.sort(v2);
            Collections.sort(v3);
            v2.add(z);
            v3.add(z);
            v3.add(z);
            for (int i=0;i<x;i++)
        {
            if (v1.get(i).equals(v2.get(i))==false)
            {
                result.add(v1.get(i));
                break;
            }
        }
            for (int i=0;i<x-1;i++)
            {
                 if (v2.get(i).equals(v3.get(i))==false)
                 {
                 result.add(v2.get(i));
                 break;
                 }
            }
            for (int i=0 ; i<result.size() ; i++)
            {
                System.out.println(result.get(i));
            }
    }
    
}
