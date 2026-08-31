from math import ceil,floor,log,sqrt,factorial
inf = float("inf")
for _ in range(int(input())):
     
     n = int(input())
     a = list(map(int,input().split()))
     ma = -inf
     mi = inf
     for i in range(n):
          if i>0 :
               if a[i]== -1 and a[i-1]!= -1:
                    ma = max(ma,a[i-1])
                    mi = min(mi,a[i-1])
          if i< n-1:
               if a[i] == -1 and a[i+1] != -1:
                    ma = max(ma,a[i+1])
                    mi = min(mi,a[i+1])

     if ma == -inf:
          ma = 0
     if mi == inf:
          mi = 0


     k = (ma+mi)//2
     m = 0

     for i in range(n-1):

          if a[i] == -1:
               a[i] = k
          if a[i+1] == -1:
               a[i+1] = k
          m = max(m,abs(a[i]-a[i+1]))

     print(m,k)
               
          
          
                    
                    
     
