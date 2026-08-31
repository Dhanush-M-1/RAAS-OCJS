import sys
input=sys.stdin.readline
from bisect import bisect_left
def getans(a,x,n,ma,s,ss,ssi):
    p=ma
    if s>0:
        cnt=0
        if x<=ma:
            return ssi[bisect_left(ss,x)]
        if x>ma:
            cnt=(x-ma)//s
        p+=cnt*s
        while(1):
            if x<=p:
                return n*cnt+ssi[bisect_left(ss,x-cnt*s)]
            p+=s
            cnt+=1
    if s<=0:
        if x<=p:
            return ssi[bisect_left(ss,x)]
        return -1
for _ in range(int(input())):
    n,m=[*map(int,input().split())]
    a=[*map(int,input().split())]
    b=[*map(int,input().split())]
    s=a[0]
    ss=[a[0]]
    ssi=[0]
    for i in range(1,n):
        s+=a[i]
        if s>ss[-1]:
            ss.append(s)
            ssi.append(i)
    ma=ss[-1]
    for i in range(m):
        print(getans(a,b[i],n,ma,s,ss,ssi),end=' ')