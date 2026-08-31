/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author VEDANT
 */
//Codeforces
import java.util.*;
public class Garden {
    public static void main(String args[]){
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int k=in.nextInt();
        int min=1000;
        for(int i=0;i<n;i++){
            int c=in.nextInt();
            if(k%c==0){
                if(min>(k/c))
                    min=k/c;
            }
        }
        System.out.println(min);
    }
}
