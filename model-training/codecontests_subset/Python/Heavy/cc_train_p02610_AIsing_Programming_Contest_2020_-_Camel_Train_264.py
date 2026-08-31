import heapq

def g(LS):
    Q = [];
    QLen = 0
    SC = 0

    for k,sc in sorted(LS):
        heapq.heappush(Q, sc)
        QLen += 1
        SC += sc

        if  QLen > k:
            SC -= heapq.heappop(Q)
            QLen -= 1

    return SC
            


def f():
    N = int(input())
    LS = []
    RS = []
    SC0 = 0

    for _ in range(N):
        K,L,R = map(int, input().split())
        SC = abs(L - R)
        SC0 += min(L, R)

        if L >= R:
            LS.append((K, SC))
        else:
            RS.append((N-K, SC))

    
    print(SC0 + g(LS) + g(RS))


T = int(input())
for _ in range(T):
    f()




