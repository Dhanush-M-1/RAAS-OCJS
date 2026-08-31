


    import java.util.*;


    public class Main {

        public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
             int n = input.nextInt();
             int k = input.nextInt();
             int ans[] = new int[2000000];
//            Integer a[] = new Integer[n];
ArrayList<Integer> a = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int value = input.nextInt();
                a.add(value);
                ans[value]++;
            }
            Collections.sort(a);
            int count=0;
            for (int i = 0; i < n-1; i++) {
                if(a.get(i)<a.get(i+1)&& a.get(i)+k>=a.get(i+1))
                {
                    count+=ans[a.get(i)];
                }
            }
            System.out.println(n-count);
           
              
        }

    }

