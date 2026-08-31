import java.util.*;
import java.lang.*;
public class Cf1334A {
public static void main(String[] args) {
Scanner sc=new Scanner(System.in);
int t,n,i,l;
t=sc.nextInt();
while(t>0) {
l=0;
n=sc.nextInt();
int []p=new int[n];
int []c=new int[n];
for (i=0;i<n;i++) {
p[i]=sc.nextInt();
c[i]=sc.nextInt();
}
for (i=0;i<n;i++) {
if (i==0) {
if(p[i]<c[i]) {
System.out.println("NO");
l=1;
break;
}
}
else {
if(p[i]<c[i] || p[i]<p[i-1] || c[i]<c[i-1] || (p[i]-p[i-1])<(c[i]-c[i-1])) {
l=1;
System.out.println("NO");
break;
}
}
}
if(l==0)
System.out.println("YES");
t--;
}
sc.close();
}

}
