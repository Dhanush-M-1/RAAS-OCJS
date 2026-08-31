//package com.example.myPackage;

import java.io.PrintWriter;
import java.util.Scanner;

public class CyclicPermutation663 {
    private static Scanner fs = new Scanner(System.in);
    private static int Mod = 1000_000_007;
    private static PrintWriter out = new PrintWriter(System.out);
    public static void main(String[] args) {
     int n = Integer.parseInt(fs.next());
     /*
     // Hre it is an important Concept of unimodel permutations
        // We can see only uni model permutation are not making cycles
        // So We just need to calculate the number of uni model
       // permutations and sub tract with the number of the permuatation
        //i.e n! - 2^(n-1)
        //2^(n-1) because we are fixing the n element and remaining elements we can either
        //front or back;
         */
     long res =1;
     for(int i=2;i<=n;i++)
        res = (res*i)%Mod;
     long minus =1;
     for(int i=0;i<n-1;i++) minus=(minus*2)%Mod;
     long Fres = (res - minus+ Mod)%Mod;
     out.println(Fres);
     out.close();
    }
}
