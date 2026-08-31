import java.util.Scanner;
public class officekeys {
   static int []a =new int  [2001];
   static int []b =new int  [2001];
   
   static boolean[]c=new boolean[2001];
static int l,h,tg,dk;
static long x1,y1,result=0,result1=0;    
static int n,m,m1,i,j;

   public static void quicksort(int []a1,int x,int y){
if (x<y){
    tg=a1[(x+y)/2];
    l=x;h=y;
    while (l<=h){
    while (a1[l]<tg) l++;
    while (a1[h]>tg) h--;
    if (l<=h){
    if(l<h){
    dk=a1[l];
    a1[l]=a1[h];
    a1[h]=dk;
     }
    l++;h--;
   
    }


}
quicksort(a1,x,h);quicksort(a1,l,y);    
}
    }
    public static void xuli(int p){
    int vt=0,kq,d1;
    long dk;
            long c1=1000000000;
            c1=c1*10;
    for (kq=0;kq++<m;)
        if (c[kq]==false){
            d1=Math.abs(p-b[kq]);
        dk=d1+Math.abs(b[kq]-m1);
            if (dk<c1){
            c1=d1+Math.abs(b[kq]-m1);
        vt=kq;
        }
        }
    c[vt]=true;
    if (result<c1) result=c1; 
    }
    
    public static void main(String argv[]){
    Scanner input=new Scanner(System.in);

long c2=1000000000;
            c2=c2*10;
long ma=0;
            n=input.nextInt();
m=input.nextInt();
m1=input.nextInt();
for (i=0;i++<n;)
    a[i]=input.nextInt();
quicksort(a,1,n);
for (i=0;i++<m;)
b[i]=input.nextInt();
quicksort(b,1,m);
i=0;
while (i<=(m-n)){
    ma=0;
    for (j=0;j++<n;){
        x1=Math.abs(a[j]-b[i+j])+Math.abs(b[i+j]-m1);
        if (x1>ma) ma=x1;
    }
if (ma<c2) c2=ma;
i++;
}
System.out.print(c2);

    }
    }

