//package com.example.programming;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CodeforcesProblems {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int r1 = in.nextInt();
        int r2 = in.nextInt();
        int c1 = in.nextInt();
        int c2 = in.nextInt();
        int d1 = in.nextInt();
        int d2 = in.nextInt();

        if(r1>18 || r2>18 || c1>18 || c2>18 || d1>18 || d2>18) {
            System.out.println("-1");
            return;
        }

        int w = (r1-c2+d1)/2;
        int x = (d2+r1-c1)/2;
        int y = (c1-d1+r2)/2;
        int z = (r2-c1+d1)/2;

        boolean isExist = w+x == r1 & y+z==r2;
        isExist &= w+y==c1 & x+z==c2;
        isExist &= w+z==d1 & x+y==d2;

        isExist &= x!=z & y!=w && x!=y & w!=z & x!=w & y!=z;
        isExist &= x>0 & y>0 & z>0 & w>0 & x<10 & y<10 & z<10 & w<10;
        if(isExist) System.out.println(w+" "+x+"\n"+y+" "+z);
        else System.out.println("-1");
    }
}
