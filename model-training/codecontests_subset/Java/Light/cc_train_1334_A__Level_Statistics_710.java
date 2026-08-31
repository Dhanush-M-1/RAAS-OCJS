import java.util.*;
import java.util.ArrayList;
public class Main{   
     static class Pair{
     int x;
     int y;
       Pair(){
       
       }
       Pair(int x,int y){
       this.x=x;
       this.y=y;
       }
     }
    
 
    public static void main(String[] args)
    {
    Scanner param = new Scanner(System.in);
    int end=param.nextInt();
     c:while(end-->0){
    int n=param.nextInt();
    Pair arr[]=new Pair[n];
    for(int i=0;i<n;i++)
    {
    arr[i]=new Pair(param.nextInt(),param.nextInt());
    }
    int play=0;
    int clear=0;
    int f=0;
    if(n==1){
    if(arr[0].x>=arr[0].y){
    System.out.println("YES");
    
    }
    else{
      System.out.println("NO");
    }
    }
    else{
  for(int i=1;i<n;i++){
 
  if(arr[i].x>=arr[i].y&&arr[i-1].x>=arr[i-1].y&&arr[i].x>=arr[i-1].x&&arr[i].y>=arr[i-1].y&&arr[i].x-arr[i-1].x>=arr[i].y-arr[i-1].y){
  
  continue; 
  }
  else{
  f=1;
  }
  
 
    }
    if(f==1){
        System.out.println("NO");
    }
    else{
    System.out.println("YES");
    }
     }
     }
}
}