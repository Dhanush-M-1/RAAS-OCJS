//package model;

import java.util.ArrayList;
import java.util.Scanner;

public class CodeForcesNewYearBookReading {
    public CodeForcesNewYearBookReading() {
        super();
    }

    public static void main(String[] args) {
        CodeForcesNewYearBookReading codeForcesNewYearBookReading = new CodeForcesNewYearBookReading();
        ArrayList<Integer> list = new ArrayList<Integer>();
        int n,m;
        Scanner s = new Scanner(System.in);
        n = s.nextInt();
        m = s.nextInt();
        int[] w = new int[n];
        int[] b = new int[m];
        
        for(int i=0; i<n; i++) {
            w[i] = s.nextInt();
        }
        
        for(int i=0; i<m; i++) {
            b[i] = s.nextInt();
        }
        
        for(int i=0; i<m; i++) {
            if(list.size() == n)
                break;
            if(list.indexOf(b[i])== -1)
                list.add(b[i]);
        }
        
        int we = 0;
        int tw = 0;
        int index = 0;
        for(int i=0; i<m; i++) {
            index = list.indexOf(b[i]);
            tw=0;
            for(int k=0; k<index; k++) {
                tw = tw + w[list.get(k)-1];
            }
            list.remove(index);
            list.add(0, b[i]);
            we = we+tw;
        }
        
        System.out.println(we);
    }
    
}