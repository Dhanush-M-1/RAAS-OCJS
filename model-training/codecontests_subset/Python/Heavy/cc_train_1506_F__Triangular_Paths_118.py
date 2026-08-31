import sys
mod=998244353
input = lambda: sys.stdin.readline().rstrip("\r\n")
from _collections import deque
from math import ceil
for counter in range(int(input())):
    n=int(input())
    ck=[]
    for i,j in zip(input().split(),input().split()):
        ck.append([int(i),int(j)])
    ck.sort()
    tot=0
    r,c=1,1
    for i,j in ck:
        if r-c==i-j:
            if not (r+c)%2:
                tot+=j-c
        else:
            if not(r+c)%2:
                r+=1
            t=i-r
            jm=c+t
            tot+=ceil((jm-j)/2)
        r,c=i,j
    print(tot)

