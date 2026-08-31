import sys
input = sys.stdin.buffer.readline

from bisect import bisect_left

T = int(input())
for _ in range(T):
    n, l, r = map(int, input().split())
    ls = [ (n-u)*2 for u in range(n+1) ]
    ls[0] = 1
    for i in range(1, n+1):
        ls[i] += ls[i-1]

    p = bisect_left(ls, l)
    sp = []
    if p == 0:
        sp = [0, 0, 0]
    else:
        d = l - ls[p-1]
        sp = [p, p+(d+1)//2, 0 if d%2 else 1]
    
    def getp(ls):
        if ls[0] == 0 or ls == [n-1, n, 1]: return 1
        elif ls[2] == 0: return ls[1]
        elif ls[1] == n: return ls[0]+1
        else: return ls[0]

    def nextp(ls):
        a, b, c = ls
        if a == 0: return [1, 2, 0]
        elif c == 0: return [a, b, 1]
        elif b < n: return [a, b+1, 0]
        else: return [a+1, a+2, 0]
         
    res = []
    for _ in range(r-l+1):
        #print(sp)
        res.append(getp(sp))
        sp = nextp(sp)
    print(' '.join(map(str, res)))