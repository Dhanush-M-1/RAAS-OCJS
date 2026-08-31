from heapq import *

def solve(p:list):
    s = 0
    n = len(p)
    data = [[] for _ in range(n+1)]
    for i,j in p:
        data[min(i,n)].append(j)
    H = []
    heapify(H)
    for i in range(n,0,-1):
        for j in data[i]:
            heappush(H,-j)
        if H:
            s -= heappop(H)
    return s
    
t = int(input())
for _ in range(t):
    n = int(input())
    ans = 0
    pl = []
    pr = []
    for _ in range(n):
        k,l,r = map(int,input().split())
        m = min(l,r)
        ans += m
        l,r = l-m,r-m
        if l:
            pl.append((k,l))
        else:
            pr.append((n-k,r))
    print(ans+solve(pl)+solve(pr))