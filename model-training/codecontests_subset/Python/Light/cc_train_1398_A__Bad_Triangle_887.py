t=int(input())
for i in range(t):
         n=int(input())
         l=list(map(int,input().split()))
         i=0
         j=1
         k=2
         f=0
         while(k<n):
                  if(l[i]+l[j]<=l[k]):
                           print(i+1,j+1,k+1)
                           f=1
                           break
                  else:
                           k+=1
         if(f==0):
                  print(-1)
