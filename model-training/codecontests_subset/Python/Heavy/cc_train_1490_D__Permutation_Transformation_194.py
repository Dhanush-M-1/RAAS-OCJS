#dt = {} for i in x: dt[i] = dt.get(i,0)+1
import sys;input = sys.stdin.readline
#import io,os; input = io.BytesIO(os.read(0,os.fstat(0).st_size)).readline #for pypy
inp,ip = lambda :int(input()),lambda :[int(w) for w in input().split()]

import sys
sys.setrecursionlimit(10**5)

def func(l,r,dep):
    global n,x,d,idx
    if l > r:
        return
    if l == r:
        d[l] = dep
        return
    mx = max(x[l:r+1])
    ind = idx[mx]
    d[ind] = dep
    func(l,ind-1,dep+1)
    func(ind+1,r,dep+1)



for _ in range(inp()):
    n = inp()
    x = ip()
    idx = [0]*(n+1)
    for i in range(n):
        idx[x[i]] = i
    d = [0]*n
    ind = x.index(n)
    func(0,ind-1,1)
    func(ind+1,n-1,1)
    print(*d)