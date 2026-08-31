import java.util.Scanner;

public class Games {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n;
    int cont=0;
    int a,b;
    int local[] = new int[105];
    int visitor[] = new int[105];
    for(int i=0; i<105; i++)
    {
        local[i]=0;
        visitor[i]=0;
    }
    n = sc.nextInt();
    for(int i=0; i<n; i++)
    {
        a = sc.nextInt();
        b = sc.nextInt();
        local[a]++;
        visitor[b]++;
    }
    for(int i=0; i<105; i++)
    {
        if(local[i]>0 && visitor[i]>0)
        {
            cont+=local[i]*visitor[i];
        }
    }
    System.out.println(cont);
  }
}