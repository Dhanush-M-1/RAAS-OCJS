import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class ParityAlternatedDeletions {
    public static void main(String[] args) {
        Scanner s = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int n=s.nextInt();
        ArrayList<Integer>even=new ArrayList<>();
        ArrayList<Integer>odd=new ArrayList<>();
        for(int i=0;i<n;i++){
            int el=s.nextInt();
            if(el%2==0)
                even.add(el);
            else
                odd.add(el);
        }
        Collections.sort(even);
        Collections.sort(odd);
        int diff=0;
        if(even.size()>odd.size()){
            diff=even.size()-odd.size()-1;
            if(diff==0||even.size()==odd.size())
                System.out.println(0);
            else{
                long sum=0;
                for(int i=0;i<diff;i++){
                    sum+=even.get(i);
                }
                System.out.println(sum);
            }
        }else{
            diff=odd.size()-even.size()-1;
            if(diff==0)
                System.out.println(0);
            else{
                long sum=0;
                for(int i=0;i<diff;i++){
                    sum+=odd.get(i);
                }
                System.out.println(sum);
            }
        }
    }
    }
