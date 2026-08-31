from heapq import heappush, heappushpop

T = int(input())
ans = []
for _ in range(T):
    N = int(input())
    first = []
    last = []
    base = 0
    base_max = 0
    for _ in range(N):
        k, l, r = map(int, input().split())
        if k == N:
            r = l
        if l > r:
            first.append([k, l - r])
        elif r > l:
            last.append([N - k, r - l])
        base += min(l, r)
        base_max += max(l, r)
    first.sort()
    last.sort()

    pool = []
    for k, p in first:
        if len(pool) < k:
            heappush(pool, p)
        else:
            if pool and pool[0] < p:
                heappushpop(pool, p)
    base += sum(pool)
    pool = []
    for k, p in last:
        if len(pool) < k:
            heappush(pool, p)
        else:
            if pool and pool[0] < p:
                heappushpop(pool, p)
    base += sum(pool)
    ans.append(base)
    pass
print(*ans, sep="\n")

