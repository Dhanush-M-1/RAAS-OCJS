/*
Kenb
*/
import java.util.*;
import java.io.*;

   public class F565{
   
      public static void main(String args[]) throws Exception{
         BufferedReader f = new BufferedReader(new InputStreamReader(System.in));  
         PrintWriter out = new PrintWriter(System.out);
         
         StringTokenizer st = new StringTokenizer(f.readLine());
         int N = Integer.parseInt(st.nextToken());
         PriorityQueue<Card> pq;
         long[][] dp = new long[N+1][10];
         for(int i=0; i < dp.length; i++)
            Arrays.fill(dp[i], -5L);
         for(int i=0; i < N+1; i++)
            dp[i][0] = 0L; 
         dp[0][0] = 0L;
         for(int t=0; t < N; t++){
            //for each turn
            st = new StringTokenizer(f.readLine());
            int K = Integer.parseInt(st.nextToken());
            Card max2 = new Card(2, 0);
            Card max3 = new Card(3, 0);
            pq = new PriorityQueue<Card>();
            for(int i=0; i < K; i++){
               st = new StringTokenizer(f.readLine());
               int c = Integer.parseInt(st.nextToken());
               long d = Long.parseLong(st.nextToken());
               if(c == 1)
                  pq.add(new Card(c, d));
               else if(c == 2 && d > max2.damage)
                  max2 = new Card(c, d);
               else if(c == 3 && d > max3.damage)
                  max3 = new Card(c, d);
            }
            //dp states
            for(int i=0; i < 10; i++)
               dp[t+1][i] = Math.max(dp[t+1][i], dp[t][i]);
            if(max3.damage != 0){
               for(int i=0; i < 10; i++){
                  if(dp[t][i] != -5 && i < 9)
                     dp[t+1][i+1] = Math.max(dp[t+1][(i+1)%10], dp[t][i]+max3.damage);
                  else if(dp[t][i] != -5 && i == 9)
                     dp[t+1][(i+1)%10] = Math.max(dp[t+1][(i+1)%10], dp[t][i]+2*max3.damage);
               }
            }
            if(max2.damage != 0){
               for(int i=0; i < 10; i++){
                  if(dp[t][i] != -5 && i < 9)
                     dp[t+1][i+1] = Math.max(dp[t+1][(i+1)%10], dp[t][i]+max2.damage);
                  else if(dp[t][i] != -5 && i == 9)
                     dp[t+1][(i+1)%10] = Math.max(dp[t+1][(i+1)%10], dp[t][i]+2*max2.damage);
               }
            }
            if(pq.size() > 0){
               Card max1 = pq.poll();
               for(int i=0; i < 10; i++){
                  if(dp[t][i] != -5 && i < 9)
                     dp[t+1][i+1] = Math.max(dp[t+1][(i+1)%10], dp[t][i]+max1.damage);
                  else if(dp[t][i] != -5 && i == 9)
                     dp[t+1][(i+1)%10] = Math.max(dp[t+1][(i+1)%10], dp[t][i]+2*max1.damage);
               }
               pq.add(max1);
            }
            if(pq.size() > 0){
               Card max1 = pq.poll();
               long max = Math.max(max1.damage, max2.damage);
               for(int i=0; i < 10; i++){
                  if(max2.damage > 0 && dp[t][i] != -5 && i < 8)
                     dp[t+1][i+2] = Math.max(dp[t+1][i+2], dp[t][i]+max2.damage+max1.damage);
                  else if(max2.damage > 0 && dp[t][i] != -5 && i >= 8)
                     dp[t+1][(i+2)%10] = Math.max(dp[t+1][(i+2)%10], 
                        dp[t][i]+2*Math.max(max1.damage, max2.damage)+Math.min(max1.damage, max2.damage));
                  //one card
                  if(dp[t][i] != -5 && i < 9)
                     dp[t+1][i+1] = Math.max(dp[t+1][i+1], dp[t][i]+max);
                  else if(dp[t][i] != -5 && i == 9)
                     dp[t+1][(i+1)%10] = Math.max(dp[t+1][(i+1)%10], dp[t][i]+2*max);
               }
               pq.add(max1);
            }
            if(pq.size() >= 3){
               Card c1 = pq.poll();
               Card c2 = pq.poll();
               Card c3 = pq.poll();
               long max = Math.max(c1.damage, Math.max(c2.damage, c3.damage));
               long min = Math.min(c1.damage, Math.min(c2.damage, c3.damage));
               long sum = c1.damage+c2.damage+c3.damage;
               for(int i=0; i < 10; i++){
                  if(dp[t][i] != -5 && i < 7)
                     dp[t+1][i+3] = Math.max(dp[t+1][i+3], dp[t][i]+c1.damage+c2.damage+c3.damage);
                  else if(dp[t][i] != -5 && i >= 7)
                     dp[t+1][(i+3)%10] = Math.max(dp[t+1][(i+3)%10], 
                        dp[t][i]+sum+max);
                  //two card
                  if(dp[t][i] != -5 && i < 8)
                     dp[t+1][i+2] = Math.max(dp[t+1][i+2], dp[t][i]+sum-min);
                  else if(dp[t][i] != -5 && i >= 8)
                     dp[t+1][(i+2)%10] = Math.max(dp[t+1][(i+2)%10], dp[t][i]+sum-min+max);
               }
               pq.add(c1);
               pq.add(c2);
               pq.add(c3);
            }
            if(pq.size() >= 2){
               Card c1 = pq.poll();
               Card c2 = pq.poll();
               long max = Math.max(c1.damage, c2.damage);
               for(int i=0; i < 10; i++){
                  if(dp[t][i] != -5 && i < 8)
                     dp[t+1][i+2] = Math.max(dp[t+1][i+2], dp[t][i]+c2.damage+c1.damage);
                  else if(dp[t][i] != -5 && i >= 8)
                     dp[t+1][(i+2)%10] = Math.max(dp[t+1][(i+2)%10], 
                        dp[t][i]+2*max+Math.min(c1.damage, c2.damage));
               }
               pq.add(c1);
               pq.add(c2);
            }
            //cancer
         }
         long res = 0L;
         for(int i=0; i < 10; i++)
            res = Math.max(res, dp[N][i]);
         out.println(res);
         out.close();
      }
   }
   class Card implements Comparable<Card>
   {
      public int cost;
      public long damage;
      
      public Card(int a, long b)
      {
         cost = a;
         damage = b;
      }
      public int compareTo(Card oth)
      {
         if(oth.damage > damage)
            return 1;
         else if(oth.damage == damage)
            return 0;
         return -1;
      }
   }