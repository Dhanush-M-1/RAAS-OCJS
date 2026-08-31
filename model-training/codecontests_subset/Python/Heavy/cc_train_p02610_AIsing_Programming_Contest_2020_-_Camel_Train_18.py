import sys
input = lambda: sys.stdin.readline().rstrip()
import heapq  
def calc(A):
    n = len(A)
    c = 0
    h = []
    ret = 0
    for i, aa in enumerate(A):
        for a in aa:
            ret += a
            heapq.heappush(h, a)
            if len(h) > i + 1:
                ret -= heapq.heappop(h)
    return ret

T = int(input())
for _ in range(T):
    N = int(input())
    L = [[] for _ in range(N)]
    R = [[] for _ in range(N)]
    ans = 0
    for _ in range(N):
        k, l, r = map(int, input().split())
        if k == N:
            ans += l
        elif l == r:
            ans += l
        elif l < r:
            ans += l
            R[N-1-k].append(r - l)
        else:
            ans += r
            L[k-1].append(l - r)
    ans += calc(L) + calc(R)
    print(ans)