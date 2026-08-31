for _ in range(int(input())):
   n = int(input())
   dp = {}
   dp[1] = 0
   dp[3] = 2
   dp[6] = 1
   dp[9] = 4
   dp[27] = 6
   dp[36] = 2
   dl = [6,3,9,36,27]
   c = 0
   tmp = n
   if n==1 or n==0: 
      print(0)
      continue
   if n in dl: print(dp[n])
   else:
      i, ans, h = 0, 0, 0
      while i<3 and tmp>=1:
         if (tmp/dl[i])==(tmp//dl[i]) and tmp not in dp.keys():
            c+=1
            tmp = tmp//dl[i]
         else:
            if tmp in dl or tmp==1:
               print(c*dp[dl[i]]+dp[tmp]+h)
               dp[n] = c*dp[dl[i]]+dp[tmp]+h
               dl.append(n)
               break
            else: 
               if tmp%dl[i+1]==0:
                  h += c*dp[dl[i]]
               else: 
                  tmp = n
               c = 0
               i+=1
      if i>=3: print(-1)

