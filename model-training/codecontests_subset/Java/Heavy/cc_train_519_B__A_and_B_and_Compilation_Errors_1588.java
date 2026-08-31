import java.util.*;

public class CompailationError_CF_519B {
    public static void main(String[] args) {
        int n,a=0,b=0,c=0;
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        Stack<Integer>st=new Stack<>();
        LinkedList<Integer>ll=new LinkedList<>();
        int com1[]=new int[n];
        int com2[]=new int[n];
        int com3[]=new int[n];
        int[] newArray=new int[n];
        int[] newArray2=new int[n];
        for (int i=0;i<n;i++){
            //ll.add(sc.nextInt());
            com1[i]=sc.nextInt();
        }
        for (int i=0;i<n-1;i++){
            com2[i]=sc.nextInt();

        }
        for (int i=0;i<n-2;i++){
            com3[i]=sc.nextInt();
        }
        for (int i=0;i<n;i++){
            //ll.add(sc.nextInt());
          a+=com1[i];
        }
        for (int i=0;i<n-1;i++){

            b+=com2[i];
        }
        for (int i=0;i<n-2;i++){
            c+=com3[i];
        }
        System.out.println((a-b));
        System.out.println((b-c));

    }
}
