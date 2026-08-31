# author : empr #
import sys
input=sys.stdin.buffer.readline
ri=lambda: int(input())
rl=lambda: list(map(int,input().split()))
rs=lambda: input().decode().rstrip('\n\r')
wrt=sys.stdout.write
pr=lambda *args,end='\n': wrt(' '.join([str(x) for x in args])+end)
xrange=lambda *args: reversed(range(*args))
cdiv=lambda x,y: (-(-x//y))
enum=enumerate; inf=float('inf')
mod=10**9 + 7
# Am I debugging ? Check if I'm using same variable name in two places
# fun() returning empty list ? check new=temp[:] or new=temp
# Am I breaking or returning from a loop while reading input
# check if I am initializing any ans correctly
from collections import defaultdict as dd,Counter
from queue import deque
from heapq import *
#from math import gcd
#lcm=lambda x,y: x*y//gcd(x,y)

Testcase=ri()
for testcase in range(Testcase):
    n,=rl()
    a=rl()
    vis=[False for i in range(n)]
    k=max(a)
    q=deque()
    q.append([k,a.index(k),0])
    ans=[0 for i in range(n)]
    while(q):
        k,i,d=q.popleft()
        #print(k,i,d)
        vis[i]=True
        ans[i]=d
        mx=0
        ni=0
        f=False
        for j in xrange(0,i):
            
            if vis[j]:
                break
            f=True
            if a[j]>mx:
                ni=j 
                mx=a[j]
        if f: q.append([mx,ni,d+1])
        mx=0
        ni=0
        f=False
        for j in range(i+1,n):
            if vis[j]:
                break
            f=True
            if a[j]>mx:
                ni=j 
                mx=a[j]
        if f:q.append([mx,ni,d+1])
    print(*ans)