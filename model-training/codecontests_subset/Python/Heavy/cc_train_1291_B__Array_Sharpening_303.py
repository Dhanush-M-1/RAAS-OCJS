from math import gcd
import sys
input=sys.stdin.readline
from collections import defaultdict as dd,deque as dq
t=int(input())
while t:
    n=int(input())
    l=list(map(int,input().split()))
    ld=[True]
    rd=dq([True])
    for i in range(n):
        ld.append(ld[-1] and l[i]>=i)
    for i in range(n-1,-1,-1):
        rd.appendleft(rd[0] and l[i]>=len(rd)-1)
    lol=0
    #print(ld)
    #print(rd)
    ld.pop(0)
    rd.pop()
    for i in range(n):
        if(ld[i] and rd[i]):
            lol=1
    if(lol):
        print("Yes")
    else:
        print("No")
    t-=1
       