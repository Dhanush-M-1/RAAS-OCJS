import java.util.*;

public class Main{
	
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
  	int n=sc.nextInt(),m=sc.nextInt(),e=0;
    long[] a=new long[n],b=new long[n],c=new long[m],d=new long[m];
    long min=1000000000;
    for(int i=0;i<n;i++){
      a[i]=sc.nextLong();
      b[i]=sc.nextLong();
    }
    for(int j=0;j<m;j++){
      c[j]=sc.nextLong();
      d[j]=sc.nextLong();
    }
    for(int i=0;i<n;i++){
      for(int j=0;j<m;j++){
        long f=(long)Math.abs((double)(a[i]-c[j]))+(long)Math.abs((double)(b[i]-d[j]));
        if(min>f){
          e=j+1;
          min=f;
        }
      }
      System.out.println(e);
      min=1000000000;
      e=0;
    }
  }
}
