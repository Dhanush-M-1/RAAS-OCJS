import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

public class Solution {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    int n = sc.nextInt();
    int k = sc.nextInt();
    
    PriorityQueue<Integer> both = new PriorityQueue<>();
    PriorityQueue<Integer> alice = new PriorityQueue<>();
    PriorityQueue<Integer> bob = new PriorityQueue<>();
    for(int i=0;i<n;i++){
      int t = sc.nextInt();
      int a = sc.nextInt();
      int b = sc.nextInt();
      
      if(a==1 && b==1){
        both.offer(t);
      } else if(a == 1){
        alice.offer(t);
      } else if(b == 1){
        bob.offer(t);
      }
    }
    
    int timeSpent = 0;
    while(k > 0){
      if(!alice.isEmpty() && !bob.isEmpty() && !both.isEmpty()){
        if(alice.peek()+bob.peek() < both.peek()) {
          timeSpent += (alice.poll() + bob.poll());
          
        } else {
          timeSpent += both.poll();
        }
        k--;
      } else if(!both.isEmpty()){
        
        timeSpent += both.poll();
        k--;
      } else if(!alice.isEmpty() && !bob.isEmpty()){
        timeSpent += (alice.poll() + bob.poll());
        k--;
      } else {
        break;
      }
      if(k == 0) break;
    }
    System.out.println((k==0)?timeSpent:"-1");

  }
}


/* 
Your previous Plain Text content is preserved below:

8 4
  7 1 1
  2 1 1
4 0 1
  8 1 1
1 0 1
  1 1 1
1 0 1
3 0 0

both: 7 2 8 1

alice: 

bob : 4, 1

both+alice < k || both+bob < k
  return -1;
  
  
5 2
6 0 0
9 0 0
1 0 1
2 1 1
5 1 0

both : 2

alice : 5

bob : 1

8

if alicequeue is not empty and bobqueue is not empty

 if bob time + alice time < both time
  pick individual
else pick
  both time
  
else
  pick both time
  



 */