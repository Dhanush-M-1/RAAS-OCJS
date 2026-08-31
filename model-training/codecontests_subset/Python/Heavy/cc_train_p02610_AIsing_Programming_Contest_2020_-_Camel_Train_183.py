import heapq
T = int(input())
for _ in range(T):
    N = int(input())
    KLR = [list(map(int, input().split())) for i in range(N)]
    ans = 0
    for i in range(N):
        ans += min(KLR[i][1], KLR[i][2])
    KX = [(K, L-R) for K, L, R in KLR if L-R >= 0]
    KX.sort()
    hq = []
    id = 0
    for i in range(1, N+1):
        while(id < len(KX) and KX[id][0] == i):
            heapq.heappush(hq, KX[id][1])
            id += 1
        while(len(hq) > i):
            heapq.heappop(hq)
        # print(hq)
    ans += sum(hq)
    L = len(KX)
    KX = [(N-K, R-L) for K, L, R in KLR if R-L > 0]
    KX.sort()
    hq = []

    id = 0
    for i in range(N):
        while(id < len(KX) and KX[id][0] == i):
            heapq.heappush(hq, KX[id][1])
            id += 1
        while(len(hq) > i):
            heapq.heappop(hq)
        # print(hq)

    ans += sum(hq)

    print(ans)
