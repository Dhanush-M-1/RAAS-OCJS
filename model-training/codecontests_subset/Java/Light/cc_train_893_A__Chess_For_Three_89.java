import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int rem = 3;
        int playerSum = 3;
        boolean flag = true;
        for(int i = 0;i<t;i++){
            int winner = sc.nextInt();
            if(winner == rem){
                System.out.println("NO");
                flag = false;
                break;
            }
            rem = playerSum - winner;
            playerSum = 6-rem;
        }
        if(flag){
            System.out.println("YES");
        }
    }
}