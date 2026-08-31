import sys
import bisect
input=lambda: sys.stdin.readline().strip("\r\n")
from math import log
sa=lambda :input()
sb=lambda:int(input())
sc=lambda:input().split()
sd=lambda:list(map(int,input().split()))
se=lambda:float(input())
sf=lambda:list(input())
flsh=lambda: sys.stdout.flush()
mod=10**9+7
def hnbhai():
    n,m=sd()
    a=sd()
    query=sd()
    prefix=[0]*(n+1)
    d={}
    max_=[0]*(n+1)
    for i in range(1,n+1):
        prefix[i]=prefix[i-1]+a[i-1]
        max_[i]=max(max_[i-1],prefix[i])
        if d.get(prefix[i]) is not None:
            continue
        if prefix[i]>0:
            d[prefix[i]]=i-1
        #print(max_[i])
    abe=[]
    #print(max_)
    #print(prefix)
    for i in range(m):
        op=0
        ind=bisect.bisect_left(max_,query[i])
        if ind!=len(max_):
            abe.append(ind-1)
        else:
            if prefix[n]<=0:
                abe.append(-1)
                continue
            if max_[-1]<query[i]:
                ans=query[i]-max_[-1]
                op=ans//prefix[n]
                if ans%prefix[n]:
                    op+=1
                query[i]-=op*prefix[n]
                op=n*op
            abe.append(op+bisect.bisect_left(max_,query[i])-1)
    print(*abe)
for _ in range(sb()):
    hnbhai()
