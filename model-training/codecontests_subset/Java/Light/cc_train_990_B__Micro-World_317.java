import com.sun.security.jgss.GSSUtil;

import javax.swing.table.AbstractTableModel;
import java.io.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

//_________________________________________________________________
public class Main {

    public static void main(String[] args) throws IOException {
        Scanner sc= new Scanner(System.in);
//        int t=sc.nextInt();
//        while (t-->=1){
            int n=sc.nextInt(),k=sc.nextInt();
            int a[]= new int[n];
        int ans[]= new int[(int)(2*1e6+10)];
        ArrayList<Integer> list= new ArrayList<>();
        for (int i=0;i<n;i++){
                a[i]=sc.nextInt();
        }
//        Arrays.sort(a);
        for (int i=0;i<n;i++){
            ans[a[i]]++;
            list.add(a[i]);
        }
        Collections.sort(list);
        int c=0;
            for (int i=1;i<n;i++){
                if (list.get(i)>list.get(i-1)&&list.get(i)<=k+list.get(i-1)){

                   c+=ans[list.get(i-1)];
                }
            }
        System.out.println(n-c);


        }


    }


