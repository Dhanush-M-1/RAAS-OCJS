import java.util.*;
public class nz {
 public static void main(String[] args) {
  Scanner no=new Scanner(System.in);
  int n=no.nextInt();
  long m=no.nextLong();
  long ans=0;
  long arr[]=new long[n];
  for(int i=0;i<n;i++){
    arr[i]=no.nextLong();
  }
  Arrays.sort(arr);
  int o=(n-1)/2;
  ans=Math.abs(arr[o]-m);
  if(arr[o]<=m){
    arr[o]=arr[o]+ans;
    while(o<n-1&&arr[o+1]<m){
      ans+=Math.abs(arr[o+1]-m);
      o++;
    }
  }
  else{
    for(int i=0;i<o;i++){
     if(arr[i]>m){
      ans+=Math.abs(arr[i]-m);
     }
    }
  }
  System.out.println(ans);
 }

}