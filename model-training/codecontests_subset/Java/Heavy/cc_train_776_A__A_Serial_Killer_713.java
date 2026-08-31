//package com.myProject.test;

import java.io.*;
import java.util.*;


public class Solution {

    public static void main(String[] args) throws IOException {
       // BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Scanner in = new Scanner(System.in);

        String[][] people = new String[1001][2];
        String[][] rezult = new String[1001][2];
        int n;

        people[0][0] = in.next();
        people[0][1] = in.next();
        n = Integer.parseInt(in.next());

        for (int i=1;i<n+1;i++)
        {
            people[i][0] = in.next();
            people[i][1] = in.next();
        }

        rezult[0][0] = people[0][0];
        rezult[0][1] = people[0][1];

        for (int i=1;i<n+1;i++)
        {
            rezult[i][0] = people[i][1];
            if (people[i][0].equals(rezult[i-1][0]))
                rezult[i][1] = rezult[i-1][1];
            else
                rezult[i][1] = rezult[i-1][0];
        }

        for (int i=0;i<n+1;i++)
        {
            System.out.println(rezult[i][0]+" "+rezult[i][1]);
        }
    }

}