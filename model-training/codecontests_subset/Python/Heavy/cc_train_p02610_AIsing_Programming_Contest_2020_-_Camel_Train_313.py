import sys
input = sys.stdin.readline
from heapq import heappop, heappush

t = int(input())
for i in range(t):
    n = int(input())
    C = [list(map(int,input().split())) for i in range(n)]
    L = []
    R = []

    ans = 0
    for i in range(n):
        k = C[i][0]-1
        l = C[i][1]
        r = C[i][2]
        ans += min(l,r)
        if l > r:
            L.append([r-l, k])
        elif l < r:
            R.append([l-r, k+1])

    L.sort(key=lambda x:x[1], reverse=True)
    R.sort(key=lambda x:x[1])

    LQ = []
    ind = 0
    for i in range(n-1,-1,-1):
        while ind < len(L) and L[ind][1] == i:
            heappush(LQ, L[ind])
            ind += 1
        if len(LQ) > 0:
            LL = heappop(LQ)
            ans += -LL[0]

    RQ = []
    ind = 0
    for i in range(n):
        while ind < len(R) and R[ind][1] == i:
            heappush(RQ, R[ind])
            ind += 1
        if len(RQ) > 0:
            RR = heappop(RQ)
            ans += -RR[0]
    # print(LQ,RQ)
    print(ans)