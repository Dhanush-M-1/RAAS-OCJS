import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
	
	
    public static void main(String[] args) {
    	Scanner input = new Scanner(System.in);
    	int n = input.nextInt();
    	int winner[] = new int[n];

    	for (int i = 0; i < n; i++) {
    		winner[i] = input.nextInt();
    	}
    	
    	int play1 = 1, play2 = 2, spectator = 3;
    	for (int i = 0; i < n; i++) {
    		if (winner[i] == spectator) {
    			System.out.println("NO");
    			return;
    		}
    		
    		if (winner[i] == play1) {
    			int tmp = spectator;
    			spectator = play2;
    			play2 = tmp;
    		}
    		else if (winner[i] == play2) {
    			int tmp = spectator;
    			spectator = play1;
    			play1 = tmp;
    		}
    	}

    	/*for (int i = 0; i < n - 2; i++) {
    		System.out.println(winner[i] + " " + winner[i + 1] + " " + winner[i + 2]);
    		if (winner[i] != winner[i + 1] && winner[i] == winner[i + 2]) {
    			System.out.println("NO");
    			return;
    		}
    	}*/
    	
    	System.out.println("YES");
    }
    
   
}