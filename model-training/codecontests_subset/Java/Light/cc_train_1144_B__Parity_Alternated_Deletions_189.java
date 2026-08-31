/*-----------------------------*/
/*      Vora Mahammadasim      */
/*-----------------------------*/


import java.util.*;
import java.lang.*;
import java.math.*;

public class Solution{

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> ref1 = new ArrayList<>();
        ArrayList<Integer> ref2 = new ArrayList<>();
        for(int i=0;i<n;i++){
            int x = sc.nextInt();
            if(x%2 != 0) ref1.add(x);
            else ref2.add(x); 
        }
        if(ref2.size() > ref1.size() + 1){
            Collections.sort(ref2);
            int ans = 0;
            for(int i=0;i<ref2.size()-ref1.size()-1;i++){
                ans += ref2.get(i);
            }
            System.out.println(ans);
        }
        else if(ref1.size() > ref2.size() + 1){
            Collections.sort(ref1);
            int ans = 0;
            for(int i=0;i<ref1.size()-ref2.size()-1;i++){
                ans += ref1.get(i);
            }
            System.out.println(ans);
        }
        else{
            System.out.println(0);
        }
    }
}