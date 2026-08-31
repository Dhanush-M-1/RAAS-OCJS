import java.awt.Checkbox;
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

import javax.security.auth.kerberos.KerberosKey;
public class Main {
	public static void main(String[]args) {
		Scanner scanner=new Scanner(new BufferedInputStream(System.in));
		int n=scanner.nextInt();
		int c=scanner.nextInt();
		int x[]=new int [n];
		for (int i=0;i<n;i++){
			x[i]=scanner.nextInt();
		}
		int total=0;
		for (int i=0;i<n-1;i++){
			if (x[i]-x[i+1]-c>total)
				total=x[i]-x[i+1]-c;
		}
		System.out.println(total);
	}
}
