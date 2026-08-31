/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
 *
 * @author Sourav Kumar Paul
 */
public class C545 {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int pos[] = new int[n+1];
        int height[] = new int[n];
        pos[n] = Integer.MAX_VALUE;
        for(int i=0; i<n; i++)
        {
            StringTokenizer st = new StringTokenizer(reader.readLine());
            pos[i] = Integer.parseInt(st.nextToken());
            height[i] = Integer.parseInt(st.nextToken());
            
        }
        int total = 1;
        int max = pos[0];
        for(int i=1; i<n; i++)
        {
            if(pos[i] - height[i] > max)
            {
                total++;
                max = pos[i];
            }
            else if(pos[i]+height[i] < pos[i+1])
            {
                total ++;
                max = pos[i]+height[i];
            }
            else
                max = pos[i];
        }
        System.out.println(total);
        
    }
}
