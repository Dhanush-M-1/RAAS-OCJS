import java.util.Scanner;

public class Stones {
    public static void main(String args[]){
        int[] heap = new int[3];

        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int[] results = new int[t];
        for (int i=0; i<t; i++){
            results[i]=0;
            for (int j=0; j<3; j++){
                heap[j] = in.nextInt();
            }
            //System.out.println(heap[0]+" "+ heap[1]+" "+ heap[2]);
            int temp = countRuleA(heap);
            //System.out.println(temp);
            //System.out.println(heap[0]+" "+ heap[1]+" "+ heap[2]);
            int temp2 = countRuleB(heap);
            for (int k=1; k<=temp; k++){
                int ruleAc=k;
                int[] tempheap = heap.clone();
                for (int times=0; times<k;times++){
                    tempheap = ruleA(tempheap);
                }
                int ruleBc=countRuleB(tempheap);
                if ((ruleAc+ruleBc)*3>results[i]){
                    results[i] = (ruleAc+ruleBc)*3;
                }
            }

            for (int k=1; k<=temp2; k++){
                int ruleBc=k;
                int[] tempheap = heap.clone();
                for (int times=0; times<k;times++){
                    tempheap = ruleB(tempheap);
                }
                int ruleAc=countRuleA(tempheap);
                if ((ruleAc+ruleBc)*3>results[i]){
                    results[i] = (ruleAc+ruleBc)*3;
                }
            }

        }

        for (int i:results
             ) {
            System.out.println(i);
        }

    }

    public static int[] ruleA(int[] heaps){
        heaps[0] -=1;
        heaps[1] -=2;
        //System.out.println(heaps[0]+" "+heaps[1]+" "+heaps[2]);
        return heaps;
    }

    public static int[] ruleB(int[] heaps){
        heaps[1] -=1;
        heaps[2] -=2;
        //System.out.println(heaps[0]+" "+heaps[1]+" "+heaps[2]);
        return heaps;
    }

    public static int countRuleA(int[] heap){
        int count = 0;
        int[] temp = heap.clone();
        while (temp[0] >= 0 && temp[1] >= 0) {
            temp[0] -=1;
            temp[1] -=2;
            if (temp[0]>=0 && temp[1]>=0){
                count++;
            }

        }
        return count;
    }
    public static int countRuleB(int[] heap){
        int count = 0;
        int[] temp = heap.clone();
        while (temp[1] >= 0 && temp[2] >= 0) {
            temp[1] -=1;
            temp[2] -=2;
            if (temp[1]>=0 && temp[2] >= 0){
                count++;
            }
        }
        return count;
    }
}
