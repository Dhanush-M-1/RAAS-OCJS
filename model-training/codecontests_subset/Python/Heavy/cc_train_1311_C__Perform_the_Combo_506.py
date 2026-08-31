from collections import Counter
from collections import defaultdict
import math
t=int(input())
for _ in range(0,t):
    n,m=list(map(int,input().split()))
    s=input()
    l=list(map(int,input().split()))
    d=dict()
    for i in range(0,n+1):
        d[i]=[0]*26
    for i in range(0,n):
        k=ord(s[i])-ord('a')
        if(i==0):
            d[i][k]=1
        else:
            for j in range(0,26):
                if(j==k):
                    d[i][j]=d[i-1][j]+1
                else:
                    d[i][j]=d[i-1][j]
    pre=dict()
    ans=[0]*26
    l.append(n-1)
    for i in range(0,m):
        l[i]=l[i]-1
  #  print(l)
    for i in range(0,len(l)):
        for j in range(0,26):
            ans[j]=ans[j]+d[l[i]][j]
  #  print(d)
    print(*ans)    
            
        