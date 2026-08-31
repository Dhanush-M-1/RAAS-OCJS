import java.io.*;
public class Mafia{
/*static long ans;
static long findans(long[] a){

while(sum(a)!=0)
{

long  m=findMin(a);
decAllByOne(a,m);
++ans;


}
return ans;


}
static long sum(long[] a){

long s=0;
for(long i:a)
	s += i;
return s;



}

static long findMin(long[] a)
{

int min=0;
for(int i=1;i<a.length;i++)
{
	if(a[i]<a[min])
		min=i;


}

return min;

}
static void decAllByOne(long[] a,long m){

for(int i=0;i<a.length;i++)
{

if(i==m || a[i]==0)
	continue;
--a[i];


}


}*/

public static void main(String[] args) throws IOException{

BufferedReader r=new BufferedReader(new InputStreamReader(System.in));
int n=Integer.parseInt(r.readLine());
long[] a=new long[n];
String[] s=(r.readLine()).split(" ");
long sum=0l;
long max=Long.MIN_VALUE;
for(int i=0;i<n;i++){
	a[i]= Long.parseLong(s[i]);
	sum += a[i];
	if(a[i] > max) max=a[i];

}



long ans=(long)Math.ceil((double)sum/(double)(n-1));
long ans2=Math.max(ans,max);
System.out.println(ans2);
}


}