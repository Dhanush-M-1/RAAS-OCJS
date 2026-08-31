def solve(l1,l2):
         for j in range(m):
                  if(l1[j] in l2):
                           return 1,l1[j]
                           break
         return 0,0
         
t=int(input())
for i in range(t):
         m,n=map(int,input().split())
         l1=list(map(int,input().split()))
         l2=list(map(int,input().split()))
 
         res,val=solve(l1,l2)
         if(res==1):
                  print("YES")
                  print(res,val)
         else:
                  print("NO")
