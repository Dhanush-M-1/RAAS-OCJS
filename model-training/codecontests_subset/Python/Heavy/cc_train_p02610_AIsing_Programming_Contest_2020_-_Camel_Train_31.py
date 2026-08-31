import heapq  
def priority(klr):
    return abs(klr[1]-klr[2])
              
def process(KP):
    q = []    
    for kp in KP:
        if kp[0] < len(q) and len(q) > 0 and q[0] < kp[1]:
            heapq.heappop(q)
        if kp[0] >= len(q):
            heapq.heappush(q, kp[1])
    return sum(q)
              
def solve():  
    N = int(input())
    KLR = []  
    for _ in range(N):
        klr = list(map(int, input().split()))
        klr[0] -= 1 # convert to 0-based index to avoid confusion                                                                                                                                           
        KLR.append(klr)
    ans = 0   
    L = []    
    R = []    
    for klr in KLR:
        if klr[1] > klr[2]:
            ans += klr[2]
            L.append((klr[0], klr[1]-klr[2]))
        elif klr[1] < klr[2]:
            ans += klr[1]
            R.append((N-1-klr[0]-1, klr[2]-klr[1]))
        else: 
            ans += klr[1]
    L.sort(key=lambda kp: kp[0])
    R.sort(key=lambda kp: kp[0])
    ans += process(L)
    ans += process(R)
    print(ans)
              
T = int(input())
              
for _ in range(T):
    solve()   
              
              