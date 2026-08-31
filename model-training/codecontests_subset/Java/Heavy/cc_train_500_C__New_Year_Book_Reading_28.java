import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Vector;
public class Bookreading {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String brr[]=br.readLine().trim().split(" ");
        int n=Integer.parseInt(brr[0]);
        int m=Integer.parseInt(brr[1]);
        Vector v=new Vector(m);
       int weight[]=new int[n];
       int books[]=new int[m];
        brr=br.readLine().trim().split(" ");
        int i;
        Iterator it=v.iterator();
        for(i=0;i<n;i++)
        {
            weight[i]=Integer.parseInt(brr[i]);
        }
        brr=br.readLine().trim().split(" ");
        for(i=0;i<m;i++)
        {
            books[i]=Integer.parseInt(brr[i]);
        }
        int k,sum=0,j;
        for(i=0;i<m;i++)
        {
            int ctr=0;
            if(v.isEmpty())
            {
                v.add(books[i]);
               // System.out.println((weight[books[i]-1));
                
            }
            else 
            {
                for(j=v.indexOf(v.lastElement());j>=v.indexOf(v.firstElement());j--)
                {
                    //System.out.println(j);
                    k=(int) v.get(j);
                   // System.out.println(k);
                    ctr++;
                    if (k==books[i])
                    {
                       //  System.out.println((v.indexOf(v.firstElement())+v.size()-ctr));
                        // System.out.println(v.elementAt(4));
                        v.remove(v.indexOf(v.firstElement())+v.size()-ctr);
                        //System.out.println(v.elementAt(4));
                        break;
                    }
                    else
                    {
                        // System.out.println();
                        sum+=weight[k-1];
                          // System.out.println(sum);
                    }
                }
               // System.out.println(v.lastElement());
                //System.out.println(v.size());
                v.add(books[i]);
                 // System.out.println(v.lastElement());
                //System.out.println(v.size());
            }
        }
        System.out.println(sum);
    }
}
            
            
    
