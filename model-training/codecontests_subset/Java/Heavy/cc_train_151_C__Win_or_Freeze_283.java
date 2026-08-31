//MohammedElkady
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
public class Hell {
static long ans,sum=1L,x=2;

    public static void main(String[] args) {
        Reader in =new Reader();
        long q=in.l();
        if(is_prim(q)){
            System.out.println("1");
            System.out.println("0");}
        else{
        if(ans==2){System.out.println("2");}
        else{System.out.println("1");System.out.println(sum);}}
    }

    static boolean is_prim(long x){
        boolean b=true;
    if(x%2==0&&x!=2){
        
        while(x%2==0&&x!=1){
        x/=2;
        
        ans++;
        if(ans<=2)
        sum*=2;
        }
        b= false;}
    for(long i=3;i*i<=x;i+=2){
    if(x%i==0){b= false;
    while(x%i==0&&x!=1){
        x/=i;
        ans++;
        if(ans<=2)
        sum*=i;
        if(ans>=3){i=x;break;}
        }
    }}
    if(x>1)ans++;
    return b;
    }
 static class Reader 
    { 
        private InputStream mIs;private byte[] buf = new byte[1024];private int curChar,numChars;public Reader() { this(System.in); }public Reader(InputStream is) { mIs = is;} 
        public int read() {if (numChars == -1) throw new InputMismatchException();if (curChar >= numChars) {curChar = 0;try { numChars = mIs.read(buf);} catch (IOException e) { throw new InputMismatchException();}if (numChars <= 0) return -1; }return buf[curChar++];} 
        public String nextLine(){int c = read();while (isSpaceChar(c)) c = read();StringBuilder res = new StringBuilder();do {res.appendCodePoint(c);c = read();}while (!isEndOfLine(c));return res.toString() ;} 
        public String s(){int c = read();while (isSpaceChar(c)) c = read();StringBuilder res = new StringBuilder();do {res.appendCodePoint(c);c = read();}while (!isSpaceChar(c));return res.toString();} 
        public long l(){int c = read();while (isSpaceChar(c)) c = read();int sgn = 1;if (c == '-') { sgn = -1 ; c = read() ; }long res = 0; do{ if (c < '0' || c > '9') throw new InputMismatchException();res *= 10 ; res += c - '0' ; c = read();}while(!isSpaceChar(c));return res * sgn;} 
        public int nextInt(){int c = read() ;while (isSpaceChar(c)) c = read();int sgn = 1;if (c == '-') { sgn = -1 ; c = read() ; }int res = 0;do{if (c < '0' || c > '9') throw new InputMismatchException();res *= 10 ; res += c - '0' ; c = read() ;}while(!isSpaceChar(c));return res * sgn;} 
        public double d() throws IOException {return Double.parseDouble(s()) ;}
        public boolean isSpaceChar(int c) { return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1; } 
        public boolean isEndOfLine(int c) { return c == '\n' || c == '\r' || c == -1; } 
        public int[] arr(int n){int[] ret = new int[n];for (int i = 0; i < n; i++) {ret[i] = nextInt();}return ret;}
    }   
}
class HashTable{
List[]Table;
HashTable(int size){
Table=new List[size];
while(size-->0){
Table[size]=new ArrayList();
}
}
void Hashing(int kay,int value){
Table[kay].add(value);
}
void Delet(int key,int value){
for(int i=0;i<Table[key].size();i++)
    if(value==(int)Table[key].get(i)){
        Table[key].remove(i);i--;}
}
ArrayList getTable(int key){
    return (ArrayList) Table[key];

}
void Uptodate(int key ,int value , int nextvalue){
for(int i=0;i<Table[key].size();i++)
    if(Table[key].get(i).equals(value)){
        Table[key].remove(i);Table[key].add(nextvalue);i--;}

}
}