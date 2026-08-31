


import java.util.*;



public class Main {
    
  
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

       
       int n = input.nextInt();
       ArrayList<Integer> even = new ArrayList<>(),odd = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int value = input.nextInt();
            if((value&1)==0)
            {
                even.add(value);
                
            }
            else
                odd.add(value);
        }
        long sum=0;
        
        
        if(even.size()>odd.size())
        {
            Collections.sort(even);
            for (int i = 0; i <(even.size()-(odd.size()+1)) ; i++) {
                sum+=even.get(i);
            }
        }
        else if(odd.size()>even.size())
        {
            Collections.sort(odd);
            for (int i = 0; i <(odd.size()-(even.size()+1)) ; i++) {
                sum+=odd.get(i);
            }
        }
        System.out.println(sum);
        


       
    }
}

