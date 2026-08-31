import java.util.*;
public class square
{
 
    public static void main(String ar[])
    {
        Scanner sc=new Scanner(System.in);
        int req=sc.nextInt(),has=sc.nextInt(),time=sc.nextInt();
       if(has>req) {System.out.println("0");return;}
       int nec=(req-has)*time;int curr=0;
       while(has*curr<nec)curr++;
       
System.out.println(curr);
      
}

}