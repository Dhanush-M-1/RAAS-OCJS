import java.util.*;
public class Main {
  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    int a[]=new int[n];
    ArrayList<Integer> ev=new ArrayList<>();
    ArrayList<Integer> od=new ArrayList<>();
    int e=0,o=0;
     for(int i=0;i<n;i++){
       a[i]=sc.nextInt();
       if(a[i]%2==0) {e++;ev.add(a[i]);}
       else {o++;od.add(a[i]);}
    }
    Collections.sort(ev);
    Collections.sort(od);
    if((e-o)==0||Math.abs(e-o)==1) System.out.println(0);
    else 
    {
      int sum=0;
      if(e>o){
        int k=ev.size()-od.size();
        for(int i=0;i<k-1;i++){
          sum+=ev.get(i);
        }
        System.out.println(sum);
      }else{
        int k=od.size()-ev.size();
        for(int i=0;i<k-1;i++){
          sum+=od.get(i);
        }
        System.out.println(sum);
      }
    }

  }
}