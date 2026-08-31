import heapq

T = int(input())

for _ in range(T):
    N = int(input())
    List = []
    ans = 0
    
    for _ in range(N):
        K, L, R = map(int,input().split())
        ans += min(L, R)
        List.append((K, L, R))
    
    S1 = []
    S2 = []
    
    List.sort()
    
    for i in range(N):
        K, L, R = List[i]
        if L-R > 0:
            heapq.heappush(S1, L-R)
        if K < len(S1):
            heapq.heappop(S1)
    
    for i in range(N):
        K, L, R = List[N-i-1]
        K = N - K
        
        if R-L > 0:
            heapq.heappush(S2, R-L)
        if K < len(S2):
            heapq.heappop(S2)
    
    ans += sum(S1) + sum(S2)
    
    print(ans)