import java.util.*;
public class codechef{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
       
           int n=sc.nextInt();
           int k=sc.nextInt();
           int p,a,b;
           PriorityQueue<Integer> p1=new PriorityQueue<>();
           PriorityQueue<Integer> p2=new PriorityQueue<>();
           PriorityQueue<Integer> p3=new PriorityQueue<>();
           for(int i=0;i<n;i++){
               p=sc.nextInt();
               a=sc.nextInt();
               b=sc.nextInt();
               if(a==0 && b==1)
               {p1.add(p);}
               if(a==1 && b==0)
               {p2.add(p);}
               if(a==1 && b==1)
               {p3.add(p);}
            }
            int ans=0;
            
           for(int i=0;i<k;i++){
               if((p1.isEmpty() && p3.isEmpty()) || (p2.isEmpty() && p3.isEmpty()))
               {ans=-1;
                break;}
               if(!p1.isEmpty() && !p2.isEmpty() && !p3.isEmpty())
               {
                   if((p1.element()+p2.element())>p3.element())
                   {ans=ans+p3.remove();}
                   else
                   {ans=ans+p1.remove()+p2.remove();
                    }
                }
                else{
                if(!p1.isEmpty() && !p2.isEmpty() && p3.isEmpty())
                {
                    ans=ans+p1.remove()+p2.remove();
                    
                }
                else{
                if((p1.isEmpty() && p2.isEmpty())|| (p1.isEmpty() && !p2.isEmpty())||(!p1.isEmpty() && p2.isEmpty()))
                {
                    ans=ans+p3.remove();
                }
            }
             }
            }
            System.out.println(ans);
        
    }
}
