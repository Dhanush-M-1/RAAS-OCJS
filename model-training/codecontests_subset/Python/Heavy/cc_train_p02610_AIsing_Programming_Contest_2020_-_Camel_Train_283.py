import sys
import heapq as hq

readline = sys.stdin.readline
readall = sys.stdin.read
ns = lambda: readline().rstrip()
ni = lambda: int(readline().rstrip())
nm = lambda: map(int, readline().split())
nl = lambda: list(map(int, readline().split()))
prn = lambda x: print(*x, sep='\n')

def solve():
    n = ni()
    f = list()
    g = list()
    ans = 0
    for i in range(n):
        k, l, r = nm()
        if l > r:
            ans += r
            g.append((k, l-r))
        else:
            ans += l
            f.append((k+1, r-l))
    g.sort()
    f.sort(reverse=True)
    h = list()
    # print(f)
    # print(g)
    for k in range(len(g), 0, -1):
        while g and g[-1][0] >= k:
            _, c = g.pop()
            hq.heappush(h, -c)
        if h:
            ans -= hq.heappop(h)
    h = list()
    for k in range(len(g)+1, n+1):
        while f and f[-1][0] <= k:
            _, c = f.pop()
            hq.heappush(h, -c)
        if h:
            ans -= hq.heappop(h)
    print(ans)
    return

T = ni()
for _ in range(T):
    solve()
