import java.util.*;
import java.io.*;
public class test6
{     
 
      

 

    public static void main(String []Args)throws Exception
    {    
   
   
   
  //BufferedReader br=new InputStreamReader(System.in);
Scanner sc=new Scanner(System.in);
int n=sc.nextInt();
ArrayList<Integer> odd=new ArrayList<Integer>();
ArrayList<Integer> even=new ArrayList<Integer>();
for(int i=0;i<n;i++){
  int x=sc.nextInt();
  if(x%2==0){
    even.add(x);
  }else{
    odd.add(x);
  }
}
int os=odd.size();
int es=even.size();
if(os==es){
  System.out.println(0);
  return ;
}
if(os>es){
  
  os=os-(es+1);
  Collections.sort(odd);
  long sum=0;
  for(int i=0;i<os;i++){
    sum+=odd.get(i);
  }
  System.out.println(sum);
  return;
}
if(es>os){
  
  es=es-(os+1);
  Collections.sort(even);
  long sum=0;
  for(int i=0;i<es;i++){
    sum+=even.get(i);
  }
  System.out.println(sum);
  return;

}

}
}
            
             