import java.util.*;
public class Rec {
      static HashMap<String,Integer> h=new HashMap<>();
public static void main(String [] args){
Scanner sc=new Scanner(System.in);
int n=sc.nextInt();
sc.nextLine();
String s= sc.nextLine();
for(int i=0;i<n-1;i++){
   String k=s.substring(i,i+2);
   if(!h.containsKey(k))
      h.put(k,1);
   else{
         h.put(k,h.get(k)+1);
   }

}
int m=0;
String max=s;
for(String check:h.keySet()){
      if(h.get(check)>m){
            m=h.get(check);
            max=check;
      }
}
System.out.println(max);

}
}