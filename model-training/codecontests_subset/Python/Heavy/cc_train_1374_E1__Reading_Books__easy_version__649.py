from collections import deque
import sys
import heapq
def inp():
    return sys.stdin.readline().strip()
for _ in range(1):
    n,k=map(int,inp().split())
    l=[]
    a=[]
    b=[]
    for i in range(n):
        ti,ai,bi=map(int,inp().split())
        if ai==0 and bi==0:
            continue
        elif ai==0:
            b.append(ti)
        elif bi==0:
            a.append(ti)
        else:
            l.append(ti)
    if len(a)+len(l)<k or len(b)+len(l)<k:
        print(-1)
        continue
    a.sort()
    b.sort()
    l.sort()
    heapq.heapify(l)
    q=l
    for i in range(min(len(a),len(b))):
        heapq.heappush(q,a[i]+b[i])
    if len(q)<k:
        print(-1)
    ans=0
    while k>0:
        ans+=heapq.heappop(q)
        k-=1 
    print(ans)
    
            
    
    
            
    