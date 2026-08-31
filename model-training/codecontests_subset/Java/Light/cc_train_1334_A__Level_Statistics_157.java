import java.util.Scanner;

public class codeforceseducational85 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        for (int i = 0; i < a; i++) {
            int b = s.nextInt();
//            String c=s.next();
            int arr[] = new int[b];
            int arr1[] = new int[b];
            boolean yes = true;
            for (int j = 0; j < b; j++) {
                arr[j] = s.nextInt();
                arr1[j] = s.nextInt();
                if (arr1[j] > arr[j])
                    yes = false;
                if(arr1[j]<0||arr[j]<0)
                    yes=false;
            }
            if (yes == true) {
                for (int j = 0; j < b-1; j++) {
                    if(arr[j]>arr[j+1]||arr1[j]>arr1[j+1]) {
                        yes = false;
                        break;
                    }
                    if(arr[j+1]-arr[j]<arr1[j+1]-arr1[j]){
                        yes=false;
                        break;
                    }
                }
            }
            if(yes==true)
                System.out.println("yes");
            else
                System.out.println("no");
        }
    }
}
