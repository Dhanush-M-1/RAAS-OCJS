import java.util.*;
public class Bolbs {
    public static void main (String[] args)  {
        Scanner scan= new Scanner(System.in);
        while(scan.hasNext()){
            int n= scan.nextInt();
            int m= scan.nextInt();

            ArrayList <Integer> ar= new ArrayList();
            for(int i=1;i<=n;i++){
                int s= scan.nextInt();              
                for(int j=1;j<=s;j++){
                    ar.add(scan.nextInt());
                }
            }
            int l= ar.size();
            int c=0;
            for(int j=1;j<=m;j++){          
                loop2:  for(int i=0;i<l;i++){
                    if(ar.get(i)==j){
                        c++;
                        break loop2;
                    }
                }
            if(c==m){
                System.out.println("YES");
                continue;
            }
            }
            if(c!= m){
                System.out.println("NO");

            }
        }
    }
}
