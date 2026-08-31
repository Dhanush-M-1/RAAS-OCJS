import sys
from heapq import heappush, heappushpop

t = int(sys.stdin.buffer.readline())
buf = []
for _ in range(t):
    n = int(sys.stdin.buffer.readline())
    lll = []
    rrr = []
    ans = 0
    for i in range(n):
        k, l, r = map(int, sys.stdin.buffer.readline().split())
        if l >= r:
            lll.append((k, l - r))
            ans += l
        else:
            rrr.append((n - k, r - l))
            ans += r
    lll.sort()
    rrr.sort()
    q = []
    for k, rl in lll:
        if len(q) < k:
            heappush(q, rl)
        else:
            nrl = heappushpop(q, rl)
            ans -= nrl
    q = []
    for k, lr in rrr:
        if len(q) < k:
            heappush(q, lr)
        else:
            nlr = heappushpop(q, lr)
            ans -= nlr

    buf.append(ans)

print('\n'.join(map(str, buf)))
