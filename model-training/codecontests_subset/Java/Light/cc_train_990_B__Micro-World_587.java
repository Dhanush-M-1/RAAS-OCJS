



    import java.util.*;


    public class Main {

        public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
             int n = input.nextInt();
             int k = input.nextInt();
             int ans[] = new int[2000000];
            Integer a[] = new Integer[n];
            for (int i = 0; i < n; i++) {
                a[i] = input.nextInt();
                ans[a[i]]++;
            }
            Arrays.sort(a);
            int count=0;
            for (int i = 0; i < n-1; i++) {
                if(a[i]<a[i+1]&& a[i]+k>=a[i+1])
                {
                    count+=ans[a[i]];
                }
            }
            System.out.println(n-count);
           
              
        }

    }

