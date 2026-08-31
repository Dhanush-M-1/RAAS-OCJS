import heapq
n, k = map(int, input().split())
x, y, z = [], [], []
heapq.heapify(x)
heapq.heapify(y)
heapq.heapify(z)
for _ in range(n):
    t, a, b = map(int, input().split())
    if a == b == 1:
        heapq.heappush(x, t)
    elif a == 1:
        heapq.heappush(y, t)
    elif b == 1:
        heapq.heappush(z, t)
lx, ly, lz = len(x), len(y), len(z)
u, v = len(x), min(len(y), len(z))
ans = 0
if u + v >= k:
    i, j = 0, 0
    for _ in range(k):
        if i < u and j < v:
            if x[0] <= y[0] + z[0]:
                ans += heapq.heappop(x)
                i += 1
            else:
                ans += (heapq.heappop(y) + heapq.heappop(z))
                j += 1
        elif i < u:
            ans += heapq.heappop(x)
            i += 1
        elif j < v:
            ans += (heapq.heappop(y) + heapq.heappop(z))
            j += 1
else:
    ans = -1
print(ans)