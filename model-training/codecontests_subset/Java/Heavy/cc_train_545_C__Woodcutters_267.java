import java.io.*;
import java.util.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author winterwind
 */
public class November20_Woodcutter {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        
        /**
         * @PHILOSOPHY A tree can either be felled to the left, to the right, or stay standing
             * All we need is the furthest right position: if it's a sorted array,
             * that's either the position of the tree (if felled to the left or still standing)
             * or the position if it's felled to the right.
         */
        
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(f.readLine());
        int[] positions = new int[n + 1];
        int[] heights = new int[n];
        
        positions[n] = Integer.MAX_VALUE;
        
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            positions[i] = Integer.parseInt(st.nextToken());
            heights[i] = Integer.parseInt(st.nextToken());
        }        
        
        int count = 1;
        int right = 0;
        for(int i = 1; i < n; i++) {
            if(positions[i] - heights[i] > positions[i - 1] + right*(heights[i - 1])) {
                count++;
                right = 0;
            }
            else if(positions[i] + heights[i] < positions[i + 1]) {
                count++;
                right = 1;
            }
            else {
                right = 0;
            }
        }
        System.out.println(count);
    }
    
}
