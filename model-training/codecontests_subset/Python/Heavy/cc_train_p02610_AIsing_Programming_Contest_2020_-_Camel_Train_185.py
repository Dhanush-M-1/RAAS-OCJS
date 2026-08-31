from heapq import heappop, heappush

sc = map(int, open(0).read().split())
ni = lambda: next(sc)

def solve(A):
    Q = []
    for i, ai in enumerate(A):
        for aij in ai:
            heappush(Q, aij)
        while len(Q) > i:
            heappop(Q)
    return sum(Q)

T = ni()
for _ in range(T):
    N = ni()
    A, B = [[] for _ in range(N + 1)], [[] for _ in range(N + 1)]

    ans = 0
    for _ in range(N):
        k, l, r = ni(), ni(), ni()
        if l >= r:
            A[k].append(l - r)
        else:
            B[k].append(r - l)
        ans += min(l, r)

    ans += solve(A) + solve(reversed(B))
    print(ans)