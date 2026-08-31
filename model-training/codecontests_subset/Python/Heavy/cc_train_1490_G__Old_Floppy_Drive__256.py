import sys, math, itertools, random, bisect
from collections import defaultdict
INF = sys.maxsize
def get_ints(): return map(int, sys.stdin.readline().strip().split())
def get_array(): return list(map(int, sys.stdin.readline().strip().split()))
def input(): return sys.stdin.readline().strip()
mod = 10**9 + 7


for _ in range(int(input())):
    n,m = get_ints()
    a = get_array()
    x = get_array()

    b = [[a[0],0]]
    cur = a[0]
    mx = a[0]
    for i in range(1,n):
        if cur + a[i] > b[-1][0]:
            b.append([cur + a[i], i])
        cur += a[i]
        mx = max(mx, cur)

    length = len(b)
    res = []
    for ele in x:
        if ele<=mx:
            l = 0
            r = length - 1
            while l<=r:
                m = (l+r)//2
                if b[m][0]>=ele: r = m-1
                else: l=m+1
            res.append(b[l][1])
        else:
            if cur>0:
                y = (ele - mx)//cur
                ele -= y*cur
                if ele>mx:
                    y += 1
                    ele -= cur
                l = 0
                r = length - 1
                while l<=r:
                    m = (l+r)//2
                    if b[m][0]>=ele: r = m-1
                    else: l=m+1
                res.append(b[l][1] + y*n)
            else:
                res.append(-1)
            
    print(*res)


