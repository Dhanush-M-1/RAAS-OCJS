import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

  
    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args)
            throws IOException {

        // BufferedReader buffer=new BufferedReader(new InputStreamReader(System.in));

        PrintWriter writer = new PrintWriter(new OutputStreamWriter(System.out));
    int n=input.nextInt();

      int s=0;
      int s2=0;
    for(int i=0;i<n;i++){
    int x=input.nextInt();
    s+=x;
   
    }
        
        for(int i=0;i<(n-1);i++)
        {
              int x=input.nextInt();
                s2+=x;
        }
        int s3=0;
            for(int i=0;i<(n-2);i++)
        {
              int x=input.nextInt();
               s3+=x;
        }
        System.out.println(s-s2);
        System.out.println(s2-s3);
      
       
    }}