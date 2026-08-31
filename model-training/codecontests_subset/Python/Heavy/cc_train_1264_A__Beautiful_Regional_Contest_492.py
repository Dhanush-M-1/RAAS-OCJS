from collections import Counter
from collections import defaultdict
import math
import bisect
t=int(input())
for _ in range(0,t):
    n=int(input())
    a=list(map(int,input().split()))
    d=defaultdict(lambda:0)
    s=a[0]
    d[s]=1
    ans=1
    l=[a[0]]
    if(n<5):
        print("0 0 0")
        continue
    for i in range(1,n//2):
        if(a[i]==s):
            d[a[i]]=d[a[i]]+1
        else:
            s=a[i]
            d[a[i]]=1
            l.append(a[i])
    ans=d[a[0]]
    a2=a[n//2-1]
    if(a2==a[n//2]):
        #print(a2,a[n//2],"ll")
        l.remove(a[n//2-1])
       # print("f")
   # print(d)
    c=0
    s2=0
    k=0
    f1=0
    f2=0
    for i in range(1,len(l)):
        c=c+d[l[i]]
        if(c>ans):
            s2=c
            k=i
            f1=1
            break
    c=0
    #print(k)
    for i in range(k+1,len(l)):
        c=c+d[l[i]]
        if(c>ans):
            f2=1
            s3=c
    if(f1 and f2):
        print(ans,s2,s3)
    else:
        print("0 0 0")
            
    