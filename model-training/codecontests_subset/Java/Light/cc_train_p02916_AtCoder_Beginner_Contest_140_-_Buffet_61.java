import java.util.*;
class Main{
public static void main(String[] args){
	Scanner sc=new Scanner(System.in);
  	int n=sc.nextInt();
  	int[] a= new int[n];
  	for(int b=0;b<n;b++){
   	a[b]=sc.nextInt();
    }
    int count=0;
    for(int b=0;b<n;b++){
    int ad=sc.nextInt();
    count+=ad;
    ad=0;
    }
  	int[] c=new int[n-1];
    for(int b=0;b<n-1;b++){
   	c[b]=sc.nextInt();
    }
  	for(int d=0;d<n-1;d++){
    if((a[d]+1)==a[d+1]){ count+=c[a[d]-1];}
    }
  	System.out.println(count);

}
}