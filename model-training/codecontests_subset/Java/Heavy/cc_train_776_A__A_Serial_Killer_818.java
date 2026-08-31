import java.awt.List;
import java.io.PrintWriter;
import java.lang.ref.SoftReference;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	
	public static int as;
	
	public static void main(String[] args) {
		f776_a();
	  }
	
	public static void f776_a() {
		Scanner in = new Scanner(System.in);
		String a = in.next();
		String b = in.next();
		
		String a2;
		String b2;
		
		int n = in.nextInt();
		for (int i = 0; i < n; i++) {
			System.out.println(a + " " + b);
			a2 = in.next();
			b2 = in.next();
			if(a.equals(a2))
				a = b2;
			else b = b2;
		}
		System.out.println(a + " " + b);
	}
	
	public static void f777_a() {
		Scanner in = new Scanner(System.in);
		long n = in.nextLong();
		int x = in.nextInt();
		
		n = n%12;
		
		int [] a = {0,1,2};
		int asd = 0;
		for(int i=1; i<=n; i++) {
			if (i%2 == 1) {
				asd = a[0];
				a[0] = a[1];
				a[1] = asd; 
			} else {
				asd = a[1];
				a[1] = a[2];
				a[2] = asd;
			}
		}
		System.out.println(a[x]);
	}
	
	public static void f785_a() {
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		in.nextLine();
		String ad = "";
		long res=0;
		for ( int i=0; i<n; ++i) {
			ad = in.nextLine();
			if(ad.startsWith("T"))
				res += 4;
			else if(ad.startsWith("C"))
				res += 6;
			else if(ad.startsWith("O"))
				res += 8;
			else if(ad.startsWith("D"))
				res += 12;
			else if(ad.startsWith("I"))
				res += 20;
		}
		System.out.println(res);
	}
	
	public static void someFun(Integer a) {
		a=44;
	}
	public static void f711_a() {
		Scanner sc = new Scanner(System.in);
	    PrintWriter out = new PrintWriter(System.out);
	    int n = 0;
	    n = sc.nextInt();
	    String [] bus = new String[n];
	    String row = "";
	    boolean res = false;
	    sc.nextLine();
	    for(int i=0; i<n; i++) {
	    	row = sc.nextLine();
	    	if(row.contains("OO") && !res) {
	    		if(row.equals("OO|OO"))
	    			row = row.replaceFirst("OO", "++");
	    		res = true;
	    	}
	    	bus[i] = row;
	    }
	    if(res) {
	    	out.println("YES");
	    	for(int i=0; i<n; i++) 
	    		out.println(bus[i]);
	    }
	    else out.println("NO");
	    out.println();
	    out.close();
	    sc.close();
	}
	
	public static void f746_a() {
		Scanner sc = new Scanner(System.in);
	    PrintWriter out = new PrintWriter(System.out);
	    int a, b, c;
	    a = sc.nextInt();
	    b = sc.nextInt();
	    c = sc.nextInt();
	    b = b/2;
	    c = c/4;
	    if(b < a)
	    	a = b;
	    if(c < a)
	    	a = c;
	    
	    out.println(a*7);
	    out.close();
	    sc.close();
	}
	
	public static void f747_b() {
		Scanner sc = new Scanner(System.in);
	    PrintWriter out = new PrintWriter(System.out);
	    int n;
	    n = sc.nextInt();
	    int cA =0, cC = 0, cG =0, cT = 0, cQ=0;
	    String str = sc.next();
	    
	    for(int i=0; i < n; i++) {
	    	char a = str.charAt(i);
	    	if(a == 'A')
	    		cA++;
	    	if(a == 'C')
	    		cC++;
	    	if(a == 'G')
	    		cG++;
	    	if(a == 'T')
	    		cT++;
	    	if(a == '?')
	    		cQ++;
	    }
	    
	    int max = 0;
	    char c = 'A';
	    max = Math.max(Math.max(cA, cC), Math.max(cG, cT));
	    
	    int qalan = - cA - cC - cG - cT + 4 * max;
	    cA = max - cA;
	    cC = max - cC;
	    cG = max - cG;
	    cT = max - cT;
	    StringBuilder strB = new StringBuilder(str);
	    if(qalan == cQ) {
	    	for (int i = 0; i < n; i++) {
				if (strB.charAt(i) == '?') {
					if (cA > 0) {
						strB.setCharAt(i, 'A');
						cA--;
					} else if (cC > 0) {
						strB.setCharAt(i, 'C');
						cC--;
					} else if (cG > 0) {
						strB.setCharAt(i, 'G');
						cG--;
					} else if (cT > 0) {
						strB.setCharAt(i, 'T');
						cT--;
					}
					
				}
			}
	    	out.println(strB);
	    } else {
	    	if((cQ - qalan)%4 == 0 && ((cQ - qalan)) > 0) {
	    		for (int i = 0; i < n; i++) {
					if (strB.charAt(i) == '?') {
						if (cA > 0) {
							strB.setCharAt(i, 'A');
							cA--;
						} else if (cC > 0) {
							strB.setCharAt(i, 'C');
							cC--;
						} else if (cG > 0) {
							strB.setCharAt(i, 'G');
							cG--;
						} else if (cT > 0) {
							strB.setCharAt(i, 'T');
							cT--;
						}
						else { 
							strB.setCharAt(i, c);
							if(c == 'A') c = 'C';
							else if(c == 'C') c = 'G';
							else if(c == 'G') c = 'T';
							else if(c == 'T') c = 'A';
						}
					}
				}
	    		out.println(strB);
	    	} else {
	    		out.println("===");
	    	}
	    }
	    
	    out.close();
	    sc.close();
	}
	
	public static void f710_b() {
		Scanner sc = new Scanner(System.in);
	    PrintWriter out = new PrintWriter(System.out);
	    int res =0;
	    int n = 0;
	    n = sc.nextInt();
	    ArrayList<Integer> a = new ArrayList<>();
	    
	    for(int i=0; i<n; i++) {
	    	a.add(sc.nextInt());
	    }
	    Collections.sort(a);
	    
//	    if(arr[0] < 0) {
//	    	neg_val = arr[0];
//	    	for(int i=0; i<n; i++) {
//	    		arr[i] = arr[i] + neg_val; 
//	    	}
//	    }
//	    int a = (arr[0]+arr[n-1])/2;
//	    if(Arrays.asList(arr).contains(a)) {
//	    	if(ifneg && a==arr[0])
//	    	out.println(-arr[0]);
//	    }
//	    else 
//	    for(int i=0; i<n; i++) {
//	    	int k = a-i;
//	    	if(Arrays.asList(arr).contains(k)) {
//	    		out.println(a - i - neg_val);
//	    		break;
//	    	}
//	    	else if(Arrays.asList(arr).contains(a+i)) {
//	    		out.println(a + i - neg_val);
//	    		break;
//	    	}
//	    }
//	    out.println((um - maxMinus) + "");
	    int k=(n-1)/2;
	    out.println(a.get(k));
	    out.close();
	    sc.close();
	}
	
	public static void f705_a() {
		Scanner sc = new Scanner(System.in);
	    PrintWriter out = new PrintWriter(System.out);
	    int num = sc.nextInt();
	    
	    out.print("I hate");
	    
	    for(int i=1; i < num; i++) {
	    	out.print(" that ");
	    	if(i%2 == 0) 
	    		out.print("I hate");
	    	else 
	    		out.print("I love");
	    	
	    }
	    
	    	out.println(" it");
	    
	    out.close();
	    sc.close();
	}
	
	public static void f680_a() {
		Scanner sc = new Scanner(System.in);
	    PrintWriter out = new PrintWriter(System.out);
	    
	    int maxMinus =0;
	    
	    int [] arr = new int[5];
	    int um = 0;
	    for(int i=0; i<5; i++) {
	    	int a = sc.nextInt();
	    	um += a;
	    	arr[i] = a;
	    	int c = 1;
	    	for(int j=0; j < i; j++) {
	    		if(arr[j] == a) {
	    			c++;
	    		}
	    	}
	    	
	    	if((c==2 || c == 3) && maxMinus < c*a)
	    		maxMinus = c*a;
	    	
	    }
	    out.println((um - maxMinus) + "");
	    out.close();
	    sc.close();
	}
	
	public static void f681_a() {
		Scanner sc = new Scanner(System.in);
	    PrintWriter out = new PrintWriter(System.out);
	    boolean res = false;
	    long num = sc.nextInt();
	    
	    for(long h=0; ; h++) {
	    	if(res || (h*1234567 > num))
	    		break;
	    	for(long car=0; ; car++) {
	    		if(res || ((car*123456 + h*1234567) > num) )
	    			break;
	    		long de = num - (car*123456 + h*1234567);
	    		if((de % 1234) == 0) {
	    			res = true;
    				out.println("YES");
	    		}
//	    		for(long comp=0; ; comp++){
//	    			if((car*123456 + h*1234567 + comp*1234) > num)
//		    			break;
//	    			
//	    			if((car*123456 + h*1234567 + comp*1234) == num) {
//	    				res = true;
//	    				out.println("YES");
//	    				break;
//	    			}
//	    			
//	    		}
	    	}
	    }
	    
	    if(!res)
	    	out.println("NO");
	    
	    out.close();
	    sc.close();
	}
	
	public static void test(){
		int a = Integer.valueOf("b0", 18);
		System.out.println(a);
	}
	
	public static void problem_333_a(){

	    Scanner sc = new Scanner(System.in);
	    PrintWriter out = new PrintWriter(System.out);
	    //BigInteger a, b, c;
	    
	    //	l = sc.nextBigInteger();


	    int n, bx;
	    int m, by;
	    
	    
	    
	    n = sc.nextInt(); bx = sc.nextInt();
	    BigInteger nler = new BigInteger("0");
	    
	    BigInteger [] nn = new BigInteger[n]; 
	    
	    int temp=0;
	    for(int i=0; i<n; i++) {
//	    	System.out.println(Math.pow(bx,(n-i-1)));
//	    	temp = sc.nextInt();
//	    	String b = "" +  temp*(Math.pow(bx,(n-i-1)));
//	    	b = b.substring(0, b.indexOf('.'));
//	    			
//	    	nler = nler.add(new BigInteger(b));
	    	nn[i] = sc.nextBigInteger();
	    }
	    
	    m = sc.nextInt(); by = sc.nextInt();
	    BigInteger mler = new BigInteger("0");
	    BigInteger [] mm = new BigInteger[m]; 
	    for(int i=0; i<m; i++) {
//	    	System.out.println(Math.pow(bx,(n-i-1)));
//	    	temp = sc.nextInt();
//	    	String a = temp*(Math.pow(by,(m-i-1))) + "";
//	    	a = a.substring(0, a.indexOf('.'));
//	    	mler = mler.add(new BigInteger(a));
	    	mm[i] = sc.nextBigInteger();
	    }
	    boolean equalFlag = false;
	    BigInteger nSelf = new BigInteger("0");
	    BigInteger nRadix = new BigInteger("1");
	    
	    BigInteger mSelf = new BigInteger("0");
	    BigInteger mRadix = new BigInteger("1");
	    
	    if(n>m && bx>by) {
	    	System.out.println(">");
	    	equalFlag = true;
	    } else if(n<m && bx<by) {
	    	System.out.println("<");
	    	equalFlag = true;
	    } else if(n==m && bx==by) {
	    	for(int i=0; i<n; i++){
	    		if(nn[i].equals(mm[i]))
	    			equalFlag = true;
	    		else {equalFlag = false; break;}
	    	}
	    	if(equalFlag) {
	    		System.out.println("<");
	    		
	    	}
	    }
	    if(!equalFlag) {
	    	for(int i=0; i<n; i++) {
    			nSelf = nSelf.add(nRadix.multiply(new BigInteger(nn[n-1-i] + "")));
    			nRadix = nRadix.multiply(new BigInteger(bx+""));
    		}
    		
    		for(int i=0; i<m; i++) {
    			mSelf = mSelf.add(mRadix.multiply(new BigInteger(mm[m-1-i] + "")));
    			mRadix = mRadix.multiply(new BigInteger(by+""));
    		}
    		int res = nSelf.compareTo(mSelf);
    		if( res < 0) 
    			System.out.println("<");
    		else if(res == 0) {
    			System.out.println("=");
    		}
    		else System.out.println(">");
	    }
	    //System.out.format("%.0f%n", mler);
	    
//	    System.out.println(nler);
//	    System.out.println(mler);
	//    
//	    if( nler.compareTo(mler) == 0) System.out.println("=");
//	    else if( nler.compareTo(mler) > 0) System.out.println(">");
//	    else if( nler.compareTo(mler) < 0) System.out.println("<");
	    
	    out.println();
	    
	    out.close();
	    sc.close();
	    
		
	}
 
  
}