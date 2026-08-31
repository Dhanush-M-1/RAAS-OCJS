import heapq
def solve():
    N = int(input())
    klr = [list(map(int,input().split())) for _ in range(N)]
    
    ll = []
    lr = []
    for i in range(N):
        if klr[i][1]>klr[i][2]:
            ll.append(klr[i])
        else:
            lr.append(klr[i])

    ansl = 0
    ll.sort(key=lambda x:-x[0])
    j = 0
    cand = []
    for i in range(len(ll)-1,-1,-1):
        while j<len(ll):
            if ll[j][0]-1<i:
                break
            heapq.heappush(cand,[ll[j][2]-ll[j][1],ll[j][0],ll[j][1],ll[j][2]])
            j += 1
        if cand:
            d,k,l,r = heapq.heappop(cand)
            ansl += l
    while cand:
        d,k,l,r = heapq.heappop(cand)
        ansl += r

    ansr = 0
    lr.sort(key=lambda x:x[0])
    j = 0
    cand = []
    for i in range(len(ll),N+1):
        while j<len(lr):
            if lr[j][0]>i:
                break
            heapq.heappush(cand,[-lr[j][2]+lr[j][1],lr[j][0],lr[j][1],lr[j][2]])
            j += 1
        if cand and i!=N:
            d,k,l,r = heapq.heappop(cand)
            ansr += r
    while cand:
        d,k,l,r = heapq.heappop(cand)
        ansr += l
    ans = ansl+ansr
    print(ans)

T = int(input())
for t in range(T):
    solve()        