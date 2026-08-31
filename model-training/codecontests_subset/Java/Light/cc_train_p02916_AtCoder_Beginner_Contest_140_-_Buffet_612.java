import java.util.Scanner;

class Main
{
    public static void main(String[] args)
    {
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      int[] a = new int[30];
      int[] b = new int[30];
      int[] c = new int[30];
      for (int i=0; i<n; i++) a[i] = sc.nextInt();
      for (int i=0; i<n; i++) b[i] = sc.nextInt();
      for (int i=0; i<n-1; i++) c[i] = sc.nextInt();
      int count = 0;
      for (int i=0; i<n; i++) {
        count += b[a[i]-1];
        if(i>0 && a[i]-a[i-1]==1) {
          count += c[a[i-1]-1];
        }
      }
      System.out.println(count);
    }
}

