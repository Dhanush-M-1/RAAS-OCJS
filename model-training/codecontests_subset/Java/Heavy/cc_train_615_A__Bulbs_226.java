import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    // public static Scanner input = new Scanner(System.in);
    public static void main(String[] args)
            throws IOException {

        Scanner input = new Scanner(System.in);
        // BufferedReader buffer=new BufferedReader(new InputStreamReader(System.in));
int n=input.nextInt();
int m= input.nextInt();
 Set<Integer>set=new HashSet<>();
 Set<Integer>set2=new HashSet<>();
     
   for(int i=0;i<m;i++)
       set.add(i+1);
   for(int i=0;i<n;i++){
       int b=input.nextInt();
       for(int ii=0;ii<b;ii++){
           set2.add(input.nextInt());
       }
   }
   if(set.size()==set2.size()){
Iterator iter = set.iterator();
Iterator iter2 = set2.iterator();
while (iter.hasNext()) {
   if(iter.next()!=iter2.next()){
       System.out.println("NO");
       return;
   }
}
       System.out.println("YES");
   }else
        System.out.println("NO");
       
}
}