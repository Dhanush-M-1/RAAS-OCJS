import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
public class codeforces {

    public static long gcd(long x,long y){
        if(y==0)
        return x;
        return gcd(y,x%y);
    }
    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        // StringBuilder str=new StringBuilder();
        PrintWriter out = new PrintWriter(System.out);
        long num=Long.parseLong(br.readLine());
        ArrayList<Long> arrayList=new ArrayList<>();
        for(int i=1;i<=(int) Math.sqrt(num);i++){
            if(num%i==0){
                arrayList.add((long) i);
                arrayList.add(num/i);
            }
        }
        Collections.sort(arrayList);
        int size=arrayList.size();
        long min=Long.MAX_VALUE,extra=0;
        int s=0,e=size-1;
        while(s<e){
            long a=arrayList.get(s),b=arrayList.get(e);
            b=gcd(a,b)*b;
            if(b<min){
                min=b;
                extra=a;
            }            
            s++;
            e--;
        }      
        out.println(extra+" "+min);
        out.close();
    }
}