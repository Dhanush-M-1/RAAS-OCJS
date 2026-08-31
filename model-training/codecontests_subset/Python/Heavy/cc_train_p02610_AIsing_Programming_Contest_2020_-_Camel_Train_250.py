import sys
from heapq import*
input=sys.stdin.buffer.readline
def solve():
    n=int(input())
    x,y=[],[]
    for _ in range(n):
        k,l,r=map(int,input().split())
        if l>r:
            x+=(k,l,r),
        else:
            y+=(n-k,r,l),
    x.sort()
    y.sort()
    s=0
    h=[]
    for i in range(len(x),0,-1):
        while x and x[-1][0]>=i:
            k,l,r=x.pop()
            heappush(h,(r-l,l,r))
        if h:s+=heappop(h)[1]
    s+=sum(r for _,_,r in x+h)
    h=[]
    for i in range(len(y),0,-1):
        while y and y[-1][0]>=i:
            k,l,r=y.pop()
            heappush(h,(r-l,l,r))
        if h:s+=heappop(h)[1]
    s+=sum(r for _,_,r in y+h)
    return s
t=int(input())
print('\n'.join(str(solve())for _ in range(t)))