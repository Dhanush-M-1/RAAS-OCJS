import java.util.Scanner;

public class Main {


    private static void getDepth(int currentDepth,int left,int right,int[] dArray,int[] arr)
    {
        int maxvalue=Integer.MIN_VALUE;
        int position=-1;
        if(left>right)
        {
            return;
        }
        for(int i=left;i<=right;i++)
        {
            if(arr[i]>maxvalue)
            {
                maxvalue=arr[i];
                position=i;
            }
        }
        dArray[position]=currentDepth;
        getDepth(currentDepth+1,left,position-1,dArray,arr);
        getDepth(currentDepth+1,position+1,right,dArray,arr);
    }

    private static int[] solution(int[] arr)
    {
        int[] dArray=new int[arr.length];
        getDepth(0,0,arr.length-1,dArray,arr);
        return dArray;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t > 0) {

            int n=scanner.nextInt();
            int[] arr =new int[n];
            for(int i=0;i<n;i++)
            {
                arr[i]=scanner.nextInt();
            }
            int[] dArray = solution(arr);
            for (int i=0;i<dArray.length;i++)
            {
                System.out.print(dArray[i]+" ");
            }
            System.out.println();
            t--;
        }
    }

}
