T = int(input())
import heapq

for _ in range(T):
    n = int(input())
    ans = 0
    
    lamount,ramount = 0,0
    k,l,r = [0]*n,[0]*n,[0]*n
    
    ll,rr = [],[]
    for i in range(n):
        k[i],l[i],r[i] = map(int,input().split())
        if l[i] >= r[i]:
            lamount += 1
            ans += r[i]
            ll.append(i)
        else:
            ramount += 1
            ans += l[i]
            rr.append(i)
            
    ldek = [[] for _ in range(lamount)]
    rdek = [[] for _ in range(ramount)]
    
    for i in ll:
        ldek[min(lamount-1,k[i]-1)].append(l[i]-r[i])
    
    for i in rr:
        if n != k[i]:
            rdek[min(ramount-1,n-1-k[i])].append(r[i]-l[i])
        
    cur = []
    heapq.heapify(cur)
    
    for l in range(lamount-1,-1,-1):
        for k in ldek[l]:
            heapq.heappush(cur, k*(-1))
            
        if cur != []:
            mi = heapq.heappop(cur)
            ans += mi * (-1)
            
    cur = []
    heapq.heapify(cur)
    
    for l in range(ramount-1,-1,-1):
        for k in rdek[l]:
            heapq.heappush(cur, k*(-1))
            
        if cur != []:
            mi = heapq.heappop(cur)
            ans += mi * (-1)
            
    print(ans)