#dt = {} for i in x: dt[i] = dt.get(i,0)+1
import sys;input = sys.stdin.readline
inp,ip = lambda :int(input()),lambda :[int(w) for w in input().split()]

for _ in range(inp()):
    n = inp()
    x = ip()
    if x[0]+x[1] <= x[-1]:
        print(1,2,n)
    else:
        print(-1)