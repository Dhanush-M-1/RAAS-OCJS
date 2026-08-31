import java.io.BufferedInputStream;
import java.rmi.StubNotFoundException;
import java.util.Collections.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
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
import java.util.Vector;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;
import java.math.*;
import java.util.*;

import javax.management.Query;
import javax.naming.InitialContext;
import javax.security.auth.x500.X500Principal;
import javax.swing.text.html.MinimalHTMLWriter;
public class Main {
	public static void main(String[]args) throws IOException {
		Scanner scanner=new Scanner(new BufferedInputStream(System.in));
		int r1=scanner.nextInt(),r2=scanner.nextInt(),
			c1=scanner.nextInt(),c2=scanner.nextInt(),
			d1=scanner.nextInt(),d2=scanner.nextInt();
		boolean flag=false;
		for (int i=1;i<=9;i++)
			for (int j=1;j<=9;j++)
				if (i!=j)
				for (int p=1;p<=9;p++)
					if (i!=p&&j!=p)
					for (int q=1;q<=9;q++)
						if (i!=q&&j!=q&&p!=q)
					{
						if (flag) break;
						else{
							if (i+j==r1&&
								p+q==r2&&
								i+p==c1&&
								j+q==c2&&
								i+q==d1&&
								j+p==d2)
							{
								flag=true;
								System.out.println(i+" "+j);
								System.out.println(p+" "+q);
								break;
							}
						}
					}
		if (!flag) System.out.println(-1);
	}
}
