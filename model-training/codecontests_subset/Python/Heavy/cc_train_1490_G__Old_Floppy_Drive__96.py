import heapq


def solve(n, a, x):
    delta = sum(a)
    offset = [0] * len(x)
    if delta > 0:
        mx = None
        s = 0
        for i in range(n):
            s += a[i]
            if mx is None or mx < s:
                mx = s
        offset = [0] * len(x)
        for i in range(len(x)):
            laps = (max(0, x[i] - mx) + delta - 1) // delta
            offset[i] = laps * n
            x[i] -= laps * delta
    q = []
    for i in range(len(x)):
        heapq.heappush(q, (x[i], i))
    s = 0
    res = [-1] * len(x)
    for i in range(n):
        s += a[i]
        while q and s >= q[0][0]:
            res[q[0][1]] = i + offset[q[0][1]]
            heapq.heappop(q)
    return res




t = int(input())
for _ in range(t):
    n, m = map(int, input().split())
    a = list(map(int, input().split()))
    x = list(map(int, input().split()))
    print(*solve(n, a, x))