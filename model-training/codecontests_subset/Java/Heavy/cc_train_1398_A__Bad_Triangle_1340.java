import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



public class CodeChef {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t=Integer.parseInt(br.readLine());
        while(t-->0)
        {
        	int n=Integer.parseInt(br.readLine());
        	String[] sr=br.readLine().split(" ");
        	int a=Integer.parseInt(sr[0]);
        		int b=Integer.parseInt(sr[1]);
        	int c=Integer.parseInt(sr[n-1]);
        	if(a+b>c)
        		System.out.println("-1");
        	else
        		System.out.println("1 2 "+(n));
        	
        }
       

    }
}
