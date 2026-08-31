T = int(input())
import heapq
ans = []
for _ in range(T):
    n = int(input())
    ans = 0
    q1,q2,l1,l2 = [],[],[],[]
    for _ in range(n):
        k,l,r = map(int,input().split())
        if l>r:
            l1 += [(k,l-r)]
        else:
            l2 += [(n-k,r-l)]
        ans += min(l,r)
    l1.sort()
    l2.sort()
    #一番大きい差分のものからpushする
    for k,d in l1:
        heapq.heappush(q1, d)
        if len(q1)>k: heapq.heappop(q1)
    for k,d in l2:
        heapq.heappush(q2,d)
        if len(q2)>k: heapq.heappop(q2)
    ans += sum(q1) + sum(q2)
    print(ans)