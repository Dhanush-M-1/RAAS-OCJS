import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.io.*;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		// Scanner read = new Scanner(new FileInputStream(new
		// File("input.txt")));
		// PrintWriter out = new PrintWriter(new File("output.txt"));
		Scanner read = new Scanner(System.in);
		int n = read.nextInt(), c = read.nextInt(),arr[]  = new int[n],max = 0,index = -1 ,maxp = 0;
		for(int i = 0; i < n ; i++){
			arr[i] = read.nextInt();		
		}
		for(int i = 0; i < n-1; i++){
			if(arr[i] - arr[i+1] > maxp)
				maxp = arr[i] - arr[i+1]; 
		}
		System.out.println(Math.max(maxp - c , 0));	
	}
}