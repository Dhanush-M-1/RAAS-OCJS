import java.io.*;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner input=new Scanner(System.in);
        int n=input.nextInt(), x=input.nextInt(), y=input.nextInt();
        int q;
        if (n*y%100==0)
            q=n*y/100;
        else q=n*y/100+1;
        System.out.println(Math.max(q-x, 0));
        
    }
}

   			   	       	 	 		    	 		