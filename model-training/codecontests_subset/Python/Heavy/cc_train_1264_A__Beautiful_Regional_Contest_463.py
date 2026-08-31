import sys
from itertools import accumulate
from bisect import bisect_left, bisect
readline = sys.stdin.readline

T = int(readline())
Ans = [None]*T
inf = 10**9+7
for qu in range(T):
    N = int(readline())
    P = list(map(int, readline().split())) + [None]
    if N < 6:
        Ans[qu] = (0, 0, 0)
        continue
    L = []
    pre = None
    cnt = 0
    for p in P:
        if pre != p:
            L.append(cnt)
            cnt = 1
        else:
            cnt += 1
        pre = p
    L = L[1:]
    AL = list(accumulate(L))
    AL += [inf]
    M = len(L)
    ans = (0, 0, 0)
    aa = 0
    for i in range(M):
        g = AL[i]
        if 3*g + 2 > N//2:
            break
        sidx = bisect_left(AL, 2*g+1)
        s = AL[sidx]
        if s >= inf:
            continue
        blidx = bisect_left(AL,s+g+1)
        bridx = bisect(AL,N//2)-1
        if blidx > bridx:
            continue
        if aa < AL[bridx]:
            ans = (g, s-g, AL[bridx]-s)
    Ans[qu] = ans
for a in Ans:
    sys.stdout.write('{} {} {}\n'.format(*a))