import java.io.BufferedInputStream;
import java.util.Collections.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeMap;
import java.math.*;
import java.util.*;
public class Main {
	public static void main(String[]args) {
		Scanner scanner=new Scanner(new BufferedInputStream(System.in));
		int n=scanner.nextInt();
		String t=scanner.next();
		int t1=0;
		for (int i=0;i<n;i++)
			if (t.charAt(i)=='I') t1++;
		if (t1==0){
			int total=0;
			for (int i=0;i<n;i++)
				if (t.charAt(i)=='A') total++;
			System.out.println(total);
		}
		else if (t1==1){
			System.out.println(1);
		}
		else System.out.println(0);
	}
}
