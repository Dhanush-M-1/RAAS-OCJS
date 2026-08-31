
TT = int(input())
import heapq

for loop in range(TT):

    N = int(input())

    L = []
    R = []

    abmax = 0

    for i in range(N):

        k,l,r = map(int,input().split())

        if l >= r:
            L.append( (k,l,r) )
            abmax += l
        else:
            R.append( (N-k,r,l) )
            abmax += r

    L.sort()
    R.sort()

    q = []
    for i in range(len(L)):

        k,nowc,nexc = L[i]
        heapq.heappush( q , nowc-nexc )

        while len(q) > k:
            tmp = heapq.heappop(q)
            abmax -= tmp

    q = []
    for i in range(len(R)):

        k,nowc,nexc = R[i]
        heapq.heappush( q , nowc-nexc )

        while len(q) > k:
            tmp = heapq.heappop(q)
            abmax -= tmp

    print (abmax)
