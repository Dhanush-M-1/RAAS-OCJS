"""x=int(input())
L=[]
import math
for i in range(1,x+1):
    for j in range(i,x+1):
        t=(i*j)//math.gcd(i,j)
        #print(i,j,t)
        L.append((t,i,j))

print(sorted(L))
"""

import math

n=int(input())

ans=n
i=1
c1=1
c2=n
while(i<=math.sqrt(n)):
    if(n%i==0):
        if(n//i==i):
            t=(i*i)//math.gcd(i,i)
            if(i<ans and t==n):
                ans=min(i,ans)
                c1=i
                c2=i
        else:
            t=(i*(n//i))//math.gcd(i,(n//i))
            if(max(i,n//i)<ans and t==n):
                c1=i
                c2=n//i
                ans=min(ans,max(i,n//i))

    i+=1

print(c1,c2)
          
