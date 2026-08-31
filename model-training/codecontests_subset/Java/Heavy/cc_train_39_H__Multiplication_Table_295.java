import java.io.*;
import java.util.*;
import java.math.*;
public class Solution
{
   BufferedReader in;
   PrintWriter out;
   StringTokenizer ss;

String _token()throws IOException
{
   while (!ss.hasMoreTokens())ss=new StringTokenizer(in.readLine());
   return ss.nextToken();
}
int _int()throws IOException{return Integer.parseInt(_token());}
long _long()throws IOException{return Long.parseLong(_token());}
double _double()throws IOException{return Double.parseDouble(_token());}
void dbg(String s){System.out.println(s);}

BigInteger ad(BigInteger A, BigInteger B){return (A.add(B));}
BigInteger mu(BigInteger A, BigInteger B){return (A.multiply(B));}
BigInteger su(BigInteger A, BigInteger B){return (A.subtract(B));}
BigInteger di(BigInteger A, BigInteger B){return A.divide(B);}
BigInteger mi(BigInteger A){return (BigInteger.ZERO).subtract(A);}
BigInteger sq(BigInteger A){return (A.multiply(A));}
BigInteger va(long a){return BigInteger.valueOf(a);}

BigDecimal val(double a){return BigDecimal.valueOf(a);};
BigDecimal mult(BigDecimal a, BigDecimal b){return a.multiply(b);}
BigDecimal div(BigDecimal a, BigDecimal b){return a.divide(b,30,RoundingMode.CEILING);}
BigDecimal add(BigDecimal a, BigDecimal b){return a.add(b);}
BigDecimal sub(BigDecimal a, BigDecimal b){return a.subtract(b);}


void RUN()throws IOException
{
   in = new BufferedReader(new InputStreamReader(System.in));
   out = new PrintWriter(System.out);
   ss = new StringTokenizer(" "); 

   int n = _int();
   
   for(int i=1;i<n;i++)
     {for(int j=1;j<n;j++)
       {
         BigInteger a = new BigInteger(i+"",n);
         BigInteger b = new BigInteger(j+"",n);
         out.print(mu(a,b).toString(n)+" ");

       }
       out.println();
     }
   out.close();
}

public static void main(String[] args)throws Exception
  {
     new Solution().RUN();
  }
}