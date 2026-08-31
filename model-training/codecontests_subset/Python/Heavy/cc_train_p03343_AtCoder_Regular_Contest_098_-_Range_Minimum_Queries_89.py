import heapq
N, K, Q = [int(_) for _ in input().split()]
A = [int(_) for _ in input().split()]
sA = sorted(A)
A += [-1]
ans = float('inf')
for amin in sA:
    cand = []
    dp = []
    for i in range(N + 1):
        a = A[i]
        if a >= amin:
            heapq.heappush(dp, a)
        if len(dp) and a < amin:
            m = len(dp) - K + 1
            for _ in range(m):
                heapq.heappush(cand, heapq.heappop(dp))
            dp = []
    y = float('inf')
    if len(cand) < Q:
        break
    for _ in range(Q - 1):
        heapq.heappop(cand)
    ans = min(ans, heapq.heappop(cand) - amin)
print(ans)
