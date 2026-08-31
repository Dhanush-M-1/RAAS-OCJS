import java.util.*;
import java.io.*;
public class Sol2{
public static void main(String args[]) throws IOException{
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
StringTokenizer st=new StringTokenizer(br.readLine());

int n=Integer.parseInt(st.nextToken());
long m=Long.parseLong(st.nextToken());
long count=0;
StringTokenizer st1=new StringTokenizer(br.readLine());

int[] a=new int[n];
TreeMap<Long,Integer> map=new TreeMap<Long,Integer>();
for(int i=0;i<n;i++){
a[i]=Integer.parseInt(st1.nextToken());
count+=i+1;
map.put(count,i+1);

}


int x=(int)(m-map.floorKey(m));
if(x==0){
int ly=map.get(map.floorKey(m));
System.out.println(a[ly-1]);
}
else
System.out.println(a[x-1]);

}
}

