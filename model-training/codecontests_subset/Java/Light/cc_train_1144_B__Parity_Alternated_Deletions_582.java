import java.util.*;
public class shashwat{
    static Scanner in=new Scanner(System.in);
public static void main(String args[]){
    int n=in.nextInt();
    int arr[]=new int[n];
    
    PriorityQueue<Integer> o=new PriorityQueue<Integer>(Collections.reverseOrder());
    PriorityQueue<Integer> e=new PriorityQueue<Integer>(Collections.reverseOrder());
    
    for(int i=0;i<n;i++) {
        arr[i]=in.nextInt();
        if(arr[i]%2==0)
            e.add(arr[i]);
        else
            o.add(arr[i]);
    }
   // System.out.println(o.peek());
    PriorityQueue<Integer> temp=new PriorityQueue<Integer>(Collections.reverseOrder());
   // System.out.println(o.size()+" "+e.size());
    if(o.size()<e.size()){
        
   // System.out.println(o.size()+" "+e.size());
        temp=e;
        e=o;
        o=temp;
    }
    
   // System.out.println(o.size()+" "+e.size());
    while(e.size()!=0){
        e.poll();
        o.poll();
    }
    if(o.size()!=0){
        o.poll();
    }
    long sum=0;
    while(o.size()!=0){
        sum+=o.poll();
    }
    System.out.println(sum);
}
}