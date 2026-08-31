import heapq
t = int(input())
while t:
    t-=1
    n = int(input())
    klr = [list(map(int, input().split())) for i in range(n)]
    klr.sort()
    q = []
    ans = 0
    for i in range(n):
        K = klr[i][0]
        L = klr[i][1]
        R = klr[i][2]
        if L >= R:
            ans += L
            heapq.heappush(q,L-R)
            while len(q) > K:
                dec = heapq.heappop(q)
                ans -= dec
    q = []
    for i in reversed(range(n)):
        K = klr[i][0]
        L = klr[i][1]
        R = klr[i][2]
        if L < R:
            ans += R
            heapq.heappush(q,R-L)
            while len(q) > n-K:
                dec = heapq.heappop(q)
                ans -= dec    
    print(ans)
