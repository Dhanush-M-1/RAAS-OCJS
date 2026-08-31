import java.io.InputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.math.BigInteger;
 
public class Main{
 
static PrintWriter out;
static InputReader ir;
 
static void solve(){
 int n=ir.nextInt();
 char[] com;
 String s;
 while(n-->0){
  com=new StringBuilder(ir.next()).reverse().toString().toCharArray();
  s=ir.next();
  for(int i=0;i<com.length;i++){
   if(com[i]=='J') s=J(s);
   else if(com[i]=='C') s=C(s);
   else if(com[i]=='E') s=E(s);
   else if(com[i]=='A') s=A(s);
   else if(com[i]=='P') s=P(s);
   else s=M(s);
  }
  out.println(s);
 }
}
 
public static String C(String s){
 return s.substring(1)+s.substring(0,1);
}
 
public static String J(String s){
 return s.substring(s.length()-1)+s.substring(0,s.length()-1);
}
 
public static String E(String s){
 if(s.length()%2==0){
  return s.substring(s.length()/2)+s.substring(0,s.length()/2);
 }
 else{
  return s.substring((s.length()+1)/2)+s.substring((s.length()-1)/2,(s.length()+1)/2)+s.substring(0,(s.length()-1)/2);
 }
}
 
public static String A(String s){
 return new StringBuilder(s).reverse().toString();
}
 
public static String M(String s){
 char[] ss=s.toCharArray();
 for(int i=0;i<s.length();i++){
  if(ss[i]>='0'&&ss[i]<='9'){
   if(ss[i]=='9') ss[i]='0';
   else ss[i]++;
  }
 }
 return String.valueOf(ss);
}
 
public static String P(String s){
 char[] ss=s.toCharArray();
 for(int i=0;i<s.length();i++){
  if(ss[i]>='0'&&ss[i]<='9'){
   if(ss[i]=='0') ss[i]='9';
   else ss[i]--;
  }
 }
 return String.valueOf(ss);
}
 
public static void main(String[] args) throws Exception{
 ir=new InputReader(System.in);
 out=new PrintWriter(System.out);
 solve();
 out.flush();
}
 
static class InputReader {
 private InputStream in;
 private byte[] buffer=new byte[1024];
 private int curbuf;
 private int lenbuf;
 
 public InputReader(InputStream in) {this.in=in; this.curbuf=this.lenbuf=0;}
  
 public boolean hasNextByte() {
  if(curbuf>=lenbuf){
   curbuf= 0;
   try{
    lenbuf=in.read(buffer);
   }catch(IOException e) {
    throw new InputMismatchException();
   }
   if(lenbuf<=0) return false;
  }
  return true;
 }
 
 private int readByte(){if(hasNextByte()) return buffer[curbuf++]; else return -1;}
  
 private boolean isSpaceChar(int c){return !(c>=33&&c<=126);}
  
 private void skip(){while(hasNextByte()&&isSpaceChar(buffer[curbuf])) curbuf++;}
  
 public boolean hasNext(){skip(); return hasNextByte();}
  
 public String next(){
  if(!hasNext()) throw new NoSuchElementException();
  StringBuilder sb=new StringBuilder();
  int b=readByte();
  while(!isSpaceChar(b)){
   sb.appendCodePoint(b);
   b=readByte();
  }
  return sb.toString();
 }
  
 public int nextInt() {
  if(!hasNext()) throw new NoSuchElementException();
  int c=readByte();
  while (isSpaceChar(c)) c=readByte();
  boolean minus=false;
  if (c=='-') {
   minus=true;
   c=readByte();
  }
  int res=0;
  do{
   if(c<'0'||c>'9') throw new InputMismatchException();
   res=res*10+c-'0';
   c=readByte();
  }while(!isSpaceChar(c));
  return (minus)?-res:res;
 }
  
 public long nextLong() {
  if(!hasNext()) throw new NoSuchElementException();
  int c=readByte();
  while (isSpaceChar(c)) c=readByte();
  boolean minus=false;
  if (c=='-') {
   minus=true;
   c=readByte();
  }
  long res = 0;
  do{
   if(c<'0'||c>'9') throw new InputMismatchException();
   res=res*10+c-'0';
   c=readByte();
  }while(!isSpaceChar(c));
  return (minus)?-res:res;
 }
 
 public double nextDouble(){return Double.parseDouble(next());}
 
 public int[] nextIntArray(int n){
  int[] a=new int[n];
  for(int i=0;i<n;i++) a[i]=nextInt();
  return a;
 }
 
 public long[] nextLongArray(int n){
  long[] a=new long[n];
  for(int i=0;i<n;i++) a[i]=nextLong();
  return a;
 }
 
 public char[][] nextCharMap(int n,int m){
  char[][] map=new char[n][m];
  for(int i=0;i<n;i++) map[i]=next().toCharArray();
  return map;
 }
}
}