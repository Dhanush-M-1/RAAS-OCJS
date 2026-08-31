import java.util.*;
import java.io.*;
public final class BadTriangle{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        for(int i=0;i<n;i++){
            int numLengths=sc.nextInt();
            TreeMap<Integer,TreeSet<Integer>> triangleSides=new TreeMap<Integer,TreeSet<Integer>>();
            int sidesArray[]=new int[numLengths];
            for(int j=0;j<numLengths;j++){
                int side=sc.nextInt();
                triangleSides.putIfAbsent(side,new TreeSet<Integer>());
                triangleSides.get(side).add(j);
                sidesArray[j]=side;
            }
            boolean flag=true;
            for(int k=0;k<numLengths-2;k++){
                int val=sidesArray[k]+sidesArray[k+1];
                Map.Entry<Integer,TreeSet<Integer>> nxtEntry=triangleSides.ceilingEntry(val);
                if(nxtEntry!=null){
                    if(nxtEntry.getValue().ceiling(k+2)!=null){
                        int nxtPos=nxtEntry.getValue().ceiling(k+2);
                        System.out.println(String.format("%d %d %d",k+1,k+2,nxtPos+1));
                        flag=false;
                        break;
                    }
                }
            }
            if(flag){
                System.out.println(String.format("%d",-1));
            }

        }
    }
}