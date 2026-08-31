import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Rebus {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] parts = br.readLine().split(" ");
        int n = Integer.parseInt(parts[parts.length - 1]);
        String [] signs = new String[parts.length / 2 - 1];
        int idx = 0;
        int [] nums = new int[parts.length / 2 ];
        Set<Integer> negative = new HashSet<>();
        Set<Integer> positive = new HashSet<>();
        positive.add(0);
        long sum = n;
        nums[0] = n;
        for (int i = 1; i < parts.length - 2; i += 2) {
            signs[idx] = parts[i];
            if (parts[i].equals("+")){
                positive.add(idx + 1);
                sum += n;
            } else {
                negative.add(idx + 1);
                sum -= n;
            }
            idx++;
            nums[idx]=n;
        }
        boolean possible = true;
        if (sum > n) {
            while (sum > n) {
                if (!positive.isEmpty()) {
                    int posIdx = positive.iterator().next();
                    long diff = sum - n;
                    if (diff < n - 1) {
                        nums[posIdx] -= diff;
                        sum -= diff;
                    } else {
                        sum -= (nums[posIdx] - 1);
                        nums[posIdx] = 1;
                    }
                    positive.remove(posIdx);
                } else {
                    possible = false;
                    break;
                }
            }
        } else {
            while (sum < n) {
                if (!negative.isEmpty()) {
                    int posIdx = negative.iterator().next();
                    long diff = n - sum;
                    if (diff < n - 1) {
                        nums[posIdx] -= diff;
                        sum += diff;
                    } else {
                        sum += (nums[posIdx] - 1);
                        nums[posIdx] = 1;
                    }
                    negative.remove(posIdx);
                } else {
                    possible = false;
                    break;
                }
            }
        }
        if (possible) {
            System.out.println("Possible");
            System.out.print(nums[0] + " ");
            for (int i = 1; i < nums.length; ++i) {
                System.out.print(signs[i - 1] + " ");
                System.out.print(nums[i] + " ");

            }
            System.out.println("= " + n);
        } else {
            System.out.println("Impossible");
        }

    }
}
