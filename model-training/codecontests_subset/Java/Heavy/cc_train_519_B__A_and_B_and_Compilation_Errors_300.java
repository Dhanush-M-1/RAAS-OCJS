
import java.io.BufferedReader;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.nio.BufferOverflowException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Stack;
import java.util.Vector;

public class Main {


	public static void main(String args[]) throws IOException

	{
		Scanner in=new Scanner(System.in);
   int n=in.nextInt();
  int sum1=0,sum2=0,sum3=0; 
  Vector<Integer> x1=new Vector<Integer>();
  
for(int i=0;i<n;i++) {
	x1.add(in.nextInt());
	sum1+=x1.get(i);
}
  Vector<Integer> x2=new Vector<Integer>();
  for(int i=0;i<n-1;i++) {
	  x2.add(in.nextInt());
	  sum2+=x2.get(i);
  }
  Vector<Integer> x3=new Vector<Integer>();
  for(int i=0;i<n-2;i++) {
	  x3.add(in.nextInt());
	  sum3+=x3.get(i);
	  }
//System.out.println(sum1+"   "+sum2+"    "+sum3);  
System.out.println((int)Math.abs(sum2-sum1));

System.out.println((int)Math.abs(sum3-sum2));
  
  
  
  
  // viewed the implmentation !!!
  
  
  
  
  
	}
	
}
