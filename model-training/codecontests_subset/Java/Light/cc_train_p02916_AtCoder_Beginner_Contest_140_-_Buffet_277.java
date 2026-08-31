import java.util.*;
class Main{
  public static void main(String args[]){
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int a[]=new int[n];
    int b[]= new int[n];
    int c[] =new int[n-1];
    for(int i=0;i<n;i++){
      a[i]=sc.nextInt();
    }
    for(int i=0;i<n;i++){
      b[i]=sc.nextInt();
    }
    for(int i=0;i<n-1;i++){
     c[i]=sc.nextInt();
    }
    int index=-100;int sum=0;
    for(int i=0;i<n;i++){
      
      if(a[i]==index+1){
        sum+=b[a[i]-1]+c[index-1];
      }
      else{
        sum+=b[a[i]-1];
      }
      index = a[i];
    }
    System.out.println(sum);
  }
}
    